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

	private static Logger logger = Logger.getLogger(ReadWrite.class.getName());
	
	public static void writeToTextFile(String text, String fileLocation)
	{
		File plik = new File(fileLocation);

		try	(FileWriter strumienZapisu = new FileWriter(plik))
		{
			plik.createNewFile();
			strumienZapisu.write(text);
		}
		catch (IOException io)
		{
			logger.log(Level.INFO, "Wyjątek I/O ", io);
		}
		catch (Exception se)
		{
			logger.log(Level.INFO, "Błąd sec ", se);
		}
	}
	
	public static String readFromTextFile(String file)
	{
		String text = "";
		
		try (FileReader fileReader = new FileReader(file); 
				BufferedReader bufferedReader = new BufferedReader(fileReader))
		{
			String textLine;
			
			do 
			{  
			    textLine = bufferedReader.readLine();
			    
			    if(textLine != null)
			    	text += textLine + "\n";
			} 
			while(textLine != null);

		} 
		catch (FileNotFoundException io) 
		{
			logger.log(Level.INFO, "Błąd sec", io);
		}
		catch (IOException io) 
		{
			logger.log(Level.INFO, "Błąd sec", io);
		}
		  
		return text;
	}
	
	public static void writeArrayToFile(int[] tab, String file)
	{			
		try (DataOutputStream strumienTablicy = new DataOutputStream(new FileOutputStream(file)))
		{ 
			for (int i=0; i< tab.length; i++) 
				strumienTablicy.writeInt(tab[i]); 			
		} 
		catch (IOException io) 
		{
			logger.log(Level.INFO, "Wyjątek I/O" , io);
		} 
		catch (Exception se) 
		{
			logger.log(Level.INFO, "Błąd sec" , se);
		}
	}
	
	public static int[] readArrayFromFile(String file)
	{
		int [] tablica = new int [10]; // to trzeba poprawic, tymczasowy rozmiar!!!
		// tablica o znacznie wiekszym rozmiarze niż potrzebny jest brzydka :P
		// no i przy obecnym kodzie bedzie wywalać błędy bo odczytujemy ze strumienia coś co nie istnieje
		
		try (DataInputStream strumienTablicaZPliku = new DataInputStream(new FileInputStream(file)))
		{
			for (int i=0; i< tablica.length; i++) 
				tablica[i] = strumienTablicaZPliku.readInt();
		} 
		catch (FileNotFoundException io) 
		{
			logger.log(Level.INFO, "Błąd pliku", io);
		} 
		catch (IOException io) 
		{
			logger.log(Level.INFO, "Wyjątek I/O", io);
		}
		
		return tablica;
	}
	
}
