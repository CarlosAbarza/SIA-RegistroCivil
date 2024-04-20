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
    
    public Conexion(Menu menu, AgregarSede opc1) {
        this.menu = menu;
        this.opc1 = opc1;
        
        this.menu.getOpc1().addMouseListener(this);
        this.opc1.getAcept().addMouseListener(this);
    }
    
    @Override
    public void mouseClicked(MouseEvent e) {
        if (e.getSource() == menu.getOpc1()) {
            menu.setVisible(false);
            opc1.setVisible(true);
        }
        else if (e.getSource() == opc1.getAcept()) {
            opc1.setVisible(false);
            menu.setVisible(true);
            System.out.println(opc1.getCodigo().getText());
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
