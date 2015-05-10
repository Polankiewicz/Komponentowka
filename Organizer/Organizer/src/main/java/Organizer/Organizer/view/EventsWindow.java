package Organizer.Organizer.view;

import java.util.List;

import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import Organizer.Organizer.controller.Note;
import Organizer.Organizer.controller.NotesList;

public class EventsWindow 
{
	private JFrame frame;
	private JLabel labelPlace, labelDescription;
	private JTextField fieldForPlace;
	private JTextArea areaForDescription;
	
	private NotesList notesList;
	private String[] listOfDates;
	private JComboBox choseDate;
	
	
	public EventsWindow(NotesList notesList)
	{
		this.notesList = notesList;
	}
	
	public void showWindow() 
	{
		frame = new JFrame("List of all evets");
		frame.setSize(300, 250);
		frame.setLocation(500, 150);
		frame.getContentPane().setLayout(null);
		frame.setResizable(false);
		
		
		labelPlace = new JLabel( "Place" );
		labelPlace.setBounds(10, 50, 60, 20);
		frame.add(labelPlace);
						
		labelDescription = new JLabel( "Description" );
		labelDescription.setBounds(10, 80, 80, 20);
		frame.add(labelDescription);
		
		
		fieldForPlace = new JTextField();
		fieldForPlace.setBounds(100, 50, 180, 20);
		fieldForPlace.setEditable(false);
		frame.add(fieldForPlace);
		
		
		areaForDescription = new JTextArea();
		areaForDescription.setBounds(100, 80, 180, 80);
		areaForDescription.setEditable(false);
		areaForDescription.setLineWrap(true);
		frame.add(areaForDescription);
		
		
		// set separated strings from dates to listOfDates
		listOfDates = new String[ notesList.size() ];
		
		for(int i=0; i<notesList.size(); i++)
		{
			String temp = notesList.getNote(i).getStringFromDate();
					
			String first = temp.substring(0, 4);
			String second = temp.substring(4, 6);
			String third = temp.substring(6, 8);
			String fDate = first + "/" + second + "/" + third;
			
			listOfDates[i] = fDate;
		}
		
		
		choseDate = new JComboBox(listOfDates);
		choseDate.setBounds(110, 15, 100, 20);
		frame.add(choseDate);
		
		//////////////////////////////////////////////////////////////////////////////////////////////////////
		//choseDate.addActionListener(new ActionListener() { }
		//////////////////////////////////////////////////////////////////////////////////////////////////////
		
		frame.setVisible(true);
	}
	
}
