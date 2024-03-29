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
    
    public void setSede(Sede nuevo) {
        listado.add(nuevo);
        mapa.put(nuevo.getCodigo(), nuevo);
    }
    
    public boolean setTramite(String ciudad, Tramite documento) {
        Sede temp = mapa.get(ciudad);
        if (temp == null) {
            return false;
        }
        temp.setDocumento(documento);
        return true;
    }
}
