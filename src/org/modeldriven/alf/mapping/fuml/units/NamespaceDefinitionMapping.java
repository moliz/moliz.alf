
/*
 * Copyright 2011 Data Access Technologies, Inc. (Model Driven Solutions)
 *
 * Licensed under the Academic Free License version 3.0 
 * (http://www.opensource.org/licenses/afl-3.0.php) 
 *
 */

package org.modeldriven.alf.mapping.fuml.units;

import java.util.Collection;

import org.modeldriven.alf.mapping.Mapping;
import org.modeldriven.alf.mapping.MappingError;
import org.modeldriven.alf.mapping.fuml.FumlMapping;
import org.modeldriven.alf.mapping.fuml.units.MemberMapping;

import org.modeldriven.alf.syntax.units.ActivityDefinition;
import org.modeldriven.alf.syntax.units.ClassifierTemplateParameter;
import org.modeldriven.alf.syntax.units.ImportReference;
import org.modeldriven.alf.syntax.units.Member;
import org.modeldriven.alf.syntax.units.NamespaceDefinition;
import org.modeldriven.alf.syntax.units.UnitDefinition;

import fUML.Syntax.Classes.Kernel.Element;
import fUML.Syntax.Classes.Kernel.ElementImport;
import fUML.Syntax.Classes.Kernel.NamedElement;
import fUML.Syntax.Classes.Kernel.Namespace;
import fUML.Syntax.Classes.Kernel.PackageImport;

public abstract class NamespaceDefinitionMapping extends MemberMapping {
    
    // Note: An operation is a namespace in full UML, but not in fUML, 
    // so the "namespace" parameter has the type "NamedElement" to accommodate
    // this.
    public void mapTo(NamedElement namespace) throws MappingError {
        super.mapTo(namespace);
        
        NamespaceDefinition definition = this.getNamespaceDefinition();

        for (Member member: definition.getOwnedMember()) {
            // Note: Ignore classifiers that are not completely bound and 
            // classifier template parameters.
            if (member.getImpl().isCompletelyBound() && 
                    !(member instanceof ClassifierTemplateParameter)) {
                if (member.getIsStub()) {
                    UnitDefinition subunit = member.getSubunit();
                    if (subunit == null) {
                        this.throwError("Cannot resolve subunit.");
                    }
                    member = subunit.getDefinition();
                }
                FumlMapping mapping = this.fumlMap(member);
                for (Element element: mapping.getModelElements()) {
                    this.addMemberTo(element, namespace);
                }
            }
        }
        
        UnitDefinition unit = definition.getUnit();
        if (unit != null) {
            for (ImportReference importReference: unit.getImport()) {
                FumlMapping mapping = this.fumlMap(importReference);
                for (Element element: mapping.getModelElements()) {
                    if (element instanceof ElementImport) {
                        ((Namespace)namespace).addElementImport((ElementImport)element);
                    } else if (element instanceof PackageImport) {                        
                        ((Namespace)namespace).addPackageImport((PackageImport)element);
                    }
                    
                }
            }
        }
        
        /**
         * Map any statements nested in members of the namespace as a
         * second pass, to avoid possible circular mapping due to internal
         * references between members and between members and the namespace
         * itself.
         */
        for (Member member: definition.getOwnedMember()) {
            Mapping mapping = member.getImpl().getMapping();
            if (mapping instanceof MemberMapping) {
                ((MemberMapping)mapping).mapBody();
            }
        }
    }
    
    public abstract void addMemberTo(Element element, NamedElement namespace) 
        throws MappingError;
    
	public NamespaceDefinition getNamespaceDefinition() {
		return (NamespaceDefinition) this.getSource();
	}
	
	@Override
	public void print(String prefix) {
	    super.print(prefix);
	    
	    NamespaceDefinition source = this.getNamespaceDefinition();
	    UnitDefinition unit = source.getUnit();
	    if (unit != null) {
	        Collection<ImportReference> imports = unit.getImport();
	        if (!imports.isEmpty()) {
	            System.out.println(prefix + " import:");
    	        for (ImportReference importReference: imports) {
    	            Mapping mapping = importReference.getImpl().getMapping();
    	            if (mapping != null) {
    	                mapping.printChild(prefix);
    	            }
    	        }
	        }
	    }
	    
	    Collection<Member> ownedMembers = source.getOwnedMember();
	    if (!ownedMembers.isEmpty()) {
	        System.out.println(prefix + " ownedMember:");
    	    for (Member member: ownedMembers) {
    	        if (member.getIsStub()) {
    	            UnitDefinition subunit = member.getSubunit();
    	            if (subunit != null) {
    	                member = member.getSubunit().getDefinition();
    	            }
    	        }
    	        Mapping mapping = member.getImpl().getMapping();
    	        if (mapping != null) {
    	            mapping.printChild(prefix);
    	        }
    	    }
	    }
	}
	
	public static String makeDistinguishableActivityName(
	        NamespaceDefinition namespace,
	        String name) {
	    int i = 1;
	    String distinguishableName;
	    do {
	        distinguishableName = name + "$" + i++;
	    } while (includesActivity(namespace.getImpl().resolve(distinguishableName)));
	    return distinguishableName;
	}
	
	private static boolean includesActivity(Collection<Member> members) {
	    for (Member member: members) {
	        if (member instanceof ActivityDefinition) {
	            return true;
	        }
	    }
	    return false;
	}

} // NamespaceDefinitionMapping
