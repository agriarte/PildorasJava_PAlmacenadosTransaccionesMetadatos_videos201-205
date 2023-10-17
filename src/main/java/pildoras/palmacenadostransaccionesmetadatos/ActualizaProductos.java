/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pildoras.palmacenadostransaccionesmetadatos;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 * Para crear el PROCEDIMIENTO con 2 parámetros ejecuto este código desde
 * phpMyadmin CREATE PROCEDURE ACTUALIZA_PRECIO(IN AC_ARTICULO VARCHAR(19), IN
 * AC_PRECIO VARCHAR(7)) UPDATE productos SET PRECIO = AC_PRECIO WHERE ARTICULO
 * = AC_ARTICULO;
 */
public class ActualizaProductos {

    private static final String URL = "jdbc:mysql://localhost:3306/gestionpedidos";
    private static final String USER = "root";
    private static final String PASSWORD = "";

    public static void main(String[] args) {

        //Crear 2 ActionPane que pregunten nombre de producto y precio para actualizar
        String miNombre = JOptionPane.showInputDialog("Introduce el nombre del artículo");
        String miPrecio = JOptionPane.showInputDialog("Introduce el nuevo precio: ");
        try {
            Connection miConexion = DriverManager.getConnection(URL, USER, PASSWORD);
            //Llamada al procedimiento almacenado creado en phpMyAdmin
            //La diferencia con ejercicio anterior son los 2 parámetros
            CallableStatement miCallableStatement = miConexion.prepareCall("{call ACTUALIZA_PRECIO( ?, ?)}");
            miCallableStatement.setString(1, miNombre);
            miCallableStatement.setString(2, miPrecio);
            //ejecutar sentencia
            miCallableStatement.execute();

            System.out.println("Registro actualizado");

        } catch (SQLException ex) {
            Logger.getLogger(PAlmacenados1.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
