package org.modeldriven.alf.uml;

import java.util.List;

public interface ConditionalNode extends StructuredActivityNode {
	public boolean getIsDeterminate();

	public void setIsDeterminate(boolean isDeterminate);

	public boolean getIsAssured();

	public void setIsAssured(boolean isAssured);

	public List<Clause> getClause();

	public void addClause(Clause clause);

	public List<OutputPin> getResult();

	public void addResult(OutputPin result);
}
