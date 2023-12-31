package Ejercicio5;

import java.awt.Container;
import java.awt.GridLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class Ejercicio5 {
	public static void main(String[] args) {
		JFrame ventana = new JFrame();
		ventana.setTitle("Ejemplo");
		ventana.setSize(200, 200);
		ventana.setLocationRelativeTo(null);
		ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Container contenedor = ventana.getContentPane();
		JPanel panel = new JPanel();
		GridLayout gridLayout = new GridLayout(2, 1);
		panel.setLayout(gridLayout);
		JTextField textField = new JTextField();
		textField.setHorizontalAlignment(JTextField.CENTER);

		ListenerPrueba listenerBotones = new ListenerPrueba(textField);
		
		JButton botonN = new JButton();
		botonN.addActionListener(listenerBotones);
		botonN.setText("Sumar");
		panel.add(botonN);

		panel.add(textField);

		contenedor.add(panel);

		ventana.setVisible(true);
	}
}