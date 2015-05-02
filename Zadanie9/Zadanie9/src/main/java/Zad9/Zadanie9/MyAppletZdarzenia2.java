package Zad9.Zadanie9;

import javax.swing.*;

import java.awt.*;
import java.awt.event.*; 
import java.applet.*;


public class MyAppletZdarzenia2 extends Applet implements ActionListener, ItemListener {  

	
	boolean bokA = false,
			bokB = false,
			bokC = false;
	
	
	// Deklaracje obiektow - zmiennych reprezentujacych przyciski
	Button 	przycisk1, 
	przycisk2,
	przycisk3; 
	
	// klasa adaptacyjna
	KlasaAdaptacyjna adaptacyjna;
	
	// klasa wewnetrzna
	Wewnetrzna wewnetrznyActionListener;
	
	//chekery - linie
	Checkbox przyciskk1, przyciskk2, przyciskk3;
	
	// tekst 
	Font appFont;
	
	// radiobuttony - rozmiar czcionki
	CheckboxGroup checkboxgroup1;
	Checkbox checkbox1, checkbox2, checkbox3, checkbox4;
	int rozmiar_czcionki = 10;
	
	
	//checker - tekst pogrubienie/pochylenie
	Checkbox font1, font2;
	boolean font11 = false, font22 = false;
	
	
	// choice - wybor czcionki
	Choice myChoice;
	String czcionka = "Arial";
	
	// choice - wybor koloru tekstu
	Choice myChoiceColor;
	String kolorCzcionki = "Black";
	
	
	
	public void init() {
		
		setSize(480,500);
		
		// KLASA ADAPTACYJNA
        adaptacyjna = new KlasaAdaptacyjna();
		this.addMouseListener(adaptacyjna);
		
		
		// obsługa w klasie wewnetrznej
		wewnetrznyActionListener = new Wewnetrzna();
		przycisk1 = new Button("WLACZ A");
		add(przycisk1);
		przycisk1.addActionListener(wewnetrznyActionListener);
		
		
		// obsługa we własnej klasie
		przycisk2 = new Button("WLACZ B");	
		add(przycisk2);						
		przycisk2.addActionListener(this);	

		przycisk3 = new Button("WLACZ C");	
		add(przycisk3);						
		przycisk3.addActionListener(this);	
		
		
		
		
		// checker - rysowanie lini
        przyciskk1 = new Checkbox("1");
        add(przyciskk1);
        przyciskk1.addItemListener(this);
        
        przyciskk2 = new Checkbox("2");
        add(przyciskk2);
        przyciskk2.addItemListener(this);

        przyciskk3 = new Checkbox("3");
        add(przyciskk3);
        przyciskk3.addItemListener(this);


        
        //KlasaZewnetrzna klasaZewnetrzna = new KlasaZewnetrzna();
        
        // radiobutton - rozmiar czcionki
        checkboxgroup1 = new CheckboxGroup();

        checkbox1 = new Checkbox("15", false, checkboxgroup1);
        add(checkbox1);
        checkbox1.addItemListener(this);

        checkbox2 = new Checkbox("25", false, checkboxgroup1);
        add(checkbox2);
        checkbox2.addItemListener(this);

        checkbox3 = new Checkbox("35", false, checkboxgroup1);
        add(checkbox3);
        checkbox3.addItemListener(this);

        checkbox4 = new Checkbox("45", false, checkboxgroup1);
        add(checkbox4);
        checkbox4.addItemListener(this);
        
        

        
		
        
        ///////////////////////////////////////////////////////// KLASY ANONIMOWE
        // choice - wybor czcionki
        myChoice = new Choice();  
        String [] numbers = {"Arial", "Comic", "Times New Roman", "Tahoma", "Lucida", "Verdana", "Courier New"};
        
        for (int i = 0; i < numbers.length; i++)
            myChoice.add(numbers[i]);
        
        add(myChoice);
        
        myChoice.addItemListener(new ItemListener() {
			
			public void itemStateChanged(ItemEvent e) {
				// TODO Auto-generated method stub
				
		        if(e.getItemSelectable() == myChoice)	
		        	czcionka = myChoice.getSelectedItem();
		        repaint();
			}
		});
        
        
        
        
        // choice - wybor koloru tekstu
        myChoiceColor = new Choice();  
        
        String [] numbersColor = {"Black", "Red", "Green", "Blue", "Pink"};
        
        for (int i = 0; i < numbersColor.length; i++)
            myChoiceColor.add(numbersColor[i]);
        
        add(myChoiceColor);
        
        
        myChoiceColor.addItemListener(new ItemListener() {
			
			public void itemStateChanged(ItemEvent e) {
				// TODO Auto-generated method stub
				
		        if(e.getItemSelectable() == myChoiceColor)	
		        	kolorCzcionki = myChoiceColor.getSelectedItem();
		        repaint();
			}
		});
        
        
        
        /////////////////////////////////////////////// KLASA LOKALNA
        class KlasaLokalna implements ItemListener
        {

			public void itemStateChanged(ItemEvent e) 
			{
				//checker - tekst pogrubienie/pochylenie
		        if(e.getItemSelectable() == font1)	{
		        	if(font11==true) 
		        		font11=false; 
		        	else 
		        		font11=true;
		        }
		        
		        if(e.getItemSelectable() == font2)	{
		        	if(font22==true) 
		        		font22=false; 
		        	else 
		        		font22=true;
		        }
		        
		        repaint();
			}
        	
        }
        
        //checker - tekst pogrubienie/pochylenie
        KlasaLokalna lokalna = new KlasaLokalna();
        
        font1 = new Checkbox("B");
        add(font1);
        font1.addItemListener(lokalna);
      
        font2 = new Checkbox("/");
        add(font2);
        font2.addItemListener(lokalna);
		
        
	}	// init
	
	
	
	public void paint (Graphics g) 
	{
		if (bokA == true) {
			g.setColor(this.getForeground()); 
			g.drawLine(50,60, 80, 200);
			przycisk1.setLabel("wylacz A");
		}
		else {
			g.setColor(this.getBackground()); 
			g.drawLine(50,60, 80, 200);
			przycisk1.setLabel("WLACZ A");
		}
		
		if (bokB == true) {
			g.setColor(Color.BLACK);
			g.drawLine(80, 200, 190, 60);
			przycisk2.setLabel("wylacz B");
		}
		else {
			g.setColor(Color.WHITE); 
			g.drawLine(80, 200, 190, 60);
			przycisk2.setLabel("WLACZ B");
		}
		
		if (bokC == true) {
			g.setColor(Color.BLACK);
			g.drawLine(190, 60, 50, 60);
				przycisk3.setLabel("wylacz C");
		}
		else {
			g.setColor(Color.WHITE);
			g.drawLine(190, 60, 50, 60);
				przycisk3.setLabel("WLACZ C");
		}
		
		
		
		
		if (font11 == true && font22 == true) 
			appFont = new Font(czcionka, Font.BOLD + Font.ITALIC, rozmiar_czcionki);
		else if (font11==true)		
			appFont = new Font(czcionka, Font.BOLD, rozmiar_czcionki);
		else if (font22==true)		
			appFont = new Font(czcionka, Font.ITALIC, rozmiar_czcionki);
		else						
			appFont = new Font(czcionka, Font.PLAIN, rozmiar_czcionki);

		
			
		if (kolorCzcionki == "Black") 		g.setColor(Color.black);
		else if (kolorCzcionki == "Red")	g.setColor(Color.red);
		else if (kolorCzcionki == "Green")	g.setColor(Color.green);
		else if (kolorCzcionki == "Blue")	g.setColor(Color.blue);
		else if (kolorCzcionki == "Pink")	g.setColor(Color.pink);
		
		g.setFont(appFont); 
		g.drawString("Jestem tekstem", 20, 280);
		
	}
	
	
	//KLASA WEWNETRZNA
	private class Wewnetrzna implements ActionListener{ 
		public void actionPerformed(ActionEvent evt) {
			
			if (evt.getSource() == przycisk1) {
				bokA = !bokA;
				przyciskk1.setState(bokA);
			} 
			
			repaint();
		}
	}
	
	public void actionPerformed(ActionEvent evt) 
	{
		if (evt.getSource() == przycisk2) {
			bokB = !bokB;
			przyciskk2.setState(bokB);
		} 
		
		if (evt.getSource() == przycisk3) {
			bokC = !bokC;
			przyciskk3.setState(bokC);
		} 
		
		repaint();
	}
	
	
	
	public void itemStateChanged(ItemEvent e) 
	{
		// rysowanie lini
		if(e.getItemSelectable() == przyciskk1)		bokA = !bokA;

        if(e.getItemSelectable() == przyciskk2)		bokB = !bokB;
        
        if(e.getItemSelectable() == przyciskk3)		bokC = !bokC;
		
        
        // rozmiar czcionki
        if(e.getItemSelectable() == checkbox1)		rozmiar_czcionki = 15;
        
        if(e.getItemSelectable() == checkbox2)		rozmiar_czcionki = 25;
        
        if(e.getItemSelectable() == checkbox3)		rozmiar_czcionki = 35;
        
        if(e.getItemSelectable() == checkbox4)		rozmiar_czcionki = 45;
        
        
        repaint();
	}
	
	
}

