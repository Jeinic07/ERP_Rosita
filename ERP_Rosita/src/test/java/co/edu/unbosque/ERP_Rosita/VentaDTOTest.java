package co.edu.unbosque.ERP_Rosita;

import org.junit.jupiter.api.Test;

import co.edu.unbosque.model.VentaDTO;

import java.time.LocalDate;
import java.time.LocalTime;
import static org.junit.jupiter.api.Assertions.*;

public class VentaDTOTest {

    @Test
    public void testVentaDTO() {
        // Crear un objeto VentaDTO usando el constructor con parámetros
        LocalDate fechaVenta = LocalDate.of(2024, 11, 11);
        LocalTime horaVenta = LocalTime.of(14, 30);
        float totalVenta = 250.75f;

        VentaDTO venta = new VentaDTO(fechaVenta, horaVenta, totalVenta);

        // Verificar que los valores asignados con el constructor estén correctos
        assertEquals(fechaVenta, venta.getFechaVenta(), "La fecha de la venta debería ser " + fechaVenta);
        assertEquals(horaVenta, venta.getHoraVenta(), "La hora de la venta debería ser " + horaVenta);
        assertEquals(totalVenta, venta.getTotalVenta(), "El total de la venta debería ser " + totalVenta);

        // Verificar el método toString()
        String expectedToString = "VentaDTO [idFechaVenta=0, fechaVenta=" + fechaVenta + ", horaVenta=" + horaVenta
                + ", totalVenta=" + totalVenta + "]";
        assertEquals(expectedToString, venta.toString(), "El toString() debería devolver la representación esperada.");
    }

    @Test
    public void testSettersAndGetters() {
        // Crear un objeto VentaDTO
        VentaDTO venta = new VentaDTO();

        // Establecer valores usando los setters
        LocalDate nuevaFecha = LocalDate.of(2024, 11, 12);
        LocalTime nuevaHora = LocalTime.of(16, 45);
        float nuevoTotal = 320.50f;

        venta.setFechaVenta(nuevaFecha);
        venta.setHoraVenta(nuevaHora);
        venta.setTotalVenta(nuevoTotal);

        // Verificar que los valores se hayan actualizado correctamente
        assertEquals(nuevaFecha, venta.getFechaVenta(), "La fecha de la venta debería ser " + nuevaFecha);
        assertEquals(nuevaHora, venta.getHoraVenta(), "La hora de la venta debería ser " + nuevaHora);
        assertEquals(nuevoTotal, venta.getTotalVenta(), "El total de la venta debería ser " + nuevoTotal);
    }

    @Test
    public void testIdVenta() {
        // Crear un objeto VentaDTO con idVenta
        VentaDTO venta = new VentaDTO(1, LocalDate.of(2024, 11, 11), LocalTime.of(14, 30), 250.75f);

        // Verificar que el idVenta sea correcto
        assertEquals(1, venta.getIdVenta(), "El id de la venta debería ser 1.");
    }
}
