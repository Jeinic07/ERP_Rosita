package co.edu.unbosque.view;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;
import java.util.ArrayList;
import java.util.List;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.table.DefaultTableModel;
public class CompraNuevaWindow extends JFrame {

	private JButton btnBack;
	private JButton btnAdd, btnDone;
	private JLabel titleLabel;
	private Image imagenBg;
	private JPanel panel;
	private JTable tableNuevaVenta;
	private JScrollPane scroll;
	private DefaultTableModel model;
	private AutoTextField txtProducto;
	private JTextField txtCantidad, txtPrecio;
	private ArrayList<String> items;

	public CompraNuevaWindow() {
		setBounds(369, 250, 700, 450);
		setLayout(null);
		setVisible(false);
		setUndecorated(true);
		setResizable(false);
		setLocationRelativeTo(null);
//Cambiar el jpg por el que está haciendo mi Maria P 👊
		imagenBg = new ImageIcon("src/main/java/co/edu/unbosque/view/images/VentasAgregar.png").getImage();

		panel = new PanelConFondo();
		panel.setBounds(0, 0, 700, 450); // Ajustar tamaño del panel
		panel.setLayout(null);

		String[] columnNames = { "Producto", "Cantidad", "Precio", "SubTotal" };
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

		
		items = new ArrayList<String>();

		txtProducto = new AutoTextField();
		txtProducto.setBounds(49, 69, 153, 34);

		txtCantidad = new JTextField();
		txtCantidad.setBounds(221, 69, 153, 34);

		txtPrecio = new JTextField();
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

	private class PanelConFondo extends JPanel {
		@Override
		protected void paintComponent(Graphics g) {
			super.paintComponent(g);
			// Dibujar la imagen de fondo
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

