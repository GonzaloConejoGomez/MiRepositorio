package repasotema1;

import java.awt.EventQueue;
import java.awt.Image;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JFrame;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JCheckBox;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.ImageIcon;

public class Ejercicio1 {

	private JFrame frame;
	private JTextField textField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Ejercicio1 window = new Ejercicio1();
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
	public Ejercicio1() {
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
		textField.setBounds(179, 92, 96, 19);
		frame.getContentPane().add(textField);
		textField.setColumns(10);
		
		JLabel lblEdad = new JLabel("Indique la edad");
		lblEdad.setBounds(53, 95, 116, 15);
		frame.getContentPane().add(lblEdad);
		
		JCheckBox chckbxPrivacidad = new JCheckBox("Acepto las políticas de privacidad");
		chckbxPrivacidad.setSelected(true);
		chckbxPrivacidad.setBounds(128, 184, 216, 23);
		
		frame.getContentPane().add(chckbxPrivacidad);
		
		JButton btnClean = new JButton("Clean");
		btnClean.setIcon(new ImageIcon("C:\\Users\\gconejo2637\\Downloads\\trash-var-solid.png"));
		ImageIcon imageIcon = new ImageIcon("C:\\Users\\gconejo2637\\Downloads\\trash-var-solid.png");
		Image image = imageIcon.getImage();
		Image newimg = image.getScaledInstance(25, 25, java.awt.Image.SCALE_SMOOTH);
		imageIcon = new ImageIcon(newimg);
		btnClean.setIcon(imageIcon);
		btnClean.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textField.setText("");
			}
		});
		btnClean.setBounds(311, 86, 96, 33);
		frame.getContentPane().add(btnClean);
		
		KeyListener listener = new KeyListener() {
			
			@Override
			public void keyTyped(KeyEvent e) {
				Character c = e.getKeyChar(); // con esto obtengo el caracter
				// con esto se sabe si el caracter es un número
				if (!Character.isDigit(c) || (c.equals('0') && textField.getText().isEmpty())) {
					e.consume(); // con esto puedo evitar que el caracter se imprima
				}
			}
			
			@Override
			public void keyReleased(KeyEvent e) {
				
			}
			
			@Override
			public void keyPressed(KeyEvent e) {
				if (e.getKeyCode() == KeyEvent.VK_UP || e.getKeyCode() == KeyEvent.VK_DOWN) {
					Integer numNuevo = 1;
					if (!textField.getText().isEmpty()) {
						if (e.getKeyCode() == KeyEvent.VK_UP) {
							numNuevo = Integer.parseInt(textField.getText()) + 1;
						}
						else {
							numNuevo = Integer.parseInt(textField.getText()) - 1;
						}
					}
					if (numNuevo < 1) {
						numNuevo = 1;
					}
					textField.setText(numNuevo.toString());
				}
			}
		};
		
		ItemListener itemListener = new ItemListener() {
			
			@Override
			public void itemStateChanged(ItemEvent e) {
				JCheckBox origen = (JCheckBox) e.getSource();
				textField.setEnabled(origen.isSelected());
				
			}
		};
		
		
		
		chckbxPrivacidad.addItemListener(itemListener);
		textField.addKeyListener(listener);
	}
}
