package zad3a.zad3a;

import zad3a.zad3a.KomparatorISBN;


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
        
        System.out.println();System.out.println("Sortowanie:");
        ksiegarnia.sort();
        ksiegarnia.print();
        
        System.out.println();System.out.println("Sortowanie po ISBN:");
        ksiegarnia.sort(new KomparatorISBN());
        ksiegarnia.print();
    }
}
