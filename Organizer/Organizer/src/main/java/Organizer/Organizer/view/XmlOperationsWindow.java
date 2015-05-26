package Organizer.Organizer.view;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;

import Organizer.Organizer.controller.NotesList;
import Organizer.Organizer.controller.XmlOperations;

public class XmlOperationsWindow extends JFrame implements ActionListener
{
	private	JTabbedPane tabbedPane;
	private	JPanel	panel1;
	private	JPanel	panel2;
	private NotesList notesList;
	private XmlOperations xmlOperations;
	private CalendarWindow calendarWindow;
	
	public XmlOperationsWindow(NotesList notesList, CalendarWindow calendarWindow)
	{
		this.notesList = notesList;
		this.calendarWindow = calendarWindow;
		xmlOperations = new XmlOperations(notesList);
		
		setTitle( "XML" );
		setSize( 300, 200 );

		JPanel topPanel = new JPanel();
		topPanel.setLayout( new BorderLayout() );
		getContentPane().add( topPanel );

		// Create the tab pages
		createPage1Save();
		createPage2Load();

		// Create a tabbed pane
		tabbedPane = new JTabbedPane();
		tabbedPane.addTab( "Save", panel1 );
		tabbedPane.addTab( "Load", panel2 );
		topPanel.add( tabbedPane, BorderLayout.CENTER );
	}
	
	public void showWindow() 
	{
		XmlOperationsWindow mainFrame = new XmlOperationsWindow(notesList, calendarWindow);
		mainFrame.setVisible(true);
	}
	
	private void createPage1Save() 
	{
		panel1 = new JPanel();
		panel1.setLayout(null);

		JLabel label1 = new JLabel( "Press button and save to xml file" );
		label1.setBounds(10, 15, 250, 20);
		panel1.add(label1);

		JButton buttonSave = new JButton("Save");
		buttonSave.setBounds(10, 35, 40, 40);
		buttonSave.setBorder(null);
		panel1.add(buttonSave);
		buttonSave.addActionListener(this);
	}
	
	private void createPage2Load() 
	{
		panel2 = new JPanel();
		panel2.setLayout(null);

		JLabel label2 = new JLabel( "Press button and load from xml file" );
		label2.setBounds(10, 15, 250, 20);
		panel2.add(label2);

		JButton buttonLoad = new JButton("Load");
		buttonLoad.setBounds(10, 35, 40, 40);
		buttonLoad.setBorder(null);
		panel2.add(buttonLoad);
		buttonLoad.addActionListener(this);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
		if(e.getActionCommand().equals("Save"))
		{
			xmlOperations.Save();
		}
		if(e.getActionCommand().equals("Load"))
		{
			notesList = xmlOperations.Load();
			calendarWindow.refreshCalendar(notesList);
		}
	}
}
