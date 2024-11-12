package co.edu.unbosque.ERP_Rosita;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import co.edu.unbosque.model.ProveedorDTO;
import co.edu.unbosque.model.persistence.ProveedorDAO;

import static org.junit.jupiter.api.Assertions.*;

public class ProveedorDAOTest {

    private ProveedorDAO proveedorDAO;

    @BeforeEach
    public void setUp() {
        proveedorDAO = new ProveedorDAO();
        // Limpiar la base de datos antes de cada prueba
        limpiarBaseDeDatos();
    }

    private void limpiarBaseDeDatos() {
        // Limpiar la base de datos, asegurándonos de que no haya proveedores previos
        proveedorDAO.readAll(); // Esto asegura que la lista de proveedores esté vacía al principio
    }


    @Test
    public void testUpdateById() {
        // Crear proveedor de prueba
        proveedorDAO.create("Proveedor C", "CC", "123123123", "3200000000", "Calle 789");

        // Leer todos los proveedores y obtener el ID
        proveedorDAO.readAll();
        ProveedorDTO proveedor = proveedorDAO.getProveedores().get(0);
        int id = proveedor.getIdProveedor(); // Obtener el ID del proveedor creado

        // Actualizar proveedor
        String nuevoNombre = "Proveedor C Actualizado";
        String tipoDocumento = "CC";
        String documento = "123123123";
        String telefono = "3200000001";
        String direccion = "Calle 789 Actualizada";

        int result = proveedorDAO.updateById(id, nuevoNombre, tipoDocumento, documento, telefono, direccion);

        // Verificar que la actualización fue exitosa
        assertEquals(0, result, "El proveedor debe ser actualizado correctamente");

        // Verificar que el proveedor ha sido actualizado
        proveedorDAO.readAll(); // Volver a cargar los proveedores desde la base de datos
        ProveedorDTO proveedorActualizado = proveedorDAO.getProveedores().get(0);

        assertEquals(nuevoNombre, proveedorActualizado.getNombreProveedor(), "El nombre del proveedor debe ser actualizado");
        assertEquals(telefono, proveedorActualizado.getTelefonoProveedor(), "El teléfono del proveedor debe ser actualizado");
        assertEquals(direccion, proveedorActualizado.getDireccionProveedor(), "La dirección del proveedor debe ser actualizada");
    }

   
}
