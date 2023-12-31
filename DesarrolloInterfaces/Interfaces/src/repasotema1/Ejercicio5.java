package repasotema1;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JFrame;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JComboBox;
import javax.swing.JButton;

public class Ejercicio5 {

	private JFrame frame;
	private JTextField textField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Ejercicio5 window = new Ejercicio5();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Ejercicio5() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);

		textField = new JTextField();
		textField.setBounds(238, 77, 123, 20);
		frame.getContentPane().add(textField);
		textField.setColumns(10);

		JLabel lblCiudad = new JLabel("Nueva Ciudad:");
		lblCiudad.setBounds(90, 80, 100, 14);
		frame.getContentPane().add(lblCiudad);

		JComboBox<String> comboBox = new JComboBox<>();
		comboBox.setBounds(238, 139, 123, 22);
		frame.getContentPane().add(comboBox);

		JLabel lblDestinosDisponibles = new JLabel("Destinos Disponibles:");
		lblDestinosDisponibles.setBounds(67, 143, 123, 14);
		frame.getContentPane().add(lblDestinosDisponibles);

		JButton btnClean = new JButton("Clean");
		btnClean.setBounds(169, 26, 89, 23);
		frame.getContentPane().add(btnClean);

		JButton btnSeleccionar = new JButton("Seleccionar");
		btnSeleccionar.setEnabled(false);
		btnSeleccionar.setBounds(49, 197, 107, 23);
		frame.getContentPane().add(btnSeleccionar);

		JLabel lblCiudadSeleccion = new JLabel("");
		lblCiudadSeleccion.setBounds(199, 201, 225, 14);
		frame.getContentPane().add(lblCiudadSeleccion);

		btnSeleccionar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				lblCiudadSeleccion.setText("Ciudad seleccionada: " + comboBox.getSelectedItem());
			}
		});
		
		btnClean.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				comboBox.removeAllItems();
				
			}
		});
		
		KeyListener listener = new KeyListener() {

			@Override
			public void keyTyped(KeyEvent e) {

			}

			@Override
			public void keyReleased(KeyEvent e) {

			}

			@Override
			public void keyPressed(KeyEvent e) {
				if (e.getKeyCode() == KeyEvent.VK_ENTER) {
					comboBox.addItem(textField.getText());
					comboBox.setSelectedIndex(-1);
					textField.setText("");
				}

			}
		};
		
		ItemListener itemListener = new ItemListener() {
			
			@Override
			public void itemStateChanged(ItemEvent e) {
				if(comboBox.getSelectedIndex()>=0) {
					btnSeleccionar.setEnabled(true);
				} else {
					btnSeleccionar.setEnabled(false);
					lblCiudadSeleccion.setText("");
				}
				
			}
		};
		comboBox.addItemListener(itemListener);
		textField.addKeyListener(listener);

	}
}
