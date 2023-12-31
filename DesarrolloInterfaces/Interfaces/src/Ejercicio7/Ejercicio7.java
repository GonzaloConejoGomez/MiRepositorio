package Ejercicio7;

import java.awt.Color;
import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JTextField;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.ButtonGroup;
import javax.swing.JComboBox;
import javax.swing.JRadioButton;

public class Ejercicio7 {

	private JFrame frame;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JComboBox<String> comboBox;
	private JRadioButton rdbtnVerde;
	private JRadioButton rdbtnAmarillo;
	private JRadioButton rdbtnRojo;
	private JRadioButton rdbtnAzul;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Ejercicio7 window = new Ejercicio7();
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
	public Ejercicio7() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {

		KeyListener keyListener = new KeyListener() {

			@Override
			public void keyTyped(KeyEvent e) {
				Character c = e.getKeyChar();
				if (!Character.isDigit(c)) {
					e.consume();
				}

			}

			@Override
			public void keyReleased(KeyEvent e) {

			}

			@Override
			public void keyPressed(KeyEvent e) {
				JTextField origen = (JTextField) e.getSource();
				
				if (origen.getText().isEmpty() && (e.getKeyCode() == KeyEvent.VK_DOWN || e.getKeyCode() == KeyEvent.VK_UP)) {
					origen.setText("1");

				} else if (e.getKeyCode() == KeyEvent.VK_DOWN && Integer.parseInt(origen.getText()) > 1) {
					Integer resta = Integer.parseInt(origen.getText()) - 1;
					origen.setText("" + resta);

				} else if (e.getKeyCode() == KeyEvent.VK_UP) {
					Integer suma = Integer.parseInt(origen.getText()) + 1;
					origen.setText("" + suma);
				}

			}
		};

		FocusListener focusListener = new FocusListener() {

			@Override
			public void focusLost(FocusEvent e) {
				e.getComponent().setBackground(null);

			}

			@Override
			public void focusGained(FocusEvent e) {
				JTextField origen = (JTextField) e.getSource();

				if (comboBox.getSelectedItem().equals("Verde")) {
					origen.setBackground(Color.GREEN);
				} else if (comboBox.getSelectedItem().equals("Amarillo")) {
					origen.setBackground(Color.YELLOW);
				} else if (comboBox.getSelectedItem().equals("Rojo")) {
					origen.setBackground(Color.RED);
				} else if (comboBox.getSelectedItem().equals("Azul")) {
					origen.setBackground(Color.BLUE);
				}

			}
		};

		ItemListener itemListener = new ItemListener() {

			@Override
			public void itemStateChanged(ItemEvent e) {
				rdbtnVerde.setSelected(comboBox.getSelectedItem().equals("Verde"));
				rdbtnAmarillo.setSelected(comboBox.getSelectedItem().equals("Amarillo"));
				rdbtnRojo.setSelected(comboBox.getSelectedItem().equals("Rojo"));
				rdbtnAzul.setSelected(comboBox.getSelectedItem().equals("Azul"));

			}
		};

		ActionListener actionListener = new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				JRadioButton origen = (JRadioButton) e.getSource();
				comboBox.setSelectedItem(origen.getText());

			}
		};

		frame = new JFrame();
		frame.setBounds(100, 100, 249, 259);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);

		textField = new JTextField();
		textField.setBounds(22, 28, 86, 20);
		frame.getContentPane().add(textField);
		textField.setColumns(10);
		textField.addKeyListener(keyListener);
		textField.addFocusListener(focusListener);

		textField_1 = new JTextField();
		textField_1.setBounds(22, 70, 86, 20);
		frame.getContentPane().add(textField_1);
		textField_1.setColumns(10);
		textField_1.addKeyListener(keyListener);
		textField_1.addFocusListener(focusListener);

		textField_2 = new JTextField();
		textField_2.setBounds(22, 112, 86, 20);
		frame.getContentPane().add(textField_2);
		textField_2.setColumns(10);
		textField_2.addKeyListener(keyListener);
		textField_2.addFocusListener(focusListener);

		textField_3 = new JTextField();
		textField_3.setBounds(22, 151, 86, 20);
		frame.getContentPane().add(textField_3);
		textField_3.setColumns(10);
		textField_3.addKeyListener(keyListener);
		textField_3.addFocusListener(focusListener);

		comboBox = new JComboBox<>();
		comboBox.setBounds(124, 27, 99, 22);
		comboBox.addItem("Verde");
		comboBox.addItem("Amarillo");
		comboBox.addItem("Rojo");
		comboBox.addItem("Azul");
		frame.getContentPane().add(comboBox);

		rdbtnVerde = new JRadioButton("Verde");
		rdbtnVerde.setBounds(134, 56, 109, 23);
		frame.getContentPane().add(rdbtnVerde);

		rdbtnAmarillo = new JRadioButton("Amarillo");
		rdbtnAmarillo.setBounds(134, 85, 109, 23);
		frame.getContentPane().add(rdbtnAmarillo);

		rdbtnRojo = new JRadioButton("Rojo");
		rdbtnRojo.setBounds(134, 111, 109, 23);
		frame.getContentPane().add(rdbtnRojo);

		rdbtnAzul = new JRadioButton("Azul");
		rdbtnAzul.setBounds(134, 137, 109, 23);
		frame.getContentPane().add(rdbtnAzul);

		ButtonGroup grupo = new ButtonGroup();
		grupo.add(rdbtnVerde);
		grupo.add(rdbtnAmarillo);
		grupo.add(rdbtnRojo);
		grupo.add(rdbtnAzul);
		grupo.add(rdbtnAmarillo);

		rdbtnAmarillo.addActionListener(actionListener);
		rdbtnVerde.addActionListener(actionListener);
		rdbtnRojo.addActionListener(actionListener);
		rdbtnAzul.addActionListener(actionListener);
		comboBox.addItemListener(itemListener);
	}
}
