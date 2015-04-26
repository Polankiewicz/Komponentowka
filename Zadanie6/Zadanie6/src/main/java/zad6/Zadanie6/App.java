package zad6.Zadanie6;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;


/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args ) throws CloneNotSupportedException
    {
    	Ksiegarnia ksiegarniaZapis = new Ksiegarnia();
    	BookDaoImpl bookDaoImpl = new BookDaoImpl();
    	
    	bookDaoImpl.writeListToFile(ksiegarniaZapis, "plik.txt");    	
    	Ksiegarnia ksiegarniaOdczyt = bookDaoImpl.readListFromFile("plik.txt");
    	ksiegarniaOdczyt.print();
    	
    	
//    	
//    	Ksiazka ksiazka1 = new Ksiazka("", "", "", 0);
//    	Ksiazka ksiazka2 = (Ksiazka) ksiazka1.clone();
//    	
//    	MyExceptions myExceptions = new MyExceptions();
//    	myExceptions.testExceptions();
    }
}
