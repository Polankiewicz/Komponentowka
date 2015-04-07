package zad5.Zadanie5;

import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import zad2.Zadanie2.Tablice;




public class ReadWrite {

	public static void writeToTextFile(String text, String fileLocation) // dodać polskie znaki w kodowaniu i zamknięcia buffora (w catch), załamanie tekstu przy zapisie
	{
		
		File plik = new File(fileLocation);
		
		String tekstDoZapisania = text;

		try	
		{
			plik.createNewFile();					// Utworzenie pliku pod sciezka zapisana w plik 
			FileWriter strumienZapisu = new FileWriter(plik);	// Konstrukcja i otwarcie strumienia
			strumienZapisu.write(tekstDoZapisania);		// Zapis do pliku, (tekstDoZapisania, int, int) - inty okreslaja ilosc znakow, ktore zostana zapisane
			strumienZapisu.close(); 				// Zamkniecie strumienia
		}

		catch (IOException io)												
		{
			System.out.println(io.getMessage());
		}

		catch (Exception se)
		{
			System.err.println("blad sec");
		}
	}
	
	public static String readFromTextFile(String file) // dodać polskie znaki w kodowaniu i zamknięcia buffora (w catch)
	{
		
		String text = "";
		
		FileReader fileReader;
		
		try
		{
			fileReader = new FileReader(file);
			
			BufferedReader bufferedReader = new BufferedReader(fileReader); 	// Konstrukcja i otwarcie strumienia odczytujacego
			  
			String textLine;// = bufferedReader.readLine();
			do 
			{
			    		  
			    textLine = bufferedReader.readLine();  // Odczytanie znakow od 0 do 7 ze strumienia do bufora
			    
			    if(textLine != null)
			    	text += textLine + "\n";
			    
			} while(textLine != null);

			bufferedReader.close();
			
		} 
		catch (FileNotFoundException e) 
		{
			e.printStackTrace();
		}
		catch (IOException e) 
		{
			e.printStackTrace();
		}
		  
		return text;
		
	}
	
//	int zakres = 30;	
//	int i; 
//	int rozmiar = 15; 
//	int tab[] = new int[rozmiar];
	
	public static int[] tablice(int rozmiar)
	{
		int i;
			
		
		// Tablice o dynamicznie ustalanym rozmiarze 
		rozmiar = 15; //
		int zakres = 30;
		int tablica_inna[] =new int[rozmiar];
				
		for (i=0; i< rozmiar; i++) {
			tablica_inna[i] = 20-2*i;
			System.out.print(tablica_inna[i]+" "); 
		}
		
		System.out.println("");  
		
				
		// Wypelnianie tablicy liczbami losowymi
			
		for (i=0; i< rozmiar; i++) 
			tablica_inna[i] = (int)(Math.random()*20);
		
		for (i=0; i< rozmiar; i++)
			System.out.print(tablica_inna[i]+" "); 
				
		System.out.println("");
			
		for (i=0; i< rozmiar; i++) {
			tablica_inna[i] = (int)(Math.random()*zakres);}
		
		for (i=0; i< rozmiar; i++)
			System.out.print(tablica_inna[i]+" "); 
				
		System.out.println("");
		return tablica_inna;
		
		
	}
	
	public static void writeArrayToFile(int[] tab, String file)
	{		
		File plik = new File(file);
		int[] tablica = tab;
		
//		int rozmiar = 0;
		//int[] tab1;
			
		
		try 
		{ 
			//tab = Tablice.getTabWithRandValues(20);
			
			DataOutputStream strumienTablicy = new DataOutputStream(new FileOutputStream(file));// Strumien zapisujacy liczby  
			for (int i=0; i< tab.length; i++) 
				strumienTablicy.writeInt(tab[i]); 
			strumienTablicy.close();
		} 
		catch (IOException io) 
		{
			System.out.println(io.getMessage());
		} 
		catch (Exception se) 
		{
			System.err.println("blad sec");
		}
	}
	
	public static int[] readArrayFromFile(String file)
	{
		int [] tablica = new int [50] ;
		try 
		{
			DataInputStream strumienTablicaZPliku = new DataInputStream(new FileInputStream(file)); 
			for (int i=0; i< tablica.length; i++) tablica[i] = strumienTablicaZPliku.readInt();
			
			
			strumienTablicaZPliku.close();
		} 
		catch (FileNotFoundException io) 
		{
			System.out.println(io.getMessage());
		} 
		catch (IOException io) 
		{
			System.out.println(io.getMessage());
		}
		return tablica;
	}
}
