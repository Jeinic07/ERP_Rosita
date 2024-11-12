package co.edu.unbosque.ERP_Rosita;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import co.edu.unbosque.model.CompraDTO;

import java.time.LocalDate;
import java.time.LocalTime;

import static org.junit.jupiter.api.Assertions.*;

public class CompraDTOTest {

    private CompraDTO compra;

    @BeforeEach
    void setUp() {
        // Inicializamos un objeto CompraDTO con algunos valores predeterminados
        compra = new CompraDTO(1, LocalDate.of(2024, 11, 11), LocalTime.of(14, 30), 1200.5f);
    }

    @Test
    void testGetIdCompra() {
        assertEquals(1, compra.getidCompra());
    }

    @Test
    void testSetIdCompra() {
        compra.setIdCompra(2);
        assertEquals(2, compra.getidCompra());
    }

    @Test
    void testGetFechaCompra() {
        assertEquals(LocalDate.of(2024, 11, 11), compra.getfechaCompra());
    }

    @Test
    void testSetFechaCompra() {
        compra.setfechaCompra(LocalDate.of(2024, 12, 1));
        assertEquals(LocalDate.of(2024, 12, 1), compra.getfechaCompra());
    }

    @Test
    void testGetHoraCompra() {
        assertEquals(LocalTime.of(14, 30), compra.gethoraCompra());
    }

    @Test
    void testSetHoraCompra() {
        compra.sethoraCompra(LocalTime.of(16, 45));
        assertEquals(LocalTime.of(16, 45), compra.gethoraCompra());
    }

    @Test
    void testGetTotalCompra() {
        assertEquals(1200.5f, compra.gettotalCompra());
    }

    @Test
    void testSetTotalCompra() {
        compra.settotalCompra(2000.0f);
        assertEquals(2000.0f, compra.gettotalCompra());
    }

    @Test
    void testToString() {
        String expected = "CompraDTO [idfechaCompra=1, fechaCompra=2024-11-11, horaCompra=14:30, totalCompra=1200.5]";
        assertEquals(expected, compra.toString());
    }
}
