package Organizer.Organizer.model;

import static org.junit.Assert.*;

import javax.swing.JButton;

import org.junit.Before;
import org.junit.Test;

import Organizer.Organizer.controller.Note;
import Organizer.Organizer.controller.NotesList;

public class CalendarLogicTest {

	private CalendarLogic calendarLogic;
	private NotesList notesList;
	
	@Before
	public void init()
	{
		calendarLogic = new CalendarLogic();
		
		notesList = new NotesList();
		notesList.addNote(new Note("20150603", "description1", "place1"));
		notesList.addNote(new Note("20150504", "description2", "place2"));
		notesList.addNote(new Note("20141205", "description3", "place3"));
		notesList.addNote(new Note("20151206", "description4", "place4"));
	}
	
	@Test
	public void testGetStringFromDate() throws Exception 
	{
		String sut = calendarLogic.getStringFromDate(7, 4, 1993);
		assertEquals("19930507", sut);
	}

	@Test
	public void testSetFirstDayOfWeekPositionX() throws Exception 
	{
		calendarLogic.setFirstDayofWeek(2);
		int sut = calendarLogic.setFirstDayOfWeekPositionX();
		assertEquals(75, sut);
	}

	@Test
	public void testDeleteOldEvents() throws Exception 
	{
		assertEquals(4, notesList.size());
		calendarLogic.deleteOldEvents(notesList);
		assertEquals(1, notesList.size());
		
		Note note = new Note("20151206", "description4", "place4");
		assertTrue(notesList.getNote(0).equals(note));
	}

	@Test
	public void testNextPrevButtonEnable() throws Exception 
	{
		JButton btnNext = new JButton(); 
		JButton btnPrev = new JButton();
		
		calendarLogic.setCurrentMonth(0);
		calendarLogic.setCurrentYear(2000);
		calendarLogic.nextPrevButtonEnable(btnNext, btnPrev);
		assertFalse(btnPrev.isEnabled());
		
		calendarLogic.setCurrentMonth(11);
		calendarLogic.setCurrentYear(2039);
		calendarLogic.nextPrevButtonEnable(btnNext, btnPrev);
		assertFalse(btnNext.isEnabled());
		
	}

	
	
}
