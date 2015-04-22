package zad5.Zadanie5;

import static org.junit.Assert.assertEquals;

import java.util.Arrays;

import org.junit.Test;

import zad2.Zadanie2.*;

public class ReadWriteTest {
	
	
	@Test
	public void testReadWriteText() throws Exception 
	{
		String zapis = "Zapisanie tekstu do pliku \nęóąśłżźćń\n";
		ReadWrite.writeToTextFile(zapis,  "plik.txt");
		
        String odczyt = ReadWrite.readFromTextFile("plik.txt");
        
        assertEquals(odczyt, zapis);
	}
	

	@Test
	public void testReadWriteArray() throws Exception 
	{
		int[] tab = Tablice.getTabWithRandValues(12);
		
		ReadWrite.writeArrayToFile(tab, "tablice.bin");
        Arrays.equals(tab, ReadWrite.readArrayFromFile("tablice.bin"));
	}
	
	@Test
	public void testBubbleSortAndArraysSort() throws Exception 
	{
		int[] tabToSort = Tablice.getTabWithRandValues(10);
		int[] tabArrays = tabToSort.clone();
		
		Arrays.sort(tabArrays);
		Tablice.bubbleSort(tabToSort);
		
		Arrays.equals(tabToSort, tabArrays);
	}

}
