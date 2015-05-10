package Organizer.Organizer.view;

import java.awt.BorderLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;

public class XmlOperationsWindow extends JFrame
{

	private JFrame frame;
	private	JTabbedPane tabbedPane;
	private	JPanel	panel1;
	private	JPanel	panel2;
	
	
	public XmlOperationsWindow()
	{
		setTitle( "XML" );
		setSize( 300, 200 );

		JPanel topPanel = new JPanel();
		topPanel.setLayout( new BorderLayout() );
		getContentPane().add( topPanel );

		// Create the tab pages
		createPage1();
		createPage2();

		// Create a tabbed pane
		tabbedPane = new JTabbedPane();
		tabbedPane.addTab( "Save", panel1 );
		tabbedPane.addTab( "Load", panel2 );
		topPanel.add( tabbedPane, BorderLayout.CENTER );
	}
	
	
	public void showWindow() 
	{
		XmlOperationsWindow mainFrame	= new XmlOperationsWindow();
		mainFrame.setVisible(true);
	}
	
	
	private void createPage1() 
	{
		panel1 = new JPanel();
		panel1.setLayout(null);

		JLabel label1 = new JLabel( "Press button and save to xml file" );
		label1.setBounds(10, 15, 250, 20);
		panel1.add(label1);

		JButton buttonSave = new JButton("Save");
		buttonSave.setBounds(10, 35, 40, 40);
		buttonSave.setBorder(null);
		panel1.add(buttonSave);
		
		///////////////////////////////////////////////////////////////////////////
		//buttonSave.addActionListener(new ActionListener() {}
		///////////////////////////////////////////////////////////////////////////
	}
	
	private void createPage2() 
	{
		panel2 = new JPanel();
		panel2.setLayout(null);

		JLabel label2 = new JLabel( "Press button and load from xml file" );
		label2.setBounds(10, 15, 250, 20);
		panel2.add(label2);

		JButton buttonLoad = new JButton("Load");
		buttonLoad.setBounds(10, 35, 40, 40);
		buttonLoad.setBorder(null);
		panel2.add(buttonLoad);
		
		///////////////////////////////////////////////////////////////////////////
		//buttonLoad.addActionListener(new ActionListener() {}
		///////////////////////////////////////////////////////////////////////////
	}
	
}
