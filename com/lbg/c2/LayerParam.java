package com.lbg.c2;

public class LayerParam  extends Parameter{
	/**
	 * 
	 */
	private static final long serialVersionUID = -6943631753604816970L;
	private String label;
	private String description;
	
	public LayerParam () {
		super("Layer Parameter");
		
	}
	
	public LayerParam (String l, String d) {
		super("Layer Parameter");
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
