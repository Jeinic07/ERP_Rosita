package co.edu.unbosque.model.persistence;

import java.sql.Date;
import java.sql.SQLException;
import java.sql.Time;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;

import co.edu.unbosque.controller.DBConnection;
import co.edu.unbosque.model.GastoDTO;

public class GastoDAO implements OperationsDAO {

	DBConnection dbcon;
	private ArrayList<GastoDTO> gastos;

	public GastoDAO() {
		dbcon = new DBConnection();
		gastos = new ArrayList<GastoDTO>();
	}

	public DBConnection getDbcon() {
		return dbcon;
	}

	public void setDbcon(DBConnection dbcon) {
		this.dbcon = dbcon;
	}

	public ArrayList<GastoDTO> getGastos() {
		return gastos;
	}

	public void setGastos(ArrayList<GastoDTO> gastos) {
		this.gastos = gastos;
	}

	@Override
	public void create(Object o) {
		gastos.add((GastoDTO) o);
	}

	@Override
	public int create(String... args) {
		GastoDTO newGasto =new GastoDTO(LocalDate.now(), LocalTime.now().truncatedTo(ChronoUnit.SECONDS),
				args[0], Float.parseFloat(args[1]));
		
		dbcon.initConnection();
		try {
			dbcon.setPrepareStatement(dbcon.getConnect()
					.prepareStatement("INSERT INTO Gasto(fechaGasto ,horaGasto, descripcionGasto,"
							+ "valorGasto) VALUES(?, ?, ?, ?)"));
			dbcon.getPrepareStatement().setDate(1, Date.valueOf(newGasto.getFechaGasto()));
			dbcon.getPrepareStatement().setTime(2, Time.valueOf(newGasto.getHoraGasto()));
			dbcon.getPrepareStatement().setString(3, newGasto.getDescipcionGasto());
			dbcon.getPrepareStatement().setFloat(4, newGasto.getValorGasto());

			dbcon.getPrepareStatement().executeUpdate();
			dbcon.closeConnection();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		gastos.add(newGasto);
		return 0;
	}

	@Override
	public String readAll() {
		gastos.clear();
		
		dbcon.initConnection();
		try {
			dbcon.setStatement(dbcon.getConnect().createStatement());
			dbcon.setResultSet(dbcon.getStatement().executeQuery("SELECT * FROM Gasto"));
			
			while(dbcon.getResultSet().next()) {
				int id = dbcon.getResultSet().getInt("idGasto");
				LocalDate fecha = dbcon.getResultSet().getDate("fechaGasto").toLocalDate();
				LocalTime hora = dbcon.getResultSet().getTime("horaGasto").toLocalTime();
				String descripcion = dbcon.getResultSet().getString("descripcionGasto");
				float valor = dbcon.getResultSet().getFloat("valorGasto");
				
				gastos.add(new GastoDTO(id, fecha, hora, descripcion, valor));
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
