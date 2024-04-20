/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
import controlador.*;
import visual.AgregarSede;
import visual.Menu;
/**
 *
 * @author carlo
 */
public class NewMain {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        AgregarSede opc1 = new AgregarSede();
        Menu mm = new Menu(opc1);
        
        Conexion cc = new Conexion(mm, opc1);
        
        cc.prueba();
        
    }
    
    
}
