/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Exceptions;

/**
 *
 * @author carlo
 */
public class FormatoHoraException extends Exception{ 
    public FormatoHoraException() {
        super("El formato de la hora no es valido");
    }
}
