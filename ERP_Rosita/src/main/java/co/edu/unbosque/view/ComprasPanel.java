package co.edu.unbosque.view;

import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class ComprasPanel extends JPanel {

	private JLabel si;
	private JButton btnBack;
	
	public ComprasPanel() {
		setBounds(0, 0, 800, 600);
		setLayout(null);

		si = new JLabel("Compras");
		si.setFont(new Font("Arial", Font.PLAIN, 18));
		si.setBounds(323, 46, 161, 50);

		btnBack = new JButton("<-");
		btnBack.setBounds(47, 30, 77, 32);

		add(si);
		add(btnBack);

		setVisible(false);
	}

	public JLabel getSi() {
		return si;
	}

	public void setSi(JLabel si) {
		this.si = si;
	}

	public JButton getBtnBack() {
		return btnBack;
	}

	public void setBtnBack(JButton btnBack) {
		this.btnBack = btnBack;
	}
	
	
}
