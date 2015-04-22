package zad6.Zadanie6;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import Zad4.Zadanie4.Ksiazka;
import Zad4.Zadanie4.Ksiegarnia;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
    	Ksiegarnia ksiegarnia = new Ksiegarnia();
    	List<Ksiazka> listaKsiazek = new ArrayList<Ksiazka>();
    	List<Ksiazka> listaKsiazek2 = new ArrayList<Ksiazka>();
    	listaKsiazek = ksiegarnia.getList();
    	
    	
    	BookDaoImpl bookDaoImpl = new BookDaoImpl();
    	bookDaoImpl.writeListToFile(listaKsiazek, "plik.txt");
    	listaKsiazek2 = bookDaoImpl.readListFromFile("plik.txt");
    	bookDaoImpl.printList(listaKsiazek2);
    	
    }
}
