/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyectointroprogra;

import javax.swing.JOptionPane;

/**
 *
 * @author jorg1
 */
public class Cliente {
        private String Nombre;
    private String Telefono;
    private String Email;
    private TipoPago Pago;
    private Factura FacturaPedido;

    public Factura getFacturaPedido() {
        return FacturaPedido;
    }

    public void setFacturaPedido(Factura FacturaPedido) {
        this.FacturaPedido = FacturaPedido;
    }

    public String getNombre() {
        return Nombre;
    }

    public void setNombre(String Nombre) {
        this.Nombre = Nombre;
    }

    public String getTelefono() {
        return Telefono;
    }

    public void setTelefono(String Telefono) {
        this.Telefono = Telefono;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String Email) {
        this.Email = Email;
    }

    public TipoPago getPago() {
        return Pago;
    }

    public void setPago(TipoPago Pago) {
        this.Pago = Pago;
    }
    
    public Cliente(){
        
    }
    
    public void CargarDatos(Restaurante restaurante){
        setNombre(JOptionPane.showInputDialog("Por favor digite el nombre"));
        setTelefono(JOptionPane.showInputDialog("Por favor digite el telefono"));
        setEmail(JOptionPane.showInputDialog("Por favor digite el email"));
        
        TipoPago tipoPago = null;
        
        do {
            tipoPago = (TipoPago) JOptionPane.showInputDialog(null, 
            "Por favor seleccione el tipo de pago",
            "Pago",
            JOptionPane.QUESTION_MESSAGE, 
            null, 
            restaurante.getTiposDePago(), 
            restaurante.getTiposDePago()[0]);      

            if(tipoPago != null && !tipoPago.isAceptado()){
                JOptionPane.showMessageDialog(null, "El pago seleccionado es invalido");
            }
            else{
                setPago(tipoPago);
            }
            
        } while (tipoPago == null || !tipoPago.isAceptado());
    }
    
    public Factura ObtenerPedido(Restaurante restaurante){
        
        Producto[] productosPedidos = new Producto[1000];
        Producto productoSeleccion = null;
        int contador = 0;
        
        do {
            productoSeleccion = (Producto)JOptionPane.showInputDialog(null, 
            "Por favor seleccione el producto que desea consumir",
            "Pedido",
            JOptionPane.QUESTION_MESSAGE, 
            null, 
            restaurante.getProductos(), 
            restaurante.getProductos()[0]);      

            if(productoSeleccion != null && !productoSeleccion.isDisponible()){
                JOptionPane.showMessageDialog(null, "Lamentablemente el producto seleccionado no esta disponible");
            }
            else{
                productosPedidos[contador++] = productoSeleccion;
                productoSeleccion.ProductoSolicitado();
            }
        } while (JOptionPane.showConfirmDialog(null,
                "Desea agregar otro producto al pedido?",
                "Menu",
                JOptionPane.YES_NO_OPTION) == 0);
        
        contador = 0;
        for (int i = 0; i < productosPedidos.length; i++) {
            if(productosPedidos[i] == null){
                break;
            }
            contador++;
        }
        
        Producto[] productosFactura = new Producto[contador];
        
        for (int i = 0; i < contador; i++) {
            productosFactura[i] = productosPedidos[i];
        }
        
        Factura factura = new Factura();
        factura.setProductosFactura(productosFactura);
        setFacturaPedido(factura);
        
        return factura;
    }
}
