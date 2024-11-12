package co.edu.unbosque.ERP_Rosita;

import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import co.edu.unbosque.controller.DBConnection;
import co.edu.unbosque.model.persistence.DetalleCompraDAO;

public class DetalleCompraDAOTest {

    private DetalleCompraDAO detalleCompraDAO;
    private DBConnection mockDbConnection;
    private Connection mockConnection;
    private Statement mockStatement;
    private PreparedStatement mockPreparedStatement;

    @BeforeEach
    public void setUp() throws SQLException {
        mockDbConnection = mock(DBConnection.class);
        mockConnection = mock(Connection.class);
        mockStatement = mock(Statement.class);
        mockPreparedStatement = mock(PreparedStatement.class);

        // Mock para que getConnect devuelva un Connection simulado
        when(mockDbConnection.getConnect()).thenReturn(mockConnection);

        // Mock para que getStatement devuelva un Statement simulado
        when(mockConnection.createStatement()).thenReturn(mockStatement);
        when(mockDbConnection.getStatement()).thenReturn(mockStatement);

        // Mock para que getPrepareStatement devuelva un PreparedStatement simulado
        when(mockDbConnection.getPrepareStatement()).thenReturn(mockPreparedStatement);

        detalleCompraDAO = new DetalleCompraDAO();
        detalleCompraDAO.setDbcon(mockDbConnection);
    }

    @Test
    public void testUpdateById() {
        String[] args = {"15", "25.0", "375.0", "2", "100"};
        int result = detalleCompraDAO.updateById(1, args);
        assertEquals(0, result);
    }

    @Test
    public void testDeleteById() {
        int result = detalleCompraDAO.deleteById(1);
        assertEquals(0, result);
    }
}
