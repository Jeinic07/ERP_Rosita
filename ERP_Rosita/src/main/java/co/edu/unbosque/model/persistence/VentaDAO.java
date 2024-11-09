package co.edu.unbosque.model.persistence;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Time;

import co.edu.unbosque.controller.DBConnection;
import co.edu.unbosque.model.VentaDTO;

public class VentaDAO implements OperationsDAO {

	private DBConnection dbcon;
	private ArrayList<VentaDTO> ventas;

	public VentaDAO() {
		dbcon = new DBConnection();
		ventas = new ArrayList<VentaDTO>();

	}

	public DBConnection getDbcon() {
		return dbcon;
	}

	public void setDbcon(DBConnection dbcon) {
		this.dbcon = dbcon;
	}

	public ArrayList<VentaDTO> getVentas() {
		return ventas;
	}

	public void setVentas(ArrayList<VentaDTO> ventas) {
		this.ventas = ventas;
	}

	@Override
	public void create(Object o) {
		ventas.add((VentaDTO) o);
	}

	@Override
	public int create(String... args) {
		VentaDTO newVenta = new VentaDTO(LocalDate.now(), LocalTime.now().truncatedTo(ChronoUnit.SECONDS),
				Float.parseFloat(args[0]));

		dbcon.initConnection();
		try {
			dbcon.setPrepareStatement(dbcon.getConnect()
					.prepareStatement("INSERT INTO Venta(fechaVenta, " + "horaVenta, totalVenta) VALUES(?, ?, ?)"));
			dbcon.getPrepareStatement().setDate(1, Date.valueOf(newVenta.getFechaVenta()));
			dbcon.getPrepareStatement().setTime(2, Time.valueOf(newVenta.getHoraVenta()));
			dbcon.getPrepareStatement().setFloat(3, newVenta.getTotalVenta());

			dbcon.getPrepareStatement().executeUpdate();
			dbcon.closeConnection();

		} catch (SQLException e) {
			e.printStackTrace();
		}
		ventas.add(newVenta);
		return 0;
	}
	public int create2(float total) {
	    int idVenta = -1;  
	    VentaDTO newVenta = new VentaDTO(LocalDate.now(), LocalTime.now().truncatedTo(ChronoUnit.SECONDS), total);

	    dbcon.initConnection();
	    try {

	        dbcon.setPrepareStatement(dbcon.getConnect()
	                .prepareStatement("INSERT INTO Venta(fechaVenta, horaVenta, totalVenta) VALUES(?, ?, ?)",
	                        java.sql.Statement.RETURN_GENERATED_KEYS));
	        
	        dbcon.getPrepareStatement().setDate(1, Date.valueOf(newVenta.getFechaVenta()));
	        dbcon.getPrepareStatement().setTime(2, Time.valueOf(newVenta.getHoraVenta()));
	        dbcon.getPrepareStatement().setFloat(3, newVenta.getTotalVenta());


	        dbcon.getPrepareStatement().executeUpdate();

	        try (ResultSet rs = dbcon.getPrepareStatement().getGeneratedKeys()) {
	            if (rs.next()) {
	                idVenta = rs.getInt(1);  
	            }
	        }

	        dbcon.closeConnection();

	    } catch (SQLException e) {
	        e.printStackTrace();
	    }
	    
	    ventas.add(newVenta);
	    return idVenta;  // Devolver el ID de la venta generada
	}


	@Override
	public String readAll() {
		ventas.clear();

		try {
			dbcon.setStatement(dbcon.getConnect().createStatement());
			dbcon.setResultSet(dbcon.getStatement().executeQuery("SELECT * FROM Venta;"));

			while (dbcon.getResultSet().next()) {
				int id = dbcon.getResultSet().getInt("idVenta");
				LocalDate fecha = dbcon.getResultSet().getDate("fechaVenta").toLocalDate();
				LocalTime hora = dbcon.getResultSet().getTime("horaVenta").toLocalTime();
				float total = dbcon.getResultSet().getFloat("totalVenta");

				ventas.add(new VentaDTO(id, fecha, hora, total));
			}
			dbcon.closeConnection();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public String readByName(String name) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int updateById(int id, String... args) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int deleteById(int id) {
		// TODO Auto-generated method stub
		return 0;
	}

}
