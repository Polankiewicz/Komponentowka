package Organizer.Organizer.view;

import java.awt.Color;
import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.ArrayList;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import Organizer.Organizer.controller.NotesList;
import Organizer.Organizer.controller.XmlOperations;
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
	
	private NotesList notesList;
	
	private Menu menu;
	
	private XmlOperations xml;
	
	
	public void showtime() 
	{
		frame = new JFrame("Calednar");
		frame.setDefaultCloseOperation(EXIT_ON_CLOSE);
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
		btnPrev.addActionListener(this);
		
		btnNext = new JButton (">>");
		btnNext.setBounds(340, 20, 40, 40);
		btnNext.setBorder(null);
		contentPane.add(btnNext);
		btnNext.setToolTipText("Click this button and go to next month.");
		btnNext.addActionListener(this);
		
		// JButtons for days
		buttonList = new ArrayList<JButton>();
		
		for(int i=0; i<31; i++)
			buttonList.add(new JButton(Integer.toString(i+1))); 
		
		for(int i=0; i<buttonList.size(); i++)
			buttonList.get(i).addActionListener(this);
		
		// JLabel month/years
		lblMonth = new JLabel ();
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
		yearList.addActionListener(this);
		
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
		
		// JLabel reminder - event in next day
		remainderLabel = new JLabel();
		remainderLabel.setBounds(200, 425, 200, 30);
		remainderLabel.setForeground(Color.red);
		contentPane.add(remainderLabel);
	     
		// JButton delete old events
	    deleteButton = new JButton("Delete");
	    deleteButton.setBounds(10, 420, 50, 40);
	    deleteButton.setBorder(null);
	    deleteButton.setToolTipText("Press this button to delete old events.");
	    contentPane.add(deleteButton);
		deleteButton.addActionListener(this);
		
		
		// list of saved events
		notesList = new NotesList();
		
		// Menu options
		menu = new Menu(frame, notesList, this);
		menu.menuOptions();
		
		// Calendar logic - Gregorian Calendar
		calendarLogic = new CalendarLogic();
		
		
		// load events from xml file
		xml = new XmlOperations(notesList);
		// draw days for current month/year
		refreshCalendar(xml.Load());
		
		// save events to xml when closing app
		frame.addWindowListener(new WindowAdapter()
        {
            @Override
            public void windowClosing(WindowEvent e)
            {
            	xml.Save();
                e.getWindow().dispose();
            }
        });
		
		frame.setVisible(true);
	}
	
	
	public void refreshCalendar()
	{
		refreshCalendar(calendarLogic.getCurrentYear(), calendarLogic.getCurrentMonth());
	}
	
	// refresh calendar after XML/DB 
	public void refreshCalendar(NotesList notesList)
	{
		this.notesList = notesList;
		menu.updateNotesList(notesList);
		refreshCalendar(calendarLogic.getCurrentYear(), calendarLogic.getCurrentMonth());
	}

	public void refreshCalendar(int year, int month)
	{
		String[] months =  {"January", "February", "March", "April", "May", "June", "July", "August",
				"September", "October", "November", "December"};
		
		// reload buttons
		contentPane.repaint();
		
		for(int i=0; i < buttonList.size(); i++)
			contentPane.remove(buttonList.get(i));
		
		// enable buttons and check if we can change month 
		calendarLogic.nextPrevButtonEnable(btnNext, btnPrev);
		
		// Refresh the month label
		lblMonth.setText(months[month]); 
		
		//Select the correct year in the combo box
		yearList.setSelectedItem(String.valueOf(year)); 
		
		// update first day of month, and number of days in current month
		calendarLogic.updateCalendarForCountingDays(year, month);
		
		try {
			drawDays();
		} 
		catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	
	public void drawDays() throws Exception
	{
		int x = calendarLogic.setFirstDayOfWeekPositionX();
		int y = 100;

		int first = calendarLogic.getFirstDayofWeek();
		int days = calendarLogic.getNumberOdDays();
		
		
		String firstDayString = calendarLogic.getStringFromDate(1, calendarLogic.getCurrentMonth(), calendarLogic.getCurrentYear());
		int currentDayToColor = Integer.parseInt(firstDayString);
		
		int remaindMe = Integer.parseInt(calendarLogic.getToday())+1;
		
		// draw 
		for(int i=0; i<days; y+=50, x=25, first=0)
		{
			for(int j=first; j<7 && i<days; j++, i++, x+=50, currentDayToColor++)
			{
				// days positions
				buttonList.get(i).setBounds(x,y,40,40);
				buttonList.get(i).setBorder(null);
				contentPane.add(buttonList.get(i));
				buttonList.get(i).setBackground(Color.LIGHT_GRAY);
				
				// color days with notes
				for(int k=0; k< notesList.size(); k++)
				{
					if(notesList.getNote(k).getStringFromDate()
							.equals(calendarLogic.getStringFromDate(
									i+1, calendarLogic.getCurrentMonth(), calendarLogic.getCurrentYear()) ) )
					{
						if(notesList.getNote(k).ifNotNull()) 	// without empty notes
							buttonList.get(i).setBackground(Color.green);
					}
				}
				
				// current day - today
				if(currentDayToColor == Integer.parseInt(calendarLogic.getToday()))	
					buttonList.get(i).setBackground(Color.blue);
				
				// remainder - event in next day
				for(int k=0; k< notesList.size(); k++) 
				{
					if( notesList.getNote(k).getStringFromDate().equals(Integer.toString(remaindMe)) )
						if(notesList.getNote(k).ifNotNull())
							remainderLabel.setText("New event is coming tomorrow!");
					else 
						remainderLabel.setText("");
				}
					
			}
		}
	}

	
	@Override
	public void actionPerformed(ActionEvent e)
	{
		// btnPrev - go to preview month
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
		
		// btnNext - go to next month
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
		
		// JComboBox - yearList - chose year
		if(e.getSource().equals(yearList) )
		{
			if (yearList.getSelectedItem() != null)
			{
				String selectedYear = yearList.getSelectedItem().toString();
				calendarLogic.setCurrentYear(Integer.parseInt(selectedYear));
				
				refreshCalendar(calendarLogic.getCurrentYear(), calendarLogic.getCurrentMonth());
			}
		}
		
		// buttonList - open new note window
		for(int i=0; i<buttonList.size(); i++)
		{
			if(e.getSource().equals(buttonList.get(i)))
			{
				try {
					calendarLogic.dayButtonOn(i+1, notesList, this);
				} 
				catch (Exception e1) {
					e1.printStackTrace();
				}
				refreshCalendar();
			}	
		}
		
		// delete old events
		if(e.getActionCommand().equals("Delete"))
		{
			calendarLogic.deleteOldEvents(notesList);
			refreshCalendar();
		}
		
	}
		
}
