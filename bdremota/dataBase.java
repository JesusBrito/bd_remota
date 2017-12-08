package com.example.jesus.bdremota;



import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * Created by jesus on 7/12/17.
 */

public class dataBase {
    private Connection conexion;
    private String usr;
    private String cve;
    private String url;
    private String puerto="3306";
    dataBase(String svr, String bd, String usr, String cve){
        try{

            Class.forName("com.mysql.jdbc.Driver");
            System.out.println("Cargando controlador...");
            this.url = "jdbc:mysql://" + svr + ":"+puerto+ "/" + bd;
            this.cve = cve;
            this.usr = usr;
            System.out.println(url);
            conexion = DriverManager.getConnection(url, usr, cve);
            System.out.println("Conexion establecida...");

        } catch(ClassNotFoundException ex){

            System.out.println("No se pudo cargar el controlador...");
            System.out.println("Ha ocurrido un error en la Base de Datos");

        } catch(SQLException ex) {
            System.out.println("Error en la conexión a BD...");
            System.out.println("Ha ocurrido un error en la Base de Datos No se pudo conectar a la bd");
        }
    }

}
