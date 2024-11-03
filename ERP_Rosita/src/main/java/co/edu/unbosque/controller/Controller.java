package co.edu.unbosque.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import co.edu.unbosque.view.MainWindow;

public class Controller implements ActionListener {

	private MainWindow mw;

	public Controller() {
		mw = new MainWindow();
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

		// Botones InventarioPanel
		mw.getIp().getBtnBack().addActionListener(this);
		mw.getIp().getBtnBack().setActionCommand("invBack");
		
		mw.getIp().getBtnProveedores().addActionListener(this);
		mw.getIp().getBtnProveedores().setActionCommand("invProveedores");
		
		//BOtones ProveedoresPanel
		mw.getPp().getBtnBack().addActionListener(this);
		mw.getPp().getBtnBack().setActionCommand("provBack");
		
		mw.getPp().getBtnAdd().addActionListener(this);
		mw.getPp().getBtnAdd().setActionCommand("provAdd");
		
		mw.getPp().getBtnEdit().addActionListener(this);
		mw.getPp().getBtnEdit().setActionCommand("provEdit");
		
		//Botones ProveedorNuevoWindow
		mw.getPw().getBtnAdd().addActionListener(this);
		mw.getPw().getBtnAdd().setActionCommand("newProvAdd");
		
		mw.getPw().getBtnBack().addActionListener(this);
		mw.getPw().getBtnBack().setActionCommand("newProvBack");
		
		//Botones VentasPanel
		mw.getVp().getBtnBack().addActionListener(this);
		mw.getVp().getBtnBack().setActionCommand("venBack");
		
		
		//Botones ComprasPanel
		mw.getCp().getBtnBack().addActionListener(this);
		mw.getCp().getBtnBack().setActionCommand("comBack");
		
		//Botones GastosPanel
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
			break;
		}

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

		// Botones InventarioPanel
		case "invBack": {
			mw.getOp().setVisible(true);
			mw.getIp().setVisible(false);
			break;
		}
		
		case "invProveedores":{
			mw.getIp().setVisible(false);
			mw.getPp().setVisible(true);
			break;
		}
		
		//Botones ProveedoresPanel
		
		case "provBack":{
			mw.getPp().setVisible(false);
			mw.getIp().setVisible(true);
			break;
		}
		case "provAdd":{
			mw.getPw().setVisible(true);
			break;
		}
		
		case "provEdit":{
			
			break;
		}
		
		//Botones ProveedorNuevoAdd
		
		case "newProvAdd":{

			break;
		}
		
		case "newProvBack":{
			mw.getPw().setVisible(false);
			break;
		}
		// Botones VentasPanel
		case "venBack": {
			mw.getOp().setVisible(true);
			mw.getVp().setVisible(false);
			break;
		}
		
		//Botones ComprasPanel
		case "comBack": {
			mw.getOp().setVisible(true);
			mw.getCp().setVisible(false);
			break;
		}
		
		//Botones GastosPanel
		case "gasBack": {
			mw.getOp().setVisible(true);
			mw.getGp().setVisible(false);
			break;
		}
		}
	}

}
