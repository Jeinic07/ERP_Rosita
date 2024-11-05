package co.edu.unbosque.view;

import java.awt.Graphics;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;


public class OptionPanelInfo extends JFrame {

	private Image imagenBg;
	private JPanel panel;
	private JButton btnOk;

	public OptionPanelInfo() {
		setSize(253, 450);
		setLayout(null);
		setLocationRelativeTo(null);
		setResizable(false);
		setUndecorated(true);
		setVisible(false);
		
        imagenBg = new ImageIcon("src/main/java/co/edu/unbosque/view/images/InfoSelec.png").getImage();
        panel = new PanelConFondo();
        panel.setBounds(0, 0, 253, 450);
        panel.setLayout(null);
        
        btnOk = new JButton();
        btnOk.setBounds(71, 299, 112, 34);
        btnOk.setContentAreaFilled(false);
        btnOk.setBorderPainted(false);
        btnOk.setFocusPainted(false);
        
        panel.add(btnOk);
        add(panel);
	}
	
	private class PanelConFondo extends JPanel {
        @Override
        protected void paintComponent(Graphics g) {
            super.paintComponent(g);
            // Dibujar la imagen de fondo
            g.drawImage(imagenBg, 0, 0, getWidth(), getHeight(), this);
        }
    }

	public Image getImagenBg() {
		return imagenBg;
	}

	public void setImagenBg(Image imagenBg) {
		this.imagenBg = imagenBg;
	}

	public JPanel getPanel() {
		return panel;
	}

	public void setPanel(JPanel panel) {
		this.panel = panel;
	}

	public JButton getBtnOk() {
		return btnOk;
	}

	public void setBtnOk(JButton btnOk) {
		this.btnOk = btnOk;
	}
	
}
