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
    
    public void setTramite(Tramite nuevo) {
        mapa.put(nuevo.getCodigo(), nuevo);
        lista.add(nuevo);
    }
    
    public void mostrar() {
        for (Tramite doc : lista) {
            System.out.println("Codigo: " + doc.getCodigo());
            System.out.println("Nombre: " + doc.getNombre());
            System.out.println("Hora: " + doc.getHora() + "\n");
        }
    }
}
