
package controlador;

import dao.NecesidadDAO;
import modelo.ConexionBD;

public class ControladorNecesidad 
{
    private final NecesidadDAO dao;

    public ControladorNecesidad() 
    {
        dao = new NecesidadDAO(ConexionBD.getInstancia().getConexion());
    }

    public void registrar(String nombre, String apellidos, String grupo, String descripcion) 
    {
        dao.registrarNecesidad(nombre, apellidos, grupo, descripcion);
    }
}
