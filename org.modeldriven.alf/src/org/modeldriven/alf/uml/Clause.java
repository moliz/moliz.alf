/*******************************************************************************
 * Copyright 2011, 2012 Data Access Technologies, Inc. (Model Driven Solutions)
 * All rights reserved worldwide. This program and the accompanying materials
 * are made available for use under the terms of the GNU General Public License 
 * (GPL) version 3 that accompanies this distribution and is available at 
 * http://www.gnu.org/licenses/gpl-3.0.html. For alternative licensing terms, 
 * contact Model Driven Solutions.
 *******************************************************************************/
package org.modeldriven.alf.uml;

import java.util.List;

public interface Clause extends Element {
	public List<ExecutableNode> getTest();

	public void addTest(ExecutableNode test);

	public List<ExecutableNode> getBody();

	public void addBody(ExecutableNode body);

	public List<Clause> getPredecessorClause();

	public void addPredecessorClause(Clause predecessorClause);

	public List<Clause> getSuccessorClause();

	public void addSuccessorClause(Clause successorClause);

	public OutputPin getDecider();

	public void setDecider(OutputPin decider);

	public List<OutputPin> getBodyOutput();

	public void addBodyOutput(OutputPin bodyOutput);
}
