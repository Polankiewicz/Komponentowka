package zad2.Zadanie2;

import static org.junit.Assert.*;

import java.io.PrintStream;
import java.util.Arrays;
import java.util.Date;

import org.junit.Test;

public class TabliceTest {

	@Test
	public void testBubbleSortAndArraysSort() throws Exception {

		int[] tabBubble = Tablice.getTabWithRandValues(10), tabArrays = tabBubble.clone();
		
		Tablice.bubbleSort(tabBubble);
		Arrays.sort(tabArrays);
		assertTrue(Arrays.toString(tabBubble).equals(Arrays.toString(tabArrays))  );
	}
	
	@Test
	public void testSort10() throws Exception {

		int[] tabBubble = Tablice.getTabWithRandValues(10), tabArrays = tabBubble.clone();
		System.out.println("-----10 elementów-----");
		System.out.println(Arrays.toString(tabBubble));
		
		Date przed1 = new Date();
		Tablice.bubbleSort(tabBubble);
		System.out.println(Arrays.toString(tabBubble));
		Date po1 = new Date();
		System.out.println("Czas sortowania babelkowego "+(po1.getTime() - przed1.getTime()) +"ms");
		
		Date przed2 = new Date();
		Arrays.sort(tabArrays);
		System.out.println(Arrays.toString(tabArrays));
		Date po2 = new Date();
		System.out.println("Czas sortowania przy pomocy klasy Arrays "+(po2.getTime() - przed2.getTime()) +"ms");
		System.out.println();
	}

	@Test
	public void testSort1000() throws Exception {

		int[] tabBubble = Tablice.getTabWithRandValues(1000), tabArrays = tabBubble.clone();
		System.out.println("-----1000 elementów-----");
		System.out.println(Arrays.toString(tabBubble));
		
		Date przed1 = new Date();
		Tablice.bubbleSort(tabBubble);
		System.out.println(Arrays.toString(tabBubble));
		Date po1 = new Date();
		System.out.println("Czas sortowania babelkowego "+(po1.getTime() - przed1.getTime()) +"ms");
		
		Date przed2 = new Date();
		Arrays.sort(tabArrays);
		System.out.println(Arrays.toString(tabArrays));
		Date po2 = new Date();
		System.out.println("Czas sortowania przy pomocy klasy Arrays "+(po2.getTime() - przed2.getTime()) +"ms");
		System.out.println();
	}
	
	@Test
	public void testSort30000() throws Exception {

		int[] tabBubble = Tablice.getTabWithRandValues(30000), tabArrays = tabBubble.clone();
		System.out.println("-----30000 elementów-----");
		//System.out.println(Arrays.toString(tabBubble));
		
		Date przed1 = new Date();
		Tablice.bubbleSort(tabBubble);
		//System.out.println(Arrays.toString(tabBubble));
		Date po1 = new Date();
		System.out.println("Czas sortowania babelkowego "+(po1.getTime() - przed1.getTime()) +"ms");
		
		Date przed2 = new Date();
		Arrays.sort(tabArrays);
		//System.out.println(Arrays.toString(tabArrays));
		Date po2 = new Date();
		System.out.println("Czas sortowania przy pomocy klasy Arrays "+(po2.getTime() - przed2.getTime()) +"ms");
		System.out.println();
	}

	@Test
	public void testFillTable() throws Exception {
		double []tab = new double[4];
		double []tab2 = new double[] {5.0, 5.0, 5.0, 5.0};
		Tablice.fillTable(tab, 5.0);
		//System.out.println(Arrays.toString(tab));
		assertTrue(Arrays.toString(tab).equals(Arrays.toString(tab2))  );
	}

	@Test
	public void testFillTableWithDiffrentValues() throws Exception {
		double []tab = new double[4];
		double []tab2 = new double[] {0.0, 2.0, 4.0, 6.0};
		Tablice.fillTableWithDiffrentValues(tab);
		//System.out.println(Arrays.toString(tab));
		assertTrue(Arrays.toString(tab).equals(Arrays.toString(tab2))  );
	}

	@Test
	public void testGetTab() throws Exception {
		int []tab = Tablice.getTab(4);
		int []tab2 = new int[] {20, 18, 16, 14};
		//System.out.println(Arrays.toString(tab));
		assertTrue(Arrays.toString(tab).equals(Arrays.toString(tab2))  );
	}
	
	@Test(expected=Exception.class)
	public void testGetTabNegativeArraySize() throws Exception {
		int []tab = Tablice.getTab(-4);
		tab = Tablice.getTab(0);
	}

	@Test
	public void testGetTabWithRandValues() throws Exception {
		int[] tab = Tablice.getTabWithRandValues(10);
		int[] tab2 = Tablice.getTabWithRandValues(10);
		assertFalse(Arrays.toString(tab).equals(Arrays.toString(tab2))  );
	}

	@Test
	public void testGetTabWithRandValuesFromSomeRange() throws Exception {
		int[] tab = Tablice.getTabWithRandValuesFromSomeRange(10,5);
		int[] tab2 = Tablice.getTabWithRandValuesFromSomeRange(10,5);
		assertFalse(Arrays.toString(tab).equals(Arrays.toString(tab2))  );
	}

	@Test
	public void testPrintTable() throws Exception {
		double[] tab = new double[5];
		Tablice.fillTableWithDiffrentValues(tab);
		
		Tablice.printTable(new PrintStream("plik") ,tab);
		
	}

}
