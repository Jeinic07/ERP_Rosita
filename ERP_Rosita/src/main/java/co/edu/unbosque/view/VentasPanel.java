package co.edu.unbosque.view;

import java.awt.*;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;

public class VentasPanel extends JPanel {

	private JButton btnBack, btnNuevaVenta;
	private DefaultTableModel model;
	private JScrollPane scroll;
	private JPanel panel;
	private Image imagenBg;
	private JTable tableVentas;


	public VentasPanel() {
		setBounds(0, 0, 800, 600);
		setLayout(null);
		setVisible(false);
		
        imagenBg = new ImageIcon("src/main/java/co/edu/unbosque/view/images/Ventas.png").getImage();

        panel = new PanelConFondo();
        panel.setBounds(0, 0, 800, 600);  // Ajustar tamaño del panel
        panel.setLayout(null);
		
        String[] columnNames = {"N. Factura", "Fecha", "Total"};
        
		model = new DefaultTableModel(columnNames, 0);
		
		tableVentas = new JTable(model);
		tableVentas.setBounds(66, 169, 668, 263);
		
        scroll= new JScrollPane(tableVentas);
        scroll.setBounds(66, 169, 668, 263);


		btnBack = new JButton();
		btnBack.setBounds(27, 17, 36, 36);
		btnBack.setContentAreaFilled(false);
		btnBack.setBorderPainted(false);
		
		btnNuevaVenta= new JButton();
		btnNuevaVenta.setBounds(319, 444, 172, 42);
		btnNuevaVenta.setContentAreaFilled(false);
		btnNuevaVenta.setBorderPainted(false);

		panel.add(btnBack);
		panel.add(scroll);
		panel.add(btnNuevaVenta);
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
	

	public JButton getBtnBack() {
		return btnBack;
	}

	public void setBtnBack(JButton btnBack) {
		this.btnBack = btnBack;
	}

	public JButton getBtnNuevaVenta() {
		return btnNuevaVenta;
	}

	public void setBtnNuevaVenta(JButton btnNuevaVenta) {
		this.btnNuevaVenta = btnNuevaVenta;
	}

	public DefaultTableModel getModel() {
		return model;
	}

	public void setModel(DefaultTableModel model) {
		this.model = model;
	}

	public JScrollPane getScroll() {
		return scroll;
	}

	public void setScroll(JScrollPane scroll) {
		this.scroll = scroll;
	}

	public JTable getTableVentas() {
		return tableVentas;
	}

	public void setTableVentas(JTable tableVentas) {
		this.tableVentas = tableVentas;
	}
	
	

}
