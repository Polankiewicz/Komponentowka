package zad6.Zadanie6;

import zad6.Zadanie6.exceptions.MyExceptions;


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
    	//ksiegarniaOdczyt.print();
    	
    	
//    	
//    	Ksiazka ksiazka1 = new Ksiazka("", "", "", 0);
//    	Ksiazka ksiazka2 = (Ksiazka) ksiazka1.clone();
//    	
    	MyExceptions myExceptions = new MyExceptions();
    	myExceptions.testExceptions();
    }
}
