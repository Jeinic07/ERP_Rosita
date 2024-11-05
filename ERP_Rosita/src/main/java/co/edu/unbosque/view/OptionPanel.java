package co.edu.unbosque.view;

import java.awt.Graphics;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPanel;

public class OptionPanel extends JPanel {
	
	private JButton btnInventario, btnVentas, btnCompras, btnGastos, btnX, btnMinus, btnPreg;
	private Image imagenBg;
	private JPanel panel;

	public OptionPanel() {
        setBounds(0, 0, 800, 600);
        setLayout(null);

        imagenBg = new ImageIcon("src/main/java/co/edu/unbosque/view/images/MenuSeleccion.png").getImage();

        // Crear un panel personalizado con imagen de fondo
        panel = new PanelConFondo();
        panel.setBounds(0, 0, 800, 600);  // Ajustar tamaño del panel
        panel.setLayout(null);

        btnInventario = new JButton();
        btnInventario.setBounds(255, 257, 130, 48);
        btnInventario.setContentAreaFilled(false);
        btnInventario.setBorderPainted(false);
        btnInventario.setFocusPainted(false);
        

        btnVentas = new JButton();
        btnVentas.setBounds(255, 338, 130, 48);
        btnVentas.setContentAreaFilled(false);
        btnVentas.setBorderPainted(false);
        btnVentas.setFocusPainted(false);
        

        btnCompras = new JButton();
        btnCompras.setBounds(431, 257, 130, 48);
        btnCompras.setContentAreaFilled(false);
        btnCompras.setBorderPainted(false);
        btnCompras.setFocusPainted(false);
        

        btnGastos = new JButton();
        btnGastos.setBounds(431, 338, 130, 48);
        btnGastos.setContentAreaFilled(false);
        btnGastos.setBorderPainted(false);
        btnGastos.setFocusPainted(false);
        
        btnPreg = new JButton();
		btnPreg.setBounds(734, 550, 36, 36);
		btnPreg.setContentAreaFilled(false);
		btnPreg.setBorderPainted(false);
		btnPreg.setFocusPainted(false);

		btnX = new JButton();
		btnX.setBounds(734, 16, 36, 36);
		btnX.setContentAreaFilled(false);
		btnX.setBorderPainted(false);
		btnX.setFocusPainted(false);

		btnMinus = new JButton();
		btnMinus.setBounds(681, 16, 36, 36);
		btnMinus.setContentAreaFilled(false);
		btnMinus.setBorderPainted(false);
		btnMinus.setFocusPainted(false);
        
		
		panel.add(btnPreg);
		panel.add(btnX);
		panel.add(btnMinus);
        panel.add(btnInventario);
        panel.add(btnVentas);
        panel.add(btnCompras);
        panel.add(btnGastos);
        add(panel);

        setVisible(true);
    }

    // Clase interna para el panel con imagen de fondo
    private class PanelConFondo extends JPanel {
        @Override
        protected void paintComponent(Graphics g) {
            super.paintComponent(g);
            // Dibujar la imagen de fondo
            g.drawImage(imagenBg, 0, 0, getWidth(), getHeight(), this);
        }
    }
	public JButton getBtnInventario() {
		return btnInventario;
	}

	public void setBtnInventario(JButton btnInventario) {
		this.btnInventario = btnInventario;
	}

	public JButton getBtnVentas() {
		return btnVentas;
	}

	public void setBtnVentas(JButton btnVentas) {
		this.btnVentas = btnVentas;
	}

	public JButton getBtnCompras() {
		return btnCompras;
	}

	public void setBtnCompras(JButton btnCompras) {
		this.btnCompras = btnCompras;
	}

	public JButton getBtnGastos() {
		return btnGastos;
	}

	public void setBtnGastos(JButton btnGastos) {
		this.btnGastos = btnGastos;
	}

	public JButton getBtnX() {
		return btnX;
	}

	public void setBtnX(JButton btnX) {
		this.btnX = btnX;
	}

	public JButton getBtnMinus() {
		return btnMinus;
	}

	public void setBtnMinus(JButton btnMinus) {
		this.btnMinus = btnMinus;
	}

	public JButton getBtnPreg() {
		return btnPreg;
	}

	public void setBtnPreg(JButton btnPreg) {
		this.btnPreg = btnPreg;
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
	
}
