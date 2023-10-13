package Ejercicio1;

import java.awt.Container;
import java.awt.GridLayout;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class Ejercicio1 {

	public static void main(String[] args) {
		JFrame ventana = new JFrame();
		ventana.setTitle("Ejemplo");
		ventana.setSize(700, 500);
		ventana.setLocationRelativeTo(null);
		ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Container contenedor = ventana.getContentPane();
		GridLayout gridLayout = new GridLayout(3, 2);
		ventana.setLayout(gridLayout);
		for (Integer n = 1; n <= 5; n++) {
			JLabel label = new JLabel();
			label.setText("Texto" + n);
			contenedor.add(label);

		}
		JPanel panelPrimeraCelda = new JPanel();
		GridLayout gridLayoutCelda = new GridLayout(2, 2);
		panelPrimeraCelda.setLayout(gridLayoutCelda);
		contenedor.add(panelPrimeraCelda);
		for (Integer n = 1; n <= 4; n++) {
			JLabel labelN = new JLabel();
			labelN.setText("Texto6" + n);
			panelPrimeraCelda.add(labelN);

		}
		ventana.setVisible(true);
	}
}
