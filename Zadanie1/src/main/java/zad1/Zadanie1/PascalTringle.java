package zad1.Zadanie1;

public class PascalTringle {
	
	private int[][] tab;
	
	private int[] testtab = {1};
    private int[] testowa;
    private int suma = 0;
	
    
	public int[][] getTab()
	{
		return tab;
	}
	
	public int silnia(int s)
	{
		int x=1;
		for(int i=1; i<=s; i++)
		{
			x= x * i;
		}
		return x;
	}
    
    public void compute(int n) throws Exception
    {
	    {    	
	    	if(n<=0) throw new Exception("Bledna wysokosc trojkata Pascala");
	    	else
	    	{
		    	tab = new int[n][];
		    	
		    	for(int i=0; i<n; i++)
		    	{
		    		tab[i] = new int[i+1];
		    	}
		    		
		    	
				for(int i=0; i<n; i++)
				{
					for(int j=0; j<i+1; j++)
					{
						tab[i][j] = (silnia(i))/(silnia(j)*silnia(i-j));
					}	
				}
	    	}
	    }
    }
    
    public void draw()
    {
    	for(int i=0; i<tab.length; i++)
		{    		
    		for(int k=0; k<tab.length-i; k++)
    		{
        		System.out.print(" ");
    		}
    		
    		for(int j=0; j<i+1; j++)
			{
				System.out.print( tab[i][j] + " ");
			}
			 System.out.println("");			
		}
    }
    
    
    
    
    public int[] getTesttab()
	{
		return testtab;
	}
    
    public int[] getTestowa()
	{
		return testowa;
	}
    
    public void multiplyabove(int n)
    {
    	testtab = new int[n];
        testtab[0] = 1;
        
    	for (int i=1; i<n; i++)
    	{
    		testtab[i]=2*testtab[i-1];
    	}
    }

    public void suminrows(int n)
    {      
        testowa = new int[n];      

    	for (int i=0; i<n; i++)
    	{
    		for (int j=0; j<i+1; j++)
    		{
    			suma = suma + tab[i][j];
    		}
    		testowa[i] = suma;
    		suma = 0;   		
    	}
    }
    
    public void test(int n)
    {
    	for (int i=0; i<n; i++)
    	{
    		if (testtab[i] != testowa[i])
			{
				System.out.print("\nBlad. Trojkat Pascala nieudany!");
				break;
			}
    	}
    	//System.out.print("\nRysowanie trojkata Pascala zakonczone powodzeniem!");
    }
}
