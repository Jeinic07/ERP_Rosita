package co.edu.unbosque.ERP_Rosita;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import co.edu.unbosque.model.GastoDTO;

import java.time.LocalDate;
import java.time.LocalTime;

import static org.junit.jupiter.api.Assertions.*;

public class GastoDTOTest {

    private GastoDTO gasto;

    @BeforeEach
    void setUp() {
        // Inicializamos un objeto GastoDTO con algunos valores predeterminados
        gasto = new GastoDTO(1, LocalDate.of(2024, 11, 11), LocalTime.of(14, 30), "Compra de materiales", 1500.0f);
    }

    @Test
    void testGetIdGasto() {
        assertEquals(1, gasto.getIdGasto());
    }

    @Test
    void testSetIdGasto() {
        gasto.setIdGasto(2);
        assertEquals(2, gasto.getIdGasto());
    }

    @Test
    void testGetFechaGasto() {
        assertEquals(LocalDate.of(2024, 11, 11), gasto.getFechaGasto());
    }

    @Test
    void testSetFechaGasto() {
        gasto.setFechaGasto(LocalDate.of(2024, 12, 1));
        assertEquals(LocalDate.of(2024, 12, 1), gasto.getFechaGasto());
    }

    @Test
    void testGetHoraGasto() {
        assertEquals(LocalTime.of(14, 30), gasto.getHoraGasto());
    }

    @Test
    void testSetHoraGasto() {
        gasto.setHoraGasto(LocalTime.of(16, 45));
        assertEquals(LocalTime.of(16, 45), gasto.getHoraGasto());
    }

    @Test
    void testGetDescipcionGasto() {
        assertEquals("Compra de materiales", gasto.getDescipcionGasto());
    }

    @Test
    void testSetDescipcionGasto() {
        gasto.setDescipcionGasto("Pago de servicios");
        assertEquals("Pago de servicios", gasto.getDescipcionGasto());
    }

    @Test
    void testGetValorGasto() {
        assertEquals(1500.0f, gasto.getValorGasto());
    }

    @Test
    void testSetValorGasto() {
        gasto.setValorGasto(2000.0f);
        assertEquals(2000.0f, gasto.getValorGasto());
    }

    @Test
    void testToString() {
        String expected = "GastoDTO [idGasto=1, fechaGasto=2024-11-11, horaGasto=14:30, descipcionGasto=Compra de materiales, valorGasto=1500.0]";
        assertEquals(expected, gasto.toString());
    }
}
