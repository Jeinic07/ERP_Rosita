package co.edu.unbosque.view;

import java.awt.geom.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class MainWindow extends JFrame {

	private LoginPanel lp;
	private OptionPanel op;
	private OptionPanelInfo opi;
	private InventarioPanel ip;
	private ProductoNuevoWindow pnw;
	private VentasPanel vp;
	private ComprasPanel cp;
	private GastosPanel gp;
	private ProveedoresPanel pp;
	private ProveedorNuevoWindow pw;
	private ProveedorEditarWindow pew;
	private VentaNuevaWindow vw;
	private CompraNuevaWindow cnp;
	private JPanel titleBar;
	private JButton minimizeButton;
	private JButton closeButton;

	public MainWindow() {

		op = new OptionPanel();
		ip = new InventarioPanel();
		opi = new OptionPanelInfo();
		vp = new VentasPanel();
		cp = new ComprasPanel();
		gp = new GastosPanel();
		pp = new ProveedoresPanel();
		pw = new ProveedorNuevoWindow();
		vw = new VentaNuevaWindow();
		pew = new ProveedorEditarWindow();
		pnw = new ProductoNuevoWindow();
		cnp = new CompraNuevaWindow();

		setTitle("sisas");
		setSize(800, 600);
		setLayout(null);
		setUndecorated(true);
		setResizable(false);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(EXIT_ON_CLOSE);

		setShape(new RoundRectangle2D.Double(0, 0, getWidth(), getHeight(), 20, 20));
		createCustomTitleBar();

		add(op);
		add(ip);
		add(vp);
		add(cp);
		add(gp);
		add(pp);

		setVisible(false);
	}

	private void createCustomTitleBar() {
		// Crear el panel de la barra de título
		titleBar = new JPanel();
		titleBar.setBackground(Color.decode("#FFC581")); // Fondo naranja
		titleBar.setLayout(null); // Usar layout null para posicionar botones manualmente
		titleBar.setBounds(0, 0, getWidth(), 30); // Posicionar en la parte superior
		minimizeButton = new JButton("-");
		minimizeButton.setForeground(Color.WHITE);
		minimizeButton.setBackground(Color.decode("#FFC581"));
		minimizeButton.setFocusPainted(false);
		minimizeButton.setBorderPainted(false);
		minimizeButton.setBounds(getWidth() - 80, 0, 40, 30);
		// Cambiar color al hacer hover en el botón de minimizar
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
		// Botón de cerrar
		closeButton = new JButton("x");
		closeButton.setForeground(Color.WHITE);
		closeButton.setBackground(Color.decode("#FFC581")); // Color aún más oscuro
		closeButton.setFocusPainted(false);
		closeButton.setBorderPainted(false);
		closeButton.setBounds(getWidth() - 40, 0, 40, 30); // Posicionar el botón
//para el controller
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
				System.exit(0); // Cerrar la aplicación
			}
		});
		titleBar.add(minimizeButton);
		titleBar.add(closeButton);
		add(titleBar);
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

	public LoginPanel getLp() {
		return lp;
	}

	public void setLp(LoginPanel lp) {
		this.lp = lp;
	}

	public OptionPanel getOp() {
		return op;
	}

	public void setOp(OptionPanel op) {
		this.op = op;
	}

	public OptionPanelInfo getOpi() {
		return opi;
	}

	public void setOpi(OptionPanelInfo opi) {
		this.opi = opi;
	}

	public InventarioPanel getIp() {
		return ip;
	}

	public void setIp(InventarioPanel ip) {
		this.ip = ip;
	}

	public VentasPanel getVp() {
		return vp;
	}

	public void setVp(VentasPanel vp) {
		this.vp = vp;
	}

	public ComprasPanel getCp() {
		return cp;
	}

	public void setCp(ComprasPanel cp) {
		this.cp = cp;
	}

	public GastosPanel getGp() {
		return gp;
	}

	public void setGp(GastosPanel gp) {
		this.gp = gp;
	}

	public ProveedoresPanel getPp() {
		return pp;
	}

	public void setPp(ProveedoresPanel pp) {
		this.pp = pp;
	}

	public ProveedorNuevoWindow getPw() {
		return pw;
	}

	public void setPw(ProveedorNuevoWindow pw) {
		this.pw = pw;
	}

	public VentaNuevaWindow getVw() {
		return vw;
	}

	public void setVw(VentaNuevaWindow vw) {
		this.vw = vw;
	}

	public ProveedorEditarWindow getPew() {
		return pew;
	}

	public void setPew(ProveedorEditarWindow pew) {
		this.pew = pew;
	}

	public ProductoNuevoWindow getPnw() {
		return pnw;
	}

	public void setPnw(ProductoNuevoWindow pnw) {
		this.pnw = pnw;
	}

	public CompraNuevaWindow getCnp() {
		return cnp;
	}

	public void setCnp(CompraNuevaWindow cnp) {
		this.cnp = cnp;
	}

}
