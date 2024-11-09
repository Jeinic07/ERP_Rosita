package co.edu.unbosque.model;

import java.time.LocalDate;
import java.time.LocalTime;

public class VentaDTO {

	private int idFechaVenta;
	private LocalDate fechaVenta;
	private LocalTime horaVenta;
	private float totalVenta;

	public VentaDTO() {
		// TODO Auto-generated constructor stub
	}

	public VentaDTO(LocalDate fechaVenta, LocalTime horaVenta, float totalVenta) {
		super();
		this.fechaVenta = fechaVenta;
		this.horaVenta = horaVenta;
		this.totalVenta = totalVenta;
	}

	public VentaDTO(int idFechaVenta, LocalDate fechaVenta, LocalTime horaVenta, float totalVenta) {
		super();
		this.idFechaVenta = idFechaVenta;
		this.fechaVenta = fechaVenta;
		this.horaVenta = horaVenta;
		this.totalVenta = totalVenta;
	}

	public int getIdFechaVenta() {
		return idFechaVenta;
	}

	public void setIdFechaVenta(int idFechaVenta) {
		this.idFechaVenta = idFechaVenta;
	}

	public LocalDate getFechaVenta() {
		return fechaVenta;
	}

	public void setFechaVenta(LocalDate fechaVenta) {
		this.fechaVenta = fechaVenta;
	}

	public LocalTime getHoraVenta() {
		return horaVenta;
	}

	public void setHoraVenta(LocalTime horaVenta) {
		this.horaVenta = horaVenta;
	}

	public float getTotalVenta() {
		return totalVenta;
	}

	public void setTotalVenta(float totalVenta) {
		this.totalVenta = totalVenta;
	}

	@Override
	public String toString() {
		return "VentaDTO [idFechaVenta=" + idFechaVenta + ", fechaVenta=" + fechaVenta + ", horaVenta=" + horaVenta
				+ ", totalVenta=" + totalVenta + "]";
	}
	
}