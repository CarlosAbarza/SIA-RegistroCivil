/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controlador;

import modelo.*;
import visual.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
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
    
    public Conexion(Menu menu, AgregarSede opc1, AgregarTramite opc2, 
            ListarTramitesDeSede opc3, ListarSedesTramite opc4) {
        this.sedes = new OrganizadorSede();
        this.menu = menu;
        this.opc1 = opc1;
        this.opc2 = opc2;
        this.opc3 = opc3;
        this.opc4 = opc4;
        
        this.menu.getOpc1().addMouseListener(this);
        this.menu.getOpc2().addMouseListener(this);
        this.menu.getOpc3().addMouseListener(this);
        this.menu.getOpc4().addMouseListener(this);
        this.opc1.getAcept().addMouseListener(this);
        this.opc2.getAcept().addMouseListener(this);
        this.opc3.getBuscar().addMouseListener(this);
        this.opc3.getVolver().addMouseListener(this);
        this.opc4.getVolver().addMouseListener(this);
        
        
        
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
            opc3.setListado("Hora: " + tt.getHora() + "\n\n");
        }
    }
    
    public void mostrarSedesTramite() {
        for (int i = 0; i < sedes.getCantidadSede(); i++) {
            Sede ss = sedes.getSede(i);
            opc4.setLista("Ciudad: " + ss.getCiudad() + "\n");
            opc4.setLista("Código: " + ss.getCodigo() + "\n");
            for (int j = 0; j < ss.getCantDocumento(); j++) {
                Tramite tt = ss.getDocumento(j);
                opc4.setLista("    - Nombre: " + tt.getNombre());
                opc4.setLista("    - Codigo: " + tt.getCodigo() + "\n");
                opc4.setLista("    - Hora: " + tt.getHora() + "\n\n");
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
            menu.setVisible(true);
            opc2.setVisible(false);
            sedes.setTramite(opc2.getCodigoS().getText(), opc2.getNombre().getText(),
                    opc2.getCodigoT().getText(), opc2.getHora().getText());
            limpiarOpc2();
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
                opc3.mostrarError();
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
            mostrarSedesTramite();
        }
        // Cierra la ventana
        else if (e.getSource() == opc4.getVolver()) {
            menu.setVisible(true);
            opc4.setVisible(false);
            limpiarOpc4();
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
