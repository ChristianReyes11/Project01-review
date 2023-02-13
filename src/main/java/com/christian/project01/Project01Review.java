/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Project/Maven2/JavaApp/src/main/java/${packagePath}/${mainClassName}.java to edit this template
 */

package com.christian.project01;

import java.sql.Statement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author chris
 */
public class Project01Review {

    public static void main(String[] args) {
        Connection con=null;
        Statement st= null;
        try {
            String sql="insert into empleados (clave, nombre, direccion, telefono) values"
                    + "('01', 'Christian', 'av 20', '2721344053')";
            String url = "jdbc:postgresql://localhost:5432/ejemplo";
            String user = "postgres";
            String pwd = "admin";
            con= DriverManager.getConnection(url, user, pwd);
            Logger.getLogger(Project01Review.class.getName()).log(Level.INFO, "Se conectó..." );
            st= con.createStatement();
            st.execute(sql);
            Logger.getLogger(Project01Review.class.getName()).log(Level.INFO, "Se  guardo...");
            
        } catch (SQLException ex) {
            Logger.getLogger(Project01Review.class.getName()).log(Level.SEVERE, null, ex);
        }
        finally{
            try {
                if(st!=null)
                    st.close();
            } catch (SQLException ex) {
                Logger.getLogger(Project01Review.class.getName()).log(Level.SEVERE, null, ex);
            }
            try {
                if(con!=null)
                    con.close();
            } catch (SQLException ex) {
                Logger.getLogger(Project01Review.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
}
