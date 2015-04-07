package zad2.Zadanie2;

import java.io.PrintStream;

public class Tablice {

	
	
	public static void fillTable(double[] tab, double wartosc)
	{
			// Wypelnianie tablicy takimi samymi wartosciami - parametrem metody jest tablica i wartosc
			for (int i = 0; i < tab.length; i = i + 1) 
				tab[i] = wartosc; 
	}
	
	public static void printTable(PrintStream printStream, double[] tab)
	{
			// Drukowanie zawartosci tablicy - parametrem metody jest PrintStream i tablica
			for (int i=1; i < tab.length; i=i+1) 
				printStream.print(tab[i]+" ");
			printStream.println(""); 
	}
	
	public static void fillTableWithDiffrentValues(double[] tab)
	{
			// Wypelnianie tablicy wartosciami zaleznymi od i - parametrem metody jest tablica
			for (int i=0; i<tab.length; i=i+1) 
				tab[i] = 2*i; 
	}
	
	public static int[] getTab(int rozmiar) throws Exception 
	{
			if(rozmiar <= 0) 
				throw new Exception();
		
			// Zwraca tablice o dynamicznie ustalanym rozmiarze - parametrem jest zadany rozmiar
			int tablica[] = new int[rozmiar];
			for (int i=0; i< rozmiar; i++){
				tablica[i] = 20-2*i;
			} 
			
			return tablica;
	}
	
	public static int[] getTabWithRandValues(int rozmiar) throws Exception
	{
			if(rozmiar <= 0) 
				throw new Exception();
		
			// Zwraca tablice wypełnioną liczbami losowymi - parametrem jest zadany rozmiar
			int tablica[] = new int[rozmiar];
			//Random r = new Random();
			for (int i=0; i < rozmiar; i++)
				tablica[i] = (int)(Math.random()*20);
				//tablica[i] = r.nextInt(100);
			
			return tablica;
	}
	
	public static int[] getTabWithRandValuesFromSomeRange(int rozmiar, int zakres) throws Exception
	{
			if(rozmiar <= 0) 
				throw new Exception();
		
			// Zwraca tablice wypełnioną liczbami losowymi - parametrem jest zadany rozmiar
			int tablica[] = new int[rozmiar];
			for (int i=0; i < rozmiar; i++) 
				tablica[i] = (int)(Math.random()*zakres); 
			
			return tablica;
	}
	
	public static void bubbleSort(int[] tab)
	{
		int zamiany, pomocnicza;
		do
		{
			zamiany=0;
			
			for(int i=0; i<tab.length-1; i++)
			{
				if(tab[i] > tab[i+1])
				{
					pomocnicza= tab[i+1];
					tab[i+1]= tab[i];
					tab[i]= pomocnicza;
					zamiany++;
				}
			}
			
		}
		while(zamiany!=0);
		
		//return tab;
	}
	
}
