package co.edu.unbosque.model;

import java.time.LocalDate;
import java.time.LocalTime;

public class CompraDTO {

	private int idfechaCompra;
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

	public CompraDTO(int idfechaCompra, LocalDate fechaCompra, LocalTime horaCompra, float totalCompra) {
		super();
		this.idfechaCompra = idfechaCompra;
		this.fechaCompra = fechaCompra;
		this.horaCompra = horaCompra;
		this.totalCompra = totalCompra;
	}

	public int getIdfechaCompra() {
		return idfechaCompra;
	}

	public void setIdfechaCompra(int idfechaCompra) {
		this.idfechaCompra = idfechaCompra;
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
		return "CompraDTO [idfechaCompra=" + idfechaCompra + ", fechaCompra=" + fechaCompra + ", horaCompra=" + horaCompra
				+ ", totalCompra=" + totalCompra + "]";
	}
	

}
