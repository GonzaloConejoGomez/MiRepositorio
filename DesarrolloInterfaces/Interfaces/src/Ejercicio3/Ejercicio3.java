package Ejercicio3;

import java.awt.Color;
import java.awt.Container;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class Ejercicio3 {
	public static void main(String[] args) {
		JFrame ventana = new JFrame();
		ventana.setTitle("Ejemplo");
		ventana.setSize(350, 400);
		ventana.setLocationRelativeTo(null);
		ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Container contenedor = ventana.getContentPane();
		JPanel panel = new JPanel();
		GridLayout gridLayout = new GridLayout(4, 1);
		panel.setLayout(gridLayout);

		JLabel label = new JLabel();
		label.setHorizontalAlignment(JLabel.CENTER);

		ActionListener listenerBotones = new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// JButton botonOrigen = (JButton) e.getSource();
				String actionCommandOrigen = e.getActionCommand();
				// label.setText("Has hecho click en el boton " + botonOrigen.getText());
				label.setText("Has hecho click en el boton " + actionCommandOrigen);
			}
		};

		MouseListener mouseHover = new MouseListener() {

			@Override
			public void mouseReleased(MouseEvent e) {

			}

			@Override
			public void mousePressed(MouseEvent e) {

			}

			@Override
			public void mouseExited(MouseEvent e) {
				JButton botonOrigen = (JButton) e.getSource();
				botonOrigen.setBackground(new JButton().getBackground());

			}

			@Override
			public void mouseEntered(MouseEvent e) {
				JButton botonOrigen = (JButton) e.getSource();
				botonOrigen.setBackground(Color.red);
			}

			@Override
			public void mouseClicked(MouseEvent e) {
				JButton botonOrigen = (JButton) e.getSource();
				botonOrigen.setText(botonOrigen.getText() + "!");

			}
		};

		for (Integer n = 1; n <= 3; n++) {
			JButton botonN = new JButton();
			botonN.addActionListener(listenerBotones);
			botonN.addMouseListener(mouseHover);
			botonN.setText(String.valueOf(n));
			botonN.setActionCommand("Boton " + n);
			panel.add(botonN);

		}

		label.setHorizontalAlignment(JLabel.CENTER);

		panel.add(label);

		contenedor.add(panel);

		ventana.setVisible(true);
	}
}
