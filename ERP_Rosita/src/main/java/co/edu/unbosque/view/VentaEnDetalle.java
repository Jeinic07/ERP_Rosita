package co.edu.unbosque.view;

import java.awt.*;
import java.awt.geom.*;
import javax.swing.*;
import javax.swing.table.*;



public class VentaEnDetalle extends JFrame{
	private Image imagenBg;
	private JPanel panel, titleBar;
	private JButton btnOk;
	private JTable tableDV;
	private JScrollPane scroll;
	private JTableHeader header;
	private NonEditableTableModel model;

	public VentaEnDetalle() {
		setSize(600, 600);
		setLayout(null);
		setLocationRelativeTo(null);
		setResizable(false);
		setUndecorated(true);
		setVisible(false);
		setShape(new RoundRectangle2D.Double(0, 0, getWidth(), getHeight(), 20, 20));

		
		imagenBg = new ImageIcon("src/main/java/co/edu/unbosque/view/images/VerDetalle.png").getImage();
		panel = new PanelConFondo();
		panel.setBounds(0, 0, 600, 600);
		panel.setLayout(null);

		btnOk = new JButton();
		btnOk.setBounds(214, 510, 172, 37);
		btnOk.setContentAreaFilled(false);
		btnOk.setBorderPainted(false);
		btnOk.setFocusPainted(false);
		
		
        String[] columnNames = {"Producto", "Cantidad",  "Precio", "SubTotal"};
        
        model = new NonEditableTableModel(columnNames, 0);
        
        tableDV = new JTable(model);
        tableDV.setGridColor(Color.decode("#FFC581"));
        tableDV.setRowHeight(30);
        tableDV.setShowGrid(false);
        tableDV.setIntercellSpacing(new Dimension(0, 0));	
        
        header = tableDV.getTableHeader();
		header.setDefaultRenderer(new BubbleHeaderRenderer());
		header.setPreferredSize(new Dimension(header.getWidth(), 35));
		tableDV.setDefaultRenderer(Object.class, new AlternateRowRenderer());
        
        scroll = new JScrollPane(tableDV);
		scroll.setBounds(62, 161, 475, 324);
		scroll.setOpaque(false);
		scroll.getViewport().setOpaque(false);
		scroll.setBorder(BorderFactory.createEmptyBorder());

		panel.add(scroll);
		panel.add(btnOk);
		add(panel);
	}
	public class NonEditableTableModel extends DefaultTableModel {
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
			g.drawImage(imagenBg, 0, 0, getWidth(), getHeight(), this);
			
			Graphics2D g2d = (Graphics2D) g;
			g2d.setColor(Color.decode("#FFBA68"));
			g2d.setStroke(new BasicStroke(5)); // Grosor del borde
			g2d.drawRoundRect(0, 0, getWidth() - 1, getHeight() - 1, 20, 20);
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

	public JButton getBtnOk() {
		return btnOk;
	}

	public void setBtnOk(JButton btnOk) {
		this.btnOk = btnOk;
	}

	public JPanel getTitleBar() {
		return titleBar;
	}

	public void setTitleBar(JPanel titleBar) {
		this.titleBar = titleBar;
	}

	public JTable getTableDV() {
		return tableDV;
	}

	public void setTableDV(JTable tableDV) {
		this.tableDV = tableDV;
	}

	public JScrollPane getScroll() {
		return scroll;
	}

	public void setScroll(JScrollPane scroll) {
		this.scroll = scroll;
	}

	public NonEditableTableModel getModel() {
		return model;
	}

	public void setModel(NonEditableTableModel model) {
		this.model = model;
	}


}


