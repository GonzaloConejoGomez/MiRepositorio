package Ejercicio12;

import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Pantalla2View extends View{
	public Pantalla2View(App appController) {
		super(appController);
		setLayout(null);
		
		JLabel lbPantalla = new JLabel("PANTALLA 2");
		lbPantalla.setBounds(151, 134, 238, 13);
		add(lbPantalla);
		
		JButton btnIrSiguiente = new JButton("Ir a pantalla 3");
		btnIrSiguiente.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				appController.irAPantalla3();
			}
		});
		btnIrSiguiente.setBounds(275, 292, 148, 21);
		add(btnIrSiguiente);
	}

	/**
	 * 
	 */
	private static final long serialVersionUID = -7695949790165179377L;
}
