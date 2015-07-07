package com.lbg.c2;

public class AnyTypeParam  extends Parameter {
	/**
	 * 
	 */
	private static final long serialVersionUID = -6686348014654182281L;
	private String label;
	private String description;
	private String value;
	
	public AnyTypeParam () {
		super("Any Type Parameter");
		
	}
	
	public AnyTypeParam (String l, String d, String v) {
		super("Any Type Parameter");
		label = l;
		description = d;
		value = v;
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

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}
	
	@Override
	public String toString () {
		return String.format("Type : %s , Label : %s , Description: %s , Initial : %s", this.getType(),this.getLabel(),this.getDescription(),this.getValue());
	}

}
