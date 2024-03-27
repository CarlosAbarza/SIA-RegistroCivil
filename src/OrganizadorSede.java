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
    
    public void agregar(Sede nuevo) {
        listado.add(nuevo);
        mapa.put(nuevo.getCodigo(), nuevo);
    }
    
    public void agregar(String ciudad, Tramite documento) {
        Sede temp = mapa.get(ciudad);
        temp.setDocumentos(documento);
    }
}
