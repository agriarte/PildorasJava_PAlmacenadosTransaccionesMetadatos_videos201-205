package pildoras.palmacenadostransaccionesmetadatos;

import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Inserta_Clientes_Pedidos {

    private static final String URL = "jdbc:mysql://localhost:3306/gestionpedidos";
    private static final String USER = "root";
    private static final String PASSWORD = "";

    public static void main(String[] args) {

        Connection miConexion = null;

        try {

            miConexion = DriverManager.getConnection(URL, USER, PASSWORD);

            // Inserción de datos mediante "transacción". Por defecto, las sentencias SQL se ejecutan de 
            //manera individual, pero existe una técnica para ejecutar conjuntos de sentencias en bloque.
            // Cambiando el valor setAutoCommit a "false", todas las sentencias se ejecutan en bloque hasta 
            //que se realiza el commit. Si alguna de ellas no se puede completar por cualquier motivo, se 
            //revierten todas al estado original.
            // En otras palabras, se ejecutan todas o ninguna.
            miConexion.setAutoCommit(false);

            Statement miStatement = miConexion.createStatement();

            String instruccionSql_1 = "INSERT INTO CLIENTES (CÓDIGOCLIENTE, EMPRESA, DIRECCIÓN) VALUES ('CT84', 'EJEMPLO', 'P BOTANICO')";

            miStatement.executeUpdate(instruccionSql_1);

            String instruccionSql_2 = "INSERT INTO PEDIDOS (NÚMERODEPEDIDO, CÓDIGOCLIENTE,FECHADEPEDIDO) VALUES('82', 'CT84', '11/03/2000')";

            miStatement.executeUpdate(instruccionSql_2);

            //
            miConexion.commit();
            System.out.println("Datos INSERTADOS correctamente");

        } catch (SQLException e1) {

            System.out.println("ERROR EN LA INSERCIÓN DE DATOS!!");

            try {
                //si hay error anular sentencias BBDD y dejar como antes
                miConexion.rollback();
            } catch (SQLException e2) {
                Logger.getLogger(Inserta_Clientes_Pedidos.class.getName()).log(Level.SEVERE, null, e2);
            }

            e1.printStackTrace();

        }

    }

}
