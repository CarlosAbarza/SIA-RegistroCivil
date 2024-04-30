/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

import Exceptions.TipoSedeException;

/**
 *
 * @author carlo
 */
public class SedeDocumento extends Sede{
    private int tipo;
    
    public SedeDocumento(String codigo, String ciudad) {
        super(codigo, ciudad);
        tipo = 1;
    }
    
    @Override
    public int getTipo() {
        return tipo;
    }
    
    @Override
    public boolean setDocumento(Tramite documento, int tipo) throws TipoSedeException{
        if (tipo != 1) {
            throw new TipoSedeException();
        }
        return getDocumento().setTramite(documento);
    }
}
