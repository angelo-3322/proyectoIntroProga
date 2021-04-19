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
public class Factura {
        private Producto[] ProductosFactura;
    private double TotalFactura;

    public double getTotalFactura() {
        return TotalFactura;
    }

    public void setTotalFactura(double TotalFactura) {
        this.TotalFactura = TotalFactura;
    }
    
    public Producto[] getProductosFactura() {
        return ProductosFactura;
    }
    

    public void setProductosFactura(Producto[] ProductosFactura) {
        this.ProductosFactura = ProductosFactura;
    }
    
    public Factura(){
    
    }
    
    public void MostrarFactura(Restaurante restaurante, Cliente cliente){
        String factura = 
                "******"+restaurante.getNombre()+"******\n"+
                "Cedula Juridica: " + restaurante.getCedula()+"\n"+
                "Email: " + restaurante.getCorreoElectronico()+"\n"+
                "Direccion: " + restaurante.getUbicacion()+"\n"+
                "Telefono: "+restaurante.getTelefono()+"\n"+
                "***************************************"+"\n"+
                "Cliente: "+cliente.getNombre()+"\n"+
                "Telefono: "+cliente.getTelefono()+"\n"+
                "Email: "+cliente.getEmail()+"\n"+
                "Productos:\n";
        
        int sumatoria = 0;
        
        for (int i = 0; i < ProductosFactura.length; i++) {
            String detalleFactura = "";
            detalleFactura += ProductosFactura[i].getNombre()+", ";
            detalleFactura += ProductosFactura[i].getTipoProducto()+"";
            for (int j = 0; j < 35-detalleFactura.length(); j++) {
                detalleFactura+=".";
            }
            detalleFactura+=ProductosFactura[i].getPrecio();
            sumatoria+=ProductosFactura[i].getPrecio();
            factura+=detalleFactura+"\n";
        }
        factura+="Subtotal :................."+sumatoria+"\n";
        factura+="IVA :......................"+(sumatoria*0.13)+"\n";
        factura+="Total :...................."+(sumatoria+(sumatoria*0.13))+"\n";
        
        JOptionPane.showMessageDialog(null, factura);
        restaurante.AgregarFacturaPagada(this);
        setTotalFactura(sumatoria+(sumatoria*0.13));
    }
}
