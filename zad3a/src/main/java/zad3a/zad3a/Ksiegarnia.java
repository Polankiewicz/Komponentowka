package zad3a.zad3a;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;


public class Ksiegarnia {
		
	private String[][] tab;
	private String[][] temp;
	
	public String[][] getTab()
	{
		return tab;
	}
	
    
    public Ksiegarnia() 
    {       	
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
	
	public void appendElement(String tytul, String autor, String gatunek, String ISBN)
	{
		final int N = tab.length;
		Arrays.copyOf(tab, N+1);
	    
		tab[N+1][0] = tytul;
		tab[N+1][1] = autor;
		tab[N+1][2] = gatunek;
		tab[N+1][3] = ISBN;
	}
	
	public void removeElement(int x) throws Exception
	{
		if(x <= 0 || x >= tab.length) throw new Exception();
		
		final int N = tab.length;
		tab = new String[N-1][4];
		temp = new String[N-1][4];
		
		for(int i=0; i<N && i != x ; i++)
		{
			for(int j=0; j<4; j++)
			{
				temp[i][j]=tab[i][j];
				tab[i][j]=temp[i][j];
			}
		}
	}
	
	public String getElement(int x) throws Exception
	{
		if(x <= 0 || x >= tab.length) throw new Exception();
		
		String e1 = tab[x][0];
		String e2 = tab[x][1];
		String e3 = tab[x][2];
		String e4 = tab[x][3];
		
		String elem = e1 + " " + e2 + " " + e3 + " " + e4;
		return elem;
	}
	
	public int rowSize()
	{
		return tab.length;
	}
	
	public int columnSize()
	{
		return tab[0].length;
	}
	
	public void sort()
	{
		Arrays.sort(tab);
	}
	
	public void sort(Comparator x)
	{
		Arrays.sort(tab, x);
	}
	
	public void print()
	{
		for(int i=0; i<tab.length; i++)
		{
			for(int j=0; j<tab[0].length; j++)
			{
				System.out.println(tab[i][j] + " ");
			}
			System.out.println(" ");
		}	    
	}
}
