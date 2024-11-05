package co.edu.unbosque.view;

import java.awt.*;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;

public class InventarioPanel extends JPanel {

    private Image imageBg;
    private JPanel panel;
    private JButton btnBack, btnProveedores, btnX, btnMinus, btnPreg;
    private JTable tableInventario;
    private JScrollPane scroll;
    private NonEditableTableModel model;

    public InventarioPanel() {

        setBounds(0, 0, 800, 600);
        setLayout(null);
        setVisible(false);

        imageBg = new ImageIcon("src/main/java/co/edu/unbosque/view/images/Inventario.png").getImage();

        panel = new PanelConFondo();
        panel.setBounds(0, 0, 800, 600);  
        panel.setLayout(null);

        String[] columnNames = {"id", "Producto", "Marca", "Cantidad", "Costo", "Precio", "Proveedor"};

        model = new NonEditableTableModel(columnNames, 0);

        tableInventario = new JTable(model);
        tableInventario.setBounds(66, 169, 668, 263);
        tableInventario.setGridColor(Color.decode("#FFC581"));
        tableInventario.setColumnSelectionAllowed(false);

        scroll = new JScrollPane(tableInventario);
        scroll.setBounds(66, 169, 668, 263);

        btnBack = new JButton();
        btnBack.setBounds(27, 17, 36, 36);
        btnBack.setContentAreaFilled(false);
        btnBack.setBorderPainted(false);
        btnBack.setFocusPainted(false);
        
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


        btnProveedores = new JButton();
        btnProveedores.setBounds(606, 443, 133, 38);
        btnProveedores.setContentAreaFilled(false);
        btnProveedores.setBorderPainted(false);
        btnProveedores.setFocusPainted(false);

        panel.add(btnPreg);
        panel.add(btnMinus);
        panel.add(btnX);
        panel.add(btnBack);
        panel.add(btnProveedores);
        panel.add(scroll);
        add(panel);
    }

    // Modelo de tabla no editable
    private class NonEditableTableModel extends DefaultTableModel {
        public NonEditableTableModel(Object[] columnNames, int rowCount) {
            super(columnNames, rowCount);
        }

        @Override
        public boolean isCellEditable(int row, int column) {
            return false; 
        }
    }

    // Dibujar la imagen de fondo
    private class PanelConFondo extends JPanel {
        @Override
        protected void paintComponent(Graphics g) {
            super.paintComponent(g);
            g.drawImage(imageBg, 0, 0, getWidth(), getHeight(), this);
        }
    }

    public JButton getBtnBack() {
        return btnBack;
    }

    public void setBtnBack(JButton btnBack) {
        this.btnBack = btnBack;
    }

    public JButton getBtnProveedores() {
        return btnProveedores;
    }

    public void setBtnProveedores(JButton btnProveedores) {
        this.btnProveedores = btnProveedores;
    }

    public JTable getTableInventario() {
        return tableInventario;
    }

    public void setTableInventario(JTable tableInventario) {
        this.tableInventario = tableInventario;
    }

    public JScrollPane getScroll() {
        return scroll;
    }

    public Image getImageBg() {
		return imageBg;
	}

	public void setImageBg(Image imageBg) {
		this.imageBg = imageBg;
	}

	public JPanel getPanel() {
		return panel;
	}

	public void setPanel(JPanel panel) {
		this.panel = panel;
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

	public void setScroll(JScrollPane scroll) {
        this.scroll = scroll;
    }

    public DefaultTableModel getModel() {
        return model;
    }

    public void setModel(NonEditableTableModel model) {
        this.model = model;
    }
}
