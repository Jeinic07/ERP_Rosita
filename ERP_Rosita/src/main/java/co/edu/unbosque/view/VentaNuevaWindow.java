package co.edu.unbosque.view;

import java.awt.*;
import java.awt.geom.RoundRectangle2D;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;

public class VentaNuevaWindow extends JFrame {

    private JButton btnBack;
    private JButton btnAdd, btnDone;
    private JLabel titleLabel;
    private Image imagenBg;
    private JPanel panel;
    private JTable tableNuevaVenta;
    private JScrollPane scroll;
    private DefaultTableModel model;
    private JTextField txtProducto;
    private JTextField txtCantidad;
    private JTextField txtPrecio;

   
        public VentaNuevaWindow() {
            setBounds(369, 250, 700, 450);
            setLayout(null);
            setVisible(false);
            setUndecorated(true);
            setResizable(false);
            setLocationRelativeTo(null);

            imagenBg = new ImageIcon("src/main/java/co/edu/unbosque/view/images/VentasAgregar.png").getImage();

            panel = new PanelConFondo();
            panel.setBounds(0, 0, 700, 450);
            panel.setLayout(null);

            String[] columnNames = {"Producto", "Cantidad", "Precio", "SubTotal"};
            model = new DefaultTableModel(columnNames, 0);

            tableNuevaVenta = new JTable(model);
            tableNuevaVenta.setBounds(49, 153, 605, 215);

            scroll = new JScrollPane(tableNuevaVenta);
            scroll.setBounds(49, 153, 605, 215);

            btnBack = new JButton();
            btnBack.setBounds(10, 5, 50, 32);
            btnBack.setContentAreaFilled(false);
            btnBack.setBorderPainted(false);

            btnAdd = new JButton();
            btnAdd.setBounds(567, 69, 87, 34);
            btnAdd.setContentAreaFilled(false);
            btnAdd.setBorderPainted(false);

            btnDone = new JButton();
            btnDone.setBounds(306, 375, 87, 34);
            btnDone.setContentAreaFilled(false);
            btnDone.setBorderPainted(false);

            // Usar RoundedTextField en lugar de JTextField
            txtProducto = new RoundedTextField("Producto", 20, 20);
            txtProducto.setBounds(49, 69, 153, 34);

            txtCantidad = new RoundedTextField("Cantidad", 20, 20);
            txtCantidad.setBounds(221, 69, 153, 34);

            txtPrecio = new RoundedTextField("Precio", 20, 20);
            txtPrecio.setBounds(393, 69, 153, 34);

            panel.add(btnBack);
            panel.add(scroll);
            panel.add(btnAdd);
            panel.add(txtProducto);
            panel.add(txtCantidad);
            panel.add(txtPrecio);
            panel.add(btnDone);
            add(panel);
        }

        private class RoundedTextField extends JTextField {
            private int arcWidth;
            private int arcHeight;

            public RoundedTextField(String text, int arcWidth, int arcHeight) {
                super(text);
                this.arcWidth = arcWidth;
                this.arcHeight = arcHeight;
                setOpaque(false); 
                setBackground(Color.decode("#FFF9F3"));// Hace que el fondo sea transparente
            }

            @Override
            protected void paintComponent(Graphics g) {
                Graphics2D g2 = (Graphics2D) g.create();
                g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
                g2.setColor(getBackground());
                g2.fill(new RoundRectangle2D.Float(0, 0, getWidth(), getHeight(), arcWidth, arcHeight));
                super.paintComponent(g);
                g2.dispose();
            }

            @Override
            protected void paintBorder(Graphics g) {
                Graphics2D g2 = (Graphics2D) g.create();
                g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
                g2.setColor(Color.decode("#FFCD94")); 
                g2.setStroke(new BasicStroke(2));
                g2.draw(new RoundRectangle2D.Float(0, 0, getWidth() - 1, getHeight() - 1, arcWidth, arcHeight));
                g2.dispose();
            }
        }

        private class PanelConFondo extends JPanel {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                g.drawImage(imagenBg, 0, 0, getWidth(), getHeight(), this);
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
