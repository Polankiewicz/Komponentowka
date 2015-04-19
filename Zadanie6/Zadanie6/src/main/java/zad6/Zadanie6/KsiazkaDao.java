package zad6.Zadanie6;

import java.util.List;

public interface KsiazkaDao {
	
	public List <Ksiazka> getAllBooks();
	public Ksiazka getKsiazka(int ISBN);
	//public void updateKsiazka(Ksiazka ksiazka);
	public void deleteeKsiazka(Ksiazka ksiazka);

}
