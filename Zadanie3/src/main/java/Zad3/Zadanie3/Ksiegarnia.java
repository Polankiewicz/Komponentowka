package Zad3.Zadanie3;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Ksiegarnia {

	public static void main( String[] args )
	{
	    //System.out.println( "Hello World!" );
		
		Ksiegarnia main = new Ksiegarnia();
		main.program();
	}
	
	private void program()
	{
		List<Ksiazka> ksiazki = new ArrayList<Ksiazka>();
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
		
		
		System.out.println("\nNieposortowana lista: ");
		for(Ksiazka ksiazka : ksiazki)
		{
			System.out.println(ksiazka);
		}
		
		
		Collections.sort(ksiazki);
		 
	    System.out.println("\nPosortowana lista: ");
	    for(Ksiazka ksiazka : ksiazki) 
	    {
	        System.out.println(ksiazka);
	    }
	    
	    
	    Collections.sort(ksiazki, new KomparatorISBN());
	    
	    System.out.println("\nPosortowane wg numeru ISBN: ");
	    for(Ksiazka ksiazka : ksiazki) 
	    {
	        System.out.println(ksiazka);
	    }
	    
	}
	
	private class KomparatorISBN implements Comparator<Ksiazka>
	{
		public int compare(Ksiazka k1, Ksiazka k2)
		{
			int ISBN = k1.getISBN() - k2.getISBN();
			if (ISBN == 0) { return k1.compareTo(k2); }
			return ISBN;
		}
	}
}