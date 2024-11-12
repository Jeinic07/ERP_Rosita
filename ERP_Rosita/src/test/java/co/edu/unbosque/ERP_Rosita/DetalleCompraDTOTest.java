package co.edu.unbosque.ERP_Rosita;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import co.edu.unbosque.model.DetalleCompraDTO;

import static org.junit.jupiter.api.Assertions.*;

public class DetalleCompraDTOTest {

    private DetalleCompraDTO detalleCompra;

    @BeforeEach
    void setUp() {
        // Inicializamos un objeto DetalleCompraDTO con algunos valores predeterminados
        detalleCompra = new DetalleCompraDTO(1, 10, 150.0f, 1500.0f, 101, 1001, "Producto A");
    }

    @Test
    void testGetIdDC() {
        assertEquals(1, detalleCompra.getIdDC());
    }

    @Test
    void testSetIdDC() {
        detalleCompra.setIdDC(2);
        assertEquals(2, detalleCompra.getIdDC());
    }

    @Test
    void testGetCantidadDC() {
        assertEquals(10, detalleCompra.getCantidadDC());
    }

    @Test
    void testSetCantidadDC() {
        detalleCompra.setCantidadDC(20);
        assertEquals(20, detalleCompra.getCantidadDC());
    }

    @Test
    void testGetCostoUnitarioDC() {
        assertEquals(150.0f, detalleCompra.getcostoUnitarioDC());
    }

    @Test
    void testSetCostoUnitarioDC() {
        detalleCompra.setcostoUnitarioDC(200.0f);
        assertEquals(200.0f, detalleCompra.getcostoUnitarioDC());
    }

    @Test
    void testGetSubtotalDC() {
        assertEquals(1500.0f, detalleCompra.getSubtotalDC());
    }

    @Test
    void testSetSubtotalDC() {
        detalleCompra.setSubtotalDC(3000.0f);
        assertEquals(3000.0f, detalleCompra.getSubtotalDC());
    }

    @Test
    void testGetIdProductoDC() {
        assertEquals(101, detalleCompra.getIdProductoDC());
    }

    @Test
    void testSetIdProductoDC() {
        detalleCompra.setIdProductoDC(102);
        assertEquals(102, detalleCompra.getIdProductoDC());
    }

    @Test
    void testGetIdCompraDC() {
        assertEquals(1001, detalleCompra.getIdCompraDC());
    }

    @Test
    void testSetIdCompraDC() {
        detalleCompra.setIdCompraDC(1002);
        assertEquals(1002, detalleCompra.getIdCompraDC());
    }

    @Test
    void testGetNombreProducto() {
        assertEquals("Producto A", detalleCompra.getNombreProducto());
    }

    @Test
    void testSetNombreProducto() {
        detalleCompra.setNombreProducto("Producto B");
        assertEquals("Producto B", detalleCompra.getNombreProducto());
    }

    @Test
    void testToString() {
        String expected = "DetalleCompraDTO [idDC=1, cantidadDC=10, costoUnitarioDC=150.0, subtotalDC=1500.0, idProductoDC=101, idCompraDC=1001, nombreProducto=Producto A]";
        assertEquals(expected, detalleCompra.toString());
    }
}
