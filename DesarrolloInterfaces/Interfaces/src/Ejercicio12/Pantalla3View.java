package Ejercicio12;

import javax.swing.JLabel;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

public class Pantalla3View extends View{
	public Pantalla3View(App appController) {
		super(appController);
		setLayout(null);
		
		JLabel lbPantalla = new JLabel("PANTALLA 3");
		lbPantalla.setBounds(151, 134, 238, 13);
		add(lbPantalla);
		
		JButton btnIrSiguiente = new JButton("Ir a pantalla 1");
		btnIrSiguiente.setBounds(275, 292, 148, 21);
		btnIrSiguiente.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				appController.irAPantalla1();
			}
		});
		add(btnIrSiguiente);
	}

	/**
	 * 
	 */
	private static final long serialVersionUID = -7695949790165179377L;
}
