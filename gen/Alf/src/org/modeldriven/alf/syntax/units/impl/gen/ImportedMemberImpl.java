
/*
 * Copyright 2011 Data Access Technologies, Inc. (Model Driven Solutions)
 *
 * Licensed under the Academic Free License version 3.0 
 * (http://www.opensource.org/licenses/afl-3.0.php) 
 *
 */

package org.modeldriven.alf.syntax.units.impl.gen;

import org.modeldriven.alf.syntax.*;
import org.modeldriven.alf.syntax.common.*;
import org.modeldriven.alf.syntax.expressions.*;
import org.modeldriven.alf.syntax.statements.*;
import org.modeldriven.alf.syntax.units.*;

import org.omg.uml.*;

import java.util.ArrayList;

public class ImportedMemberImpl extends
		org.modeldriven.alf.syntax.units.impl.gen.MemberImpl {

	public ImportedMemberImpl(ImportedMember self) {
		super(self);
	}

	public org.modeldriven.alf.syntax.units.ImportedMember getSelf() {
		return (ImportedMember) this.self;
	}

	/**
	 * An imported element is not a stub.
	 **/
	public boolean importedMemberNotStub() {
		return true;
	}

	/**
	 * An imported element is a feature if its referent is a feature.
	 **/
	public boolean importedMemberIsFeatureDerivation() {
		this.getSelf().getIsFeature();
		return true;
	}

	/**
	 * Returns false. (Imported members do not have annotations.)
	 **/
	public Boolean annotationAllowed(StereotypeAnnotation annotation) {
		return false; // STUB
	} // annotationAllowed

	/**
	 * If the given member is not an imported member, then return the result of
	 * checking whether the given member is distinguishable from this member.
	 * Else, if the element of the referent for this member is an Alf member,
	 * then return the result of checking whether that element is
	 * distinguishable from the given member. Else, if the element of the
	 * referent for the given member is an Alf member, then return the result of
	 * checking whether that element is distinguishable from this member. Else,
	 * the referents for both this and the given member are UML elements, so
	 * return the result of checking their distinguishability according to the
	 * rules of the UML superstructure.
	 **/
	public Boolean isSameKindAs(Member member) {
		return false; // STUB
	} // isSameKindAs

} // ImportedMemberImpl