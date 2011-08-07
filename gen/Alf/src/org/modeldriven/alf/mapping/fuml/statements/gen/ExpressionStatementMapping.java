
/*
 * Copyright 2011 Data Access Technologies, Inc. (Model Driven Solutions)
 *
 * Licensed under the Academic Free License version 3.0 
 * (http://www.opensource.org/licenses/afl-3.0.php) 
 *
 */

package org.modeldriven.alf.mapping.fuml.statements.gen;

import org.modeldriven.alf.mapping.fuml.statements.gen.StatementMapping;

import org.modeldriven.alf.syntax.statements.ExpressionStatement;

import fUML.Syntax.Classes.Kernel.Element;

import java.util.ArrayList;
import java.util.List;

public class ExpressionStatementMapping extends StatementMapping {

	public ExpressionStatementMapping() {
		this.setErrorMessage("ExpressionStatementMapping not yet implemented.");
	}

	public List<Element> getModelElements() {
		// TODO: Auto-generated stub
		return new ArrayList<Element>();
	}

	public ExpressionStatement getExpressionStatement() {
		return (ExpressionStatement) this.getSource();
	}

} // ExpressionStatementMapping