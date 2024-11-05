package co.edu.unbosque.model.persistence;

import java.awt.dnd.DnDConstants;
import java.sql.SQLException;
import java.util.ArrayList;

import co.edu.unbosque.controller.DBConnection;
import co.edu.unbosque.model.ProveedorDTO;

public class ProveedorDAO implements OperationsDAO {

	DBConnection dbcon;
	private ArrayList<ProveedorDTO> proveedores;

	public ProveedorDAO() {
		dbcon = new DBConnection();
		proveedores = new ArrayList<ProveedorDTO>();
	}

	public DBConnection getDbcon() {
		return dbcon;
	}

	public void setDbcon(DBConnection dbcon) {
		this.dbcon = dbcon;
	}

	public ArrayList<ProveedorDTO> getProveedores() {
		return proveedores;
	}

	public void setProveedores(ArrayList<ProveedorDTO> proveedores) {
		this.proveedores = proveedores;
	}

	@Override
	public void create(Object o) {
		proveedores.add((ProveedorDTO) o);
	}

	// hay que manejar las excepciones con el int
	@Override
	public int create(String... args) {
		ProveedorDTO newProveedor = new ProveedorDTO(args[0], args[1], args[2], args[3], args[4]);
		dbcon.initConnection();
		try {
			dbcon.setPrepareStatement(
					dbcon.getConnect().prepareStatement("INSERT INTO Proveedor(nombreProveedor, tipoDocumentoProveedor,"
							+ "documentoProveedor, telefonoProveedor, direccionProveedor) VALUES(?,?,?,?,?)"));
			dbcon.getPrepareStatement().setString(1, newProveedor.getNombreProveedor());
			dbcon.getPrepareStatement().setString(2, newProveedor.getTipoDocumentoProveedor());
			dbcon.getPrepareStatement().setString(3, newProveedor.getDocumentoProveedor());
			dbcon.getPrepareStatement().setString(4, newProveedor.getTelefonoProveedor());
			dbcon.getPrepareStatement().setString(5, newProveedor.getDireccionProveedor());

			dbcon.getPrepareStatement().executeUpdate();
			dbcon.closeConnection();

		} catch (SQLException e) {
			e.printStackTrace();
		}
		proveedores.add(newProveedor);

		return 0;
	}

	@Override
	public String readAll() {
		proveedores.clear();

		dbcon.initConnection();

		try {
			dbcon.setStatement(dbcon.getConnect().createStatement());
			dbcon.setResultSet(dbcon.getStatement().executeQuery("SELECT * FROM Proveedor"));
			while (dbcon.getResultSet().next()) {
				int id = dbcon.getResultSet().getInt("idProveedor");
				String nombre = dbcon.getResultSet().getString("nombreProveedor");
				String tipoDocumento = dbcon.getResultSet().getString("tipoDocumentoProveedor");
				String documento = dbcon.getResultSet().getString("documentoProveedor");
				String telefono = dbcon.getResultSet().getString("telefonoProveedor");
				String direccion = dbcon.getResultSet().getString("direccionProveedor");

				proveedores.add(new ProveedorDTO(id, nombre, tipoDocumento, documento, telefono, direccion));
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
		ProveedorDTO prov = new ProveedorDTO(args[0], args[1], args[2], args[3], args[4]);
		dbcon.initConnection();
		try {
			dbcon.setPrepareStatement(dbcon.getConnect()
					.prepareStatement("UPDATE Proveedor SET nombreProveedor=?, tipoDocumentoProveedor=?, "
							+ "documentoProveedor=?, telefonoProveedor=?, direccionProveedor=? " + "WHERE idProveedor="
							+ id));

			dbcon.getPrepareStatement().setString(1, prov.getNombreProveedor());
			dbcon.getPrepareStatement().setString(2, prov.getTipoDocumentoProveedor());
			dbcon.getPrepareStatement().setString(3, prov.getDocumentoProveedor());
			dbcon.getPrepareStatement().setString(4, prov.getTelefonoProveedor());
			dbcon.getPrepareStatement().setString(5, prov.getDireccionProveedor());
			dbcon.getPrepareStatement().executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		}

		dbcon.closeConnection();
		return 0;
	}

	@Override
	public int deleteById(int id) {
		dbcon.initConnection();
		try {
			dbcon.setPrepareStatement(
					dbcon.getConnect().prepareStatement("DELETE FROM Proveedor WHERE idProveedor = ?"));
			dbcon.getPrepareStatement().setInt(1, id);
			dbcon.getPrepareStatement().executeUpdate();
			dbcon.closeConnection();
			return 0;
		} catch (Exception e) {
			return 1;
		}

	}

}
