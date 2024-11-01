package co.edu.unbosque.view;

import java.awt.Font;

import javax.swing.DefaultButtonModel;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class InventarioPanel extends JPanel {

	private JLabel si;
	private JButton btnBack, btnProveedores;
	private JTable tableInventario;
	private JScrollPane scroll;
	private DefaultTableModel model;

	public InventarioPanel() {
		
		setBounds(0, 0, 800, 600);
		setLayout(null);
		setVisible(false);
		
        String[] columnNames = {"ID", "Producto", "Cantidad", "Precio"};
        Object[][] data = {
            {"1", "Lápiz", "100", "$0.50"},
            {"2", "Cuaderno", "50", "$1.00"},
            {"3", "Borrador", "30", "$0.20"}
        };

		model = new DefaultTableModel(data, columnNames);
		
		tableInventario = new JTable(model);
		tableInventario.setBounds(66, 169, 668, 263);
		
        scroll= new JScrollPane(tableInventario);
        scroll.setBounds(66, 169, 668, 263);
		
		
		si = new JLabel("Inventario");
		si.setFont(new Font("Arial", Font.PLAIN, 18));
		si.setBounds(323, 46, 161, 50);
		
		btnBack= new JButton("<-");
		btnBack.setBounds(47, 30, 77, 32);	
		
		btnProveedores = new JButton("Proveedores");
		btnProveedores.setBounds(605, 455, 118, 29);
		
		
		
		add(si);
		add(btnBack);
		add(btnProveedores);
		add(tableInventario);
		add(scroll);
		


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
	
}
