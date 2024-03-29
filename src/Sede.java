import java.util.*;

public class Sede {
    private String codigo;
    private String ciudad;
    private String horaInicio;
    private String horaCierre;
    private ContenedorTramite documento;

    public Sede(String codigo, String ciudad) {
        this.codigo = codigo;
        this.ciudad = ciudad;
        this.horaInicio = "8:30";
        this.horaCierre = "2:00";
        this.documento = new ContenedorTramite();
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getCiudad() {
        return ciudad;
    }

    public void setCiudad(String ciudad) {
        this.ciudad = ciudad;
    }

    public String getHoraInicio() {
        return horaInicio;
    }

    public void setHoraInicio(String horaInicio) {
        this.horaInicio = horaInicio;
    }

    public String getHoraCierre() {
        return horaCierre;
    }

    public void setHoraCierre(String horaCierre) {
        this.horaCierre = horaCierre;
    }

    public Iterator<Tramite> getDocumento() {
        return documento.getTramite();
    }
    
    public Tramite getDocumento(String codigo) {
        return documento.getTramite(codigo);
    }

    /*public void setDocumento(Hashtable<String, Tramite> documento) {
        this.documento = documento;
    }*/
    
    public void setDocumento(Tramite documento) {
        this.documento.setTramite(documento);
    }
    
    public void mostrarTramites() {
        System.out.println("Tramites ingresados en la Sede " + codigo);
        documento.mostrar();
    }
}