package Organizer.Organizer.controller;

import java.io.File;
import java.lang.reflect.InvocationTargetException;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;

public class XmlOperations 
{
	private NotesList notesList;
	private JAXBContext context;
	
	public XmlOperations(NotesList notesList)
	{
		this.notesList = notesList;
	}
	
	public void Save()
	{
		try 
		{
			context = JAXBContext.newInstance(NotesList.class);
			Marshaller m = context.createMarshaller();
		    m.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);

		    File file = new File ("out1.xml");
		    
		    m.marshal(notesList, file);
		    m.marshal(notesList, file);
		} 
		catch (JAXBException e) 
		{
			e.printStackTrace();
		}
	}
	
	public NotesList Load()
	{
		try 
		{
			JAXBContext jc = JAXBContext.newInstance(NotesList.class);

			Unmarshaller u = jc.createUnmarshaller ();

			File f = new File ("out1.xml");
			NotesList object = (NotesList) u.unmarshal(f);
			notesList = object;
        } 
		catch (JAXBException e) {
			e.printStackTrace ();
        } 
		catch (IllegalArgumentException e) {
			e.printStackTrace();
		} 

		return notesList;
	}
}
