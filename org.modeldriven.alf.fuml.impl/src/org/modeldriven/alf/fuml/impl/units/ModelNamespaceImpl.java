/*******************************************************************************
 * Copyright 2013 Ivar Jacobson International SA
 * All rights reserved worldwide. This program and the accompanying materials
 * are made available for use under the terms of the GNU General Public License
 * (GPL) version 3 that accompanies this distribution and is available at     
 * http://www.gnu.org/licenses/gpl-3.0.html.
 *******************************************************************************/
package org.modeldriven.alf.fuml.impl.units;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;

import org.modeldriven.alf.syntax.common.ElementReference;
import org.modeldriven.alf.syntax.expressions.QualifiedName;
import org.modeldriven.alf.syntax.units.Member;
import org.modeldriven.alf.syntax.units.MissingUnit;
import org.modeldriven.alf.syntax.units.ModelNamespace;
import org.modeldriven.alf.syntax.units.RootNamespace;
import org.modeldriven.alf.syntax.units.UnitDefinition;
import org.modeldriven.alf.syntax.units.impl.ImportedMemberImpl;
import org.modeldriven.alf.syntax.units.impl.PackageDefinitionImpl;

import fUML.Syntax.Classes.Kernel.Classifier;
import fUML.Syntax.Classes.Kernel.Element;
import fUML.Syntax.Classes.Kernel.NamedElement;
import fUML.Syntax.Classes.Kernel.Namespace;

public class ModelNamespaceImpl extends
		org.modeldriven.alf.fuml.units.ModelNamespaceImpl {

	private Namespace contextNamespace = null;

	public ModelNamespaceImpl(ModelNamespace self) {
		super(self);
	}

	public void setContext(Element contextElement) {
		this.contextNamespace = !(contextElement instanceof NamedElement) ? null
				: ((NamedElement) contextElement).namespace;
		if (this.contextNamespace != null) {
			this.setExactName(contextNamespace.name);
		}
	}

	@Override
	public Collection<Member> resolve(String name, boolean classifierOnly) {
		System.out.println("[resolve] Model scope name=" + name);
		Collection<Member> members = new ArrayList<Member>();
		if (this.contextNamespace != null) {
			// TODO: Handle resolution in enclosing namespaces.
			for (NamedElement element : this.contextNamespace.member) {
				if (!classifierOnly || element instanceof Classifier) {
					if (name.equals(element.name))
						members.add(ImportedMemberImpl.makeImportedMember(
								element.name,
								org.modeldriven.alf.fuml.impl.uml.Element
										.wrap(element), this.getNamespace()));
				}
			}
		}

		if (members.isEmpty()) {
			// TODO is here really the right place?
			//members.addAll(resolveImportedMembers(name, classifierOnly));
		}

		return members;
	}

	private Collection<? extends Member> resolveImportedMembers(String name,
			boolean classifierOnly) {
		Collection<ElementReference> references = new HashSet<ElementReference>();

		if (name.equals("CollectionClasses")) {
			references.addAll(RootNamespace.getCollectionClasses()
					.getReferent());
		} else if (name.equals("CollectionFunctions")) {
			references.addAll(RootNamespace.getCollectionFunctions()
					.getReferent());
		} else if (name.equals("ListFunctions")) {
			references.addAll(RootNamespace.getListFunctions().getReferent());
		} else if (name.equals("SequenceFunctions")) {
			references.addAll(RootNamespace.getSequenceFunctions()
					.getReferent());
		} else if (name.equals("IntegerFunctions")) {
			references
					.addAll(RootNamespace.getIntegerFunctions().getReferent());
		} else if (name.equals("BooleanFunctions")) {
			references
					.addAll(RootNamespace.getBooleanFunctions().getReferent());
		} else if (name.equals("StringFunctions")) {
			references.addAll(RootNamespace.getStringFunctions().getReferent());
		} else if (name.equals("UnlimitedNaturalFunctions")) {
			references.addAll(RootNamespace.getUnlimitedNaturalFunctions()
					.getReferent());
		} else if (name.equals("ListFunctions")) {
			references.addAll(RootNamespace.getListFunctions().getReferent());
		}
		// TODO What about real functions: they are missing in rootnamespace

		// TODO somehow add all sequence and collection functions
//		if (name.equals("add")) {
//			references.addAll(RootNamespace.getCollectionFunctionAdd()
//					.getImpl().getQualifiedName().getReferent());
//		}

		Collection<Member> members = new ArrayList<Member>();
		for (ElementReference reference : references) {
			members.add(ImportedMemberImpl.makeImportedMember(reference));
		}

		return members;
	}

}
