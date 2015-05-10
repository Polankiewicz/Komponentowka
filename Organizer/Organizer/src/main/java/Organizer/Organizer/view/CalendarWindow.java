package Organizer.Organizer.view;

import java.awt.Color;
import java.awt.Container;
import java.util.ArrayList;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class CalendarWindow extends JFrame
{
	
	JFrame frame;
	Container pane;		
	JPanel contentPane;
	
	JButton btnPrev, btnNext;		
	ArrayList<JButton> buttonList;
	JButton deleteButton;
	
	JLabel lblMonth, lblYear;
	JLabel[] dayOfWeek;
	JLabel remainderLabel;
	
	JComboBox yearList;
	
	
//	int buttonNumeration;
//	int realYear, realMonth, realDay, currentYear, currentMonth, currentDay, monthh, yearr;

	
	
//	JColorChooser tcc;
//	ArrayList<Note> listOfEvents;
//	String today;
//	Note mNote;
//	NoteWindow mNoteWindow;
//	Menu menu;


	
	

	public void showtime() 
	{
		frame = new JFrame("Calednar");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(400, 530);
		frame.setLocation(200, 100);
		frame.setResizable(false);
		
		// Container 
		pane = frame.getContentPane();
		pane.setLayout(null);
		
		// JPanel
		contentPane = new JPanel(null);
		contentPane.setBorder(BorderFactory.createTitledBorder("Calendar"));
		
		pane.add(contentPane);
		contentPane.setBounds(0, 0, 390, 475);
		
		
		
		// JButtons for next/prev month
		btnPrev = new JButton ("<<");
		btnPrev.setBounds(10, 20, 40, 40);
		btnPrev.setBorder(null);
		contentPane.add(btnPrev);
		btnPrev.setToolTipText("Click this button and go to previous month.");
		
		btnNext = new JButton (">>");
		btnNext.setBounds(340, 20, 40, 40);
		btnNext.setBorder(null);
		contentPane.add(btnNext);
		btnNext.setToolTipText("Click this button and go to next month.");
		
		//////////////////////////////////////////// OBSŁUGA BUTTONÓW GDZIEŚ W MODELU ////////////
		//btnPrev.addActionListener(new btnPrev_Action());
		//btnNext.addActionListener(new btnNext_Action());
		//////////////////////////////////////////////////////////////////////////////////////////
		
		
		// JButtons for days
		buttonList = new ArrayList<JButton>();
		
		for(int i=0; i<31; i++)
			buttonList.add(new JButton(Integer.toString(i+1))); 
		
		////////////////////////////////////////////OBSŁUGA BUTTONÓW GDZIEŚ W MODELU ////////////
		//buttonList.get(buttonNumeration).addActionListener(new ActionListener() { }
		//////////////////////////////////////////////////////////////////////////////////////////
		
		
		// JLabel month/years
		lblMonth = new JLabel ("January");
		lblYear = new JLabel ("Change year:");
		contentPane.add(lblMonth);
		contentPane.add(lblYear);
		lblMonth.setBounds(170, 30, 100, 25);
		lblYear.setBounds(10, 400, 80, 20);
		
		
		
		
		// JComboBox - list of years
		String[] yearListOfDays = new String[40];
		
		for(int i=0; i<40; i++)
			yearListOfDays[i] = Integer.toString(2000 + i);
		
		yearList = new JComboBox(yearListOfDays);
		yearList.setBounds(300, 400, 80, 20);
		contentPane.add(yearList);
		////////////////////////////////////////////OBSŁUGA BUTTONÓW GDZIEŚ W MODELU ////////////
		//yearList.addActionListener(new cmbYear_Action());
		//////////////////////////////////////////////////////////////////////////////////////////
		
		
		
		
		// JLabel[] - list of days
		String[] namesOfDays = {"Mon", "Tue", "Wed", "Thu", "Fri", "Sat", "Sun"};
		dayOfWeek = new JLabel[7];
		
		for(int i=0; i<7; i++)
		{
			dayOfWeek[i] = new JLabel(namesOfDays[i]);
			dayOfWeek[i].setBounds(35 + i*50 , 70, 30, 30);
			contentPane.add(dayOfWeek[i]);
			
			if(i>4) 
				dayOfWeek[i].setForeground(Color.red);
		}
		
		
		
		/////////////////////////////////////////////////////// JColorChooser ///////////////////////////////////
		
		
		// JLabel reminder 
		remainderLabel = new JLabel();
		
	     

	    // list of saved events
	    //listOfEvents = new ArrayList<Note>();
	    
	    
	    
	    
	    
	    // JButton delete old events
	    deleteButton = new JButton("Delete");
	    deleteButton.setBounds(80, 420, 50, 40);
	    deleteButton.setBorder(null);
	    deleteButton.setToolTipText("Press this button to delete old events.");
	    contentPane.add(deleteButton);
	    	    
		////////////////////////////////////////////OBSŁUGA BUTTONÓW GDZIEŚ W MODELU ////////////
		// deleteButton.addActionListener(new ActionListener() { }
		//////////////////////////////////////////////////////////////////////////////////////////
		
	    
	    
	    
	    
	    
		// Menu options
		Menu menu = new Menu(frame);
		menu.menuOptions();
		
		
		
		
		////////////////////
		frame.setVisible(true);
	}
	
	
}
