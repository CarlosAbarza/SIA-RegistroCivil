/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Exceptions;

/**
 *
 * @author carlo
 */
public class SedeInexistenteException extends Exception{
    public SedeInexistenteException() {
        super("La sede Ingresada no se ha registrado");
    }
}
