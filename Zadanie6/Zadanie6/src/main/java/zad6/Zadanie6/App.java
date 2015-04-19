package zad6.Zadanie6;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.logging.Level;
import java.util.logging.Logger;


/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        KsiazkaDao ksiazkaDao = new Ksiegarnia();
        
        //wyswietlenie wszystkich ksiazek
        for(Ksiazka ksiazka : ksiazkaDao.getAllBooks())
		{
			System.out.println("Książka: Tytuł: " + ksiazka.getTitle()
					+ " Autor: " + ksiazka.getAuthor()
					+ " Gatunek: " + ksiazka.getGenre()
					+ " ISBN: " + ksiazka.getISBN());
		}
        
//        //aktualizacja ksiazki
//        Ksiazka ksiazka = ksiazkaDao.getAllBooks().get(10);
//        ksiazka.setAuthor("Norman Davies");
//        ksiazkaDao.updateKsiazka(ksiazka);

        //wyswietlenie konkretnej ksiazki
        Ksiazka ksiazka = ksiazkaDao.getAllBooks().get(0);
        ksiazkaDao.getKsiazka(10);
        System.out.println("\nKsiążka: Tytuł: " + ksiazka.getTitle()
				+ " Autor: " + ksiazka.getAuthor()
				+ " Gatunek: " + ksiazka.getGenre()
				+ " ISBN: " + ksiazka.getISBN());
        
        
        try{
        	//utworzenie nowego pliku z ObjectOutputStream
        	FileOutputStream out = new FileOutputStream("test.txt");
        	ObjectOutputStream output = new ObjectOutputStream (out);
        	
        	//wpisanie do pliku
        	output.writeObject(ksiazkaDao.getKsiazka(0));
//        	output.writeObject(ksiazkaDao.getKsiazka(1));
//        	output.writeObject(ksiazkaDao.getKsiazka(2));
//        	output.writeObject(ksiazkaDao.getKsiazka(3));
//        	output.writeObject(ksiazkaDao.getKsiazka(4));
//        	output.writeObject(ksiazkaDao.getKsiazka(5));
//        	output.writeObject(ksiazkaDao.getKsiazka(6));
//        	output.writeObject(ksiazkaDao.getKsiazka(7));
//        	output.writeObject(ksiazkaDao.getKsiazka(8));
//        	output.writeObject(ksiazkaDao.getKsiazka(9));
//        	output.writeObject(ksiazkaDao.getKsiazka(10));
        	output.flush();
        	output.close();
        	
        	//utworzenie ObjectInputStream z wczesniej utworzonego pliku
        	ObjectInputStream input = new ObjectInputStream(new FileInputStream("test.txt"));
        	
        	//odczytanie i wyswietlenie
        	System.out.println("" + (KsiazkaDao)input.readObject());
        	
        	KsiazkaDao read = (KsiazkaDao)input.readObject();
        	//KsiazkaDao k2 = new KsiazkaDao(read);
        	//System.out.println("" + k2);
        	input.close();
        	
        }
        catch (RuntimeException exc)
        {
        	Logger.getLogger("default").log(Level.SEVERE, "Wyjątek w czasie działania" + ksiazkaDao, exc);
        	
        }
        catch (Exception ex)
        {
        	ex.printStackTrace();
        }
        
    }
}
