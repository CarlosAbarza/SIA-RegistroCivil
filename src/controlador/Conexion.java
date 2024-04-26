/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controlador;

import visual.PestañasErrores.*;
import Exceptions.*;
import modelo.*;
import visual.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeParseException;
/**
 *
 * @author carlo
 */
public class Conexion implements MouseListener{
    private OrganizadorSede sedes;
    private Menu menu;
    private AgregarSede opc1;
    private AgregarTramite opc2;
    private ListarTramitesDeSede opc3;
    private ListarSedesTramite opc4;
    private ModificarTramite opc5;
    private EliminarTramite opc6;
    private RangoTiempo opc7;
    
    public Conexion(Menu menu, AgregarSede opc1, AgregarTramite opc2, 
            ListarTramitesDeSede opc3, ListarSedesTramite opc4, 
            ModificarTramite opc5, EliminarTramite opc6,
            RangoTiempo opc7) {
        this.sedes = new OrganizadorSede();
        this.menu = menu;
        this.opc1 = opc1;
        this.opc2 = opc2;
        this.opc3 = opc3;
        this.opc4 = opc4;
        this.opc5 = opc5;
        this.opc6 = opc6;
        this.opc7 = opc7;
        
        this.menu.getOpc1().addMouseListener(this);
        this.menu.getOpc2().addMouseListener(this);
        this.menu.getOpc3().addMouseListener(this);
        this.menu.getOpc4().addMouseListener(this);
        this.menu.getOpc5().addMouseListener(this);
        this.menu.getOpc6().addMouseListener(this);
        this.menu.getOpc7().addMouseListener(this);
        
        
        this.opc1.getAcept().addMouseListener(this);
        this.opc2.getAcept().addMouseListener(this);
        this.opc3.getBuscar().addMouseListener(this);
        this.opc3.getVolver().addMouseListener(this);
        this.opc4.getVolver().addMouseListener(this);
        this.opc5.getMod().addMouseListener(this);
        this.opc5.getCancel().addMouseListener(this);
        this.opc6.getEliminar().addMouseListener(this);
        this.opc6.getCancelar().addMouseListener(this);
        this.opc7.getBuscar().addMouseListener(this);
        this.opc7.getVolver().addMouseListener(this);
        
        
        try {
            // Precarga de datos
            CSV csv = new CSV("sedes");
            String linea;
            csv.firstLine();
            while ((linea = csv.nextLine()) != null) {
                String[] elem = linea.split(",");
                sedes.setSede(new Sede(elem[1], elem[0]));
            }

            csv = new CSV("tramitesPrecargados");
            csv.firstLine();
            while ((linea = csv.nextLine()) != null) {
                String[] elem = linea.split(",");
                sedes.setTramite(elem[3], new Tramite(elem[1], elem[0], elem[2]));
            }
            
        } 
        catch(FileNotFoundException e) {
            System.out.println("Archivo no encontrado");
        } 
        catch(IOException e) {
            System.out.println("Error al leer");
        }
        catch (FormatoHoraException | RangoHorarioException e){
            
        }
        
        this.menu.setVisible(true);
    }
    
    //Funciones de exportar CSV
    public void exportarSedes(String rutaArchivo){
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(rutaArchivo))) {
            writer.write("codigoSede,ciudad");
            writer.newLine();
            
            for (int i = 0; i < sedes.getCantidadSede(); i++) {
                Sede sede = sedes.getSede(i);
                System.out.println(sedes);
                writer.write(sede.getCodigo() + "," + sede.getCiudad());
                writer.newLine(); 
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
    public void exportarTramites(String rutaArchivo){
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(rutaArchivo))){
            writer.write("codigoTramite,nombreTramite,hora,codigoSede");
            writer.newLine();

            for (int i = 0; i < sedes.getCantidadSede(); i++) {
                Sede sede = sedes.getSede(i);
                for (int j = 0; j < sede.getCantDocumento(); j++) {
                    Tramite tramite = sede.getDocumento(j);
                    writer.write(tramite.getCodigo() + "," + tramite.getNombre() + "," + tramite.getHora() + "," + sede.getCodigo());
                    writer.newLine();
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
    
    public void limpiarOpc1() {
        opc1.setCodigo("");
        opc1.setCity("");
    }
    
    public void limpiarOpc2() {
        opc2.setCodigoT("");
        opc2.setNombre("");
        opc2.setHora("");
        opc2.setCodigoS("");
    }
    
    public void limpiarOpc3() {
        opc3.setListado();
        opc3.setCodigo("");
        opc3.limpiar();
    }
    
    public void limpiarOpc4() {
        opc4.limpiar();
    }
    
    public void limpiarOpc5() {
        opc5.setCodS("");
        opc5.setCodT("");
        opc5.setFecha("");
        opc5.setNombre("");
    }
    
    public void limpiarOpc6() {
        opc6.setCodigoS("");
        opc6.setCodigoT("");
    }
    
    public void limpiarOpc7() {
        opc7.setLista();
        opc7.setInicio("");
        opc7.setCierre("");
    }
    
    public void mostrarTramiteOpc3(Sede ss) {
        opc3.mostrarListado();
        for (int i = 0; i < ss.getCantDocumento(); i++) {
            Tramite tt = ss.getDocumento(i);
            opc3.setListado("Codigo: " + tt.getCodigo() + "\n");
            opc3.setListado("Nombre: " + tt.getNombre() + "\n");
            opc3.setListado("Fecha: " + tt.getHora() + "\n\n");
        }
    }
    
    public void mostrarSedesTramiteOpc4() {
        for (int i = 0; i < sedes.getCantidadSede(); i++) {
            Sede ss = sedes.getSede(i);
            opc4.setLista("Ciudad: " + ss.getCiudad() + "\n");
            opc4.setLista("Código: " + ss.getCodigo() + "\n");
            for (int j = 0; j < ss.getCantDocumento(); j++) {
                Tramite tt = ss.getDocumento(j);
                opc4.setLista("    - Nombre: " + tt.getNombre() + "\n");
                opc4.setLista("    - Codigo: " + tt.getCodigo() + "\n");
                opc4.setLista("    - Fecha: " + tt.getHora() + "\n\n");
            }
        }
    }
    
    public void modificarOpc5() throws TextoVacioException, SedeNoEncontradaException, 
            TramiteNoEncontradoException, FormatoHoraException, RangoHorarioException {
        Sede ss = sedes.getSede(opc5.getCodS().getText());
        if (ss == null) {
            throw new SedeNoEncontradaException();
        }
        Tramite tt = ss.getDocumento(opc5.getCodT().getText());
        if (tt == null) {
            throw new TramiteNoEncontradoException();
        }
        if (!opc5.getFecha().getText().equals("")) {
            tt.setHora(opc5.getFecha().getText());
        }
        else if (!opc5.getNombre().getText().equals("")) {
            tt.setNombre(opc5.getNombre().getText());
        }
        else {
            throw new TextoVacioException();
        }
        
    }
    
    public void eliminarOpc6() throws SedeNoEncontradaException, 
            TramiteNoEncontradoException, TextoVacioException {
        if (opc6.getCodigoS().getText().equals("") ||
                opc6.getCodigoT().getText().equals("")){
            throw new TextoVacioException();
        }
        
        Sede ss = sedes.getSede(opc6.getCodigoS().getText());
        if (ss == null) {
            throw new SedeNoEncontradaException();
        }
        ss.eliminarDocumento(opc6.getCodigoT().getText());
    }
    
    public void buscarRango() throws FormatoHoraException, TextoVacioException {
        if (opc7.getInicio().getText().equals("") ||
                opc7.getCierre().getText().equals("")){
            throw new TextoVacioException();
        }
        LocalDateTime inicio;
        LocalDateTime cierre;
        try {
            inicio = LocalDateTime.parse(opc7.getInicio().getText());
            cierre = LocalDateTime.parse(opc7.getCierre().getText());
        }
        catch (DateTimeParseException e) {
            throw new FormatoHoraException();
        }
        
        for (int i = 0; i < sedes.getCantidadSede(); i++) {
            int cont = 0;
            Sede ss = sedes.getSede(i);
            opc7.setLista("Ciudad: " + ss.getCiudad() + "\n");
            opc7.setLista("Código: " + ss.getCodigo() + "\n");
            for (int j = 0; j < ss.getCantDocumento(); j++) {
                Tramite tt = ss.getDocumento(j);
                if (tt.dentroRango(inicio, cierre)) {
                    opc7.setLista("    - Nombre: " + tt.getNombre() + "\n");
                    opc7.setLista("    - Codigo: " + tt.getCodigo() + "\n");
                    opc7.setLista("    - Fecha: " + tt.getHora() + "\n\n");
                    cont++;
                }
            }
            if (cont == 0) {
                opc7.setLista("    NO TIENE TRAMITES EN ESE RANGO\n\n");
            }
        }
    }
    
    @Override
    public void mouseClicked(MouseEvent e) {
        // Abre la ventana para agregar Sede
        if (e.getSource() == menu.getOpc1()) {
            opc1.setVisible(true);
            menu.setVisible(false);
        }
        // Si se ingresaron los dato bien, Cierra la ventana
        else if (e.getSource() == opc1.getAcept()) {
            if (opc1.getCodigo().getText().equals("") ||
                opc1.getCity().getText().equals("")){
                (new ErrorFaltaRellenar()).setVisible(true);
            }
            else {
                menu.setVisible(true);
                opc1.setVisible(false);
                sedes.setSede(opc1.getCodigo().getText(), opc1.getCity().getText());
                limpiarOpc1();
            }
            
        }
        
        // Abre la ventana para agregar Tramite
        else if (e.getSource() == menu.getOpc2()) {
            opc2.setVisible(true);
            menu.setVisible(false);
        }
        // Si se ingresaron bien los datos, Cierra la ventana
        else if (e.getSource() == opc2.getAcept()) {
            if (opc2.getCodigoS().getText().equals("") ||
                    opc2.getNombre().getText().equals("") ||
                    opc2.getCodigoT().getText().equals("") ||
                    opc2.getHora().getText().equals("")) {
                (new ErrorFaltaRellenar()).setVisible(true);
            }
            else {
                try {

                    sedes.setTramite(opc2.getCodigoS().getText(), opc2.getNombre().getText(),
                            opc2.getCodigoT().getText(), opc2.getHora().getText());
                    menu.setVisible(true);
                    opc2.setVisible(false);
                    limpiarOpc2();
                } 
                catch (FormatoHoraException ex) {
                    (new ErrorFormatoHora()).setVisible(true);
                }
                catch (RangoHorarioException ex) {
                    (new ErrorRangoHorario()).setVisible(true);
                }catch (SedeNoEncontradaException ex) {
                    (new SedeInexistente()).setVisible(true);
                }
            }
        }
        
        // Abre la ventana para listar los Tramites de una Sede
        else if (e.getSource() == menu.getOpc3()) {
            opc3.setVisible(true);
            menu.setVisible(false);
        }
        // Busca la Sede
        else if (e.getSource() == opc3.getBuscar()) {
            if (opc3.getCodigoS().getText().equals("")) {
                (new ErrorFaltaRellenar()).setVisible(true);
            }
            else {
                Sede ss = sedes.getSede(opc3.getCodigoS().getText());
                opc3.limpiar();
                opc3.setListado();
                if (ss == null) {
                    (new SedeInexistente()).setVisible(true);
                }
                else {
                    mostrarTramiteOpc3(ss);
                }
            }
        }
        // Cierra la ventana
        else if (e.getSource() == opc3.getVolver()) {
            menu.setVisible(true);
            opc3.setVisible(false);
            limpiarOpc3();
        }
        
        // Abre la ventana para listar todo
        else if (e.getSource() == menu.getOpc4()) {
            opc4.setVisible(true);
            menu.setVisible(false);
            mostrarSedesTramiteOpc4();
        }
        // Cierra la ventana
        else if (e.getSource() == opc4.getVolver()) {
            menu.setVisible(true);
            opc4.setVisible(false);
            limpiarOpc4();
        }
        
        // Abre la ventana de Modificar Tramite
        else if (e.getSource() == menu.getOpc5()) {
            opc5.setVisible(true);
            menu.setVisible(false);
        }
        // Modifica el tramite o intenta hacerlo, si lo logra vuelve al menu
        else if (e.getSource() == opc5.getMod()) {
            try {
                modificarOpc5();
                menu.setVisible(true);
                opc5.setVisible(false);
            }
            catch(TextoVacioException ex) {
                (new ErrorFaltaRellenar()).setVisible(true);
            }
            catch (SedeNoEncontradaException ex) {
                (new SedeInexistente()).setVisible(true);
            }
            catch (TramiteNoEncontradoException ex) {
                (new TramiteNoRegistrado()).setVisible(true);
            } 
            catch (FormatoHoraException ex) {
                (new ErrorFormatoHora()).setVisible(true);
            } 
            catch (RangoHorarioException ex) {
                (new ErrorRangoHorario()).setVisible(true);
            }
        }
        // Cancela la operacion y vuelve al menu
        else if (e.getSource() == opc5.getCancel()) {
            menu.setVisible(true);
            opc5.setVisible(false);
            limpiarOpc5();
        }
        
        // Abre la ventana Eliminar Tramite
        else if (e.getSource() == menu.getOpc6()) {
            opc6.setVisible(true);
            menu.setVisible(false);
        }
        // Elimina el tramite o intenta haerlo, si lo logra vuelve al menu
        else if (e.getSource() == opc6.getEliminar()) {
            try {
                eliminarOpc6();
                menu.setVisible(true);
                opc6.setVisible(false);
            }
            catch(TextoVacioException ex) {
                (new ErrorFaltaRellenar()).setVisible(true);
            }
            catch (SedeNoEncontradaException ex) {
                (new SedeInexistente()).setVisible(true);
            }
            catch (TramiteNoEncontradoException ex) {
                (new TramiteNoRegistrado()).setVisible(true);
            } 
        }
        // Cancela la operacion y vuelve al menu
        else if (e.getSource() == opc6.getCancelar()) {
            menu.setVisible(true);
            opc6.setVisible(false);
            limpiarOpc6();
        }
        
        // Abre la ventana para buscar en un rango de tiempo
        else if (e.getSource() == menu.getOpc7()) {
            opc7.setVisible(true);
            menu.setVisible(false);
        }
        // Busca los elementos o lanza el error
        else if (e.getSource() == opc7.getBuscar()) {
            try {
                opc7.setLista();
                buscarRango();
            }
            catch (FormatoHoraException ex) {
                (new ErrorFormatoHora()).setVisible(true);
            }
            catch (TextoVacioException ex) {
                (new ErrorFaltaRellenar()).setVisible(true);
            }
        }
        // Vuelve al menu
        else if (e.getSource() == opc7.getVolver()) {
            menu.setVisible(true);
            opc7.setVisible(false);
            limpiarOpc7();
        }
    }
    
    @Override
    public void mousePressed(MouseEvent me) {
        
    }

    @Override
    public void mouseReleased(MouseEvent me) {
        
    }

    @Override
    public void mouseEntered(MouseEvent me) {
        
    }

    @Override
    public void mouseExited(MouseEvent me) {
        
    }
}
