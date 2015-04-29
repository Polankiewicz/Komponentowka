package zad6.Zadanie6.exceptions;


public class MyExceptions {

	public void myExceptionMethod() throws MyException
	{
		throw new MyException("wyjatek w metodzie myExceptionMethod()");
	}
	
	public void myRunetimeExceptionMethod()
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
