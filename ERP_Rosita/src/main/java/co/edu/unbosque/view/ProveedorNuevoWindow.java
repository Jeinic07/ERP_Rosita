package co.edu.unbosque.view;

import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class ProveedorNuevoWindow extends JFrame {

	private JLabel si;
	private JTextField txtNombre, txtDocumento, txtTelefono, txtDireccion;
	private JComboBox<String> txtTipoDocumento;
	private JButton btnAdd, btnBack;

	public ProveedorNuevoWindow() {

		setBounds(650, 250, 253, 450);
		setLayout(null);
		setVisible(false);

		si = new JLabel("Añadir Proveedor");
		si.setFont(new Font("Arial", Font.PLAIN, 15));
		si.setBounds(60, 40, 171, 35);

		txtNombre = new JTextField("");
		txtNombre.setBounds(124, 90, 103, 29);

		String[] opcionesDocs = { "CC", "NIT" };
		txtTipoDocumento = new JComboBox<String>(opcionesDocs);
		txtTipoDocumento.setBounds(124, 131, 105, 28);

		txtDocumento = new JTextField("");
		txtDocumento.setBounds(124, 171, 103, 29);

		txtTelefono = new JTextField("");
		txtTelefono.setBounds(124, 212, 103, 29);

		txtDireccion = new JTextField("");
		txtDireccion.setBounds(124, 253, 103, 29);

		btnAdd = new JButton("Añadir");
		btnAdd.setBounds(84, 356, 79, 29);

		btnBack = new JButton("<-");
		btnBack.setBounds(10, 5, 50, 32);

		add(si);
		add(txtNombre);
		add(txtTipoDocumento);
		add(txtDireccion);
		add(txtDocumento);
		add(txtTelefono);
		add(btnAdd);
		add(btnBack);

	}

	public JLabel getSi() {
		return si;
	}

	public void setSi(JLabel si) {
		this.si = si;
	}

	public JTextField getTxtNombre() {
		return txtNombre;
	}

	public void setTxtNombre(JTextField txtNombre) {
		this.txtNombre = txtNombre;
	}

	public JTextField getTxtDocumento() {
		return txtDocumento;
	}

	public void setTxtDocumento(JTextField txtDocumento) {
		this.txtDocumento = txtDocumento;
	}

	public JTextField getTxtTelefono() {
		return txtTelefono;
	}

	public void setTxtTelefono(JTextField txtTelefono) {
		this.txtTelefono = txtTelefono;
	}

	public JTextField getTxtDireccion() {
		return txtDireccion;
	}

	public void setTxtDireccion(JTextField txtDireccion) {
		this.txtDireccion = txtDireccion;
	}

	public JComboBox<String> getTxtTipoDocumento() {
		return txtTipoDocumento;
	}

	public void setTxtTipoDocumento(JComboBox<String> txtTipoDocumento) {
		this.txtTipoDocumento = txtTipoDocumento;
	}

	public JButton getBtnAdd() {
		return btnAdd;
	}

	public void setBtnAdd(JButton btnAdd) {
		this.btnAdd = btnAdd;
	}

	public JButton getBtnBack() {
		return btnBack;
	}

	public void setBtnBack(JButton btnBack) {
		this.btnBack = btnBack;
	}
	
}
