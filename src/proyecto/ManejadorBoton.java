package proyecto;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;

import javax.swing.JTextField;

public class ManejadorBoton implements ActionListener{
	
	Jota jdbc=new Jota();

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		jdbc.createUser();
	}

}

class CambioFoco implements FocusListener{

	@Override
	public void focusGained(FocusEvent arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void focusLost(FocusEvent arg0) {
		// TODO Auto-generated method stub

	}

}
