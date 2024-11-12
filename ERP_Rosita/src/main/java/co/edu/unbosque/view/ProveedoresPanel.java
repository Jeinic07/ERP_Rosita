package co.edu.unbosque.view;

import java.awt.*;
import javax.swing.*;
import javax.swing.border.LineBorder;
import javax.swing.table.*;

import co.edu.unbosque.view.VentaNuevaWindow.AutoTextField;

public class ProveedoresPanel extends JPanel {

	private JTable tableProveedores;
	private JScrollPane scroll;
	private JPanel panel;
	private JTextField txtBusqueda;
	private LineBorder customBorder;
	private NonEditableTableModel model;
	private Image imageBg;
	private JTableHeader header;
	private JButton btnAdd, btnEdit, btnBack, btnDelete, btnPreg, btnBusqueda;

	public ProveedoresPanel() {

		setBounds(0, 0, 800, 600);
		setLayout(null);

		imageBg = new ImageIcon("src/main/java/co/edu/unbosque/view/images/Proveedores.png").getImage();
		customBorder = new LineBorder(Color.decode("#FFC581"), 2, true);

		panel = new PanelConFondo();
		panel.setBounds(0, 0, 800, 600);
		panel.setLayout(null);

		String[] columnNames = { "ID", "Nombre", "Tipo Documento", "Documento", "Telefono", "Direccion" };

		model = new NonEditableTableModel(columnNames, 0);

	
		tableProveedores = new JTable(model);
		tableProveedores.setGridColor(Color.decode("#FFC581"));
		tableProveedores.setRowHeight(30);
		tableProveedores.setShowGrid(false);
		tableProveedores.setIntercellSpacing(new Dimension(0, 0));	
		tableProveedores.getColumnModel().getColumn(0).setPreferredWidth(50);

		// Configurar el renderizado del encabezado de la tabla
		header = tableProveedores.getTableHeader();
		header.setDefaultRenderer(new BubbleHeaderRenderer());
		header.setPreferredSize(new Dimension(header.getWidth(), 35));
		tableProveedores.setDefaultRenderer(Object.class, new AlternateRowRenderer());

		scroll = new JScrollPane(tableProveedores);
		scroll.setBounds(66, 182, 668, 263);
		scroll.setOpaque(false);
		scroll.getViewport().setOpaque(false);
		scroll.setBorder(BorderFactory.createEmptyBorder());

		txtBusqueda = new JTextField();
		txtBusqueda.setBounds(527, 141, 167, 29);
		txtBusqueda.setBorder(customBorder);
		txtBusqueda.setBackground(Color.decode("#FFF9F3"));

		btnBusqueda = new JButton();
		btnBusqueda.setBounds(694, 134, 36, 36);
		btnBusqueda.setContentAreaFilled(false);
		btnBusqueda.setBorderPainted(false);
		btnBusqueda.setFocusPainted(false);
		

		btnBack = new JButton();
		btnBack.setBounds(39, 48, 36, 36);
		btnBack.setContentAreaFilled(false);
		btnBack.setBorderPainted(false);
		btnBack.setFocusPainted(false);
		
		btnPreg = new JButton();
		btnPreg.setBounds(734, 547, 36, 36);
		btnPreg.setContentAreaFilled(false);
		btnPreg.setBorderPainted(false);
		btnPreg.setFocusPainted(false);

		btnAdd = new JButton();
		btnAdd.setBounds(179, 464, 133, 40);
		btnAdd.setContentAreaFilled(false);
		btnAdd.setBorderPainted(false);
		btnAdd.setFocusPainted(false);

		btnEdit = new JButton();
		btnEdit.setBounds(340, 464, 133, 40);
		btnEdit.setContentAreaFilled(false);
		btnEdit.setBorderPainted(false);
		btnEdit.setFocusPainted(false);

		btnDelete = new JButton();
		btnDelete.setBounds(501, 464, 133, 40);
		btnDelete.setContentAreaFilled(false);
		btnDelete.setBorderPainted(false);
		btnDelete.setFocusPainted(false);

		panel.add(btnBusqueda);
		panel.add(txtBusqueda);
		panel.add(scroll);
		panel.add(btnPreg);
		panel.add(btnEdit);
		panel.add(btnBack);
		panel.add(btnAdd);
		panel.add(btnDelete);
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

	public JButton getBtnDelete() {
		return btnDelete;
	}

	public void setBtnDelete(JButton btnDelete) {
		this.btnDelete = btnDelete;
	}

	public JButton getBtnPreg() {
		return btnPreg;
	}

	public void setBtnPreg(JButton btnPreg) {
		this.btnPreg = btnPreg;
	}

	public JTextField getTxtBusqueda() {
		return txtBusqueda;
	}

	public void setTxtBusqueda(JTextField txtBusqueda) {
		this.txtBusqueda = txtBusqueda;
	}

	public JButton getBtnBusqueda() {
		return btnBusqueda;
	}

	public void setBtnBusqueda(JButton btnBusqueda) {
		this.btnBusqueda = btnBusqueda;
	}

}
