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
import Organizer.Organizer.controller.SqlOperations;
import Organizer.Organizer.controller.XmlOperations;

public class SqlOperationsWindow extends JFrame implements ActionListener
{

	private JFrame frame;
	private	JTabbedPane tabbedPane;
	private	JPanel	panel1;
	private	JPanel	panel2;
	private NotesList notesList;
	private SqlOperations sqlOperations;
	private CalendarWindow calendarWindow;
	
	public SqlOperationsWindow(NotesList notesList, CalendarWindow calendarWindow)
	{
		this.notesList = notesList;
		this.calendarWindow = calendarWindow;
		sqlOperations = new SqlOperations(notesList);
		
		setTitle( "SQL" );
		setSize( 300, 200 );

		JPanel topPanel = new JPanel();
		topPanel.setLayout( new BorderLayout() );
		getContentPane().add( topPanel );

		// Create the tab pages
		createPage1();
		createPage2();

		// Create a tabbed pane
		tabbedPane = new JTabbedPane();
		tabbedPane.addTab( "Save", panel1 );
		tabbedPane.addTab( "Load", panel2 );
		topPanel.add( tabbedPane, BorderLayout.CENTER );
	}
	
	public void showWindow() 
	{
		SqlOperationsWindow mainFrame = new SqlOperationsWindow(notesList, calendarWindow);
		mainFrame.setVisible(true);
	}
	
	private void createPage1() 
	{
		panel1 = new JPanel();
		panel1.setLayout(null);

		JLabel label1 = new JLabel( "Press button and save to database" );
		label1.setBounds(10, 15, 250, 20);
		panel1.add(label1);

		JButton buttonSave = new JButton("Save");
		buttonSave.setBounds(10, 35, 40, 40);
		buttonSave.setBorder(null);
		panel1.add(buttonSave);
		
		///////////////////////////////////////////////////////////////////////////
		buttonSave.addActionListener(this);
		///////////////////////////////////////////////////////////////////////////
	}
	
	private void createPage2() 
	{
		panel2 = new JPanel();
		panel2.setLayout(null);

		JLabel label2 = new JLabel( "Press button and load from database" );
		label2.setBounds(10, 15, 250, 20);
		panel2.add(label2);

		JButton buttonLoad = new JButton("Load");
		buttonLoad.setBounds(10, 35, 40, 40);
		buttonLoad.setBorder(null);
		panel2.add(buttonLoad);
		
		///////////////////////////////////////////////////////////////////////////
		buttonLoad.addActionListener(this);
		///////////////////////////////////////////////////////////////////////////
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
		if(e.getActionCommand().equals("Save"))
		{
			sqlOperations.Save();
		}
		if(e.getActionCommand().equals("Load"))
		{
			notesList = sqlOperations.Load();
			calendarWindow.refreshCalendar(notesList);
		}
		
	}
	
}
