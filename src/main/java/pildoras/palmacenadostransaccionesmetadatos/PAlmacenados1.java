package pildoras.palmacenadostransaccionesmetadatos;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;


public class PAlmacenados1 {

    private static final String URL = "jdbc:mysql://localhost:3306/gestionpedidos";
    private static final String USER = "root";
    private static final String PASSWORD = "";

    public static void main(String[] args) {
        try {
            Connection miConexion = DriverManager.getConnection(URL, USER, PASSWORD);
            //Llamada al procedimiento almacenado creado en phpMyAdmin
            //La sentencia SQL está en el servidor. Ventajas: reutilizar código, velocidad de respuesta, evitar errores...
            CallableStatement miCallableStatement = miConexion.prepareCall("{call MUESTRAPAISES}");
            
            ResultSet rs = miCallableStatement.executeQuery();
            
            while (rs.next()){
                System.out.println(rs.getString(2) + " " + rs.getString(3) + " " + rs.getString(8));
            }
            
            rs.close();
            miConexion.close();
            
        } catch (SQLException ex) {
            Logger.getLogger(PAlmacenados1.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
