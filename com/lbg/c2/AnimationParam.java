package com.lbg.c2;

public class AnimationParam extends Parameter {
	 
	/**
	 * 
	 */
	private static final long serialVersionUID = 6403738921313682581L;
	private String label;
	private String description;
	
	public AnimationParam () {
		
	super("Animation Parameter");	
	
	}
	
	public AnimationParam (String l, String d)  {
		
	super("Animation Parameter");
	label = l;
	description = d;
	
	}
	
	public String getLabel() {
		return label;
	}
	
	public void setLabel(String label) {
		this.label = label;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
	
	@Override
	public String toString () {
		return String.format("Type : %s , Label : %s , Description: %s", this.getType(),this.getLabel(),this.getDescription());
	}

}
