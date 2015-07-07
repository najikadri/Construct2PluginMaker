package com.lbg.c2;

import java.io.*;
import java.nio.charset.*;
import java.nio.file.*;

public class PluginBuilder {
	
	private static Plugin p;
	
	public static void BuildEditTime (File f) {
		
		
	Path path = Paths.get(f.toURI());
	Charset charset = StandardCharsets.UTF_8;
	
	try {
		
	String data = new String(Files.readAllBytes(path),charset);
		
		
	data =	data.replaceAll("\"name\":			\"MyPlugin\"", "\"name\":			\""+p.getName()+"\"");
	data =	data.replaceAll("\"id\":			\"MyPlugin\"", "\"id\":			\""+p.getId()+"\"");
	data =	data.replaceAll("1.0", p.getVersion());
	data =	data.replaceAll("<appears at the bottom of the insert object dialog>", p.getDescription());
	data =	data.replaceAll("<your name/organisation>", p.getAuthor());
	data =	data.replaceAll("<your website or a manual entry on Scirra.com>", p.getHelpUrl());
	data =	data.replaceAll("General", p.getCategory());
	data =	data.replaceAll("world", p.getType());
	data =	data.replaceAll("true", String.format("%b", p.getRotatable()));
	data =	data.replaceAll("\"flags\":		0","\"flags\":		"+p.getFlags());
	
	data = data.replaceAll("AddNumberParam", "//AddNumberParam");
	data = data.replaceAll("AddCondition", "//AddCondition");
	data = data.replaceAll("AddStringParam", "//AddStringParam");
	data = data.replaceAll("AddAction", "//AddAction");
	data = data.replaceAll("AddExpression", "//AddExpression");
	data = data.replaceAll("new cr.Property", "//new cr.Property");
	
	data = data.replaceAll("// example c", PluginBuilder.getConditions());
	data = data.replaceAll("// example a", PluginBuilder.getActions());
	data = data.replaceAll("// example e", PluginBuilder.getExpressions());
	data = data.replaceAll("];", PluginBuilder.getProperties());
	
	
	Files.write(path, data.getBytes(charset));
	
	} catch (IOException e) {
		e.printStackTrace();
	}
	
	}
	
	public static void BuildRunTime (File f) {
		
		Path path = Paths.get(f.toURI());
		Charset charset = StandardCharsets.UTF_8;
		
		try {
			String data = new String(Files.readAllBytes(path),charset);
			
			data = data.replaceAll("MyPlugin", p.getId());
			data = data.replaceAll("// the example condition", PluginBuilder.getRConditions());
			data = data.replaceAll("// the example action", PluginBuilder.getRActions());
			data = data.replaceAll("// the example expression", PluginBuilder.getRExpressions());
			
			Files.write(path, data.getBytes(charset));
			
		} catch (IOException e) {
			
			e.printStackTrace();
		}
		
	}
	
	public static void setPlugin(Plugin p) {
		PluginBuilder.p = p;
	}
	
	public static void copyFiles (File in, File out) {
		try {
			InputStream input = new FileInputStream(in);
			OutputStream output = new FileOutputStream(out);
			
			byte [] buffer = new byte[1024];
			
			int length;
			
			 while ((length = input.read(buffer)) > 0){
				 
	    	    	output.write(buffer, 0, length);
	 
	    	    }
			 
			 input.close();
			 output.close();
			
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public static String getActions () {
		String actions = "";
		
		for (int i = 0; i < p.getActions().size();i++) { // first loop
			Action act = p.getAct(i);
			for (int x = 0; x < p.getAct(i).getParameters().size();x++) { //second loop
				 Parameter par = p.getAct(i).getParam(x) ;
				   
				   if (par instanceof NumberParam) { // if condition
					   
					actions = actions + "AddNumberParam(\""+par.getLabel()+"\",\""+par.getDescription()+"\".\""+par.getValue()+"\");\n";
					 
				   }
				   else if (par instanceof StringParam) {
					   actions = actions + "AddStringParam(\""+par.getLabel()+"\",\""+par.getDescription()+"\",\""+par.getValue()+"\");\n";   
				   }
				   else if (par instanceof AnyTypeParam) {
					   actions = actions + "AddAnyTypeParam(\""+par.getLabel()+"\",\""+par.getDescription()+"\",\""+par.getValue()+"\");\n";  
				   }
				   else if (par instanceof ComboParam) {
					   actions = actions + "AddComboParam(\""+par.getLabel()+"\",\""+par.getDescription()+"\",\""+par.getValue()+"\");\n";
				   }
				   else if (par instanceof ComboOptionParam) {
					   actions = actions + "AddComboOption(\""+par.getText()+"\");\n";
				   }
				   else if (par instanceof CmpParam) {
					   actions = actions + "AddCmpParam(\""+par.getLabel()+"\",\""+par.getDescription()+"\");\n"; 
				   }
				   else if (par instanceof ObjectParam) {
					   actions = actions + "AddObjectParam(\""+par.getLabel()+"\",\""+par.getDescription()+"\");\n"; 
				   }
				   else if (par instanceof LayerParam) {
					   actions = actions + "AddLayerParam(\""+par.getLabel()+"\",\""+par.getDescription()+"\");\n";  
				   }
				   else if (par instanceof LayoutParam) {
					   actions = actions + "AddLayoutParam(\""+par.getLabel()+"\",\""+par.getDescription()+"\");\n";    
				   }
				   else if (par instanceof KeybParam) {
					   actions = actions + "AddKeybParam(\""+par.getLabel()+"\",\""+par.getDescription()+"\");\n";   
				   }
				   else if (par instanceof AnimationParam) {
					   actions = actions + "AddAnimationParam(\""+par.getLabel()+"\",\""+par.getDescription()+"\");\n"; 
				   }
				   else if (par instanceof AudioParam) {
					   actions = actions + "AddAudioParam(\""+par.getLabel()+"\",\""+par.getDescription()+"\");\n"; 
				   } // end of if condition
			} //end of first loop
			actions = actions + "AddAction("+act.getId()+",\""+act.getFlag()+"\",\""+act.getList_name()+"\",\""+act.getCategory()+"\",\""+act.getDisplay_str()+"\",\""+act.getDescription()+"\",\""+act.getScript_name()+"\");\n \n";
		} // end of second loop
		return actions;
	}
	
	public static String getConditions () {
		String conditions = "";
		
		for (int i = 0; i < p.getConditions().size();i++) { // first loop
			Condition cond = p.getCond(i);
			for (int x = 0; x < p.getCond(i).getParameters().size();x++) { //second loop
				
				 Parameter par = p.getCond(i).getParam(x) ;
				   
				   if (par instanceof NumberParam) { // if condition
					   
					conditions = conditions + "AddNumberParam(\""+par.getLabel()+"\",\""+par.getDescription()+"\".\""+par.getValue()+"\");\n";
					 
				   }
				   else if (par instanceof StringParam) {
					   conditions = conditions + "AddStringParam(\""+par.getLabel()+"\",\""+par.getDescription()+"\",\""+par.getValue()+"\");\n";   
				   }
				   else if (par instanceof AnyTypeParam) {
					   conditions = conditions + "AddAnyTypeParam(\""+par.getLabel()+"\",\""+par.getDescription()+"\",\""+par.getValue()+"\");\n";  
				   }
				   else if (par instanceof ComboParam) {
					   conditions = conditions + "AddComboParam(\""+par.getLabel()+"\",\""+par.getDescription()+"\",\""+par.getValue()+"\");\n";
				   }
				   else if (par instanceof ComboOptionParam) {
					   conditions = conditions + "AddComboOption(\""+par.getText()+"\");\n";
				   }
				   else if (par instanceof CmpParam) {
					   conditions = conditions + "AddCmpParam(\""+par.getLabel()+"\",\""+par.getDescription()+"\");\n"; 
				   }
				   else if (par instanceof ObjectParam) {
					   conditions = conditions + "AddObjectParam(\""+par.getLabel()+"\",\""+par.getDescription()+"\");\n"; 
				   }
				   else if (par instanceof LayerParam) {
					   conditions = conditions + "AddLayerParam(\""+par.getLabel()+"\",\""+par.getDescription()+"\");\n";  
				   }
				   else if (par instanceof LayoutParam) {
					   conditions = conditions + "AddLayoutParam(\""+par.getLabel()+"\",\""+par.getDescription()+"\");\n";    
				   }
				   else if (par instanceof KeybParam) {
					   conditions = conditions + "AddKeybParam(\""+par.getLabel()+"\",\""+par.getDescription()+"\");\n";   
				   }
				   else if (par instanceof AnimationParam) {
					   conditions = conditions + "AddAnimationParam(\""+par.getLabel()+"\",\""+par.getDescription()+"\");\n"; 
				   }
				   else if (par instanceof AudioParam) {
					   conditions = conditions + "AddAudioParam(\""+par.getLabel()+"\",\""+par.getDescription()+"\");\n"; 
				   } // end of if condition
			} //end of first loop
			conditions = conditions + "AddCondition("+cond.getId()+",\""+cond.getFlag()+"\",\""+cond.getList_name()+"\",\""+cond.getCategory()+"\",\""+cond.getDisplay_str()+"\",\""+cond.getDescription()+"\",\""+cond.getScript_name()+"\");\n \n";
		} // end of second loop
		return conditions;
	}
	
	public static String getExpressions () {
		String exp = "";
		
		for (Expression e: p.getExpressions()) {
			
			exp = exp + "AddExpression("+e.getId()+",\""+e.getFlag()+"\",\""+e.getList_name()+"\",\""+e.getCategory()+"\",\""+e.getExpr_name()+"\",\""+e.getDescription()+"\");\n";
		}
		
		return exp;
	}
	
	public static String getProperties () {
		String prop = "";
		
		for (int i = 0; i < p.getProperties().size();i++) {
			Property pr = p.getProp(i);
			
		 if (pr.getType().equals("ept_combo")) {
			 prop = prop + "cr.Property("+pr.getType()+",\""+pr.getName()+"\",\""+pr.getInitial()+"\",\""+pr.getDescription()+"\",\""+pr.getItems()+"\");";
		 }
		 else {
			 prop = prop + "cr.Property("+pr.getType()+",\""+pr.getName()+"\",\""+pr.getInitial()+"\",\""+pr.getDescription()+"\");";
		 }
		 
		 if (i != (p.getProperties().size()-1) ) {
			 prop = prop + ",\n";
		 }
		 else {
			 prop = prop + "\n";
		 }
		 
		}
		prop = prop + "];";
		return prop;
	}

	
	public static String getRConditions () {
		String conditions = "";
		
		for (int i =0; i < p.getConditions().size();i++) {
			 Condition c = p.getCond(i);
			 conditions = conditions + "   Cnds.prototype."+c.getScript_name()+" = function (";
			 for (int x = 0; x < c.getParameters().size();x++) {
				 Parameter par = c.getParam(x);
				 conditions = conditions + par.getLabel();
				 if (x == c.getParameters().size()-1) {
					 conditions = conditions + ")\n   {\n\n   };\n\n";
				 }
				 else {
					 conditions = conditions + ", ";
				 }
			 }
		}
		
		return conditions;
	}
	
	public static String getRActions () {
		String actions = "";
		
		for (int i =0; i < p.getActions().size();i++) {
			 Action a = p.getAct(i);
			 actions = actions + "  Acts.prototype."+a.getScript_name()+" = function (";
			 for (int x = 0; x < a.getParameters().size();x++) {
				 Parameter par = a.getParam(x);
				 actions = actions + par.getLabel();
				 if (x == a.getParameters().size()-1) {
					 actions = actions + ")\n   {\n\n   };\n\n";
				 }
				 else {
					 actions = actions + " , ";
				 }
			 }
		}
		
		return actions;
	}
	
	public static String getRExpressions () {
		String expressions = "";
		
		for (int i =0; i < p.getExpressions().size();i++) {
			Expression exp = p.getExpr(i);
			
			expressions = expressions + "  Exps.prototype."+exp.getExpr_name()+" = function (ret)\n   {\n\n   };\n\n";
		}
		
		return expressions;
	}
}
