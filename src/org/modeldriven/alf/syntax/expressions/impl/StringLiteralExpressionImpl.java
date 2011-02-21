
/*
 * Copyright 2011 Data Access Technologies, Inc. (Model Driven Solutions)
 *
 * Licensed under the Academic Free License version 3.0 
 * (http://www.opensource.org/licenses/afl-3.0.php) 
 *
 */

package org.modeldriven.alf.syntax.expressions.impl;

import org.modeldriven.alf.syntax.*;
import org.modeldriven.alf.syntax.common.*;
import org.modeldriven.alf.syntax.expressions.*;
import org.modeldriven.alf.syntax.statements.*;
import org.modeldriven.alf.syntax.units.*;

import java.util.ArrayList;

/**
 * An expression that comprises a String literal.
 **/

public class StringLiteralExpressionImpl extends
		org.modeldriven.alf.syntax.expressions.impl.LiteralExpressionImpl {

	public StringLiteralExpressionImpl(StringLiteralExpression self) {
		super(self);
	}

	public org.modeldriven.alf.syntax.expressions.StringLiteralExpression getSelf() {
		return (StringLiteralExpression) this.self;
	}

	/**
	 * The type of a string literal expression is String.
	 **/
	public boolean stringLiteralExpressionTypeDerivation() {
		this.getSelf().getType();
		return true;
	}

} // StringLiteralExpressionImpl