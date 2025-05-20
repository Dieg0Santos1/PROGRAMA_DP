
package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;

public class NecesidadDAO 
{
    private final Connection conexion;

    public NecesidadDAO(Connection conexion) 
    {
        this.conexion = conexion;
    }

    public void registrarNecesidad(String nombre, String apellidos, String grupo, String descripcion) 
    {
        try {
            String sql = "INSERT INTO necesidades (nombre_persona, apellidos, grupo_vulnerable, descripcion) VALUES (?, ?, ?, ?)";
            PreparedStatement ps = conexion.prepareStatement(sql);
            ps.setString(1, nombre);
            ps.setString(2, apellidos);
            ps.setString(3, grupo);
            ps.setString(4, descripcion);
            ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
