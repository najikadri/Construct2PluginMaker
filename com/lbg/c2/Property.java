package com.lbg.c2;

import java.io.Serializable;

public class Property implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 6669998126701855761L;
	private String type;
	private String  name;
	private String initial;
	private String  items;
	private String description;
	
	public Property () {

	}
	
	public Property (String t, String n, String i, String d) {
		type = t;
		name = n;
		initial = i;
		description = d;
	}
	
	public Property (String t, String n, String i, String d, String it) {
		type = t;
		name = n;
		initial = i;
		description = d;
		items = it;
	}
	
	public String getType() {
		return type;
	}
	
	public void setType(String type) {
		this.type = type;
	}
	
	public String getInitial() {
		return initial;
	}
	
	public void setInitial(String initial) {
		this.initial = initial;
	}
	
	public String getItems() {
		return items;
	}
	
	public void setItems(String items) {
		this.items = items;
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
	
	public static String formatType (String v) {
		if (v.equals("integer")) {
			return "ept_integer";
		}
		else if(v.equals("float")) {
			return "ept_float";
		}
		else if (v.equals("text")) {
			return "ept_text";
		}
		else if (v.equals("color")) {
			return "ept_color";
		}
		else if (v.equals("font")) {
			return "ept_font";
		}
		else if (v.equals("combo")) {
			return "ept_combo";
		}
		else {
			return "";
		}
	}
	
	public static int getIndex (String v) {
		if (v.equals("ept_integer")) {
			return 0;
		}
		else if(v.equals("ept_float")) {
			return 1;
		}
		else if (v.equals("ept_text")) {
			return 2;
		}
		else if (v.equals("ept_color")) {
			return 3;
		}
		else if (v.equals("ept_font")) {
			return 4;
		}
		else if (v.equals("ept_combo")) {
			return 5;
		}
		else {
			return -1;
		}
	}
	
	@Override
	public String toString () {
		if (type.equals("ept_combo")) {
			return String.format("Property %s , Type : %s , Initial : %s , Items : %s , Description : %s", name,type,initial,items,description);
		}
		else {
			return String.format("Property %s , Type : %s , Initial : %s , Description : %s", name,type,initial,description);
		}
	}
	

}
