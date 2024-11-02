package co.edu.unbosque.model.persistence;

import java.util.ArrayList;

import co.edu.unbosque.controller.DBConnection;
import co.edu.unbosque.model.ProveedorDTO;

public class ProveedorDAO implements OperationsDAO {

	DBConnection db;
	private ArrayList<ProveedorDTO> proveedores;

	public ProveedorDAO() {
		db = new DBConnection();
		proveedores = new ArrayList<ProveedorDTO>();
	}

	public DBConnection getDb() {
		return db;
	}

	public void setDb(DBConnection db) {
		this.db = db;
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

	@Override
	public void create(String... args) {
		

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
