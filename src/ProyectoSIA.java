// <<<<<<< HEAD
import controlador.Conexion;
import visual.*;


public class ProyectoSIA {
    public static void main(String[] args){
        Menu mm = new Menu();
        AgregarSede opc1 = new AgregarSede();
        AgregarTramite opc2 = new AgregarTramite();
        ListarTramitesDeSede opc3 = new ListarTramitesDeSede();
        ListarSedesTramite opc4 = new ListarSedesTramite();
        ModificarTramite opc5 = new ModificarTramite();
        EliminarTramite opc6 = new EliminarTramite();
        RangoTiempo opc7 = new RangoTiempo();
        ExportarCSV opc8 = new ExportarCSV();
        
        
        Conexion cc = new Conexion(mm, opc1, opc2, opc3, opc4, opc5, opc6, opc7, opc8);
    }
}
