package zad5.Zadanie5;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.File;
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

		int []tablica = null;
		
		// OTWIERANIE PLIKU:
		try (RandomAccessFile fis = new RandomAccessFile(file, "rw");)
		{
			Integer k = (int) (long) fis.length() / 4;
			
			tablica = new int[k];
			
			//SCZYTYWANIE
			for (int i = 0; i < k; i++)
			{
				tablica[i] = fis.readInt();
				System.out.println("Tablica z pliku: " + tablica[i] + " ");
			}
			
			//ZAMKNIECIE
			fis.close();
		} 
		catch (FileNotFoundException io) {
			logger.log(Level.INFO, "Błąd pliku", io);
		} catch (IOException io) {
			logger.log(Level.INFO, "Wyjątek I/O", io);
		}
		return tablica;
	}
}