import java.io.*;
import java.util.*;


public class ProyectoSIA {
    public static void main(String[] args) throws IOException {
        OrganizadorSede registros = new OrganizadorSede();
        
        BufferedReader lector = new BufferedReader(new InputStreamReader(System.in));
        String opcion;
        boolean bucle = true;
        
        // Instanciacion de auxiliares
        Sede auxSede;
        Tramite auxTram;
        String auxCodS, auxCityS;
        String auxNameT, auxCodT, auxHoraT;
        
        while (bucle) {
            System.out.println("Menú");
            System.out.println("Que desea hacer?");
            System.out.println("1. Agregar una Sede (Manual)");
            System.out.println("2. Agregar un tramite realizado (Manual)");
            System.out.println("3. Listar los tramites de una Sede");
            // System.out.println("4. Prestar");
            System.out.println("4. Salir\n");

            opcion = lector.readLine();
            if (opcion == null || opcion.isEmpty()) {
                System.out.println("No ingreso ninguna opción\n");
                opcion = "0";
            }

            switch(opcion.toLowerCase()) {
                case "1" -> {
                    System.out.println("Ingrese el codigo de la Sede: ");
                    auxCodS = lector.readLine();
                    System.out.println("Ingrese el nombre de la Sede: ");
                    auxCityS = lector.readLine();
                    
                    if (registros.getSede(auxCodS) == null) {
                        registros.agregar(new Sede(auxCodS, auxCityS));
                    }
                    else {
                        System.out.println("Ya existe una Sede con ese codigo\n");
                    }
                }
                
                case "2" -> {
                    // Agregar un tramite
                    System.out.println("Ingrese el codigo del tramite: ");
                    auxCodT = lector.readLine();
                    System.out.println("Ingrese el nombre: ");
                    auxNameT = lector.readLine();
                    System.out.println("Ingrese la hora en que se realizo: ");
                    auxHoraT = lector.readLine();
                    
                    System.out.println("Ingrese el codigo de la sede en que se realizo: ");
                    auxCodS = lector.readLine();
                    
                    auxSede = registros.getSede(auxCodS);
                    if (auxSede == null) {
                        System.out.println("No se ha registrado la Sede\n");
                    }
                    else {
                        if (auxSede.getDocumento(auxCodT) == null) {
                            auxSede.setDocumento(new Tramite(auxNameT, auxCodT, auxHoraT));
                        }
                        else {
                            System.out.println("Ya existe un tramite con ese codigo\n");
                        }
                    }
                }
                
                case "3" -> {
                    // Mostrar todos los tramites realizados en la Sede
                    System.out.println("Ingrese el codigo de la Sede");
                    auxCodS = lector.readLine();
                    
                    auxSede = registros.getSede(auxCodS);
                    if (auxSede != null) {
                        // auxSede.mostrarTramites();
                        
                        Iterator<Tramite> it = auxSede.getDocumento();
                        
                        while (it.hasNext()) {
                            auxTram = it.next();
                            System.out.println("Codigo: " + auxTram.getCodigo());
                            System.out.println("Nombre: " + auxTram.getNombre());
                            System.out.println("Hora: " + auxTram.getHora() + "\n");
                        }
                    }
                    else {
                        System.out.println("No existe una Sede con ese codigo");
                    }
                }
                
                case "4" -> {
                    System.out.println("Hasta luego");
                    bucle = false;
                }
                
                default -> {
                    System.out.println("Opción invalida\nIntenta de nuevo\n\n");
                }
            }
        }
    }
    
}
