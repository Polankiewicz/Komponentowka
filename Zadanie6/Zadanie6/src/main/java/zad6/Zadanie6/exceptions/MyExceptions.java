package zad6.Zadanie6.exceptions;


public class MyExceptions extends Exception{

	public void myExceptionMethod() throws MyException
	{
		throw new MyException("wyjatek w metodzie myExceptionMethod()");
	}
	
	public void myRunetimeExceptionMethod() throws MyRunetimeException
	{
		throw new MyRunetimeException("wyjatek w metodzie MyRunetimeException()");
	}
	
	
	public void testExceptions()
	{
		try {
			myExceptionMethod();
		} catch (MyException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		myRunetimeExceptionMethod();
			
	}
	
}
