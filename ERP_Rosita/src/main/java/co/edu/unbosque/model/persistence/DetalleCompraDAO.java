package co.edu.unbosque.model.persistence;

import java.sql.SQLException;
import java.util.ArrayList;

import co.edu.unbosque.controller.DBConnection;
import co.edu.unbosque.model.DetalleCompraDTO;
import co.edu.unbosque.model.DetalleVentaDTO;

public class DetalleCompraDAO implements OperationsDAO{

	DBConnection dbcon;
	private ArrayList<DetalleCompraDTO> dcs;
	
	public DetalleCompraDAO() {
		dbcon = new DBConnection();
		dcs = new ArrayList<DetalleCompraDTO>();
	}
	
	
	public DBConnection getDbcon() {
		return dbcon;
	}


	public void setDbcon(DBConnection dbcon) {
		this.dbcon = dbcon;
	}


	public ArrayList<DetalleCompraDTO> getDcs() {
		return dcs;
	}


	public void setDcs(ArrayList<DetalleCompraDTO> dcs) {
		this.dcs = dcs;
	}


	@Override
	public void create(Object o) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public int create(String... args) {
		DetalleCompraDTO newDc = new DetalleCompraDTO(Integer.parseInt(args[0]), Float.parseFloat(args[1]),
				Float.parseFloat(args[2]), Integer.parseInt(args[3]), Integer.parseInt(args[4]));

		dbcon.initConnection();
		try {
			dbcon.setPrepareStatement(dbcon.getConnect().prepareStatement("INSERT INTO DetalleCompra "
					+ "(cantidadDC, costoUnitarioDC, subtotalDC, idProductoDC ,idCompraDC)" + "VALUES (?,?,?,?,?)"));

			dbcon.getPrepareStatement().setInt(1, newDc.getCantidadDC());
			dbcon.getPrepareStatement().setFloat(2, newDc.getcostoUnitarioDC());
			dbcon.getPrepareStatement().setFloat(3, newDc.getSubtotalDC());
			dbcon.getPrepareStatement().setInt(4, newDc.getIdProductoDC());
			dbcon.getPrepareStatement().setInt(5, newDc.getIdCompraDC());
			
			

			dbcon.getPrepareStatement().executeUpdate();
			dbcon.closeConnection();

		} catch (SQLException e) {
			e.printStackTrace();
		}
		dcs.add(newDc);
		System.out.println(newDc.toString());
		return 0;
	}

	@Override
	public String readAll() {
		// TODO Auto-generated method stub
		return null;
	}
	
	public void readById(int id) {
		dcs.clear();
		dbcon.initConnection();
		
		try {
			dbcon.setStatement(dbcon.getConnect().createStatement());
			dbcon.setResultSet(dbcon.getStatement().executeQuery(
					"SELECT p.nombreProducto, dc.cantidadDC, "
					+ "dc.costoUnitarioDC, "
					+ "dc.subTotalDC, dc.idProductoDC "
					+ "FROM DetalleCompra dc "
					+ "JOIN Producto p ON dc.idProductoDC = p.idProducto "
					+ "WHERE dc.idCompraDC = " + id));

			while(dbcon.getResultSet().next()) {
				
				String producto = dbcon.getResultSet().getString("p.nombreProducto");
				int cantidad = dbcon.getResultSet().getInt("dc.cantidadDC");
				float costo = dbcon.getResultSet().getFloat("dc.CostoUnitarioDC");
				float subtotal = dbcon.getResultSet().getFloat("dc.subtotalDC");
				int idProducto = dbcon.getResultSet().getInt("dc.idProductoDC");
				dcs.add(new DetalleCompraDTO(producto, cantidad, costo, subtotal, idProducto));
			}
			dbcon.closeConnection();
		} catch (SQLException e) {
			e.printStackTrace();
		}
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
