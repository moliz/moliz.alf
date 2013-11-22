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

import org.modeldriven.alf.syntax.units.Member;
import org.modeldriven.alf.syntax.units.ModelNamespace;
import org.modeldriven.alf.syntax.units.impl.ImportedMemberImpl;

import fUML.Syntax.Classes.Kernel.Class_;
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
		Collection<Member> members = new ArrayList<Member>();

		if (this.contextNamespace != null) {
			boolean resolved = resolveInContextNamespace(members, name,
					classifierOnly);

			if (!resolved)
				resolved = resolveInContext(members, name, classifierOnly);

			if (!resolved)
				resolved = resolveInRootNamespace(members, name, classifierOnly);
		}

		return members;
	}

	private boolean resolveInContextNamespace(Collection<Member> members,
			String name, boolean classifierOnly) { // package
		boolean resolved = false;
		if (this.contextNamespace.namespace != null)
			resolved = members.addAll(resolve(this.contextNamespace.namespace,
					name, classifierOnly, true));

		return resolved;
	}

	private boolean resolveInContext(Collection<Member> members, String name,
			boolean classifierOnly) { // class
		boolean resolved = false;
		resolved = members.addAll(resolve(this.contextNamespace, name,
				classifierOnly, false));
		return resolved;
	}

	private boolean resolveInRootNamespace(Collection<Member> members,
			String name, boolean classifierOnly) { // root namespace
		boolean resolved = false;
		Namespace rootNamespace = getRootNamespace();
		resolved = members.addAll(resolve(rootNamespace, name, classifierOnly,
				true));
		return resolved;
	}

	private Collection<Member> resolve(Namespace namespace, String name,
			boolean classifierOnly, boolean classesAndPackagesOnly) {
		Collection<Member> members = new ArrayList<Member>();
		if (namespace != null) {
			for (NamedElement element : namespace.member) {
				if ((!classifierOnly || element instanceof Classifier)
						&& (!classesAndPackagesOnly
								|| element instanceof Class_ || element instanceof fUML.Syntax.Classes.Kernel.Package)) {
					if (name.equals(element.name))
						members.add(ImportedMemberImpl.makeImportedMember(
								element.name,
								org.modeldriven.alf.fuml.impl.uml.Element
										.wrap(element), this.getNamespace()));
				}
			}
		}
		return members;
	}
	
	private Namespace getRootNamespace() {
		Namespace rootNamespace = this.contextNamespace;		
		while(rootNamespace.namespace != null)
			rootNamespace = rootNamespace.namespace;		
		return rootNamespace;
	}
}
