package Organizer.Organizer.controller;

import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;


@XmlRootElement(name = "notes")
@XmlAccessorType(XmlAccessType.NONE)
public class NotesList 
{
	@XmlElement(name = "notesList")
	private List<Note> notesList;
	
	public NotesList()
	{
		notesList = new ArrayList<Note>();
	}
	
	public void addNote(Note note)
	{
		notesList.add(note);
	}
	
	public Note getNote(int index) throws Exception
	{
		if(index < 0 || index > notesList.size())
			throw new Exception();
		
		return notesList.get(index);
	}
	
	public int size()
	{
		return notesList.size();
	}
	
	public void removeNote(int index) throws Exception
	{
		if(index < 0 || index > notesList.size())
			throw new Exception();
		
		notesList.remove(index);
	}
	
	public void updateNote(int index, Note note) throws Exception
	{
		if(index < 0 || index > notesList.size())
			throw new Exception();
		
		notesList.set(index, note);
	}
	
	public String[] getListOfDates()
	{
		String[] listOfDates = new String[notesList.size()];
		
		for(int i=0; i<notesList.size(); i++)
		{
			listOfDates[i] = notesList.get(i).getSeparetedStringFromDate();
		}
		
		return listOfDates;
	}
	
}
