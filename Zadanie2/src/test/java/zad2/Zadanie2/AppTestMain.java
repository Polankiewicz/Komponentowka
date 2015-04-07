package zad2.Zadanie2;

import org.junit.Test;

public class AppTestMain {

	@Test
	public void testMain() throws Exception {
		String []x = new String[]  {"5", "7.5", "8"};
		String []y = new String[]  {"5", "7"};
		String []z = new String[]  {"5", "7", "+", "heh"};
		
		System.out.println("-----3 argumenty------");
		App.main(x);
		
		System.out.println("-----2 argumenty------");
		App.main(y);

		System.out.println("-----4 argumenty------");
		App.main(z);
		
		
	}

}
