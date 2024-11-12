package co.edu.unbosque.view;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.geom.RoundRectangle2D;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class LoginPreguntaPanel extends JFrame {
	
	private JButton btnValidar, closeButton, minimizeButton ;
	private JTextField txtRta;
	private Image imagenBg;
	private JPanel panel, titleBar;
	
	public LoginPreguntaPanel() {
		setSize(400, 450);
		setLayout(null);
		setVisible(false);
		setUndecorated(true);
		setResizable(false);
		setLocationRelativeTo(null);
		setShape(new RoundRectangle2D.Double(0, 0, getWidth(), getHeight(), 20, 20));

		createCustomTitleBar();

		imagenBg = new ImageIcon("src/main/java/co/edu/unbosque/view/images/Pregunta.png").getImage();
		panel = new PanelConFondo();
		panel.setBounds(0, 0, 400, 450);
		panel.setLayout(null);

		
		
		btnValidar = new JButton();
		btnValidar.setBounds(162, 301, 76, 28);
		btnValidar.setContentAreaFilled(false);
		btnValidar.setBorderPainted(false);
		
		
		txtRta = new JTextField();
		txtRta.setBounds(111, 207, 178, 28);
		
		panel.add(btnValidar);
		panel.add(txtRta);
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
			g.drawImage(imagenBg, 0, 0, getWidth(), getHeight(), this);

			Graphics2D g2d = (Graphics2D) g;
			g2d.setColor(Color.decode("#FFC581"));
			g2d.setStroke(new BasicStroke(5)); // Grosor del borde
			g2d.drawRoundRect(0, 0, getWidth() - 1, getHeight() - 1, 20, 20);
		}
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
