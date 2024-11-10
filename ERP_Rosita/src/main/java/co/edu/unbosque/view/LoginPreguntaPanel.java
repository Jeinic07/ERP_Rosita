package co.edu.unbosque.view;

import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;

import co.edu.unbosque.view.CompraNuevaWindow.AutoTextField;

public class LoginPreguntaPanel extends JFrame {
	
	private JButton btnValidar, btnPregunta;
	private JTextField txtRta;
	
	public LoginPreguntaPanel() {
		setBounds(369, 250, 700, 450);
		setLayout(null);
		setVisible(false);
		setUndecorated(true);
		setResizable(false);
		setLocationRelativeTo(null);
		
		
		btnValidar = new JButton("Validar");
		btnValidar.setBounds(300, 375, 87, 34);
		btnValidar.setContentAreaFilled(true);
		btnValidar.setBorderPainted(false);
		
		btnPregunta = new JButton("Cómo se llama juan?");
		btnPregunta.setBounds(10, 10, 400, 34);
		btnPregunta.setContentAreaFilled(true);
		btnPregunta.setBorderPainted(false);

		txtRta = new JTextField();
		txtRta.setBounds(49, 69, 400, 34);
		
		add(btnPregunta);
		add(btnValidar);
		add(txtRta);
		
		
	}

	public JButton getBtnValidar() {
		return btnValidar;
	}

	public void setBtnValidar(JButton btnValidar) {
		this.btnValidar = btnValidar;
	}

	public JTextField getTxtRta() {
		return txtRta;
	}

	public void setTxtRta(JTextField txtRta) {
		this.txtRta = txtRta;
	}
	
}
