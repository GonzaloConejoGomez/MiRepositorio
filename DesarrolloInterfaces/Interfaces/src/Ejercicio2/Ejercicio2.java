package Ejercicio2;

import java.awt.Container;
import java.awt.GridLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class Ejercicio2 {
	public static void main(String[] args) {
		JFrame ventana = new JFrame();
		ventana.setTitle("Ejemplo");
		ventana.setSize(300, 200);
		ventana.setLocationRelativeTo(null);
		ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Container contenedor = ventana.getContentPane();
		JPanel panel = new JPanel();
		GridLayout gridLayout = new GridLayout(4, 2);
		panel.setLayout(gridLayout);
		panel.add(new JLabel("Nombre:"));
		panel.add(new JTextField(2));
		panel.add(new JLabel("DNI:"));
		panel.add(new JTextField(2));
		panel.add(new JLabel("Fecha de nacimiento:"));

		JPanel panelFecha = new JPanel();
		panelFecha.add(new JTextField(2));
		panelFecha.add(new JLabel("/"));
		panelFecha.add(new JTextField(2));
		panelFecha.add(new JLabel("/"));
		panelFecha.add(new JTextField(2));
		panel.add(panelFecha);

		JPanel aceptarBoton = new JPanel();
		JButton aceptar = new JButton();
		aceptar.setText("Aceptar");
		aceptarBoton.add(aceptar);
		panel.add(aceptarBoton);
		
	
		
		panel.add(aceptarBoton);
		
		JPanel cancelarBoton = new JPanel();
		JButton cancelar = new JButton();
		cancelar.setText("cancelar");
		cancelarBoton.add(cancelar);
		panel.add(cancelarBoton);

		contenedor.add(panel);

		ventana.setVisible(true);
	}
}
