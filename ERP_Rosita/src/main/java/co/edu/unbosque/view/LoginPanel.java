package co.edu.unbosque.view;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.geom.*;

public class LoginPanel extends JFrame {

	private JPanel panel, titleBar;
	private JButton btnIngresar, btnOlvidoContra, closeButton, minimizeButton;
	private JTextField txtUser, txtContra;
	private Image imageBg;

	public LoginPanel() {
		setSize(800, 600);
		setLayout(null);
		setUndecorated(true);
		setResizable(false);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(EXIT_ON_CLOSE);

		setShape(new RoundRectangle2D.Double(0, 0, getWidth(), getHeight(), 20, 20));
		createCustomTitleBar();

		imageBg = new ImageIcon("src/main/java/co/edu/unbosque/view/images/Main.png").getImage();
		panel = new PanelConFondo();
		panel.setBounds(0, 0, 800, 600);
		panel.setLayout(null);

		btnIngresar = new JButton();
		btnIngresar.setBounds(343, 402, 114, 37);
		btnIngresar.setContentAreaFilled(false);
		btnIngresar.setBorderPainted(false);
		btnIngresar.setFocusPainted(false);

		btnOlvidoContra = new JButton();
		btnOlvidoContra.setBounds(336, 364, 127, 20);
		btnOlvidoContra.setContentAreaFilled(false);
		btnOlvidoContra.setBorderPainted(false);
		btnOlvidoContra.setFocusPainted(false);

		txtUser = new JTextField("Usuario");
		txtUser.setBounds(307, 256, 185, 36);
		txtUser.addFocusListener(new PlaceholderFocusListener(txtUser, "Usuario"));

		txtContra = new JTextField("Contraseña");
		txtContra.setBounds(307, 310, 185, 36);
		txtContra.addFocusListener(new PlaceholderFocusListener(txtContra, "Contraseña"));

		panel.add(btnIngresar);
		panel.add(btnOlvidoContra);
		panel.add(txtUser);
		panel.add(txtContra);
		add(panel);

		setVisible(true);

	}
	
	private void createCustomTitleBar() {
		// Crear el panel de la barra de título
		titleBar = new JPanel();
		titleBar.setBackground(Color.decode("#FFC581")); // Fondo naranja
		titleBar.setLayout(null); // Usar layout null para posicionar botones manualmente
		titleBar.setBounds(0, 0, getWidth(), 30); // Posicionar en la parte superior
		minimizeButton = new JButton("-");
		minimizeButton.setForeground(Color.WHITE);
		minimizeButton.setBackground(Color.decode("#FFC581"));
		minimizeButton.setFocusPainted(false);
		minimizeButton.setBorderPainted(false);
		minimizeButton.setBounds(getWidth() - 80, 0, 40, 30);
		// Cambiar color al hacer hover en el botón de minimizar
		minimizeButton.addMouseListener(new MouseAdapter() {
			Color originalColor = minimizeButton.getBackground();
			Color hoverColor = new Color(255, 140, 0);

			@Override
			public void mouseEntered(MouseEvent e) {
				minimizeButton.setBackground(hoverColor);
			}

			@Override
			public void mouseExited(MouseEvent e) {
				minimizeButton.setBackground(originalColor);
			}
		});
		// Botón de cerrar
		closeButton = new JButton("x");
		closeButton.setForeground(Color.WHITE);
		closeButton.setBackground(Color.decode("#FFC581")); // Color aún más oscuro
		closeButton.setFocusPainted(false);
		closeButton.setBorderPainted(false);
		closeButton.setBounds(getWidth() - 40, 0, 40, 30); // Posicionar el botón
		// para el controller
		closeButton.addMouseListener(new MouseAdapter() {
			Color originalColor = closeButton.getBackground();
			Color hoverColor = new Color(255, 0, 0);

			@Override
			public void mouseEntered(MouseEvent e) {
				closeButton.setBackground(hoverColor);
			}

			@Override
			public void mouseExited(MouseEvent e) {
				closeButton.setBackground(originalColor);
			}
		});

		closeButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				System.exit(0); // Cerrar la aplicación
			}
		});
		titleBar.add(minimizeButton);
		titleBar.add(closeButton);
		add(titleBar);
	}

	// Dibujar la imagen de fondo
	private class PanelConFondo extends JPanel {
		@Override
		protected void paintComponent(Graphics g) {
			super.paintComponent(g);
			g.drawImage(imageBg, 0, 0, getWidth(), getHeight(), this);
		}
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
	
	

	public JPanel getTitleBar() {
		return titleBar;
	}

	public void setTitleBar(JPanel titleBar) {
		this.titleBar = titleBar;
	}

	public JButton getCloseButton() {
		return closeButton;
	}

	public void setCloseButton(JButton closeButton) {
		this.closeButton = closeButton;
	}

	public JButton getMinimizeButton() {
		return minimizeButton;
	}

	public void setMinimizeButton(JButton minimizeButton) {
		this.minimizeButton = minimizeButton;
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
