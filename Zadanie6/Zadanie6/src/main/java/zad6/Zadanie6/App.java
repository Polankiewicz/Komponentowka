package zad6.Zadanie6;


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
        System.out.println("Książka: Tytuł: " + ksiazka.getTitle()
				+ " Autor: " + ksiazka.getAuthor()
				+ " Gatunek: " + ksiazka.getGenre()
				+ " ISBN: " + ksiazka.getISBN());
        
    }
}
