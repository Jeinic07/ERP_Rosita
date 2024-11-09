package co.edu.unbosque.view;

import java.awt.*;
import javax.swing.*;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;

public class ProveedoresPanel extends JPanel {

	private JTable tableProveedores;
	private JTableHeader header;
	private JScrollPane scroll;
	private JPanel panel;
	private NonEditableTableModel model;
	private Image imageBg;
	private JButton btnAdd, btnEdit, btnBack, btnDelete, btnX, btnMinus, btnPreg;

	public ProveedoresPanel() {
		setBounds(0, 0, 800, 600);
		setLayout(null);

		// Cargar la imagen de fondo
		imageBg = new ImageIcon("src/main/java/co/edu/unbosque/view/images/Proveedores.png").getImage();

		// Crear el panel con imagen de fondo
		panel = new PanelConFondo();
		panel.setBounds(0, 0, 800, 600);
		panel.setLayout(null);
		
		

		// Columnas de la tabla
		String[] columnNames = { "ID", "Nombre", "Tipo Documento", "Documento", "Direccion", "Telefono" };
		model = new NonEditableTableModel(columnNames, 0);

		// Crear y configurar la tabla
		tableProveedores = new JTable(model);
		tableProveedores.setGridColor(Color.decode("#FFC581"));
		tableProveedores.setRowHeight(30);
		tableProveedores.setShowGrid(false);
		tableProveedores.setIntercellSpacing(new Dimension(0, 0));

		// Configurar el renderizado del encabezado de la tabla
		header = tableProveedores.getTableHeader();
		header.setDefaultRenderer(new BubbleHeaderRenderer());
		header.setPreferredSize(new Dimension(header.getWidth(), 35));
		tableProveedores.setDefaultRenderer(Object.class, new AlternateRowRenderer());
		
		
		// Agregar la tabla a un JScrollPane
		scroll = new JScrollPane(tableProveedores);
		scroll.setBounds(70, 157, 668, 283);
		scroll.setOpaque(false);
	    scroll.getViewport().setOpaque(false);
	    scroll.setBorder(BorderFactory.createEmptyBorder());
		// Configurar botones
	    btnBack = new JButton();
		btnBack.setBounds(27, 17, 36, 36);
		btnBack.setContentAreaFilled(false);
        btnBack.setBorderPainted(false);
        btnBack.setFocusPainted(false);

		btnAdd = new JButton();
		btnAdd.setBounds(179, 443, 133, 40);
		btnAdd.setContentAreaFilled(false);
		btnAdd.setBorderPainted(false);
		btnAdd.setFocusPainted(false);

		btnEdit = new JButton();
		btnEdit.setBounds(340, 443, 133, 40);
		btnEdit.setContentAreaFilled(false);
		btnEdit.setBorderPainted(false);
		btnEdit.setFocusPainted(false);
		
		btnDelete = new JButton();
		btnDelete.setBounds(501, 443, 133, 40);
		btnDelete.setContentAreaFilled(false);
		btnDelete.setBorderPainted(false);
		btnDelete.setFocusPainted(false);
		
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
		// Agregar componentes al panel
		panel.add(btnMinus);
		panel.add(btnX);
		panel.add(scroll);
		panel.add(btnEdit);
		panel.add(btnBack);
		panel.add(btnAdd);
		panel.add(btnDelete);
		add(panel);
		
		setVisible(false);
	}

	// Método para crear botones transparentes
	
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

	// Renderer personalizado para los encabezados de la tabla con estilo burbuja
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

	public void setModel(NonEditableTableModel model) {
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

	public JPanel getPanel() {
		return panel;
	}

	public void setPanel(JPanel panel) {
		this.panel = panel;
	}

	public Image getImageBg() {
		return imageBg;
	}

	public void setImageBg(Image imageBg) {
		this.imageBg = imageBg;
	}

	public JButton getBtnDelete() {
		return btnDelete;
	}

	public void setBtnDelete(JButton btnDelete) {
		this.btnDelete = btnDelete;
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

}
