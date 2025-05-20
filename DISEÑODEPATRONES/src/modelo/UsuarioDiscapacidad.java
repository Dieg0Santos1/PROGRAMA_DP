
package modelo;

public class UsuarioDiscapacidad implements UsuarioBase 
{
    private String nombre;

    public UsuarioDiscapacidad(String nombre) {
        this.nombre = nombre;
    }

    public String getNombre() { return nombre; }

    public String getTipo() { return "Discapacidad"; }
}
