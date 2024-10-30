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

		// Botones Ventana Principal
		mw.getBtnInventario().addActionListener(this);
		mw.getBtnInventario().setActionCommand("mwInventario");

		mw.getBtnCompras().addActionListener(this);
		mw.getBtnCompras().setActionCommand("mwCompras");

		mw.getBtnVentas().addActionListener(this);
		mw.getBtnVentas().setActionCommand("mwVentas");

		mw.getBtnGastos().addActionListener(this);
		mw.getBtnGastos().setActionCommand("mwGastos");

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub

		switch (e.getActionCommand()) {

		case "mwInventario": {

			break;
		}

		case "mwVentas": {

		}

		case "mwCompras": {

			break;
		}

		case "mwGastos": {

			break;
		}

		}
	}

}
