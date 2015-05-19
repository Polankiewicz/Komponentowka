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

}
