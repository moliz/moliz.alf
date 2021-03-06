
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

public class ImportedMemberImpl extends
		org.modeldriven.alf.syntax.units.impl.gen.MemberImpl {

	private ElementReference referent = null;

	public ImportedMemberImpl(ImportedMember self) {
		super(self);
	}

	public ImportedMember getSelf() {
		return (ImportedMember) this.self;
	}

	public ElementReference getReferent() {
		return this.referent;
	}

	public void setReferent(ElementReference referent) {
		this.referent = referent;
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
	 * checking whether the given member is the same kind as this member. Else,
	 * if the element of the referent for this member is an Alf member, then
	 * return the result of checking whether that element is the same kind as
	 * the given member. Else, if the element of the referent for the given
	 * member is an Alf member, then return the result of checking whether that
	 * element is the same kind as this member. Else, the referents for both
	 * this and the given member are UML elements, so return the result of
	 * checking their distinguishability according to the rules of the UML
	 * superstructure.
	 **/
	public Boolean isSameKindAs(Member member) {
		return false; // STUB
	} // isSameKindAs

} // ImportedMemberImpl
