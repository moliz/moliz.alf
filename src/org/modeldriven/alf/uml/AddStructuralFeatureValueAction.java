package org.modeldriven.alf.uml;

import java.util.List;

import org.modeldriven.alf.uml.InputPin;
import org.modeldriven.alf.uml.WriteStructuralFeatureAction;

public interface AddStructuralFeatureValueAction extends
		WriteStructuralFeatureAction {
	public boolean getIsReplaceAll();

	public void setIsReplaceAll(boolean isReplaceAll);

	public InputPin getInsertAt();

	public void setInsertAt(InputPin insertAt);
}