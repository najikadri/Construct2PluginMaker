package com.lbg.c2;

public class LayoutParam extends Parameter {
	/**
	 * 
	 */
	private static final long serialVersionUID = -7575264443679125256L;
	private String label;
	private String description;
	
	public LayoutParam () {
		super("Layout Parameter");
		
	}
	
	public LayoutParam (String l, String d) {
		super("Layout Parameter");
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
