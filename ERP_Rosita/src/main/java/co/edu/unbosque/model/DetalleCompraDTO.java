package co.edu.unbosque.model;

public class DetalleCompraDTO {

	private int idDC;
	private int cantidadDC; 
	private float precioUnitarioDC; 
	private float subtotalDC; 
	private int idProductoDC; 
	private int idCompraDC; 
	private String nombreProducto;

	public DetalleCompraDTO() {
		
	}

	public DetalleCompraDTO(int idDC, int cantidadDC, float precioUnitarioDC, float subtotalDC, int idProductoDC,
			int idVentaDC, String nombreProducto) {
		super();
		this.idDC = idDC;
		this.cantidadDC = cantidadDC;
		this.precioUnitarioDC = precioUnitarioDC;
		this.subtotalDC = subtotalDC;
		this.idProductoDC = idProductoDC;
		this.idCompraDC = idVentaDC;
		this.nombreProducto = nombreProducto;
	}
	
	public DetalleCompraDTO(int cantidadDV, float precioUnitarioDV, float subtotalDV, int idProductoDV, int idVentaDV) {
		super();
		this.cantidadDC = cantidadDV;
		this.precioUnitarioDC = precioUnitarioDV;
		this.subtotalDC = subtotalDV;
		this.idProductoDC = idProductoDV;
		this.idCompraDC = idVentaDV;
	}	
	public DetalleCompraDTO(int idDV, int cantidadDV, float precioUnitarioDV, float subtotalDV, int idProductoDV,
			int idVentaDV) {
		super();
		this.idDC = idDC;
		this.cantidadDC = cantidadDC;
		this.precioUnitarioDC = precioUnitarioDC;
		this.subtotalDC = subtotalDC;
		this.idProductoDC = idProductoDC;
		this.idCompraDC = idCompraDC;
	}

	public int getIdDC() {
		return idDC;
	}

	public void setIdDC(int idDC) {
		this.idDC = idDC;
	}

	public int getCantidadDC() {
		return cantidadDC;
	}

	public void setCantidadDC(int cantidadDC) {
		this.cantidadDC = cantidadDC;
	}

	public float getPrecioUnitarioDC() {
		return precioUnitarioDC;
	}

	public void setPrecioUnitarioDC(float precioUnitarioDC) {
		this.precioUnitarioDC = precioUnitarioDC;
	}

	public float getSubtotalDC() {
		return subtotalDC;
	}

	public void setSubtotalDC(float subtotalDC) {
		this.subtotalDC = subtotalDC;
	}

	public int getIdProductoDC() {
		return idProductoDC;
	}

	public void setIdProductoDC(int idProductoDC) {
		this.idProductoDC = idProductoDC;
	}

	public int getIdCompraDC() {
		return idCompraDC;
	}

	public void setIdCompraDC(int idCompraDC) {
		this.idCompraDC = idCompraDC;
	}

	public String getNombreProducto() {
		return nombreProducto;
	}

	public void setNombreProducto(String nombreProducto) {
		this.nombreProducto = nombreProducto;
	}

	@Override
	public String toString() {
		return "DetalleCompraDTO [idDC=" + idDC + ", cantidadDC=" + cantidadDC + ", precioUnitarioDC="
				+ precioUnitarioDC + ", subtotalDC=" + subtotalDC + ", idProductoDC=" + idProductoDC + ", idVentaDC="
				+ idCompraDC + ", nombreProducto=" + nombreProducto + "]";
	}
	
}
