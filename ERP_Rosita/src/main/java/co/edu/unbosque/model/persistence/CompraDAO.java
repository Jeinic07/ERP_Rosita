package co.edu.unbosque.model.persistence;

import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Time;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;

import co.edu.unbosque.controller.DBConnection;
import co.edu.unbosque.model.CompraDTO;

public class CompraDAO {

	private DBConnection dbcon;
	private ArrayList<CompraDTO> compras;
	
	public CompraDAO() {
		dbcon = new DBConnection();
		compras = new ArrayList<CompraDTO>();

	}

	public DBConnection getDbcon() {
		return dbcon;
	}

	public void setDbcon(DBConnection dbcon) {
		this.dbcon = dbcon;
	}

	public ArrayList<CompraDTO> getCompras() {
		return compras;
	}

	public void setCompras(ArrayList<CompraDTO> compras) {
		this.compras = compras;
	}
	
	public void create(Object o) {
		compras.add((CompraDTO) o);
	}

	public int create(String... args) {
		CompraDTO newCompra = new CompraDTO(LocalDate.now(), LocalTime.now().truncatedTo(ChronoUnit.SECONDS),
				Float.parseFloat(args[0]));

		dbcon.initConnection();
		try {
			dbcon.setPrepareStatement(dbcon.getConnect()
					.prepareStatement("INSERT INTO Venta(fechaCompra, " + "horaCompra, totalCompra) VALUES(?, ?, ?)"));
			dbcon.getPrepareStatement().setDate(1, Date.valueOf(newCompra.getfechaCompra()));
			dbcon.getPrepareStatement().setTime(2, Time.valueOf(newCompra.gethoraCompra()));
			dbcon.getPrepareStatement().setFloat(3, newCompra.gettotalCompra());

			dbcon.getPrepareStatement().executeUpdate();
			dbcon.closeConnection();

		} catch (SQLException e) {
			e.printStackTrace();
		}
		compras.add(newCompra);
		return 0;
	}
	public int create2(float total) {
	    int idCompra = -1;  
	    CompraDTO newCompra = new CompraDTO(LocalDate.now(), LocalTime.now().truncatedTo(ChronoUnit.SECONDS), total);

	    dbcon.initConnection();
	    try {

	        dbcon.setPrepareStatement(dbcon.getConnect()
	                .prepareStatement("INSERT INTO Compra(fechaCompra,totalCompra, horaCompra) VALUES(?, ?, ?)",
	                        java.sql.Statement.RETURN_GENERATED_KEYS));
	        
	        dbcon.getPrepareStatement().setDate(1, Date.valueOf(newCompra.getfechaCompra()));
	        dbcon.getPrepareStatement().setFloat(2, newCompra.gettotalCompra());
	        dbcon.getPrepareStatement().setTime(3, Time.valueOf(newCompra.gethoraCompra()));
	        


	        dbcon.getPrepareStatement().executeUpdate();

	        try (ResultSet rs = dbcon.getPrepareStatement().getGeneratedKeys()) {
	            if (rs.next()) {
	                idCompra = rs.getInt(1);  
	            }
	        }

	        dbcon.closeConnection();

	    } catch (SQLException e) {
	        e.printStackTrace();
	    }
	    
	    compras.add(newCompra);
	    return idCompra;  // Devolver el ID de la venta generada
	}
	public String readAll() {
		compras.clear();

		try {
			dbcon.setStatement(dbcon.getConnect().createStatement());
			dbcon.setResultSet(dbcon.getStatement().executeQuery("SELECT * FROM Compra;"));

			while (dbcon.getResultSet().next()) {
				int id = dbcon.getResultSet().getInt("idCompra");
				LocalDate fecha = dbcon.getResultSet().getDate("fechaCompra").toLocalDate();
				LocalTime hora = dbcon.getResultSet().getTime("horaCompra").toLocalTime();
				float total = dbcon.getResultSet().getFloat("totalCompra");

				compras.add(new CompraDTO(id, fecha, hora, total));
			}
			dbcon.closeConnection();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public String readByName(String name) {
		// TODO Auto-generated method stub
		return null;
	}

	public int updateById(int id, String... args) {
		// TODO Auto-generated method stub
		return 0;
	}

	public int deleteById(int id) {
		// TODO Auto-generated method stub
		return 0;
	}

}




