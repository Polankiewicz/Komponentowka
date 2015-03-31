package zad3a.zad3a;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;


public class Ksiegarnia {
	
	
	public String[][] tab;
	public String[][] tab2;
	
	
	
//	private int[] testtab = {1};
//    private int[] testowa;
//    private int suma = 0;
	
    
	public String[][] getTab()
	{
		return tab;
	}
	
    
    public void ksiegarnia(int n) throws Exception
    {
	    {    	
	    	if(n<=0) throw new Exception();
	    	else
	    	{
		    	tab = new String[n][];
		    	
		    	for(int i=0; i<n; i++)
		    	{
		    		tab[i] = new String[i+1];
		    	}
		    	
		    	tab[0][0] = "Kziężniczka z lodu";
		    	tab[0][1] = "Camilla Laeckberg";
		    	tab[0][2] = "Kryminał";
		    	tab[0][3] = "10";
				
		    	tab[1][0] = "Kamieniarz";
		    	tab[1][1] = "Camilla Laeckberg";
		    	tab[1][2] = "Kryminał";
		    	tab[1][3] = "11";
		    	
		    	tab[2][0] = "Niemiecki bękart";
		    	tab[2][1] = "Camilla Laeckberg";
		    	tab[2][2] = "Kryminał";
		    	tab[2][3] = "12";
		    	
		    	tab[3][0] = "Kaznodzieja";
		    	tab[3][1] = "Camilla Laeckberg";
		    	tab[3][2] = "Kryminał";
		    	tab[3][3] = "15";
		    	
		    	tab[4][0] = "Ofiara losu";
		    	tab[4][1] = "Camilla Laeckberg";
		    	tab[4][2] = "Kryminał";
		    	tab[4][3] = "20";
				
		    	tab[5][0] = "Latarnik";
		    	tab[5][1] = "Camilla Laeckberg";
		    	tab[5][2] = "Kryminał";
		    	tab[5][3] = "19";
		    	
		    	tab[6][0] = "Smaki z Fjaellbacki";
		    	tab[6][1] = "Camilla Laeckberg";
		    	tab[6][2] = "Kryminał";
		    	tab[6][3] = "33";
		    	
		    	tab[7][0] = "Biesiada, jedzenie i miłość";
		    	tab[7][1] = "Camilla Laeckberg";
		    	tab[7][2] = "Kryminał";
		    	tab[7][3] = "45";
		    	
		    	tab[8][0] = "Pogromca lwów";
		    	tab[8][1] = "Camilla Laeckberg";
		    	tab[8][2] = "Kryminał";
		    	tab[8][3] = "156";
		    	
		    	tab[9][0] = "Czerwony krąg";
		    	tab[9][1] = "Brandon Webb";
		    	tab[9][2] = "Biografia";
		    	tab[9][3] = "125";
		    	
		    	tab[10][0] = "Boże igrzysko";
		    	tab[10][1] = "Norman Davis";
		    	tab[10][2] = "Historyczna";
		    	tab[10][3] = "97";		    	
	    	}
	    }
    }
	
	public void appendElement()
	{
		final int N = tab.length;
	    tab2 = Arrays.copyOf(tab, N + 1);
	    
		/*tab[N][0] = append(tab, "Ocalona z piekła" );
		tab[N][1] = append(tab, "Ania Golędzinowska");
		tab[N][2] = append(tab, "Biografia");
		tab[N][3] = append(tab, 666);*/
	}
	
//	public void removeElement(int x) throws Exception
//	{
//		if(x <= 0 || x >= ksiazki.size()) throw new Exception();
//		
//		tab.remove(x);
//		
//		tab.
//	}
//	
//	public Ksiazka getElement(int x) throws Exception
//	{
//		if(x <= 0 || x >= ksiazki.size()) throw new Exception();
//		
//		return ksiazki.get(x);
//	}
//	
//	public int size()
//	{
//		return ksiazki.size();
//	}
//	
//	public void sort()
//	{
//		Collections.sort(ksiazki);
//	}
//	
//	public void sort(Comparator x)
//	{
//		Collections.sort(ksiazki, x);
//	}
//	
//	public void print()
//	{
//		for(Ksiazka ksiazka : ksiazki)
//		{
//			System.out.println(ksiazka);
//		}	    
//	}
//	
//}
//
//
//class KomparatorISBN implements Comparator<Ksiazka>
//{
//	public int compare(Ksiazka k1, Ksiazka k2)
//	{
//		int ISBN = k1.getISBN() - k2.getISBN();
//		if (ISBN == 0) { return k1.compareTo(k2); }
//		return ISBN;
//	}
}
