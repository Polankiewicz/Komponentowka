package zad6.Zadanie6;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.logging.Level;
import java.util.logging.Logger;


public class BookDaoImpl implements BookDao {

	private static Logger logger = Logger.getLogger(BookDaoImpl.class.getName());
	
	public void writeListToFile(Ksiegarnia ksiegarnia, String file) {
		// TODO Auto-generated method stub
		
	    try (FileOutputStream fileOut = new FileOutputStream(file);
		    	ObjectOutputStream out = new ObjectOutputStream(fileOut))
	    {
	    	out.writeObject(ksiegarnia);
	    } 
	    catch (IOException i) 
	    {
	    	logger.log(Level.INFO, "IOException ", i);
	    }
		
	}

	public Ksiegarnia readListFromFile(String file) {
		// TODO Auto-generated method stub
		
		Ksiegarnia ksiegarnia = null;
		
	    try (FileInputStream fileIn = new FileInputStream(file);
		        ObjectInputStream in = new ObjectInputStream(fileIn))
	    {	        
	    	ksiegarnia = (Ksiegarnia) in.readObject();
	    } 
	    catch (IOException i) 
	    {
	    	logger.log(Level.INFO, "IOException ", i);
	    } 
	    catch (ClassNotFoundException c) 
	    {
	    	logger.log(Level.INFO, "ClassNotFoundException ", c);
	    }
		
	    return ksiegarnia;
	}

	
}
