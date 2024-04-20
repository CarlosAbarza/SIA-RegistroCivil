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
    
    public void setSede(Sede nuevo) {
        listado.add(nuevo);
        mapa.put(nuevo.getCodigo(), nuevo);
    }
    
    public int setTramite(String ciudad, Tramite documento) {
        Sede temp = mapa.get(ciudad);
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
    
    public Iterator<Tramite> getDocumento(String codigo) {
        Sede aux = mapa.get(codigo);
        if (aux != null) {
            return aux.getDocumento();
        }
        return null;
    }
}
