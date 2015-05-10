package Organizer.Organizer.view;

import java.awt.Color;
import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.GregorianCalendar;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import Organizer.Organizer.model.CalendarLogic;

public class CalendarWindow extends JFrame implements ActionListener
{
	
	private JFrame frame;
	private Container pane;		
	private JPanel contentPane;
	
	private JButton btnPrev, btnNext;		
	private ArrayList<JButton> buttonList;
	private JButton deleteButton;
	
	private JLabel lblMonth, lblYear;
	private JLabel[] dayOfWeek;
	private JLabel remainderLabel;
	
	private JComboBox<String> yearList;
	
	private CalendarLogic calendarLogic;
	
	
//	JColorChooser tcc;
	
//	ArrayList<Note> listOfEvents;	
//	Note mNote;
//	NoteWindow mNoteWindow;

	
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
		btnPrev.addActionListener(this);
		btnNext.addActionListener(this);
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
		
		yearList = new JComboBox<String>(yearListOfDays);
		yearList.setBounds(300, 400, 80, 20);
		contentPane.add(yearList);
		////////////////////////////////////////////OBSŁUGA BUTTONÓW GDZIEŚ W MODELU ////////////
		yearList.addActionListener(this);
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
		
		
		
		
		calendarLogic = new CalendarLogic(frame);
		
		refreshCalendar(calendarLogic.getCurrentYear(), calendarLogic.getCurrentMonth());
		
		
		
		
		
		
		////////////////////
		frame.setVisible(true);
	}
	


	

	
	
	
	public void refreshCalendar(int year, int month)
	{
		String[] months =  {"January", "February", "March", "April", "May", "June", "July", "August",
				"September", "October", "November", "December"};
		
		
		// reload buttons
		contentPane.repaint();
		for(int i=0; i < buttonList.size(); i++)
		{
			contentPane.remove(buttonList.get(i));
		}
		
		btnPrev.setEnabled(true);
		btnNext.setEnabled(true);
		
		//Too early
		if (month == 0 && year <= calendarLogic.getRealYear() - 14)
			btnPrev.setEnabled(false); 
		//Too late
		if (month == 11 && year >= calendarLogic.getRealYear() + 25)
			btnNext.setEnabled(false); 
		
		//Refresh the month label
		lblMonth.setText(months[month]); 
		
		//lblMonth.setBounds(170, 30, 180, 25); //Re-align label with calendar
		
		//Select the correct year in the combo box
		yearList.setSelectedItem(String.valueOf(year)); 
		
		
		//Number Of Days, Start Of Month
		int nod, som;
		
		//Get first day of month and number of days
		GregorianCalendar cal = new GregorianCalendar(year, month, 7);
		nod = cal.getActualMaximum(GregorianCalendar.DAY_OF_MONTH);
		som = cal.get(GregorianCalendar.DAY_OF_WEEK);
		

		drawDays(nod,som);
	}
	
	

	public void drawDays(int days, int first)
	{
		// position
		int x = 25;
		int y = 100;
				
		
		// set first day of week
		first=(1+first-2)%7;
		
		if		(first==0) x= x+0*50;
		else if (first==1) x= x+1*50;
		else if (first==2) x= x+2*50;
		else if (first==3) x= x+3*50;
		else if (first==4) x= x+4*50;
		else if (first==5) x= x+5*50;
		else if (first==6) x= x+6*50;
		

		
		String abc = calendarLogic.getStringFromDate(1, calendarLogic.getCurrentMonth(), calendarLogic.getCurrentYear());
		int dayToColor = Integer.parseInt(abc);
		
		// w przypadku ostatniego dnia miesiaca bedzie sie krzaczyc :P
		int remaindMe = Integer.parseInt(calendarLogic.getToday())+1;
			
		
		// draw 
		for(int i=0; i<days; y+=50, x=25, first=0)
		{
			for(int j=first; j<7 && i<days; j++, i++, x+=50, dayToColor++)
			{
				buttonList.get(i).setBounds(x,y,40,40);
				buttonList.get(i).setBorder(null);
				contentPane.add(buttonList.get(i));
				buttonList.get(i).setBackground(Color.LIGHT_GRAY);
				
				
//				for(int k=0; k< listOfEvents.size(); k++) // note
//				{
//					if(listOfEvents.get(k).getStringFromDate().equals(getStringFromDate(i+1, currentMonth, currentYear) ) )
//					{
//						//if (listOfEvents.get(k).ifNotNull()) 	// without empty notes
//							buttonList.get(i).setBackground(Color.green);
//					}
//				}
				
				// current day
				if(dayToColor == Integer.parseInt(calendarLogic.getToday()))	
					buttonList.get(i).setBackground(Color.blue);
				
				
				
//				for(int k=0; k< listOfEvents.size(); k++) // reminder
//				{
//					if(listOfEvents.get(k).getStringFromDate().equals(Integer.toString(remaindMe) ) )
//					{
//						remainderLabel.setBounds(200, 425, 200, 30);
//						remainderLabel.setText("New event is coming tomorrow!");
//						remainderLabel.setForeground(Color.red);
//						contentPane.add(remainderLabel);
//					}
//				}
					
			}
		}
	}







	/////////////////////////////////////// DO MODELU???? ////////////////////////////////////////////////
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
		// btnPrev
		if(e.getActionCommand().equals("<<"))
		{
			if (calendarLogic.getCurrentMonth() == 0) //Back one year
			{ 
				calendarLogic.setCurrentMonth(11);
				calendarLogic.setCurrentYear(calendarLogic.getCurrentYear() - 1);
			}
			else //Back one month
			{ 
				calendarLogic.setCurrentMonth(calendarLogic.getCurrentMonth() - 1);
			}
			
			refreshCalendar(calendarLogic.getCurrentYear(), calendarLogic.getCurrentMonth());
		}
		
		// btnNext
		if(e.getActionCommand().equals(">>"))
		{
			if (calendarLogic.getCurrentMonth() == 11) //Forward one year
			{
				calendarLogic.setCurrentMonth(0);
				calendarLogic.setCurrentYear(calendarLogic.getCurrentYear() + 1);
			}
			else //Forward one month
			{
				calendarLogic.setCurrentMonth(calendarLogic.getCurrentMonth() + 1);
			}
			
			refreshCalendar(calendarLogic.getCurrentYear(), calendarLogic.getCurrentMonth());
		}
		
		if(e.getSource().equals(yearList) )
		{
			if (yearList.getSelectedItem() != null)
			{
				String selectedYear = yearList.getSelectedItem().toString();
				calendarLogic.setCurrentYear(Integer.parseInt(selectedYear));
				
				refreshCalendar(calendarLogic.getCurrentYear(), calendarLogic.getCurrentMonth());
			}
		}
		
	}
	
	
	
	
	
	
	
	
	
}
