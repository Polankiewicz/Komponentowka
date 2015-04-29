package zad6.Zadanie6.exceptions;

import java.util.logging.Level;
import java.util.logging.Logger;


public class MyRunetimeException extends RuntimeException
{
	public MyRunetimeException() {}
	public MyRunetimeException(String msg)
	{
		super(msg);
	}
	public MyRunetimeException(String msg, Exception e)
	{
		super(msg);
		Logger.getLogger(MyRunetimeException.class.getName()).log(Level.INFO, "IOException ", e);
	}
}
