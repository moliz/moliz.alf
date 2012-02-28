
/*
 * Copyright 2011 Data Access Technologies, Inc. (Model Driven Solutions)
 *
 * Licensed under the Academic Free License version 3.0 
 * (http://www.opensource.org/licenses/afl-3.0.php) 
 *
 */

package org.modeldriven.alf.mapping.fuml.expressions;

import org.modeldriven.alf.mapping.fuml.common.gen.SyntaxElementMapping;

import org.modeldriven.alf.syntax.expressions.NamedExpression;

import fUML.Syntax.Classes.Kernel.Element;

import java.util.ArrayList;
import java.util.List;

public class NamedExpressionMapping extends SyntaxElementMapping {

	public NamedExpressionMapping() {
		this.setErrorMessage("No mapping for NamedExpressionMapping.");
	}

	public List<Element> getModelElements() {
		return new ArrayList<Element>();
	}

	public NamedExpression getNamedExpression() {
		return (NamedExpression) this.getSource();
	}

} // NamedExpressionMapping
