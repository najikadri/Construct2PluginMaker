package com.lbg.c2;

public class ComboOptionParam extends Parameter {
	/**
	 * 
	 */
	private static final long serialVersionUID = 5901765346068634925L;
	private String text;
	
	public ComboOptionParam () {
		super("Combo Option Parameter");
		
	}
	
    public ComboOptionParam (String t) {
    	super("Combo Option Parameter");
		text = t;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}
	
	@Override
	public String toString() {
		return String.format("Type : %s , Option : %s", this.getType(),this.getText());
	}

}
