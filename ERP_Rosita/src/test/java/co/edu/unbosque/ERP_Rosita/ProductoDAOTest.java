package co.edu.unbosque.ERP_Rosita;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import co.edu.unbosque.model.ProductoDTO;
import co.edu.unbosque.model.persistence.ProductoDAO;

public class ProductoDAOTest {

    private ProductoDAO productoDAO;

    @BeforeEach
    public void setUp() {
        productoDAO = new ProductoDAO();
    }

    @Test
    public void testCreateProducto() {
        // Crear un ProductoDTO de prueba
        ProductoDTO producto = new ProductoDTO("Producto A", "Marca A", 100, 10.5f, 15.5f, 1);
        
        // Verificar que el ProductoDTO se agrega a la lista
        productoDAO.create(producto);
        assertTrue(productoDAO.getProductos().contains(producto), "El producto debería estar en la lista");
    }


}
