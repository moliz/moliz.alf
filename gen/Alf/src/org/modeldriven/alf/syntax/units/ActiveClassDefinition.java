
/*
 * Copyright 2011 Data Access Technologies, Inc. (Model Driven Solutions)
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

import org.omg.uml.*;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.modeldriven.alf.syntax.units.impl.ActiveClassDefinitionImpl;

/**
 * The definition of an active class.
 **/

public class ActiveClassDefinition extends ClassDefinition {

	public ActiveClassDefinition() {
		this.impl = new ActiveClassDefinitionImpl(this);
	}

	public ActiveClassDefinitionImpl getImpl() {
		return (ActiveClassDefinitionImpl) this.impl;
	}

	public ActivityDefinition getClassifierBehavior() {
		return this.getImpl().getClassifierBehavior();
	}

	public void setClassifierBehavior(ActivityDefinition classifierBehavior) {
		this.getImpl().setClassifierBehavior(classifierBehavior);
	}

	/**
	 * Returns true if the given unit definition matches this active class
	 * definition considered as a class definition and the subunit is for an
	 * active class definition.
	 **/
	public Boolean matchForStub(UnitDefinition unit) {
		return this.getImpl().matchForStub(unit);
	}

	public Collection<ConstraintViolation> checkConstraints() {
		Collection<ConstraintViolation> violations = new ArrayList<ConstraintViolation>();
		this.checkConstraints(violations);
		return violations;
	}

	public void checkConstraints(Collection<ConstraintViolation> violations) {
		super.checkConstraints(violations);
	}

	public String toString() {
		StringBuffer s = new StringBuffer(super.toString());
		return s.toString();
	}

	public void print() {
		this.print("");
	}

	public void print(String prefix) {
		super.print(prefix);
		ActivityDefinition classifierBehavior = this.getClassifierBehavior();
		if (classifierBehavior != null) {
			System.out.println(prefix + " classifierBehavior:"
					+ classifierBehavior);
		}
	}
} // ActiveClassDefinition
