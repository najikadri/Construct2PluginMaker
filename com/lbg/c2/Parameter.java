package com.lbg.c2;

import java.io.Serializable;

public class Parameter implements Param , Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -4928139258303672386L;

	private  String  type;
	
	public static final Parameter NumberParam = new NumberParam();
	public static final Parameter StringParam = new StringParam();
	public static final Parameter AnyTypeParam = new AnyTypeParam();
	public static final Parameter AnimationParam = new AnimationParam();
	public static final Parameter AudioParam = new AudioParam();
	public static final Parameter CmpParam = new CmpParam();
	public static final Parameter ComboOptionParam = new ComboOptionParam();
	public static final Parameter ComboParam = new ComboParam();
	public static final Parameter KeybParam = new KeybParam();
	public static final Parameter LayerParam = new LayerParam();
	public static final Parameter LayoutParam = new LayoutParam();
	public static final Parameter ObjectParam = new ObjectParam();
	
	public Parameter () {
		
	}
	
	public Parameter (String t) {
		type = t;
	}
	
	public String getType() {
		return type;
	}
	
	public static Parameter init (String t) {
		if (t.equals("number")) {
			return NumberParam;
		}
		else if (t.equals("string")) {
			return StringParam;
		}
		else if (t.equals("any type")) {
			return AnyTypeParam;
		}
		else if (t.equals("animation")) {
			return AnimationParam;
		}
		else if (t.equals("audio")) {
			return AudioParam;
		}
		else if (t.equals("comparision")) {
			return CmpParam;
		}
		else if (t.equals("combo option")) {
			return ComboOptionParam;
		}
		else if (t.equals("combo")) {
			return ComboParam;
		}
		else if (t.equals("keyboard")) {
			return KeybParam;
		}
		else if (t.equals("layer")) {
			return LayerParam;
		}
		else if (t.equals("layout")) {
			return LayoutParam;
		}
		else if (t.equals("object")) {
			return ObjectParam;
		}
		else {
			return new Parameter();
		}
	}

	@Override
	public void setLabel(String label) {
		
		
	}

	@Override
	public void setDescription(String description) {
		
		
	}

	@Override
	public void setText(String text) {
		
		
	}

	@Override
	public String getLabel() {

		return "";
	}

	@Override
	public String getDescription() {

		return "";
	}

	@Override
	public String getText() {

		return "" ;
	}

	@Override
	public void setValue(String value) {
		
	}

	@Override
	public String getValue() {
		return "";
	}
	

}
