package co.edu.unbosque.view;

import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class ProveedoresPanel extends JPanel {

	private JTable tableProveedores;
	private JScrollPane scroll;
	private DefaultTableModel model;
	private JButton btnAdd, btnEdit, btnBack;
	private JLabel si;


	public ProveedoresPanel() {

		setBounds(0, 0, 800, 600);
		setLayout(null);

		
        String[] columnNames = {"ID", "Nombre", "Tipo Documento", "Documento", "Direccion", "Telefono"};
        Object[][] data = {
            {"60", "si", "CC", "1052836658", "caracas con 19", "3209054024"},
            {"70", "no", "NIT", "1052836659", "caracas con 20", "3209054024"},
            {"60", "si", "CC", "1052836658", "caracas con 19", "3209054024"},
            {"70", "no", "NIT", "1052836659", "caracas con 20", "3209054024"},
            {"60", "si", "CC", "1052836658", "caracas con 19", "3209054024"},
            {"70", "no", "NIT", "1052836659", "caracas con 20", "3209054024"},
            {"60", "si", "CC", "1052836658", "caracas con 19", "3209054024"},
            {"70", "no", "NIT", "1052836659", "caracas con 20", "3209054024"},
            {"60", "si", "CC", "1052836658", "caracas con 19", "3209054024"},
            {"70", "no", "NIT", "1052836659", "caracas con 20", "3209054024"},
            {"60", "si", "CC", "1052836658", "caracas con 19", "3209054024"},
            {"70", "no", "NIT", "1052836659", "caracas con 20", "3209054024"},
            {"60", "si", "CC", "1052836658", "caracas con 19", "3209054024"},
            {"70", "no", "NIT", "1052836659", "caracas con 20", "3209054024"},
            {"60", "si", "CC", "1052836658", "caracas con 19", "3209054024"},
            {"70", "no", "NIT", "1052836659", "caracas con 20", "3209054024"},
            {"60", "si", "CC", "1052836658", "caracas con 19", "3209054024"},
            {"70", "no", "NIT", "1052836659", "caracas con 20", "3209054024"},
            {"60", "si", "CC", "1052836658", "caracas con 19", "3209054024"},
            {"70", "no", "NIT", "1052836659", "caracas con 20", "3209054024"},
            {"60", "si", "CC", "1052836658", "caracas con 19", "3209054024"},
            {"70", "no", "NIT", "1052836659", "caracas con 20", "3209054024"},
            {"60", "si", "CC", "1052836658", "caracas con 19", "3209054024"},
            {"70", "no", "NIT", "1052836659", "caracas con 20", "3209054024"},
            {"60", "si", "CC", "1052836658", "caracas con 19", "3209054024"},
            {"70", "no", "NIT", "1052836659", "caracas con 20", "3209054024"},
            {"60", "si", "CC", "1052836658", "caracas con 19", "3209054024"},
            {"70", "no", "NIT", "1052836659", "caracas con 20", "3209054024"},
            {"60", "si", "CC", "1052836658", "caracas con 19", "3209054024"},
            {"70", "no", "NIT", "1052836659", "caracas con 20", "3209054024"},
            {"60", "si", "CC", "1052836658", "caracas con 19", "3209054024"},
            {"70", "no", "NIT", "1052836659", "caracas con 20", "3209054024"},
            
        };

		model = new DefaultTableModel(data, columnNames);
		
		tableProveedores = new JTable(model);
		tableProveedores.setBounds(66, 169, 668, 263);
		
        scroll= new JScrollPane(tableProveedores);
        scroll.setBounds(66, 169, 668, 263);
        
        si = new JLabel("Proveedores");
		si.setFont(new Font("Arial", Font.PLAIN, 18));
		si.setBounds(323, 46, 161, 50);
		
		btnBack= new JButton("<-");
		btnBack.setBounds(47, 30, 77, 32);	
		
		btnAdd = new JButton("Añadir");
		btnAdd.setBounds(274, 474, 84, 40);
		
		btnEdit = new JButton("Editar");
		btnEdit.setBounds(395, 474, 84, 40);
		
		add(si);
		add(scroll);
		add(btnEdit);
		add(btnBack);
		add(btnAdd);
		
		setVisible(false);

	}


	public JTable getTableProveedores() {
		return tableProveedores;
	}


	public void setTableProveedores(JTable tableProveedores) {
		this.tableProveedores = tableProveedores;
	}


	public JScrollPane getScroll() {
		return scroll;
	}


	public void setScroll(JScrollPane scroll) {
		this.scroll = scroll;
	}


	public DefaultTableModel getModel() {
		return model;
	}


	public void setModel(DefaultTableModel model) {
		this.model = model;
	}


	public JButton getBtnAdd() {
		return btnAdd;
	}


	public void setBtnAdd(JButton btnAdd) {
		this.btnAdd = btnAdd;
	}


	public JButton getBtnEdit() {
		return btnEdit;
	}


	public void setBtnEdit(JButton btnEdit) {
		this.btnEdit = btnEdit;
	}


	public JButton getBtnBack() {
		return btnBack;
	}


	public void setBtnBack(JButton btnBack) {
		this.btnBack = btnBack;
	}


	public JLabel getSi() {
		return si;
	}


	public void setSi(JLabel si) {
		this.si = si;
	}
	
	

}
