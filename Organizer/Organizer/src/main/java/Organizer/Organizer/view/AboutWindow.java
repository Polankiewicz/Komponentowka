package Organizer.Organizer.view;

import javax.swing.JFrame;
import javax.swing.JLabel;

public class AboutWindow
{
	private JFrame frame;
	private JLabel label1, label2, label3;
	
	public void showWindow()
	{
		frame = new JFrame();
		frame.setSize(200, 150);
		frame.setLocation(500, 150);
		frame.setLayout(null);
		frame.setResizable(false);
		
		label1 = new JLabel("Authors:");
		label1.setBounds(10, 15, 50, 20);
		frame.add(label1);
		
		label2 = new JLabel("Damian Polankiewicz 180670");
		label2.setBounds(10, 35, 180, 20);
		frame.add(label2);
		
		label3 = new JLabel("Patrycja Bubas 180511");
		label3.setBounds(10, 55, 180, 20);
		frame.add(label3);
		
		frame.setVisible(true);
	}
}
