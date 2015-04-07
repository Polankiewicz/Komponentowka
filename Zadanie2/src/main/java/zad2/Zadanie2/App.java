package zad2.Zadanie2;

import javax.swing.JOptionPane;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
    	try
    	{
    		// drukowanie Pierwszego argumentu wywolania
	    	System.out.println(args[0]);
	    	// drukowanie DRUGIEGO i TRZECIEGO argumentu wywolania
	    	System.out.println(args[1]+" | "+args[2]);
	    	// Zabezpieczenie przed niewlasciwa liczbą argumentów
	    	if (args.length <3) System.err.print("Za malo argumentow");
	    	else System.out.println(" * " + args[0]+" ** "+args[1]+" *** "+args[2]);
	    	// Drukowanie kazdej podanej ilosci argumentow
	    	for (int i=0; i<args.length; i++) // ilosc argumentow jako ograniczenie gorne petli
	    	System.out.println(args[i]);
    	}
    	catch(IndexOutOfBoundsException e)
    	{
    		System.out.println(e);
    	}
    	catch(Exception e)
    	{
    		System.out.println(e);
    	}
    	
    	
    	try
    	{
    		double x1 = Double.parseDouble(args[0]);
	    	double x2 = Double.parseDouble(args[1]);
	    	double x3 = 0.0;
	    	
	    	for(;;)
	    	{
	    		if(args[2].equals("+")) 
	    		{
	    			x3 = x1 + x2;
	    			break;
	    		}
	    		else if(args[2].equals("-")) 
	    		{
	    			x3 = x1 - x2;
	    			break;
	    		}
	    		else if(args[2].equals("*")) 
	    		{
	    			x3 = x1 * x2;
	    			break;
	    		}
	    		else if(args[2].equals("/")) 
	    		{
	    			x3 = x1 / x2;
	    			break;
	    		}
	    		else 
	    		{
	    			args[2] = JOptionPane.showInputDialog("Podaj wlasciwy znak:   - + * /" , "-");
	    		}
	    		
	    	}
	    	
	    	System.out.println(args[0] + " " + args[2] + " " + args[1] + " = " + x3);
	    	
	    	
    	}
    	catch(IndexOutOfBoundsException e)
    	{
    		System.out.println(e);
    	}
    	catch(Exception e)
    	{
    		System.out.println(e);
    	}
    }
}
