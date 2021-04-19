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
public class UsuarioSistema {
        private String Usuario;
    private String NombreUsuario;
    private String Apellido1;
    private String Apellido2;
    private String ClaveUsuario;
    private boolean EsAdministrador;
    private boolean PuedeHacerCierre;

    public String getUsuario() {
        return Usuario;
    }

    public void setUsuario(String Usuario) {
        this.Usuario = Usuario;
    }

    public String getNombreUsuario() {
        return NombreUsuario;
    }

    public void setNombreUsuario(String NombreUsuario) {
        this.NombreUsuario = NombreUsuario;
    }

    public String getApellido1() {
        return Apellido1;
    }

    public void setApellido1(String Apellido1) {
        this.Apellido1 = Apellido1;
    }

    public String getApellido2() {
        return Apellido2;
    }

    public void setApellido2(String Apellido2) {
        this.Apellido2 = Apellido2;
    }

    public String getClaveUsuario() {
        return ClaveUsuario;
    }

    public void setClaveUsuario(String ClaveUsuario) {
        this.ClaveUsuario = ClaveUsuario;
    }

    public boolean isEsAdministrador() {
        return EsAdministrador;
    }

    public void setEsAdministrador(boolean EsAdministrador) {
        this.EsAdministrador = EsAdministrador;
    }

    public boolean isPuedeHacerCierre() {
        return PuedeHacerCierre;
    }

    public void setPuedeHacerCierre(boolean PuedeHacerCierre) {
        this.PuedeHacerCierre = PuedeHacerCierre;
    }
   
    public UsuarioSistema(){
        
    }

    
    public UsuarioSistema(String usuario, String nombreUsuario, String apellido1, String apellido2, 
            String clave, boolean esAdministrador, boolean puedeHacerCierre){
        setUsuario(usuario);
        setNombreUsuario(nombreUsuario);
        setApellido1(apellido1);
        setApellido2(apellido2);
        setClaveUsuario(clave);
        setEsAdministrador(esAdministrador);
        setPuedeHacerCierre(puedeHacerCierre);
    }
    
    @Override
    public String toString(){
        return getNombreUsuario() + " " + getApellido1();
    }
}
