package zad6.Zadanie6;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import Zad4.Zadanie4.*;

public class BookDaoImpl implements BookDao {

	private static Logger logger = Logger.getLogger(BookDaoImpl.class.getName());
	
	public void writeListToFile(List<Ksiazka> list, String file) {
		// TODO Auto-generated method stub
		
	    try (FileOutputStream fileOut = new FileOutputStream(file);
		    	ObjectOutputStream out = new ObjectOutputStream(fileOut))
	    {
	    	for(int i=0; i < list.size(); i++)
	    	{
	    		out.writeObject(list.get(i).getTitle());
	    		out.writeObject(list.get(i).getAuthor());
	    		out.writeObject(list.get(i).getGenre());
	    		out.writeObject(list.get(i).getISBN());
	    	}
	    	out.writeObject(null);
	    } 
	    catch (IOException i) 
	    {
	    	logger.log(Level.INFO, "IOException ", i);
	    }
		
	}

	public List<Ksiazka> readListFromFile(String file) {
		// TODO Auto-generated method stub
		
		List<Ksiazka> list = new ArrayList<Ksiazka>();
	    
	    try (FileInputStream fileIn = new FileInputStream(file);
		        ObjectInputStream in = new ObjectInputStream(fileIn))
	    {
	        String firstElement;
	        
	        for(;;)
		    {
	        	firstElement = (String) in.readObject();
	        	if(firstElement == null) 
	        		break;
	        	
	        	list.add(new Ksiazka(
	        			firstElement, 
	        			(String) in.readObject(), 
	        			(String) in.readObject(), 
	        			(Integer) in.readObject()
	        	));
		    }
	        
	    } 
	    catch (IOException i) 
	    {
	    	logger.log(Level.INFO, "IOException ", i);
	    } 
	    catch (ClassNotFoundException c) 
	    {
	    	logger.log(Level.INFO, "ClassNotFoundException ", c);
	    }
		
		return list;
	}

	@Override
	public void printList(List<Ksiazka> list) {
		// TODO Auto-generated method stub
		
		for(int i=0; i < list.size(); i++)
	      {
	    	System.out.println(list.get(i).toString());
	      }
	}

	
	
}
