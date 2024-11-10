package co.edu.unbosque.view;

import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class GastosPanel extends JPanel{
	
	private JLabel si;
	private JButton btnBack, btnAdd;
	private DefaultTableModel model;
	private JTable tableGastos;
	private JScrollPane scroll;
	
	public GastosPanel() {
		setBounds(0, 0, 800, 600);
		setLayout(null);

		si = new JLabel("Gastos");
		si.setFont(new Font("Arial", Font.PLAIN, 18));
		si.setBounds(323, 46, 161, 50);

		btnBack = new JButton("<-");
		btnBack.setBounds(47, 30, 77, 32);
		
	    String[] columnNames = {"No. Gasto", "Fecha", "Hora", "Descipción", "Total"};
	    
		model = new DefaultTableModel(columnNames, 0);
		
		tableGastos = new JTable(model);
		tableGastos.setBounds(66, 169, 668, 263);
		
		btnAdd= new JButton("Añadir");
		btnAdd.setBounds(319, 444, 172, 42);
		btnAdd.setContentAreaFilled(false);
		btnAdd.setBorderPainted(false);
		
        scroll= new JScrollPane(tableGastos);
        scroll.setBounds(66, 169, 668, 263);
		
		add(si);
		add(btnBack);
		add(scroll);
		add(btnAdd);
		

		setVisible(false);
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

	public JButton getBtnAdd() {
		return btnAdd;
	}

	public void setBtnAdd(JButton btnAdd) {
		this.btnAdd = btnAdd;
	}

	public DefaultTableModel getModel() {
		return model;
	}

	public void setModel(DefaultTableModel model) {
		this.model = model;
	}

	public JTable getTableGastos() {
		return tableGastos;
	}

	public void setTableGastos(JTable tableGastos) {
		this.tableGastos = tableGastos;
	}

	public JScrollPane getScroll() {
		return scroll;
	}

	public void setScroll(JScrollPane scroll) {
		this.scroll = scroll;
	}
	
}
