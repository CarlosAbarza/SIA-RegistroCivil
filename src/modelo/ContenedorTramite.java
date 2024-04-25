package modelo;

import Exceptions.TramiteNoEncontradoException;
import modelo.Tramite;
import java.util.*;

public class ContenedorTramite {
    private Hashtable<String, Tramite> mapa;
    private ArrayList<Tramite> lista;

    public ContenedorTramite() {
        this.mapa = new Hashtable<>();
        this.lista = new ArrayList<>();
    }

    public Tramite getTramite(String codigo) {
        return mapa.get(codigo);
    }
    
    public Tramite getTramite(int i) {
        return lista.get(i);
    }
    
    public boolean setTramite(Tramite nuevo) {
        if (mapa.get(nuevo.getCodigo()) == null) { 
            mapa.put(nuevo.getCodigo(), nuevo);
            lista.add(nuevo);
            return true;
        }
        else {
            return false;
        }
    }
    
    public int getLargo() {
        return lista.size();
    }
    
    public void eliminarDocumento(String codigo) throws TramiteNoEncontradoException {
        if (mapa.containsKey(codigo)){
            lista.remove(mapa.remove(codigo));
        }
        else {
            throw new TramiteNoEncontradoException();
        }
    }
}
