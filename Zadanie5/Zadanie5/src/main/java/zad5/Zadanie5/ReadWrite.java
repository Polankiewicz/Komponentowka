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

public class ReadWrite {

	public static void writeToTextFile(String text, String fileLocation) // dodać polskie znaki w kodowaniu i zamknięcia buffora (w catch), załamanie tekstu przy zapisie
	{
		
		File plik = new File(fileLocation);
		
		String tekstDoZapisania = text;

		try	{
			plik.createNewFile();					// Utworzenie pliku pod sciezka zapisana w plik 
			FileWriter strumienZapisu = new FileWriter(plik);	// Konstrukcja i otwarcie strumienia
			strumienZapisu.write(tekstDoZapisania);		// Zapis do pliku, (tekstDoZapisania, int, int) - inty okreslaja ilosc znakow, ktore zostana zapisane
			strumienZapisu.close(); 				// Zamkniecie strumienia
		}

		catch (IOException io)												
			{System.out.println(io.getMessage());}

		catch (Exception se)
			{System.err.println("blad sec");}
		
	}
	
	public static String readFromTextFile(String file) // dodać polskie znaki w kodowaniu i zamknięcia buffora (w catch)
	{
		
		String text = "";
		
		FileReader fileReader;
		try {
			fileReader = new FileReader(file);
			
			BufferedReader bufferedReader = new BufferedReader(fileReader);
			  
			String textLine;// = bufferedReader.readLine();
			do {
			    		  
			    textLine = bufferedReader.readLine();
			    
			    if(textLine != null)
			    	text += textLine + "\n";
			} 
			while(textLine != null);

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
	
//	public static void writeTabToFile(int[] tab, String file)
//	{
//		try { 
//			DataOutputStream strumienTablicy = new DataOutputStream(new FileOutputStream(file));// Strumien zapisujacy liczby  
//			for (int i=0; i< tab.length; i++) strumienTablicy.writeInt(tab[i]); 
//		} 
//		catch (IOException io) {
//			System.out.println(io.getMessage());
//		} 
//		catch (Exception se) {
//			System.err.println("blad sec");
//		}
//	}
	
//	public static String readTabFromFile(String file)
//	{
//		int [] tab;
//		try {
//			DataInputStream strumienTablicaZPliku = new DataInputStream(new FileInputStream(file)); 
//			for (int i=0; i< rozmiar; i++) tab[i] = strumienTablicaZPliku.readInt();
//		} 
//		catch (FileNotFoundException io) {
//			System.out.println(io.getMessage());
//		} 
//		catch (IOException io) {
//			System.out.println(io.getMessage());
//		}
//		return tab;
//	}
	
	
}
