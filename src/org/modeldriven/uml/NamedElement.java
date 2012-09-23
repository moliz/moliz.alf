package org.modeldriven.uml;

import java.util.List;

public interface NamedElement extends Element {
	public String getName();

	public void setName(String name);

	public String getVisibility();

	public void setVisibility(String visibility);

	public String getQualifiedName();

	public Namespace getNamespace();

    public boolean isDistinguishableFrom(NamedElement otherElement, Namespace namespace);
}
