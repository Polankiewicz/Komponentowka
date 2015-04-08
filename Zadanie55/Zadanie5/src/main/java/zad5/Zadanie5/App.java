package zad5.Zadanie5;

import java.util.Arrays;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        ReadWrite.writeToTextFile("Zapisanie tekstu do pliku \n kk 3 d",  "plik.txt");
        System.out.println(ReadWrite.readFromTextFile("plik.txt"));
        
        int[] tab =  {4, 7, 8, 6, 76, 94, 67, 23, 13, 45};
        ReadWrite.writeArrayToFile(tab, "tablice.bin");
        System.out.println("odczyt tablicy: \n" + Arrays.toString( ReadWrite.readArrayFromFile("tablice.bin") ) );
    }
}
