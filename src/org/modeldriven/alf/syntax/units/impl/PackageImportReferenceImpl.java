
/*
 * Copyright 2011 Data Access Technologies, Inc. (Model Driven Solutions)
 *
 * Licensed under the Academic Free License version 3.0 
 * (http://www.opensource.org/licenses/afl-3.0.php) 
 *
 */

package org.modeldriven.alf.syntax.units.impl;

import org.modeldriven.alf.syntax.common.*;
import org.modeldriven.alf.syntax.units.*;
import org.omg.uml.Package;
import org.omg.uml.PackageableElement;

import java.util.ArrayList;

/**
 * An import reference to a package all of whose public members are to be
 * imported.
 **/

public class PackageImportReferenceImpl extends ImportReferenceImpl {

	public PackageImportReferenceImpl(PackageImportReference self) {
		super(self);
	}

	public PackageImportReference getSelf() {
		return (PackageImportReference) this.self;
	}
	
	/*
	 * Constraints
	 */

	/**
	 * The referent of a package import must be a package.
	 **/
	public boolean packageImportReferenceReferent() {
	    ElementReference referent = this.getSelf().getReferent();
	    return referent != null && referent.getImpl().isPackage();
	}

    /*
     * Helper Methods
     */

    @Override
    public ArrayList<Member> getImportedMembers() {
        ArrayList<Member> members = new ArrayList<Member>();
        ElementReference referent = this.getSelf().getReferent();
        if (referent != null && referent.getImpl().isPackage()) {
            PackageDefinition packageDefinition = (PackageDefinition)referent.getImpl().getAlf();
            if (packageDefinition != null) {
                for (Member member: packageDefinition.getImpl().getPublicMembers()) {
                    members.add(makeImportedMember(member.getImpl().getReferent()));
                }
            } else {
                for (PackageableElement element: ((Package)referent.getImpl().getUml()).visibleMembers()) {
                    ExternalElementReference memberReference = new ExternalElementReference();
                    memberReference.setElement(element);
                    members.add(makeImportedMember(memberReference));
                }
            }
        }
        return members;
    }
    
    @Override
    public boolean equals(Object other) {
        return (other instanceof PackageImportReference || other instanceof PackageImportReferenceImpl) &&
            super.equals(other);
    }

} // PackageImportReferenceImpl
