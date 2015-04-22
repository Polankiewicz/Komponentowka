package zad3a.zad3a;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class KsiegarniaTest {

	Ksiegarnia ksiegarnia;
	
	@Before
	public void init()
	{
		ksiegarnia = new Ksiegarnia();
	}
	
	
	@Test
	public void testAppendElementAndSize() throws Exception {

		int sud = ksiegarnia.size();
		assertEquals(11, sud);

		ksiegarnia.appendElement("XXX", "YYY", "ZZZ", 555);
		sud = ksiegarnia.size();
		assertEquals(12, sud);
	}

	@Test(expected=Exception.class)
	public void testRemoveElementMinusValues() throws Exception {

		ksiegarnia.removeElement(-2);
	}

	@Test(expected=Exception.class)
	public void testRemoveElementOverRange() throws Exception {

		ksiegarnia.removeElement(15);
	}

	@Test
	public void testRemoveElementIndex() throws Exception {
 
 		ksiegarnia.removeElement(5);
 		assertEquals(10, ksiegarnia.size());
 	}
 
	@Test
	public void testGetElement() throws Exception {
		
		Ksiazka ksiazka1 = new Ksiazka("Kaznodzieja", "Camilla Laeckberg", "Krymina³", 15);
		Ksiazka ksiazka2 = ksiegarnia.getElement(3);
		assertEquals(ksiazka1.getTitle(), ksiazka2.getTitle());
		assertEquals(ksiazka1.getAuthor(), ksiazka2.getAuthor());
		assertEquals(ksiazka1.getGenre(), ksiazka2.getGenre());
		assertEquals(ksiazka1.getISBN(), ksiazka2.getISBN());
		
	}

	@Test(expected=Exception.class)
	public void testGetElementMinusValue() throws Exception {
		
		//Ksiazka ksiazka = 
				ksiegarnia.getElement(-3);
	}
	
	@Test(expected=Exception.class)
	public void testGetElementOverRange() throws Exception {
		
		//Ksiazka ksiazka = 
				ksiegarnia.getElement(15);
	}
	
	@Test
	public void testSortComparator() throws Exception {

		ksiegarnia.print();
		ksiegarnia.sort(new KomparatorISBN());
		System.out.println();
		ksiegarnia.print();
		
		
		for(int i=0; i < ksiegarnia.size()-1; i++)
		{
			if(ksiegarnia.getElement(i).getISBN() < ksiegarnia.getElement(i+1).getISBN()) {}
			else System.out.println("B³¹d w sortowaniu za pomoc¹ komparatora");
		}
	}

}
