
/*******************************************************************************
 * Copyright 2011, 2012 Data Access Technologies, Inc. (Model Driven Solutions)
 * All rights reserved worldwide. This program and the accompanying materials
 * are made available for use under the terms of the GNU General Public License 
 * (GPL) version 3 that accompanies this distribution and is available at 
 * http://www.gnu.org/licenses/gpl-3.0.html. For alternative licensing terms, 
 * contact Model Driven Solutions.
 *******************************************************************************/

package org.modeldriven.alf.fuml.mapping.expressions;

import org.modeldriven.alf.fuml.mapping.expressions.BinaryExpressionMapping;
import org.modeldriven.alf.mapping.MappingError;

import org.modeldriven.alf.syntax.common.ElementReference;
import org.modeldriven.alf.syntax.expressions.LogicalExpression;
import org.modeldriven.alf.syntax.units.RootNamespace;

import org.modeldriven.alf.uml.ActivityNode;

public class LogicalExpressionMapping extends BinaryExpressionMapping {
    
    @Override
    protected void mapOperator(
            String operator,
            ActivityNode operand1Result, 
            ActivityNode operand2Result) throws MappingError {
        LogicalExpression expression = this.getLogicalExpression();
        if (expression.getIsBitStringConversion1()) {
            operand1Result = this.addBitStringConversion(operand1Result);
        }
        if (expression.getIsBitStringConversion2()) {
            operand2Result = this.addBitStringConversion(operand2Result);
        }
        super.mapOperator(operator, operand1Result, operand2Result);
    }

    @Override
    protected ElementReference getOperatorFunction(String operator) {
        return this.getLogicalExpression().getIsBitWise()?
                RootNamespace.getBitStringFunction(operator):
                RootNamespace.getBooleanFunction(operator);
    }

	public LogicalExpression getLogicalExpression() {
		return (LogicalExpression) this.getSource();
	}

} // LogicalExpressionMapping
