package zad6.Zadanie6.exceptions;

import static org.junit.Assert.*;

import org.junit.Test;

public class MyExceptionsTest {

	@Test(expected=MyException.class)
	public void testMyException() throws MyException {
		MyExceptions myExceptions = new MyExceptions();
    	myExceptions.myExceptionMethod();
	}
	
	@Test(expected=MyRunetimeException.class)
	public void testmyRunetimeException() throws MyRunetimeException {
		MyExceptions myExceptions = new MyExceptions();
    	myExceptions.myRunetimeExceptionMethod();
	}

}
