package co.edu.unbosque.model;

public class ProveedorDTO {
	
	private int idProveedor;
	private String nombreProveedor;
	private String tipoDocumentoProveedor;
	private String documentoProveedor;
	private String telefonoProveedor;
	private String direccionProveedor;
	
	public ProveedorDTO() {
		// TODO Auto-generated constructor stub
	}

	public ProveedorDTO(int idProveedor, String nombreProveedor, String tipoDocumentoProveedor,
			String documentoProveedor, String telefonoProveedor, String direccionProveedor) {
		super();
		this.idProveedor = idProveedor;
		this.nombreProveedor = nombreProveedor;
		this.tipoDocumentoProveedor = tipoDocumentoProveedor;
		this.documentoProveedor = documentoProveedor;
		this.telefonoProveedor = telefonoProveedor;
		this.direccionProveedor = direccionProveedor;
	}

	public ProveedorDTO(String nombreProveedor, String tipoDocumentoProveedor, String documentoProveedor,
			String telefonoProveedor, String direccionProveedor) {
		super();
		this.nombreProveedor = nombreProveedor;
		this.tipoDocumentoProveedor = tipoDocumentoProveedor;
		this.documentoProveedor = documentoProveedor;
		this.telefonoProveedor = telefonoProveedor;
		this.direccionProveedor = direccionProveedor;
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

	public String getTipoDocumentoProveedor() {
		return tipoDocumentoProveedor;
	}

	public void setTipoDocumentoProveedor(String tipoDocumentoProveedor) {
		this.tipoDocumentoProveedor = tipoDocumentoProveedor;
	}

	public String getDocumentoProveedor() {
		return documentoProveedor;
	}

	public void setDocumentoProveedor(String documentoProveedor) {
		this.documentoProveedor = documentoProveedor;
	}

	public String getTelefonoProveedor() {
		return telefonoProveedor;
	}

	public void setTelefonoProveedor(String telefonoProveedor) {
		this.telefonoProveedor = telefonoProveedor;
	}

	public String getDireccionProveedor() {
		return direccionProveedor;
	}

	public void setDireccionProveedor(String direccionProveedor) {
		this.direccionProveedor = direccionProveedor;
	}

	@Override
	public String toString() {
		return "ProveedorDTO [idProveedor=" + idProveedor + ", nombreProveedor=" + nombreProveedor
				+ ", tipoDocumentoProveedor=" + tipoDocumentoProveedor + ", documentoProveedor=" + documentoProveedor
				+ ", telefonoProveedor=" + telefonoProveedor + ", direccionProveedor=" + direccionProveedor + "]";
	}
	
		

}
