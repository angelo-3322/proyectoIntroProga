/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyectointroprogra;

/**
 *
 * @author jorg1
 */
public class TipoPago {
        private String Descripcion;
    private boolean Aceptado;
    
    public String getDescripcion() {
        return Descripcion;
    }

    public void setDescripcion(String Descripcion) {
        this.Descripcion = Descripcion;
    }

    public boolean isAceptado() {
        return Aceptado;
    }

    public void setAceptado(boolean Aceptado) {
        this.Aceptado = Aceptado;
    }
    
    public TipoPago(){
    }
    
    public TipoPago(String descripcion, boolean aceptado){
        setAceptado(aceptado);
        setDescripcion(descripcion);
    }
    
    @Override
    public String toString(){
        String disponible = "";
        if(!isAceptado()){
            disponible = " / Deshabilitado";
        }
        return getDescripcion() + "" + disponible;
    }
}
