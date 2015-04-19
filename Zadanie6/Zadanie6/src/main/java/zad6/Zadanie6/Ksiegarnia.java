package zad6.Zadanie6;

import java.util.ArrayList;
import java.util.List;

public class Ksiegarnia implements KsiazkaDao {
	
	List<Ksiazka> ksiazki;
	
	public Ksiegarnia(){
		ksiazki = new ArrayList <Ksiazka>();
		Ksiazka ksiazka1 = new Ksiazka("Księżniczka z lodu", "Camilla Laeckberg", "Kryminał", 0);
		Ksiazka ksiazka2 = new Ksiazka("Kamieniarz", "Camilla Laeckberg", "Kryminał", 1);
		Ksiazka ksiazka3 = new Ksiazka("Niemiecki bękart", "Camilla Laeckberg", "Kryminał", 2);
		Ksiazka ksiazka4 = new Ksiazka("Kaznodzieja", "Camilla Laeckberg", "Kryminał", 3);
		Ksiazka ksiazka5 = new Ksiazka("Ofiara losu", "Camilla Laeckberg", "Kryminał", 4);
		Ksiazka ksiazka6 = new Ksiazka("Latarnik", "Camilla Laeckberg", "Kryminał", 5);
		Ksiazka ksiazka7 = new Ksiazka("Smaki z Fjaellbacki", "Camilla Laeckberg", "Kryminał", 6);
		Ksiazka ksiazka8 = new Ksiazka("Biesiada, jedzenie i miłość", "Camilla Laeckberg", "Kryminał", 7);
		Ksiazka ksiazka9 = new Ksiazka("Pogromca lwów", "Camilla Laeckberg", "Kryminał", 8);
		Ksiazka ksiazka10 = new Ksiazka("Czerwony krąg", "Brandon Webb", "Biografia", 9);
		Ksiazka ksiazka11 = new Ksiazka("Boże igrzysko", "Norman Davis", "Historyczna", 10);
		
		ksiazki.add(ksiazka1);
		ksiazki.add(ksiazka2);
		ksiazki.add(ksiazka3);
		ksiazki.add(ksiazka4);
		ksiazki.add(ksiazka5);
		ksiazki.add(ksiazka6);
		ksiazki.add(ksiazka7);
		ksiazki.add(ksiazka8);
		ksiazki.add(ksiazka9);
		ksiazki.add(ksiazka10);
		ksiazki.add(ksiazka11);
		
	}

	public List<Ksiazka> getAllBooks() {
		return ksiazki;
	}

	public Ksiazka getKsiazka(int ISBN) {
		return ksiazki.get(ISBN);
	}

//	public void updateKsiazka(Ksiazka ksiazka) {
//		ksiazki.get(ksiazka.getISBN()).setAuthor(ksiazka.getAuthor());
//	}

	public void deleteeKsiazka(Ksiazka ksiazka) {
		ksiazki.remove(ksiazka.getISBN());
		
	}
	

}
