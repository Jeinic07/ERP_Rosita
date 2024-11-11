package co.edu.unbosque.view;

import java.awt.*;
import javax.swing.*;
import javax.swing.border.LineBorder;
import javax.swing.table.*;

public class GastosPanel extends JPanel {

	private JButton btnBack, btnAdd, btnInfo, btnBusqueda;
	private DefaultTableModel model;
	private Image imagenBg;
	private JTextField txtBusqueda;
	private JPanel panel, titleBar;
	private JTableHeader header;
	private JTable tableGastos;
	private LineBorder customBorder;
	private JScrollPane scroll;

	public GastosPanel() {
		setBounds(0, 0, 800, 600);
		setLayout(null);

		imagenBg = new ImageIcon("src/main/java/co/edu/unbosque/view/images/Gastos.png").getImage();

		panel = new PanelConFondo();
		panel.setBounds(0, 0, 800, 600); // Ajustar tamaño del panel
		panel.setLayout(null);
		customBorder = new LineBorder(Color.decode("#FFC581"), 2, true);

		String[] columnNames = { "No. Gasto", "Fecha", "Hora", "Descipción", "Total" };

		model = new NonEditableTableModel(columnNames, 0);

		tableGastos = new JTable(model);
		tableGastos.setGridColor(Color.decode("#FFC581"));
		tableGastos.setRowHeight(30);
		tableGastos.setShowGrid(false);
		tableGastos.setIntercellSpacing(new Dimension(0, 0));
		tableGastos.getColumnModel().getColumn(0).setPreferredWidth(30);
		tableGastos.getColumnModel().getColumn(3).setPreferredWidth(200);

		txtBusqueda = new JTextField();
		txtBusqueda.setBounds(527, 141, 167, 29);
		txtBusqueda.setBorder(customBorder);
		txtBusqueda.setBackground(Color.decode("#FFF9F3"));

		header = tableGastos.getTableHeader();
		header.setDefaultRenderer(new BubbleHeaderRenderer());
		header.setPreferredSize(new Dimension(header.getWidth(), 35));
		tableGastos.setDefaultRenderer(Object.class, new AlternateRowRenderer());

		scroll = new JScrollPane(tableGastos);
		scroll.setBounds(66, 182, 668, 263);
		scroll.setOpaque(false);
		scroll.getViewport().setOpaque(false);
		scroll.setBorder(BorderFactory.createEmptyBorder());

		btnBack = new JButton();
		btnBack.setBounds(39, 48, 36, 36);
		btnBack.setContentAreaFilled(false);
		btnBack.setBorderPainted(false);

		btnAdd = new JButton();
		btnAdd.setBounds(319, 464, 162, 37);
		btnAdd.setContentAreaFilled(false);
		btnAdd.setBorderPainted(false);

		btnBusqueda = new JButton();
		btnBusqueda.setBounds(694, 134, 36, 36);
		btnBusqueda.setContentAreaFilled(false);
		btnBusqueda.setBorderPainted(false);
		btnBusqueda.setFocusPainted(false);

		btnInfo = new JButton();
		btnInfo.setBounds(734, 547, 36, 36);
		btnInfo.setContentAreaFilled(false);
		btnInfo.setBorderPainted(false);

		panel.add(txtBusqueda);
		panel.add(btnBusqueda);
		panel.add(btnInfo);
		panel.add(btnBack);
		panel.add(scroll);
		panel.add(btnAdd);
		add(panel);

		setVisible(false);
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

	public LineBorder getCustomBorder() {
		return customBorder;
	}

	public void setCustomBorder(LineBorder customBorder) {
		this.customBorder = customBorder;
	}

	public JButton getBtnInfo() {
		return btnInfo;
	}

	public void setBtnInfo(JButton btnInfo) {
		this.btnInfo = btnInfo;
	}

	public Image getImagenBg() {
		return imagenBg;
	}

	public void setImagenBg(Image imagenBg) {
		this.imagenBg = imagenBg;
	}

	public JPanel getPanel() {
		return panel;
	}

	public void setPanel(JPanel panel) {
		this.panel = panel;
	}

	public JPanel getTitleBar() {
		return titleBar;
	}

	public void setTitleBar(JPanel titleBar) {
		this.titleBar = titleBar;
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
