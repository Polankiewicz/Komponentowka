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
import java.util.logging.Level;
import java.util.logging.Logger;


public class ReadWrite {

	public static void writeToTextFile(String text, String fileLocation)
	{
		File plik = new File(fileLocation);
		String tekstDoZapisania = text;

		try	
		{
			plik.createNewFile();
			FileWriter strumienZapisu = new FileWriter(plik);
			strumienZapisu.write(tekstDoZapisania);
			strumienZapisu.close();
		}
		catch (IOException io)
		{
			Logger.getLogger("default").log(Level.INFO, "Wyjątek I/O ", io);
		}
		catch (Exception se)
		{
			Logger.getLogger("default2").log(Level.SEVERE, "Błąd sec ", se);
		}
	}
	
	public static String readFromTextFile(String file)
	{
		String text = "";
		FileReader fileReader;
		
		try
		{
			fileReader = new FileReader(file);
			BufferedReader bufferedReader = new BufferedReader(fileReader);
			String textLine;
			
			do 
			{  
			    textLine = bufferedReader.readLine();
			    
			    if(textLine != null)
			    	text += textLine + "\n";
			} 
			while(textLine != null);

			bufferedReader.close();
		} 
		catch (FileNotFoundException fexc) 
		{
			Logger.getLogger("default3").log(Level.SEVERE, "Błąd sec", fexc);
		}
		catch (IOException iexc) 
		{
			Logger.getLogger("default4").log(Level.SEVERE, "Błąd sec", iexc);
		}
		  
		return text;
	}
	
	public static void writeArrayToFile(int[] tab, String file)
	{			
		try 
		{ 
			DataOutputStream strumienTablicy = new DataOutputStream(new FileOutputStream(file));
			
			for (int i=0; i< tab.length; i++) 
				strumienTablicy.writeInt(tab[i]); 
			
			strumienTablicy.close();
		} 
		catch (IOException io) 
		{
			Logger.getLogger("default").log(Level.INFO, "Wyjątek I/O" , io);
		} 
		catch (Exception se) 
		{
			Logger.getLogger("default").log(Level.SEVERE, "Błąd sec" , se);
		}
	}
	
	public static int[] readArrayFromFile(String file)
	{
		int [] tablica = new int [10]; // to trzeba poprawic, tymczasowy rozmiar!!!
		// tablica o znacznie wiekszym rozmiarze niż potrzebny jest brzydka :P
		// no i przy obecnym kodzie bedzie wywalać błędy bo odczytujemy ze strumienia coś co nie istnieje
		
		try 
		{
			DataInputStream strumienTablicaZPliku = new DataInputStream(new FileInputStream(file)); 
			
			for (int i=0; i< tablica.length; i++) 
				tablica[i] = strumienTablicaZPliku.readInt();
			
			strumienTablicaZPliku.close();
		} 
		catch (FileNotFoundException fnex) 
		{
			Logger.getLogger("default").log(Level.INFO, "Błąd pliku", fnex);
		} 
		catch (IOException io) 
		{
			Logger.getLogger("default").log(Level.INFO, "Wyjątek I/O", io);
		}
		
		return tablica;
	}
	
}
