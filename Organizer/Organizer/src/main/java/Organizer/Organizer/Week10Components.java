package Organizer.Organizer;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JColorChooser;
import javax.swing.JFrame;

public class Week10Components implements ActionListener
{
	private JFrame frame;
	// JColorChooser - change color
	private JButton colorButton;
	private Color newColor;
	// next component :P
	// ...
	
	public void showWindow() 
	{
		// JFrame - window settings
		frame = new JFrame("Week 10 Components");
		frame.setSize(300, 250);
		frame.setLocation(500, 150);
		frame.getContentPane().setLayout(null);
		frame.setResizable(false);
		
		// JColorChooser - change color
		colorButton = new JButton("Color");
		colorButton.setBounds(20, 20, 40, 40);
		colorButton.setBorder(null);
		frame.add(colorButton);
		colorButton.setToolTipText("Click this button to change color");
		colorButton.addActionListener(this);
		
		// next component :P
		// ...
		
		
		frame.setVisible(true);
	}

	
	public void actionPerformed(ActionEvent e) 
	{
		// JColorChooser - change color
		if(e.getActionCommand().equals("Color"))
		{
			newColor = JColorChooser.showDialog(colorButton, "Change color", Color.green);
			colorButton.setBackground(newColor);
		}
		
		// next component :P
		// ...
		
	}
	
}
