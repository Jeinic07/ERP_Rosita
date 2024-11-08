package co.edu.unbosque.controller;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.temporal.ChronoUnit;

import co.edu.unbosque.model.persistence.VentaDAO;

public class AplMain {

	public static void main(String[] args) {
		Controller c = new Controller();
	}

//	public static void main(String[] args) {
//		
//		VentaDAO vdao = new VentaDAO();
//        LocalTime horaActual = LocalTime.now().truncatedTo(ChronoUnit.SECONDS);
//        System.out.println("Hora actual sin milisegundos: " + horaActual.toString());
//        
//        LocalDate fechaActual = LocalDate.now();
//        System.out.println("Fecha actual: " + fechaActual.toString());
//        
//    }
}
