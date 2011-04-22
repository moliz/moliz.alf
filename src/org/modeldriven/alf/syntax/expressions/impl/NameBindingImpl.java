
/*
 * Copyright 2011 Data Access Technologies, Inc. (Model Driven Solutions)
 *
 * Licensed under the Academic Free License version 3.0 
 * (http://www.opensource.org/licenses/afl-3.0.php) 
 *
 */

package org.modeldriven.alf.syntax.expressions.impl;

import org.modeldriven.alf.syntax.common.impl.SyntaxElementImpl;
import org.modeldriven.alf.syntax.expressions.*;
import org.modeldriven.alf.syntax.units.*;

/**
 * An unqualified name, optionally with a template binding.
 **/

public class NameBindingImpl extends SyntaxElementImpl {

    private TemplateBinding binding = null;
    private String name = "";

	public NameBindingImpl(NameBinding self) {
		super(self);
	}

	@Override
	public NameBinding getSelf() {
		return (NameBinding) this.self;
	}
	
    public TemplateBinding getBinding() {
        return this.binding;
    }

    public void setBinding(TemplateBinding binding) {
        this.binding = binding;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }
    
    /*
     * Helper Methods
     */

    @Override
	public String toString() {
	    NameBinding self = this.getSelf();
	    StringBuffer s = new StringBuffer(self.getName());
	    TemplateBinding b = self.getBinding();
	    if (b!=null) {
	        s.append(b.getImpl());
	    }
	    return s.toString();
	}

    public void setCurrentScope(NamespaceDefinition currentScope) {
        TemplateBinding binding = this.getSelf().getBinding();
        if (binding != null) {
            binding.getImpl().setCurrentScope(currentScope);
        }
    }

} // NameBindingImpl
