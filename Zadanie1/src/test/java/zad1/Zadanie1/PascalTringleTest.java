package zad1.Zadanie1;

import static org.junit.Assert.*;

import java.util.Arrays;

import org.junit.Before;
import org.junit.Test;

public class PascalTringleTest {

	PascalTringle pascalTringle;
	
	@Before
	public void init()
	{
		pascalTringle = new PascalTringle();
	}
	

	@Test
	public void testCompute() throws Exception 
	{
		pascalTringle.compute(1); 
		assertEquals(1, pascalTringle.getTab()[0][0]);
		
		pascalTringle.compute(4); 
		pascalTringle.suminrows(4);
        pascalTringle.multiplyabove(4);
        assertTrue(Arrays.toString(pascalTringle.getTestowa()).equals(Arrays.toString(pascalTringle.getTesttab())));
        
	}

	@Test(expected=Exception.class)
	public void testComputeZeroValue() throws Exception 
	{
		pascalTringle.compute(0);   
	}
	
	@Test(expected=Exception.class)
	public void testComputeMinusValues() throws Exception 
	{ 
		pascalTringle.compute(-3);   
	}
	
	
}
