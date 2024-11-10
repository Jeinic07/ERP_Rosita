package co.edu.unbosque.view;

import java.awt.Color;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;

public class LoginPanel extends JFrame{

	private JPanel panel;
	private JButton btnIngresar, btnOlvidoContra;
	private JTextField txtUser, txtContra;
	private MainWindow mw;
	
	public LoginPanel() {
		
		mw = new MainWindow();
		
		setTitle("penme");
		setSize(800, 600);
		setLayout(null);
		setUndecorated(true);
		setResizable(false);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		
        
        btnIngresar = new JButton("Ingresar");
        btnIngresar.setBounds(300, 430, 133, 40);
        btnIngresar.setContentAreaFilled(true);
        btnIngresar.setBorderPainted(false);
        btnIngresar.setFocusPainted(false);
		
        btnOlvidoContra = new JButton("Olvidó la contraseña?");
        btnOlvidoContra.setBounds(300, 490, 133, 40);
        btnOlvidoContra.setContentAreaFilled(true);
        btnOlvidoContra.setBorderPainted(false);
        btnOlvidoContra.setFocusPainted(false);
		
        txtUser = new JTextField("Usuario");
        txtUser.setBounds(300, 340, 133, 40);
        txtUser.setForeground(Color.GRAY);
        txtUser.addFocusListener(new PlaceholderFocusListener(txtUser, "Usuario"));
		
        txtContra = new JTextField("Contraseña");
        txtContra.setBounds(300, 380, 133, 40);
        txtContra.setForeground(Color.GRAY);
        txtContra.addFocusListener(new PlaceholderFocusListener(txtContra, "Contraseña"));
		
        
        add(btnIngresar);
        add(btnOlvidoContra);
        add(txtUser);
        add(txtContra);
        
        setVisible(true);
		
	}

	
	// Clase interna para manejar el placeholder
    private class PlaceholderFocusListener implements FocusListener {
        private JTextField textField;
        private String placeholder;

        public PlaceholderFocusListener(JTextField textField, String placeholder) {
            this.textField = textField;
            this.placeholder = placeholder;
        }

        @Override
        public void focusGained(FocusEvent e) {
            // Al hacer clic, borrar el placeholder si es necesario
            if (textField.getText().equals(placeholder)) {
                textField.setText("");
                textField.setForeground(Color.BLACK);
            }
        }

        @Override
        public void focusLost(FocusEvent e) {
            // Si el campo está vacío al deseleccionar, volver a mostrar el placeholder
            if (textField.getText().isEmpty()) {
                textField.setText(placeholder);
                textField.setForeground(Color.GRAY);
            }
        }
    }
	public JPanel getPanel() {
		return panel;
	}

	public void setPanel(JPanel panel) {
		this.panel = panel;
	}

	public JButton getBtnIngresar() {
		return btnIngresar;
	}

	public void setBtnIngresar(JButton btnIngresar) {
		this.btnIngresar = btnIngresar;
	}

	public JButton getBtnOlvidoContra() {
		return btnOlvidoContra;
	}

	public void setBtnOlvidoContra(JButton btnOlvidoContra) {
		this.btnOlvidoContra = btnOlvidoContra;
	}

	public JTextField getTxtUser() {
		return txtUser;
	}

	public void setTxtUser(JTextField txtUser) {
		this.txtUser = txtUser;
	}

	public JTextField getTxtContra() {
		return txtContra;
	}

	public void setTxtContra(JTextField txtContra) {
		this.txtContra = txtContra;
	}
}
