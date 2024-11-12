package co.edu.unbosque.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Iterator;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.RowFilter;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;

import co.edu.unbosque.model.CompraDTO;
import co.edu.unbosque.model.DetalleCompraDTO;
import co.edu.unbosque.model.DetalleVentaDTO;
import co.edu.unbosque.model.GastoDTO;
import co.edu.unbosque.model.Login;
import co.edu.unbosque.model.ProductoDTO;
import co.edu.unbosque.model.ProveedorDTO;
import co.edu.unbosque.model.VentaDTO;
import co.edu.unbosque.model.persistence.CompraDAO;
import co.edu.unbosque.model.persistence.DetalleCompraDAO;
import co.edu.unbosque.model.persistence.DetalleVentaDAO;
import co.edu.unbosque.model.persistence.GastoDAO;
import co.edu.unbosque.model.persistence.ProductoDAO;
import co.edu.unbosque.model.persistence.ProveedorDAO;
import co.edu.unbosque.model.persistence.VentaDAO;
import co.edu.unbosque.view.LoginPanel;
import co.edu.unbosque.view.LoginPreguntaPanel;
import co.edu.unbosque.view.MainWindow;
import co.edu.unbosque.view.Sonido;

public class Controller implements ActionListener {

	private LoginPanel lp;
	private MainWindow mw;
	private ProveedorDAO provDao;
	private ProductoDAO producDao;
	private VentaDAO venDao;
	private DetalleVentaDAO dvDao;
	private CompraDAO comDao;
	private DetalleCompraDAO dcDao;
	private GastoDAO gdao;
	private Login l;
	private LoginPreguntaPanel lpp;
	private Sonido sound;

	public Controller() {

		sound = new Sonido();
		l = new Login();
		lp = new LoginPanel();
		lpp = new LoginPreguntaPanel();
		mw = new MainWindow();
		provDao = new ProveedorDAO();
		producDao = new ProductoDAO();
		venDao = new VentaDAO();
		dvDao = new DetalleVentaDAO();
		comDao = new CompraDAO();
		dcDao = new DetalleCompraDAO();
		gdao = new GastoDAO();
		addListeners();

	}

	public void addListeners() {

		// Botones LoginPanel
		lp.getBtnIngresar().addActionListener(this);
		lp.getBtnIngresar().setActionCommand("Ingresar");

		lp.getBtnOlvidoContra().addActionListener(this);
		lp.getBtnOlvidoContra().setActionCommand("OlvContra");

		lpp.getBtnValidar().addActionListener(this);
		lpp.getBtnValidar().setActionCommand("Validar");
		// Botones OptionPanel
		mw.getOp().getBtnInventario().addActionListener(this);
		mw.getOp().getBtnInventario().setActionCommand("Inventario");

		mw.getOp().getBtnCompras().addActionListener(this);
		mw.getOp().getBtnCompras().setActionCommand("Compras");

		mw.getOp().getBtnVentas().addActionListener(this);
		mw.getOp().getBtnVentas().setActionCommand("Ventas");

		mw.getOp().getBtnGastos().addActionListener(this);
		mw.getOp().getBtnGastos().setActionCommand("Gastos");

		mw.getOp().getBtnPreg().addActionListener(this);
		mw.getOp().getBtnPreg().setActionCommand("Consulta");

		// boton OptionPaneinfo

		mw.getOpi().getBtnOk().addActionListener(this);
		mw.getOpi().getBtnOk().setActionCommand("OptOk");

		// Botones InventarioPanel
		mw.getIp().getBtnBack().addActionListener(this);
		mw.getIp().getBtnBack().setActionCommand("invBack");

		mw.getIp().getBtnProveedores().addActionListener(this);
		mw.getIp().getBtnProveedores().setActionCommand("invProveedores");

		mw.getIp().getBtnAdd().addActionListener(this);
		mw.getIp().getBtnAdd().setActionCommand("invAdd");

		mw.getIp().getBtnBusqueda().addActionListener(this);
		mw.getIp().getBtnBusqueda().setActionCommand("invBus");

		mw.getIp().getBtnS().addActionListener(this);
		mw.getIp().getBtnS().setActionCommand("magia");

		// boton Info

		mw.getIp().getBtnPreg().addActionListener(this);
		mw.getIp().getBtnPreg().setActionCommand("ConsultaInventario");

		// Botones ProductoNuevoWindow
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

		mw.getPp().getBtnEdit().addActionListener(this);
		mw.getPp().getBtnEdit().setActionCommand("provEdit");

		mw.getPp().getBtnDelete().addActionListener(this);
		mw.getPp().getBtnDelete().setActionCommand("provDelete");

		// Boton info
		mw.getPp().getBtnPreg().addActionListener(this);
		mw.getPp().getBtnPreg().setActionCommand("ConsultaProveedores");

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

		mw.getVp().getBtnVerVenta().addActionListener(this);
		mw.getVp().getBtnVerVenta().setActionCommand("venView");

		// Boton Info

		mw.getVp().getBtnPreg().addActionListener(this);
		mw.getVp().getBtnPreg().setActionCommand("ConsultaVentas");

		// Botones VentaNuevaWindow
		mw.getVw().getBtnAdd().addActionListener(this);
		mw.getVw().getBtnAdd().setActionCommand("newVenAdd");

		mw.getVw().getBtnBack().addActionListener(this);
		mw.getVw().getBtnBack().setActionCommand("newVenBack");

		mw.getVw().getBtnDone().addActionListener(this);
		mw.getVw().getBtnDone().setActionCommand("newVenDone");

		// Botones VentaEnDetalle
		mw.getVed().getBtnOk().addActionListener(this);
		mw.getVed().getBtnOk().setActionCommand("detailVenOk");

		// Botones ComprasPanel
		mw.getCp().getBtnBack().addActionListener(this);
		mw.getCp().getBtnBack().setActionCommand("comBack");

		mw.getCp().getbtnNuevaCompra().addActionListener(this);
		mw.getCp().getbtnNuevaCompra().setActionCommand("comAdd");

		mw.getCp().getBtnDetails().addActionListener(this);
		mw.getCp().getBtnDetails().setActionCommand("comDetails");

		// Boton Info

		mw.getCp().getBtnInfo().addActionListener(this);
		mw.getCp().getBtnInfo().setActionCommand("ConsultaCompras");

		// Botones CompraEnDetalle
		mw.getCed().getBtnOk().addActionListener(this);
		mw.getCed().getBtnOk().setActionCommand("cedOk");

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

		mw.getGp().getBtnBusqueda().addActionListener(this);
		mw.getGp().getBtnBusqueda().setActionCommand("gasBus");

		mw.getGp().getBtnAdd().addActionListener(this);
		mw.getGp().getBtnAdd().setActionCommand("gasAdd");

		mw.getGp().getBtnInfo().addActionListener(this);
		mw.getGp().getBtnInfo().setActionCommand("ConsultaGastos");

		// Botones GastoNuevoWindow

		mw.getGnw().getBtnBack().addActionListener(this);
		mw.getGnw().getBtnBack().setActionCommand("gnwBack");

		mw.getGnw().getBtnAdd().addActionListener(this);
		mw.getGnw().getBtnAdd().setActionCommand("gnwAdd");

	}

	private static int idVenta;
	private static int idCompra;

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub

		switch (e.getActionCommand()) {
		// Botones Login

		case "Ingresar": {

			String userName = lp.getTxtUser().getText();
			char[] passwordChars = lp.getTxtContra().getPassword();
		    String contraseña = new String(passwordChars);
		    
			if (Login.validarCredenciales(userName, contraseña)) {
				JOptionPane.showMessageDialog(null, "Ingreso exitoso");
				mw.setVisible(true);
				lp.setVisible(false);
			} else {
				JOptionPane.showMessageDialog(null, "Credenciales incorrectas");
			}
			break;
		}

		case "OlvContra": {
			lp.setVisible(false);
			lpp.setVisible(true);
			break;
		}

		// Botones LoginPanelPregunta

		case "Validar": {
			String respuestaUsuario = lpp.getTxtRta().getText();

			if (Login.validarRespuestaSeguridad(respuestaUsuario)) {
				JOptionPane.showMessageDialog(null, "Respuesta correcta");
				mw.setVisible(true); 
				lp.setVisible(false); 
			} else {
				JOptionPane.showMessageDialog(null, "Respuesta incorrecta", "Error", JOptionPane.ERROR_MESSAGE);
			}
			break;
		}

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

			List<ProductoDTO> productosBajoStock = producDao.getProductosBajoStock(5);
			if (!productosBajoStock.isEmpty()) {
				StringBuilder mensaje = new StringBuilder("Los siguientes productos tienen stock bajo:\n\n");
				for (ProductoDTO producto : productosBajoStock) {
					mensaje.append(producto.getNombreProducto()).append(" - Stock actual: ")
							.append(producto.getStockProducto()).append("\n");
				}

				JOptionPane.showMessageDialog(null, mensaje.toString(), "Alerta de Stock", JOptionPane.WARNING_MESSAGE);
				for (ProductoDTO p : producDao.getProductos()) {
					Object row[] = { p.getIdProducto(), p.getNombreProducto(), p.getMarcaProducto(),
							p.getStockProducto(), p.getCostoProducto(), p.getPrecioProducto(),
							p.getNombreProveedor(), };
					mw.getIp().getModel().addRow(row);
				}

				break;
			}

			break;
		}

		// cambios
		case "Ventas": {
			mw.getOp().setVisible(false);
			mw.getVp().setVisible(true);

			venDao.readAll();

			for (VentaDTO v : venDao.getVentas()) {
				Object row[] = { v.getIdVenta(), v.getFechaVenta(), v.getHoraVenta(), v.getTotalVenta() };
				mw.getVp().getModel().addRow(row);
			}
			break;
		}

		case "Compras": {
			mw.getOp().setVisible(false);
			mw.getCp().setVisible(true);

			comDao.readAll();

			for (CompraDTO c : comDao.getCompras()) {
				Object row[] = { c.getidCompra(), c.getfechaCompra(), c.gethoraCompra(), c.gettotalCompra() };
				mw.getCp().getModel().addRow(row);
			}
			break;
		}

		case "Gastos": {
			mw.getOp().setVisible(false);
			mw.getGp().setVisible(true);

			gdao.readAll();

			for (GastoDTO g : gdao.getGastos()) {
				Object row[] = { g.getIdGasto(), g.getFechaGasto(), g.getHoraGasto(), g.getDescipcionGasto(),
						g.getValorGasto() };
				mw.getGp().getModel().addRow(row);
			}
			break;
		}
		case "magia":{
			
			mw.playMusica(0);
			
		}
		case "gasBus": {
		    String fechaBuscar = mw.getGp().getTxtBusqueda().getText();

		    TableModel modelGastos = mw.getGp().getTableGastos().getModel();
		    TableRowSorter<TableModel> sorter = new TableRowSorter<>(modelGastos);
		    mw.getGp().getTableGastos().setRowSorter(sorter);

		    if (fechaBuscar.isEmpty()) {
		        sorter.setRowFilter(null);
		        JOptionPane.showMessageDialog(null, 
		            "Para buscar por fecha, ingrese la fecha en el formato año-mes-día (ejemplo: 2024-11-09).",
		            "Información de búsqueda",
		            JOptionPane.INFORMATION_MESSAGE);
		    } else {
		        if (!fechaBuscar.matches("\\d{4}-\\d{2}-\\d{2}")) {
		            JOptionPane.showMessageDialog(null, 
		                "Formato de fecha incorrecto. Solo se permite el carácter '-' y números.\n" +
		                "Ejemplo de formato: año-mes-día (por ejemplo, 2024-11-09)", 
		                "Error de formato", 
		                JOptionPane.ERROR_MESSAGE);
		            return;
		        }

		        int columnaFecha = 1;
		        RowFilter<TableModel, Object> rf = RowFilter.regexFilter(fechaBuscar, columnaFecha);
		        sorter.setRowFilter(rf);
		    }

		    break;
		}




		case "Consulta": {
			mw.getOpi().setVisible(true);
			break;

		}

		case "ConsultaInventario": {
			mw.getIpi().setVisible(true);
			break;
		}

		case "ConsultaProveedores": {
			mw.getPpi().setVisible(true);
			break;
		}

		case "ConsultaVentas": {
			mw.getVpi().setVisible(true);
			break;
		}

		case "ConsultaCompras": {
			mw.getCpi().setVisible(true);
			break;
		}

		case "ConsultaGastos": {
			mw.getGpi().setVisible(true);
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

		    TableModel modelInventario = mw.getIp().getTableInventario().getModel();
		    TableRowSorter<TableModel> sorter = new TableRowSorter<>(modelInventario);
		    mw.getIp().getTableInventario().setRowSorter(sorter);

		    if (textoBuscar.isEmpty()) {
		        sorter.setRowFilter(null);
		        JOptionPane.showMessageDialog(null, 
		            "Para buscar un producto específico, ingrese el nombre del producto en el campo de búsqueda.",
		            "Información de búsqueda",
		            JOptionPane.INFORMATION_MESSAGE);
		    } else {
		        RowFilter<TableModel, Object> rf = RowFilter.regexFilter("(?i)" + textoBuscar, 1);
		        sorter.setRowFilter(rf);
		    }

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

		case "invAdd": {
		    provDao.readAll();

		    if (provDao.getProveedores().isEmpty()) {
		        JOptionPane.showMessageDialog(null, "No hay proveedores registrados. Por favor, agrega un proveedor primero.", "Error", JOptionPane.ERROR_MESSAGE);
		        return;
		    }

		    mw.getPnw().setVisible(true);

		    for (ProveedorDTO p : provDao.getProveedores()) {
		        mw.getPnw().getItems().add(p.getIdProveedor() + " - " + p.getNombreProveedor());
		    }
		    mw.getPnw().getTxtProveedor().setSuggestions(mw.getPnw().getItems());

		    break;
		}


		case "newProducBack": {
			mw.getPnw().setVisible(false);
			break;
		}

		case "newProducAdd": {

		    String nombre = mw.getPnw().getTxtNombre().getText();
		    String marca = mw.getPnw().getTxtMarca().getText();
		    String costo = mw.getPnw().getTxtCosto().getText();
		    String precio = mw.getPnw().getTxtPrecio().getText();
		    String proveedor = mw.getPnw().getTxtProveedor().getText();

		    if (nombre.isEmpty() || marca.isEmpty() || costo.isEmpty() || precio.isEmpty() || proveedor.isEmpty()) {
		        JOptionPane.showMessageDialog(null, "Todos los campos deben estar completos.", "Error", JOptionPane.ERROR_MESSAGE);
		        return;
		    }

		    try {
		        Float.parseFloat(costo);
		        Float.parseFloat(precio);
		    } catch (NumberFormatException e1) {
		        JOptionPane.showMessageDialog(null, "Costo y precio deben ser valores numéricos.", "Error", JOptionPane.ERROR_MESSAGE);
		        return;
		    }

		    if (!proveedor.contains(" - ")) {
		        JOptionPane.showMessageDialog(null, "Por favor, selecciona un proveedor válido con el formato 'ID - Nombre'.", "Error", JOptionPane.ERROR_MESSAGE);
		        return;
		    }

		    String proveedorId = proveedor.split(" - ")[1]; 

		    boolean proveedorExiste = false;
		    for (ProveedorDTO p : provDao.getProveedores()) {
		        if (p.getNombreProveedor().equalsIgnoreCase(proveedorId)) {
		            proveedorExiste = true;
		            break;
		        }
		    }

		    if (!proveedorExiste) {
		        JOptionPane.showMessageDialog(null, "Por favor, selecciona un proveedor válido.", "Error", JOptionPane.ERROR_MESSAGE);
		        return;
		    }

		    producDao.create2(nombre, marca, "0", costo, precio, proveedorId);
		    producDao.readAll();

		    ProductoDTO nuevoProducto = producDao.getProductos().get(producDao.getProductos().size() - 1);
		    System.out.println(nuevoProducto.toString());

		    mw.getIp().getModel().addRow(new Object[] { 
		        nuevoProducto.getIdProducto(), 
		        nuevoProducto.getNombreProducto(),
		        nuevoProducto.getMarcaProducto(), 
		        nuevoProducto.getStockProducto(),
		        nuevoProducto.getCostoProducto(), 
		        nuevoProducto.getPrecioProducto(),
		        nuevoProducto.getNombreProveedor() 
		    });

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

		    TableModel modelProveedores = mw.getPp().getTableProveedores().getModel();
		    TableRowSorter<TableModel> sorter = new TableRowSorter<>(modelProveedores);
		    mw.getPp().getTableProveedores().setRowSorter(sorter);

		    if (textoBuscar.isEmpty()) {
		        sorter.setRowFilter(null);
		        JOptionPane.showMessageDialog(null, 
		            "Para buscar un proveedor específico, ingrese el nombre del proveedor en el campo de búsqueda.",
		            "Información de búsqueda",
		            JOptionPane.INFORMATION_MESSAGE);
		    } else {
		        RowFilter<TableModel, Object> rf = RowFilter.regexFilter("(?i)" + textoBuscar, 1); // 1 es el índice de la columna "Nombre"
		        sorter.setRowFilter(rf);
		    }

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

		case "provEdit":
			try {
				int selectedRow = mw.getPp().getTableProveedores().getSelectedRow();

				// Verifica si se ha seleccionado alguna fila
				if (selectedRow == -1) {
					throw new Exception("No se ha seleccionado ningún proveedor para editar.");
				}

				int id = (Integer) mw.getPp().getTableProveedores().getValueAt(selectedRow, 0);

				mw.getPew().getTxtNombre()
						.setText((String) mw.getPp().getTableProveedores().getValueAt(selectedRow, 1));
				mw.getPew().getTxtDocumento()
						.setText((String) mw.getPp().getTableProveedores().getValueAt(selectedRow, 3));
				mw.getPew().getTxtTelefono()
						.setText((String) mw.getPp().getTableProveedores().getValueAt(selectedRow, 4));
				mw.getPew().getTxtDireccion()
						.setText((String) mw.getPp().getTableProveedores().getValueAt(selectedRow, 5));

				mw.getPew().setVisible(true);
			} catch (Exception ex) {
				JOptionPane.showMessageDialog(null, "Error: " + ex.getMessage(), "Error de edición",
						JOptionPane.ERROR_MESSAGE);
			}
			break;

		case "provDelete": {
			int selectedRow = mw.getPp().getTableProveedores().getSelectedRow();

			if (selectedRow == -1) {
				JOptionPane.showMessageDialog(mw, "No se ha seleccionado ningún proveedor para eliminar.", "Error",
						JOptionPane.ERROR_MESSAGE);
				break;
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

			if (nombre.isEmpty() || tipoDocumento == null || tipoDocumento.isEmpty() || documento.isEmpty()
					|| telefono.isEmpty() || direccion.isEmpty()) {
				JOptionPane.showMessageDialog(null, "Todos los campos deben estar llenos", "Error",
						JOptionPane.ERROR_MESSAGE);
				break;
			}
			if (!nombre.matches("[a-zA-Z\\s]+")) {
				JOptionPane.showMessageDialog(null, "El nombre solo debe contener letras", "Error",
						JOptionPane.ERROR_MESSAGE);
				break;
			}

			if (!telefono.matches("\\d+")) {
				JOptionPane.showMessageDialog(null, "El teléfono solo debe contener números", "Error",
						JOptionPane.ERROR_MESSAGE);
				break;
			}

			if (!documento.matches("\\d+")) {
				JOptionPane.showMessageDialog(null, "El documento solo debe contener números", "Error",
						JOptionPane.ERROR_MESSAGE);
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

			// Obtener los valores actuales de la tabla para ahorita comparar con los
			// existentes y verificar si se hizo un cambio
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

			if (nombre.isEmpty() || tipoDocumento == null || tipoDocumento.isEmpty() || documento.isEmpty()
					|| telefono.isEmpty() || direccion.isEmpty()) {
				JOptionPane.showMessageDialog(null, "Todos los campos deben estar llenos", "Error",
						JOptionPane.ERROR_MESSAGE);
				break;
			}
			if (!nombre.matches("[a-zA-Z\\s]+")) {
				JOptionPane.showMessageDialog(null, "El nombre solo debe contener letras", "Error",
						JOptionPane.ERROR_MESSAGE);
				break;
			}

			if (!documento.matches("\\d+")) {
				JOptionPane.showMessageDialog(null, "El documento solo debe contener números", "Error",
						JOptionPane.ERROR_MESSAGE);
				break;
			}
			if (!telefono.matches("\\d+")) {
				JOptionPane.showMessageDialog(null, "El teléfono solo debe contener números", "Error",
						JOptionPane.ERROR_MESSAGE);
				break;
			}

			if (nombre.equals(nombreActual) && tipoDocumento.equals(tipoDocumentoActual)
					&& documento.equals(documentoActual) && telefono.equals(telefonoActual)
					&& direccion.equals(direccionActual)) {
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

			mw.getVp().getModel().setRowCount(0);
			break;
		}
		case "venView": {
		    int selectedRow = mw.getVp().getTableVentas().getSelectedRow();

		    if (selectedRow == -1) { 
		        JOptionPane.showMessageDialog(null, "Por favor, selecciona una venta para ver los detalles.", "Advertencia", JOptionPane.WARNING_MESSAGE);
		        return;
		    }

		    int id = (Integer) mw.getVp().getTableVentas().getValueAt(selectedRow, 0);

		    dvDao.readById(id);
		    for (DetalleVentaDTO dv : dvDao.getDvs()) {
		        Object row[] = { dv.getNombreProducto(), dv.getCantidadDV(), dv.getPrecioUnitarioDV(),
		                dv.getSubtotalDV() };

		        mw.getVed().getModel().addRow(row);
		    }
		    mw.getVed().setVisible(true);
		    break;
		}

		case "venAdd": {
		    producDao.readAll();

		    if (producDao.getProductos().isEmpty()) {
		        JOptionPane.showMessageDialog(null, "No hay productos registrados en el inventario. Por favor, agrega productos primero.", "Error", JOptionPane.ERROR_MESSAGE);
		        return; 
		    }

		    mw.getVw().setVisible(true);

		    for (ProductoDTO item : producDao.getProductos()) {
		        mw.getVw().getItems().add(item.getIdProducto() + " - " + item.getNombreProducto());
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

		    String producto = mw.getVw().getTxtProducto().getText().trim();
		    if (producto.isEmpty()) {
		        JOptionPane.showMessageDialog(null, "El campo de producto no puede estar vacío.");
		        return;
		    }

		    if (!producto.matches("^\\d+ - .+$")) {
		        JOptionPane.showMessageDialog(null, "El formato del nombre del producto no es válido. Debe ser: 'ID - Nombre Producto'.");
		        return;
		    }

		    String idProductoStr = producto.split(" - ")[0].trim();
		    String nombreProductoIngresado = producto.split(" - ")[1].trim();

		    int idProductoIngresado;
		    try {
		        idProductoIngresado = Integer.parseInt(idProductoStr);
		    } catch (NumberFormatException e1) {
		        JOptionPane.showMessageDialog(null, "La ID del producto debe ser un número válido.");
		        return;
		    }

		    // Buscar el producto en la base de datos usando tanto ID como nombre
		    ProductoDTO productoEnDb = null;
		    for (ProductoDTO p : producDao.getProductos()) {
		        if (p.getIdProducto() == idProductoIngresado && p.getNombreProducto().trim().equalsIgnoreCase(nombreProductoIngresado)) {
		            productoEnDb = p;
		            break;
		        }
		    }

		    // Verificar si el producto fue encontrado en la base de datos
		    if (productoEnDb == null) {
		        JOptionPane.showMessageDialog(null, 
		            "No se encontró un producto con la combinación de ID y nombre ingresados. " +
		            "Por favor, verifique que la ID y el nombre sean correctos.");
		        return;
		    }

		    String cantidadStr = mw.getVw().getTxtCantidad().getText();
		    String precioStr = mw.getVw().getTxtPrecio().getText();

		    if (cantidadStr.isEmpty()) {
		        JOptionPane.showMessageDialog(null, "El campo de cantidad no puede estar vacío.");
		        return;
		    }

		    if (precioStr.isEmpty()) {
		        JOptionPane.showMessageDialog(null, "El campo de precio no puede estar vacío.");
		        return;
		    }

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

		    dvDao.create(cantidadStr, precioStr, String.valueOf(subTotal), String.valueOf(productoEnDb.getIdProducto()), String.valueOf(idVenta));

		    mw.getVw().getModel().addRow(new Object[] { producto, cantidadStr, precioStr, subTotal });

		    mw.getVw().getTxtPrecio().setText("");
		    mw.getVw().getTxtCantidad().setText("");
		    mw.getVw().getTxtProducto().setText("");

		    break;
		}

		case "newVenDone": {
		    if (dvDao.getDvs().isEmpty()) {
		        JOptionPane.showMessageDialog(null, "No hay información de venta. Debe realizar una venta primero.");
		        return; 
		    }

		    boolean hayStockSuficiente = true;  

		    for (DetalleVentaDTO dv : dvDao.getDvs()) {
		        int idProducto = dv.getIdProductoDV();
		        int newStock = (producDao.getStockById(idProducto)) - dv.getCantidadDV();
		        if (newStock < 0) {
		            hayStockSuficiente = false; 
		            JOptionPane.showMessageDialog(null, "No hay stock suficiente para realizar la venta del producto ID: " + idProducto);
		            break; 
		        }
		    }

		    if (!hayStockSuficiente) {
		        return;
		    }

		    float totalVenta = venDao.getTotalByVentaId(idVenta);
		    venDao.updateTotalVentaById(idVenta, totalVenta);
		    venDao.readAll();

		    VentaDTO v = venDao.getVentas().get(venDao.getVentas().size() - 1);
		    mw.getVp().getModel()
		            .addRow(new Object[] { v.getIdVenta(), v.getFechaVenta(), v.getHoraVenta(), v.getTotalVenta() });

		    mw.getVw().setVisible(false);

		    dvDao.readById(idVenta);
		    producDao.readAll();

		    for (DetalleVentaDTO dv : dvDao.getDvs()) {
		        int idProducto = dv.getIdProductoDV();
		        int newStock = (producDao.getStockById(idProducto)) - dv.getCantidadDV();
		        producDao.updateStockById(idProducto, newStock);
		    }

		    // Limpiar los campos y la tabla
		    mw.getVw().getTxtPrecio().setText("");
		    mw.getVw().getTxtCantidad().setText("");
		    mw.getVw().getTxtProducto().setText("");

		    mw.getVw().getModel().setRowCount(0);
		    break;
		}


		case "newVenBack": {
			mw.getVw().setVisible(false);
			mw.getVw().getModel().setRowCount(0);
			break;
		}

		// Botones VentaEnDetalle
		case "detailVenOk": {
			mw.getVed().setVisible(false);
			mw.getVed().getModel().setRowCount(0);
			break;
		}

		// Botones ComprasPanel
		case "comBack": {
			mw.getOp().setVisible(true);
			mw.getCp().setVisible(false);
			break;
		}
		case "comAdd": {

			mw.getCnp().setVisible(true);

			producDao.readAll();
			for (ProductoDTO item : producDao.getProductos()) {
				mw.getCnp().getItems().add((item.getIdProducto() + " - " + item.getNombreProducto()));
			}
			mw.getCnp().getTxtProducto().setSuggestions(mw.getCnp().getItems());

			idCompra = comDao.create2(0f);

			break;
		}
		case "comDetails": {

		    int selectedRow = mw.getCp().getTableVentas().getSelectedRow();

		    if (selectedRow == -1) {
		        JOptionPane.showMessageDialog(null, "Por favor, seleccione una fila para ver los detalles de la compra.", "Error", JOptionPane.WARNING_MESSAGE);
		        return;
		    }

		    int id = (Integer) mw.getCp().getTableVentas().getValueAt(selectedRow, 0);

		    mw.getCed().setVisible(true);

		    dcDao.readById(id);

		    for (DetalleCompraDTO dc : dcDao.getDcs()) {
		        Object row[] = { dc.getNombreProducto(), dc.getCantidadDC(), dc.getcostoUnitarioDC(), dc.getSubtotalDC() };
		        mw.getCed().getModel().addRow(row);
		    }

		    break;
		}


		// Botones CompraEnDetalle
		case "cedOk": {
			mw.getCed().setVisible(false);
			System.out.println("pija");
			mw.getCed().getModel().setRowCount(0);
			break;
		}

		// Botones NuevaCompraWindow
		case "newComAdd": {

		    if (idCompra == -1) {
		        JOptionPane.showMessageDialog(null, "Error al crear la compra.");
		        return;
		    }

		    String producto = mw.getCnp().getTxtProducto().getText().trim();
		    if (producto.isEmpty()) {
		        JOptionPane.showMessageDialog(null, "El campo de producto no puede estar vacío.");
		        return;
		    }

		    if (!producto.matches("^\\d+ - .+$")) {
		        JOptionPane.showMessageDialog(null, "El formato del nombre del producto no es válido. Debe ser: 'ID - Nombre Producto'.");
		        return;
		    }

		    String idProductoStr = producto.split(" - ")[0].trim();
		    String nombreProductoIngresado = producto.split(" - ")[1].trim();

		    int idProductoIngresado;
		    try {
		        idProductoIngresado = Integer.parseInt(idProductoStr);
		    } catch (NumberFormatException e2) {
		        JOptionPane.showMessageDialog(null, "La ID del producto debe ser un número válido.");
		        return;
		    }

		    ProductoDTO productoEnDb = null;
		    for (ProductoDTO p : producDao.getProductos()) {
		        if (p.getIdProducto() == idProductoIngresado && p.getNombreProducto().trim().equalsIgnoreCase(nombreProductoIngresado)) {
		            productoEnDb = p;
		            break;
		        }
		    }

		    if (productoEnDb == null) {
		        JOptionPane.showMessageDialog(null, 
		            "No se encontró un producto con la combinación de ID y nombre ingresados. " +
		            "Por favor, verifique que la ID y el nombre sean correctos.");
		        return;
		    }

		    String cantidadStr = mw.getCnp().getTxtCantidad().getText();
		    String costoStr = mw.getCnp().getTxtPrecio().getText();

		    if (cantidadStr.isEmpty()) {
		        JOptionPane.showMessageDialog(null, "El campo de cantidad no puede estar vacío.");
		        return;
		    }

		    if (costoStr.isEmpty()) {
		        JOptionPane.showMessageDialog(null, "El campo de costo no puede estar vacío.");
		        return;
		    }

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

		    try {
		        float precio = Float.parseFloat(costoStr);
		        if (precio <= 0) {
		            JOptionPane.showMessageDialog(null, "El precio debe ser un número mayor a cero.");
		            return;
		        }
		    } catch (NumberFormatException e1) {
		        JOptionPane.showMessageDialog(null, "Ingrese un precio válido (solo números).");
		        return;
		    }

		    float subTotal = Float.parseFloat(cantidadStr) * Float.parseFloat(costoStr);

		    dcDao.create(cantidadStr, costoStr, String.valueOf(subTotal), String.valueOf(productoEnDb.getIdProducto()), String.valueOf(idCompra));

		    mw.getCnp().getModel().addRow(new Object[] { producto, cantidadStr, costoStr, subTotal });

		    mw.getCnp().getTxtProducto().setText("");
		    mw.getCnp().getTxtCantidad().setText("");
		    mw.getCnp().getTxtPrecio().setText("");

		    break;
		}

		case "newComDone":{
		    if (dcDao.getDcs().isEmpty()) {
		        JOptionPane.showMessageDialog(null, "No hay información de compra. Debe realizar una compra primero.");
		        return; 
		    }

		    float totalCompra = comDao.getTotalByCompraId(idCompra);
		    comDao.updateTotalCompraById(idCompra, totalCompra);
		    comDao.readAll();

		    CompraDTO c = comDao.getCompras().get(comDao.getCompras().size() - 1);
		    mw.getCp().getModel().addRow(
		            new Object[] { c.getidCompra(), c.getfechaCompra(), c.gethoraCompra(), c.gettotalCompra() });

		    mw.getCnp().setVisible(false);

		    dcDao.readById(idCompra);

		    for (DetalleCompraDTO dc : dcDao.getDcs()) {
		        int idProducto = dc.getIdProductoDC();
		        int newStock = producDao.getStockById(idProducto) + dc.getCantidadDC();
		        producDao.updateStockById(idProducto, newStock); 
		    }

		    mw.getCnp().getTxtPrecio().setText("");
		    mw.getCnp().getTxtCantidad().setText("");
		    mw.getCnp().getTxtProducto().setText("");

		    mw.getCnp().getModel().setRowCount(0);
		    break;

		}

		case "newComBack": {
			mw.getCnp().setVisible(false);
			break;
		}

		// Botones GastosPanel
		case "gasBack": {
			mw.getOp().setVisible(true);
			mw.getGp().setVisible(false);

			mw.getGp().getModel().setRowCount(0);
			break;
		}
		case "gasAdd": {
			mw.getGnw().setVisible(true);
			break;
		}

		// Botones GastoNuevoWindow

		case "gnwBack": {
			mw.getGnw().setVisible(false);
			break;
		}
		
		

		case "gnwAdd": {
		    String descripcion = mw.getGnw().getTxtDescripcion().getText();
		    String valor = mw.getGnw().getTxtValor().getText();

		    if (descripcion.trim().isEmpty()) {
		        JOptionPane.showMessageDialog(null, "La descripción no puede estar vacía.", "Error", JOptionPane.ERROR_MESSAGE);
		        return;
		    }

		    if (!valor.matches("\\d+")) {
		        JOptionPane.showMessageDialog(null, "El valor debe ser numérico.", "Error", JOptionPane.ERROR_MESSAGE);
		        return;
		    }

		    gdao.create(descripcion, valor);
		    gdao.readAll();
		    GastoDTO nuevoGasto = gdao.getGastos().get(gdao.getGastos().size() - 1);

		    mw.getGp().getModel().addRow(new Object[] { nuevoGasto.getIdGasto(), nuevoGasto.getFechaGasto(),
		            nuevoGasto.getHoraGasto(), nuevoGasto.getDescipcionGasto(), nuevoGasto.getValorGasto() });
		    System.out.println("Gasto añadido :D");

		    break;
		}

		}
	}

	public void playMusica(int i) {

		sound.setFile(i);
		sound.play();
		sound.loop();
	}
}
