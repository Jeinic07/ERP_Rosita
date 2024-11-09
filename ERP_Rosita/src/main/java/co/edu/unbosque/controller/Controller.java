package co.edu.unbosque.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

import co.edu.unbosque.model.ProductoDTO;
import co.edu.unbosque.model.ProveedorDTO;
import co.edu.unbosque.model.persistence.ProductoDAO;
import co.edu.unbosque.model.persistence.ProveedorDAO;
import co.edu.unbosque.view.MainWindow;

public class Controller implements ActionListener {

	private MainWindow mw;
	private ProveedorDAO provDao;
	private ProductoDAO producDao;

	public Controller() {
		mw = new MainWindow();
		provDao = new ProveedorDAO();
		producDao = new ProductoDAO();
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

		//CAMBIO 09/11
//		mw.getOp().getBtnX().addActionListener(this);
//		mw.getOp().getBtnX().setActionCommand("Cerrar");

//		mw.getOp().getBtnMinus().addActionListener(this);
//		mw.getOp().getBtnMinus().setActionCommand("Minus");

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

//		mw.getIp().getBtnX().addActionListener(this);
//		mw.getIp().getBtnX().setActionCommand("Cerrar");
//		
//		mw.getPp().getBtnMinus().addActionListener(this);
//		mw.getPp().getBtnMinus().setActionCommand("Minus");
		
		// BOtones ProveedoresPanel
		mw.getPp().getBtnBack().addActionListener(this);
		mw.getPp().getBtnBack().setActionCommand("provBack");

		mw.getPp().getBtnAdd().addActionListener(this);
		mw.getPp().getBtnAdd().setActionCommand("provAdd");

		mw.getPp().getBtnEdit().addActionListener(this);
		mw.getPp().getBtnEdit().setActionCommand("provEdit");

		mw.getPp().getBtnDelete().addActionListener(this);
		mw.getPp().getBtnDelete().setActionCommand("provDelete");
		
//		mw.getPp().getBtnX().addActionListener(this);
//		mw.getPp().getBtnX().setActionCommand("Cerrar");
//		
//		mw.getPp().getBtnMinus().addActionListener(this);
//		mw.getPp().getBtnMinus().setActionCommand("Minus");


		// Botones ProveedorNuevoWindow
		mw.getPw().getBtnAdd().addActionListener(this);
		mw.getPw().getBtnAdd().setActionCommand("newProvAdd");

		mw.getPw().getBtnBack().addActionListener(this);
		mw.getPw().getBtnBack().setActionCommand("newProvBack");
		
		//Botones ProveedorEditarWindow
		mw.getPew().getBtnConfirm().addActionListener(this);
		mw.getPew().getBtnConfirm().setActionCommand("editProvConfirm");

		mw.getPew().getBtnBack().addActionListener(this);
		mw.getPew().getBtnBack().setActionCommand("editProvBack");

		// Botones VentasPanel
		mw.getVp().getBtnBack().addActionListener(this);
		mw.getVp().getBtnBack().setActionCommand("venBack");

		mw.getVp().getBtnNuevaVenta().addActionListener(this);
		mw.getVp().getBtnNuevaVenta().setActionCommand("venAdd");
		
//		mw.getVp().getBtnX().addActionListener(this);
//		mw.getVp().getBtnX().setActionCommand("Cerrar");
//		
//		mw.getVp().getBtnMinus().addActionListener(this);
//		mw.getVp().getBtnMinus().setActionCommand("Minus");

		// Botones VentaNuevaWindow
		mw.getVw().getBtnAdd().addActionListener(this);
		mw.getVw().getBtnAdd().setActionCommand("newVenAdd");

		mw.getVw().getBtnBack().addActionListener(this);
		mw.getVw().getBtnBack().setActionCommand("newVenBack");

		// Botones ComprasPanel
		mw.getCp().getBtnBack().addActionListener(this);
		mw.getCp().getBtnBack().setActionCommand("comBack");

		// Botones GastosPanel
		mw.getGp().getBtnBack().addActionListener(this);
		mw.getGp().getBtnBack().setActionCommand("gasBack");
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub

		switch (e.getActionCommand()) {

		// Botones OptionPanel
		case "Inventario": {
			mw.getOp().setVisible(false);
			mw.getIp().setVisible(true);

			producDao.readAll();
			
			for(ProductoDTO p : producDao.getProductos()) {
				Object row[] = { 
						p.getIdProducto(), 
						p.getNombreProducto(),
						p.getMarcaProducto(),
						p.getStockProducto(),
						p.getCostoProducto(),
						p.getPrecioProducto(),
						p.getNombreProveedor(),
				};
				mw.getIp().getModel().addRow(row);
			}

			break;
		}

		//cambios
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
		
		case "OptOk":{
			mw.getOpi().setVisible(false);
			break;
		}
		
		case "Cerrar":{
			System.exit(0);
			break;
		}
		
		case "Minus":{
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

		case "invProveedores": {
			mw.getIp().setVisible(false);
			mw.getPp().setVisible(true);
			
			provDao.readAll();

			for (ProveedorDTO p : provDao.getProveedores()) {
				Object row[] = { 
						p.getIdProveedor(), 
						p.getNombreProveedor(),
						p.getTipoDocumentoProveedor(),
						p.getDocumentoProveedor(), 
						p.getTelefonoProveedor(),
						p.getDireccionProveedor()
				};
				mw.getPp().getModel().addRow(row);
			}
			break;
		}

		// Botones ProveedoresPanel

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

		case "provEdit": {
			mw.getPew().setVisible(true);
			
			int selectedRow = mw.getPp().getTableProveedores().getSelectedRow();
			int id = (Integer) mw.getPp().getTableProveedores().getValueAt(selectedRow, 0);
			
			mw.getPew().getTxtNombre().setText((String) mw.getPp().getTableProveedores().getValueAt(selectedRow, 1));
			mw.getPew().getTxtDocumento().setText((String) mw.getPp().getTableProveedores().getValueAt(selectedRow, 3));
			mw.getPew().getTxtTelefono().setText((String) mw.getPp().getTableProveedores().getValueAt(selectedRow, 4));
			mw.getPew().getTxtDireccion().setText((String) mw.getPp().getTableProveedores().getValueAt(selectedRow, 5));
			
			break;
		}
		
		case "provDelete":{
			int selectedRow = mw.getPp().getTableProveedores().getSelectedRow();
		
			int id = (Integer) mw.getPp().getTableProveedores().getValueAt(selectedRow, 0);
			
			provDao.deleteById(id);
			if(JOptionPane.showConfirmDialog(mw, "Seguro que desea eliminarlo?")== 0) {
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

			provDao.create(nombre, tipoDocumento, documento, telefono, direccion);
			
			provDao.readAll();
		    ProveedorDTO nuevoProveedor = provDao.getProveedores().get(provDao.getProveedores().size() - 1);
		    
			mw.getPp().getModel().addRow(new Object[] {
			        nuevoProveedor.getIdProveedor(),
			        nuevoProveedor.getNombreProveedor(),
			        nuevoProveedor.getTipoDocumentoProveedor(),
			        nuevoProveedor.getDocumentoProveedor(),
			        nuevoProveedor.getTelefonoProveedor(),
			        nuevoProveedor.getDireccionProveedor()
			});
			
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
		
		//Botones ProveedorEditarWindow
		case "editProvConfirm": {
		    int selectedRow = mw.getPp().getTableProveedores().getSelectedRow();

		    // Verificar si hay una fila seleccionada
		    if (selectedRow == -1) {
		        JOptionPane.showMessageDialog(null, "Por favor, selecciona un proveedor para editar.");
		        break;
		    }

		    int id = (Integer) mw.getPp().getTableProveedores().getValueAt(selectedRow, 0);
		    
		    String nombre = mw.getPew().getTxtNombre().getText();
		    String tipoDocumento = (String) mw.getPew().getTxtTipoDocumento().getSelectedItem();
		    String documento = mw.getPew().getTxtDocumento().getText();
		    String telefono = mw.getPew().getTxtTelefono().getText();
		    String direccion = mw.getPew().getTxtDireccion().getText();
		    
		    
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

		case "editProvBack":{
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
			break;
		}
		
		//Botones NuevaVentaWindow
		case "newVenBack":{
			mw.getVw().setVisible(false);
			break;
		}
		
		case "newVenAdd":{
			String producto = mw.getVw().getTxtProducto().getText();
	        int cantidad;
	        double precio;

	        try {
	            cantidad = Integer.parseInt(mw.getVw().getTxtCantidad().getText());
	            precio = Double.parseDouble(mw.getVw().getTxtPrecio().getText());
	        } catch (NumberFormatException i) {
	            JOptionPane.showMessageDialog(null, "Ingrese una cantidad y precio válidos.");
	            return;
	        }
	        double subTotal = cantidad * precio;
	        mw.getVw().getModel().addRow(new Object[]{producto, cantidad, precio, subTotal});
			break;
		}

		// Botones ComprasPanel
		case "comBack": {
			mw.getOp().setVisible(true);
			mw.getCp().setVisible(false);
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
