package zad1.Zadanie1;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class CalculatorTest {

	Calculator x;
	
	@Before
	public void init()
	{
		x = new Calculator();
	}
	
	
	
	@Test
	public void testDivide() throws Exception 
	{
		double y1 = x.divide(9.0, 3.0);
		assertEquals(3.0, y1, 0.0001);	
		
		int y4 = x.divide(5, 2);
		assertEquals(2, y4);
		
		int y5=x.divide(3, 1);
		assertEquals(3,y5);
	}

	@Test(expected=Exception.class)
	public void testDivideException() throws Exception 
	{
		double y = x.divide(5.0, 0.0);
		double y2 = x.divide(0.0, 0.0);
		
		int y3 = x.divide(3, 0);
		int y4 = x.divide(0, 0);
	}
	
	
	@Test
	public void testMultiply() throws Exception 
	{
		double y1 = x.multiply(5.0, 3.0);
		assertEquals(15.0, y1, 0.0001);
		
		int y2 = x.multiply(5, 3);
		assertEquals(15, y2);
	}
	
	@Test(expected=Exception.class)
	public void testMultiplyException() throws Exception 
	{
		double y1 = x.multiply(1e308, 10);
		double y2 = x.multiply(1e308, -10);
		
		int y3 = x.add(1999999999, 1999999999);
		int y4 = x.add(-1999999999, -1999999999);
	}
	

	@Test
	public void testDifference() throws Exception 
	{
		double y1 = x.difference(5.0, 3.0);
		assertEquals(2.0, y1, 1);
		
		int y2 = x.difference(5, 5);
		assertEquals(0, y2);
	}
	
	@Test(expected=Exception.class)
	public void testDifferenceException() throws Exception 
	{
		double y1 = x.difference(1e308, -1e308);
		double y2 = x.difference(-1e308, 1e308);
		
		int y3 = x.add(-1999999999, -1999999999);
	}
	

	@Test
	public void testAdd() throws Exception 
	{
		double y1 = x.add(5.0, 3.0);
		assertEquals(8.0, y1, 1);
		
		int y2 = x.add(3, 2);
		assertEquals(5, y2);
	}
	
	@Test(expected=Exception.class)
	public void testAddException() throws Exception 
	{
		double y1 = x.add(1e308, 1e308);
		double y2 = x.add(-1e308, -1e308);
		
		int y3 = x.add(1999999999, 1999999999);
	}

}
