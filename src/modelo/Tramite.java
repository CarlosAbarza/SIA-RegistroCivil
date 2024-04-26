package modelo;

import Exceptions.FormatoHoraException;
import Exceptions.RangoHorarioException;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeParseException;

public class Tramite {
    private String nombre;
    private String codigo;
    private LocalDateTime hora;

    public Tramite(String nombre, String codigo, String hora) 
            throws FormatoHoraException, RangoHorarioException {
        try {
            this.nombre = nombre;
            this.codigo = codigo;
            this.hora = LocalDateTime.parse(hora);
            
            if (this.hora.toLocalTime().isBefore(LocalTime.parse("08:30:00")) ||
                this.hora.toLocalTime().isAfter(LocalTime.parse("14:00:00"))) {
                throw new RangoHorarioException();
            }
        }
        catch (DateTimeParseException e) {
            throw new FormatoHoraException();
        }
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

    public LocalDateTime getHora() {
        return hora;
    }

    public void setHora(String hora) throws FormatoHoraException, RangoHorarioException {
        try {
            this.hora = LocalDateTime.parse(hora);
            if (this.hora.toLocalTime().isBefore(LocalTime.parse("08:30:00")) ||
                this.hora.toLocalTime().isAfter(LocalTime.parse("14:00:00"))) {
                throw new RangoHorarioException();
            }
        }
        catch (DateTimeParseException e) {
            throw new FormatoHoraException();
        }
    }
    
    public boolean dentroRango(LocalDateTime inicio, LocalDateTime cierre) {
        return hora.isAfter(inicio) && hora.isBefore(cierre);
    }
}