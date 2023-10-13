package Interfaz;

import java.awt.Container;
//import java.awt.FlowLayout;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class Ventana {

	public static void main(String[] args) {
		JFrame ventana = new JFrame();
		ventana.setTitle("Ejemplo");
		ventana.setSize(700, 500);
		ventana.setLocationRelativeTo(null);
		ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Container contenedor = ventana.getContentPane();

		JPanel panelPrimeraCelda = new JPanel();
		GridLayout gridLayoutCelda = new GridLayout(1, 2);
		panelPrimeraCelda.setLayout(gridLayoutCelda);
		contenedor.add(panelPrimeraCelda);
		for (Integer n = 1; n <= 2; n++) {
			JButton botonN = new JButton();
			botonN.setText("Boton PrimCelda " + n);
			panelPrimeraCelda.add(botonN);

		}

		for (Integer n = 1; n <= 7; n++) {
			JButton botonN = new JButton();
			botonN.setText("Boton " + n);
			contenedor.add(botonN);

		}

		// FlowLayout layout = new FlowLayout();
		GridLayout gridLayout = new GridLayout(4, 2);
		ventana.setLayout(gridLayout);

		ventana.setVisible(true);
	}
}
