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
import java.util.logging.Logger;

//import zad2.Zadanie2.Tablice;




public class ReadWrite {
	
	private static Logger log = Logger.getLogger(ReadWrite.class.getName());

	public static void writeToTextFile(String text, String fileLocation) 
	{
		File plik = new File(fileLocation);
		FileWriter strumienZapisu = null;
		
		try	
		{
			plik.createNewFile();					// Utworzenie pliku pod sciezka zapisana w plik 
			strumienZapisu = new FileWriter(plik);	// Konstrukcja i otwarcie strumienia
			strumienZapisu.write(text);		// Zapis do pliku, (tekstDoZapisania, int, int) - inty okreslaja ilosc znakow, ktore zostana zapisane
			
		}
		catch (IOException e)												
		{
			log.info("IOException");
		}
		catch (Exception e)
		{
			log.info("Exception");
		}
		finally // ??????????????????????????
		{
			try {
				strumienZapisu.close(); 	// Zamkniecie strumienia
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
	public static String readFromTextFile(String file) 
	{
		
		String text = "";
		
		FileReader fileReader;
		
		try
		{
			fileReader = new FileReader(file);
			
			BufferedReader bufferedReader = new BufferedReader(fileReader); 	// Konstrukcja i otwarcie strumienia odczytujacego
			  
			String textLine;
			do 
			{	  
			    textLine = bufferedReader.readLine();
			    
			    if(textLine != null)
			    	text += textLine + "\n";
			    
			} while(textLine != null);

			bufferedReader.close();
		} 
		catch (FileNotFoundException e) 
		{
			log.info("FileNotFoundException");
		}
		catch (IOException e) 
		{
			log.info("IOException");
		}
		  
		return text;
		
	}
	
//	
//	public static int[] tablice(int rozmiar)
//	{
//		int i;
//			
//		
//		// Tablice o dynamicznie ustalanym rozmiarze 
//		rozmiar = 15; //
//		int zakres = 30;
//		int tablica_inna[] =new int[rozmiar];
//				
//		for (i=0; i< rozmiar; i++) {
//			tablica_inna[i] = 20-2*i;
//			System.out.print(tablica_inna[i]+" "); 
//		}
//		
//		System.out.println("");  
//		
//				
//		// Wypelnianie tablicy liczbami losowymi
//			
//		for (i=0; i< rozmiar; i++) 
//			tablica_inna[i] = (int)(Math.random()*20);
//		
//		for (i=0; i< rozmiar; i++)
//			System.out.print(tablica_inna[i]+" "); 
//				
//		System.out.println("");
//			
//		for (i=0; i< rozmiar; i++) {
//			tablica_inna[i] = (int)(Math.random()*zakres);}
//		
//		for (i=0; i< rozmiar; i++)
//			System.out.print(tablica_inna[i]+" "); 
//				
//		System.out.println("");
//		return tablica_inna;
//		
//		
//	}
	
	public static void writeArrayToFile(int[] tab, String file)
	{		
		try 
		{ 
			DataOutputStream strumienTablicy = new DataOutputStream(new FileOutputStream(file));// Strumien zapisujacy liczby  
			for (int i=0; i< tab.length; i++) 
				strumienTablicy.writeInt(tab[i]); 
			strumienTablicy.close();
		} 
		catch (IOException io) 
		{
			log.info("IOException");
		} 
		catch (Exception se) 
		{
			log.info("FileNotFoundException");
		}
	}
	
	public static int[] readArrayFromFile(String file)
	{
		int [] tablica = new int [50];
		try 
		{
			DataInputStream strumienTablicaZPliku = new DataInputStream(new FileInputStream(file)); 
			
			for (int i=0; i< tablica.length; i++) 
			{
				tablica[i] = strumienTablicaZPliku.readInt();
			}
			
			
			strumienTablicaZPliku.close();
		} 
		catch (FileNotFoundException io) 
		{
			log.info("FileNotFoundException");
		} 
		catch (IOException io) 
		{
			log.info("IOException");
		}
		return tablica;
	}
}
