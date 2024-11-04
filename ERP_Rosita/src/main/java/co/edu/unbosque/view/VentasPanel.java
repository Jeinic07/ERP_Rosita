package co.edu.unbosque.view;

import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class VentasPanel extends JPanel {

	private JLabel si;
	private JButton btnBack, btnNuevaVenta;
	private DefaultTableModel model;
	private JScrollPane scroll;
	private JTable tableVentas;


	public VentasPanel() {
		setBounds(0, 0, 800, 600);
		setLayout(null);
		setVisible(false);
		
        String[] columnNames = {"N. Factura", "Fecha", "Total"};
        
		model = new DefaultTableModel(columnNames, 0);
		
		tableVentas = new JTable(model);
		tableVentas.setBounds(66, 169, 668, 263);
		
        scroll= new JScrollPane(tableVentas);
        scroll.setBounds(66, 169, 668, 263);

		si = new JLabel("Ventas");
		si.setFont(new Font("Arial", Font.PLAIN, 18));
		si.setBounds(323, 46, 161, 50);

		btnBack = new JButton("<-");
		btnBack.setBounds(47, 30, 77, 32);
		
		btnNuevaVenta= new JButton("Nueva Venta");
		btnNuevaVenta.setBounds(300, 470, 180, 40);

		add(si);
		add(btnBack);
		add(scroll);
		add(btnNuevaVenta);

	}

	public JLabel getSi() {
		return si;
	}

	public void setSi(JLabel si) {
		this.si = si;
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
