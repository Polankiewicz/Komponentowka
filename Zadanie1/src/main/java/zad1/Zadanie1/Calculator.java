package zad1.Zadanie1;

public class Calculator {
	
	public double add(double x1, double x2) throws Exception
	{
		double sum = 0;
		
		sum = x1+x2;
		
		if(sum == Double.POSITIVE_INFINITY || sum == Double.NEGATIVE_INFINITY)
			throw new Exception();

		return sum;
	}
	
	public double difference(double x1, double x2) throws Exception
	{
		double difference = 0;
		
		difference = x1-x2;
		
		if(difference == Double.POSITIVE_INFINITY || difference == Double.NEGATIVE_INFINITY)
			throw new Exception();

		return difference;
	}
	
	public double multiply(double x1, double x2) throws Exception
	{
		double product = 0;
		
		product = x1*x2;
			
		if(product == Double.POSITIVE_INFINITY || product == Double.NEGATIVE_INFINITY)
			throw new Exception();

		return product;
	}
	
	public double divide(double x1, double x2) throws Exception
	{
		if(x1 == 0.0 || x2 == 0.0) 
			throw new Exception();
		
		double quotient = 0;
		
		quotient = x1/x2;
		
		if(quotient == Double.POSITIVE_INFINITY || quotient == Double.NEGATIVE_INFINITY)
			throw new Exception();

		return quotient;
	}
	
////////////////////////
	
	
	
	public int add(int x1, int x2) throws Exception
	{
		int sum = 0;
		double y1 = x1;
		double y2 = x2;
		
		sum = x1+x2;
			
		if(sum != (int)(y1 + y2)) 
			throw new Exception();
			//System.out.println("cos tu nie gra" + sum + " != " + (int)(y1 + y2));

		return sum;
	}
	
	public int difference(int x1, int x2) throws Exception
	{
		int difference = 0;
		double y1 = x1;
		double y2 = x2;
		
		difference = x1-x2;
		
		if(difference != (int)(y1 - y2)) 
			throw new Exception();

		return difference;
	}
	
	public int multiply(int x1, int x2) throws Exception
	{
		int product = 0;
		double y1 = x1;
		double y2 = x2;
		
		product = x1*x2;
		
		if(product != (int)(y1 * y2)) 
			throw new Exception();

		return product;
	}
	
	public int divide(int x1, int x2) throws Exception
	{
		if(x1 == 0 || x2 == 0) 
			throw new Exception();
		
		int quotient = 0;
		double y1 = x1;
		double y2 = x2;

		quotient = x1/x2;
		
		if(quotient != (int)(y1 / y2)) 
			throw new Exception();

		return quotient;
	}
}
