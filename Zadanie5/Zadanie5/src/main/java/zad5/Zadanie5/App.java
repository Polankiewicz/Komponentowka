package zad5.Zadanie5;

import zad2.Zadanie2.Tablice;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args ) throws Exception
    {
    	
        //String xxx = ReadWrite.readFromTextFile("plik.txt");
        //System.out.println( xxx );
        
    	int[] tab;
    	tab = Tablice.getTabWithRandValues(20);
        
        ReadWrite.writeToTextFile("Zapisanie tekstu do pliku",  "plik.txt");
        ReadWrite.writeArrayToFile(tab, "tablice.bin");
        
    }
}
