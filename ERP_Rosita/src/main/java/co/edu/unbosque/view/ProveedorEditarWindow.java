package co.edu.unbosque.view;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.geom.RoundRectangle2D;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.LineBorder;


public class ProveedorEditarWindow extends JFrame{

	private JTextField txtNombre, txtDocumento, txtTelefono, txtDireccion;
	private JComboBox<String> txtTipoDocumento;
	private Image imageBg;
	private JPanel panel, titleBar;
	private LineBorder customBorder;
	private JButton btnConfirm, btnBack, closeButton, minimizeButton;

	public ProveedorEditarWindow() {

		setSize(253, 412);
		setLayout(null);
		setLayout(null);
		setLocationRelativeTo(null);
		setResizable(false);
		setUndecorated(true);
		setVisible(false);
		setVisible(false);
		setShape(new RoundRectangle2D.Double(0, 0, getWidth(), getHeight(), 20, 20));

		createCustomTitleBar();

		customBorder = new LineBorder(Color.decode("#FFC581"), 2, true);

		
		imageBg = new ImageIcon("src/main/java/co/edu/unbosque/view/images/EditProveedor.png").getImage();
        panel = new PanelConFondo();
        panel.setBounds(0, 0, 253, 412);
        panel.setLayout(null);

        txtNombre = new JTextField("");
		txtNombre.setBounds(119, 136, 99, 25);
		txtNombre.setBorder(customBorder);
		txtNombre.setBackground(Color.decode("#FFF9F3"));

		String[] opcionesDocs = { "CC", "NIT" };
		txtTipoDocumento = new JComboBox<String>(opcionesDocs);
		txtTipoDocumento.setBounds(119, 176, 99, 25);
		txtTipoDocumento.setBorder(customBorder);
		txtTipoDocumento.setBackground(Color.decode("#FFF9F3"));
		txtTipoDocumento.setFocusable(false);
		


		txtDocumento = new JTextField("");
		txtDocumento.setBounds(119, 216, 99, 25);
		txtDocumento.setBorder(customBorder);
		txtDocumento.setBackground(Color.decode("#FFF9F3"));


		txtTelefono = new JTextField("");
		txtTelefono.setBounds(119, 256, 99, 25);
		txtTelefono.setBorder(customBorder);
		txtTelefono.setBackground(Color.decode("#FFF9F3"));


		txtDireccion = new JTextField("");
		txtDireccion.setBounds(119, 296, 99, 25);
		txtDireccion.setBorder(customBorder);
		txtDireccion.setBackground(Color.decode("#FFF9F3"));

		btnConfirm = new JButton();
		btnConfirm.setBounds(88, 324, 76, 29);
		btnConfirm.setContentAreaFilled(false);
		btnConfirm.setBorderPainted(false);
		btnConfirm.setFocusPainted(false);

		btnBack = new JButton();
		btnBack.setBounds(18, 37, 36, 36);
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
	
	private void createCustomTitleBar() {
		// Crear el panel de la barra de título
		titleBar = new JPanel();
		titleBar.setBackground(Color.decode("#FFC581"));
		titleBar.setLayout(null);
		titleBar.setBounds(0, 0, getWidth(), 30);

		minimizeButton = new JButton("-");
		minimizeButton.setForeground(Color.WHITE);
		minimizeButton.setBackground(Color.decode("#FFC581"));
		minimizeButton.setFocusPainted(false);
		minimizeButton.setBorderPainted(false);
		minimizeButton.setBounds(getWidth() - 80, 0, 40, 30);

		// Cambiar color al hacer hover en el botón de minimizar, va a controller
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

		minimizeButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				setState(JFrame.ICONIFIED);
			}
		});

		// Botón de cerrar
		closeButton = new JButton("x");
		closeButton.setForeground(Color.WHITE);
		closeButton.setBackground(Color.decode("#FFC581"));
		closeButton.setFocusPainted(false);
		closeButton.setBorderPainted(false);
		closeButton.setBounds(getWidth() - 40, 0, 40, 30);
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
				setVisible(false);
			}
		});

		titleBar.add(minimizeButton);
		titleBar.add(closeButton);
		add(titleBar);
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
