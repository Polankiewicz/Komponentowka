package zad6.Zadanie6;

import org.junit.Test;

import zad6.Zadanie6.exceptions.MyException;
import zad6.Zadanie6.exceptions.MyRunetimeException;

public class BookDaoImplTest{
	
	@Test
	public void readWriteTest() throws MyRunetimeException, MyException{
		Ksiegarnia zapis = new Ksiegarnia();
    	BookDaoImpl bookDaoImpl = new BookDaoImpl();
    	
    	bookDaoImpl.writeListToFile(zapis, "plik2.txt");    	
    	Ksiegarnia odczyt = bookDaoImpl.readListFromFile("plik2.txt");
    	
    	zapis.equals(odczyt);
	}
	
	@Test
	public void readWriteTestEx() throws MyRunetimeException{
		Ksiegarnia zapis = new Ksiegarnia();
    	BookDaoImpl bookDaoImpl = new BookDaoImpl();
    	
    	bookDaoImpl.writeListToFile(zapis, "plik2.txt");    	
    	Ksiegarnia odczyt = bookDaoImpl.readListFromFile("plik5.txt");
    	
    	zapis.equals(odczyt);
	}
}
