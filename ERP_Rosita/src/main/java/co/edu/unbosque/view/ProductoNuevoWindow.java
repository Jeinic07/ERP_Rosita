package co.edu.unbosque.view;

import java.awt.BasicStroke;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.*;
import java.awt.geom.*;
import java.util.*;
import javax.swing.*;
import javax.swing.border.*;
import javax.swing.event.*;

public class ProductoNuevoWindow extends JFrame {

	private JButton btnBack, minimizeButton, closeButton;;
	private JButton btnDone;

	private JTextField txtNombre;
	private JTextField txtMarca;
	private JTextField txtCosto;
	private Image imageBg;
	private JPanel panel, titleBar;
	private JTextField txtPrecio;
	private AutoTextField txtProveedor;
	private ArrayList<String> items;
	private LineBorder customBorder;

	public ProductoNuevoWindow() {
		setSize(253, 412);
		setLayout(null);
		setLayout(null);
		setLocationRelativeTo(null);
		setResizable(false);
		setUndecorated(true);
		setVisible(false);

		setShape(new RoundRectangle2D.Double(0, 0, getWidth(), getHeight(), 20, 20));
		createCustomTitleBar();
		customBorder = new LineBorder(Color.decode("#FFC581"), 2, true);

		imageBg = new ImageIcon("src/main/java/co/edu/unbosque/view/images/AddInventario.png").getImage();
		panel = new PanelConFondo();
		panel.setBounds(0, 0, 253, 412);
		panel.setLayout(null);

		btnBack = new JButton();
		btnBack.setBounds(18, 37, 36, 36);
		btnBack.setContentAreaFilled(false);
		btnBack.setBorderPainted(false);
		btnBack.setFocusPainted(false);

		btnDone = new JButton();
		btnDone.setBounds(88, 324, 76, 29);
		btnDone.setContentAreaFilled(false);
		btnDone.setBorderPainted(false);
		btnDone.setFocusPainted(false);

		txtNombre = new JTextField("");
		txtNombre.setBounds(119, 136, 99, 25);
		txtNombre.setBorder(customBorder);

		txtMarca = new JTextField("");
		txtMarca.setBounds(119, 176, 99, 25);
		txtMarca.setBorder(customBorder);

		txtCosto = new JTextField("");
		txtCosto.setBounds(119, 216, 99, 25);
		txtCosto.setBorder(customBorder);

		txtPrecio = new JTextField("");
		txtPrecio.setBounds(119, 256, 99, 25);
		txtPrecio.setBorder(customBorder);

		items = new ArrayList<>();

		txtProveedor = new AutoTextField();
		txtProveedor.setBounds(119, 296, 99, 35);
		txtProveedor.setBorder(customBorder);

		panel.add(btnBack);
		panel.add(btnDone);
		panel.add(txtNombre);
		panel.add(txtMarca);
		panel.add(txtCosto);
		panel.add(txtPrecio);
		panel.add(txtProveedor);
		add(panel);

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

	public JButton getMinimizeButton() {
		return minimizeButton;
	}

	public void setMinimizeButton(JButton minimizeButton) {
		this.minimizeButton = minimizeButton;
	}

	public JButton getCloseButton() {
		return closeButton;
	}

	public void setCloseButton(JButton closeButton) {
		this.closeButton = closeButton;
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

	public JPanel getTitleBar() {
		return titleBar;
	}

	public void setTitleBar(JPanel titleBar) {
		this.titleBar = titleBar;
	}

	public LineBorder getCustomBorder() {
		return customBorder;
	}

	public void setCustomBorder(LineBorder customBorder) {
		this.customBorder = customBorder;
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
			g.drawImage(imageBg, 0, 0, getWidth(), getHeight(), this);

			Graphics2D g2d = (Graphics2D) g;
			g2d.setColor(Color.decode("#FFBA68"));
			g2d.setStroke(new BasicStroke(5)); // Grosor del borde
			g2d.drawRoundRect(0, 0, getWidth() - 1, getHeight() - 1, 20, 20);
		}
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
