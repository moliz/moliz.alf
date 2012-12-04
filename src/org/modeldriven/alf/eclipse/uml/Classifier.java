package org.modeldriven.alf.eclipse.uml;

import java.util.List;
import java.util.ArrayList;

public class Classifier extends Type implements
		org.modeldriven.alf.uml.Classifier {

	public Classifier(org.eclipse.uml2.uml.Classifier base) {
		super(base);
	}

	public org.eclipse.uml2.uml.Classifier getBase() {
		return (org.eclipse.uml2.uml.Classifier) this.base;
	}

	public boolean getIsAbstract() {
		return this.getBase().getIsAbstract();
	}

	public void setIsAbstract(boolean isAbstract) {
		this.getBase().setIsAbstract(isAbstract);
	}

	public List< org.modeldriven.alf.uml.Generalization> getGeneralization
() {
		List< org.modeldriven.alf.uml.Generalization> list = new ArrayList< org.modeldriven.alf.uml.Generalization>();
		for (org.eclipse.uml2.uml.Generalization
 element: this.getBase().getGeneralization
s()) {
			list.add( new Generalization(element)
);
		}
		return list;
	}

	public void addGeneralization
( org.modeldriven.alf.uml.Generalization generalization) {
		this.getBase().getGeneralization
s.add( generalization == null? null: ((Generalization)generalization).getBase()
);
	}

	public List< org.modeldriven.alf.uml.Feature> getFeature
() {
		List< org.modeldriven.alf.uml.Feature> list = new ArrayList< org.modeldriven.alf.uml.Feature>();
		for (org.eclipse.uml2.uml.Feature
 element: this.getBase().getFeature
s()) {
			list.add( new Feature(element)
);
		}
		return list;
	}

	public List< org.modeldriven.alf.uml.NamedElement> getInheritedMember
() {
		List< org.modeldriven.alf.uml.NamedElement> list = new ArrayList< org.modeldriven.alf.uml.NamedElement>();
		for (org.eclipse.uml2.uml.NamedElement
 element: this.getBase().getInheritedMember
s()) {
			list.add( new NamedElement(element)
);
		}
		return list;
	}

	public List< org.modeldriven.alf.uml.Property> getAttribute
() {
		List< org.modeldriven.alf.uml.Property> list = new ArrayList< org.modeldriven.alf.uml.Property>();
		for (org.eclipse.uml2.uml.Property
 element: this.getBase().getAttribute
s()) {
			list.add( new Property(element)
);
		}
		return list;
	}

	public List< org.modeldriven.alf.uml.Classifier> getGeneral
() {
		List< org.modeldriven.alf.uml.Classifier> list = new ArrayList< org.modeldriven.alf.uml.Classifier>();
		for (org.eclipse.uml2.uml.Classifier
 element: this.getBase().getGeneral
s()) {
			list.add( new Classifier(element)
);
		}
		return list;
	}

	public boolean getIsFinalSpecialization() {
		return this.getBase().getIsFinalSpecialization();
	}

	public void setIsFinalSpecialization(boolean isFinalSpecialization) {
		this.getBase().setIsFinalSpecialization(isFinalSpecialization);
	}

	public List< org.modeldriven.alf.uml.NamedElement> getMember
() {
		List< org.modeldriven.alf.uml.NamedElement> list = new ArrayList< org.modeldriven.alf.uml.NamedElement>();
		for (org.eclipse.uml2.uml.NamedElement
 element: this.getBase().getMember
s()) {
			list.add( new NamedElement(element)
);
		}
		return list;
	}

	public List< org.modeldriven.alf.uml.NamedElement> getOwnedMember
() {
		List< org.modeldriven.alf.uml.NamedElement> list = new ArrayList< org.modeldriven.alf.uml.NamedElement>();
		for (org.eclipse.uml2.uml.NamedElement
 element: this.getBase().getOwnedMember
s()) {
			list.add( new NamedElement(element)
);
		}
		return list;
	}

	public List< org.modeldriven.alf.uml.ElementImport> getElementImport
() {
		List< org.modeldriven.alf.uml.ElementImport> list = new ArrayList< org.modeldriven.alf.uml.ElementImport>();
		for (org.eclipse.uml2.uml.ElementImport
 element: this.getBase().getElementImport
s()) {
			list.add( new ElementImport(element)
);
		}
		return list;
	}

	public void addElementImport
( org.modeldriven.alf.uml.ElementImport elementImport) {
		this.getBase().getElementImport
s.add( elementImport == null? null: ((ElementImport)elementImport).getBase()
);
	}

	public List< org.modeldriven.alf.uml.PackageImport> getPackageImport
() {
		List< org.modeldriven.alf.uml.PackageImport> list = new ArrayList< org.modeldriven.alf.uml.PackageImport>();
		for (org.eclipse.uml2.uml.PackageImport
 element: this.getBase().getPackageImport
s()) {
			list.add( new PackageImport(element)
);
		}
		return list;
	}

	public void addPackageImport
( org.modeldriven.alf.uml.PackageImport packageImport) {
		this.getBase().getPackageImport
s.add( packageImport == null? null: ((PackageImport)packageImport).getBase()
);
	}

	public List< org.modeldriven.alf.uml.PackageableElement> getImportedMember
() {
		List< org.modeldriven.alf.uml.PackageableElement> list = new ArrayList< org.modeldriven.alf.uml.PackageableElement>();
		for (org.eclipse.uml2.uml.PackageableElement
 element: this.getBase().getImportedMember
s()) {
			list.add( new PackageableElement(element)
);
		}
		return list;
	}

}
