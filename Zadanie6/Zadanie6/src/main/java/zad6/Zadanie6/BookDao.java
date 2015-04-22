package zad6.Zadanie6;

import java.util.List;

import Zad4.Zadanie4.*;

public interface BookDao {

	public void writeListToFile(List<Ksiazka> list, String file);
	public List<Ksiazka> readListFromFile(String file);
	public void printList(List<Ksiazka> list);
	
}
