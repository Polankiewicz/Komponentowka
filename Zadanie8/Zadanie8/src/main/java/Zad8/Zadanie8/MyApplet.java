package Zad8.Zadanie8;

import java.applet.Applet;

import java.awt.*; 
import java.awt.event.*;
 

public class MyApplet extends Applet implements ActionListener, ItemListener
{

		Button 	przycisk1, przycisk2; 
		TextField oknoTekstowe; 
		
		// nowe okno
		Button button1, button2;
	    menuFrame fullmenuWindow;
	
		//radiobutton
	    CheckboxGroup checkboxgroup1;
	    Checkbox checkbox1, checkbox2, checkbox3, checkbox4, checkbox5;
	    TextField text2;
	    
		//checker
	    Checkbox przyciskk1, przyciskk2, przyciskk3;
	    TextField text3;
	
	
		public void paint (Graphics g) 
		{
			oknoTekstowe.setLocation(150,200);	// okno tekstowe i przyciski
			przycisk1.setLocation(160,170);
			przycisk2.setLocation(240,170);
			button1.setLocation(150, 70); 	// nowe okno
			button2.setLocation(150, 100);
			checkbox1.setLocation(130, 20);	// radiobutton
			checkbox2.setLocation(160, 20);
			checkbox3.setLocation(190, 20);
			checkbox4.setLocation(220, 20);
			checkbox5.setLocation(250, 20);
			text2.setLocation(280, 20);
			przyciskk1.setLocation(270, 50); //checker
			przyciskk2.setLocation(300, 50);
			przyciskk3.setLocation(330, 50);
			text3.setLocation(250, 80);
			
			
			// Rysuje odcinek o poczatku i koncu w podanych wspolrzednych
			g.drawLine(10, 150, 70, 10);
			g.drawLine(70, 10, 150, 150);
			g.drawLine(150, 150, 10, 150);
							
		
			// rysuje kwadrat lub prostokat
			g.setColor(Color.green);
			g.drawRect(50,300,150,150);
	
					
			// rysuje kwadrat lub prostokat o zaokraglonych bokach
			g.setColor(Color.blue);
			g.drawRoundRect(70, 350, 50, 50, 20, 20);
						
					
			// rysuje elipse wpisana w podany prostokat
			g.setColor(Color.gray);
			g.drawOval(330, 180, 150, 50);
					
							
			// Pobiera obrazek z pliku i wyswietla go w podanym prostokacie 
			Image image = getImage(getCodeBase(), "http://ics.p.lodz.pl/~aniewiadomski/mijp/applets/welcome.jpg");  
			g.drawImage(image, 220, 350, 250, 100, this);
					
					
			// Ustawia kroj i parametry czcionki w applecie
			String s = new String ("Pogrubiona czcionka Arial 28pt");
			Font appFont = new Font("Arial", Font.BOLD, 28);  
					
			g.setColor(Color.black);
			g.setFont(appFont); 
			g.drawString(s, 20, 280);
			
		}
	
        
		public void init()
		{
			setSize(500,500);
			
			oknoTekstowe = new TextField(20);
			add(oknoTekstowe);
			

			przycisk1 = new Button("Welcome");
			add(przycisk1);
			przycisk1.addActionListener(this);
			
			przycisk2 = new Button("to JAVA !!!");	
			add(przycisk2);						
			przycisk2.addActionListener(this);	
			
			
			// nowe okno
			button1 = new Button("Show menu");
            add(button1);
            button1.addActionListener(this);
            button2 = new Button("Hide menu");
            add(button2);
            button2.addActionListener(this);

            
            fullmenuWindow = new menuFrame("Full menu");
            fullmenuWindow.setSize(400, 400);
			
            
            //radiobutton
            checkboxgroup1 = new CheckboxGroup();

            checkbox1 = new Checkbox("1", false, checkboxgroup1);
            add(checkbox1);
            checkbox1.addItemListener(this);

            checkbox2 = new Checkbox("2", false, checkboxgroup1);
            add(checkbox2);
            checkbox2.addItemListener(this);

            checkbox3 = new Checkbox("3", false, checkboxgroup1);
            add(checkbox3);
            checkbox3.addItemListener(this);

            checkbox4 = new Checkbox("4", false, checkboxgroup1);
            add(checkbox4);
            checkbox4.addItemListener(this);

            checkbox5 = new Checkbox("5", false, checkboxgroup1);
            add(checkbox5);
            checkbox5.addItemListener(this);

            text2 = new TextField(20);
            add(text2);
            
            
            //checker
            przyciskk1 = new Checkbox("1");
            add(przyciskk1);
            przyciskk1.addItemListener(this);
            
            przyciskk2 = new Checkbox("2");
            add(przyciskk2);
            przyciskk2.addItemListener(this);

            przyciskk3 = new Checkbox("3");
            add(przyciskk3);
            przyciskk3.addItemListener(this);


            text3 = new TextField(20);
            add(text3);
		}
		
		
		public void itemStateChanged(ItemEvent e)
        {
            //radiobutton
			if(e.getItemSelectable() == checkbox1)		
				text2.setText("jedyneczka");
            if(e.getItemSelectable() == checkbox2)		
                text2.setText("dwojeczka");        
            if(e.getItemSelectable() == checkbox3)		
                text2.setText("trojeczka");               
            if(e.getItemSelectable() == checkbox4)		
                text2.setText("czworeczka");              
            if(e.getItemSelectable() == checkbox5)		
                text2.setText("piateczka");
                
            //cheker
            if(e.getItemSelectable() == przyciskk1)		
                text3.setText(text3.getText()+"jeden ");
            if(e.getItemSelectable() == przyciskk2)		
                text3.setText(text3.getText()+"dwa ");               
            if(e.getItemSelectable() == przyciskk3)		
                text3.setText(text3.getText()+"trzy ");
        }

		public void actionPerformed(ActionEvent evt) 
		{
			if (evt.getSource() == przycisk1)
				oknoTekstowe.setText("Welcome");
			if (evt.getSource() == przycisk2)
				oknoTekstowe.setText(oknoTekstowe.getText() + " to JAVA !!!");
				
			// nowe okno
			if(evt.getSource() == button1)
	            fullmenuWindow.setVisible(true);
			if(evt.getSource() == button2)
	            fullmenuWindow.setVisible(false);
		}
		


}
