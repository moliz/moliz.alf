
/*
 * Copyright 2011 Data Access Technologies, Inc. (Model Driven Solutions)
 *
 * Licensed under the Academic Free License version 3.0 
 * (http://www.opensource.org/licenses/afl-3.0.php) 
 *
 */

package org.modeldriven.alf.syntax.expressions;

import org.modeldriven.alf.syntax.*;
import org.modeldriven.alf.syntax.common.*;
import org.modeldriven.alf.syntax.expressions.*;
import org.modeldriven.alf.syntax.statements.*;
import org.modeldriven.alf.syntax.units.*;

import org.omg.uml.*;

import java.util.ArrayList;

import org.modeldriven.alf.syntax.expressions.impl.UnboundedLiteralExpressionImpl;

/**
 * An expression that comprises an unbounded value literal.
 **/

public class UnboundedLiteralExpression extends LiteralExpression {

	public UnboundedLiteralExpression() {
		this.impl = new UnboundedLiteralExpressionImpl(this);
	}

	public UnboundedLiteralExpressionImpl getImpl() {
		return (UnboundedLiteralExpressionImpl) this.impl;
	}

	/**
	 * The type of an unbounded literal expression is UnlimitedNatural.
	 **/
	public boolean unboundedLiteralExpressionTypeDerivation() {
		return this.getImpl().unboundedLiteralExpressionTypeDerivation();
	}

	public String toString() {
		StringBuffer s = new StringBuffer(super.toString());
		return s.toString();
	}

	public void print(String prefix) {
		super.print(prefix);
	}
} // UnboundedLiteralExpression