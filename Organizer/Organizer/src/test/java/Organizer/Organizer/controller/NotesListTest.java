package Organizer.Organizer.controller;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class NotesListTest {

	private NotesList notesList;
	
	@Before
	public void init()
	{
		notesList = new NotesList();
		notesList.addNote(new Note("20151203", "description1", "place1"));
		notesList.addNote(new Note("20151204", "description2", "place2"));
		notesList.addNote(new Note("20151205", "description3", "place3"));
		notesList.addNote(new Note("20151206", "description4", "place4"));
	}

	@Test
	public void testAddNote() throws Exception 
	{
		int before, after;
		before = notesList.size();
		notesList.addNote(new Note("20151206", "description5", "place5"));
		after = notesList.size();
		assertEquals(before + 1, after);
		
		Note note = new Note("20151206", "description5", "place5");
		assertTrue(note.equals(notesList.getNote(after-1)) );
	}
	
	@Test(expected=Exception.class)
	public void testGetNoteLessIndex() throws Exception 
	{
		notesList.getNote(-1);
	}
	
	@Test(expected=Exception.class)
	public void testGetNoteHigherIndex() throws Exception 
	{
		notesList.getNote(11);
	}
	
	@Test
	public void testGetNote() throws Exception
	{
		for(int i=0; i< notesList.size(); i++)
		{
			assertTrue(notesList.getNote(i).equals(new Note("2015120" + (3+i), "description" + (1+i), "place"+ (1+i))));
		}
	}

	@Test
	public void testSize() throws Exception 
	{
		assertEquals(4, notesList.size());
	}

	@Test
	public void testRemoveNote() throws Exception 
	{
		notesList.removeNote(0);
		assertEquals(3, notesList.size());
		
		Note note = new Note("20151203", "description1", "place1");
		
		for(int i=0;i<notesList.size(); i++)
		{
			assertFalse(notesList.getNote(i).equals(note));
		}
	}
	
	@Test(expected=Exception.class)
	public void testRemoveNoteLessIndex() throws Exception 
	{
		notesList.removeNote(-1);
	}
	
	@Test(expected=Exception.class)
	public void testRemoveNoteHigherIndex() throws Exception 
	{
		notesList.removeNote(11);
	}
	
	@Test
	public void testUpdateNote() throws Exception 
	{
		notesList.updateNote(1, new Note("20151204", "descriptionX", "placeX"));
		
		Note note = new Note("20151204", "descriptionX", "placeX");
		
		assertTrue(notesList.getNote(1).equals(note));
	}
	
	@Test(expected=Exception.class)
	public void testUpdateNoteLessIndex() throws Exception 
	{
		notesList.updateNote(-1, new Note("20151204", "description2", "place2"));
	}
	
	@Test(expected=Exception.class)
	public void testUpdateNoteHigherIndex() throws Exception 
	{
		notesList.updateNote(11, new Note("20151204", "description2", "place2"));
	}

	@Test
	public void testGetListOfDates() throws Exception 
	{
		String[] listOfDates = notesList.getListOfDates();
		
		for(int i=0; i<notesList.size(); i++)
		{
			assertEquals(notesList.getNote(i).getSeparetedStringFromDate(), listOfDates[i]);
		}
	}
	
	
	
	// ...

}
