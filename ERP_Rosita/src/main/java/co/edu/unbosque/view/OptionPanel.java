package co.edu.unbosque.view;

import javax.swing.JButton;
import javax.swing.JPanel;

public class OptionPanel extends JPanel {
	
	private JButton btnInventario, btnVentas, btnCompras, btnGastos;

	public OptionPanel() {
		setBounds(0, 0, 800, 600);
		setLayout(null);
		
		btnInventario = new JButton("Inventario");
		btnInventario.setBounds(242,231, 120,40);
		btnInventario.setVisible(true);
		
		btnVentas = new JButton("Ventas");
		btnVentas.setBounds(457,231, 120,40);
		btnVentas.setVisible(true);
		
		btnCompras = new JButton("Compras");
		btnCompras.setBounds(242,317, 120,40);
		btnCompras.setVisible(true);
		
		btnGastos = new JButton("Gastos");
		btnGastos.setBounds(457,317, 120,40);
		btnGastos.setVisible(true);
		
		
		add(btnInventario);
		add(btnVentas);
		add(btnCompras);
		add(btnGastos);
		
		setVisible(true);

	}

	public JButton getBtnInventario() {
		return btnInventario;
	}

	public void setBtnInventario(JButton btnInventario) {
		this.btnInventario = btnInventario;
	}

	public JButton getBtnVentas() {
		return btnVentas;
	}

	public void setBtnVentas(JButton btnVentas) {
		this.btnVentas = btnVentas;
	}

	public JButton getBtnCompras() {
		return btnCompras;
	}

	public void setBtnCompras(JButton btnCompras) {
		this.btnCompras = btnCompras;
	}

	public JButton getBtnGastos() {
		return btnGastos;
	}

	public void setBtnGastos(JButton btnGastos) {
		this.btnGastos = btnGastos;
	}
	
	
}
