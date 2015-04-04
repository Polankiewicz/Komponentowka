package Zad4.Zad4;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Ksiegarnia {
	
	private List<Ksiazka> ksiazki = new ArrayList<Ksiazka>();
	
	public Ksiegarnia()
	{
		ksiazki.add(new Ksiazka("Księżniczka z lodu", "Camilla Laeckberg", "Kryminał", 10));
		ksiazki.add(new Ksiazka("Kamieniarz", "Camilla Laeckberg", "Kryminał", 11));
		ksiazki.add(new Ksiazka("Niemiecki bękart", "Camilla Laeckberg", "Kryminał", 12));
		ksiazki.add(new Ksiazka("Kaznodzieja", "Camilla Laeckberg", "Kryminał", 15));
		ksiazki.add(new Ksiazka("Ofiara losu", "Camilla Laeckberg", "Kryminał", 20));
		ksiazki.add(new Ksiazka("Latarnik", "Camilla Laeckberg", "Kryminał", 19));
		ksiazki.add(new Ksiazka("Smaki z Fjaellbacki", "Camilla Laeckberg", "Kryminał", 33));
		ksiazki.add(new Ksiazka("Biesiada, jedzenie i miłość", "Camilla Laeckberg", "Kryminał", 45));
		ksiazki.add(new Ksiazka("Pogromca lwów", "Camilla Laeckberg", "Kryminał", 156));
		ksiazki.add(new Ksiazka("Czerwony krąg", "Brandon Webb", "Biografia", 125));
		ksiazki.add(new Ksiazka("Boże igrzysko", "Norman Davis", "Historyczna", 97));
	}
	
	public void appendElement(String tytul, String autor, String gatunek, int ISBN)
	{
		ksiazki.add(new Ksiazka(tytul, autor, gatunek, ISBN));
	}
	
	public void removeElement(int x) throws Exception
	{
		if(x < 0 || x >= ksiazki.size()) throw new Exception();
		
		ksiazki.remove(x);
	}
	
	public Ksiazka getElement(int x) throws Exception
	{
		if(x < 0 || x >= ksiazki.size()) throw new Exception();
		
		return ksiazki.get(x);
	}
	
	public int size()
	{
		return ksiazki.size();
	}
	
	public void sort()
	{
		Collections.sort(ksiazki);
	}
	
	public void sort(Comparator<Ksiazka> x)
	{
		Collections.sort(ksiazki, x);
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
		if (ISBN == 0) { return k1.compareTo(k2); }
		return ISBN;
	}
}
