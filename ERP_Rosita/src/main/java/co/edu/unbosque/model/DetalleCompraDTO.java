package co.edu.unbosque.model;

public class DetalleCompraDTO {

	private int idDC;
	private int cantidadDC;
	private float costoUnitarioDC;
	private float subtotalDC;
	private int idProductoDC;
	private int idCompraDC;
	private String nombreProducto;

	public DetalleCompraDTO() {

	}

	public DetalleCompraDTO(int idDC, int cantidadDC, float costoUnitarioDC, float subtotalDC, int idProductoDC,
			int idCompraDC, String nombreProducto) {
		super();
		this.idDC = idDC;
		this.cantidadDC = cantidadDC;
		this.costoUnitarioDC = costoUnitarioDC;
		this.subtotalDC = subtotalDC;
		this.idProductoDC = idProductoDC;
		this.idCompraDC = idCompraDC;
		this.nombreProducto = nombreProducto;
	}

	public DetalleCompraDTO(int cantidadDV, float precioUnitarioDV, float subtotalDV, int idProductoDV, int idVentaDV) {
		super();
		this.cantidadDC = cantidadDV;
		this.costoUnitarioDC = precioUnitarioDV;
		this.subtotalDC = subtotalDV;
		this.idProductoDC = idProductoDV;
		this.idCompraDC = idVentaDV;
	}

	public DetalleCompraDTO(String nombreProducto, int cantidadDC, float costoUnitarioDC, float subtotalDC, int idProductoDC) {
		super();
		this.idProductoDC = idProductoDC;
		this.cantidadDC = cantidadDC;
		this.costoUnitarioDC = costoUnitarioDC;
		this.subtotalDC = subtotalDC;
		this.nombreProducto = nombreProducto;
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

	public float getcostoUnitarioDC() {
		return costoUnitarioDC;
	}

	public void setcostoUnitarioDC(float costoUnitarioDC) {
		this.costoUnitarioDC = costoUnitarioDC;
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
		return "DetalleCompraDTO [idDC=" + idDC + ", cantidadDC=" + cantidadDC + ", costoUnitarioDC=" + costoUnitarioDC
				+ ", subtotalDC=" + subtotalDC + ", idProductoDC=" + idProductoDC + ", idCompraDC=" + idCompraDC
				+ ", nombreProducto=" + nombreProducto + "]";
	}

}
