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
    
    public Conexion(Menu menu, AgregarSede opc1, AgregarTramite opc2, 
            ListarTramitesDeSede opc3) {
        this.sedes = new OrganizadorSede();
        this.menu = menu;
        this.opc1 = opc1;
        this.opc2 = opc2;
        this.opc3 = opc3;
        
        this.menu.getOpc1().addMouseListener(this);
        this.menu.getOpc2().addMouseListener(this);
        this.menu.getOpc3().addMouseListener(this);
        this.opc1.getAcept().addMouseListener(this);
        this.opc2.getAcept().addMouseListener(this);
        this.opc3.getBuscar().addMouseListener(this);
        
        this.menu.setVisible(true);
    }
    
    public void limpiarAgregarS() {
        opc1.setCodigo("");
        opc1.setCity("");
    }
    
    public void limpiarAgregarT() {
        opc2.setCodigoT("");
        opc2.setNombre("");
        opc2.setHora("");
        opc2.setCodigoS("");
    }
    
    @Override
    public void mouseClicked(MouseEvent e) {
        // Abre la ventana para agregar Sede
        if (e.getSource() == menu.getOpc1()) {
            menu.setVisible(false);
            opc1.setVisible(true);
        }
        // Cierra la ventana
        else if (e.getSource() == opc1.getAcept()) {
            opc1.setVisible(false);
            menu.setVisible(true);
            sedes.setSede(opc1.getCodigo().getText(), opc1.getCity().getText());
            limpiarAgregarS();
        }
        
        // Abre la ventana para agregar Tramite
        else if (e.getSource() == menu.getOpc2()) {
            menu.setVisible(false);
            opc2.setVisible(true);
        }
        // Cierra la ventana
        else if (e.getSource() == opc2.getAcept()) {
            opc2.setVisible(false);
            menu.setVisible(true);
            sedes.setTramite(opc2.getCodigoS().getText(), opc2.getNombre().getText(),
                    opc2.getCodigoT().getText(), opc2.getHora().getText());
            limpiarAgregarT();
        }
        
        // Abre la ventana para listar los Tramites de una Sede
        else if (e.getSource() == menu.getOpc3()) {
            menu.setVisible(false);
            opc3.setVisible(true);
        }
        // Busca la Sede
        else if (e.getSource() == opc3.getBuscar()) {
            Sede ss = sedes.getSede(opc3.getCodigoS().getText());
            if (ss == null) {
                opc3.mostrarError();
            }
            else {
                opc3.setListado();
                opc3.mostrarListado();
                for (int i = 0; i < ss.getCantDocumento(); i++) {
                    Tramite tt = ss.getDocumento(i);
                    opc3.setListado("Codigo: " + tt.getCodigo() + "\n");
                    opc3.setListado("Nombre: " + tt.getNombre() + "\n");
                    opc3.setListado("Hora: " + tt.getHora() + "\n\n");
                }
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
