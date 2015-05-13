package zad6.Zadanie6;

import zad6.Zadanie6.exceptions.MyException;
import zad6.Zadanie6.exceptions.MyRunetimeException;


public interface BookDao {

	public void writeListToFile(Ksiegarnia ksiegarnia, String file) throws MyRunetimeException;
	public Ksiegarnia readListFromFile(String file) throws MyRunetimeException;
}
