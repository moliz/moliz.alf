
/*******************************************************************************
 * Copyright 2011, 2012 Data Access Technologies, Inc. (Model Driven Solutions)
 * All rights reserved worldwide. This program and the accompanying materials
 * are made available for use under the terms of the GNU General Public License 
 * (GPL) version 3 that accompanies this distribution and is available at 
 * http://www.gnu.org/licenses/gpl-3.0.html. For alternative licensing terms, 
 * contact Model Driven Solutions.
 *******************************************************************************/

package org.modeldriven.alf.syntax.units.impl.gen;

import org.modeldriven.alf.parser.Parser;
import org.modeldriven.alf.parser.Token;

import org.modeldriven.alf.syntax.*;
import org.modeldriven.alf.syntax.common.*;
import org.modeldriven.alf.syntax.expressions.*;
import org.modeldriven.alf.syntax.statements.*;
import org.modeldriven.alf.syntax.units.*;

import org.modeldriven.alf.uml.Element;
import org.modeldriven.alf.uml.Profile;
import org.modeldriven.alf.uml.Stereotype;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.TreeSet;

/**
 * A model of the common properties of the definition of a namespace in Alf.
 **/

public abstract class NamespaceDefinitionImpl extends
		org.modeldriven.alf.syntax.units.impl.gen.MemberImpl {

	private List<Member> ownedMember = new ArrayList<Member>();
	private UnitDefinition unit = null;
	private Collection<Member> member = null; // DERIVED

	public NamespaceDefinitionImpl(NamespaceDefinition self) {
		super(self);
	}

	public NamespaceDefinition getSelf() {
		return (NamespaceDefinition) this.self;
	}

	public List<Member> getOwnedMember() {
		return this.ownedMember;
	}

	public void setOwnedMember(List<Member> ownedMember) {
		this.ownedMember = ownedMember;
	}

	public void addOwnedMember(Member ownedMember) {
		this.ownedMember.add(ownedMember);
	}

	public UnitDefinition getUnit() {
		return this.unit;
	}

	public void setUnit(UnitDefinition unit) {
		this.unit = unit;
	}

	public Collection<Member> getMember() {
		if (this.member == null) {
			this.setMember(this.deriveMember());
		}
		return this.member;
	}

	public void setMember(Collection<Member> member) {
		this.member = member;
	}

	public void addMember(Member member) {
		this.member.add(member);
	}

	protected Collection<Member> deriveMember() {
		return null; // STUB
	}

	/**
	 * The members of a namespace definition include references to all owned
	 * members. Also, if the namespace definition has a unit with imports, then
	 * the members include imported members with referents to all imported
	 * elements. The imported elements and their visibility are determined as
	 * given in the UML Superstructure. The name of an imported member is the
	 * name of the imported element or its alias, if one has been given for it.
	 * Elements that would be indistinguishable from each other or from an owned
	 * member (as determined by the Member::isDistinguishableFrom operation) are
	 * not imported.
	 **/
	public boolean namespaceDefinitionMemberDerivation() {
		this.getSelf().getMember();
		return true;
	}

	/**
	 * The members of a namespace must be distinguishable as determined by the
	 * Member::isDistinguishableFrom operation.
	 **/
	public boolean namespaceDefinitionMemberDistinguishability() {
		return true;
	}

	/**
	 * Returns true if the annotation is @external.
	 **/
	public Boolean annotationAllowed(StereotypeAnnotation annotation) {
		return false; // STUB
	} // annotationAllowed

} // NamespaceDefinitionImpl
