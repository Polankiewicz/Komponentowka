package zad5.Zadanie5;

import static org.junit.Assert.assertEquals;

import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.junit.Test;

import zad2.Zadanie2.*;

public class ReadWriteTest {

	private static Logger logger = Logger.getLogger(ReadWrite.class.getName());

	@Test
	public void testReadWriteText() throws Exception {
		String zapis = "Zapisanie tekstu do pliku \nęóąśłżźćń\n";
		ReadWrite.writeToTextFile(zapis, "plik.txt");

		String odczyt = ReadWrite.readFromTextFile("plik.txt");

		try {
			assertEquals(odczyt, zapis);
		} catch (AssertionError aerr) {
			logger.log(Level.INFO, "Rózna treść", aerr);
		}
	}

	@Test
	public void testReadWriteTextEx() throws Exception {
		String zapis = "Zapisanie tekstu do pliku \nęóąśłżźćń\n";
		ReadWrite.writeToTextFile(zapis, "plik2.txt");

		String odczyt = ReadWrite.readFromTextFile("plik3.txt");

		try {
			assertEquals(odczyt, zapis);
		} catch (AssertionError aerr) {
			logger.log(Level.INFO, "Rózna treść", aerr);
		}
	}

	@Test
	public void testReadWriteTextExc() throws Exception {
		String zapis = "Jakiś \ninny\ntekst";
		ReadWrite.writeToTextFile(zapis, "plik2.txt");

		String odczyt = ReadWrite.readFromTextFile("plik.txt");

		try {
			assertEquals(odczyt, zapis);
		} catch (AssertionError aerr) {
			logger.log(Level.INFO, "Rózna treść", aerr);
		}
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
		Tablice.bubbleSort(tabToSort);

		Arrays.equals(tabToSort, tabArrays);
	}
}
