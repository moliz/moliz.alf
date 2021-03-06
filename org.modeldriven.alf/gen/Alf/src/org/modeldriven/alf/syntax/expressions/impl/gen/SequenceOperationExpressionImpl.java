
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
 * An expression used to invoke a behavior as if it was an operation on a target
 * sequence as a whole.
 **/

public class SequenceOperationExpressionImpl
		extends
		org.modeldriven.alf.syntax.expressions.impl.gen.InvocationExpressionImpl {

	private ExtentOrExpression primary = null;
	private QualifiedName operation = null;
	private Boolean isCollectionConversion = null; // DERIVED
	private Boolean isBitStringConversion = null; // DERIVED
	private LeftHandSide leftHandSide = null; // DERIVED

	public SequenceOperationExpressionImpl(SequenceOperationExpression self) {
		super(self);
	}

	public SequenceOperationExpression getSelf() {
		return (SequenceOperationExpression) this.self;
	}

	public ExtentOrExpression getPrimary() {
		return this.primary;
	}

	public void setPrimary(ExtentOrExpression primary) {
		this.primary = primary;
	}

	public QualifiedName getOperation() {
		return this.operation;
	}

	public void setOperation(QualifiedName operation) {
		this.operation = operation;
	}

	public Boolean getIsCollectionConversion() {
		if (this.isCollectionConversion == null) {
			this.setIsCollectionConversion(this.deriveIsCollectionConversion());
		}
		return this.isCollectionConversion;
	}

	public void setIsCollectionConversion(Boolean isCollectionConversion) {
		this.isCollectionConversion = isCollectionConversion;
	}

	public Boolean getIsBitStringConversion() {
		if (this.isBitStringConversion == null) {
			this.setIsBitStringConversion(this.deriveIsBitStringConversion());
		}
		return this.isBitStringConversion;
	}

	public void setIsBitStringConversion(Boolean isBitStringConversion) {
		this.isBitStringConversion = isBitStringConversion;
	}

	public LeftHandSide getLeftHandSide() {
		if (this.leftHandSide == null) {
			this.setLeftHandSide(this.deriveLeftHandSide());
		}
		return this.leftHandSide;
	}

	public void setLeftHandSide(LeftHandSide leftHandSide) {
		this.leftHandSide = leftHandSide;
	}

	protected Boolean deriveIsCollectionConversion() {
		return null; // STUB
	}

	protected Boolean deriveIsBitStringConversion() {
		return null; // STUB
	}

	protected LeftHandSide deriveLeftHandSide() {
		return null; // STUB
	}

	/**
	 * The referent for a sequence operation expression is the behavior named by
	 * the operation for the expression.
	 **/
	public boolean sequenceOperationExpressionReferentDerivation() {
		this.getSelf().getReferent();
		return true;
	}

	/**
	 * There is no feature for a sequence operation expression.
	 **/
	public boolean sequenceOperationExpressionFeatureDerivation() {
		this.getSelf().getFeature();
		return true;
	}

	/**
	 * There must be a single behavior that is a resolution of the operation
	 * qualified name of a sequence operation expression with a least one
	 * parameter, whose first parameter has direction in or inout, has
	 * multiplicity [0..*] and to which the target primary expression is
	 * assignable.
	 **/
	public boolean sequenceOperationExpressionOperationReferent() {
		return true;
	}

	/**
	 * If the first parameter of the referent has direction inout, then the
	 * parameter type must have the same type as the primary expression, the
	 * primary expression must have the form of a left-hand side and, if the
	 * equivalent left-hand side is for a local name, that name must already
	 * exist.
	 **/
	public boolean sequenceOperationExpressionTargetCompatibility() {
		return true;
	}

	/**
	 * The type of an input argument expression of a sequence operation
	 * parameter must be assignable to its corresponding parameter. The type of
	 * an output parameter must be assignable to its corresponding argument
	 * expression. (Note that this implies that the type of an argument
	 * expression for an inout parameter must be the same as the type of that
	 * parameter.)
	 **/
	public boolean sequenceOperationExpressionArgumentCompatibility() {
		return true;
	}

	/**
	 * The assignments before the primary expression of a sequence operation
	 * expression are the same as the assignments before the sequence operation
	 * expression.
	 **/
	public boolean sequenceOperationExpressionAssignmentsBefore() {
		return true;
	}

	/**
	 * Collection conversion is required if the type of the primary expression
	 * of a sequence operation expression is a collection class and the
	 * multiplicity upper bound of the primary expression is 1.
	 **/
	public boolean sequenceOperationExpressionIsCollectionConversionDerivation() {
		this.getSelf().getIsCollectionConversion();
		return true;
	}

	/**
	 * BitString conversion is required if type of the first parameter of the
	 * referent of a sequence operation expression is BitString and either the
	 * type of its primary expression is Integer or collection conversion is
	 * required and the type of its primary expression is a collection class
	 * whose argument type is Integer.
	 **/
	public boolean sequenceOperationExpressionIsBitStringConversionDerivation() {
		this.getSelf().getIsBitStringConversion();
		return true;
	}

	/**
	 * A local name that is assigned in the primary expression of a sequence
	 * operation expression may not be assigned in any expression in the tuple
	 * of the sequence operation expression.
	 **/
	public boolean sequenceOperationExpressionAssignmentsAfter() {
		return true;
	}

	/**
	 * If the operation of a sequence operation expression has a first parameter
	 * whose direction is inout, then the effective left-hand side for the
	 * expression is constructed as follows: If the primary is a name
	 * expression, then the left-hand side is a name left-hand side with the
	 * name from the name expression as its target. If the primary is a property
	 * access expression, then the left-hand side is a feature left hand side
	 * with the feature reference from the property access expression as its
	 * feature. If the primary is a sequence access expression whose primary is
	 * a name expression or a property access expression, then the left-hand
	 * side is constructed from the primary of the sequence access expression as
	 * given previously and the index of the sequence access expression becomes
	 * the index of the left-hand side.
	 **/
	public boolean sequenceOperationExpressionLeftHandSideDerivation() {
		this.getSelf().getLeftHandSide();
		return true;
	}

	/**
	 * The assignments after a sequence operation expression include those made
	 * in the primary expression and those made in the tuple and, for an
	 * "in place" operation (one whose first parameter is inout), that made by
	 * the sequence operation expression itself.
	 **/
	public Collection<AssignedSource> updateAssignments() {
		return new ArrayList<AssignedSource>(); // STUB
	} // updateAssignments

	/**
	 * Returns the list of parameter elements from the superclass operation,
	 * with the first parameter removed (since the argument for the first
	 * parameter is given by the primary expression of a sequence operation
	 * expression, not in its tuple).
	 **/
	public List<ElementReference> parameterElements() {
		return new ArrayList<ElementReference>(); // STUB
	} // parameterElements

} // SequenceOperationExpressionImpl
