package co.edu.unbosque.view;

import java.awt.Graphics;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;


public class ProveedorEditarWindow extends JFrame{

	private JTextField txtNombre, txtDocumento, txtTelefono, txtDireccion;
	private JComboBox<String> txtTipoDocumento;
	private Image imageBg;
	private JPanel panel;
	private JButton btnConfirm, btnBack;

	public ProveedorEditarWindow() {

		setSize(253, 412);
		setLayout(null);
		setLayout(null);
		setLocationRelativeTo(null);
		setResizable(false);
		setUndecorated(true);
		setVisible(false);
		setVisible(false);

		
		imageBg = new ImageIcon("src/main/java/co/edu/unbosque/view/images/AddProveedor.png").getImage();
        panel = new PanelConFondo();
        panel.setBounds(0, 0, 253, 412);
        panel.setLayout(null);

		txtNombre = new JTextField("");
		txtNombre.setBounds(116, 97, 99, 25);

		String[] opcionesDocs = { "CC", "NIT" };
		txtTipoDocumento = new JComboBox<String>(opcionesDocs);
		txtTipoDocumento.setBounds(116, 137, 99, 25);

		txtDocumento = new JTextField("");
		txtDocumento.setBounds(116, 177, 99, 25);

		txtTelefono = new JTextField("");
		txtTelefono.setBounds(116, 217, 99, 25);

		txtDireccion = new JTextField("");
		txtDireccion.setBounds(116, 257, 99, 25);

		btnConfirm = new JButton();
		btnConfirm.setBounds(84, 312, 84, 40);
		btnConfirm.setContentAreaFilled(false);
		btnConfirm.setBorderPainted(false);
		btnConfirm.setFocusPainted(false);

		btnBack = new JButton();
		btnBack.setBounds(8, 5, 30, 27);
		btnBack.setContentAreaFilled(false);
		btnBack.setBorderPainted(false);
		btnBack.setFocusPainted(false);

		panel.add(txtNombre);
		panel.add(txtTipoDocumento);
		panel.add(txtDireccion);
		panel.add(txtDocumento);
		panel.add(txtTelefono);
		panel.add(btnConfirm);
		panel.add(btnBack);
		add(panel);

	}
	
	private class PanelConFondo extends JPanel {
        @Override
        protected void paintComponent(Graphics g) {
            super.paintComponent(g);
            // Dibujar la imagen de fondo
            g.drawImage(imageBg, 0, 0, getWidth(), getHeight(), this);
        }
    }

	
	
	public Image getImageBg() {
		return imageBg;
	}

	public void setImageBg(Image imageBg) {
		this.imageBg = imageBg;
	}

	public JPanel getPanel() {
		return panel;
	}

	public void setPanel(JPanel panel) {
		this.panel = panel;
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



	public JButton getBtnConfirm() {
		return btnConfirm;
	}

	public void setBtnConfirm(JButton btnConfirm) {
		this.btnConfirm = btnConfirm;
	}

	public JButton getBtnBack() {
		return btnBack;
	}

	public void setBtnBack(JButton btnBack) {
		this.btnBack = btnBack;
	}
	
		
}
