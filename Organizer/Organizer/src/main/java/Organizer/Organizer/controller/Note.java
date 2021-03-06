package Organizer.Organizer.controller;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;


@XmlRootElement(name = "note")
@XmlAccessorType(XmlAccessType.NONE)
public class Note 
{
	@XmlElement(name = "stringFromDate")
	private String stringFromDate;
	
	@XmlElement(name = "description")
	private String description;
	
	@XmlElement(name = "place")
	private String place;
	
	public Note() {}
	
	public Note(String stringFromDate, String description, String place)
	{
		this.stringFromDate = stringFromDate;
		this.description = description;
		this.place = place;
	}
	
	public String getStringFromDate() { 
		return stringFromDate; 
	}
	public void setStringFromDate(String stringFromDate) { 
		this.stringFromDate = stringFromDate; 
	}
	
	public String getDescription() { 
		return description; 
	}
	public void setDescription(String description) { 
		this.description = description; 
	}
	
	public String getPlace() { 
		return place; 
	}
	public void setPlace(String place) { 
		this.place = place; 
	}
	
	public boolean equals(Note note) 
	{
		if(stringFromDate.equals(note.getStringFromDate())  && description.equals(note.getDescription()) && 
				place.equals(note.getPlace()))
		return true;
		else 
			return false;
	}
	
	public String getSeparetedStringFromDate()
	{
		return new StringBuilder(stringFromDate.substring(0, 4)).append("/")
			.append(stringFromDate.substring(4, 6)).append("/")
			.append(stringFromDate.substring(6, 8)).toString();
	}

	public Boolean ifNotNull()
	{
		if(description!= null && place!= null && !description.equals("")  && !place.equals("") )
			return true;
		else 
			return false;
	}
}
