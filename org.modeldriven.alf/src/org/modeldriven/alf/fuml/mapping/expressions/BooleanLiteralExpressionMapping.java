
/*******************************************************************************
 * Copyright 2011, 2012 Data Access Technologies, Inc. (Model Driven Solutions)
 * All rights reserved worldwide. This program and the accompanying materials
 * are made available for use under the terms of the GNU General Public License 
 * (GPL) version 3 that accompanies this distribution and is available at 
 * http://www.gnu.org/licenses/gpl-3.0.html. For alternative licensing terms, 
 * contact Model Driven Solutions.
 *******************************************************************************/

package org.modeldriven.alf.fuml.mapping.expressions;

import org.modeldriven.alf.fuml.mapping.expressions.LiteralExpressionMapping;
import org.modeldriven.alf.mapping.MappingError;

import org.modeldriven.alf.syntax.expressions.BooleanLiteralExpression;

import org.modeldriven.alf.uml.ValueSpecificationAction;
import org.modeldriven.alf.uml.LiteralBoolean;

public class BooleanLiteralExpressionMapping extends LiteralExpressionMapping {

    @Override
    public ValueSpecificationAction mapValueSpecificationAction() throws MappingError {
        String image = this.getBooleanLiteralExpression().getImage();        
        return this.graph.addBooleanValueSpecificationAction(image.equals("true"));
    }

	public BooleanLiteralExpression getBooleanLiteralExpression() {
		return (BooleanLiteralExpression) this.getSource();
	}

    @Override
    public String toString() {
        ValueSpecificationAction action = 
            (ValueSpecificationAction)this.getElement();
        return super.toString() + (action == null? "": " value:" + 
                ((LiteralBoolean)action.getValue()).getValue());
    }

} // BooleanLiteralExpressionMapping
