package com.lbg.c2;

public class KeybParam extends Parameter {
	/**
	 * 
	 */
	private static final long serialVersionUID = 2091806470307406352L;
	private String label;
	private String description;
	
	public KeybParam () {
		super("Keyboard Parameter");
		
	}
	
	public KeybParam (String l, String d)  {
	super("Keyboard Parameter");
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
