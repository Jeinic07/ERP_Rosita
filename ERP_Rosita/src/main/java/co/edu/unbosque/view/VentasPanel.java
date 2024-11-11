package co.edu.unbosque.view;

import java.awt.*;

import javax.swing.*;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;

public class VentasPanel extends JPanel {

	private JButton btnBack, btnNuevaVenta, btnVerVenta, btnPreg;
	private DefaultTableModel model;
	private JScrollPane scroll;
	private JPanel panel;
	private Image imagenBg;
	private JTableHeader header;
	private JTable tableVentas;

	public VentasPanel() {
		setBounds(0, 0, 800, 600);
		setLayout(null);
		setVisible(false);

		imagenBg = new ImageIcon("src/main/java/co/edu/unbosque/view/images/Ventas.png").getImage();

		panel = new PanelConFondo();
		panel.setBounds(0, 0, 800, 600); // Ajustar tamaño del panel
		panel.setLayout(null);

		String[] columnNames = { "No. Factura", "Fecha", "Hora", "Total" };

		model = new NonEditableTableModel(columnNames, 0);

		tableVentas = new JTable(model);
		tableVentas.setGridColor(Color.decode("#FFC581"));
		tableVentas.setRowHeight(30);
		tableVentas.setShowGrid(false);
		tableVentas.setIntercellSpacing(new Dimension(0, 0));

		// Configurar el renderizado del encabezado de la tabla
		header = tableVentas.getTableHeader();
		header.setDefaultRenderer(new BubbleHeaderRenderer());
		header.setPreferredSize(new Dimension(header.getWidth(), 35));
		tableVentas.setDefaultRenderer(Object.class, new AlternateRowRenderer());

		scroll = new JScrollPane(tableVentas);
		scroll.setBounds(80, 165, 668, 270);
		scroll.setOpaque(false);
		scroll.getViewport().setOpaque(false);
		scroll.setBorder(BorderFactory.createEmptyBorder());

		btnBack = new JButton();
		btnBack.setBounds(39, 48, 36, 36);
		btnBack.setContentAreaFilled(false);
		btnBack.setBorderPainted(false);

		btnNuevaVenta = new JButton();
		btnNuevaVenta.setBounds(222, 464, 162, 37);
		btnNuevaVenta.setContentAreaFilled(false);
		btnNuevaVenta.setBorderPainted(false);

		btnVerVenta = new JButton();
		btnVerVenta.setBounds(415, 464, 162, 37);
		btnVerVenta.setContentAreaFilled(false);
		btnVerVenta.setBorderPainted(false);

		btnPreg = new JButton();
		btnPreg.setBounds(734, 547, 36, 36);
		btnPreg.setContentAreaFilled(false);
		btnPreg.setBorderPainted(false);
		btnPreg.setFocusPainted(false);
		
		panel.add(btnPreg);
		panel.add(btnVerVenta);
		panel.add(btnBack);
		panel.add(scroll);
		panel.add(btnNuevaVenta);
		add(panel);

	}

	private class NonEditableTableModel extends DefaultTableModel {
		public NonEditableTableModel(Object[] columnNames, int rowCount) {
			super(columnNames, rowCount);
		}

		@Override
		public boolean isCellEditable(int row, int column) {
			return false;
		}
	}

	private class PanelConFondo extends JPanel {
		@Override
		protected void paintComponent(Graphics g) {
			super.paintComponent(g);
			// Dibujar la imagen de fondo
			g.drawImage(imagenBg, 0, 0, getWidth(), getHeight(), this);
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


	public JPanel getPanel() {
		return panel;
	}
	
	public JButton getBtnVerVenta() {
		return btnVerVenta;
	}

	public void setBtnVerVenta(JButton btnVerVenta) {
		this.btnVerVenta = btnVerVenta;
	}

	public JButton getBtnPreg() {
		return btnPreg;
	}

	public void setBtnPreg(JButton btnPreg) {
		this.btnPreg = btnPreg;
	}

	public JTableHeader getHeader() {
		return header;
	}

	public void setHeader(JTableHeader header) {
		this.header = header;
	}



	public void setPanel(JPanel panel) {
		this.panel = panel;
	}

	public Image getImagenBg() {
		return imagenBg;
	}

	public void setImagenBg(Image imagenBg) {
		this.imagenBg = imagenBg;
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
