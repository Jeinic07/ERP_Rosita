package co.edu.unbosque.view;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ProveedoresEditarWindow extends JPanel {

    private JTextField idField;
    private JButton okButton;
    private JPanel infoPanel;
    private JLabel infoLabel;

    public ProveedoresEditarWindow() {
        setLayout(new BorderLayout());

        // Panel superior para entrada de ID
        JPanel idPanel = new JPanel();
        idPanel.setLayout(new GridLayout(2, 1, 5, 5));
        idPanel.setBorder(BorderFactory.createTitledBorder("Entrada de ID"));

        idField = new JTextField();
        okButton = new JButton("OK");

        idPanel.add(new JLabel("Ingrese la ID:"));
        idPanel.add(idField);
        idPanel.add(okButton);

        // Panel inferior para mostrar la información (inicialmente invisible)
        infoPanel = new JPanel();
        infoPanel.setLayout(new BorderLayout());
        infoPanel.setBorder(BorderFactory.createTitledBorder("Información"));
        infoPanel.setVisible(false);  // Ocultar infoPanel inicialmente

        infoLabel = new JLabel("Información del producto/proveedor aparecerá aquí.");
        infoPanel.add(infoLabel, BorderLayout.CENTER);

        // Agregar ambos paneles al panel principal
        add(idPanel, BorderLayout.NORTH);
        add(infoPanel, BorderLayout.CENTER);

        // Acción para mostrar el infoPanel cuando se presiona "OK"
        okButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				mostrarInformacion();
			}
		});
    }

    private void mostrarInformacion() {
        String id = idField.getText();
        if (id != null && !id.isEmpty()) {
            infoLabel.setText("Información para ID: " + id);
            infoPanel.setVisible(true);
        } else {
            JOptionPane.showMessageDialog(this, "Por favor, ingrese una ID válida.", "Advertencia", JOptionPane.WARNING_MESSAGE);
        }
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("Inventario");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(800, 600);

        ProveedoresEditarWindow inventarioPanel = new ProveedoresEditarWindow();
        frame.add(inventarioPanel);

        frame.setVisible(true);
    }
}
