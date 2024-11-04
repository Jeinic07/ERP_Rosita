package co.edu.unbosque.view;

import java.awt.Font;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

public class VentaNuevaWindow extends JFrame {

    private JButton btnBack;
    private JButton btnAdd, btnDone;
    private JLabel titleLabel;
    private JTable tableNuevaVenta;
    private JScrollPane scroll;
    private DefaultTableModel model;
    private JTextField txtProducto;
    private JTextField txtCantidad;
    private JTextField txtPrecio;

    public VentaNuevaWindow() {
        setBounds(369, 250, 800, 450);
        setLayout(null);
        setVisible(false);

        String[] columnNames = {"Producto", "Cantidad", "Precio", "SubTotal"};
        model = new DefaultTableModel(columnNames, 0);

        tableNuevaVenta = new JTable(model);
        tableNuevaVenta.setBounds(66, 86, 668, 263);

        scroll = new JScrollPane(tableNuevaVenta);
        scroll.setBounds(66, 86, 668, 263);

        btnBack = new JButton("<-");
        btnBack.setBounds(10, 5, 50, 32);
        
        btnAdd = new JButton("Agregar Producto");
        btnAdd.setBounds(560, 35, 150, 32);
        
        btnDone = new JButton("Hecho");
        btnDone.setBounds(320, 360, 150, 32);
        
        
        txtProducto = new JTextField("Producto");
        txtProducto.setBounds(80, 35, 150, 32);

        txtCantidad = new JTextField("Cantidad");
        txtCantidad.setBounds(240, 35, 150, 32);

        txtPrecio = new JTextField("Precio");
        txtPrecio.setBounds(400, 35, 150, 32);
        
        add(btnBack);
        add(scroll);
        add(btnAdd);
        add(txtProducto);
        add(txtCantidad);
        add(txtPrecio);
        add(btnDone);
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

	public JLabel getTitleLabel() {
		return titleLabel;
	}

	public void setTitleLabel(JLabel titleLabel) {
		this.titleLabel = titleLabel;
	}

	public JTable getTableNuevaVenta() {
		return tableNuevaVenta;
	}

	public void setTableNuevaVenta(JTable tableNuevaVenta) {
		this.tableNuevaVenta = tableNuevaVenta;
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

	public JTextField getTxtProducto() {
		return txtProducto;
	}

	public void setTxtProducto(JTextField txtProducto) {
		this.txtProducto = txtProducto;
	}

	public JTextField getTxtCantidad() {
		return txtCantidad;
	}

	public void setTxtCantidad(JTextField txtCantidad) {
		this.txtCantidad = txtCantidad;
	}

	public JTextField getTxtPrecio() {
		return txtPrecio;
	}

	public void setTxtPrecio(JTextField txtPrecio) {
		this.txtPrecio = txtPrecio;
	}

    // Getters y Setters...

}
