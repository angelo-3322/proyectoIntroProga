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
public class Producto {
        private String Nombre;
    private int Precio;
    private String TipoProducto;
    private boolean Disponible;

    private int VecesPedido;

    public int getVecesPedido() {
        return VecesPedido;
    }

    public void setVecesPedido(int VecesPedido) {
        this.VecesPedido = VecesPedido;
    }
    
    public String getNombre() {
        return Nombre;
    }

    public void setNombre(String Nombre) {
        this.Nombre = Nombre;
    }

    public int getPrecio() {
        return Precio;
    }

    public void setPrecio(int Precio) {
        this.Precio = Precio;
    }

    public String getTipoProducto() {
        return TipoProducto;
    }

    public void setTipoProducto(String TipoProducto) {
        this.TipoProducto = TipoProducto;
    }

    public boolean isDisponible() {
        return Disponible;
    }

    public void setDisponible(boolean Disponible) {
        this.Disponible = Disponible;
    }
    
    public Producto(){
    
    }
    
    public Producto(String nombre,String tipo, int precio, boolean disponible){
        setDisponible(disponible);
        setNombre(nombre);
        setPrecio(precio);
        setTipoProducto(tipo);
    }
    
    public void ProductoSolicitado(){
        setVecesPedido(getVecesPedido()+1);
    }
    
    @Override
    public String toString(){
        return getTipoProducto() + ": " + getNombre() + " ₡"+getPrecio()+" \n";
    }
}
