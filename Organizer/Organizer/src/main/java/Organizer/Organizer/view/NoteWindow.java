package Organizer.Organizer.view;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import Organizer.Organizer.controller.Note;

public class NoteWindow
{
	
	private JTextArea areaForDescription;
	private JTextField fieldForPlace;
	private JLabel labelDate, labelPlace, labelDescription, requiredFields;
	private Note note;
	private JFrame frame2;
	
	
	public void newNoteWindow(String date, CalendarWindow calendarWindow)
	{
			newNoteWindow(date, new Note(), calendarWindow);
	}
	
	public void newNoteWindow(String date, final Note note, final CalendarWindow calendarWindow)
	{
		this.note = note;
		this.note.setStringFromDate(date);
		

		frame2 = new JFrame("Note");
		frame2.setSize(300, 300);
		frame2.setLocation(600, 200);
		frame2.getContentPane().setLayout(null);
		frame2.setResizable(false);
		frame2.setVisible(true);
		
		
		
		String first = date.substring(0, 4);
		String second = date.substring(4, 6);
		String third = date.substring(6, 8);
		// date
		labelDate = new JLabel( first+"/"+second+"/"+third );
		labelDate.setBounds(110, 20, 80, 20);
		frame2.add(labelDate);
		
		// place
		labelPlace = new JLabel( "Place" );
		labelPlace.setBounds(10, 50, 60, 20);
		frame2.add(labelPlace);
				
		// description
		labelDescription = new JLabel( "Description" );
		labelDescription.setBounds(10, 80, 80, 20);
		frame2.add(labelDescription);
		
		
		
		// field for place 
		fieldForPlace = new JTextField();
		fieldForPlace.setBounds(100, 50, 180, 20);
		frame2.add(fieldForPlace);
		
		// area for description
		areaForDescription = new JTextArea();
		areaForDescription.setBounds(100, 80, 180, 80);
		areaForDescription.setLineWrap(true);
		frame2.add(areaForDescription);
		
		
		// jbutton
		JButton saveNote = new JButton("Save");
		saveNote.setBounds(130, 200, 40, 40);
		saveNote.setBorder(null);
		frame2.add(saveNote);
		
		
		// required fields label
		requiredFields = new JLabel();
		requiredFields.setBounds(10, 170, 250, 20);
		requiredFields.setForeground(Color.red);
		frame2.add(requiredFields);
		
		
		if(note != null) 
		{
			fieldForPlace.setText(note.getPlace());
			areaForDescription.setText(note.getDescription());
		}
		
		
		saveNote.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {

				note.setPlace(fieldForPlace.getText());
				note.setDescription(areaForDescription.getText());
				
				if(note.ifNotNull())
				{
					calendarWindow.refreshCalendar();
					frame2.dispose();
				}
				else
					requiredFields.setText("Place and Description are required!");
				
			}
		});
		
		
	}

	public Note getNote()
	{
		return note;
	}

	
}
