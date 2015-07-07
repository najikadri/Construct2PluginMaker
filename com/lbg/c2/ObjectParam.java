package com.lbg.c2;

public class ObjectParam extends Parameter {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 7401604991299071273L;
	private String label;
	private String description;
	
	public ObjectParam () {
		super("Object Parameter");
		
	}
	
	public ObjectParam (String l, String d) {
		super("Object Parameter");
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
