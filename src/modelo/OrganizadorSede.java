package modelo;

import Exceptions.FormatoHoraException;
import Exceptions.RangoHorarioException;
import Exceptions.SedeNoEncontradaException;
import Exceptions.TipoSedeException;
import java.util.*;

public class OrganizadorSede {
    private ArrayList<Sede> listado;
    private Hashtable<String, Sede> mapa;

    public OrganizadorSede() {
        this.listado = new ArrayList<>();
        this.mapa = new Hashtable<>();
    }
    
    public Sede getSede(String codigo) {
        return mapa.get(codigo);
    }
    
    public Iterator<Sede> getSede() {
        return listado.iterator();
    }
    
    public int getCantidadSede() {
        return listado.size();
    }
    
    public Sede getSede(int i) {
        return listado.get(i);
    }
    
    public void setSede(String codigo, String ciudad, int tipo) {
        Sede ss;
        if (tipo == 0) {
            ss = new SedeCertificados(codigo, ciudad);
        }
        else {
            ss = new SedeDocumento(codigo, ciudad);
        }
        mapa.put(codigo, ss);
        listado.add(ss);
    }
    
    public void setSede(Sede nuevo) {
        listado.add(nuevo);
        mapa.put(nuevo.getCodigo(), nuevo);
    }
    
    public int setTramite(String codigo, Tramite documento, int tipo) throws TipoSedeException {
        Sede temp = mapa.get(codigo);
        if (temp == null) {
            return 0;
        }
        else if (temp.setDocumento(documento, tipo)) {
            return 1;
        }
        else {
            return -1;
        }
    }
    
    public void setTramite(String codigoS, String nombre, String codigoT, String hora, int tipo)
            throws FormatoHoraException, RangoHorarioException, SedeNoEncontradaException, TipoSedeException {
        Tramite tt = new Tramite(nombre, codigoT, hora);
        Sede temp = mapa.get(codigoS);
        if (temp == null) {
            throw new SedeNoEncontradaException();
        }
        temp.setDocumento(tt, tipo);
    }
    
    public Tramite getDocumento(String codigo, int i) {
        Sede aux = mapa.get(codigo);
        if (aux != null) {
            return aux.getDocumento(i);
        }
        return null;
    }
    
    public int getCantDocumento(String codigo) {
        Sede ss = mapa.get(codigo);
        if (ss != null){
            return ss.getCantDocumento();
        }
        return -1;
    }
}
