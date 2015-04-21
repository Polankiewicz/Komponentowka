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
import java.io.RandomAccessFile;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ReadWrite {

	private static Logger logger = Logger.getLogger(ReadWrite.class.getName());

	public static void writeToTextFile(String text, String fileLocation) {
		File plik = new File(fileLocation);

		try (FileWriter strumienZapisu = new FileWriter(plik)) {
			plik.createNewFile();
			strumienZapisu.write(text);
		} catch (IOException io) {
			logger.log(Level.INFO, "Wyjątek I/O ", io);
		} catch (Exception se) {
			logger.log(Level.INFO, "Błąd sec ", se);
		}
	}

	public static String readFromTextFile(String file) {
		String text = "";

		try (FileReader fileReader = new FileReader(file);
				BufferedReader bufferedReader = new BufferedReader(fileReader)) {
			String textLine;

			do {
				textLine = bufferedReader.readLine();

				if (textLine != null)
					text += textLine + "\n";
			} while (textLine != null);

		} catch (FileNotFoundException io) {
			logger.log(Level.INFO, "Błąd sec", io);
		} catch (IOException io) {
			logger.log(Level.INFO, "Błąd sec", io);
		}

		return text;
	}

	public static void writeArrayToFile(int[] tab, String file) {
		try (DataOutputStream strumienTablicy = new DataOutputStream(
				new FileOutputStream(file))) {
			for (int i = 0; i < tab.length; i++)
				strumienTablicy.writeInt(tab[i]);
		} catch (IOException io) {
			logger.log(Level.INFO, "Wyjątek I/O", io);
		} catch (Exception se) {
			logger.log(Level.INFO, "Błąd sec", se);
		}
	}

	public static int[] readArrayFromFile(String file) {
		

//		RandomAccessFile raf = new RandomAccessFile(file, "rw");
//		rozm = raf.length();
//
//		Integer k = (int) (long) rozm;
//
//		int[] tablica = new int[k];

		// to trzeba poprawic, tymczasowy rozmiar!!!
		// tablica o znacznie wiekszym rozmiarze niż potrzebny jest brzydka :P
		// no i przy obecnym kodzie bedzie wywalać błędy bo odczytujemy ze
		// strumienia coś co nie istnieje

//		try (
//				DataInputStream strumienTablicaZPliku = new DataInputStream(
//				new FileInputStream(file))) {
//			for (int i = 0; i < tablica.length; i++)
//				tablica[i] = strumienTablicaZPliku.readInt();
//		} catch (FileNotFoundException io) {
//			logger.log(Level.INFO, "Błąd pliku", io);
//		} catch (IOException io) {
//			logger.log(Level.INFO, "Wyjątek I/O", io);
//		}

		// return tablica;

		RandomAccessFile fis = null;
		int []tablica = null;
		
		// OTWIERANIE PLIKU:
		try 
		{
			fis = new RandomAccessFile(file, "rw");
		} 
		catch (FileNotFoundException e) 
		{
			System.out.println("BŁĄD!!! Nie znaleziono pliku...");
			System.exit(1);
		}
		
		
		long rozm;
		
		//ODCZYT
		try 
		{
			rozm = fis.length();
			
			Integer k = (int) (long) rozm / 4;
			
			tablica = new int[k];
			
			for (int i = 0; i < k; i++)
			{
				tablica[i] = fis.readInt();
				System.out.println("Tablica z pliku: " + tablica[i] + " ");
			}
		} 
		catch (FileNotFoundException io) {
			logger.log(Level.INFO, "Błąd pliku", io);
		} catch (IOException io) {
			logger.log(Level.INFO, "Wyjątek I/O", io);
		}
		
		
		// ZAMYKANIE PLIKU:
		try 
		{
			fis.close();
		} 
		catch (IOException e) 
		{
			e.printStackTrace();
		}
		
		return tablica;
	}
}