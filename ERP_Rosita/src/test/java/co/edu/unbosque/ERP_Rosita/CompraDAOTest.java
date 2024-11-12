package co.edu.unbosque.ERP_Rosita;

import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import co.edu.unbosque.controller.DBConnection;
import co.edu.unbosque.model.persistence.CompraDAO;

public class CompraDAOTest {

    private CompraDAO compraDAO;
    private DBConnection mockDbConnection;
    private Connection mockConnection;
    private PreparedStatement mockPreparedStatement;

    @BeforeEach
    public void setUp() throws SQLException {
        mockDbConnection = mock(DBConnection.class);
        mockConnection = mock(Connection.class);
        mockPreparedStatement = mock(PreparedStatement.class);

        when(mockDbConnection.getConnect()).thenReturn(mockConnection);
        when(mockConnection.prepareStatement(any(String.class))).thenReturn(mockPreparedStatement);

        compraDAO = new CompraDAO();
        compraDAO.setDbcon(mockDbConnection);
    }
    @Test
    public void testGetTotalByCompraId() throws SQLException {
        ResultSet mockResultSet = mock(ResultSet.class);
        when(mockResultSet.next()).thenReturn(true);
        when(mockResultSet.getFloat("totalSubtotal")).thenReturn(100.50f);

        PreparedStatement mockPreparedStatement = mock(PreparedStatement.class);
        when(mockPreparedStatement.executeQuery()).thenReturn(mockResultSet);

        DBConnection mockDbConnection = mock(DBConnection.class);
        when(mockDbConnection.getPrepareStatement()).thenReturn(mockPreparedStatement);
        when(mockDbConnection.getConnect()).thenReturn(mock(Connection.class));

        CompraDAO compraDAO = new CompraDAO();
        compraDAO.setDbcon(mockDbConnection);

        float total = compraDAO.getTotalByCompraId(1);

        assertEquals(100.50f, total, "El total de la compra debería ser 100.50");

        verify(mockPreparedStatement).setInt(1, 1);
        verify(mockPreparedStatement).executeQuery();

        verify(mockDbConnection).closeConnection(); 
    }


}
