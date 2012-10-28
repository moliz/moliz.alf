
/*
 * Copyright 2011 Data Access Technologies, Inc. (Model Driven Solutions)
 *
 * Licensed under the Academic Free License version 3.0 
 * (http://www.opensource.org/licenses/afl-3.0.php) 
 *
 */

package org.modeldriven.alf.fuml.mapping.expressions.gen;

import org.modeldriven.alf.fuml.mapping.common.gen.SyntaxElementMapping;

import org.modeldriven.alf.syntax.expressions.TemplateBinding;

public abstract class TemplateBindingMapping extends SyntaxElementMapping {

	public TemplateBinding getTemplateBinding() {
		return (TemplateBinding) this.getSource();
	}

} // TemplateBindingMapping
