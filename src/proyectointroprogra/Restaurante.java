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
public class Restaurante {
        private String Nombre;
    private String Telefono;
    private String CorreoElectronico;
    private String Cedula;
    private String Ubicacion;
    
    private Mesa[] Mesas;
    private Producto[] Productos;
    private UsuarioSistema[] Usuarios;
    private TipoPago[] TiposDePago;
    private Reservacion[] Reservaciones;
    private Factura[] Facturas;

    public Factura[] getFacturas() {
        return Facturas;
    }

    public void setFacturas(Factura[] Facturas) {
        this.Facturas = Facturas;
    }

    public TipoPago[] getTiposDePago() {
        return TiposDePago;
    }

    public void setTiposDePago(TipoPago[] TiposDePago) {
        this.TiposDePago = TiposDePago;
    }

    public Reservacion[] getReservaciones() {
        return Reservaciones;
    }

    public void setReservaciones(Reservacion[] Reservaciones) {
        this.Reservaciones = Reservaciones;
    }

    public UsuarioSistema[] getUsuarios() {
        return Usuarios;
    }

    public void setUsuarios(UsuarioSistema[] Usuarios) {
        this.Usuarios = Usuarios;
    }

    public Producto[] getProductos() {
        return Productos;
    }

    public void setProductos(Producto[] Productos) {
        this.Productos = Productos;
    }

    public Mesa[] getMesas() {
        return Mesas;
    }

    public void setMesas(Mesa[] Mesas) {
        this.Mesas = Mesas;
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

    public String getCorreoElectronico() {
        return CorreoElectronico;
    }

    public void setCorreoElectronico(String CorreoElectronico) {
        this.CorreoElectronico = CorreoElectronico;
    }

    public String getCedula() {
        return Cedula;
    }

    public void setCedula(String Cedula) {
        this.Cedula = Cedula;
    }

    public String getUbicacion() {
        return Ubicacion;
    }

    public void setUbicacion(String Ubicacion) {
        this.Ubicacion = Ubicacion;
    }
    
    public Restaurante(boolean precargarDatos){
        CargarDatos(precargarDatos);
    }
    
    private void CargarDatos(boolean Precargados){    
        if(Precargados == true){
            setNombre("Taco Rico");
            setCedula("3101252525");
            setUbicacion("Tres Rios Cartago");
            setTelefono("25252525");
            setCorreoElectronico("tacorico@gmail.com");
        }
        else{
            setNombre(JOptionPane.showInputDialog("Por favor indique el nombre del restaurante"));
            setCedula(JOptionPane.showInputDialog("Por favor indique la cedula juridica del restaurante"));
            setUbicacion(JOptionPane.showInputDialog("Por favor digite la direccion del local"));
            setTelefono(JOptionPane.showInputDialog("Por favor indique el numero de telefono del restaurante"));
            setCorreoElectronico(JOptionPane.showInputDialog("Por favor indique el e-mail del restaurante"));
        }       
        
        setFacturas(new Factura[1000]);
        CargarProductos();
        CargarMesas();
        CargarTiposPago();
        CargarUsuarios();
        
        JOptionPane.showMessageDialog(null, "Bienvenido al restaurante " + getNombre());
    }
    
    private void CargarTiposPago(){
        setTiposDePago(new TipoPago[4]);
        getTiposDePago()[0] = new TipoPago("Visa", true);
        getTiposDePago()[1] = new TipoPago("Mastercard", true);
        getTiposDePago()[2] = new TipoPago("American Expres", false);
        getTiposDePago()[3] = new TipoPago("Efectivo", true);
    }
    
    private void CargarMesas(){
        //Se definieron 30 mesas por defecto
        setMesas(new Mesa[30]);
        for (int j = 0; j < 30; j++) {
            getMesas()[j] = new Mesa(j+1);
        }        
    }
    
    private void CargarProductos(){
        setProductos(new Producto[11]);
       
        getProductos()[0] = new Producto("Arroz con pollo", "Plato fuerte", 2500, true);
        getProductos()[1] = new Producto("Arroz cantones", "Plato fuerte", 2500, true);
        getProductos()[2] = new Producto("Arroz con camarones", "Plato fuerte", 2500, true);
        getProductos()[3] = new Producto("Casado", "Plato fuerte", 2500, true);
        getProductos()[4] = new Producto("Chopsuey", "Plato fuerte", 2500, true);
        getProductos()[5] = new Producto("Arroz con mariscos", "Plato fuerte", 2500, true);
        
        getProductos()[6] = new Producto("Ensalada Mixta", "Acompañamientos", 1200, true);
        getProductos()[7] = new Producto("Ensada sencilla", "Acompañamientos", 1200, true);
        
        getProductos()[8] = new Producto("CocaCola", "Bebida", 1000, true);
        getProductos()[9] = new Producto("Pepsi", "Bebida", 1000, true);
        getProductos()[10] = new Producto("Fresco de cas", "Bebida", 1000, true);        
    }
    
    private void CargarUsuarios(){
        setUsuarios(new UsuarioSistema[20]);
        
        getUsuarios()[0] = new UsuarioSistema("Admin", "Administrador", "", "", "1234", true, true);
        getUsuarios()[1] = new UsuarioSistema("Cajero1", "Cajero", "", "", "567", false, false);
        
    }
    
    //Este metodo es para obtener los platos fuertes
    public Producto[] ObtenerPlatosFuertes(){
        Producto[] listaPlatoFuerte = ObtenerTipoProducto("Plato fuerte");
        return listaPlatoFuerte;
    }
    
    //Este metodo es para obtener los acompañamientos
    public Producto[] ObtenerAcompanamientos(){
        Producto[] listaPlatoAcompanamientos = ObtenerTipoProducto("Acompañamientos");
        return listaPlatoAcompanamientos;
    }
    
    //Este metodo es para obtener las bebidas
    public Producto[] ObtenerBebidas(){
        Producto[] listaPlatoAcompanamientos = ObtenerTipoProducto("Bebida");
        return listaPlatoAcompanamientos;
    }
    
    //Metodo para obtener la lista de un tipo de producto
    private Producto[] ObtenerTipoProducto(String TipoProducto){
        Producto[] listaResultado;
        int contador = 0;
        
        //Primero obtenemos la cantidad de platos con este tipo
        for (int i = 0; i < getProductos().length; i++) {
            if(getProductos()[i].getTipoProducto().equals(TipoProducto)){
                contador++;
            }
        }
        //Luego cargamos todos los tipos en una lista nueva
        listaResultado = new Producto[contador];
        contador = 0;
        for (int i = 0; i < getProductos().length; i++) {
            if(getProductos()[i].getTipoProducto().equals(TipoProducto)){
                listaResultado[contador++] = getProductos()[i];
            }
        }
        return listaResultado;
    }
        
    public void AgregarFacturaPagada(Factura factura){
        for (int i = 0; i < getFacturas().length; i++) {
            if(getFacturas()[i] == null){
                getFacturas()[i] = factura;
                break;
            }
        }
    }
    
    public UsuarioSistema VerificarUsuario(String usuario, String clave){
        for (int i = 0; i < getUsuarios().length; i++) {
            if(getUsuarios()[i] != null && getUsuarios()[i].getUsuario().equals(usuario))
            {
                if(getUsuarios()[i].getClaveUsuario().equals(clave)){
                    return getUsuarios()[i];                    
                }
            }
        }
        return null;
    }
    
    public Mesa BuscarMesa(int numeroMesa){
        
        for (int i = 0; i < getMesas().length; i++) {
            if(getMesas()[i].getNumeroMesa() == numeroMesa){
                return getMesas()[i];
            }
        }
        return null;
    }
    
    //Metodo para agregar una factura a la Restaurante.
    public void AgregarFactura(Factura factura){
        for (int i = 0; i < getFacturas().length; i++) {
            if(getFacturas()[i] == null){
                getFacturas()[i] = factura;
            }
        }
    }
    
    public void MostrarProductos(){
        String Mensaje = ""; 
        for (int i = 0; i < Productos.length; i++) {
            if(Productos[i].isDisponible()){
                Mensaje += Productos[i] +"\n";
            }            
        }
        JOptionPane.showMessageDialog(null, Mensaje);
    }
    
    public void DeshabilitarProducto(){        
        Producto productoSeleccion = null;
        
        do {            
            productoSeleccion = (Producto)JOptionPane.showInputDialog(null, 
            "Por favor seleccione el producto que desea deshabilitar",
            "Pedido",
            JOptionPane.QUESTION_MESSAGE, 
            null, 
            getProductos(), 
            getProductos()[0]); 
            
            if(productoSeleccion != null && !productoSeleccion.isDisponible()){
                JOptionPane.showMessageDialog(null, "Este producto ya esta deshabilitado");
            }
            else if(productoSeleccion != null){
                productoSeleccion.setDisponible(false);
                JOptionPane.showMessageDialog(null, "El producto fue deshabilitado exitosamente");
                break;
            }
            
        } while (productoSeleccion == null || !productoSeleccion.isDisponible());
        
        
        
    }
    
    public Producto ObtenerProductoDestacado(){        
        int productoMayor = 0;
        Producto producto = null;
        for (int i = 0; i < getProductos().length; i++) {
            if(getProductos()[i].getVecesPedido() > productoMayor){
                producto = getProductos()[i];
            }
        }
        if(producto == null){
            JOptionPane.showMessageDialog(null, "De momento no encontramos un producto destacado");    
        }
        else{
            JOptionPane.showMessageDialog(null, "El producto mas vendido es: " + producto.getNombre());
        }
        
        return producto;
    }
    
    public Mesa ObtenerMesaDestacada(){        
        int mesaMayor = 0;
        Mesa mesa = null;
        for (int i = 0; i < getProductos().length; i++) {
            if(getMesas()[i].getCantidadFacturas()> mesaMayor){
                mesa = getMesas()[i];
            }
        }
        if(mesa == null){
            JOptionPane.showMessageDialog(null, "De momento no encontramos una mesa destacada");    
        }
        else{
            JOptionPane.showMessageDialog(null, "La mesa que mas ha vendido es: " + mesa);
        }
        return mesa;
    }
    
    public void GenerarCierre(UsuarioSistema usuarioCierre){        
        double totalFacturas = 0;
        int cantidadFacturas = 0;
        for (int i = 0; i < getFacturas().length; i++) {
            if(getFacturas()[i] == null){
                break;
            }
            totalFacturas+= getFacturas()[i].getTotalFactura();
            cantidadFacturas++;
        }
        
        if(cantidadFacturas == 0){
            JOptionPane.showMessageDialog(null, "No hay facturas generadas para realizar el cierre");
            return;
        }
        
        JOptionPane.showMessageDialog(null, 
                        "         Cierre de caja\n"+
                        "*************************************\n" +
                        "Cantidad facturas: " + cantidadFacturas +
                        "Monto total: "+ Double.toString(totalFacturas) +
                        "Mesa mas usada: " + ObtenerMesaDestacada()+
                        "Producto mas comprado: " + ObtenerProductoDestacado()+
                        "El usuario que genera el cierr es: " + usuarioCierre);
    }
}
