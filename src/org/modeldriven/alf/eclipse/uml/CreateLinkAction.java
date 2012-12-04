package org.modeldriven.alf.eclipse.uml;

import java.util.List;
import java.util.ArrayList;

public class CreateLinkAction extends WriteLinkAction implements
		org.modeldriven.alf.uml.CreateLinkAction {
	public CreateLinkAction() {
		this(UMLFactory.eINSTANCE.createCreateLinkAction());
	}

	public CreateLinkAction(
			fUML.Syntax.Actions.IntermediateActions.CreateLinkAction base) {
		super(base);
	}

	public org.eclipse.uml2.uml.CreateLinkAction getBase() {
		return (org.eclipse.uml2.uml.CreateLinkAction) this.base;
	}

	public List<org.modeldriven.alf.uml.LinkEndCreationData> getEndData() {
		List<org.modeldriven.alf.uml.LinkEndCreationData> list = new ArrayList<org.modeldriven.alf.uml.LinkEndCreationData>();
		for (org.eclipse.uml2.uml.LinkEndCreationData element : this.getBase()
				.getEndData()) {
			list.add(new LinkEndCreationData(element));
		}
		return list;
	}

	public void addEndData(org.modeldriven.alf.uml.LinkEndCreationData endData) {
		this.getBase().addEndData(
				endData == null ? null : ((LinkEndCreationData) endData)
						.getBase());
	}

}
