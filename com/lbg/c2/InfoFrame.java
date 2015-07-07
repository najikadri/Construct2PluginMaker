package com.lbg.c2;
import java.awt.BorderLayout;
import java.awt.Dimension;

import javax.swing.*;
import javax.swing.event.*;
import java.awt.event.*;

public class InfoFrame extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JComboBox<String> options;
	private JTextArea area;
	private JButton save;
	private C2Frame frame;
	private Plugin nplug;
	private Plugin plugin;
	
	public InfoFrame (C2Frame f) {
		super("Construct 2 Plugin Info Editor");
		
		frame =f;
		
		plugin = frame.getPlugin();
		
		nplug = new Plugin(plugin.getName(),plugin.getId(),plugin.getVersion(),
				plugin.getDescription(),plugin.getAuthor(),plugin.getHelpUrl(),
				plugin.getCategory(),plugin.getType(),plugin.getRotatable()
				,plugin.getFlags());
		
		try {
			   UIManager.setLookAndFeel("com.sun.java.swing.plaf.nimbus.NimbusLookAndFeel");
			} catch (ClassNotFoundException | InstantiationException
				| IllegalAccessException | UnsupportedLookAndFeelException e) {
				e.printStackTrace();
			}
		
		String data [] = {"name","ID","version","description","author"
				,"help url","category","type","rotatable","flags"};
		options = new JComboBox<String> (data);
		
		area = new JTextArea ();
		area.setText(plugin.getName());
		area.setLineWrap(true);
		save = new JButton ("Save Changes");
		
		options.addItemListener(new ItemListener () {

			@Override
			public void itemStateChanged(ItemEvent e) {
				
	          switch (options.getSelectedIndex()) {
				
				case 0: 
				    area.setText(nplug.getName());
					break;
				case 1: 
					   area.setText(nplug.getId());
					break;
				case 2: 
					area.setText(nplug.getVersion());
					break;	
					
				case 3: 
					   area.setText(nplug.getDescription());
					break;	
				
				case 4: 
					area.setText(nplug.getAuthor());
					break;	
					
				case 5: 
					area.setText(nplug.getHelpUrl());				
					break;	
					
				case 6: 
					area.setText(nplug.getCategory());			
					break;	
					
				case 7: 
					area.setText(nplug.getType());				
					break;		
					
				case 8: 
					area.setText(String.format("%b", nplug.getRotatable()));	
					break;	
					
				case 9: 
					area.setText(nplug.getFlags());
					break;	
					
					
				}	
				
			}
			
		});
		
		area.getDocument().addDocumentListener(new DocumentListener () {

			@Override
			public void changedUpdate(DocumentEvent e) {

			}

			@Override
			public void insertUpdate(DocumentEvent e) {

				switch (options.getSelectedIndex()) {
				
				case 0: 
					nplug.setName(area.getText());
					break;
				case 1: 
					nplug.setId(area.getText());
					break;
					
				case 2: 
					nplug.setVersion(area.getText());
					break;	
					
				case 3: 
					nplug.setDescription(area.getText());
					break;	
				
				case 4: 
					nplug.setAuthor(area.getText());
					break;	
					
				case 5: 
					nplug.setHelpUrl(area.getText());
					break;	
					
				case 6: 
					nplug.setCategory(area.getText());
					break;	
					
				case 7: 
					nplug.setType(area.getText());
					break;		
					
				case 8: 
					nplug.setRotatable(Boolean.valueOf(area.getText()));
					break;	
					
				case 9: 
					nplug.setFlags(area.getText());
					break;	
					
					
				}	
			}

			@Override
			public void removeUpdate(DocumentEvent e) {
				
				switch (options.getSelectedIndex()) {
				
				case 0: 
					nplug.setName(area.getText());
					break;
				case 1: 
					nplug.setId(area.getText());
					break;
					
				case 2: 
					nplug.setVersion(area.getText());
					break;	
					
				case 3: 
					nplug.setDescription(area.getText());
					break;	
				
				case 4: 
					nplug.setAuthor(area.getText());
					break;	
					
				case 5: 
					nplug.setHelpUrl(area.getText());
					break;	
					
				case 6: 
					nplug.setCategory(area.getText());
					break;	
					
				case 7: 
					nplug.setType(area.getText());
					break;		
					
				case 8: 
					nplug.setRotatable(Boolean.valueOf(area.getText()));
					break;	
					
				case 9: 
					nplug.setFlags(area.getText());
					break;	
					
					
				}	
			}
			
		});
		
		save.addActionListener(new ActionListener () {

			@Override
			public void actionPerformed(ActionEvent e) {
				
			 plugin.setName(nplug.getName());
			 plugin.setId(nplug.getId());
			 plugin.setVersion(nplug.getVersion());
			 plugin.setDescription(nplug.getDescription());
			 plugin.setAuthor(nplug.getAuthor());
			 plugin.setHelpUrl(nplug.getHelpUrl());
			 plugin.setCategory(nplug.getCategory());
			 plugin.setType(nplug.getType());
			 plugin.setRotatable(nplug.getRotatable());
			 plugin.setFlags(nplug.getFlags());
				
			}
			
		});
		
		this.add(options,BorderLayout.NORTH);
		this.add(new JScrollPane(area),BorderLayout.CENTER);
		this.add(save,BorderLayout.SOUTH);
		
		this.setSize(400,300);
		this.setMinimumSize(new Dimension(400,300));
		this.setLocationRelativeTo(frame);
		this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
	}

}
