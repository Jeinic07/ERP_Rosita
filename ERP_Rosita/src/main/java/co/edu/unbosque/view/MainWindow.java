package co.edu.unbosque.view;

import javax.swing.JButton;
import javax.swing.JFrame;

public class MainWindow extends JFrame{

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
		
		add(op);
		add(ip);
		add(vp);
		add(cp);
		add(gp);
		add(pp);
		
		setVisible(true);
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
