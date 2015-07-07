package com.lbg.c2;

public class AudioParam extends Parameter {
	/**
	 * 
	 */
	private static final long serialVersionUID = -2199136259086531269L;
	private String label;
	private String description;
	
	public AudioParam () {
		super("Audio Parameter");
		
	}
	
	public AudioParam (String l, String d)  {
	super("Audio Parameter");
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
