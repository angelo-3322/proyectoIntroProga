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
public class Reservacion {
       private String NombreCompletocliente;
    private String correoElectronico;
    private int cantidadPersonas;
   
    public Reservacion(){
    
    }
    
    public Reservacion(String nombreCompleto, String correoElectronico, int cantidadPersonas, String metodoPago) {
        this.NombreCompletocliente = nombreCompleto;
        this.correoElectronico = correoElectronico;
        this.cantidadPersonas = cantidadPersonas;
    }
}
