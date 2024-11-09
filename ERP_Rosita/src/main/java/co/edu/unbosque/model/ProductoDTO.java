package co.edu.unbosque.model;

public class ProductoDTO {
	private int idProducto;
	private String nombreProducto;
	private String marcaProducto;
	private int stockProducto;
	private float costoProducto;
	private float precioProducto;
	private int idProveedor;
	private String nombreProveedor;
	
	public ProductoDTO() {
		// TODO Auto-generated constructor stub
	}

	public ProductoDTO(int idProducto, String nombreProducto, String marcaProducto, int stockProducto,
			float costoProducto, float precioProducto, int idProveedor) {
		super();
		this.idProducto = idProducto;
		this.nombreProducto = nombreProducto;
		this.marcaProducto = marcaProducto;
		this.stockProducto = stockProducto;
		this.costoProducto = costoProducto;
		this.precioProducto = precioProducto;
		this.idProveedor = idProveedor;
	}

	public ProductoDTO(String nombreProducto, String marcaProducto, int stockProducto, float costoProducto,
			float precioProducto, int idProveedor) {
		super();
		this.nombreProducto = nombreProducto;
		this.marcaProducto = marcaProducto;
		this.stockProducto = stockProducto;
		this.costoProducto = costoProducto;
		this.precioProducto = precioProducto;
		this.idProveedor = idProveedor;
	}
	

	public ProductoDTO(String nombreProducto, String marcaProducto, int stockProducto, float costoProducto,
			float precioProducto, String nombreProveedor) {
		super();
		this.nombreProducto = nombreProducto;
		this.marcaProducto = marcaProducto;
		this.stockProducto = stockProducto;
		this.costoProducto = costoProducto;
		this.precioProducto = precioProducto;
		this.nombreProveedor = nombreProveedor;
	}
	

	public ProductoDTO(int idProducto, String nombreProducto, String marcaProducto, int stockProducto,
			float costoProducto, float precioProducto, String nombreProveedor) {
		super();
		this.idProducto = idProducto;
		this.nombreProducto = nombreProducto;
		this.marcaProducto = marcaProducto;
		this.stockProducto = stockProducto;
		this.costoProducto = costoProducto;
		this.precioProducto = precioProducto;
		this.nombreProveedor = nombreProveedor;
		
		
	}

	public ProductoDTO(String nombreProducto, String marcaProducto, int stockProducto, float costoProducto,
			float precioProducto, int idProveedor, String nombreProveedor) {
		super();
		this.nombreProducto = nombreProducto;
		this.marcaProducto = marcaProducto;
		this.stockProducto = stockProducto;
		this.costoProducto = costoProducto;
		this.precioProducto = precioProducto;
		this.idProveedor = idProveedor;
		this.nombreProveedor = nombreProveedor;
	}

	public int getIdProducto() {
		return idProducto;
	}

	public void setIdProducto(int idProducto) {
		this.idProducto = idProducto;
	}

	public String getNombreProducto() {
		return nombreProducto;
	}

	public void setNombreProducto(String nombreProducto) {
		this.nombreProducto = nombreProducto;
	}

	public String getMarcaProducto() {
		return marcaProducto;
	}

	public void setMarcaProducto(String marcaProducto) {
		this.marcaProducto = marcaProducto;
	}

	public int getStockProducto() {
		return stockProducto;
	}

	public void setStockProducto(int stockProducto) {
		this.stockProducto = stockProducto;
	}

	public float getCostoProducto() {
		return costoProducto;
	}

	public void setCostoProducto(float costoProducto) {
		this.costoProducto = costoProducto;
	}

	public float getPrecioProducto() {
		return precioProducto;
	}

	public void setPrecioProducto(float precioProducto) {
		this.precioProducto = precioProducto;
	}

	public int getIdProveedor() {
		return idProveedor;
	}

	public void setIdProveedor(int idProveedor) {
		this.idProveedor = idProveedor;
	}
	
	public String getNombreProveedor() {
		return nombreProveedor;
	}

	public void setNombreProveedor(String nombreProveedor) {
		this.nombreProveedor = nombreProveedor;
	}

	@Override
	public String toString() {
		return "ProductoDTO [idProducto=" + idProducto + ", nombreProducto=" + nombreProducto + ", marcaProducto="
				+ marcaProducto + ", stockProducto=" + stockProducto + ", costoProducto=" + costoProducto
				+ ", precioProducto=" + precioProducto + ", idProveedor=" + idProveedor + ", nombreProveedor="
				+ nombreProveedor + "]";
	}


	
	
}
