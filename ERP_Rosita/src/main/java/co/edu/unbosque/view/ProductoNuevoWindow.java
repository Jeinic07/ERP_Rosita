package co.edu.unbosque.view;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;

public class ProductoNuevoWindow extends JFrame {

	private JButton btnBack;
	private JButton btnDone;

	private JTextField txtNombre;
	private JTextField txtMarca;
	private JTextField txtCosto;
	private JTextField txtPrecio;
	private AutoTextField txtProveedor;
	private ArrayList<String> items;
	
	public ProductoNuevoWindow() {
		setSize(253, 412);
		setLayout(null);
		setLayout(null);
		setLocationRelativeTo(null);
		setResizable(false);
		setUndecorated(true);
		setVisible(false);
		
		btnBack = new JButton("<-");
		btnBack.setBounds(10, 5, 50, 32);
		btnBack.setContentAreaFilled(false);
		btnBack.setBorderPainted(false);
		
		btnDone = new JButton("Hecho");
		btnDone.setBounds(84, 380, 84, 40);
		btnDone.setContentAreaFilled(false);
		btnDone.setBorderPainted(false);
		
		txtNombre = new JTextField("");
		txtNombre.setBounds(116, 97, 99, 25);
		
		txtMarca = new JTextField("");
		txtMarca.setBounds(116, 137, 99, 25);
		
		txtCosto = new JTextField("");
		txtCosto.setBounds(116, 177, 99, 25);
		
		txtPrecio= new JTextField("");
		txtPrecio.setBounds(116, 217, 99, 25);
		
		items = new ArrayList<>();

		txtProveedor = new AutoTextField();
		txtProveedor.setBounds(116, 257, 99, 100);
		
		add(btnBack);
		add(btnDone);
		add(txtNombre);
		add(txtMarca);
		add(txtCosto);
		add(txtPrecio);
		add(txtProveedor);
		
	}
	
	
	
	
	

	public JButton getBtnBack() {
		return btnBack;
	}






	public void setBtnBack(JButton btnBack) {
		this.btnBack = btnBack;
	}






	public JButton getBtnDone() {
		return btnDone;
	}






	public void setBtnDone(JButton btnDone) {
		this.btnDone = btnDone;
	}






	public JTextField getTxtNombre() {
		return txtNombre;
	}






	public void setTxtNombre(JTextField txtNombre) {
		this.txtNombre = txtNombre;
	}






	public JTextField getTxtMarca() {
		return txtMarca;
	}






	public void setTxtMarca(JTextField txtMarca) {
		this.txtMarca = txtMarca;
	}






	public JTextField getTxtCosto() {
		return txtCosto;
	}






	public void setTxtCosto(JTextField txtCosto) {
		this.txtCosto = txtCosto;
	}






	public JTextField getTxtPrecio() {
		return txtPrecio;
	}






	public void setTxtPrecio(JTextField txtPrecio) {
		this.txtPrecio = txtPrecio;
	}






	public AutoTextField getTxtProveedor() {
		return txtProveedor;
	}






	public void setTxtProveedor(AutoTextField txtProveedor) {
		this.txtProveedor = txtProveedor;
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
