/*******************************************************************************
 * Copyright 2011, 2012 Data Access Technologies, Inc. (Model Driven Solutions)
 * All rights reserved worldwide. This program and the accompanying materials
 * are made available for use under the terms of the GNU General Public License 
 * (GPL) version 3 that accompanies this distribution and is available at 
 * http://www.gnu.org/licenses/gpl-3.0.html. For alternative licensing terms, 
 * contact Model Driven Solutions.
 *******************************************************************************/
package org.modeldriven.uml.alf.fuml;


public class ReadIsClassifiedObjectAction extends Action implements
		org.modeldriven.alf.uml.ReadIsClassifiedObjectAction {
	public ReadIsClassifiedObjectAction() {
		this(
				new fUML.Syntax.Actions.CompleteActions.ReadIsClassifiedObjectAction());
	}

	public ReadIsClassifiedObjectAction(
			fUML.Syntax.Actions.CompleteActions.ReadIsClassifiedObjectAction base) {
		super(base);
	}

	public fUML.Syntax.Actions.CompleteActions.ReadIsClassifiedObjectAction getBase() {
		return (fUML.Syntax.Actions.CompleteActions.ReadIsClassifiedObjectAction) this.base;
	}

	public boolean getIsDirect() {
		return this.getBase().isDirect;
	}

	public void setIsDirect(boolean isDirect) {
		this.getBase().setIsDirect(isDirect);
	}

	public org.modeldriven.alf.uml.Classifier getClassifier() {
		return (Classifier)this.wrap(this.getBase().classifier);
	}

	public void setClassifier(org.modeldriven.alf.uml.Classifier classifier) {
		this.getBase().setClassifier(((Classifier) classifier).getBase());
	}

	public org.modeldriven.alf.uml.OutputPin getResult() {
		return new OutputPin(this.getBase().result);
	}

	public void setResult(org.modeldriven.alf.uml.OutputPin result) {
		this.getBase().setResult(((OutputPin) result).getBase());
	}

	public org.modeldriven.alf.uml.InputPin getObject() {
		return new InputPin(this.getBase().object);
	}

	public void setObject(org.modeldriven.alf.uml.InputPin object) {
		this.getBase().setObject(((InputPin) object).getBase());
	}

}
