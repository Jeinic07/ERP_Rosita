package co.edu.unbosque.model;

import java.security.MessageDigest;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JOptionPane;

public class Login {

	public static boolean validarCredenciales(String usuario, String password) {
        boolean credencialesValidas = false;

        try (Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/rosita", "root", "root")) {
            // Convertir la contraseña ingresada por el usuario a su hash SHA-256
            String hashedPassword = hashPassword(password);

            String query = "SELECT * FROM usuarios WHERE UserName = ? AND passwordName = ?";
            PreparedStatement stmt = conn.prepareStatement(query);
            stmt.setString(1, usuario);
            stmt.setString(2, hashedPassword);

            ResultSet rs = stmt.executeQuery();
            credencialesValidas = rs.next(); // Si hay un resultado, las credenciales son válidas
        } catch (Exception e) {
            e.printStackTrace();
        }

        return credencialesValidas;
    }

    public static String hashPassword(String password) throws Exception {
        MessageDigest md = MessageDigest.getInstance("SHA-256");
        byte[] hash = md.digest(password.getBytes("UTF-8"));
        StringBuilder hexString = new StringBuilder();

        for (byte b : hash) {
            String hex = Integer.toHexString(0xff & b);
            if (hex.length() == 1) hexString.append('0');
            hexString.append(hex);
        }
        return hexString.toString();
    }
    
    public static boolean validarRespuestaSeguridad(String respuesta) {
        boolean respuestaCorrecta = false;

        try (Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/rosita", "root", "root")) {
            // Consulta para obtener la respuesta de seguridad del usuario
            String query = "SELECT pregunta_seguridad FROM usuarios WHERE id = ?";
            PreparedStatement stmt = conn.prepareStatement(query);
            stmt.setInt(1, 1); // ID del usuario, ajústalo según sea necesario

            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                String respuestaGuardada = rs.getString("pregunta_seguridad");

                // Comparamos la respuesta ingresada con la almacenada en la base de datos
                if (respuesta.equalsIgnoreCase(respuestaGuardada)) {
                    respuestaCorrecta = true;
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return respuestaCorrecta;
    }


}
