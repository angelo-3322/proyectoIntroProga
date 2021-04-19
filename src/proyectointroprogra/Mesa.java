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
public class Mesa {
        private int NumeroMesa;
    private boolean Disponible;
    private Cliente ClienteMesa;
    private Factura[] FacturaMesa;
    private int CantidadFacturas;

    public int getCantidadFacturas() {
        return CantidadFacturas;
    }

    public void setCantidadFacturas(int CantidadFacturas) {
        this.CantidadFacturas = CantidadFacturas;
    }
    
    public void setNumeroMesa(int NumeroMesa) {
        this.NumeroMesa = NumeroMesa;
    }
    
    public int getNumeroMesa() {
        return NumeroMesa;
    }

    public boolean isDisponible() {
        return Disponible;
    }

    public void setDisponible(boolean Disponible) {
        this.Disponible = Disponible;
    }

    public Cliente getClienteMesa() {
        return ClienteMesa;
    }

    public void setClienteMesa(Cliente ClienteMesa) {
        this.ClienteMesa = ClienteMesa;
        if(ClienteMesa == null){
            setDisponible(true);
        }
        else{
            setDisponible(false);
        }
    }

    public Factura[] getFacturaMesa() {
        return FacturaMesa;
    }

    public void setFacturaMesa(Factura[] FacturaMesa) {
        this.FacturaMesa = FacturaMesa;
    }
    
    public Mesa(){
        setFacturaMesa(new Factura[1000]);
        setDisponible(true);
    }
    
    public Mesa(int numero){
        setNumeroMesa(numero);
        setFacturaMesa(new Factura[1000]);
        setDisponible(true);
    }
    
    //Metodo para agregar una factura a la mesa.
    public void AgregarFactura(Factura factura){
        for (int i = 0; i < getFacturaMesa().length; i++) {
            if(getFacturaMesa()[i] == null){
                getFacturaMesa()[i] = factura;
            }
        }
        
        setCantidadFacturas(getCantidadFacturas()+1);
    }
    
    @Override
    public String toString(){
        return "Mesa: #" + getNumeroMesa();
    }
}
