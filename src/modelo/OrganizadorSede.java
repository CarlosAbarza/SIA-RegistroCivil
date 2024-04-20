package modelo;

import modelo.Tramite;
import modelo.Sede;
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
    
    public void setSede(String codigo, String ciudad) {
        Sede ss = new Sede(codigo, ciudad);
        mapa.put(codigo, ss);
        listado.add(ss);
    }
    
    public void setSede(Sede nuevo) {
        listado.add(nuevo);
        mapa.put(nuevo.getCodigo(), nuevo);
    }
    
    public int setTramite(String codigo, Tramite documento) {
        Sede temp = mapa.get(codigo);
        if (temp == null) {
            return 0;
        }
        else if (temp.setDocumento(documento)) {
            return 1;
        }
        else {
            return -1;
        }
    }
    
    public int setTramite(String codigoS, String nombre, String codigoT, String hora) {
        Tramite tt = new Tramite(nombre, codigoT, hora);
        Sede temp = mapa.get(codigoS);
        if (temp == null) {
            return 0;
        }
        else if (temp.setDocumento(tt)) {
            return 1;
        }
        else {
            return -1;
        }
    }
    
    public Iterator<Tramite> getDocumento(String codigo) {
        Sede aux = mapa.get(codigo);
        if (aux != null) {
            return aux.getDocumento();
        }
        return null;
    }
}
