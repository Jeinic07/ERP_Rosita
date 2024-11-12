package co.edu.unbosque.ERP_Rosita;

import org.junit.jupiter.api.Test;

import co.edu.unbosque.model.Login;

import static org.junit.jupiter.api.Assertions.*;

public class LoginTest {

    // Prueba básica para verificar si el hash de la contraseña es generado correctamente.
    @Test
    void testHashPassword() throws Exception {
        // La contraseña original que vamos a usar para probar
        String password = "password123";
        
        // Llamamos al método hashPassword que se supone que genera el hash
        String hashedPassword = Login.hashPassword(password);

        // Verificamos que el hash no sea nulo
        assertNotNull(hashedPassword, "El hash de la contraseña no debería ser nulo.");
        
        // Verificamos que el hash generado sea diferente de la contraseña original
        assertNotEquals(password, hashedPassword, "El hash debería ser diferente a la contraseña original.");
    }
}
