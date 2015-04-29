package zad6.Zadanie6;

import org.junit.Test;

public class BookDaoImplTest{

//	@Test
//	public void test() {
//		Serializable original = 
//				Serializable copy = SerializationUtils.clone(original);
//		assertEquals(original, copy);
//	}
	
	@Test
	public void readWriteTest(){
		Ksiegarnia zapis = new Ksiegarnia();
    	BookDaoImpl bookDaoImpl = new BookDaoImpl();
    	
    	bookDaoImpl.writeListToFile(zapis, "plik2.txt");    	
    	Ksiegarnia odczyt = bookDaoImpl.readListFromFile("plik2.txt");
    	
    	zapis.equals(odczyt);
	}
	
	

}
