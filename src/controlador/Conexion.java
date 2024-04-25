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
import java.io.FileNotFoundException;
import java.io.IOException;
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
    
    public Conexion(Menu menu, AgregarSede opc1, AgregarTramite opc2, 
            ListarTramitesDeSede opc3, ListarSedesTramite opc4, 
            ModificarTramite opc5) {
        this.sedes = new OrganizadorSede();
        this.menu = menu;
        this.opc1 = opc1;
        this.opc2 = opc2;
        this.opc3 = opc3;
        this.opc4 = opc4;
        this.opc5 = opc5;
        
        this.menu.getOpc1().addMouseListener(this);
        this.menu.getOpc2().addMouseListener(this);
        this.menu.getOpc3().addMouseListener(this);
        this.menu.getOpc4().addMouseListener(this);
        this.menu.getOpc5().addMouseListener(this);
        
        this.opc1.getAcept().addMouseListener(this);
        this.opc2.getAcept().addMouseListener(this);
        this.opc3.getBuscar().addMouseListener(this);
        this.opc3.getVolver().addMouseListener(this);
        this.opc4.getVolver().addMouseListener(this);
        this.opc5.getMod().addMouseListener(this);
        
        
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
    
    public void modificarOpc5() throws TextoVacioException {
        Sede ss = sedes.getSede(opc5.getCodS().getText());
        if (ss == null) {
            (new SedeInexistente()).setVisible(true);
        }
        else {
            Tramite tt = ss.getDocumento(opc5.getCodT().getText());
            if (tt == null) {
                (new TramiteNoRegistrado()).setVisible(true);
            }
            else {
                if (!opc5.getFecha().getText().equals("")) {
                    try {
                        tt.setHora(opc5.getFecha().getText());
                    } 
                    catch (FormatoHoraException e) {
                        (new ErrorFormatoHora()).setVisible(true);
                    }
                    catch (RangoHorarioException e) {
                        (new ErrorRangoHorario()).setVisible(true);
                    }
                }
                else if (!opc5.getNombre().getText().equals("")) {
                    tt.setNombre(opc5.getNombre().getText());
                }
                else {
                    throw new TextoVacioException();
                }
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
        // Cierra la ventana
        else if (e.getSource() == opc1.getAcept()) {
            menu.setVisible(true);
            opc1.setVisible(false);
            sedes.setSede(opc1.getCodigo().getText(), opc1.getCity().getText());
            limpiarOpc1();
        }
        
        // Abre la ventana para agregar Tramite
        else if (e.getSource() == menu.getOpc2()) {
            opc2.setVisible(true);
            menu.setVisible(false);
        }
        // Cierra la ventana
        else if (e.getSource() == opc2.getAcept()) {
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
            }
        }
        
        // Abre la ventana para listar los Tramites de una Sede
        else if (e.getSource() == menu.getOpc3()) {
            opc3.setVisible(true);
            menu.setVisible(false);
        }
        // Busca la Sede
        else if (e.getSource() == opc3.getBuscar()) {
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
        
        // Abre la ventana de Modificar/Eliminar Tramite
        else if (e.getSource() == menu.getOpc5()) {
            opc5.setVisible(true);
            menu.setVisible(false);
        }
        // Abre la ventana para modificar un tramite
        else if (e.getSource() == opc5.getMod()) {
            try {
                modificarOpc5();
                menu.setVisible(true);
                opc5.setVisible(false);
            }
            catch(TextoVacioException ex) {
                (new ErrorFaltaRellenar()).setVisible(true);
            }
            
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
