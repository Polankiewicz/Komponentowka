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

/*
 * 
 * 
 * package zad6.Zadanie6;


class MyException extends Exception
{
	public MyException() {
		
		System.out.println("Utworzenie wyjątku.");
	}
	public MyException(String msg)
	{
		super(msg);
	}
}


public class MyExceptions {

	public void myExceptionMethod() throws MyException
	{
		System.out.println("Zgłoszenie wyjątku MyException");
		throw new MyException();
	}
	
	public static void testExceptions(String[] args)
	{
		MyExceptions sample = new MyExceptions();
		try {
			sample.myExceptionMethod();
		} catch (MyException e) {
			// TODO Auto-generated catch block
			System.out.println("Wyjątek przechwycony");
			e.printStackTrace();
		}		
	}
}


//public class MyException2 extends Exception
//{
//	private int x;
//	public MyException2(){}
//	
//	public MyException2(String message)
//	{
//		super(message);
//	}
//	
//	public MyException2(String message, int x)
//	{
//		super(message);
//		this.x = x;
//	}
//	
//	public int value()
//	{
//		return x;
//	}
//	
//	public String getMessage()
//	{
//		return "Komunikat szczegółowy: " + x + " " + super.getMessage();
//	}
//}
 * 
 * */
