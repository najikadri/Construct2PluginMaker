package com.lbg.c2;

import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;

import java.awt.event.*;
import java.io.*;

public class C2Bar extends JMenuBar {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private C2Frame frame;
	private Plugin plugin;
	private JTabbedPane pane;
	private JList<String> conditions;
	private JList<String> actions;
	private JList<String> expressions;
	private JList<String> properties;
	private JMenu file;
	private JMenu edit;
	private JMenu build;
	private JMenu help;
	private JMenuItem documentation;
	private JMenuItem about;
	private JMenuItem New;
	private JMenuItem open;
	private JMenuItem save;
	private JMenuItem info;
	private JMenuItem eInfo;
	private JMenuItem eParam;
	private JMenuItem export;
	private JMenuItem reexport;
	private JMenuItem template;
	private File buildLocation;
	private ObjectInputStream input;
	private ObjectOutputStream output;
	private JFileChooser fileChooser;
	private File outDir;
	
	public C2Bar (C2Frame f, JList<String> c, JList<String> a, JList<String> e, JList<String> p) {
		frame = f;
		setConditions(c);
		setActions(a);
		setExpressions(e);
		setProperties(p);
		plugin = frame.getPlugin();
		pane = frame.getPane();
		
		fileChooser = new JFileChooser();
		
		file = new JMenu ("file");
		file.setMnemonic('f');
		New =  new JMenuItem ("new");
		New.setMnemonic('n');
		open = new JMenuItem ("open");
		open.setMnemonic('o');
		save = new JMenuItem ("save");
		save.setMnemonic('s');
		file.add(New);
		file.add(open);
		file.add(save);
		this.add(file);
		
		edit = new JMenu ("edit");
		edit.setMnemonic('e');
		eInfo = new JMenuItem ("info");
		eInfo.setMnemonic('i');
		eParam = new JMenuItem ("parameters");
		eParam.setMnemonic('p');
		edit.add(eInfo);
		edit.add(eParam);
		this.add(edit);
		
		build = new JMenu ("build");
		build.setMnemonic('b');
		info = new JMenuItem ("info");
		info.setMnemonic('i');
		export = new JMenuItem ("export");
		export.setMnemonic('e');
		reexport = new JMenuItem  ("reexport");
		reexport.setMnemonic('r');
		reexport.setEnabled(false);
		template = new JMenuItem ("template");
		template.setMnemonic('t');
		build.add(info);
		build.add(template);
		build.addSeparator();
		build.add(export);
		build.add(reexport);
		this.add(build);
		
		help = new JMenu ("help");
		help.setMnemonic('h');
		about = new JMenuItem ("about");
		about.setMnemonic('a');
		documentation = new JMenuItem ("documentation");
		documentation.setMnemonic('d');
        help.add(about);
        help.add(documentation);
        this.add(help);
		
		about.addActionListener( new ActionListener () {

			@Override
			public void actionPerformed(ActionEvent e) {
				String info = "Name: Construct 2 Plugin Maker " +
			"\nDeveloper: Naji Kadri\nVersion: 1.0.0"+
			 "\nResources : Construct 2 Plugin Template\nContact : naji-newman-2000@hotmail.com"
			;
				JOptionPane.showMessageDialog(frame, info, "about", JOptionPane.INFORMATION_MESSAGE);
				
			}
			
		});
		
		
		documentation.addActionListener(new ActionListener () {

			@Override
			public void actionPerformed(ActionEvent e) {
				
				System.out.println(plugin);
				System.out.println(plugin.getConditions());
				System.out.println(plugin.getActions());
		
				
			}
			
		}) ;
		
		info.addActionListener( new ActionListener () {

			@Override
			public void actionPerformed(ActionEvent e) {
				String title = String.format("%s info", plugin.getName());
				String info = String.format("Name : %s\nID : %s\nVersion : %s\nDescription : %s\nAuthor : %s\nHelp Url : %s\nCategory : %s\ntype: %s\nRotatable : %s\nFlags : %s", plugin.getName(),plugin.getId(),plugin.getVersion(),plugin.getDescription(),plugin.getAuthor(),plugin.getHelpUrl(),plugin.getCategory(),plugin.getType(),plugin.getRotatable(),plugin.getFlags());
				JOptionPane.showMessageDialog(frame, info, title, JOptionPane.INFORMATION_MESSAGE);
				
			}
			
		});
		
		eInfo.addActionListener( new ActionListener () {

			@Override
			public void actionPerformed(ActionEvent e) {
				frame.getInfoFrame().dispose();
				frame.setInfoFrame(new InfoFrame(frame));
				frame.getInfoFrame().setVisible(true);
			}
			
		});
		
		eParam.addActionListener(new ActionListener () {

			@Override
			public void actionPerformed(ActionEvent e) {
			frame.getParamFrame().dispose();
			if (pane.getSelectedIndex() == C2Popup.COND) {
				frame.setParamFrame(new ParamFrame(plugin.getCond(frame.getConditions().getSelectedIndex()),frame));
			}
			else if (pane.getSelectedIndex() == C2Popup.ACT) {
				frame.setParamFrame(new ParamFrame(plugin.getAct(frame.getActions().getSelectedIndex()),frame));
			}
			frame.getParamFrame().setVisible(true);
				
			}
			
		});
		
		New.addActionListener(new ActionListener () {

			@Override
			public void actionPerformed(ActionEvent e) {
		    frame.dispose();
		    new C2Frame ();
				
			}
			
		});
		
		save.addActionListener(new ActionListener () {

			@Override
			public void actionPerformed(ActionEvent e) {
				
				fileChooser.setDialogTitle("Choose a file to save");
				fileChooser.setFileSelectionMode(JFileChooser.FILES_ONLY);
				FileNameExtensionFilter filter = new FileNameExtensionFilter(".ctp","ctp");
				fileChooser.setFileFilter(filter);
				int selection = fileChooser.showSaveDialog(frame);
				if (selection == JFileChooser.APPROVE_OPTION) {
					File file = fileChooser.getSelectedFile();
					String name = file.getAbsolutePath();
					if (!name.endsWith(".ctp")) {
						file = new File(file+".ctp");
					}
					try {
						file.createNewFile();
						output = new ObjectOutputStream(new FileOutputStream(file));
						output.writeObject(frame.getPlugin());
						output.close();
						JOptionPane.showMessageDialog(frame, "Plugin successfully saved!", "alert", JOptionPane.INFORMATION_MESSAGE);
					} catch (IOException e1) {
						e1.printStackTrace();
					}
					
				}
				
				
			}
			
		});
		
		open.addActionListener( new ActionListener () {

			@Override
			public void actionPerformed(ActionEvent e) {
				fileChooser.setDialogTitle("Choose a file to open");
				fileChooser.setFileSelectionMode(JFileChooser.FILES_ONLY);
				FileNameExtensionFilter filter = new FileNameExtensionFilter(".ctp","ctp");
				fileChooser.setFileFilter(filter);
				int selection = fileChooser.showOpenDialog(frame);
				
				if (selection  == JFileChooser.APPROVE_OPTION) {
					File file = fileChooser.getSelectedFile();
					try {
						input = new ObjectInputStream(new FileInputStream(file));
						plugin = (Plugin) input.readObject();
						input.close();
						frame.update();
						JOptionPane.showMessageDialog(frame, "Plugin successfully loaded!", "alert", JOptionPane.INFORMATION_MESSAGE);
					} catch (IOException | ClassNotFoundException e1) {
						e1.printStackTrace();
					}
				}
				
			}
			
		});
		
		export.addActionListener(new ActionListener () {

			@Override
			public void actionPerformed(ActionEvent event) {
				fileChooser = new JFileChooser();
				fileChooser.setDialogTitle("Export Directory");
				fileChooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
			int a = 	fileChooser.showOpenDialog(frame);
				
			 if (a == JFileChooser.APPROVE_OPTION) {
				
				
				outDir = fileChooser.getSelectedFile();
				File edittime = new File(outDir+"\\edittime.js");
				File runtime = new File(outDir+"\\runtime.js");
				File common = new File(outDir+"\\common.js");
				File pluginicon = new File(outDir+"\\PluginIcon.ico");
				
				File inDir = plugin.getTemplate();
				File tedittime = new File(inDir+"\\edittime.js");
				File truntime = new File(inDir+"\\runtime.js");
				File tpluginicon = new File(inDir+"\\PluginIcon.ico");
			
		try {
					PluginBuilder.setPlugin(frame.getPlugin());
					common.createNewFile();
					edittime.createNewFile();
					runtime.createNewFile();
					pluginicon.createNewFile();
					
					PluginBuilder.copyFiles(tedittime, edittime);
					PluginBuilder.copyFiles(truntime, runtime);
					PluginBuilder.copyFiles(tpluginicon, pluginicon);
					
					PluginBuilder.BuildEditTime(edittime);
					PluginBuilder.BuildRunTime(runtime);
					
				} catch (IOException e1) {
					e1.printStackTrace();
				} 
		
		        reexport.setEnabled(true);
				
				JOptionPane.showMessageDialog(frame, "Plugin successfully Built!","Construct 2 Plugin Builder",JOptionPane.INFORMATION_MESSAGE);
				
			}
			}
			
		});
		
		reexport.addActionListener(new ActionListener () {

			@Override
			public void actionPerformed(ActionEvent event) {
			
				File edittime = new File(outDir+"\\edittime.js");
				File runtime = new File(outDir+"\\runtime.js");
				File common = new File(outDir+"\\common.js");
				File pluginicon = new File(outDir+"\\PluginIcon.ico");
				
				File inDir = plugin.getTemplate();
				File tedittime = new File(inDir+"\\edittime.js");
				File truntime = new File(inDir+"\\runtime.js");
				File tpluginicon = new File(inDir+"\\PluginIcon.ico");
			
		try {
					PluginBuilder.setPlugin(frame.getPlugin());
					common.createNewFile();
					edittime.createNewFile();
					runtime.createNewFile();
					pluginicon.createNewFile();
					
					PluginBuilder.copyFiles(tedittime, edittime);
					PluginBuilder.copyFiles(truntime, runtime);
					PluginBuilder.copyFiles(tpluginicon, pluginicon);
					
					PluginBuilder.BuildEditTime(edittime);
					PluginBuilder.BuildRunTime(runtime);
					
				} catch (IOException e1) {
					e1.printStackTrace();
				} 
				
				JOptionPane.showMessageDialog(frame, "Plugin successfully Rebuilt!","Construct 2 Plugin Builder",JOptionPane.INFORMATION_MESSAGE);
				
			}
			
		});
		
		template.addActionListener(new ActionListener () {

			@Override
			public void actionPerformed(ActionEvent e) {
				fileChooser = new JFileChooser ();
				fileChooser.setDialogTitle("Choose Template Location");
				fileChooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
				fileChooser.showOpenDialog(frame);
				plugin.setTemplate(fileChooser.getSelectedFile());
			}
			
		});
		
		
	}

	public JList<String> getConditions() {
		return conditions;
	}

	public void setConditions(JList<String> conditions) {
		this.conditions = conditions;
	}

	public JList<String> getActions() {
		return actions;
	}

	public void setActions(JList<String> actions) {
		this.actions = actions;
	}

	public JList<String> getExpressions() {
		return expressions;
	}

	public void setExpressions(JList<String> expressions) {
		this.expressions = expressions;
	}

	public JList<String> getProperties() {
		return properties;
	}

	public void setProperties(JList<String> properties) {
		this.properties = properties;
	}

	public File getBuildLocation() {
		return buildLocation;
	}

	public void setBuildLocation(File buildLocation) {
		this.buildLocation = buildLocation;
	}

	public ObjectInputStream getInput() {
		return input;
	}

	public void setInput(ObjectInputStream input) {
		this.input = input;
	}

	public JFileChooser getFileChooser() {
		return fileChooser;
	}

	public void setFileChooser(JFileChooser fileChooser) {
		this.fileChooser = fileChooser;
	}

	public ObjectOutputStream getOutput() {
		return output;
	}

	public void setOutput(ObjectOutputStream output) {
		this.output = output;
	}
	
	public Plugin getPlugin () {
		return plugin;
	}
	
	public JMenuItem getParam () {
		return eParam;
	}

	public File getOutDir() {
		return outDir;
	}

	public void setOutDir(File outDir) {
		this.outDir = outDir;
	}

}

