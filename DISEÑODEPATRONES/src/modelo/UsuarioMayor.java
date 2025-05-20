
package modelo;

public class UsuarioMayor implements UsuarioBase 
{
    private String nombre;

    public UsuarioMayor(String nombre) {
        this.nombre = nombre;
    }

    public String getNombre() { return nombre; }

    public String getTipo() { return "Adulto Mayor"; }
}
