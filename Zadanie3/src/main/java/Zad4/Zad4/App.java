package Zad4.Zad4;

import Zad4.Zad4.Ksiegarnia;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {   	
        Ksiegarnia ksiegarnia = new Ksiegarnia();
        ksiegarnia.print();
        ksiegarnia.sort(new KomparatorISBN());
        System.out.println();
        ksiegarnia.print();
         
    }
}
