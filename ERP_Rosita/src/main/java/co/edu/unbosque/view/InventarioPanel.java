package co.edu.unbosque.view;

import java.awt.*;

import javax.swing.*;
import javax.swing.table.*;

public class InventarioPanel extends JPanel {

	private Image imageBg;
	private JPanel panel;
	private JButton btnBack, btnProveedores, btnX, btnMinus, btnPreg;
	private JTable tableInventario;
	private JTableHeader header;
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

		String[] columnNames = { "id", "Producto", "Marca", "Cantidad", "Costo", "Precio", "Proveedor" };

		model = new NonEditableTableModel(columnNames, 0);

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
		scroll.setBounds(66, 169, 668, 263);
		scroll.setOpaque(false);
		scroll.getViewport().setOpaque(false);
		scroll.setBorder(BorderFactory.createEmptyBorder());

		btnBack = new JButton();
		btnBack.setBounds(39, 48, 36, 36);
		btnBack.setContentAreaFilled(false);
		btnBack.setBorderPainted(false);
		btnBack.setFocusPainted(false);

		btnPreg = new JButton();
		btnPreg.setBounds(734, 550, 36, 36);
		btnPreg.setContentAreaFilled(false);
		btnPreg.setBorderPainted(false);
		btnPreg.setFocusPainted(false);

		btnProveedores = new JButton();
		btnProveedores.setBounds(606, 443, 133, 38);
		btnProveedores.setContentAreaFilled(false);
		btnProveedores.setBorderPainted(false);
		btnProveedores.setFocusPainted(false);

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
}
