package zad6.Zadanie6;


class MyException extends Exception
{
	public MyException() {}
	public MyException(String msg)
	{
		super(msg);
	}
}

class MyRunetimeException extends RuntimeException
{
	public MyRunetimeException() {}
	public MyRunetimeException(String msg)
	{
		super(msg);
	}
}



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
		
		
//		//tutaj jeszcze pomyślę czy to jest potrzebne/istotne :P
//		try {
//			int []x = new int[2];
//			x[3] = 4;
//		} 
//		catch (IndexOutOfBoundsException e) {
//			throw new MyRunetimeException("wyjatek MyRunetimeException");
//		}
		
		
	}
	
}
