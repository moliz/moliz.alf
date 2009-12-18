
/*
 * Copyright 2009 Data Access Technologies, Inc. (Model Driven Solutions)
 *
 * Licensed under the Academic Free License version 3.0 
 * (http://www.opensource.org/licenses/afl-3.0.php) 
 *
 */

package org.modeldriven.alf.syntax.expressions;

import org.modeldriven.alf.nodes.*;
import org.modeldriven.alf.syntax.*;
import org.modeldriven.alf.syntax.expressions.*;
import org.modeldriven.alf.syntax.statements.*;
import org.modeldriven.alf.syntax.units.*;

import java.util.ArrayList;

public class ExpressionList extends CollectionElements {

	private ArrayList<Expression> list = new ArrayList<Expression>();

	public void add(Expression expression) {
		this.list.add(expression);
	} // add

	public ArrayList<Expression> getList() {
		return this.list;
	} // getList

	public void print(String prefix) {
		super.print(prefix);

		for (Expression expr : this.getList()) {
			expr.printChild(prefix);
		}
	} // print

} // ExpressionList
