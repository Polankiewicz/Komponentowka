package zad5.Zadanie5;

import java.util.Arrays;

import zad2.Zadanie2.*;


public class App 
{
    public static void main( String[] args ) throws Exception
    {
        ReadWrite.writeToTextFile("Zapisanie tekstu do pliku \nęóąśłżźćń",  "plik.txt");
        System.out.println(ReadWrite.readFromTextFile("plik.txt"));
        
        int[] tab =  Tablice.getTabWithRandValues(12);
        System.out.println(Arrays.toString(tab)); // sie wywali potem
        ReadWrite.writeArrayToFile(tab, "tablice.bin");
        ReadWrite.readArrayFromFile("tablice.bin");
        
    }
}
