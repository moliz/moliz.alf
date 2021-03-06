
/*******************************************************************************
 * Copyright 2011, 2012 Data Access Technologies, Inc. (Model Driven Solutions)
 * All rights reserved worldwide. This program and the accompanying materials
 * are made available for use under the terms of the GNU General Public License 
 * (GPL) version 3 that accompanies this distribution and is available at 
 * http://www.gnu.org/licenses/gpl-3.0.html. For alternative licensing terms, 
 * contact Model Driven Solutions.
 *******************************************************************************/

package org.modeldriven.alf.fuml.mapping.expressions;

import org.modeldriven.alf.fuml.mapping.common.SyntaxElementMapping;

import org.modeldriven.alf.syntax.expressions.NameBinding;

import org.modeldriven.alf.uml.Element;

import java.util.ArrayList;
import java.util.List;

public class NameBindingMapping extends SyntaxElementMapping {

	public NameBindingMapping() {
		this.setErrorMessage("No mapping for NameBindingMapping.");
	}

	public List<Element> getModelElements() {
		return new ArrayList<Element>();
	}

	public NameBinding getNameBinding() {
		return (NameBinding) this.getSource();
	}

} // NameBindingMapping
