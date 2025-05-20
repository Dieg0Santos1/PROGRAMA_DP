
package modelo;

import java.sql.Connection;
import java.sql.DriverManager;

public class ConexionBD 
{
    private static ConexionBD instancia;
    private Connection conexion;

    private ConexionBD() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            conexion = DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/ods10_db", "root", "");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static ConexionBD getInstancia() {
        if (instancia == null) {
            instancia = new ConexionBD();
        }
        return instancia;
    }

    public Connection getConexion() {
        return conexion;
    }
}
