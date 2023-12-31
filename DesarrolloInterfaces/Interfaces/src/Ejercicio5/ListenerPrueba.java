package Ejercicio5;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;
import javax.swing.JTextField;

public class ListenerPrueba implements ActionListener {
	
	private JTextField textField;
	
	public ListenerPrueba (JTextField campoTexto) {
		this.textField = campoTexto;
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		try {
			if (textField.getText().isBlank()) {
				textField.setText("1");
			} else {
				Integer numero = Integer.parseInt(textField.getText());
				textField.setText(String.valueOf(numero + 1));
			}
		} catch (NumberFormatException e1) {
			JOptionPane.showMessageDialog(null, "NO SE ADMITEN LETRAS", "Error", JOptionPane.ERROR_MESSAGE);
			textField.setText("");
		}
	}

}
