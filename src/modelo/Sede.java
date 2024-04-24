package modelo;

import java.time.LocalTime;
import java.util.*;

public class Sede {
    private String codigo;
    private String ciudad;
    private LocalTime horaInicio;
    private LocalTime horaCierre;
    private ContenedorTramite documento;

    public Sede(String codigo, String ciudad) {
        this.codigo = codigo;
        this.ciudad = ciudad;
        this.horaInicio = LocalTime.parse("08:30:00");
        this.horaCierre = LocalTime.parse("14:00:00");
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

    public LocalTime getHoraInicio() {
        return horaInicio;
    }

    public void setHoraInicio(String horaInicio) {
        this.horaInicio = LocalTime.parse(horaInicio);
    }

    public LocalTime getHoraCierre() {
        return horaCierre;
    }

    public void setHoraCierre(String horaCierre) {
        this.horaCierre = LocalTime.parse(horaCierre);
    }

    public Tramite getDocumento(int i) {
        return documento.getTramite(i);
    }
    
    public Tramite getDocumento(String codigo) {
        return documento.getTramite(codigo);
    }
    
    public boolean setDocumento(Tramite documento) {
        return this.documento.setTramite(documento);
    }
    
    public int getCantDocumento() {
        return documento.getLargo();
    }
}