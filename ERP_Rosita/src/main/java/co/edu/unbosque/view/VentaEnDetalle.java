package co.edu.unbosque.view;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.geom.RoundRectangle2D;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;


public class VentaEnDetalle extends JFrame{
	private Image imagenBg;
	private JPanel panel, titleBar;
	private JButton btnOk, minimizeButton, closeButton;
	private JTable tableDV;
	private JScrollPane scroll;
	private NonEditableTableModel model;

	public VentaEnDetalle() {
		setSize(600, 600);
		setLayout(null);
		setLocationRelativeTo(null);
		setResizable(false);
		setUndecorated(true);
		setVisible(false);
		setShape(new RoundRectangle2D.Double(0, 0, getWidth(), getHeight(), 20, 20));

		createCustomTitleBar();

//		imagenBg = new ImageIcon("src/main/java/co/edu/unbosque/view/images/VentaDetalle.png").getImage();
		panel = new PanelConFondo();
		panel.setBounds(0, 0, 600, 600);
		panel.setLayout(null);

		btnOk = new JButton("ok");
		btnOk.setBounds(214, 496, 172, 37);
		btnOk.setContentAreaFilled(false);
		btnOk.setBorderPainted(false);
		btnOk.setFocusPainted(false);
		
		
        String[] columnNames = {"Producto", "Cantidad",  "Precio", "SubTotal"};
        model = new NonEditableTableModel(columnNames, 0);
        tableDV = new JTable(model);
        
		scroll = new JScrollPane(tableDV);
		scroll.setBounds(60, 60, 500, 400);

		panel.add(scroll);
		panel.add(btnOk);
		add(panel);
	}
    // Modelo de tabla no editable
    public class NonEditableTableModel extends DefaultTableModel {
        public NonEditableTableModel(Object[] columnNames, int rowCount) {
            super(columnNames, rowCount);
        }

        @Override
        public boolean isCellEditable(int row, int column) {
            return false; 
        }
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
			g.drawImage(imagenBg, 0, 0, getWidth(), getHeight(), this);

			Graphics2D g2d = (Graphics2D) g;
			g2d.setColor(Color.decode("#FFC581"));
			g2d.setStroke(new BasicStroke(5)); // Grosor del borde
			g2d.drawRoundRect(0, 0, getWidth() - 1, getHeight() - 1, 20, 20);
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


