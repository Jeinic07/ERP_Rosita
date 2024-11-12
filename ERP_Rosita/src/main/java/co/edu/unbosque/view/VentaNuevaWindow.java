package co.edu.unbosque.view;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.geom.RoundRectangle2D;
import java.util.ArrayList;
import java.util.List;

import javax.swing.*;
import javax.swing.border.LineBorder;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;

public class VentaNuevaWindow extends JFrame {

	private JButton btnAdd, btnDone, btnBack, minimizeButton, closeButton;
	private JLabel titleLabel;
	private Image imagenBg;
	private JPanel panel, titleBar;
	private JTable tableNuevaVenta;
	private JScrollPane scroll;
	private DefaultTableModel model;
	private AutoTextField txtProducto;
	private JTableHeader header;
	private JTextField txtCantidad;
	private JTextField txtPrecio;
	private ArrayList<String> items;
	private LineBorder customBorder;

	public VentaNuevaWindow() {
		setBounds(369, 250, 700, 450);
		setLayout(null);
		setVisible(false);
		setUndecorated(true);
		setResizable(false);
		setLocationRelativeTo(null);
		setShape(new RoundRectangle2D.Double(0, 0, getWidth(), getHeight(), 20, 20));

		createCustomTitleBar();

		customBorder = new LineBorder(Color.decode("#FFC581"), 2, true);

		imagenBg = new ImageIcon("src/main/java/co/edu/unbosque/view/images/VentasAgregar.png").getImage();

		panel = new PanelConFondo();
		panel.setBounds(0, 0, 700, 450); // Ajustar tamaño del panel
		panel.setLayout(null);

		String[] columnNames = { "Producto", "Cantidad", "Precio", "SubTotal" };

		model = new NonEditableTableModel(columnNames, 0);

		tableNuevaVenta = new JTable(model);
		tableNuevaVenta.setGridColor(Color.decode("#FFC581"));
		tableNuevaVenta.setRowHeight(30);
		tableNuevaVenta.setShowGrid(false);
		tableNuevaVenta.setIntercellSpacing(new Dimension(0, 0));

		header = tableNuevaVenta.getTableHeader();
		header.setDefaultRenderer(new BubbleHeaderRenderer());
		header.setPreferredSize(new Dimension(header.getWidth(), 35));
		tableNuevaVenta.setDefaultRenderer(Object.class, new AlternateRowRenderer());

		scroll = new JScrollPane(tableNuevaVenta);
		scroll.setBounds(45, 142, 609, 225);
		scroll.setOpaque(false);
		scroll.getViewport().setOpaque(false);
		scroll.setBorder(BorderFactory.createEmptyBorder());

		btnBack = new JButton();
		btnBack.setBounds(40, 28, 36, 36);
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

		items = new ArrayList<String>();

		txtProducto = new AutoTextField();
		txtProducto.setBounds(52, 87, 153, 38);
		txtProducto.setBorder(customBorder);
		txtProducto.setBackground(Color.decode("#FFF9F3"));

		txtCantidad = new JTextField();
		txtCantidad.setBounds(226, 87, 153, 30);
		txtCantidad.setBorder(customBorder);
		txtCantidad.setBackground(Color.decode("#FFF9F3"));

		txtPrecio = new JTextField();
		txtPrecio.setBounds(396, 87, 153, 30);
		txtPrecio.setBorder(customBorder);
		txtPrecio.setBackground(Color.decode("#FFF9F3"));

		panel.add(btnBack);
		panel.add(scroll);
		panel.add(btnAdd);
		panel.add(txtProducto);
		panel.add(txtCantidad);
		panel.add(txtPrecio);
		panel.add(btnDone);
		add(panel);
	}

	private void createCustomTitleBar() {
		// Crear el panel de la barra de título
		titleBar = new JPanel();
		titleBar.setBackground(Color.decode("#FFC581"));
		titleBar.setLayout(null);
		titleBar.setBounds(0, 0, getWidth(), 30);

		minimizeButton = new JButton("-");
		minimizeButton.setForeground(Color.WHITE);
		minimizeButton.setBackground(Color.decode("#FFC581"));
		minimizeButton.setFocusPainted(false);
		minimizeButton.setBorderPainted(false);
		minimizeButton.setBounds(getWidth() - 80, 0, 40, 30);

		// Cambiar color al hacer hover en el botón de minimizar, va a controller
		minimizeButton.addMouseListener(new MouseAdapter() {
			Color originalColor = minimizeButton.getBackground();
			Color hoverColor = new Color(255, 140, 0);

			@Override
			public void mouseEntered(MouseEvent e) {
				minimizeButton.setBackground(hoverColor);
			}

			@Override
			public void mouseExited(MouseEvent e) {
				minimizeButton.setBackground(originalColor);
			}
		});

		minimizeButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				setState(JFrame.ICONIFIED);
			}
		});

		// Botón de cerrar
		closeButton = new JButton("x");
		closeButton.setForeground(Color.WHITE);
		closeButton.setBackground(Color.decode("#FFC581"));
		closeButton.setFocusPainted(false);
		closeButton.setBorderPainted(false);
		closeButton.setBounds(getWidth() - 40, 0, 40, 30);
		// para el controller
		closeButton.addMouseListener(new MouseAdapter() {
			Color originalColor = closeButton.getBackground();
			Color hoverColor = new Color(255, 0, 0);

			@Override
			public void mouseEntered(MouseEvent e) {
				closeButton.setBackground(hoverColor);
			}

			@Override
			public void mouseExited(MouseEvent e) {
				closeButton.setBackground(originalColor);
			}
		});

		closeButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
			}
		});

		titleBar.add(minimizeButton);
		titleBar.add(closeButton);
		add(titleBar);
	}

	private class PanelConFondo extends JPanel {
		@Override
		protected void paintComponent(Graphics g) {
			super.paintComponent(g);
			// Dibujar la imagen de fondo
			g.drawImage(imagenBg, 0, 0, getWidth(), getHeight(), this);

			Graphics2D g2d = (Graphics2D) g;
			g2d.setColor(Color.decode("#FFBA68"));
			g2d.setStroke(new BasicStroke(5)); // Grosor del borde
			g2d.drawRoundRect(0, 0, getWidth() - 1, getHeight() - 1, 20, 20);
		}
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

	public JButton getBtnDone() {
		return btnDone;
	}

	public void setBtnDone(JButton btnDone) {
		this.btnDone = btnDone;
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

	public AutoTextField getTxtProducto() {
		return txtProducto;
	}

	public void setTxtProducto(AutoTextField txtProducto) {
		this.txtProducto = txtProducto;
	}

	public ArrayList<String> getItems() {
		return items;
	}

	public void setItems(ArrayList<String> items) {
		this.items = items;
	}

	public class AutoTextField extends JTextField {
		private JList<String> suggestionList;
		private JScrollPane suggestionPane;
		private ArrayList<String> suggestions;

		public AutoTextField() {
			super();
			this.suggestions = new ArrayList<>(items);

			// Crear la lista y el panel de sugerencias
			suggestionList = new JList<>();
			suggestionPane = new JScrollPane(suggestionList);
			suggestionPane.setVisible(false); // Oculto por defecto

			// Añadir DocumentListener para mostrar sugerencias mientras escribe
			this.getDocument().addDocumentListener(new DocumentListener() {
				@Override
				public void insertUpdate(DocumentEvent e) {
					updateSuggestions();
				}

				@Override
				public void removeUpdate(DocumentEvent e) {
					updateSuggestions();
				}

				@Override
				public void changedUpdate(DocumentEvent e) {
					updateSuggestions();
				}
			});

			// Añadir un MouseListener para seleccionar sugerencias de la lista
			suggestionList.addMouseListener(new java.awt.event.MouseAdapter() {
				public void mouseClicked(java.awt.event.MouseEvent evt) {
					setText(suggestionList.getSelectedValue());
					suggestionPane.setVisible(false); // Ocultar sugerencias después de seleccionar
				}
			});

			// Añadir el JScrollPane de sugerencias al contenedor principal
			this.setLayout(new BorderLayout());
			this.add(suggestionPane, BorderLayout.SOUTH);
		}

		private void updateSuggestions() {
			String text = this.getText();

			// Filtrar sugerencias
			List<String> filteredSuggestions = new ArrayList<>();
			for (String suggestion : suggestions) {
				if (suggestion.toLowerCase().contains(text.toLowerCase())) {
					filteredSuggestions.add(suggestion);
				}
			}

			// Actualizar la lista si hay sugerencias coincidentes
			if (!filteredSuggestions.isEmpty() && !text.isEmpty()) {
				suggestionList.setListData(filteredSuggestions.toArray(new String[0]));
				suggestionPane.setVisible(true);
				suggestionPane.setPreferredSize(
						new Dimension(this.getWidth(), Math.min(100, filteredSuggestions.size() * 20))); // Ajuste de
																											// altura
																											// dinámico
			} else {

				suggestionPane.setVisible(false); // Ocultar si no hay sugerencias
			}
		}

		public void setSuggestions(ArrayList<String> suggestions) {
			this.suggestions = suggestions;
		}

		public JList<String> getSuggestionList() {
			return suggestionList;
		}

		public void setSuggestionList(JList<String> suggestionList) {
			this.suggestionList = suggestionList;
		}

		public JScrollPane getSuggestionPane() {
			return suggestionPane;
		}

		public void setSuggestionPane(JScrollPane suggestionPane) {
			this.suggestionPane = suggestionPane;
		}

		public ArrayList<String> getSuggestions() {
			return suggestions;
		}

	}

}
