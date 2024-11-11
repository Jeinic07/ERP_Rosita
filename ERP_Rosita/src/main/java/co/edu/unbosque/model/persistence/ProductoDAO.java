package co.edu.unbosque.model.persistence;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

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
	    ProductoDTO newProducto = new ProductoDTO(args[0], args[1], Integer.parseInt(args[2]),
	            Float.parseFloat(args[3]), Float.parseFloat(args[4]), args[5]);
	    dbcon.initConnection();

	    try {
	        dbcon.setPrepareStatement(dbcon.getConnect()
	                .prepareStatement("SELECT idProveedor FROM Proveedor WHERE nombreProveedor = ?"));
	        dbcon.getPrepareStatement().setString(1, newProducto.getNombreProveedor());
	        ResultSet rs = dbcon.getPrepareStatement().executeQuery();

	        if (rs.next()) {
	            int idProveedor = rs.getInt("idProveedor");
	            newProducto.setIdProveedor(idProveedor);
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

	public int updateStockById(int id, int newStock) {
	    dbcon.initConnection();
	    int result = 0;

	    try {
	        dbcon.setPrepareStatement(dbcon.getConnect().prepareStatement(
	                "UPDATE Producto SET stockProducto = ? WHERE idProducto = ?"));
	        dbcon.getPrepareStatement().setInt(1, newStock);
	        dbcon.getPrepareStatement().setInt(2, id);

	        result = dbcon.getPrepareStatement().executeUpdate();

	        if (result > 0) {
	            System.out.println("Stock actualizado correctamente.");
	        } else {
	            System.out.println("No se encontró el producto con el ID especificado.");
	        }
	        
	        dbcon.closeConnection();

	    } catch (SQLException e) {
	        e.printStackTrace();
	    }
	    return result;
	}

	public int getStockById(int idProducto) {
	    dbcon.initConnection();
	    int stock = -1;  // Valor predeterminado para indicar que el producto no se encontró.

	    try {
	        dbcon.setPrepareStatement(dbcon.getConnect().prepareStatement(
	                "SELECT stockProducto FROM Producto WHERE idProducto = ?"));
	        dbcon.getPrepareStatement().setInt(1, idProducto);

	        ResultSet rs = dbcon.getPrepareStatement().executeQuery();
	        
	        if (rs.next()) {
	            stock = rs.getInt("stockProducto");  // Obtener el stock del producto.
	        } else {
	            System.out.println("Producto con ID " + idProducto + " no encontrado.");
	        }
	        
	        dbcon.closeConnection();

	    } catch (SQLException e) {
	        e.printStackTrace();
	    }
	    
	    return stock;  // Devolver el stock encontrado o -1 si no se encontró.
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
	
	public List<ProductoDTO> getProductosBajoStock(int threshold) {
	    List<ProductoDTO> productosBajoStock = new ArrayList<>();
	    for (ProductoDTO producto : productos) {
	        if (producto.getStockProducto() < threshold) {
	            productosBajoStock.add(producto);
	        }
	    }
	    return productosBajoStock;
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
