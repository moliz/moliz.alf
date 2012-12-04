package org.modeldriven.alf.eclipse.uml;

import java.util.List;
import java.util.ArrayList;

public class ElementImport extends Element implements
		org.modeldriven.alf.uml.ElementImport {
	public ElementImport() {
		this(UMLFactory.eINSTANCE.createElementImport());
	}

	public ElementImport(fUML.Syntax.Classes.Kernel.ElementImport base) {
		super(base);
	}

	public org.eclipse.uml2.uml.ElementImport getBase() {
		return (org.eclipse.uml2.uml.ElementImport) this.base;
	}

	public String getVisibility() {
		return this.getBase().getVisibility().toString();
	}

	public void setVisibility(String visibility) {
		this.getBase().setVisibility(
				fUML.Syntax.Classes.Kernel.VisibilityKind.valueOf(visibility));
	}

	public String getAlias() {
		return this.getBase().getAlias();
	}

	public void setAlias(String alias) {
		this.getBase().setAlias(alias);
	}

	public org.modeldriven.alf.uml.PackageableElement getImportedElement() {
		return new PackageableElement(this.getBase().getImportedElement());
	}

	public void setImportedElement(
			org.modeldriven.alf.uml.PackageableElement importedElement) {
		this.getBase().setImportedElement(
				importedElement == null ? null
						: ((PackageableElement) importedElement).getBase());
	}

	public org.modeldriven.alf.uml.Namespace getImportingNamespace() {
		return new Namespace(this.getBase().getImportingNamespace());
	}

}
