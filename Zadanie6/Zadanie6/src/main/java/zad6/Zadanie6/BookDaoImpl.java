package zad6.Zadanie6;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import zad6.Zadanie6.exceptions.MyRunetimeException;


public class BookDaoImpl implements BookDao 
{
	
	public void writeListToFile(Ksiegarnia ksiegarnia, String file) {
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
	    	throw new MyRunetimeException("wyjatek IOException w metodzie readListFromFile()", i);
	    } 
	    catch (ClassNotFoundException c) 
	    {
	    	throw new MyRunetimeException("wyjatek ClassNotFoundException w metodzie readListFromFile()", c);
	    }
		
	    return ksiegarnia;
	}

	
}
