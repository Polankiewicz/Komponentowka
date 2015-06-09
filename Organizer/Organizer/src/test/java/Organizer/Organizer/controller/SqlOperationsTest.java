package Organizer.Organizer.controller;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class SqlOperationsTest {

	private NotesList notesList;
	private SqlOperations sqlOperations;
	
	@Before
	public void init()
	{
		notesList = new NotesList();
		notesList.addNote(new Note("20151203", "description1", "place1"));
		notesList.addNote(new Note("20151204", "description2", "place2"));
		notesList.addNote(new Note("20151205", "description3", "place3"));
		notesList.addNote(new Note("20151206", "description4", "place4"));
		
		sqlOperations = new SqlOperations(notesList);
	}
	
	
	@Test
	public void saveLoadTest() throws Exception 
	{
		sqlOperations.Save();
		NotesList sut = sqlOperations.Load();
		
		for(int i=0;i<notesList.size(); i++)
		{
			assertEquals(sut.getNote(i), notesList.getNote(i));
		}
	}

}
