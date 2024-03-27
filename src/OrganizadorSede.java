import java.util.*;

public class OrganizadorSede {
    private ArrayList<Sede> listado;
    private Hashtable<String, Sede> mapa;

    public OrganizadorSede() {
        this.listado = new ArrayList<>();
        this.mapa = new Hashtable<>();
    }
    
    public Sede buscarCiudad(String name) {
        return mapa.get(name);
    }
    
    public void agregar(Sede nuevo) {
        listado.add(nuevo);
        mapa.put(nuevo.codigo, nuevo);
    }
    
    public void agregar(String ciudad, Tramite documento) {
        Sede temp = mapa.get(ciudad);
        temp.setDocumentos(documento);
    }
}
