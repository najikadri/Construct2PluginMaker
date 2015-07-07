package com.lbg.c2;

import java.io.Serializable;


public class Expression implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = -1386101207256018631L;
	private int id;
	private String flag;
	private String list_name;
	private String  category;
	private String expr_name;
	private String description;
	
	public Expression () {
	}
	
	public Expression (int i, String f, String l, String c, String ex, String de) {
		id =i;
		flag = f;
		list_name = l;
		category = c;
		expr_name = ex;
		description = de;
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
	public String getExpr_name() {
		return expr_name;
	}
	public void setExpr_name(String expr_name) {
		this.expr_name = expr_name;
	}	
	
	@Override
	public String toString() {
		return String.format("Expression %s , ID : %d , Flag : %s , Category : %s , List Name : %s ,  Description : %s", expr_name,id,flag,category,list_name,description);
	}

}
