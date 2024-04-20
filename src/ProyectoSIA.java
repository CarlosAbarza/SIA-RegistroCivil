// <<<<<<< HEAD
import modelo.OrganizadorSede;
import modelo.Tramite;
import modelo.Sede;
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
        Iterator<Tramite> trams;
        Iterator<Sede> sedes;
        
        // Precarga de datos
        CSV csv = new CSV("sedes");
        String linea;
        csv.firstLine();
        while ((linea = csv.nextLine()) != null) {
            String[] elem = linea.split(",");
            registros.setSede(new Sede(elem[1], elem[0]));
        }
        
        csv = new CSV("tramitesPrecargados");
        csv.firstLine();
        while ((linea = csv.nextLine()) != null) {
            String[] elem = linea.split(",");
            registros.setTramite(elem[3], new Tramite(elem[1], elem[0], elem[2]));
        }
        
        while (bucle) {
            System.out.println("Menú");
            System.out.println("Que desea hacer?");
            System.out.println("1. Agregar una Sede (Manual)");
            System.out.println("2. Agregar un tramite realizado (Manual)");
            System.out.println("3. Listar los tramites de una Sede");
            System.out.println("4. Listar Sedes con sus tramites");
            System.out.println("5. Salir\n");

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
                        registros.setSede(new Sede(auxCodS, auxCityS));
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
                    
                    int temp = registros.setTramite(auxCodS, new Tramite(auxNameT, auxCodT, auxHoraT));
                    if (temp == 0) {
                        System.out.println("No se ha registrado la Sede\n");
                    }
                    else if (temp == -1) {
                        System.out.println("Ya existe un tramite con ese codigo\n");
                    }
                }
                
                case "3" -> {
                    // Mostrar todos los tramites realizados en la Sede
                    System.out.println("Ingrese el codigo de la Sede");
                    auxCodS = lector.readLine();
                    
                    if (registros.getSede(auxCodS) != null) {
                        trams = registros.getDocumento(auxCodS);
                        if (trams.hasNext()) {
                            while (trams.hasNext()) {
                                auxTram = trams.next();
                                System.out.println("Codigo: " + auxTram.getCodigo());
                                System.out.println("Nombre: " + auxTram.getNombre());
                                System.out.println("Hora: " + auxTram.getHora() + "\n");
                            }
                        }
                        else {
                            System.out.println("No se han registrado tramites en esta Sede");
                        }
                    }
                    else {
                        System.out.println("No existe una Sede con ese codigo\n\n");
                    }
                }
                
                case "4" -> {
                    // Listar todos los tramites de todas las Sedes
                    sedes = registros.getSede();
                    if (sedes.hasNext()) {
                        while (sedes.hasNext()) {
                            auxSede = sedes.next();
                            System.out.println("Sede: " + auxSede.getCiudad());
                            System.out.println("Codigo: " + auxSede.getCodigo());

                            trams = auxSede.getDocumento();
                            if (trams.hasNext()) {
                                System.out.println("Tramites realizados:");
                                while (trams.hasNext()) {
                                    auxTram = trams.next();
                                    System.out.println("  - Codigo: " + auxTram.getCodigo());
                                    System.out.println("    Nombre: " + auxTram.getNombre());
                                    System.out.println("    Hora: " + auxTram.getHora() + "\n");
                                }
                                System.out.println("");
                            }
                            else {
                                System.out.println("No se han registrado tramites para la Sede\n");
                            }
                        }
                    }
                    else {
                        System.out.println("No se han registrado Sedes\n\n");
                    }
                }
                
                case "5" -> {
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
