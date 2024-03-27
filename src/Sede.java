import java.util.*;

public class Sede {
    String codigo;
    String ciudad;
    String horaInicio;
    String horaCierre;
    Hashtable<String, Tramite> documentos;

    public Sede(String codigo, String ciudad) {
        this.codigo = codigo;
        this.ciudad = ciudad;
        this.horaInicio = "8:30";
        this.horaCierre = "2:00";
        this.documentos = new Hashtable<>();
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

    public Hashtable<String, Tramite> getDocumentos() {
        return documentos;
    }

    public void setDocumentos(Hashtable<String, Tramite> documentos) {
        this.documentos = documentos;
    }
    
    public void setDocumentos(Tramite documento) {
        this.documentos.put(documento.getCodigo(), documento);
    }
}