package Organizer.Organizer.model;

import java.util.GregorianCalendar;


public class CalendarLogic 
{
	private int realYear, realMonth, realDay, currentYear, currentMonth, currentDay;
	private String today;
	private GregorianCalendar gregorianCalendar;
	
	
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
		
		return yearString + monthString + dayString;
	}
	
	
	
	
	
}
