package Organizer.Organizer.controller;

import java.io.File;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;

public class XmlOperations 
{
	private NotesList notesList;
	private JAXBContext context;
	private String path;
	
	public XmlOperations(NotesList notesList)
	{
		this.notesList = notesList;
		path = new String("out1.xml");
	}
	
	public void setPath(String path)
	{
		this.path = path;
	}
	
	public void Save()
	{
		try 
		{
			context = JAXBContext.newInstance(NotesList.class);
			Marshaller m = context.createMarshaller();
		    m.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);

		    File file = new File (path);
		    
		    m.marshal(notesList, file);
		} 
		catch (JAXBException e) {
			e.printStackTrace();
		}
	}
	
	public NotesList Load()
	{
		try 
		{
			JAXBContext jc = JAXBContext.newInstance(NotesList.class);

			Unmarshaller u = jc.createUnmarshaller ();

			File f = new File (path);
			NotesList object = (NotesList) u.unmarshal(f);
			//notesList = object;
			
			// if note is duplicated - ignore it
			for(int x=0; x<object.size(); x++)
			{
		    	boolean isDuplicatedNote = false;
		    	for(int i=0; i<notesList.size(); i++)
		    	{
		    		if(notesList.getNote(i).getStringFromDate().equals(object.getNote(x).getStringFromDate()))
		    		{
		    			isDuplicatedNote = true;
		    			break;
		    		}
		    	}
		    	if(!isDuplicatedNote)
		    		notesList.addNote(object.getNote(x));
			}
        } 
		catch (JAXBException e) {
			e.printStackTrace ();
        } 
		catch (IllegalArgumentException e) {
			e.printStackTrace();
		} 
		catch (Exception e) {
			e.printStackTrace();
		} 

		return notesList;
	}
}
