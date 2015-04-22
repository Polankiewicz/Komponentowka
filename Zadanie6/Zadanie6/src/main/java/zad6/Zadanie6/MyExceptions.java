package zad6.Zadanie6;


class MyException extends Exception
{
	public MyException() {}
	public MyException(String msg)
	{
		super(msg);
	}
}




public class MyExceptions {

	public void myExceptionMethod() throws MyException
	{
		throw new MyException("wyjatek w metodzie xxx");
	}
	
	public void testExceptions()
	{
		try {
			myExceptionMethod();
		} catch (MyException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
	}
	
}
