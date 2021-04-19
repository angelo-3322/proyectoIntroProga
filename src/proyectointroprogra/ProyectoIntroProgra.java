/*
Proyecto Programacion Basica
Restaurante Taco Rico 

Profesora:
Christy Aguero Valverde

Estudiantes:
David Vargas Alfaro
Ángelo Sánchez Montiel 
Samuel David Velandia Diaz 

 */
package proyectointroprogra;

import javax.swing.JOptionPane;

/**
 *
 * @author jorg1
 */
public class ProyectoIntroProgra {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
         UsuarioSistema usuarioLogin = null;
        
        Restaurante miRestaurante = new Restaurante(true);
        
        String opcion = "";
        String menuCajero = "";
        
        do {
            menuCajero = "Opciones:\n\n"+
                "1- Ver mesas disponibles \n"+
                "2- Facturar mesa \n"+
                "3- Asignar mesa a cliente \n"+
                "4- Ver productos disponibles \n"+
                "5- Deshabilitar producto \n"+
                "6- Ver productos destacados \n"+
                "7- Ver mesas destacados \n"+
                "8- Cierre de caja \n"+
                "9- Terminar jornada!!";
        
            opcion = JOptionPane.showInputDialog(menuCajero);
            String mensaje = "";
            switch(opcion){
                case "1": 
                    mensaje ="";
                    for (int i = 0; i < miRestaurante.getMesas().length; i++) {
                        if(miRestaurante.getMesas()[i].isDisponible()){
                            mensaje += "Mesa #" + miRestaurante.getMesas()[i].getNumeroMesa()+"\n";
                        }                    
                    }
                    JOptionPane.showMessageDialog(null, mensaje);
                    break;
                case "2": 
                    String mesaFacturar = JOptionPane.showInputDialog("Digite la mesa que desa facturar");

                    Mesa mesaFactura = miRestaurante.BuscarMesa(Integer.parseInt(mesaFacturar));
                    if(mesaFactura == null){
                        JOptionPane.showMessageDialog(null, "La mesa indicada no existe");
                        break;
                    }
                    else if(mesaFactura.isDisponible()){
                        JOptionPane.showMessageDialog(null, "La mesa indicada no tiene pedidos pendientes");
                        break;
                    }

                    Factura facuraCliente = mesaFactura.getClienteMesa().getFacturaPedido();
                    facuraCliente.MostrarFactura(miRestaurante, mesaFactura.getClienteMesa());

                    mesaFactura.setClienteMesa(null);
                    mesaFactura.setDisponible(true);
                    mesaFactura.AgregarFactura(facuraCliente);
                    miRestaurante.AgregarFactura(facuraCliente);

                    break;
                case "3": 
                    String mesaAsignar = JOptionPane.showInputDialog("Digite la mesa que desea utilizar");                
                    Mesa mesa = miRestaurante.BuscarMesa(Integer.parseInt(mesaAsignar));

                    if(mesa == null){
                        JOptionPane.showMessageDialog(null, "La mesa indicada no existe");
                        break;
                    }
                    else if(!mesa.isDisponible()){
                        JOptionPane.showMessageDialog(null, "La mesa indicada no esta disponible");
                        break;
                    }

                    Cliente clienteNuevo = new Cliente();
                    clienteNuevo.CargarDatos(miRestaurante);
                    clienteNuevo.ObtenerPedido(miRestaurante);
                    mesa.setClienteMesa(clienteNuevo);

                    break;
                case "4": 
                    miRestaurante.MostrarProductos();
                    break;
                case "5": 
                    miRestaurante.DeshabilitarProducto();
                    break;
                case "6": 
                    miRestaurante.ObtenerProductoDestacado();
                    break;
                case "7": 
                    miRestaurante.ObtenerMesaDestacada();
                    break;
                case "8": 
                    if(usuarioLogin.isPuedeHacerCierre() == true){
                        miRestaurante.GenerarCierre(usuarioLogin);
                    }
                    else{
                        JOptionPane.showMessageDialog(null, "Su usuario no esta autorizado para realizar el cierre de caja");
                    }
                    break;
            }
        } while (!opcion.equals("9"));
    }
    
}
