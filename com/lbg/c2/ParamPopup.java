package com.lbg.c2;
import java.awt.*;
import java.awt.event.*;

import javax.swing.*;

public class ParamPopup extends JPopupMenu {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -7230789245194528541L;
	private ParamFrame frame;
	private JMenuItem add;
	private JMenuItem edit;
	private JMenuItem delete;
	private ACE ace;
	
	public ParamPopup (ParamFrame f, ACE a) {
		frame = f;
		
		setAce(a);
		
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
		
		
		add.addActionListener(new ActionListener() {
			

			@Override
			public void actionPerformed(ActionEvent e) {
				String types [] = {"number","string","any type","comparision","combo option",
				"combo","object","layer","layout","keyboard","animation","audio"};
				JComboBox<String> box = new JComboBox<String>(types);
				JLabel text = new JLabel ("Select the parameter type:\n");
				JPanel panel = new JPanel();
				panel.setLayout(new BorderLayout());
			    panel.add(text, BorderLayout.NORTH);
			    panel.add(box, BorderLayout.SOUTH);
			    
			    JOptionPane.showMessageDialog(frame, panel, "New Parameter", JOptionPane.QUESTION_MESSAGE);
			    
			   Parameter p = Parameter.init((String) box.getSelectedItem());
			   
			   if (p instanceof NumberParam) {
				  String label = JOptionPane.showInputDialog(frame,"Parameter Label?","New Parameter", JOptionPane.QUESTION_MESSAGE);
				  String description = JOptionPane.showInputDialog(frame,"Parameter Description?","New Parameter", JOptionPane.QUESTION_MESSAGE);
				  String value = JOptionPane.showInputDialog(frame,"Parameter Initial Value?","New Parameter", JOptionPane.QUESTION_MESSAGE);
				  NumberParam par = new NumberParam(label,description,value);
				  ace.addParam(par);
			   }
			   else if (p instanceof StringParam) {
				      String label = JOptionPane.showInputDialog(frame,"Parameter Label?","New Parameter", JOptionPane.QUESTION_MESSAGE);
					  String description = JOptionPane.showInputDialog(frame,"Parameter Description?","New Parameter", JOptionPane.QUESTION_MESSAGE);
					  String value = JOptionPane.showInputDialog(frame,"Parameter Initial Value?","New Parameter", JOptionPane.QUESTION_MESSAGE);
					  StringParam par = new StringParam(label,description,value);
					  ace.addParam(par);
			   }
			   else if (p instanceof AnyTypeParam) {
				      String label = JOptionPane.showInputDialog(frame,"Parameter Label?","New Parameter", JOptionPane.QUESTION_MESSAGE);
					  String description = JOptionPane.showInputDialog(frame,"Parameter Description?","New Parameter", JOptionPane.QUESTION_MESSAGE);
					  String value = JOptionPane.showInputDialog(frame,"Parameter Initial Value?","New Parameter", JOptionPane.QUESTION_MESSAGE);
					  AnyTypeParam par = new AnyTypeParam(label,description,value);
					  ace.addParam(par);
			   }
			   else if (p instanceof ComboParam) {
				      String label = JOptionPane.showInputDialog(frame,"Parameter Label?","New Parameter", JOptionPane.QUESTION_MESSAGE);
					  String description = JOptionPane.showInputDialog(frame,"Parameter Description?","New Parameter", JOptionPane.QUESTION_MESSAGE);
					  String value = JOptionPane.showInputDialog(frame,"Parameter Initial Value?","New Parameter", JOptionPane.QUESTION_MESSAGE);
					  ComboParam par = new ComboParam(label,description,value);
					  ace.addParam(par);
			   }
			   else if (p instanceof ComboOptionParam) {
				   String txt = JOptionPane.showInputDialog(frame,"Parameter Option Text?","New Parameter", JOptionPane.QUESTION_MESSAGE);
				   ComboOptionParam par = new ComboOptionParam(txt);
				   ace.addParam(par);
			   }
			   else if (p instanceof CmpParam) {
				      String label = JOptionPane.showInputDialog(frame,"Parameter Label?","New Parameter", JOptionPane.QUESTION_MESSAGE);
					  String description = JOptionPane.showInputDialog(frame,"Parameter Description?","New Parameter", JOptionPane.QUESTION_MESSAGE);
					  CmpParam par = new CmpParam(label,description);
					  ace.addParam(par);
			   }
			   else if (p instanceof ObjectParam) {
				      String label = JOptionPane.showInputDialog(frame,"Parameter Label?","New Parameter", JOptionPane.QUESTION_MESSAGE);
					  String description = JOptionPane.showInputDialog(frame,"Parameter Description?","New Parameter", JOptionPane.QUESTION_MESSAGE);
					  ObjectParam par = new ObjectParam(label,description);
					  ace.addParam(par);
			   }
			   else if (p instanceof LayerParam) {
				      String label = JOptionPane.showInputDialog(frame,"Parameter Label?","New Parameter", JOptionPane.QUESTION_MESSAGE);
					  String description = JOptionPane.showInputDialog(frame,"Parameter Description?","New Parameter", JOptionPane.QUESTION_MESSAGE);
					  LayerParam par = new LayerParam(label,description);
					  ace.addParam(par);
			   }
			   else if (p instanceof LayoutParam) {
				      String label = JOptionPane.showInputDialog(frame,"Parameter Label?","New Parameter", JOptionPane.QUESTION_MESSAGE);
					  String description = JOptionPane.showInputDialog(frame,"Parameter Description?","New Parameter", JOptionPane.QUESTION_MESSAGE);
					  LayoutParam par = new LayoutParam(label,description);
					  ace.addParam(par);
			   }
			   else if (p instanceof KeybParam) {
				      String label = JOptionPane.showInputDialog(frame,"Parameter Label?","New Parameter", JOptionPane.QUESTION_MESSAGE);
					  String description = JOptionPane.showInputDialog(frame,"Parameter Description?","New Parameter", JOptionPane.QUESTION_MESSAGE);
					  KeybParam par = new KeybParam(label,description);
					  ace.addParam(par);
			   }
			   else if (p instanceof AnimationParam) {
				      String label = JOptionPane.showInputDialog(frame,"Parameter Label?","New Parameter", JOptionPane.QUESTION_MESSAGE);
					  String description = JOptionPane.showInputDialog(frame,"Parameter Description?","New Parameter", JOptionPane.QUESTION_MESSAGE);
					  AnimationParam par = new AnimationParam(label,description);
					  ace.addParam(par);
			   }
			   else if (p instanceof AudioParam) {
				      String label = JOptionPane.showInputDialog(frame,"Parameter Label?","New Parameter", JOptionPane.QUESTION_MESSAGE);
					  String description = JOptionPane.showInputDialog(frame,"Parameter Description?","New Parameter", JOptionPane.QUESTION_MESSAGE);
					  AudioParam par = new AudioParam(label,description);
					  ace.addParam(par);
			   }
			   
			   frame.update();
			    
			}
			
		});
		
		edit.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				int index = frame.getParameters().getSelectedIndex();
				
				Parameter p = ace.getParam(index);
				
				if (p instanceof StringParam || p instanceof NumberParam || p instanceof AnyTypeParam) {
					  String label = (String) JOptionPane.showInputDialog(frame,"Parameter Label?","Edit Parameter", JOptionPane.QUESTION_MESSAGE,null,null,ace.getParam(index).getLabel());
					  String description = (String) JOptionPane.showInputDialog(frame,"Parameter Description?","Edit Parameter", JOptionPane.QUESTION_MESSAGE,null,null,ace.getParam(index).getDescription());
					  String value = (String) JOptionPane.showInputDialog(frame,"Parameter Initial Value?","Edit Parameter", JOptionPane.QUESTION_MESSAGE,null,null,ace.getParam(index).getValue());
					  p.setLabel(label);
					  p.setDescription(description);
					  p.setValue(value);
					  frame.update();
				}
				else if (p instanceof ComboOptionParam) {
					  String txt = (String) JOptionPane.showInputDialog(frame,"Parameter Option Text?","Edit Parameter", JOptionPane.QUESTION_MESSAGE,null,null,ace.getParam(index).getText());
					  p.setText(txt);
					  frame.update();
				}
				else {
					  String label = (String) JOptionPane.showInputDialog(frame,"Parameter Label?","Edit Parameter", JOptionPane.QUESTION_MESSAGE,null,null,ace.getParam(index).getLabel());
					  String description = (String) JOptionPane.showInputDialog(frame,"Parameter Description?","Edit Parameter", JOptionPane.QUESTION_MESSAGE,null,null,ace.getParam(index).getDescription());
					  p.setLabel(label);
					  p.setDescription(description);
					  frame.update();
				}
				
			}
			
		});
		
		delete.addActionListener(new ActionListener () {

			@Override
			public void actionPerformed(ActionEvent e) {
				ace.removeParam(frame.getParameters().getSelectedIndex());
				frame.update();
	
			}
			
		});
	}
	
	public ParamFrame getFrame() {
		return frame;
	}
	
	public void setFrame(ParamFrame frame) {
		this.frame = frame;
	}
	
	public JMenuItem getAdd() {
		return add;
	}
	
	public void setAdd(JMenuItem add) {
		this.add = add;
	}
	
	public JMenuItem getEdit() {
		return edit;
	}
	
	public void setEdit(JMenuItem edit) {
		this.edit = edit;
	}
	
	public JMenuItem getDelete() {
		return delete;
	}
	
	public void setDelete(JMenuItem delete) {
		this.delete = delete;
	}

	public ACE getAce() {
		return ace;
	}

	public void setAce(ACE ace) {
		this.ace = ace;
	}

}
