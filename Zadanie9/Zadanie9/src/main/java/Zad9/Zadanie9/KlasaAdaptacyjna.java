package Zad9.Zadanie9;

import java.awt.event.MouseEvent;
import javax.swing.event.MouseInputAdapter;


public class KlasaAdaptacyjna extends MouseInputAdapter {

	@Override
	public void mouseReleased(MouseEvent arg0) {
		// TODO Auto-generated method stub
		System.out.println("puszczono");
	}

	@Override
	public void mousePressed(MouseEvent arg0) {
		// TODO Auto-generated method stub
		System.out.println("naciśnięto");
	}


}
