
/*
 * Copyright 2011 Data Access Technologies, Inc. (Model Driven Solutions)
 *
 * Licensed under the Academic Free License version 3.0 
 * (http://www.opensource.org/licenses/afl-3.0.php) 
 *
 */

package org.modeldriven.alf.syntax.expressions.impl.gen;

import org.modeldriven.alf.syntax.*;
import org.modeldriven.alf.syntax.common.*;
import org.modeldriven.alf.syntax.expressions.*;
import org.modeldriven.alf.syntax.statements.*;
import org.modeldriven.alf.syntax.units.*;

import org.omg.uml.*;

import java.util.ArrayList;

/**
 * A template binding in which the arguments are matched to formal template
 * parameters in order by position.
 **/

public class PositionalTemplateBindingImpl extends
		org.modeldriven.alf.syntax.expressions.impl.gen.TemplateBindingImpl {

	public PositionalTemplateBindingImpl(PositionalTemplateBinding self) {
		super(self);
	}

	public org.modeldriven.alf.syntax.expressions.PositionalTemplateBinding getSelf() {
		return (PositionalTemplateBinding) this.self;
	}

} // PositionalTemplateBindingImpl