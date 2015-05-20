package Organizer.Organizer.controller;

import static org.junit.Assert.*;

import org.junit.Test;

public class NoteTest {
	
	@Test
	public void nullNote() 
	{
		Note note = new Note();
		assertFalse(note.ifNotNull());
	}
	
	@Test
	public void notNullNote() 
	{
		Note note = new Note("12022015", "miasto", "rzeczy");
		assertTrue(note.ifNotNull());
	}
	
	@Test
	public void nullValueInNote() 
	{
		Note note = new Note("12022015", "miasto", null);
		assertFalse(note.ifNotNull());
	}
	
	@Test
	public void emptyValueInNote() 
	{
		Note note = new Note("12022015", "", "");
		assertFalse(note.ifNotNull());
	}

	@Test
	public void testGetSeparetedStringFromDate() throws Exception 
	{
		Note note = new Note("20120220", "miasto", "rzeczy");
		String sut = note.getSeparetedStringFromDate();
		assertEquals("2012/02/20", sut);
	}

}
