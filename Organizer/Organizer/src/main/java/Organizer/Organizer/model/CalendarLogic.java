package Organizer.Organizer.model;

import java.util.GregorianCalendar;

import javax.swing.JButton;

import Organizer.Organizer.controller.Note;
import Organizer.Organizer.controller.NotesList;
import Organizer.Organizer.view.CalendarWindow;
import Organizer.Organizer.view.NoteWindow;


public class CalendarLogic 
{
	private int realYear, realMonth, realDay, currentYear, currentMonth, currentDay;
	private String today;
	private GregorianCalendar gregorianCalendar;
	private GregorianCalendar calendarForCountingDays;
	private int firstDayofWeek, numberOdDays;
	
	public CalendarLogic()
	{
		// Create calendar
		gregorianCalendar = new GregorianCalendar(); 
		// real day/month/year
		realDay = gregorianCalendar.get(GregorianCalendar.DAY_OF_MONTH);
		realMonth = gregorianCalendar.get(GregorianCalendar.MONTH);
		realYear = gregorianCalendar.get(GregorianCalendar.YEAR);
		// current displayed day/month/year
		currentMonth = realMonth;
		currentYear = realYear;
		currentDay = realDay;
		// current day
		today = getStringFromDate(currentDay, currentMonth, currentYear);
		
		calendarForCountingDays = new GregorianCalendar();
	}
	
	public int getCurrentDay() { return currentDay; }
	public int getCurrentMonth() { return currentMonth; }
	public int getCurrentYear() { return currentYear; }
	
	public void setCurrentDay(int currentDay) { this.currentDay = currentDay; }
	public void setCurrentMonth(int currentMonth) { this.currentMonth = currentMonth; }
	public void setCurrentYear(int currentYear) { this.currentYear = currentYear; }
	
	public int getRealDay() { return realDay; }
	public int getRealMonth() { return realMonth; }
	public int getRealYear() { return realYear; }
	
	public String getToday() { return today; }
	
	public int getNumberOdDays() { return numberOdDays; }
	public void setNumberOdDays(int numberOdDays) { this.numberOdDays = numberOdDays; }
	
	public int getFirstDayofWeek() { return firstDayofWeek; }
	public void setFirstDayofWeek(int firstDayofWeek) { this.firstDayofWeek = firstDayofWeek; }
	
	
	// build string from date adding "0" when value is less then 10
	public String getStringFromDate (int dd, int mm, int yyyy)
	{
		String dayString, monthString, yearString;
		String zero = "0";
		
		if (dd > 9) 
			dayString = Integer.toString(dd);
		else 
		{
			dayString = Integer.toString(dd);
			dayString = zero + dayString;
		}
		
		if (mm+1 > 9) 
			monthString = Integer.toString(mm+1);
		else 
		{
			monthString = Integer.toString(mm+1);
			monthString = zero + monthString;
		}
		yearString = Integer.toString(yyyy);
		
		return new StringBuilder(yearString).append(monthString).append(dayString).toString();
	}
	
	public int setFirstDayOfWeekPositionX()
	{
		// position
		int x = 25;
				
		// set first day of week
		firstDayofWeek = (firstDayofWeek-1)%7;
		
		if		(firstDayofWeek==0) x= x+0*50;
		else if (firstDayofWeek==1) x= x+1*50;
		else if (firstDayofWeek==2) x= x+2*50;
		else if (firstDayofWeek==3) x= x+3*50;
		else if (firstDayofWeek==4) x= x+4*50;
		else if (firstDayofWeek==5) x= x+5*50;
		else if (firstDayofWeek==6) x= x+6*50;
		
		return x;
	}
	
	public void updateCalendarForCountingDays(int year, int month) 
	{ 
		calendarForCountingDays.set(year, month, 7);
		setFirstDayofWeek(calendarForCountingDays.get(GregorianCalendar.DAY_OF_WEEK));
		setNumberOdDays(calendarForCountingDays.getActualMaximum(GregorianCalendar.DAY_OF_MONTH));
	}
	
	public void deleteOldEvents(NotesList notesList)
	{
		int todayYear = Integer.parseInt( getToday().substring(0, 4) );
		int todayMonth = Integer.parseInt( getToday().substring(4, 6) );
		int todayDay = Integer.parseInt( getToday().substring(6, 8) );
		
		int eventYear, eventMonth, eventDay;
		
		for(int i=0; i< notesList.size(); i++)
		{				
			try 
			{
				eventYear = Integer.parseInt( notesList.getNote(i).getStringFromDate().substring(0, 4) );
				eventMonth = Integer.parseInt( notesList.getNote(i).getStringFromDate().substring(4, 6) );
				eventDay = Integer.parseInt( notesList.getNote(i).getStringFromDate().substring(6, 8) );
				
				// current year and month, previous days
				if(todayYear == eventYear && todayMonth == eventMonth && todayDay > eventDay){
					notesList.removeNote(i);
					i--;
				}
				// current year, previous months
				if(todayYear == eventYear && todayMonth > eventMonth){
					notesList.removeNote(i);
					i--;
				}
				// previous years
				if(todayYear > eventYear){
					notesList.removeNote(i);
					i--;
				}
			} 
			catch (Exception e1) {
				e1.printStackTrace();
			}
		}
	}
	
	public void nextPrevButtonEnable(JButton btnNext, JButton btnPrev)
	{
		btnPrev.setEnabled(true);
		btnNext.setEnabled(true);
		
		// Too early
		if (getCurrentMonth() == 0 && getCurrentYear() <= getRealYear() - 14)
			btnPrev.setEnabled(false); 
		// Too late
		if (getCurrentMonth() == 11 && getCurrentYear() >= getRealYear() + 24)
			btnNext.setEnabled(false);
	}
	
	// open new window for add/update note
	public void dayButtonOn (int day, NotesList notesList, CalendarWindow calendarWindow) throws Exception
	{
		Note note;
		NoteWindow noteWindow = new NoteWindow();
		Boolean update = false;
		
		String pressedCurrentDay = getStringFromDate(day, getCurrentMonth(), getCurrentYear());
		
		// update event
		for(int i=0; i< notesList.size(); i++)	
		{
			if(notesList.getNote(i).getStringFromDate().equals(pressedCurrentDay))
			{
				noteWindow.newNoteWindow(pressedCurrentDay, notesList.getNote(i), calendarWindow);
				note = noteWindow.getNote();
				
				notesList.updateNote(i, note);
				update = true;
			}
		}
		
		// add new event
		if (update == false)	
		{
			noteWindow.newNoteWindow(pressedCurrentDay, calendarWindow);
			note = noteWindow.getNote();
			
			notesList.addNote(note);
		}
	}
	
}
