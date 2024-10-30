package co.edu.unbosque.view;

import javax.swing.JButton;
import javax.swing.JFrame;

public class MainWindow extends JFrame{

	private OptionPanel op;
	private InventarioPanel ip;
	private VentasPanel vp;
	private ComprasPanel cp;
	private GastosPanel gp;
	
	
	public MainWindow() {
		
		op = new OptionPanel();
		ip = new InventarioPanel();
		vp = new VentasPanel();
		cp = new ComprasPanel();
		gp = new GastosPanel();
				
		
		setTitle("sisas");
		setBounds(0, 0, 800, 600);
		setLayout(null);
		setResizable(false);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		add(op);
		add(ip);
		add(vp);
		add(cp);
		add(gp);
		
		setVisible(true);
	}

	public OptionPanel getOp() {
		return op;
	}

	public void setOp(OptionPanel op) {
		this.op = op;
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
	

	
	
}
