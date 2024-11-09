package co.edu.unbosque.model.persistence;

import java.sql.SQLException;
import java.util.ArrayList;

import co.edu.unbosque.controller.DBConnection;
import co.edu.unbosque.model.DetalleCompraDTO;

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
					+ "(cantidadDC, costoUnitarioDC, subtotalDC, idCompra,idProducto)" + "VALUES (?,?,?,?,?)"));

			dbcon.getPrepareStatement().setInt(1, newDc.getCantidadDC());
			dbcon.getPrepareStatement().setFloat(2, newDc.getPrecioUnitarioDC());
			dbcon.getPrepareStatement().setFloat(3, newDc.getSubtotalDC());
			dbcon.getPrepareStatement().setInt(4, newDc.getIdCompraDC());
			dbcon.getPrepareStatement().setInt(5, newDc.getIdProductoDC());
			

			dbcon.getPrepareStatement().executeUpdate();
			dbcon.closeConnection();

		} catch (SQLException e) {
			e.printStackTrace();
		}
		dcs.add(newDc);
		return 0;
	}

	@Override
	public String readAll() {
		// TODO Auto-generated method stub
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
