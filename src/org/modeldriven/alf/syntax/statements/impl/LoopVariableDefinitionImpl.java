
/*
 * Copyright 2011 Data Access Technologies, Inc. (Model Driven Solutions)
 *
 * Licensed under the Academic Free License version 3.0 
 * (http://www.opensource.org/licenses/afl-3.0.php) 
 *
 */

package org.modeldriven.alf.syntax.statements.impl;

import org.modeldriven.alf.syntax.*;
import org.modeldriven.alf.syntax.common.*;
import org.modeldriven.alf.syntax.expressions.*;
import org.modeldriven.alf.syntax.statements.*;
import org.modeldriven.alf.syntax.units.*;

import java.util.ArrayList;

/**
 * The definition of a loop variable in a for statement.
 **/

public class LoopVariableDefinitionImpl extends
		org.modeldriven.alf.syntax.common.impl.SyntaxElementImpl {

	public LoopVariableDefinitionImpl(LoopVariableDefinition self) {
		super(self);
	}

	public org.modeldriven.alf.syntax.statements.LoopVariableDefinition getSelf() {
		return (LoopVariableDefinition) this.self;
	}

	public Boolean deriveIsCollectionConversion() {
		return null; // STUB
	}

	public ElementReference deriveType() {
		return null; // STUB
	}

	public Boolean deriveIsFirst() {
		return null; // STUB
	}

	public ArrayList<AssignedSource> deriveAssignmentBefore() {
		return null; // STUB
	}

	public ArrayList<AssignedSource> deriveAssignmentAfter() {
		return null; // STUB
	}

	/**
	 * The assignments after a loop variable definition include the assignments
	 * after the expression (or expressions) of the definition plus a new
	 * assigned source for the loop variable itself. The assigned source for the
	 * loop variable is the loop variable definition. The multiplicity upper
	 * bound for the variable is 1. The multiplicity lower bound is 1 if the
	 * loop variable definition is the first in a for statement and 0 otherwise.
	 * If collection conversion is not required, then the variable has the
	 * inferred or declared type from the definition. If collection conversion
	 * is required, then the variable has the argument type of the collection
	 * class.
	 **/
	public boolean loopVariableDefinitionAssignmentAfterDerivation() {
		this.getSelf().getAssignmentAfter();
		return true;
	}

	/**
	 * The assignments before the expressions of a loop variable definition are
	 * the assignments before the loop variable definition.
	 **/
	public boolean loopVariableDefinitionAssignmentsBefore() {
		return true;
	}

	/**
	 * If a loop variable definition has two expressions, then both expressions
	 * must have type Integer and a multiplicity upper bound of 1, and no name
	 * may be newly assigned or reassigned in more than one of the expressions.
	 **/
	public boolean loopVariableDefinitionRangeExpressions() {
		return true;
	}

	/**
	 * If a loop variable definition has a type name, then this name must
	 * resolve to a non-template classifier.
	 **/
	public boolean loopVariableDefinitionTypeName() {
		return true;
	}

	/**
	 * If the type of a loop variable is not inferred, then the variable has the
	 * type denoted by the type name, if it is not empty, and is untyped
	 * otherwise. If the type is inferred, them the variable has the same as the
	 * type of the expression in its definition.
	 **/
	public boolean loopVariableDefinitionTypeDerivation() {
		this.getSelf().getType();
		return true;
	}

	/**
	 * If the type of a loop variable definition is not inferred, then the first
	 * expression of the definition must have a type that conforms to the
	 * declared type.
	 **/
	public boolean loopVariableDefinitionDeclaredType() {
		return true;
	}

	/**
	 * Collection conversion is required for a loop variable definition if the
	 * type for the definition is the instantiation of a collection class and
	 * the multiplicity upper bound of the first expression is no greater than
	 * 1.
	 **/
	public boolean loopVariableDefinitionIsCollectionConversionDerivation() {
		this.getSelf().getIsCollectionConversion();
		return true;
	}

	/**
	 * The variable name given in a loop variable definition must be unassigned
	 * after the expression or expressions in the definition.
	 **/
	public boolean loopVariableDefinitionVariable() {
		return true;
	}

} // LoopVariableDefinitionImpl