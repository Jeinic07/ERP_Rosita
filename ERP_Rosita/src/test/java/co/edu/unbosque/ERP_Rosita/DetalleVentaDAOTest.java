package co.edu.unbosque.ERP_Rosita;

import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import co.edu.unbosque.controller.DBConnection;
import co.edu.unbosque.model.DetalleVentaDTO;
import co.edu.unbosque.model.persistence.DetalleVentaDAO;

public class DetalleVentaDAOTest {

    private DetalleVentaDAO detalleVentaDAO;
    private DBConnection mockDbConnection;
    private Connection mockConnection;
    private Statement mockStatement;
    private PreparedStatement mockPreparedStatement;
    private ResultSet mockResultSet;

    @BeforeEach
    public void setUp() throws SQLException {
        mockDbConnection = mock(DBConnection.class);
        mockConnection = mock(Connection.class);
        mockStatement = mock(Statement.class);
        mockPreparedStatement = mock(PreparedStatement.class);
        mockResultSet = mock(ResultSet.class);

        // Mocks para la conexión a la base de datos
        when(mockDbConnection.getConnect()).thenReturn(mockConnection);
        when(mockConnection.createStatement()).thenReturn(mockStatement);
        when(mockDbConnection.getStatement()).thenReturn(mockStatement);
        when(mockDbConnection.getPrepareStatement()).thenReturn(mockPreparedStatement);
        when(mockDbConnection.getResultSet()).thenReturn(mockResultSet);

        detalleVentaDAO = new DetalleVentaDAO();
        detalleVentaDAO.setDbcon(mockDbConnection);
    }

    @Test
    public void testCreate() throws SQLException {
        String[] args = {"10", "20.5", "205.0", "1", "100"};
        int result = detalleVentaDAO.create(args);
        assertEquals(0, result);
    }

    @Test
    public void testReadById() throws SQLException {
        int idVenta = 1;
        
        // Configuración del mock para ResultSet
        when(mockResultSet.next()).thenReturn(true);
        when(mockResultSet.getString("p.nombreProducto")).thenReturn("Producto A");
        when(mockResultSet.getInt("dv.cantidadDV")).thenReturn(10);
        when(mockResultSet.getFloat("dv.precioUnitarioDV")).thenReturn(20.5f);
        when(mockResultSet.getFloat("dv.subtotalDV")).thenReturn(205.0f);
        when(mockResultSet.getInt("dv.idProductoDV")).thenReturn(1);

        // Llamamos a readById
        detalleVentaDAO.readById(idVenta);

        // Verificamos el tamaño del ArrayList y el contenido
        assertFalse(detalleVentaDAO.getDvs().isEmpty());
        assertEquals("Producto A", detalleVentaDAO.getDvs().get(0).getNombreProducto());
    }

    @Test
    public void testUpdateById() {
        String[] args = {"15", "25.0", "375.0", "2", "100"};
        int result = detalleVentaDAO.updateById(1, args);
        assertEquals(0, result);
    }

    @Test
    public void testDeleteById() {
        int result = detalleVentaDAO.deleteById(1);
        assertEquals(0, result);
    }
}
