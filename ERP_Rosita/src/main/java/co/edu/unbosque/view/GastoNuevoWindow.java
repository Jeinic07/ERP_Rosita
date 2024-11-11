package co.edu.unbosque.view;

import java.awt.*;
import java.awt.event.*;
import java.awt.geom.*;
import javax.swing.*;
import javax.swing.border.*;

public class GastoNuevoWindow extends JFrame {

	private JButton btnBack, btnAdd, minimizeButton, closeButton;
	private JTextField txtDescripcion, txtValor;
	private Image imageBg;
	private JPanel panel, titleBar;
	private LineBorder customBorder;

	public GastoNuevoWindow() {
		setSize(253, 412);
		setLayout(null);
		setLayout(null);
		setLocationRelativeTo(null);
		setResizable(false);
		setUndecorated(true);
		setVisible(false);
		setShape(new RoundRectangle2D.Double(0, 0, getWidth(), getHeight(), 20, 20));

		createCustomTitleBar();
		customBorder = new LineBorder(Color.decode("#FFC581"), 2, true);

		imageBg = new ImageIcon("src/main/java/co/edu/unbosque/view/images/GastosAgregar.png").getImage();
		panel = new PanelConFondo();
		panel.setBounds(0, 0, 253, 412);
		panel.setLayout(null);

		txtDescripcion = new JTextField("");
		txtDescripcion.setBounds(119, 173, 99, 25);
		txtDescripcion.setBorder(customBorder);
		txtDescripcion.setBackground(Color.decode("#FFF9F3"));

		txtValor = new JTextField("");
		txtValor.setBounds(119, 214, 99, 25);
		txtValor.setBorder(customBorder);
		txtValor.setBackground(Color.decode("#FFF9F3"));

		btnAdd = new JButton();
		btnAdd.setBounds(88, 340, 76, 29);
		btnAdd.setContentAreaFilled(false);
		btnAdd.setBorderPainted(false);
		btnAdd.setFocusPainted(false);

		btnBack = new JButton();
		btnBack.setBounds(18, 37, 36, 36);
		btnBack.setContentAreaFilled(false);
		btnBack.setBorderPainted(false);
		btnBack.setFocusPainted(false);

		panel.add(btnAdd);
		panel.add(btnBack);
		panel.add(txtDescripcion);
		panel.add(txtValor);
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
			g.drawImage(imageBg, 0, 0, getWidth(), getHeight(), this);

			Graphics2D g2d = (Graphics2D) g;
			g2d.setColor(Color.decode("#FFBA68"));
			g2d.setStroke(new BasicStroke(5)); // Grosor del borde
			g2d.drawRoundRect(0, 0, getWidth() - 1, getHeight() - 1, 20, 20);
		}
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
