package co.edu.unbosque.ERP_Rosita;

import org.junit.jupiter.api.Test;

import co.edu.unbosque.model.ProveedorDTO;

import static org.junit.jupiter.api.Assertions.*;

public class ProveedorDTOTest {

    @Test
    public void testProveedorDTO() {
        // Crear un objeto ProveedorDTO usando el constructor con parámetros
        ProveedorDTO proveedor = new ProveedorDTO(1, "Proveedor A", "CC", "123456789", "3001234567", "Calle 123");

        // Verificar que los valores asignados con el constructor estén correctos
        assertEquals(1, proveedor.getIdProveedor(), "El id del proveedor debería ser 1.");
        assertEquals("Proveedor A", proveedor.getNombreProveedor(), "El nombre del proveedor debería ser 'Proveedor A'.");
        assertEquals("CC", proveedor.getTipoDocumentoProveedor(), "El tipo de documento debería ser 'CC'.");
        assertEquals("123456789", proveedor.getDocumentoProveedor(), "El documento del proveedor debería ser '123456789'.");
        assertEquals("3001234567", proveedor.getTelefonoProveedor(), "El teléfono del proveedor debería ser '3001234567'.");
        assertEquals("Calle 123", proveedor.getDireccionProveedor(), "La dirección del proveedor debería ser 'Calle 123'.");

        // Verificar el método toString()
        String expectedToString = "ProveedorDTO [idProveedor=1, nombreProveedor=Proveedor A, tipoDocumentoProveedor=CC, documentoProveedor=123456789, telefonoProveedor=3001234567, direccionProveedor=Calle 123]";
        assertEquals(expectedToString, proveedor.toString(), "El toString() debería devolver la representación esperada.");
    }

    @Test
    public void testSettersAndGetters() {
        // Crear un objeto ProveedorDTO
        ProveedorDTO proveedor = new ProveedorDTO();

        // Establecer valores usando los setters
        proveedor.setIdProveedor(2);
        proveedor.setNombreProveedor("Proveedor B");
        proveedor.setTipoDocumentoProveedor("NIT");
        proveedor.setDocumentoProveedor("987654321");
        proveedor.setTelefonoProveedor("3109876543");
        proveedor.setDireccionProveedor("Avenida 456");

        // Verificar que los valores se hayan actualizado correctamente
        assertEquals(2, proveedor.getIdProveedor());
        assertEquals("Proveedor B", proveedor.getNombreProveedor());
        assertEquals("NIT", proveedor.getTipoDocumentoProveedor());
        assertEquals("987654321", proveedor.getDocumentoProveedor());
        assertEquals("3109876543", proveedor.getTelefonoProveedor());
        assertEquals("Avenida 456", proveedor.getDireccionProveedor());
    }
}
