package zad1.Zadanie1;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {   	
        PascalTringle pascalTringle = new PascalTringle();
        
        try 
        {        
        	pascalTringle.compute(5);
        }
        catch (Exception e){};
        
        pascalTringle.draw();
        
        
        //Calculator c = new Calculator();
        //int g = c.add(324,2344);
        
        //System.out.println(g);
    }
}
