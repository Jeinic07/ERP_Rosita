package co.edu.unbosque.ERP_Rosita;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import co.edu.unbosque.model.ProductoDTO;

import static org.junit.jupiter.api.Assertions.*;

public class ProductoDTOTest {

    private ProductoDTO producto;

    @BeforeEach
    void setUp() {
        // Usando el constructor con todos los parámetros necesarios.
        producto = new ProductoDTO(1, "Laptop", "HP", 100, 1200.5f, 1500.0f, 101);
    }

    @Test
    void testGetIdProducto() {
        assertEquals(1, producto.getIdProducto());
    }

    @Test
    void testSetIdProducto() {
        producto.setIdProducto(2);
        assertEquals(2, producto.getIdProducto());
    }

    @Test
    void testGetNombreProducto() {
        assertEquals("Laptop", producto.getNombreProducto());
    }

    @Test
    void testSetNombreProducto() {
        producto.setNombreProducto("Tablet");
        assertEquals("Tablet", producto.getNombreProducto());
    }

    @Test
    void testGetMarcaProducto() {
        assertEquals("HP", producto.getMarcaProducto());
    }

    @Test
    void testSetMarcaProducto() {
        producto.setMarcaProducto("Dell");
        assertEquals("Dell", producto.getMarcaProducto());
    }

    @Test
    void testGetStockProducto() {
        assertEquals(100, producto.getStockProducto());
    }

    @Test
    void testSetStockProducto() {
        producto.setStockProducto(200);
        assertEquals(200, producto.getStockProducto());
    }

    @Test
    void testGetCostoProducto() {
        assertEquals(1200.5f, producto.getCostoProducto());
    }

    @Test
    void testSetCostoProducto() {
        producto.setCostoProducto(1300.0f);
        assertEquals(1300.0f, producto.getCostoProducto());
    }

    @Test
    void testGetPrecioProducto() {
        assertEquals(1500.0f, producto.getPrecioProducto());
    }

    @Test
    void testSetPrecioProducto() {
        producto.setPrecioProducto(1600.0f);
        assertEquals(1600.0f, producto.getPrecioProducto());
    }

    @Test
    void testGetIdProveedor() {
        assertEquals(101, producto.getIdProveedor());
    }

    @Test
    void testSetIdProveedor() {
        producto.setIdProveedor(102);
        assertEquals(102, producto.getIdProveedor());
    }

    @Test
    void testGetNombreProveedor() {
        // Usando el constructor con nombreProveedor
        ProductoDTO producto2 = new ProductoDTO("Laptop", "HP", 100, 1200.5f, 1500.0f, "Proveedor1");
        assertEquals("Proveedor1", producto2.getNombreProveedor());
    }

    @Test
    void testSetNombreProveedor() {
        producto.setNombreProveedor("Proveedor2");
        assertEquals("Proveedor2", producto.getNombreProveedor());
    }

    @Test
    void testToString() {
        String expected = "ProductoDTO [idProducto=1, nombreProducto=Laptop, marcaProducto=HP, stockProducto=100, costoProducto=1200.5, precioProducto=1500.0, idProveedor=101, nombreProveedor=null]";
        assertEquals(expected, producto.toString());
    }
}
