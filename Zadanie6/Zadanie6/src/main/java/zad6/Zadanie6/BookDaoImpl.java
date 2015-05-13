package zad6.Zadanie6;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InvalidClassException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.logging.Level;
import java.util.logging.Logger;

import zad6.Zadanie6.exceptions.MyException;
import zad6.Zadanie6.exceptions.MyRunetimeException;


public class BookDaoImpl implements BookDao 
{
	private static Logger logger = Logger.getLogger(BookDaoImpl.class.getName());

	
	public void writeListToFile(Ksiegarnia ksiegarnia, String file) throws MyRunetimeException {
		// TODO Auto-generated method stub
		
	    try (FileOutputStream fileOut = new FileOutputStream(file);
		    	ObjectOutputStream out = new ObjectOutputStream(fileOut))
	    {
	    	out.writeObject(ksiegarnia);
	    } 
	    catch (IOException i) 
	    {
	    	throw new MyRunetimeException("wyjatek IOException w metodzie writeListToFile()", i);

	    }
		
	}

	public Ksiegarnia readListFromFile(String file) throws MyRunetimeException {
		// TODO Auto-generated method stub
		
		Ksiegarnia ksiegarnia = null;
		
	    try (FileInputStream fileIn = new FileInputStream(file);
		        ObjectInputStream in = new ObjectInputStream(fileIn))
	    {	        
	    	ksiegarnia = (Ksiegarnia) in.readObject();
	    } 
	    catch (InvalidClassException i) 
	    {
	    	throw new MyRunetimeException("wyjatek IOException w metodzie readListFromFile() kkkkkk", i);
	    }
	    catch (FileNotFoundException fex)
	    {
	    	//throw new MyRunetimeException("Wyjątek FileNotFoundException w metodzie readListFromFile(), fex");
	    	logger.log(Level.INFO, "Wyjątek I/O Classggggg ", fex);
	    }
	    catch (IOException i) 
	    {
	    	throw new MyRunetimeException("wyjatek IOException w metodzie readListFromFile()", i);
	    } 
	    catch (ClassNotFoundException c) 
	    {
	    	throw new MyRunetimeException("wyjatek ClassNotFoundException w metodzie readListFromFile()", c);
	    }
		
	    return ksiegarnia;
	}	
}
