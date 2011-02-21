
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
import org.omg.uml.Package_;
import org.omg.uml.Profile;

import java.util.ArrayList;
import java.util.List;

/**
 * The definition of a package, all of whose members must be packageable
 * elements.
 **/

public class PackageDefinitionImpl extends
		org.modeldriven.alf.syntax.units.impl.NamespaceDefinitionImpl {

	public PackageDefinitionImpl(PackageDefinition self) {
		super(self);
	}

	public org.modeldriven.alf.syntax.units.PackageDefinition getSelf() {
		return (PackageDefinition) this.self;
	}

	/**
	 * The applied profiles of a package definition are the profiles listed in
	 * any @apply annotations on the package.
	 **/
	public ArrayList<Profile> deriveAppliedProfile() {
	    // TODO: Handle applied profiles.
		return new ArrayList<Profile>();
	}
	
	/*
	 * Derivations
	 */

	public boolean packageDefinitionAppliedProfileDerivation() {
		this.getSelf().getAppliedProfile();
		return true;
	}
	
	/*
	 * Helper Methods
	 */

	/**
	 * In addition to the annotations allowed on any namespace definition, a
	 * package definition allows @apply annotations plus any stereotype whose
	 * metaclass is consistent with Package.
	 **/
	public Boolean annotationAllowed(StereotypeAnnotation annotation) {
	    // TODO: Allow profile and stereotype applications.
		return super.annotationAllowed(annotation);
	} // annotationAllowed

	/**
	 * Returns true if the namespace definition associated with the given unit
	 * definition is a package definition.
	 **/
	public Boolean matchForStub(UnitDefinition unit) {
		return unit.getDefinition() instanceof PackageDefinition;
	} // matchForStub

	/**
	 * Return true if the given member is either a PackageDefinition or an
	 * imported member whose referent is a PackageDefinition or a Package.
	 **/
	public Boolean isSameKindAs(Member member) {
		if (member instanceof ImportedMember) {
		    SyntaxElement element = ((ImportedMember)member).getReferent().getImpl().getAlf();
		    if (element != null) {
		        return element instanceof PackageDefinition;
		    } else {
		        return ((ImportedMember)member).getReferent().getImpl().getUml() instanceof Package_;
		    }
		} else {
		    return member instanceof PackageDefinition;
		}
	} // isSameKindAs
	
	// Package-only members are limited to visibility within this package 
	// definition.
    protected boolean allowPackageOnly() {
        return false;
    }

    public List<Member> getPublicMembers() {
        ArrayList<Member> publicMembers = new ArrayList<Member>();
        for (Member member: this.getSelf().getMember()) {
            if (member.getImpl().isPublic()) {
                publicMembers.add(member);
            }
        }
        return publicMembers;
    }
} // PackageDefinitionImpl