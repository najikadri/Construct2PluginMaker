package com.lbg.c2;
import java.awt.*;
import java.awt.event.*;

import javax.swing.*;

public class C2Popup extends JPopupMenu{
	
	/**
	 * 
	 */
	public static final int COND = 0;
	public static final int ACT = 1;
	public static final int EXPR = 2;
	public static final int PROP = 3;
	private static final long serialVersionUID = 1L;
	private C2Frame frame;
	private JTabbedPane pane;
	private JMenuItem add;
	private JMenuItem edit;
	private JMenuItem delete;
	
	public C2Popup (C2Frame f, JTabbedPane p) {
		setFrame(f);
		setPane(p);
		
		add = new JMenuItem ("add");
		add.setMnemonic('a');
		edit = new JMenuItem ("edit");
		edit.setMnemonic('e');
		delete = new JMenuItem ("delete");
		delete.setMnemonic('d');
		
		this.add(add);
		this.addSeparator();
		this.add(edit);
		this.addSeparator();
		this.add(delete);
		
		
		add.addActionListener(new ActionListener () {

			@Override
			public void actionPerformed(ActionEvent e) {
			 if (pane.getSelectedIndex() == COND) {
				String tid = JOptionPane.showInputDialog(frame, "Condition ID?\nany positive integer to uniquely identify this condition", "New Condition",JOptionPane.QUESTION_MESSAGE);
				int id = Integer.parseInt(tid);
				String flags = JOptionPane.showInputDialog(frame, "Condition Flags?\nflags: cf_none , cf_trigger , cf_fake_trigger , cf_static, cf_not_invertible ", "New Condition", JOptionPane.QUESTION_MESSAGE);
				String list_name = JOptionPane.showInputDialog(frame,  "Condition List Name?\nappears in event wizard list", "New Condition",JOptionPane.QUESTION_MESSAGE);
				String category = JOptionPane.showInputDialog(frame,  "Condition Category?\ncategory in event wizard list", "New Condition",JOptionPane.QUESTION_MESSAGE);
				String display_Str = JOptionPane.showInputDialog(frame,  "Condition Display String?\nas appears in event sheet - use {0}, {1} for parameters and also <b></b>, <i></i>", "New Condition",JOptionPane.QUESTION_MESSAGE);
      			String desc = JOptionPane.showInputDialog(frame, "Condition Description?\nappears in event wizard dialog when selected", "New Condition",JOptionPane.QUESTION_MESSAGE);
				String script_name = JOptionPane.showInputDialog(frame, "Condition Script Name?\ncorresponding runtime function name", "New Condition",JOptionPane.QUESTION_MESSAGE);
				Condition con = new Condition(id,flags,list_name,category,display_Str,desc,script_name);
				frame.getPlugin().addCond(con);
				frame.update();
				 
			 }
			 else if (pane.getSelectedIndex() == ACT) {
				 String tid = JOptionPane.showInputDialog(frame, "Action ID?\nany positive integer to uniquely identify this action", "New Action",JOptionPane.QUESTION_MESSAGE);
					int id = Integer.parseInt(tid);
					String flags = JOptionPane.showInputDialog(frame, "Action Flags?\nflags: cf_none , cf_trigger , cf_fake_trigger , cf_static, cf_not_invertible ", "New Action", JOptionPane.QUESTION_MESSAGE);
					String list_name = JOptionPane.showInputDialog(frame,  "Action List Name?\nappears in event wizard list", "New Action",JOptionPane.QUESTION_MESSAGE);
					String category = JOptionPane.showInputDialog(frame,  "Action Category?\ncategory in event wizard list", "New Action",JOptionPane.QUESTION_MESSAGE);
					String display_Str = JOptionPane.showInputDialog(frame,  "Action Display String?\nas appears in event sheet - use {0}, {1} for parameters and also <b></b>, <i></i>", "New Action",JOptionPane.QUESTION_MESSAGE);
	      			String desc = JOptionPane.showInputDialog(frame, "Action Description?\nappears in event wizard dialog when selected", "New Action",JOptionPane.QUESTION_MESSAGE);
					String script_name = JOptionPane.showInputDialog(frame, "Action Script Name?\ncorresponding runtime function name", "New Action",JOptionPane.QUESTION_MESSAGE);
					Action act = new Action(id,flags,list_name,category,display_Str,desc,script_name);
					frame.getPlugin().addAct(act);
					frame.update();
				 
			 }
			 else if (pane.getSelectedIndex() == EXPR) {
				 String tid = JOptionPane.showInputDialog(frame, "Expression ID?\nany positive integer to uniquely identify this expression", "New Expression",JOptionPane.QUESTION_MESSAGE);
					int id = Integer.parseInt(tid);
					String flags = JOptionPane.showInputDialog(frame, "Expression Flag?\nFlags: cf_none, cf_deprecated , cf_return_number , cf_return_string", "New Expression",JOptionPane.QUESTION_MESSAGE);
					String list_name = JOptionPane.showInputDialog(frame, "Expression List name?\ncurrently ignored, but set as if appeared in event wizard", "New Expression",JOptionPane.QUESTION_MESSAGE);
					String category = JOptionPane.showInputDialog(frame, "Expression Category?\ncategery in the expressions panel", "New Expression",JOptionPane.QUESTION_MESSAGE);
					String exp_name = JOptionPane.showInputDialog(frame, "Expression Name?\nthe expression name after the dot, e.g. \"foo\" for \"myobject.foo\" - also the runtime function name", "New Expression",JOptionPane.QUESTION_MESSAGE);
					String description = JOptionPane.showInputDialog(frame, "Expression Description?\ndescription in the expressions panel", "New Expression",JOptionPane.QUESTION_MESSAGE);
					Expression exp = new Expression(id,flags,list_name,category,exp_name,description);
					frame.getPlugin().addExpr(exp);
					frame.update();
				 
			 }
			 else if (pane.getSelectedIndex() == PROP) {
				 String type = "ept_integer";
				 String types [] = {"integer","float","text","color","font","combo"};
				 JComboBox<String> combo = new JComboBox<String> (types);
				 JLabel label = new JLabel ("Select the property type:\n");
		         JPanel panel = new JPanel();
		         panel.setLayout(new BorderLayout());
		         panel.add(label, BorderLayout.NORTH);
		         panel.add(combo, BorderLayout.SOUTH);
				 JOptionPane.showMessageDialog(frame, panel, "New Property", JOptionPane.QUESTION_MESSAGE);
				 type = Property.formatType((String) combo.getSelectedItem());
				 

				 if (combo.getSelectedIndex() == 5 ) {
					 String name = JOptionPane.showInputDialog(frame, "Property Name?","New Property",JOptionPane.QUESTION_MESSAGE);
					 String initial_value = JOptionPane.showInputDialog(frame, "Property Initial Value?","New Property",JOptionPane.QUESTION_MESSAGE);
					 String items = JOptionPane.showInputDialog(frame, "Property Items?\nExample : \"Item1 | Item2 | item3\"","New Property",JOptionPane.QUESTION_MESSAGE);
					 String desc = JOptionPane.showInputDialog(frame, "Property Description?","New Property",JOptionPane.QUESTION_MESSAGE);
					 Property p = new Property (type,name,initial_value,desc,items);
					 frame.getPlugin().addProp(p);
					 frame.update();
					 
				 }
				 else {
					 String name = JOptionPane.showInputDialog(frame, "Property Name?","New Property",JOptionPane.QUESTION_MESSAGE);
					 String initial_value = JOptionPane.showInputDialog(frame, "Property Initial Value?","New Property",JOptionPane.QUESTION_MESSAGE);
					 String desc = JOptionPane.showInputDialog(frame, "Property Description?","New Property",JOptionPane.QUESTION_MESSAGE);
					 Property p = new Property (type,name,initial_value,desc);
					 frame.getPlugin().addProp(p);
					 frame.update();
					 
				 }
				 
				 }
				
			}
			
		});
		
		edit.addActionListener(new ActionListener () {

			@Override
			public void actionPerformed(ActionEvent e) {
				
				Plugin p = frame.getPlugin();
				
				 if (pane.getSelectedIndex() == COND) {
					    int index = frame.getConditions().getSelectedIndex();
						String tid = (String) JOptionPane.showInputDialog(frame, "Condition ID?\nany positive integer to uniquely identify this condition", "Edit Condition",JOptionPane.QUESTION_MESSAGE,null,null,p.getCond(index).getId());
						int id = Integer.parseInt(tid);
						String flags = (String) JOptionPane.showInputDialog(frame, "Condition Flags?\nflags: cf_none , cf_trigger , cf_fake_trigger , cf_static, cf_not_invertible ", "Edit Condition", JOptionPane.QUESTION_MESSAGE,null,null,p.getCond(index).getFlag());
						String list_name = (String) JOptionPane.showInputDialog(frame,  "Condition List Name?\nappears in event wizard list", "Edit Condition",JOptionPane.QUESTION_MESSAGE,null,null,p.getCond(index).getList_name());
						String category = (String) JOptionPane.showInputDialog(frame,  "Condition Category?\ncategory in event wizard list", "Edit Condition",JOptionPane.QUESTION_MESSAGE,null,null,p.getCond(index).getCategory());
						String display_Str = (String) JOptionPane.showInputDialog(frame,  "Condition Display String?\nas appears in event sheet - use {0}, {1} for parameters and also <b></b>, <i></i>", "Edit Condition",JOptionPane.QUESTION_MESSAGE,null,null,p.getCond(index).getDisplay_str());
		      			String desc = (String) JOptionPane.showInputDialog(frame, "Condition Description?\nappears in event wizard dialog when selected", "Edit Condition",JOptionPane.QUESTION_MESSAGE,null,null,p.getCond(index).getDescription());
						String script_name = (String) JOptionPane.showInputDialog(frame, "Condition Script Name?\ncorresponding runtime function name", "Edit Condition",JOptionPane.QUESTION_MESSAGE,null,null,p.getCond(index).getScript_name());
						Condition con = new Condition(id,flags,list_name,category,display_Str,desc,script_name);
						frame.getPlugin().setCond(con, index);
						frame.update();
						 
					 }
					 else if (pane.getSelectedIndex() == ACT) {
						  int index = frame.getActions().getSelectedIndex();
						    String tid = (String) JOptionPane.showInputDialog(frame, "Condition ID?\nany positive integer to uniquely identify this condition", "Edit Action",JOptionPane.QUESTION_MESSAGE,null,null,p.getAct(index).getId());
							int id = Integer.parseInt(tid);
							String flags = (String) JOptionPane.showInputDialog(frame, "Condition Flags?\nflags: cf_none , cf_trigger , cf_fake_trigger , cf_static, cf_not_invertible ", "Edit Action", JOptionPane.QUESTION_MESSAGE,null,null,p.getAct(index).getFlag());
							String list_name = (String) JOptionPane.showInputDialog(frame,  "Condition List Name?\nappears in event wizard list", "Edit Action",JOptionPane.QUESTION_MESSAGE,null,null,p.getAct(index).getList_name());
							String category = (String) JOptionPane.showInputDialog(frame,  "Condition Category?\ncategory in event wizard list", "Edit Action",JOptionPane.QUESTION_MESSAGE,null,null,p.getAct(index).getCategory());
							String display_Str = (String) JOptionPane.showInputDialog(frame,  "Condition Display String?\nas appears in event sheet - use {0}, {1} for parameters and also <b></b>, <i></i>", "Edit Action",JOptionPane.QUESTION_MESSAGE,null,null,p.getAct(index).getDisplay_str());
			      			String desc = (String) JOptionPane.showInputDialog(frame, "Condition Description?\nappears in event wizard dialog when selected", "Edit Action",JOptionPane.QUESTION_MESSAGE,null,null,p.getAct(index).getDescription());
							String script_name = (String) JOptionPane.showInputDialog(frame, "Condition Script Name?\ncorresponding runtime function name", "Edit Action",JOptionPane.QUESTION_MESSAGE,null,null,p.getAct(index).getScript_name());
							Action act = new Action(id,flags,list_name,category,display_Str,desc,script_name);
							frame.getPlugin().setAct(act, index);
							frame.update();
						 
					 }
					 else if (pane.getSelectedIndex() == EXPR) {
						 int index = frame.getExpressions().getSelectedIndex();
						 String tid = (String) JOptionPane.showInputDialog(frame, "Expression ID?\nany positive integer to uniquely identify this expression", "Edit Expression",JOptionPane.QUESTION_MESSAGE,null,null,p.getExpr(index).getId());
							int id = Integer.parseInt(tid);
							String flags = (String) JOptionPane.showInputDialog(frame, "Expression Flag?\nFlags: cf_none, cf_deprecated , cf_return_number , cf_return_string", "Edit Expression",JOptionPane.QUESTION_MESSAGE,null,null,p.getExpr(index).getFlag());
							String list_name = (String) JOptionPane.showInputDialog(frame, "Expression List name?\ncurrently ignored, but set as if appeared in event wizard", "Edit Expression",JOptionPane.QUESTION_MESSAGE,null,null,p.getExpr(index).getList_name());
							String category = (String) JOptionPane.showInputDialog(frame, "Expression Category?\ncategery in the expressions panel", "Edit Expression",JOptionPane.QUESTION_MESSAGE,null,null,p.getExpr(index).getCategory());
							String exp_name = (String) JOptionPane.showInputDialog(frame, "Expression Name?\nthe expression name after the dot, e.g. \"foo\" for \"myobject.foo\" - also the runtime function name", "Edit Expression",JOptionPane.QUESTION_MESSAGE,null,null,p.getExpr(index).getExpr_name());
							String description = (String) JOptionPane.showInputDialog(frame, "Expression Description?\ndescription in the expressions panel", "Edit Expression",JOptionPane.QUESTION_MESSAGE,null,null,p.getExpr(index).getDescription());
							Expression exp = new Expression(id,flags,list_name,category,exp_name,description);
							frame.getPlugin().setExpr(exp,index);
							frame.update();
						 
					 }
					 else if (pane.getSelectedIndex() == PROP) {
						 int index = frame.getProperties().getSelectedIndex();
						 String type = p.getProp(index).getType();
						 String types [] = {"integer","float","text","color","font","combo"};
						 JComboBox<String> combo = new JComboBox<String> (types);
						 combo.setSelectedIndex(Property.getIndex(p.getProp(index).getType()));
						 JLabel label = new JLabel ("Select the property type:\n");
				         JPanel panel = new JPanel();
				         panel.setLayout(new BorderLayout());
				         panel.add(label, BorderLayout.NORTH);
				         panel.add(combo, BorderLayout.SOUTH);
						 JOptionPane.showMessageDialog(frame, panel, "Edit Property", JOptionPane.QUESTION_MESSAGE);
						 type = Property.formatType((String) combo.getSelectedItem());
						 System.out.println(type);

						 if (combo.getSelectedIndex() == 5 ) {
							 String name = (String) JOptionPane.showInputDialog(frame, "Property Name?","Edit Property",JOptionPane.QUESTION_MESSAGE,null,null,p.getProp(index).getName());
							 String initial_value = (String) JOptionPane.showInputDialog(frame, "Property Initial Value?","Edit Property",JOptionPane.QUESTION_MESSAGE,null,null,p.getProp(index).getInitial());
							 String items = (String) JOptionPane.showInputDialog(frame, "Property Items?\nExample : \"Item1 | Item2 | item3\"","Edit Property",JOptionPane.QUESTION_MESSAGE,null,null,p.getProp(index).getItems());
							 String desc = (String) JOptionPane.showInputDialog(frame, "Property Description?","Edit Property",JOptionPane.QUESTION_MESSAGE,null,null,p.getProp(index).getDescription());
							 Property pr = new Property (type,name,initial_value,desc,items);
							 frame.getPlugin().setProp(pr, index);
							 frame.update();
							 
						 }
						 else {
							 String name = (String) JOptionPane.showInputDialog(frame, "Property Name?","Edit Property",JOptionPane.QUESTION_MESSAGE,null,null,p.getProp(index).getName());
							 String initial_value = (String) JOptionPane.showInputDialog(frame, "Property Initial Value?","Edit Property",JOptionPane.QUESTION_MESSAGE,null,null,p.getProp(index).getInitial());
							 String desc = (String) JOptionPane.showInputDialog(frame, "Property Description?","Edit Property",JOptionPane.QUESTION_MESSAGE,null,null,p.getProp(index).getDescription());
							 Property pr = new Property (type,name,initial_value,desc);
							 frame.getPlugin().setProp(pr,index);
							 frame.update();
							 
						 }
						 
						 }
						
				
				
			}
			
		});
		
		delete.addActionListener(new ActionListener () {

			@Override
			public void actionPerformed(ActionEvent e) {
				if (pane.getSelectedIndex() == COND) {
					int index = frame.getConditions().getSelectedIndex();
					frame.getPlugin().removeCond(index);
					frame.update();
				}
				else if (pane.getSelectedIndex() == ACT) {
					int index = frame.getActions().getSelectedIndex();
					frame.getPlugin().removeAct(index);
					frame.update();
				}
				else if (pane.getSelectedIndex() == EXPR) {
					int index = frame.getExpressions().getSelectedIndex();
					frame.getPlugin().removeExpr(index);
					frame.update();
				}
				else if (pane.getSelectedIndex() == PROP) {
					int index = frame.getProperties().getSelectedIndex();
					frame.getPlugin().removeProp(index);
					frame.update();
				}
				
			}
			
		});
		
	}

	

	public C2Frame getFrame() {
		return frame;
	}

	public void setFrame(C2Frame frame) {
		this.frame = frame;
	}

	public JTabbedPane getPane() {
		return pane;
	}

	public void setPane(JTabbedPane pane) {
		this.pane = pane;
	}

}
