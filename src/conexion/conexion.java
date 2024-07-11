/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package conexion;

import java.sql.Connection;
import java.sql.DriverManager;

public class conexion {
    
    Connection con;

    public conexion() {
        
        String url = "jdbc:mysql://dbconsulta.cj62oee20fk1.us-east-1.rds.amazonaws.com:3306/pacientes_db";
        String usuario = "erikson";
        String password = "%Erikson42011dias";
        
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            con = DriverManager.getConnection(url, usuario, password);
            System.out.println("conexion exitosa");
        } catch (Exception e) {
            System.out.println("error de base de dato" + e);
        }
        
        
    }

    public Connection getCon() {
        return con;
    }
    
    public static void main (String[]args){
        conexion ob1 = new conexion();
        ob1.getCon();
    }
    
    
}