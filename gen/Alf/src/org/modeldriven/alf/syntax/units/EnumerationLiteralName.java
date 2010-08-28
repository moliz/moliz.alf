
/*
 * Copyright 2010 Data Access Technologies, Inc. (Model Driven Solutions)
 *
 * Licensed under the Academic Free License version 3.0 
 * (http://www.opensource.org/licenses/afl-3.0.php) 
 *
 */

package org.modeldriven.alf.syntax.units;

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

public class EnumerationLiteralName extends Member {

	public boolean annotationAllowed(StereotypeAnnotation annotation) {
		/*
		 * Returns false. (Enumeration literal name cannot have annotations.)
		 */
		return false; // STUB
	} // annotationAllowed

	public boolean isSameKindAs(Member member) {
		/*
		 * Return true if the given member is an EnumerationLiteralName.
		 */
		return false; // STUB
	} // isSameKindAs

	public String toString() {
		StringBuffer s = new StringBuffer(super.toString());
		return s.toString();
	}

	public void print(String prefix) {
		super.print(prefix);
	}
} // EnumerationLiteralName
