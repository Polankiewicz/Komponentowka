package Zad9.Zadanie9;

import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;


public class KlasaZewnetrzna implements ItemListener
{
	private MyAppletZdarzenia2 myAppletZdarzenia2;
	
	public KlasaZewnetrzna(MyAppletZdarzenia2 myAppletZdarzenia2)
	{
		this.myAppletZdarzenia2 = myAppletZdarzenia2;
	}

	public void itemStateChanged(ItemEvent e) {
		// TODO Auto-generated method stub
		
		// rozmiar czcionki
        if(e.getItemSelectable() == myAppletZdarzenia2.checkbox1)		
        	myAppletZdarzenia2.rozmiar_czcionki = 15;
        
        if(e.getItemSelectable() == myAppletZdarzenia2.checkbox2)		
        	myAppletZdarzenia2.rozmiar_czcionki = 25;
        
        if(e.getItemSelectable() == myAppletZdarzenia2.checkbox3)		
        	myAppletZdarzenia2.rozmiar_czcionki = 35;
        
        if(e.getItemSelectable() == myAppletZdarzenia2.checkbox4)		
        	myAppletZdarzenia2.rozmiar_czcionki = 45;
        
        myAppletZdarzenia2.repaint();
	}

}
