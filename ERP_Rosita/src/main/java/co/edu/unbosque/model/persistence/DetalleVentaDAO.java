package co.edu.unbosque.model.persistence;

import java.sql.SQLException;
import java.util.ArrayList;

import co.edu.unbosque.controller.DBConnection;
import co.edu.unbosque.model.DetalleVentaDTO;

public class DetalleVentaDAO implements OperationsDAO {

	DBConnection dbcon;
	private ArrayList<DetalleVentaDTO> dvs;

	public DetalleVentaDAO() {
		dbcon = new DBConnection();
		dvs = new ArrayList<DetalleVentaDTO>();
	}

	public DBConnection getDbcon() {
		return dbcon;
	}

	public void setDbcon(DBConnection dbcon) {
		this.dbcon = dbcon;
	}

	public ArrayList<DetalleVentaDTO> getDvs() {
		return dvs;
	}

	public void setDvs(ArrayList<DetalleVentaDTO> dvs) {
		this.dvs = dvs;
	}

	@Override
	public void create(Object o) {
		// TODO Auto-generated method stub

	}

	@Override
	public int create(String... args) {
		DetalleVentaDTO newDv = new DetalleVentaDTO(Integer.parseInt(args[0]), Float.parseFloat(args[1]),
				Float.parseFloat(args[2]), Integer.parseInt(args[3]), Integer.parseInt(args[4]));

		dbcon.initConnection();
		try {
			dbcon.setPrepareStatement(dbcon.getConnect().prepareStatement("INSERT INTO DetalleVenta "
					+ "(cantidadDV, precioUnitarioDV, subtotalDV, idProductoDV, idVentaDV)" + "VALUES (?,?,?,?,?)"));

			dbcon.getPrepareStatement().setInt(1, newDv.getCantidadDV());
			dbcon.getPrepareStatement().setFloat(2, newDv.getPrecioUnitarioDV());
			dbcon.getPrepareStatement().setFloat(3, newDv.getSubtotalDV());
			dbcon.getPrepareStatement().setInt(4, newDv.getIdProductoDV());
			dbcon.getPrepareStatement().setInt(5, newDv.getIdVentaDV());

			dbcon.getPrepareStatement().executeUpdate();
			dbcon.closeConnection();

		} catch (SQLException e) {
			e.printStackTrace();
		}
		dvs.add(newDv);
		return 0;
	}

	@Override
	public String readAll() {

		return null;
	}
	
	public void readById(int id) {
		dvs.clear();
		dbcon.initConnection();
		
		try {
			dbcon.setStatement(dbcon.getConnect().createStatement());
			dbcon.setResultSet(dbcon.getStatement().executeQuery(
					"SELECT p.nombreProducto, dv.cantidadDV, "
					+ "dv.precioUnitarioDV, "
					+ "dv.subTotalDV "
					+ "FROM DetalleVenta dv "
					+ "JOIN Producto p ON dv.idProductoDV = p.idProducto "
					+ "WHERE dv.idVentaDV = " + id));

			while(dbcon.getResultSet().next()) {
				
				String producto = dbcon.getResultSet().getString("p.nombreProducto");
				int cantidad = dbcon.getResultSet().getInt("dv.cantidadDV");
				float precio = dbcon.getResultSet().getFloat("dv.precioUnitarioDV");
				float subtotal = dbcon.getResultSet().getFloat("dv.subtotalDV");
				
				dvs.add(new DetalleVentaDTO(producto, cantidad, precio, subtotal));
			}
			dbcon.closeConnection();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	@Override
	public String readByName(String name) {
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
