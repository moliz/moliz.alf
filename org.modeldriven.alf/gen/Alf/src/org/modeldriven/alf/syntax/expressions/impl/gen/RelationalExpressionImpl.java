
/*******************************************************************************
 * Copyright 2011, 2012 Data Access Technologies, Inc. (Model Driven Solutions)
 * All rights reserved worldwide. This program and the accompanying materials
 * are made available for use under the terms of the GNU General Public License 
 * (GPL) version 3 that accompanies this distribution and is available at 
 * http://www.gnu.org/licenses/gpl-3.0.html. For alternative licensing terms, 
 * contact Model Driven Solutions.
 *******************************************************************************/

package org.modeldriven.alf.syntax.expressions.impl.gen;

import org.modeldriven.alf.parser.Parser;
import org.modeldriven.alf.parser.Token;

import org.modeldriven.alf.syntax.*;
import org.modeldriven.alf.syntax.common.*;
import org.modeldriven.alf.syntax.expressions.*;
import org.modeldriven.alf.syntax.statements.*;
import org.modeldriven.alf.syntax.units.*;

import org.modeldriven.alf.uml.Element;
import org.modeldriven.alf.uml.Profile;
import org.modeldriven.alf.uml.Stereotype;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.TreeSet;

/**
 * A binary expression with a relational operator.
 **/

public class RelationalExpressionImpl extends
		org.modeldriven.alf.syntax.expressions.impl.gen.BinaryExpressionImpl {

	private Boolean isUnlimitedNatural = null; // DERIVED

	public RelationalExpressionImpl(RelationalExpression self) {
		super(self);
	}

	public RelationalExpression getSelf() {
		return (RelationalExpression) this.self;
	}

	public Boolean getIsUnlimitedNatural() {
		if (this.isUnlimitedNatural == null) {
			this.setIsUnlimitedNatural(this.deriveIsUnlimitedNatural());
		}
		return this.isUnlimitedNatural;
	}

	public void setIsUnlimitedNatural(Boolean isUnlimitedNatural) {
		this.isUnlimitedNatural = isUnlimitedNatural;
	}

	protected Boolean deriveIsUnlimitedNatural() {
		return null; // STUB
	}

	/**
	 * A relational expression is an UnlimitedNatural comparison if either one
	 * of its operands has type UnlimitedNatural.
	 **/
	public boolean relationalExpressionIsUnlimitedNaturalDerivation() {
		this.getSelf().getIsUnlimitedNatural();
		return true;
	}

	/**
	 * The type of a relational expression is Boolean.
	 **/
	public boolean relationalExpressionTypeDerivation() {
		this.getSelf().getType();
		return true;
	}

	/**
	 * A relational expression has a multiplicity lower bound of 0 if the lower
	 * bound if either operand expression is 0 and 1 otherwise.
	 **/
	public boolean relationalExpressionLowerDerivation() {
		this.getSelf().getLower();
		return true;
	}

	/**
	 * A relational expression has a multiplicity upper bound of 1.
	 **/
	public boolean relationalExpressionUpperDerivation() {
		this.getSelf().getUpper();
		return true;
	}

	/**
	 * The operand expressions for a comparison operator must have type Integer,
	 * UnlimitedNatural or Natural. However, it is not allowed to have one
	 * operand expression be Integer and the other be UnlimitedNatural.
	 **/
	public boolean relationalExpressionOperandTypes() {
		return true;
	}

} // RelationalExpressionImpl
