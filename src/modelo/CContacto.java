package modelo;

public class CContacto {
    int id;
    String nombres;
    String apellidos;
    String telefono;
    String direccion;
    String email;
    
    public CContacto(){
        
    }
    
    public CContacto(int id, String nombres, String apellidos, String telefono, String direccion, String email){
        this.id=id;
        this.nombres=nombres;
        this.apellidos=apellidos;
        this.direccion=direccion;
        this.telefono=telefono;
        this.email=email;
    }
    
    public int getId() {
        return id;
    }

    public String getNombres() {
        return nombres;
    }

    public String getApellidos() {
        return apellidos;
    }

    public String getTelefono() {
        return telefono;
    }

    public String getDireccion() {
        return direccion;
    }

    public String getEmail() {
        return email;
    }
}
