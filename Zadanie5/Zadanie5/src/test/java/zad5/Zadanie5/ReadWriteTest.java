package zad5.Zadanie5;

import static org.junit.Assert.assertTrue;

import java.util.Arrays;

import org.junit.Test;

import zad2.Zadanie2.*;

public class ReadWriteTest {
	
	
	@Test
	public void testReadWriteText() throws Exception {
		int wynik;
		
		String tekst = "Zapisanie tekstu do pliku \nęóąśłżźćń";
		ReadWrite.writeToTextFile(tekst,  "plik.txt");
		
        String odczyt = ReadWrite.readFromTextFile("plik.txt");
        
        wynik = tekst.compareTo(odczyt);
        		if(wynik==0) System.out.println("Teksty są identyczne.");
        		else System.out.println("Teksty są różne.");
	}
	

	@Test
	public void testReadWriteArray() throws Exception {
		int[] tab = Tablice.getTabWithRandValues(12);
		
		ReadWrite.writeArrayToFile(tab, "tablice.bin");
        Arrays.equals(tab, ReadWrite.readArrayFromFile("tablice.bin"));
	}
	
	@Test
	public void testBubbleSortAndArraysSort() throws Exception {

		int[] tabToSort = Tablice.getTabWithRandValues(10);
		int[] tabArrays = tabToSort.clone();
		
		Arrays.sort(tabArrays);

		Arrays.equals(Tablice.bubbleSort(tabToSort), tabArrays);
		//assertTrue(Arrays.toString(tabBubble).equals(Arrays.toString(tabArrays))  );
	}

}
