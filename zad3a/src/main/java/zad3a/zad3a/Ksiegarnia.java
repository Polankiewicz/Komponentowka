package zad3a.zad3a;

import java.util.Arrays;
import java.util.Comparator;

import org.apache.commons.lang3.ArrayUtils;
import zad3a.zad3a.Ksiazka;


public class Ksiegarnia {
		
	private Ksiazka[] ksiazki = new Ksiazka[20];
	
	
    public Ksiegarnia() 
    {       	
    	ksiazki = new Ksiazka[11];
    	
    	ksiazki[0] = new Ksiazka("Ksiê¿niczka z lodu", "Camilla Laeckberg", "Krymina³", 10);
		ksiazki[1] = new Ksiazka("Kamieniarz", "Camilla Laeckberg", "Krymina³", 11);
		ksiazki[2] = new Ksiazka("Niemiecki bêkart", "Camilla Laeckberg", "Krymina³", 12);
		ksiazki[3] = new Ksiazka("Kaznodzieja", "Camilla Laeckberg", "Krymina³", 15);
		ksiazki[4] = new Ksiazka("Ofiara losu", "Camilla Laeckberg", "Krymina³", 20);
		ksiazki[5] = new Ksiazka("Latarnik", "Camilla Laeckberg", "Krymina³", 19);
		ksiazki[6] = new Ksiazka("Smaki z Fjaellbacki", "Camilla Laeckberg", "Krymina³", 33);
		ksiazki[7] = new Ksiazka("Biesiada, jedzenie i mi³oœæ", "Camilla Laeckberg", "Krymina³", 45);
		ksiazki[8] = new Ksiazka("Pogromca lwów", "Camilla Laeckberg", "Krymina³", 156);
		ksiazki[9] = new Ksiazka("Czerwony kr¹g", "Brandon Webb", "Biografia", 125);
		ksiazki[10] = new Ksiazka("Bo¿e igrzysko", "Norman Davis", "Historyczna", 97);
    	
	}
	
	public void appendElement(String tytul, String autor, String gatunek, int ISBN)
	{
		int size = ksiazki.length;
		ksiazki = Arrays.copyOf(ksiazki, size + 1);
		ksiazki[size] = new Ksiazka(tytul, autor, gatunek, ISBN);
	}
	
	public void removeElement(int x) throws Exception
	{
		if(x < 0 || x >= ksiazki.length) throw new Exception();
		
		ksiazki = ArrayUtils.remove(ksiazki, x);
	}
	
	public Ksiazka getElement(int x) throws Exception
	{
		if(x < 0 || x >= ksiazki.length) throw new Exception();
		
		return ksiazki[x];
	}
	
	public int size()
	{
		return ksiazki.length;
	}
	
	public void sort()
	{
		Arrays.sort(ksiazki);
	}
	
	public void sort(Comparator<Ksiazka> x)
	{
		Arrays.sort(ksiazki, x);
	}
	
	public void print()
	{
		for(Ksiazka ksiazka : ksiazki)
		{
			System.out.println(ksiazka);
		}    
	}
}


class KomparatorISBN implements Comparator<Ksiazka>
{
	public int compare(Ksiazka k1, Ksiazka k2)
	{
		int ISBN = k1.getISBN() - k2.getISBN();
		if (ISBN == 0)  return k1.compareTo(k2); 
		return ISBN;
	}
}
