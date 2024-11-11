package co.edu.unbosque.model;

public class DetalleVentaDTO {
	
	private int idDV;
	private int cantidadDV; 
	private float precioUnitarioDV; 
	private float subtotalDV; 
	private int idProductoDV; 
	private int idVentaDV; 
	private String nombreProducto;
	
	
	public DetalleVentaDTO() {

	}

	public DetalleVentaDTO(int idDV, int cantidadDV, float precioUnitarioDV, float subtotalDV, int idProductoDV,
			int idVentaDV, String nombreProducto) {
		super();
		this.idDV = idDV;
		this.cantidadDV = cantidadDV;
		this.precioUnitarioDV = precioUnitarioDV;
		this.subtotalDV = subtotalDV;
		this.idProductoDV = idProductoDV;
		this.idVentaDV = idVentaDV;
		this.nombreProducto = nombreProducto;
	}

	public DetalleVentaDTO(int cantidadDV, float precioUnitarioDV, float subtotalDV, int idProductoDV, int idVentaDV) {
		super();
		this.cantidadDV = cantidadDV;
		this.precioUnitarioDV = precioUnitarioDV;
		this.subtotalDV = subtotalDV;
		this.idProductoDV = idProductoDV;
		this.idVentaDV = idVentaDV;
	}

	public DetalleVentaDTO(int idDV, int cantidadDV, float precioUnitarioDV, float subtotalDV, int idProductoDV,
			int idVentaDV) {
		super();
		this.idDV = idDV;
		this.cantidadDV = cantidadDV;
		this.precioUnitarioDV = precioUnitarioDV;
		this.subtotalDV = subtotalDV;
		this.idProductoDV = idProductoDV;
		this.idVentaDV = idVentaDV;
	}
	
	

	public DetalleVentaDTO(String nombreProducto, int cantidadDV, float precioUnitarioDV, float subtotalDV, int idProducto) {
		super();
		this.idProductoDV = idProducto;
		this.nombreProducto = nombreProducto;
		this.cantidadDV = cantidadDV;
		this.precioUnitarioDV = precioUnitarioDV;
		this.subtotalDV = subtotalDV;

	}

	public int getIdDV() {
		return idDV;
	}

	public void setIdDV(int idDV) {
		this.idDV = idDV;
	}

	public int getCantidadDV() {
		return cantidadDV;
	}

	public void setCantidadDV(int cantidadDV) {
		this.cantidadDV = cantidadDV;
	}

	public float getPrecioUnitarioDV() {
		return precioUnitarioDV;
	}

	public void setPrecioUnitarioDV(float precioUnitarioDV) {
		this.precioUnitarioDV = precioUnitarioDV;
	}

	public float getSubtotalDV() {
		return subtotalDV;
	}

	public void setSubtotalDV(float subtotalDV) {
		this.subtotalDV = subtotalDV;
	}

	public int getIdProductoDV() {
		return idProductoDV;
	}

	public void setIdProductoDV(int idProductoDV) {
		this.idProductoDV = idProductoDV;
	}

	public int getIdVentaDV() {
		return idVentaDV;
	}

	public void setIdVentaDV(int idVentaDV) {
		this.idVentaDV = idVentaDV;
	}

	public String getNombreProducto() {
		return nombreProducto;
	}

	public void setNombreProducto(String nombreProducto) {
		this.nombreProducto = nombreProducto;
	}

	@Override
	public String toString() {
		return "DetalleVentaDTO [idDV=" + idDV + ", cantidadDV=" + cantidadDV + ", precioUnitarioDV=" + precioUnitarioDV
				+ ", subtotalDV=" + subtotalDV + ", idProductoDV=" + idProductoDV + ", idVentaDV=" + idVentaDV
				+ ", nombreProducto=" + nombreProducto + "]";
	}
	
}
