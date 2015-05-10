package Organizer.Organizer.model;

import java.util.GregorianCalendar;

import javax.swing.JFrame;

public class CalendarLogic 
{
	private JFrame frame;
	
	//int buttonNumeration;
	
	private int realYear, realMonth, realDay, currentYear, currentMonth, currentDay,
	//////////////////////
		monthh, yearr;	
	//////////////////////
	private String today;
	
	
	public CalendarLogic(JFrame frame)
	{
		this.frame = frame;
		
		//Get real month/year
		GregorianCalendar cal = new GregorianCalendar(); //Create calendar
		realDay = cal.get(GregorianCalendar.DAY_OF_MONTH); //Get day
		realMonth = cal.get(GregorianCalendar.MONTH); //Get month
		realYear = cal.get(GregorianCalendar.YEAR); //Get year
		currentMonth = realMonth; //Match month, day and year
		currentYear = realYear;
		currentDay = realDay;
		////////////////////////////// current day
		monthh = realMonth;
		yearr = realYear;
		//////////////////////////////
		today = getStringFromDate(currentDay, currentMonth, currentYear);
		
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
		
		return yearString + monthString + dayString; //ddmmyyyy
	}
	
	
	
	
	
}
