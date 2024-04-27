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
public class SedeCertificados extends Sede{
    
    public SedeCertificados(String codigo, String ciudad) {
        super(codigo, ciudad);
    }
    
    @Override
    public boolean setDocumento(Tramite documento, int tipo) throws TipoSedeException{
        if (tipo != 0) {
            throw new TipoSedeException();
        }
        return getDocumento().setTramite(documento);
    }
    
}
