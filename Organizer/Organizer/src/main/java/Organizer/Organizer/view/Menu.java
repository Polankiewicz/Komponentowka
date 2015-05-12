package Organizer.Organizer.view;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

import Organizer.Organizer.Week10Components;
import Organizer.Organizer.controller.Note;
import Organizer.Organizer.controller.NotesList;

public class Menu implements ActionListener
{
	private JMenuBar menuBar;
	private JMenu fileMenu;
	private JFrame frame;
	private NotesList notesList;
	
	public Menu(JFrame frame, NotesList notesList)
	{
		this.frame = frame;
		this.notesList = notesList;
	}
	
	public void menuOptions()
 	{
	     menuBar = new JMenuBar();
	     
	     frame.setJMenuBar(menuBar);
	     
	     fileMenu = new JMenu("Options");
	     menuBar.add(fileMenu);
	 
	     JMenuItem xmlAction = new JMenuItem("XML");
	     JMenuItem sqlAction = new JMenuItem("SQL");
	     JMenuItem eventAction = new JMenuItem("Events");
	     JMenuItem settingsAction = new JMenuItem("Settings");
	     JMenuItem infoAction = new JMenuItem("About");
	     JMenuItem exitAction = new JMenuItem("Exit");

	     fileMenu.add(xmlAction);
	     fileMenu.add(sqlAction);
	     	fileMenu.addSeparator();
	     fileMenu.add(eventAction);
	     	fileMenu.addSeparator();
	     fileMenu.add(settingsAction);
	     	fileMenu.addSeparator();
	     fileMenu.add(infoAction);
	     	fileMenu.addSeparator();
	     fileMenu.add(exitAction);
		
	     xmlAction.addActionListener(this);
	     sqlAction.addActionListener(this);
	     eventAction.addActionListener(this);
	     settingsAction.addActionListener(this);
	     infoAction.addActionListener(this);
	     exitAction.addActionListener(this);
 	}
	

	
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
				
		if(e.getActionCommand().equals("XML"))
		{
			XmlOperationsWindow xmlOperationsWindow = new XmlOperationsWindow();
			xmlOperationsWindow.showWindow();
		}
			
		if(e.getActionCommand().equals("SQL"))
		{
			SqlOperationsWindow sqlOperationsWindow = new SqlOperationsWindow();
			sqlOperationsWindow.showWindow();
		}
				
		if(e.getActionCommand().equals("Events"))
		{
			EventsWindow eventsWindow = new EventsWindow(notesList);
			eventsWindow.showWindow();
		}
		
		if(e.getActionCommand().equals("Settings"))
		{
			Week10Components week10Components = new Week10Components();
			week10Components.showWindow();
		}
					
		if(e.getActionCommand().equals("About"))
		{
			AboutWindow aboutWindow = new AboutWindow();
			aboutWindow.showWindow();
		}
		
		if(e.getActionCommand().equals("Exit"))
			frame.dispose();
	}
	
	
}
