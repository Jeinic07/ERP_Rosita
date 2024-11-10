package co.edu.unbosque.view;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class GastoNuevoWindow extends JFrame {
	
	private JButton btnBack, btnAdd;
	private JTextField txtDescripcion, txtValor;
	

	public GastoNuevoWindow() {
		setSize(253, 412);
		setLayout(null);
		setLayout(null);
		setLocationRelativeTo(null);
		setResizable(false);
		setUndecorated(true);
		setVisible(false);
		
		btnBack = new JButton("<-");
		btnBack.setBounds(10, 5, 50, 32);
		btnBack.setContentAreaFilled(false);
		btnBack.setBorderPainted(false);
		
		btnAdd = new JButton("Añadir");
		btnAdd.setBounds(84, 312, 84, 40);
		btnAdd.setContentAreaFilled(false);
		btnAdd.setBorderPainted(false);
		
		txtDescripcion = new JTextField("");
		txtDescripcion.setBounds(116, 97, 99, 170);
		
		txtValor = new JTextField("");
		txtValor.setBounds(116, 300, 99, 25);
		
		add(btnAdd);
		add(btnBack);
		add(txtDescripcion);
		add(txtValor);
		
		
		
		
	}


	public JButton getBtnBack() {
		return btnBack;
	}


	public void setBtnBack(JButton btnBack) {
		this.btnBack = btnBack;
	}


	public JButton getBtnAdd() {
		return btnAdd;
	}


	public void setBtnAdd(JButton btnAdd) {
		this.btnAdd = btnAdd;
	}


	public JTextField getTxtDescripcion() {
		return txtDescripcion;
	}


	public void setTxtDescripcion(JTextField txtDescripcion) {
		this.txtDescripcion = txtDescripcion;
	}


	public JTextField getTxtValor() {
		return txtValor;
	}


	public void setTxtValor(JTextField txtValor) {
		this.txtValor = txtValor;
	}

	
}
