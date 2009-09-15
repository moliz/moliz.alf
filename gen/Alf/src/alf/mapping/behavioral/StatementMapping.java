
/*
 * Copyright 2009 Data Access Technologies, Inc. (Model Driven Solutions)
 *
 * Licensed under the Academic Free License version 3.0 
 * (http://www.opensource.org/licenses/afl-3.0.php) 
 *
 */

package alf.mapping.behavioral;

import alf.nodes.*;
import alf.syntax.SyntaxNode;
import alf.syntax.behavioral.*;
import alf.syntax.expressions.*;
import alf.syntax.namespaces.*;
import alf.syntax.structural.*;

import java.util.ArrayList;

import alf.mapping.namespaces.*;

import fUML.Syntax.Classes.Kernel.*;
import fUML.Syntax.Activities.IntermediateActivities.*;
import fUML.Syntax.Activities.CompleteStructuredActivities.StructuredActivityNode;

public abstract class StatementMapping extends DocumentedNodeMapping {

	private StructuredActivityNode node = null;
	private NamespaceDefinition context = null;

	public void setContext(NamespaceDefinition context) {
		this.context = context;
	} // setContext

	public NamespaceDefinition getContext() {
		return this.context;
	} // getContext

	public void mapTo(StructuredActivityNode node) {
		super.mapTo(node);
	} // mapTo

	public StructuredActivityNode getNode() {
		if (this.node == null) {
			this.node = new StructuredActivityNode();
			this.mapTo(this.node);
		}

		return this.node;
	} // getNode

	public Statement getStatement() {
		return (Statement) this.getSourceNode();
	} // getStatement

	public ArrayList<Element> getModelElements() {
		ArrayList<Element> elements = new ArrayList<Element>();
		elements.add(this.getNode());
		return elements;
	} // getModelElements

} // StatementMapping
