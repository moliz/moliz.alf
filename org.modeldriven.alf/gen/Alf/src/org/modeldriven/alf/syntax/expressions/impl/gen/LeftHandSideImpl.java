
/*******************************************************************************
 * Copyright 2011, 2012 Data Access Technologies, Inc. (Model Driven Solutions)
 * All rights reserved worldwide. This program and the accompanying materials
 * are made available for use under the terms of the GNU General Public License 
 * (GPL) version 3 that accompanies this distribution and is available at 
 * http://www.gnu.org/licenses/gpl-3.0.html. For alternative licensing terms, 
 * contact Model Driven Solutions.
 *******************************************************************************/

package org.modeldriven.alf.syntax.expressions.impl.gen;

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
 * The left-hand side of an assignment expression.
 * 
 * NOTE: The derivations for the derived properties of LeftHandSide are specific
 * to its various subclasses.
 **/

public abstract class LeftHandSideImpl extends
		org.modeldriven.alf.syntax.common.impl.gen.SyntaxElementImpl {

	private Collection<AssignedSource> assignmentBefore = null; // DERIVED
	private Collection<AssignedSource> assignmentAfter = null; // DERIVED
	private Expression index = null;
	private ElementReference referent = null; // DERIVED
	private ElementReference type = null; // DERIVED
	private Integer lower = null; // DERIVED
	private Integer upper = null; // DERIVED

	public LeftHandSideImpl(LeftHandSide self) {
		super(self);
	}

	public LeftHandSide getSelf() {
		return (LeftHandSide) this.self;
	}

	public Collection<AssignedSource> getAssignmentBefore() {
		if (this.assignmentBefore == null) {
			this.setAssignmentBefore(this.deriveAssignmentBefore());
		}
		return this.assignmentBefore;
	}

	public void setAssignmentBefore(Collection<AssignedSource> assignmentBefore) {
		this.assignmentBefore = assignmentBefore;
	}

	public void addAssignmentBefore(AssignedSource assignmentBefore) {
		this.assignmentBefore.add(assignmentBefore);
	}

	public Collection<AssignedSource> getAssignmentAfter() {
		if (this.assignmentAfter == null) {
			this.setAssignmentAfter(this.deriveAssignmentAfter());
		}
		return this.assignmentAfter;
	}

	public void setAssignmentAfter(Collection<AssignedSource> assignmentAfter) {
		this.assignmentAfter = assignmentAfter;
	}

	public void addAssignmentAfter(AssignedSource assignmentAfter) {
		this.assignmentAfter.add(assignmentAfter);
	}

	public Expression getIndex() {
		return this.index;
	}

	public void setIndex(Expression index) {
		this.index = index;
	}

	public ElementReference getReferent() {
		if (this.referent == null) {
			this.setReferent(this.deriveReferent());
		}
		return this.referent;
	}

	public void setReferent(ElementReference referent) {
		this.referent = referent;
	}

	public ElementReference getType() {
		if (this.type == null) {
			this.setType(this.deriveType());
		}
		return this.type;
	}

	public void setType(ElementReference type) {
		this.type = type;
	}

	public Integer getLower() {
		if (this.lower == null) {
			this.setLower(this.deriveLower());
		}
		return this.lower;
	}

	public void setLower(Integer lower) {
		this.lower = lower;
	}

	public Integer getUpper() {
		if (this.upper == null) {
			this.setUpper(this.deriveUpper());
		}
		return this.upper;
	}

	public void setUpper(Integer upper) {
		this.upper = upper;
	}

	protected Collection<AssignedSource> deriveAssignmentBefore() {
		return null; // STUB
	}

	protected Collection<AssignedSource> deriveAssignmentAfter() {
		return null; // STUB
	}

	protected ElementReference deriveReferent() {
		return null; // STUB
	}

	protected ElementReference deriveType() {
		return null; // STUB
	}

	protected Integer deriveLower() {
		return null; // STUB
	}

	protected Integer deriveUpper() {
		return null; // STUB
	}

	/**
	 * If a left-hand side has an index, then the index expression must have a
	 * multiplicity upper bound no greater than 1.
	 **/
	public boolean leftHandSideIndexExpression() {
		return true;
	}

} // LeftHandSideImpl
