package co.edu.unbosque.model;

import java.time.LocalDate;
import java.time.LocalTime;

public class CompraDTO {

	private int idCompra;
	private LocalDate fechaCompra;
	private LocalTime horaCompra;
	private float totalCompra;

	public CompraDTO() {
		// TODO Auto-generated constructor stub
	}
	
	public CompraDTO(LocalDate fechaCompra, LocalTime horaCompra, float totalCompra) {
		super();
		this.fechaCompra = fechaCompra;
		this.horaCompra = horaCompra;
		this.totalCompra = totalCompra;
	}

	public CompraDTO(int idCompra, LocalDate fechaCompra, LocalTime horaCompra, float totalCompra) {
		super();
		this.idCompra = idCompra;
		this.fechaCompra = fechaCompra;
		this.horaCompra = horaCompra;
		this.totalCompra = totalCompra;
	}

	public int getidCompra() {
		return idCompra;
	}

	public void setIdCompra(int idfecha) {
		this.idCompra = idfecha;
	}

	public LocalDate getfechaCompra() {
		return fechaCompra;
	}

	public void setfechaCompra(LocalDate fechaCompra) {
		this.fechaCompra = fechaCompra;
	}

	public LocalTime gethoraCompra() {
		return horaCompra;
	}

	public void sethoraCompra(LocalTime horaCompra) {
		this.horaCompra = horaCompra;
	}

	public float gettotalCompra() {
		return totalCompra;
	}

	public void settotalCompra(float totalCompra) {
		this.totalCompra = totalCompra;
	}

	@Override
	public String toString() {
		return "CompraDTO [idfechaCompra=" + idCompra + ", fechaCompra=" + fechaCompra + ", horaCompra=" + horaCompra
				+ ", totalCompra=" + totalCompra + "]";
	}
	

}
