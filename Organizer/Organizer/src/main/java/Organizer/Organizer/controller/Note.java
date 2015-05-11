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
	
	public Boolean ifNotNull()
	{
		if(description!= null && place!= null && !description.equals("")  && !place.equals("") )
			return true;
		else 
			return false;
	}
}
