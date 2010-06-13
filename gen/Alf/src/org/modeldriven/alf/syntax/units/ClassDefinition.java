
/*
 * Copyright 2009 Data Access Technologies, Inc. (Model Driven Solutions)
 *
 * Licensed under the Academic Free License version 3.0 
 * (http://www.opensource.org/licenses/afl-3.0.php) 
 *
 */

package org.modeldriven.alf.syntax.units;

import org.modeldriven.alf.nodes.*;
import org.modeldriven.alf.syntax.*;
import org.modeldriven.alf.syntax.expressions.*;
import org.modeldriven.alf.syntax.statements.*;
import org.modeldriven.alf.syntax.units.*;

import java.util.ArrayList;

public class ClassDefinition extends ClassifierDefinition {

	public boolean isCompletedBy(Member member) {
		return member instanceof ClassDefinition && super.isCompletedBy(member);
	} // isCompletedBy

	public boolean isDistinguishableFrom(Member other,
			NamespaceDefinition namespace) {
		return !(other instanceof ClassDefinition)
				|| super.isDistinguishableFrom(other, namespace);
	} // isDistinguishableFrom

	public boolean canSpecialize(Member member) {
		return member instanceof ClassDefinition
				&& !(member instanceof ActiveClassDefinition);
	} // canSpecialize

} // ClassDefinition
