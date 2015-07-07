package com.lbg.c2;
import java.io.Serializable;
import java.util.*;

public class Condition extends ACE implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 423186251120141593L;
	private int id;
	private String flag;
	private String list_name;
	private String  category;
	private String display_str;
	private String description;
	private String script_name;
	private ArrayList<Parameter> parameters;

	public Condition () {
		parameters = new ArrayList<Parameter>();
	}
	
	public Condition (int i, String f, String l, String c, String di, String de, String s) {
		id =i;
		flag = f;
		list_name = l;
		category = c;
		display_str = di;
		description = de;
		script_name = s;
		parameters = new ArrayList<Parameter>();
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getList_name() {
		return list_name;
	}
	public void setList_name(String list_name) {
		this.list_name = list_name;
	}
	public String getFlag() {
		return flag;
	}
	public void setFlag(String flag) {
		this.flag = flag;
	}
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getDisplay_str() {
		return display_str;
	}
	public void setDisplay_str(String display_str) {
		this.display_str = display_str;
	}
	public String getScript_name() {
		return script_name;
	}
	public void setScript_name(String script_name) {
		this.script_name = script_name;
	}
	public ArrayList<Parameter> getParameters() {
		return parameters;
	}
	public void setParameters(ArrayList<Parameter> parameters) {
		this.parameters = parameters;
	}
	
	public void addParam (Parameter p) {
		Parameter param = p;
		parameters.add(param);
	}
	
	public Parameter getParam (int index) {
		return parameters.get(index);
	}
	
	
	public void setParam(Parameter p, int index) {
	 parameters.set(index, p);
		
	}

	
	public void removeParam(int index) {
      parameters.remove(index);
		
	}
	
	@Override
	public String toString (){
		return String.format("Condition %s  , ID : %d , flags : %s , Category : %s , Display String : %s , Description : %s , Script Name : %s", list_name,id,flag,category,display_str,description,script_name);
	}

	

	

}
