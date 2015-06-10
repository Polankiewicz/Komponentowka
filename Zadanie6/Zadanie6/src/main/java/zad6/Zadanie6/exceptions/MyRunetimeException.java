package zad6.Zadanie6.exceptions;


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
	}
}
