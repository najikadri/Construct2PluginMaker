package com.lbg.c2;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class ParamFrame extends JFrame {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1391964191190872816L;
	private JList<String> parameters;
	private ParamPopup popup;
	private ACE ace;
	private C2Frame frame;
	
 	public ParamFrame () {
  
	}
 	
	public ParamFrame (ACE ace, C2Frame f) {
		super("Construct 2 Parameters Editor");
		
		frame = f;
		
		String info = "";
		
		if (ace instanceof Action) {
			info = String.format("Action %s", ace.getList_name());
		}
		else if (ace instanceof Condition) {
			info = String.format("Condition %s", ace.getList_name());
		}
		
		this.setTitle(this.getTitle()+" - "+info);
		
		
		try {
			   UIManager.setLookAndFeel("com.sun.java.swing.plaf.nimbus.NimbusLookAndFeel");
			} catch (ClassNotFoundException | InstantiationException
				| IllegalAccessException | UnsupportedLookAndFeelException e) {
				e.printStackTrace();
			}
		
		parameters = new JList<String>();
		
		this.ace = ace;
		
		popup = new ParamPopup(this, ace);
		
		parameters.addMouseListener(new MouseAdapter () {
			public void mousePressed (MouseEvent e) {
				checkForTrigger(e);
			}
			
			public void mouseReleased (MouseEvent e) {
				checkForTrigger(e);
			}
			
			private void checkForTrigger (MouseEvent e) {
				if (e.isPopupTrigger()) {
					popup.show(e.getComponent(), e.getX(), e.getY());
				}
			}
		});
		
		this.update();
		
		this.add(new JScrollPane(parameters), BorderLayout.CENTER);
		
		this.setSize(400,300);
		
		this.setLocationRelativeTo(frame);
	}
	
	public void update () {
		
		String param [] = new String[ace.getParameters().size()];
		
		for (int i =0; i < ace.getParameters().size();i++) {
			param[i] = ace.getParameters().get(i).toString();
		}
		
		parameters.setListData(param);
	}

	public JList<String> getParameters() {
		return parameters;
	}

	public void setParameters(JList<String> parameters) {
		this.parameters = parameters;
	}

	public ParamPopup getPopup() {
		return popup;
	}

	public void setPopup(ParamPopup popup) {
		this.popup = popup;
	}

	public ACE getAce() {
		return ace;
	}

	public void setAce(ACE ace) {
		this.ace = ace;
	}
	

}
