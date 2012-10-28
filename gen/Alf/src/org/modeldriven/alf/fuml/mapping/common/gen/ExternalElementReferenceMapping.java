
/*
 * Copyright 2011 Data Access Technologies, Inc. (Model Driven Solutions)
 *
 * Licensed under the Academic Free License version 3.0 
 * (http://www.opensource.org/licenses/afl-3.0.php) 
 *
 */

package org.modeldriven.alf.fuml.mapping.common.gen;

import org.modeldriven.alf.fuml.mapping.common.gen.ElementReferenceMapping;

import org.modeldriven.alf.syntax.common.ExternalElementReference;

import org.modeldriven.alf.uml.Element;

import java.util.ArrayList;
import java.util.List;

public class ExternalElementReferenceMapping extends ElementReferenceMapping {

	public ExternalElementReferenceMapping() {
		this
				.setErrorMessage("ExternalElementReferenceMapping not yet implemented.");
	}

	public List<Element> getModelElements() {
		// TODO: Auto-generated stub
		return new ArrayList<Element>();
	}

	public ExternalElementReference getExternalElementReference() {
		return (ExternalElementReference) this.getSource();
	}

} // ExternalElementReferenceMapping
