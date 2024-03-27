
import java.io.*;


public class ProyectoSIA {
    public static void main(String[] args) throws IOException {
        BufferedReader lector = new BufferedReader(new InputStreamReader(System.in));
        String opcion;
        boolean bucle = true;
        
        while (bucle) {
            System.out.println("Menú");
            System.out.println("Que desea hacer?");
            System.out.println("1. Agregar una Sede");
            System.out.println("2. Agregar un tramite realizado");
            System.out.println("3. Listar los tramites de una Sede");
            // System.out.println("4. Prestar");
            System.out.println("4. Salir\n");

            opcion = lector.readLine();
            if (opcion == null || opcion.isEmpty()) {
                System.out.println("No ingreso ninguna opción");
                opcion = "0";
            }

            switch(opcion.toLowerCase()) {
                case "1" -> {
                    // Agregar Sede
                }
                
                case "2" -> {
                    // Agregar un tramite
                }
                
                case "3" -> {
                    // Mostrar todos los tramites realizados en la sede
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
