package co.edu.unbosque.view;

import javax.swing.*;
import java.awt.*;

public class LoginWindow extends JFrame {
	private JPanel panel;
    private JLabel foto1;
    private Icon icon1, icon2;
    private Image imagen1, imagen2;
    private JPasswordField inp_pass;
    private JButton btn_preg, btn_x, btn_inic;
    
    
    public LoginWindow() {
    	setTitle("Menú");
        setSize(800, 600);
        setLocationRelativeTo(null);
        setResizable(false);
        setUndecorated(true);

    
    }

}
