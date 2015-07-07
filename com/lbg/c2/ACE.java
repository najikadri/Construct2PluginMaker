package com.lbg.c2;

import java.util.ArrayList;

public abstract class ACE {
	
	/** This interface has no effect on the program features.
	 * It is just used to refer to the Action class and the
	 * Condition class objects in the paramFrame class
	 */
	
	public abstract ArrayList<Parameter> getParameters();
	
	public abstract void setParameters(ArrayList<Parameter> parameters);
	
	public abstract void addParam (Parameter p);
	
	public abstract Parameter getParam (int index);
	
	public abstract void setParam (Parameter p, int index);
	
	public abstract void removeParam (int index);
	
	public abstract String getList_name();
}
