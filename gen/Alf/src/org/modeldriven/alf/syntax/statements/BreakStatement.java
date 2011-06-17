
/*
 * Copyright 2011 Data Access Technologies, Inc. (Model Driven Solutions)
 *
 * Licensed under the Academic Free License version 3.0 
 * (http://www.opensource.org/licenses/afl-3.0.php) 
 *
 */

package org.modeldriven.alf.syntax.statements;

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

import org.modeldriven.alf.syntax.statements.impl.BreakStatementImpl;

/**
 * A statement that causes the termination of execution of an immediately
 * enclosing block.
 **/

public class BreakStatement extends Statement {

	public BreakStatement() {
		this.impl = new BreakStatementImpl(this);
	}

	public BreakStatementImpl getImpl() {
		return (BreakStatementImpl) this.impl;
	}

	public Statement getTarget() {
		return this.getImpl().getTarget();
	}

	public void setTarget(Statement target) {
		this.getImpl().setTarget(target);
	}

	/**
	 * The target of a break statement is the innermost switch, while, do or for
	 * statement enclosing the break statement.
	 **/
	public boolean breakStatementTargetDerivation() {
		return this.getImpl().breakStatementTargetDerivation();
	}

	/**
	 * The target of a break statement may not have a @parallel annotation.
	 **/
	public boolean breakStatementNonparallelTarget() {
		return this.getImpl().breakStatementNonparallelTarget();
	}

	/**
	 * A break statement may not have any annotations.
	 **/
	public Boolean annotationAllowed(Annotation annotation) {
		return this.getImpl().annotationAllowed(annotation);
	}

	public Collection<ConstraintViolation> checkConstraints() {
		Collection<ConstraintViolation> violations = new ArrayList<ConstraintViolation>();
		this.checkConstraints(violations);
		return violations;
	}

	public void checkConstraints(Collection<ConstraintViolation> violations) {
		super.checkConstraints(violations);
		if (!this.breakStatementTargetDerivation()) {
			violations.add(new ConstraintViolation(
					"breakStatementTargetDerivation", this));
		}
		if (!this.breakStatementNonparallelTarget()) {
			violations.add(new ConstraintViolation(
					"breakStatementNonparallelTarget", this));
		}
	}

	public String toString() {
		return this.toString(false);
	}

	public String toString(boolean includeDerived) {
		return "(" + this.hashCode() + ")"
				+ this.getImpl().toString(includeDerived);
	}

	public String _toString(boolean includeDerived) {
		StringBuffer s = new StringBuffer(super._toString(includeDerived));
		return s.toString();
	}

	public void print() {
		this.print("", false);
	}

	public void print(boolean includeDerived) {
		this.print("", includeDerived);
	}

	public void print(String prefix, boolean includeDerived) {
		super.print(prefix, includeDerived);
		if (includeDerived) {
			Statement target = this.getTarget();
			if (target != null) {
				System.out.println(prefix + " /target:"
						+ target.toString(includeDerived));
			}
		}
	}
} // BreakStatement
