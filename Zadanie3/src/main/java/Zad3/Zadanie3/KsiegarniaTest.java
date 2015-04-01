package Zad3.Zadanie3;

import static org.junit.Assert.*;

import org.junit.Test;

public class KsiegarniaTest {

	@Test
	public void testAppendElementAndSize() throws Exception {

		Ksiegarnia ksiegarnia = new Ksiegarnia();
		int sud = ksiegarnia.size();
		assertEquals(11, sud);

		ksiegarnia.appendElement("XXX", "YYY", "ZZZ", 555);
		sud = ksiegarnia.size();
		assertEquals(12, sud);
	}

	@Test(expected=Exception.class)
	public void testRemoveElement() throws Exception {
		throw new Exception();
	}


	@Test
	public void testRemoveElementIndex() throws Exception {
 
 		Ksiegarnia ksiegarnia = new Ksiegarnia();
 		ksiegarnia.removeElement(5);
 		assertEquals(10, ksiegarnia.size());
 	}
 
	@Test
	public void testGetElement() throws Exception {
		
		Ksiegarnia ksiegarnia = new Ksiegarnia();
		Ksiazka ksiazka1 = new Ksiazka("Kaznodzieja", "Camilla Laeckberg", "Kryminał", 15);
		Ksiazka ksiazka2 = ksiegarnia.getElement(3);
		assertEquals(ksiazka1.getTitle(), ksiazka2.getTitle());
		assertEquals(ksiazka1.getAuthor(), ksiazka2.getAuthor());
		assertEquals(ksiazka1.getGenre(), ksiazka2.getGenre());
		assertEquals(ksiazka1.getISBN(), ksiazka2.getISBN());
		
	}

	@Test
	public void testSort() throws Exception {

		Ksiegarnia ksiegarnia = new Ksiegarnia();
		ksiegarnia.print();
		ksiegarnia.sort();
		System.out.println();
		ksiegarnia.print();
		
	}
	
	@Test
	public void testSortComparator() throws Exception {

		Ksiegarnia ksiegarnia = new Ksiegarnia();
		ksiegarnia.print();
		ksiegarnia.sort(new KomparatorISBN());
		System.out.println();
		ksiegarnia.print();
		
	}

}
