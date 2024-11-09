package co.edu.unbosque.model.persistence;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import co.edu.unbosque.controller.DBConnection;
import co.edu.unbosque.model.ProductoDTO;

public class ProductoDAO implements OperationsDAO {

	DBConnection dbcon;
	private ArrayList<ProductoDTO> productos;

	public ProductoDAO() {
		dbcon = new DBConnection();
		productos = new ArrayList<ProductoDTO>();
	}

	public DBConnection getDbcon() {
		return dbcon;
	}

	public void setDbcon(DBConnection dbcon) {
		this.dbcon = dbcon;
	}

	public ArrayList<ProductoDTO> getProductos() {
		return productos;
	}

	public void setProductos(ArrayList<ProductoDTO> productos) {
		this.productos = productos;
	}

	@Override
	public void create(Object o) {
		productos.add((ProductoDTO) o);
	}

	@Override
	public int create(String... args) {
		ProductoDTO newProducto = new ProductoDTO(args[0], args[1], Integer.parseInt(args[2]),
				Float.parseFloat(args[3]), Float.parseFloat(args[4]), Integer.parseInt(args[5]));
		dbcon.initConnection();

		try {
			dbcon.setPrepareStatement(dbcon.getConnect()
					.prepareStatement("INSERT INTO Producto(nombreProducto, marcaProducto, stockProducto, "
							+ "costoProducto, precioProducto, idProveedor) VALUES(?,?,?,?,?,?)"));
			dbcon.getPrepareStatement().setString(1, newProducto.getNombreProducto());
			dbcon.getPrepareStatement().setString(2, newProducto.getMarcaProducto());
			dbcon.getPrepareStatement().setInt(3, newProducto.getStockProducto());
			dbcon.getPrepareStatement().setFloat(4, newProducto.getCostoProducto());
			dbcon.getPrepareStatement().setFloat(5, newProducto.getPrecioProducto());
			dbcon.getPrepareStatement().setInt(6, newProducto.getIdProveedor());

			dbcon.getPrepareStatement().executeUpdate();
			dbcon.closeConnection();

		} catch (SQLException e) {
			e.printStackTrace();
		}
		productos.add(newProducto);
		return 0;
	}
	
	public int create2(String... args) {
	    // Crear un nuevo producto con el nombre del proveedor en lugar de su id
	    ProductoDTO newProducto = new ProductoDTO(args[0], args[1], Integer.parseInt(args[2]),
	            Float.parseFloat(args[3]), Float.parseFloat(args[4]), args[5]);
	    dbcon.initConnection();

	    try {
	        // Buscar el id del proveedor a partir del nombre del proveedor (args[5])
	        dbcon.setPrepareStatement(dbcon.getConnect()
	                .prepareStatement("SELECT idProveedor FROM Proveedor WHERE nombreProveedor = ?"));
	        dbcon.getPrepareStatement().setString(1, newProducto.getNombreProveedor());
	        ResultSet rs = dbcon.getPrepareStatement().executeQuery();

	        // Verificar si se encontró un id
	        if (rs.next()) {
	            int idProveedor = rs.getInt("idProveedor");
	            newProducto.setIdProveedor(idProveedor);
	            System.out.println("esta: "+ newProducto.toString());
	            // Preparar y ejecutar la inserción en la tabla Producto
	            dbcon.setPrepareStatement(dbcon.getConnect()
	                    .prepareStatement("INSERT INTO Producto(nombreProducto, marcaProducto, stockProducto, "
	                            + "costoProducto, precioProducto, idProveedor) VALUES(?,?,?,?,?,?)"));
	            dbcon.getPrepareStatement().setString(1, newProducto.getNombreProducto());
	            dbcon.getPrepareStatement().setString(2, newProducto.getMarcaProducto());
	            dbcon.getPrepareStatement().setInt(3, newProducto.getStockProducto());
	            dbcon.getPrepareStatement().setFloat(4, newProducto.getCostoProducto());
	            dbcon.getPrepareStatement().setFloat(5, newProducto.getPrecioProducto());
	            dbcon.getPrepareStatement().setInt(6, idProveedor);

	            dbcon.getPrepareStatement().executeUpdate();
	         ;
	        } else {
	            System.out.println("Proveedor no encontrado");
	            return -1;
	        }

	        dbcon.closeConnection();

	    } catch (SQLException e) {
	        e.printStackTrace();
	    }

	    productos.add(newProducto);
	    return 0;
	}

	

	@Override
	public String readAll() {
		productos.clear();

		dbcon.initConnection();

		try {
			dbcon.setStatement(dbcon.getConnect().createStatement());
			dbcon.setResultSet(dbcon.getStatement().executeQuery(
					  "SELECT p.idProducto, p.nombreProducto, p.marcaProducto, "
					  + "p.stockProducto, p.costoProducto, p.precioProducto, "
					  + "p2.nombreProveedor "
					  + "FROM Producto p "
					  + "JOIN Proveedor p2 ON p.idProveedor = p2.idProveedor"));
			while (dbcon.getResultSet().next()) {
				int id = dbcon.getResultSet().getInt("idProducto");
				String nombre = dbcon.getResultSet().getString("nombreProducto");
				String marca = dbcon.getResultSet().getString("marcaProducto");
				int stock = dbcon.getResultSet().getInt("stockProducto");
				float costo = dbcon.getResultSet().getFloat("costoProducto");
				float precio = dbcon.getResultSet().getFloat("precioProducto");
				String nombreProv = dbcon.getResultSet().getString("nombreProveedor");
				
				productos.add(new ProductoDTO(id, nombre, marca, stock, costo, precio, nombreProv));
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
