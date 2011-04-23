
/*
 * Copyright 2011 Data Access Technologies, Inc. (Model Driven Solutions)
 *
 * Licensed under the Academic Free License version 3.0 
 * (http://www.opensource.org/licenses/afl-3.0.php) 
 *
 */

package org.modeldriven.alf.syntax.units.impl;

import org.modeldriven.alf.syntax.common.*;
import org.modeldriven.alf.syntax.common.impl.DocumentedElementImpl;
import org.modeldriven.alf.syntax.expressions.*;
import org.modeldriven.alf.syntax.units.*;
import org.omg.uml.Profile;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 * The definition of a namespace as an Alf unit.
 **/

public class UnitDefinitionImpl extends DocumentedElementImpl {
    
	private QualifiedName namespaceName = null;
	private NamespaceDefinition definition = null;
	private Collection<ImportReference> import_ = new ArrayList<ImportReference>();
	private ElementReference namespace = null; // DERIVED
	private Boolean isModelLibrary = null; // DERIVED
	private Collection<Profile> appliedProfile = null; // DERIVED

    private boolean hasImplicitImports = false;

	public UnitDefinitionImpl(UnitDefinition self) {
		super(self);
	}

	@Override
	public UnitDefinition getSelf() {
		return (UnitDefinition) this.self;
	}

	public QualifiedName getNamespaceName() {
		return this.namespaceName;
	}

	public void setNamespaceName(QualifiedName namespaceName) {
		this.namespaceName = namespaceName;
	}

	public NamespaceDefinition getDefinition() {
		return this.definition;
	}

	public void setDefinition(NamespaceDefinition definition) {
		this.definition = definition;
	}

	public Collection<ImportReference> getImport() {
		return this.import_;
	}

	public void setImport(Collection<ImportReference> import_) {
		this.import_ = import_;
	}

	public void addImport(ImportReference import_) {
		this.import_.add(import_);
	}

	public ElementReference getNamespace() {
		if (this.namespace == null) {
			this.setNamespace(this.deriveNamespace());
		}
		return this.namespace;
	}

	public void setNamespace(ElementReference namespace) {
		this.namespace = namespace;
	}

	public Boolean getIsModelLibrary() {
		if (this.isModelLibrary == null) {
			this.setIsModelLibrary(this.deriveIsModelLibrary());
		}
		return this.isModelLibrary;
	}

	public void setIsModelLibrary(Boolean isModelLibrary) {
		this.isModelLibrary = isModelLibrary;
	}

	public Collection<Profile> getAppliedProfile() {
		if (this.appliedProfile == null) {
			this.setAppliedProfile(this.deriveAppliedProfile());
		}
		return this.appliedProfile;
	}

	public void setAppliedProfile(Collection<Profile> appliedProfile) {
		this.appliedProfile = appliedProfile;
	}

	public void addAppliedProfile(Profile appliedProfile) {
		this.appliedProfile.add(appliedProfile);
	}

    public boolean hasImplicitImports() {
        return hasImplicitImports;
    }

    public void setHasImplicitImports(boolean hasImplicitImports) {
        this.hasImplicitImports = hasImplicitImports;
    }

    /**
     * If a unit definition has a declared namespace name, then the containing
     * namespace for the unit is the referent for that name.
     **/
	protected ElementReference deriveNamespace() {
	    UnitDefinition self = this.getSelf();
	    ElementReference referent = null;
	    QualifiedName namespaceName = self.getNamespaceName();
	    if (namespaceName != null) {
            namespaceName.getImpl().setCurrentScope(RootNamespace.getRootScope());
	        referent = namespaceName.getImpl().getNamespaceReferent();
	    }
		return referent;
	}

    /**
     * A unit definition is for a model library if its associated namespace
     * definition has a stereotype annotation for the UML standard stereotype
     * ModelLibrary.
     **/
	protected Boolean deriveIsModelLibrary() {
	    // TODO: Require reference to standard UML ModelLibary stereotype.
	    NamespaceDefinition definition = this.getSelf().getDefinition();
		return definition != null && definition.getImpl().hasAnnotation("ModelLibrary");
	}

    /**
     * The profiles applied to a unit definition include any profiles applied to
     * the containing namespace of the unit definition. If the unit definition
     * is for a package, then the applied profiles for the unit definition also
     * include the applied profiles for its associated package definition.
     **/
	protected Collection<Profile> deriveAppliedProfile() {
	    // TODO: Implement profile application.
		return new ArrayList<Profile>(); // STUB
	}
	
	/*
	 * Derivations
	 */

	public boolean unitDefinitionNamespaceDerivation() {
		this.getSelf().getNamespace();
		return true;
	}

	public boolean unitDefinitionIsModelLibraryDerivation() {
		this.getSelf().getIsModelLibrary();
		return true;
	}

    public boolean unitDefinitionAppliedProfileDerivation() {
        this.getSelf().getAppliedProfile();
        return true;
    }

    /**
     * The declared namespace name for a unit definition, if any, must resolve
     * to a UML namespace or an Alf unit definition. If it is an Alf unit
     * definition, then it must have a stub for this unit definition.
     **/
    public boolean unitDefinitionNamespace() {
        UnitDefinition self = this.getSelf();
        ElementReference namespace = self.getNamespace();
        if (namespace == null) {
            return true;
        } else if (!namespace.getImpl().isNamespace()) {
            return false;
        } else {
            NamespaceDefinition alfNamespace = (NamespaceDefinition)namespace.getImpl().getAlf();
            return alfNamespace == null || alfNamespace.getImpl().hasSubunitFor(self);
        }
    }

	/**
	 * Unless the unit definition is a model library, it has private package
	 * import references for all the sub-packages of the Alf::Library package.
	 **/
	public boolean unitDefinitionImplicitImports() {
		return this.getSelf().getIsModelLibrary() || this.hasImplicitImports();
	}
    
    /*
     * Helper Methods
     */

    @SuppressWarnings("unchecked")
    public List<Member> getImportedMembers() {
        UnitDefinition self = this.getSelf();
        ArrayList<Member> importedMembers = new ArrayList<Member>();
        for (ImportReference importReference: self.getImport()) {
            importedMembers.addAll(importReference.getImpl().getImportedMembers());
        }
        
        // Remove conflicts
        NamespaceDefinition definition = self.getDefinition();
        if (definition != null) {
            Collection<Member> ownedMembers = definition.getOwnedMember();
            ArrayList<Member> otherMembers = (ArrayList<Member>)importedMembers.clone();
            int i = 0;
            while (otherMembers.size() > 0) {
              Member member = otherMembers.remove(0);
              if (member.getImpl().isDistinguishableFromAll(otherMembers) &&
                member.getImpl().isDistinguishableFromAll(ownedMembers)) {
                i++;
              } else {
                importedMembers.remove(i);
              }
            }
        }
        
        return importedMembers;
    }
    
    public boolean isInModelLibrary() {
        UnitDefinition self = this.getSelf();
        if (self.getIsModelLibrary()) {
            return true;
        } else {
            ElementReference namespaceReference = self.getNamespace();
            if (namespaceReference == null) {
                return false;
            } else {
                NamespaceDefinition namespace = 
                    (NamespaceDefinition)namespaceReference.getImpl().getAlf();
                UnitDefinition unit = namespace == null? null: namespace.getUnit();
                return unit != null && unit.getImpl().isInModelLibrary();
            }
        }
    }
    
    public void addImplicitImports() {
        if (!this.hasImplicitImports() && !this.isInModelLibrary()) {
            UnitDefinition self = this.getSelf();

            PackageImportReference primitiveTypesImport = new PackageImportReference();
            primitiveTypesImport.setReferentName(RootNamespace.getPrimitiveTypes());
            primitiveTypesImport.setVisibility("private");
            primitiveTypesImport.setUnit(self);
            this.addImplicitImport(primitiveTypesImport);
            
            PackageImportReference primitiveBehaviorsImport = new PackageImportReference();
            primitiveBehaviorsImport.setReferentName(RootNamespace.getPrimitiveBehaviors());
            primitiveBehaviorsImport.setVisibility("private");
            primitiveBehaviorsImport.setUnit(self);
            this.addImplicitImport(primitiveBehaviorsImport);
    
            PackageImportReference basicInputOutputImport = new PackageImportReference();
            basicInputOutputImport.setReferentName(RootNamespace.getBasicInputOutput());
            basicInputOutputImport.setVisibility("private");
            basicInputOutputImport.setUnit(self);
            this.addImplicitImport(basicInputOutputImport);
    
            this.setHasImplicitImports(true);
        }
    }
    
    public void addImplicitImport(ImportReference importReference) {
        UnitDefinition self = this.getSelf();
        if (!self.getImport().contains(importReference)) {
            self.addImport(importReference);
        }
    }

} // UnitDefinitionImpl
