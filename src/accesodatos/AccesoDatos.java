/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package accesodatos;


import java.sql.*;
import java.sql.Connection;
import java.sql.DriverManager;
/**
 *
 * @author Sergio
 */
public class AccesoDatos {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        try{
            Connection conexion = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521/xe", "DAM", "DAM");
            
            Statement st = conexion.createStatement();
            //st.executeUpdate("CREATE TABLE contacto (id INT,PRIMARY KEY(id), nombre VARCHAR(20), apellidos VARCHAR(20),telefono VARCHAR(20))");
            ResultSet rs = st.executeQuery("SELECT * FROM contacto");
            while (rs.next()){
                System.out.println("nombre="+rs.getObject("nombre")+
                ", apellidos="+rs.getObject("apellidos")+
                ", telefono="+rs.getObject("telefono"));
            }
            rs.close();

        
        }
        catch (Exception e){
            System.out.println(e.toString());
        }
        
        
    }
    
}
