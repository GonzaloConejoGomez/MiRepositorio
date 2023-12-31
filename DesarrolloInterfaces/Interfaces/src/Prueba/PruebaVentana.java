package Prueba;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;

public class PruebaVentana {

	private JFrame frmGonzaloconejo;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					PruebaVentana window = new PruebaVentana();
					window.frmGonzaloconejo.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public PruebaVentana() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmGonzaloconejo = new JFrame();
		frmGonzaloconejo.setTitle("Gonzalo Conejo");
		frmGonzaloconejo.setBounds(100, 100, 450, 300);
		frmGonzaloconejo.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmGonzaloconejo.getContentPane().setLayout(null);
		
		JButton btnNotepad = new JButton("Notepad");
		btnNotepad.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				LanzadorProcesos p = new LanzadorProcesos();
				p.ejecutarNotepad();
			}
		});
		btnNotepad.setBounds(265, 122, 89, 23);
		frmGonzaloconejo.getContentPane().add(btnNotepad);
		
		JButton btnCalc = new JButton("Calc");
		btnCalc.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				LanzadorProcesos p = new LanzadorProcesos();
				p.ejecutarCalc();
			}
		});
		btnCalc.setBounds(86, 122, 89, 23);
		frmGonzaloconejo.getContentPane().add(btnCalc);
		
		JLabel lblGonzalo = new JLabel("Gonzalo Conejo");
		lblGonzalo.setBounds(172, 50, 112, 14);
		frmGonzaloconejo.getContentPane().add(lblGonzalo);
	}
}
