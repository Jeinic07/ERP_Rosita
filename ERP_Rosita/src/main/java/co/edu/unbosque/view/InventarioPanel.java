package co.edu.unbosque.view;

import java.awt.*;

import javax.swing.*;
import javax.swing.border.LineBorder;
import javax.swing.table.*;

public class InventarioPanel extends JPanel {

	private Image imageBg;
	private JPanel panel;
	private JButton btnBack, btnProveedores, btnX, btnAdd, btnMinus, btnPreg, btnBusqueda, btnS;
	private JTable tableInventario;
	private JTableHeader header;
	private JScrollPane scroll;
	private NonEditableTableModel model;
    private JTextField txtBusqueda;
    private LineBorder customBorder;

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
		customBorder = new LineBorder(Color.decode("#FFC581"), 2, true);


        tableInventario = new JTable(model);
		tableInventario.setGridColor(Color.decode("#FFC581"));
		tableInventario.setRowHeight(30);
		tableInventario.setShowGrid(false);
		tableInventario.setRowHeight(30);
		tableInventario.setIntercellSpacing(new Dimension(0, 0));
		tableInventario.setColumnSelectionAllowed(false);
		
		header = tableInventario.getTableHeader();
		header.setDefaultRenderer(new BubbleHeaderRenderer());
		header.setPreferredSize(new Dimension(header.getWidth(), 35));
		tableInventario.setDefaultRenderer(Object.class, new AlternateRowRenderer());
		
		scroll = new JScrollPane(tableInventario);
		scroll.setBounds(66, 182, 668, 263);
		scroll.setOpaque(false);
		scroll.getViewport().setOpaque(false);
		scroll.setBorder(BorderFactory.createEmptyBorder());


        btnBack = new JButton();
        btnBack.setBounds(39, 48, 36, 36);
        btnBack.setContentAreaFilled(false);
        btnBack.setBorderPainted(false);
        btnBack.setFocusPainted(false);
        
        btnS = new JButton();
        btnS.setBounds(39, 108, 36, 36);
        btnS.setContentAreaFilled(false);
        btnS.setBorderPainted(false);
        btnS.setFocusPainted(false);
        
        btnPreg = new JButton();
		btnPreg.setBounds(734, 550, 36, 36);
		btnPreg.setContentAreaFilled(false);
		btnPreg.setBorderPainted(false);
		btnPreg.setFocusPainted(false);

		btnBusqueda = new JButton();
		btnBusqueda.setBounds(698, 135, 36, 36);
		btnBusqueda.setContentAreaFilled(false);
		btnBusqueda.setBorderPainted(false);
		btnBusqueda.setFocusPainted(false);

        btnProveedores = new JButton();
        btnProveedores.setBounds(430, 462, 133, 38);
        btnProveedores.setContentAreaFilled(false);
        btnProveedores.setBorderPainted(false);
        btnProveedores.setFocusPainted(false);

        btnAdd = new JButton();
        btnAdd.setBounds(239, 462, 133, 38);
        btnAdd.setContentAreaFilled(false);
        btnAdd.setBorderPainted(false);
        btnAdd.setFocusPainted(false);
        
        txtBusqueda = new JTextField();
		txtBusqueda.setBounds(527, 141, 167, 29);
		txtBusqueda.setBorder(customBorder);
		txtBusqueda.setBackground(Color.decode("#FFF9F3"));

		panel.add(btnS);
		panel.add(txtBusqueda);
        panel.add(btnBusqueda);
        panel.add(btnAdd);
        panel.add(btnPreg);
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
    private static class BubbleHeaderRenderer extends DefaultTableCellRenderer {
		public BubbleHeaderRenderer() {
			setHorizontalAlignment(JLabel.CENTER);
			setBackground(Color.decode("#77C4F2"));
			setForeground(Color.WHITE);
			setFont(new Font("Arial", Font.BOLD, 18));
			setOpaque(true);
		}
		@Override
		public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus,
				int row, int column) {
			// Ajustar el componente del renderizado para cada celda del encabezado
			super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);
			setFont(new Font("Arial", Font.BOLD, 12));
			setBackground(Color.decode("#FFC581"));
			setForeground(Color.WHITE);
			return this;
		}
		@Override
		protected void paintComponent(Graphics g) {
			Graphics2D g2 = (Graphics2D) g;
			g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
			g2.setColor(getBackground());
			g2.fillRoundRect(0, 0, getWidth(), getHeight(), 60, 60);
			super.paintComponent(g);
		}
	}
	// Renderer personalizado para alternar colores de fondo en las filas
	private static class AlternateRowRenderer extends DefaultTableCellRenderer {
		@Override
		public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus,
				int row, int column) {
			super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);
			if (row % 2 == 0) {
				setBackground(new Color(255, 239, 213)); // Amarillo pastel
			} else {
				setBackground(new Color(255, 228, 196)); // Naranja pastel
			}
			setForeground(Color.BLACK);
			setOpaque(true);
			return this;
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
	

    public JButton getBtnS() {
		return btnS;
	}

	public void setBtnS(JButton btnS) {
		this.btnS = btnS;
	}

	public LineBorder getCustomBorder() {
		return customBorder;
	}

	public void setCustomBorder(LineBorder customBorder) {
		this.customBorder = customBorder;
	}

	public JTableHeader getHeader() {
		return header;
	}

	public void setHeader(JTableHeader header) {
		this.header = header;
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

	public JButton getBtnAdd() {
		return btnAdd;
	}

	public void setBtnAdd(JButton btnAdd) {
		this.btnAdd = btnAdd;
	}

	public JButton getBtnBusqueda() {
		return btnBusqueda;
	}

	public void setBtnBusqueda(JButton btnBusqueda) {
		this.btnBusqueda = btnBusqueda;
	}

	public JTextField getTxtBusqueda() {
		return txtBusqueda;
	}

	public void setTxtBusqueda(JTextField txtBusqueda) {
		this.txtBusqueda = txtBusqueda;
	}
	
    
}
