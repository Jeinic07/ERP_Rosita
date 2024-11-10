package co.edu.unbosque.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.RowFilter;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;

import com.google.protobuf.StringValue;
import com.google.protobuf.StringValueOrBuilder;

import co.edu.unbosque.model.ProductoDTO;
import co.edu.unbosque.model.ProveedorDTO;
import co.edu.unbosque.model.persistence.CompraDAO;
import co.edu.unbosque.model.persistence.DetalleCompraDAO;
import co.edu.unbosque.model.persistence.DetalleVentaDAO;
import co.edu.unbosque.model.persistence.ProductoDAO;
import co.edu.unbosque.model.persistence.ProveedorDAO;
import co.edu.unbosque.model.persistence.VentaDAO;
import co.edu.unbosque.view.MainWindow;

public class Controller implements ActionListener {

	private MainWindow mw;
	private ProveedorDAO provDao;
	private ProductoDAO producDao;
	private VentaDAO venDao;
	private DetalleVentaDAO dvDao;
	private CompraDAO comDao;
	private DetalleCompraDAO dcDao;

	public Controller() {
		mw = new MainWindow();
		provDao = new ProveedorDAO();
		producDao = new ProductoDAO();
		venDao = new VentaDAO();
		dvDao = new DetalleVentaDAO();
		comDao = new CompraDAO();
		dcDao = new DetalleCompraDAO();
		addListeners();

	}

	public void addListeners() {

		// Botones OptionPanel
		mw.getOp().getBtnInventario().addActionListener(this);
		mw.getOp().getBtnInventario().setActionCommand("Inventario");

		mw.getOp().getBtnCompras().addActionListener(this);
		mw.getOp().getBtnCompras().setActionCommand("Compras");

		mw.getOp().getBtnVentas().addActionListener(this);
		mw.getOp().getBtnVentas().setActionCommand("Ventas");

		mw.getOp().getBtnGastos().addActionListener(this);
		mw.getOp().getBtnGastos().setActionCommand("Gastos");

		mw.getOp().getBtnX().addActionListener(this);
		mw.getOp().getBtnX().setActionCommand("Cerrar");

		mw.getOp().getBtnMinus().addActionListener(this);
		mw.getOp().getBtnMinus().setActionCommand("Minus");

		mw.getOp().getBtnPreg().addActionListener(this);
		mw.getOp().getBtnPreg().setActionCommand("Consulta");

		// NUEVO, boton OptionPaneinfo

		mw.getOpi().getBtnOk().addActionListener(this);
		mw.getOpi().getBtnOk().setActionCommand("OptOk");

		// Botones InventarioPanel
		mw.getIp().getBtnBack().addActionListener(this);
		mw.getIp().getBtnBack().setActionCommand("invBack");

		mw.getIp().getBtnProveedores().addActionListener(this);
		mw.getIp().getBtnProveedores().setActionCommand("invProveedores");

		mw.getIp().getBtnX().addActionListener(this);
		mw.getIp().getBtnX().setActionCommand("Cerrar");

		mw.getPp().getBtnMinus().addActionListener(this);
		mw.getPp().getBtnMinus().setActionCommand("Minus");
		
		mw.getIp().getBtnAdd().addActionListener(this);
		mw.getIp().getBtnAdd().setActionCommand("invAdd");
		
		mw.getIp().getBtnBusqueda().addActionListener(this);
		mw.getIp().getBtnBusqueda().setActionCommand("invBus");
		
		//Botones ProductoNuevoWindow
		mw.getPnw().getBtnBack().addActionListener(this);
		mw.getPnw().getBtnBack().setActionCommand("newProducBack");
		
		mw.getPnw().getBtnDone().addActionListener(this);
		mw.getPnw().getBtnDone().setActionCommand("newProducAdd");
		

		// BOtones ProveedoresPanel
		mw.getPp().getBtnBack().addActionListener(this);
		mw.getPp().getBtnBack().setActionCommand("provBack");

		mw.getPp().getBtnAdd().addActionListener(this);
		mw.getPp().getBtnAdd().setActionCommand("provAdd");

		mw.getPp().getBtnBusqueda().addActionListener(this);
		mw.getPp().getBtnBusqueda().setActionCommand("provBus");
		//aca jijijiji
		
		mw.getPp().getBtnEdit().addActionListener(this);
		mw.getPp().getBtnEdit().setActionCommand("provEdit");

		mw.getPp().getBtnDelete().addActionListener(this);
		mw.getPp().getBtnDelete().setActionCommand("provDelete");

		mw.getPp().getBtnX().addActionListener(this);
		mw.getPp().getBtnX().setActionCommand("Cerrar");

		mw.getPp().getBtnMinus().addActionListener(this);
		mw.getPp().getBtnMinus().setActionCommand("Minus");

		// Botones ProveedorNuevoWindow
		mw.getPw().getBtnAdd().addActionListener(this);
		mw.getPw().getBtnAdd().setActionCommand("newProvAdd");

		mw.getPw().getBtnBack().addActionListener(this);
		mw.getPw().getBtnBack().setActionCommand("newProvBack");

		// Botones ProveedorEditarWindow
		mw.getPew().getBtnConfirm().addActionListener(this);
		mw.getPew().getBtnConfirm().setActionCommand("editProvConfirm");

		mw.getPew().getBtnBack().addActionListener(this);
		mw.getPew().getBtnBack().setActionCommand("editProvBack");

		// Botones VentasPanel
		mw.getVp().getBtnBack().addActionListener(this);
		mw.getVp().getBtnBack().setActionCommand("venBack");

		mw.getVp().getBtnNuevaVenta().addActionListener(this);
		mw.getVp().getBtnNuevaVenta().setActionCommand("venAdd");

		mw.getVp().getBtnX().addActionListener(this);
		mw.getVp().getBtnX().setActionCommand("Cerrar");

		mw.getVp().getBtnMinus().addActionListener(this);
		mw.getVp().getBtnMinus().setActionCommand("Minus");

		// Botones VentaNuevaWindow
		mw.getVw().getBtnAdd().addActionListener(this);
		mw.getVw().getBtnAdd().setActionCommand("newVenAdd");

		mw.getVw().getBtnBack().addActionListener(this);
		mw.getVw().getBtnBack().setActionCommand("newVenBack");

		mw.getVw().getBtnDone().addActionListener(this);
		mw.getVw().getBtnDone().setActionCommand("newVenDone");

		// Botones ComprasPanel
		mw.getCp().getBtnBack().addActionListener(this);
		mw.getCp().getBtnBack().setActionCommand("comBack");

		mw.getCp().getbtnNuevaCompra().addActionListener(this);
		mw.getCp().getbtnNuevaCompra().setActionCommand("comAdd");

		// Botones NuevaCompraWindow
		mw.getCnp().getBtnAdd().addActionListener(this);
		mw.getCnp().getBtnAdd().setActionCommand("newComAdd");

		mw.getCnp().getBtnBack().addActionListener(this);
		mw.getCnp().getBtnBack().setActionCommand("newComBack");

		mw.getCnp().getBtnDone().addActionListener(this);
		mw.getCnp().getBtnDone().setActionCommand("newComDone");

		// Botones GastosPanel
		mw.getGp().getBtnBack().addActionListener(this);
		mw.getGp().getBtnBack().setActionCommand("gasBack");
		
		
	}

	private static int idVenta;
	private static int idCompra;

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub

		switch (e.getActionCommand()) {

		// Botones OptionPanel
		case "Inventario": {
			mw.getOp().setVisible(false);
			mw.getIp().setVisible(true);

			producDao.readAll();

			for (ProductoDTO p : producDao.getProductos()) {
				Object row[] = { p.getIdProducto(), p.getNombreProducto(), p.getMarcaProducto(), p.getStockProducto(),
						p.getCostoProducto(), p.getPrecioProducto(), p.getNombreProveedor(), };
				mw.getIp().getModel().addRow(row);
			}

			break;
		}

		// cambios
		case "Ventas": {
			mw.getOp().setVisible(false);
			mw.getVp().setVisible(true);
			break;
		}

		case "Compras": {
			mw.getOp().setVisible(false);
			mw.getCp().setVisible(true);
			break;
		}

		case "Gastos": {
			mw.getOp().setVisible(false);
			mw.getGp().setVisible(true);
			break;
		}

		case "Consulta": {
			mw.getOpi().setVisible(true);
			break;

		}

		case "OptOk": {
			mw.getOpi().setVisible(false);
			break;
		}

		case "Cerrar": {
			System.exit(0);
			break;
		}

		case "Minus": {
			mw.setState(JFrame.ICONIFIED);
			break;
		}

		// Botones InventarioPanel
		case "invBack": {
			mw.getOp().setVisible(true);
			mw.getIp().setVisible(false);

			mw.getIp().getModel().setRowCount(0);
			break;
		}
		case "invBus": {
			System.out.println("pepepepenenneneen");
		    String textoBuscar = mw.getIp().getTxtBusqueda().getText().toLowerCase();
		    		// Convertir el texto a minúsculas para que la búsqueda sea insensible al caso

		    if (textoBuscar.isEmpty()) {
		        JOptionPane.showMessageDialog(null, "Por favor, ingresa un nombre para buscar.");
		        return;
		    }

		    // Obtener el modelo de la tabla de proveedores
		    TableModel modelInventario = mw.getIp().getTableInventario().getModel();

		    // Filtrar las filas de la tabla
		    TableRowSorter<TableModel> sorter = new TableRowSorter<>(modelInventario);
		    mw.getIp().getTableInventario().setRowSorter(sorter);

		    // Configuración del filtro
		    RowFilter<TableModel, Object> rf = RowFilter.regexFilter("(?i)" + textoBuscar, 1); // 1 es el índice de la columna "Nombre"
		    sorter.setRowFilter(rf);
		    break;
		}

		case "invProveedores": {
			mw.getIp().setVisible(false);
			mw.getPp().setVisible(true);

			provDao.readAll();

			for (ProveedorDTO p : provDao.getProveedores()) {
				Object row[] = { p.getIdProveedor(), p.getNombreProveedor(), p.getTipoDocumentoProveedor(),
						p.getDocumentoProveedor(), p.getTelefonoProveedor(), p.getDireccionProveedor() };
				mw.getPp().getModel().addRow(row);
			}
			break;
		}
		
		case "invAdd":{
			mw.getPnw().setVisible(true);
			
			producDao.readAll();
			
			for(ProductoDTO p : producDao.getProductos()) {
				mw.getPnw().getItems().add(p.getIdProveedor()+ " - "+ p.getNombreProveedor());
			}
			System.out.println(mw.getPnw().getItems().toString());
			mw.getPnw().getTxtProveedor().setSuggestions(mw.getPnw().getItems());
			
			break;
		}
		
		case "newProducBack":{
			mw.getPnw().setVisible(false);
			break;
		}
		
		case "newProducAdd":{
			
			String nombre = mw.getPnw().getTxtNombre().getText();
			String marca = mw.getPnw().getTxtMarca().getText();
			String costo = mw.getPnw().getTxtCosto().getText();
			String precio = mw.getPnw().getTxtPrecio().getText();
			String proveedor = mw.getPnw().getTxtProveedor().getText();
			
			producDao.create2(nombre, marca, "0", costo, precio, proveedor.split(" - ")[1]);
			
			producDao.readAll();
			
			ProductoDTO nuevoProducto = producDao.getProductos().get(producDao.getProductos().size() - 1);
			System.out.println(nuevoProducto.toString());
			mw.getIp().getModel()
					.addRow(new Object[] { nuevoProducto.getIdProducto(), nuevoProducto.getNombreProducto(),
							nuevoProducto.getMarcaProducto(), nuevoProducto.getStockProducto(),
							nuevoProducto.getCostoProducto(), nuevoProducto.getPrecioProducto(),
							nuevoProducto.getNombreProveedor() });

			mw.getPnw().getTxtNombre().setText("");
			mw.getPnw().getTxtMarca().setText("");
			mw.getPnw().getTxtCosto().setText("");
			mw.getPnw().getTxtPrecio().setText("");
			mw.getPnw().getTxtProveedor().setText("");			

			break;
		}

		// Botones ProveedoresPanel

		case "provBus": {
			System.out.println("pepepepenenneneen");
		    String textoBuscar = mw.getPp().getTxtBusqueda().getText().toLowerCase();
		    		// Convertir el texto a minúsculas para que la búsqueda sea insensible al caso

		    if (textoBuscar.isEmpty()) {
		        JOptionPane.showMessageDialog(null, "Por favor, ingresa un nombre para buscar.");
		        return;
		    }

		    // Obtener el modelo de la tabla de proveedores
		    TableModel modelProveedores = mw.getPp().getTableProveedores().getModel();

		    // Filtrar las filas de la tabla
		    TableRowSorter<TableModel> sorter = new TableRowSorter<>(modelProveedores);
		    mw.getPp().getTableProveedores().setRowSorter(sorter);

		    // Configuración del filtro
		    RowFilter<TableModel, Object> rf = RowFilter.regexFilter("(?i)" + textoBuscar, 1); // 1 es el índice de la columna "Nombre"
		    sorter.setRowFilter(rf);
		    break;
		}
		case "provBack": {
			mw.getPp().setVisible(false);
			mw.getIp().setVisible(true);

			mw.getPp().getModel().setRowCount(0);
			break;
		}
		case "provAdd": {
			mw.getPw().setVisible(true);
			break;
		}

		case "provEdit": try {
	        int selectedRow = mw.getPp().getTableProveedores().getSelectedRow();

	        // Verifica si se ha seleccionado alguna fila
	        if (selectedRow == -1) {
	            throw new Exception("No se ha seleccionado ningún proveedor para editar.");
	        }

	        int id = (Integer) mw.getPp().getTableProveedores().getValueAt(selectedRow, 0);

	        mw.getPew().getTxtNombre().setText((String) mw.getPp().getTableProveedores().getValueAt(selectedRow, 1));
	        mw.getPew().getTxtDocumento().setText((String) mw.getPp().getTableProveedores().getValueAt(selectedRow, 3));
	        mw.getPew().getTxtTelefono().setText((String) mw.getPp().getTableProveedores().getValueAt(selectedRow, 4));
	        mw.getPew().getTxtDireccion().setText((String) mw.getPp().getTableProveedores().getValueAt(selectedRow, 5));

	        mw.getPew().setVisible(true);
	    } catch (Exception ex) {
	        JOptionPane.showMessageDialog(null, "Error: " + ex.getMessage(), "Error de edición", JOptionPane.ERROR_MESSAGE);
	    }
	    break;

		case "provDelete":{
			  int selectedRow = mw.getPp().getTableProveedores().getSelectedRow();

			    // Verifica si se ha seleccionado alguna fila
			    if (selectedRow == -1) {
			        JOptionPane.showMessageDialog(mw, "No se ha seleccionado ningún proveedor para eliminar.", "Error", JOptionPane.ERROR_MESSAGE);
			        break; // Termina el proceso si no se selecciona una fila
			    }
			int id = (Integer) mw.getPp().getTableProveedores().getValueAt(selectedRow, 0);

			provDao.deleteById(id);
			if (JOptionPane.showConfirmDialog(mw, "Seguro que desea eliminarlo?") == 0) {
				mw.getPp().getModel().removeRow(selectedRow);
				System.out.println("Empleado eliminado correctamente");
			}

			break;
		}

		// Botones ProveedorNuevoAdd
		case "newProvAdd": {

			String nombre = mw.getPw().getTxtNombre().getText();
			String tipoDocumento = (String) mw.getPw().getTxtTipoDocumento().getSelectedItem();
			String documento = mw.getPw().getTxtDocumento().getText();
			String telefono = mw.getPw().getTxtTelefono().getText();
			String direccion = mw.getPw().getTxtDireccion().getText();

			//Verificar si no hay algun campo vacio
			if (nombre.isEmpty() || tipoDocumento == null || tipoDocumento.isEmpty() ||
			        documento.isEmpty() || telefono.isEmpty() || direccion.isEmpty()) {
			        JOptionPane.showMessageDialog(null, "Todos los campos deben estar llenos", "Error", JOptionPane.ERROR_MESSAGE);
			        break; 
			    }
			 // Excepción para que el nombre solo contenga letras
		    if (!nombre.matches("[a-zA-Z\\s]+")) {
		        JOptionPane.showMessageDialog(null, "El nombre solo debe contener letras", "Error", JOptionPane.ERROR_MESSAGE);
		        break;
		    }
		    
		    // Excepción para que el teléfono solo contenga números
		    if (!telefono.matches("\\d+")) {
		        JOptionPane.showMessageDialog(null, "El teléfono solo debe contener números", "Error", JOptionPane.ERROR_MESSAGE);
		        break;
		    }

		    // Excepción para que el documento solo contenga números
		    if (!documento.matches("\\d+")) {
		        JOptionPane.showMessageDialog(null, "El documento solo debe contener números", "Error", JOptionPane.ERROR_MESSAGE);
		        break;
		    }
		    
			provDao.create(nombre, tipoDocumento, documento, telefono, direccion);

			provDao.readAll();
			ProveedorDTO nuevoProveedor = provDao.getProveedores().get(provDao.getProveedores().size() - 1);

			mw.getPp().getModel()
					.addRow(new Object[] { nuevoProveedor.getIdProveedor(), nuevoProveedor.getNombreProveedor(),
							nuevoProveedor.getTipoDocumentoProveedor(), nuevoProveedor.getDocumentoProveedor(),
							nuevoProveedor.getTelefonoProveedor(), nuevoProveedor.getDireccionProveedor() });

			mw.getPw().getTxtNombre().setText("");
			mw.getPw().getTxtDocumento().setText("");
			mw.getPw().getTxtTelefono().setText("");
			mw.getPw().getTxtDireccion().setText("");

			break;
		}

		case "newProvBack": {
			mw.getPw().setVisible(false);
			break;
		}

		// Botones ProveedorEditarWindow
		case "editProvConfirm": {
			int selectedRow = mw.getPp().getTableProveedores().getSelectedRow();
			if (selectedRow == -1) {
			    JOptionPane.showMessageDialog(null, "Por favor, selecciona un proveedor para editar.");
			    break;
			}

		    int id = (Integer) mw.getPp().getTableProveedores().getValueAt(selectedRow, 0);
		    
		 // Obtener los valores actuales de la tabla para ahorita comparar con los existentes y verificar si se hizo un cambio
		    String nombreActual = (String) mw.getPp().getTableProveedores().getValueAt(selectedRow, 1);
		    String tipoDocumentoActual = (String) mw.getPp().getTableProveedores().getValueAt(selectedRow, 2);
		    String documentoActual = (String) mw.getPp().getTableProveedores().getValueAt(selectedRow, 3);
		    String telefonoActual = (String) mw.getPp().getTableProveedores().getValueAt(selectedRow, 4);
		    String direccionActual = (String) mw.getPp().getTableProveedores().getValueAt(selectedRow, 5);

		    String nombre = mw.getPew().getTxtNombre().getText();
		    String tipoDocumento = (String) mw.getPew().getTxtTipoDocumento().getSelectedItem();
		    String documento = mw.getPew().getTxtDocumento().getText();
		    String telefono = mw.getPew().getTxtTelefono().getText();
		    String direccion = mw.getPew().getTxtDireccion().getText();
		    
		    if (nombre.isEmpty() || tipoDocumento == null || tipoDocumento.isEmpty() ||
			        documento.isEmpty() || telefono.isEmpty() || direccion.isEmpty()) {
			        JOptionPane.showMessageDialog(null, "Todos los campos deben estar llenos", "Error", JOptionPane.ERROR_MESSAGE);
			        break; 
			}
		    // Excepción para que el nombre solo contenga letras
		    if (!nombre.matches("[a-zA-Z\\s]+")) {
		        JOptionPane.showMessageDialog(null, "El nombre solo debe contener letras", "Error", JOptionPane.ERROR_MESSAGE);
		        break;
		    }
		    
		 // Excepción para que el documento solo contenga números
		    if (!documento.matches("\\d+")) {
		        JOptionPane.showMessageDialog(null, "El documento solo debe contener números", "Error", JOptionPane.ERROR_MESSAGE);
		        break;
		    }	
		 // Excepción para que el teléfono solo contenga números
		    if (!telefono.matches("\\d+")) {
		        JOptionPane.showMessageDialog(null, "El teléfono solo debe contener números", "Error", JOptionPane.ERROR_MESSAGE);
		        break;
		    }

		    
		    // Verificar si se ha realizado algún cambio
		    if (nombre.equals(nombreActual) && tipoDocumento.equals(tipoDocumentoActual) &&
		        documento.equals(documentoActual) && telefono.equals(telefonoActual) && 
		        direccion.equals(direccionActual)) {
		        JOptionPane.showMessageDialog(null, "No se ha editado nada", "Error", JOptionPane.ERROR_MESSAGE);
		        break;
		    }
		    
		    provDao.updateById(id, nombre, tipoDocumento, documento, telefono, direccion);
		    
		    mw.getPp().getModel().setValueAt(nombre, selectedRow, 1);
		    mw.getPp().getModel().setValueAt(tipoDocumento, selectedRow, 2);
		    mw.getPp().getModel().setValueAt(documento, selectedRow, 3);
		    mw.getPp().getModel().setValueAt(telefono, selectedRow, 4);
		    mw.getPp().getModel().setValueAt(direccion, selectedRow, 5);
		    
		    JOptionPane.showMessageDialog(mw, "Empleado Editado correctamente");
			mw.getPew().setVisible(false);

		    break;
		}

		case "editProvBack": {
			mw.getPew().setVisible(false);
			break;
		}
		// Botones VentasPanel
		case "venBack": {
			mw.getOp().setVisible(true);
			mw.getVp().setVisible(false);
			break;
		}

		case "venAdd":{

			mw.getVw().setVisible(true);

			producDao.readAll();
			for (ProductoDTO item : producDao.getProductos()) {
				mw.getVw().getItems().add((item.getIdProducto() + " - " + item.getNombreProducto()));
			}
			mw.getVw().getTxtProducto().setSuggestions(mw.getVw().getItems());
			
			
			idVenta = venDao.create2(0f);

			break;
		}
		// Botones VentaNuevaWindow
		case "newVenAdd": {

		    if (idVenta == -1) {
		        JOptionPane.showMessageDialog(null, "Error al crear la venta.");
		        return;
		    }

		    String producto = mw.getVw().getTxtProducto().getText();
		    if (producto.isEmpty()) {
		        JOptionPane.showMessageDialog(null, "El campo de producto no puede estar vacío.");
		        return;
		    }

		    String cantidadStr = mw.getVw().getTxtCantidad().getText();
		    String precioStr = mw.getVw().getTxtPrecio().getText();

		    // Validar que la cantidad no esté vacía
		    if (cantidadStr.isEmpty()) {
		        JOptionPane.showMessageDialog(null, "El campo de cantidad no puede estar vacío.");
		        return;
		    }

		    // Validar que el precio no esté vacío
		    if (precioStr.isEmpty()) {
		        JOptionPane.showMessageDialog(null, "El campo de precio no puede estar vacío.");
		        return;
		    }

		    // Validar que la cantidad sea un número válido
		    try {
		        float cantidad = Float.parseFloat(cantidadStr);
		        if (cantidad <= 0) {
		            JOptionPane.showMessageDialog(null, "La cantidad debe ser un número mayor a cero.");
		            return;
		        }
		    } catch (NumberFormatException e1) {
		        JOptionPane.showMessageDialog(null, "Ingrese una cantidad válida (solo números).");
		        return;
		    }

		    // Validar que el precio sea un número válido
		    try {
		        float precio = Float.parseFloat(precioStr);
		        if (precio <= 0) {
		            JOptionPane.showMessageDialog(null, "El precio debe ser un número mayor a cero.");
		            return;
		        }
		    } catch (NumberFormatException e1) {
		        JOptionPane.showMessageDialog(null, "Ingrese un precio válido (solo números).");
		        return;
		    }

		    float subTotal = Float.parseFloat(cantidadStr) * Float.parseFloat(precioStr);

		    dvDao.create(cantidadStr, precioStr, String.valueOf(subTotal), "3", String.valueOf(idVenta));

		    mw.getVw().getModel().addRow(new Object[] { producto, cantidadStr, precioStr, subTotal });

		    break;
		}



		case "newVenDone":

			break;

		case "newVenBack": {
			mw.getVw().setVisible(false);
			break;
		}

		// Botones ComprasPanel
		case "comBack": {
			mw.getOp().setVisible(true);
			mw.getCp().setVisible(false);
			break;
		}
		case "comAdd":

			mw.getCnp().setVisible(true);

			producDao.readAll();
			for (ProductoDTO item : producDao.getProductos()) {
				mw.getCnp().getItems().add((item.getIdProducto() + " - " + item.getNombreProducto()));
			}
			mw.getCnp().getTxtProducto().setSuggestions(mw.getCnp().getItems());
			
			
			idCompra = comDao.create2(0f);

			break;
		// Botones NuevaCompraWindow
		case "newComAdd": {

		    System.out.println("pene");
		    if (idCompra == -1) {
		        JOptionPane.showMessageDialog(null, "Error al crear la compra.");
		        return;
		    }

		    String producto = mw.getCnp().getTxtProducto().getText();
		    if (producto.isEmpty()) {
		        JOptionPane.showMessageDialog(null, "El campo de producto no puede estar vacío.");
		        return;
		    }

		    String cantidadStr = mw.getCnp().getTxtCantidad().getText();
		    String precioStr = mw.getCnp().getTxtPrecio().getText();

		    // Validar que la cantidad no esté vacía
		    if (cantidadStr.isEmpty()) {
		        JOptionPane.showMessageDialog(null, "El campo de cantidad no puede estar vacío.");
		        return;
		    }

		    // Validar que el precio no esté vacío
		    if (precioStr.isEmpty()) {
		        JOptionPane.showMessageDialog(null, "El campo de precio no puede estar vacío.");
		        return;
		    }

		    // Validar que la cantidad sea un número válido
		    try {
		        float cantidad = Float.parseFloat(cantidadStr);
		        if (cantidad <= 0) {
		            JOptionPane.showMessageDialog(null, "La cantidad debe ser un número mayor a cero.");
		            return;
		        }
		    } catch (NumberFormatException e1) {
		        JOptionPane.showMessageDialog(null, "Ingrese una cantidad válida (solo números).");
		        return;
		    }

		    // Validar que el precio sea un número válido
		    try {
		        float precio = Float.parseFloat(precioStr);
		        if (precio <= 0) {
		            JOptionPane.showMessageDialog(null, "El precio debe ser un número mayor a cero.");
		            return;
		        }
		    } catch (NumberFormatException e1) {
		        JOptionPane.showMessageDialog(null, "Ingrese un precio válido (solo números).");
		        return;
		    }

		    float subTotal = Float.parseFloat(cantidadStr) * Float.parseFloat(precioStr);

		    dcDao.create(cantidadStr, precioStr, String.valueOf(subTotal), "3", String.valueOf(idCompra));

		    mw.getCnp().getModel().addRow(new Object[] { producto, cantidadStr, precioStr, subTotal });

		    break;
		}
		case "newComDone":

			break;

		case "newComBack": {
			mw.getCnp().setVisible(false);
			break;
		}


		// Botones GastosPanel
		case "gasBack": {
			mw.getOp().setVisible(true);
			mw.getGp().setVisible(false);
			break;
		}
		
		
		}
	}

}
