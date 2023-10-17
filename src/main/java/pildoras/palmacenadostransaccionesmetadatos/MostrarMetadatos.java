package pildoras.palmacenadostransaccionesmetadatos;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class MostrarMetadatos {

    private static final String URL = "jdbc:mysql://localhost:3306/gestionpedidos";
    private static final String USER = "root";
    private static final String PASSWORD = "";
    static Connection miConexion = null;
    
    public static void main(String[] args) {
        mostrarInfoBBDD();
    }

    static void mostrarInfoBBDD() {

        try {
            miConexion = DriverManager.getConnection(URL, USER, PASSWORD);
            
            //Mostrar Metadatos de la BBDD
            System.out.println("DatabaseProductName: " + miConexion.getMetaData().getDatabaseProductName());
            System.out.println("DatabaseProductVersion: " + miConexion.getMetaData().getDatabaseProductVersion());
            System.out.println("DriverVersion: " + miConexion.getMetaData().getDriverVersion());
            System.out.println("DriverName: " + miConexion.getMetaData().getDriverName());
            
            
        } catch (SQLException ex) {
            Logger.getLogger(MostrarMetadatos.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                miConexion.close();
            } catch (SQLException ex) {
                Logger.getLogger(MostrarMetadatos.class.getName()).log(Level.SEVERE, null, ex);
            }
        }  
    }
}
