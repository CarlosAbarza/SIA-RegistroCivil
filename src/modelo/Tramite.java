package modelo;

public class Tramite {
    private String nombre;
    private String codigo;
    private String hora;

    public Tramite(String nombre, String codigo, String hora) {
        this.nombre = nombre;
        this.codigo = codigo;
        this.hora = hora;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getHora() {
        return hora;
    }

    public void setHora(String hora) {
        this.hora = hora;
    }
}