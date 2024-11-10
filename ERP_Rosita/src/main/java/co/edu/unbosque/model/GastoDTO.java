package co.edu.unbosque.model;

import java.time.LocalDate;
import java.time.LocalTime;

public class GastoDTO {
	
	private int idGasto;
	private LocalDate fechaGasto;
	private LocalTime horaGasto;
	private String descipcionGasto;
	private float valorGasto;
	
	public GastoDTO() {
		// TODO Auto-generated constructor stub
	}
	
	

	public GastoDTO(LocalDate fechaGasto, LocalTime horaGasto, String descipcionGasto, float valorGasto) {
		super();
		this.fechaGasto = fechaGasto;
		this.horaGasto = horaGasto;
		this.descipcionGasto = descipcionGasto;
		this.valorGasto = valorGasto;
	}



	public GastoDTO(int idGasto, LocalDate fechaGasto, LocalTime horaGasto, String descipcionGasto, float valorGasto) {
		super();
		this.idGasto = idGasto;
		this.fechaGasto = fechaGasto;
		this.horaGasto = horaGasto;
		this.descipcionGasto = descipcionGasto;
		this.valorGasto = valorGasto;
	}

	public int getIdGasto() {
		return idGasto;
	}

	public void setIdGasto(int idGasto) {
		this.idGasto = idGasto;
	}

	public LocalDate getFechaGasto() {
		return fechaGasto;
	}

	public void setFechaGasto(LocalDate fechaGasto) {
		this.fechaGasto = fechaGasto;
	}

	public LocalTime getHoraGasto() {
		return horaGasto;
	}

	public void setHoraGasto(LocalTime horaGasto) {
		this.horaGasto = horaGasto;
	}

	public String getDescipcionGasto() {
		return descipcionGasto;
	}

	public void setDescipcionGasto(String descipcionGasto) {
		this.descipcionGasto = descipcionGasto;
	}

	public float getValorGasto() {
		return valorGasto;
	}

	public void setValorGasto(float valorGasto) {
		this.valorGasto = valorGasto;
	}

	@Override
	public String toString() {
		return "GastoDTO [idGasto=" + idGasto + ", fechaGasto=" + fechaGasto + ", horaGasto=" + horaGasto
				+ ", descipcionGasto=" + descipcionGasto + ", valorGasto=" + valorGasto + "]";
	}
	
	
}
