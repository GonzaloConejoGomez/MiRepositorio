package Ejercicio12;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JPasswordField;

public class Pantalla1View extends View{
	/**
	 * 
	 */
	private static final long serialVersionUID = -7695949790165179377L;
	private JTextField textField;
	private JPasswordField passwordField;
	private JLabel lbPantalla;
	
	public Pantalla1View(App appController) {
		super(appController);
		setLayout(null);
		
		lbPantalla = new JLabel("PANTALLA 1");
		lbPantalla.setBounds(151, 134, 238, 13);
		add(lbPantalla);
		
		JButton btnIrSiguiente = new JButton("Ir a pantalla 2");
		btnIrSiguiente.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				appController.irAPantalla2();
			}
		});
		btnIrSiguiente.setBounds(275, 292, 148, 21);
		add(btnIrSiguiente);
		
		textField = new JTextField();
		textField.setBounds(201, 165, 96, 19);
		add(textField);
		textField.setColumns(10);
		
		JButton btLogin = new JButton("Login");
		btLogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String user = textField.getText();
				String pass = new String(passwordField.getPassword());
				appController.login(user, pass);
			}
		});
		btLogin.setBounds(261, 222, 85, 21);
		add(btLogin);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(201, 194, 96, 19);
		add(passwordField);
	
	}
	
	public void cambiarMensaje(String msg) {
		lbPantalla.setText(msg);
		lbPantalla.setForeground(Color.red);
	}

	
	
}
