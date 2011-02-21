
/*
 * Copyright 2011 Data Access Technologies, Inc. (Model Driven Solutions)
 *
 * Licensed under the Academic Free License version 3.0 
 * (http://www.opensource.org/licenses/afl-3.0.php) 
 *
 */

package org.modeldriven.alf.syntax.units.impl;

import org.modeldriven.alf.syntax.*;
import org.modeldriven.alf.syntax.common.*;
import org.modeldriven.alf.syntax.expressions.*;
import org.modeldriven.alf.syntax.statements.*;
import org.modeldriven.alf.syntax.units.*;

import java.util.ArrayList;

/**
 * The definition of an enumeration literal, as a member of an enumeration
 * definition.
 **/

public class EnumerationLiteralNameImpl extends
		org.modeldriven.alf.syntax.units.impl.MemberImpl {

	public EnumerationLiteralNameImpl(EnumerationLiteralName self) {
		super(self);
	}

	public org.modeldriven.alf.syntax.units.EnumerationLiteralName getSelf() {
		return (EnumerationLiteralName) this.self;
	}

	/**
	 * Returns false. (Enumeration literal name cannot have annotations.)
	 **/
	public Boolean annotationAllowed(StereotypeAnnotation annotation) {
		return false; // STUB
	} // annotationAllowed

	/**
	 * Return true if the given member is an EnumerationLiteralName.
	 **/
	public Boolean isSameKindAs(Member member) {
		return false; // STUB
	} // isSameKindAs

} // EnumerationLiteralNameImpl