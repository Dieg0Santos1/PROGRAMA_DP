
package modelo;

public class UsuarioNino implements UsuarioBase 
{
    private String nombre;

    public UsuarioNino(String nombre) {
        this.nombre = nombre;
    }

    public String getNombre() { return nombre; }

    public String getTipo() { return "Niño"; }
}
