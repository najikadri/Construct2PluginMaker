package com.lbg.c2;
import java.io.File;
import java.io.Serializable;
import java.util.*;

public class Plugin implements Serializable  {
	/**
	 * 
	 */
	private static final long serialVersionUID = 4485852823837813106L;
	private String name;
	private String id;
	private String version;
	private String description;
	private String author;
	private String helpUrl;
	private String category;
	private String type;
	private boolean rotatable;
	private String flags;
	private ArrayList<Condition> conditions;
	private ArrayList<Action> actions;
	private ArrayList<Expression> expressions;
	private ArrayList<Property> properties;
	private File template;
	
	
	
	public Plugin () {
		name = "MyPlugin";
		id = "MyPlugin";
		version = "1.0";
		description = "<appears at the bottom of the insert object dialog>";
		author = "<your name/organisation>";
		helpUrl = "<your website or a manual entry on Scirra.com>";
		category = "General";
		type = "world";
		rotatable = true;
		flags = "0";
		
		conditions = new ArrayList<Condition>();
		actions = new ArrayList<Action>();
		expressions = new ArrayList<Expression>();
		properties = new ArrayList<Property>();
		
	}
	
	public Plugin (String n, String i, String v, String d, String a, String h, String c, String t, boolean r, String f) {
		name = n;
		id = i;
		version = v;
		description = d;
		author = a;
		helpUrl = h;
		category = c;
		type = t;
		rotatable = r;
		flags = f;
		
		conditions = new ArrayList<Condition>();
		actions = new ArrayList<Action>();
		expressions = new ArrayList<Expression>();
		properties = new ArrayList<Property>();
	}
	
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public String getId() {
		return id;
	}
	
	public void setId(String id) {
		this.id = id;
	}
	
	public String getVersion() {
		return version;
	}
	
	public void setVersion(String version) {
		this.version = version;
	}
	
	public String getDescription() {
		return description;
	}
	
	public void setDescription(String description) {
		this.description = description;
	}
	
	public String getAuthor() {
		return author;
	}
	
	public void setAuthor(String author) {
		this.author = author;
	}
	
	public String getHelpUrl() {
		return helpUrl;
	}
	
	public void setHelpUrl(String helpUrl) {
		this.helpUrl = helpUrl;
	}
	
	public String getCategory() {
		return category;
	}
	
	public void setCategory(String category) {
		this.category = category;
	}
	
	public String getFlags() {
		return flags;
	}
	
	public void setFlags(String flags) {
		this.flags = flags;
	}
	
	public String getType() {
		return type;
	}
	
	public void setType(String type) {
		this.type = type;
	}
	
	public boolean getRotatable() {
		return rotatable;
	}
	
	public void setRotatable(boolean rotatable) {
		this.rotatable = rotatable;
	}

	public ArrayList<Condition> getConditions() {
		return conditions;
	}

	public void setConditions(ArrayList<Condition> conditions) {
		this.conditions = conditions;
	}

	public ArrayList<Action> getActions() {
		return actions;
	}

	public void setActions(ArrayList<Action> actions) {
		this.actions = actions;
	}

	public ArrayList<Expression> getExpressions() {
		return expressions;
	}

	public void setExpressions(ArrayList<Expression> expressions) {
		this.expressions = expressions;
	}

	public ArrayList<Property> getProperties() {
		return properties;
	}

	public void setProperties(ArrayList<Property> properties) {
		this.properties = properties;
	}
	
	public void addCond (Condition c) {
		conditions.add(c);
	}
	
	public void removeCond (int index) {
		conditions.remove(index);
	}
	
	public void setCond (Condition c, int index) {
		conditions.set(index, c);
	}
	
	public Condition getCond (int index) {
		return conditions.get(index);
	}
	
	public void addAct (Action a) {
		actions.add(a);
	}
	
	
	public void removeAct (int index) {
		actions.remove(index);
	}
	
	public void setAct (Action a,int index ) {
		actions.set(index, a);
	}
	
	public Action getAct (int index) {
		return actions.get(index);
		
	}
	
	public void addExpr (Expression e) {
		expressions.add(e);
	}
	
	public void setExpr (Expression e, int index) {
		expressions.set(index, e);
	}
	
	public Expression getExpr (int index) {
		return expressions.get(index);
	}
	
	public void removeExpr (int index) {
		expressions.remove(index);
	}
	
	public void addProp (Property p) {
		properties.add(p);
	}
	
	public Property getProp (int index) {
		return properties.get(index);
	}
	
	public void setProp (Property p, int index) {
		properties.set(index, p);
	}
	
	public void removeProp (int index) {
		properties.remove(index);
	}
	
	@Override
	public String toString () {
		return String.format("Name : %s\nID : %s\nVersion : %s\nDescription : %s\nAuthor : %s\nHelp Url : %s\nCategory : %s\ntype: %s\nRotatable : %s\nFlags : %s", name,id,version,description,author,helpUrl,category,type,rotatable,flags);
		
	}

	public File getTemplate() {
		return template;
	}

	public void setTemplate(File template) {
		this.template = template;
	}
	

}
