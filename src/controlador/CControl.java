package controlador;

import java.sql.Connection;
import java.util.ArrayList;
import vista.*;
import modelo.*;

public class CControl {

    CConexion con = new CConexion();
    Connection conecta;
    CConsultas consulta = new CConsultas();

    public CControl() {

    }

    public boolean insertar(String nombres, String apellidos, String direccion, String telefono, String email) {
        conecta = con.conectar();
        boolean bandera = consulta.ingresar(conecta, nombres, apellidos, direccion, telefono, email);
        con.desconectar(conecta);
        return bandera;
    }

    public ArrayList<CContacto> consultar() {
        ArrayList<CContacto> lista = new ArrayList<>();
        conecta = con.conectar();
        if (conecta != null) {
            lista = consulta.consultar(conecta);
            con.desconectar(conecta);
            return lista;
        } else {
            return null;
        }
    }
    
    public boolean borrar(String email) {
        conecta = con.conectar();
        boolean bandera = consulta.borrar(conecta, email);
        con.desconectar(conecta);
        return bandera;
    }
    
    public boolean editar(String nombres, String apellidos, String direccion, String telefono, String email) {
        conecta = con.conectar();
        boolean bandera = consulta.editar(conecta, nombres, apellidos, telefono, direccion, email);
        con.desconectar(conecta);
        return bandera;
    }
    
    public ArrayList<CContacto> buscarCiudad(String ciudad) {
        ArrayList<CContacto> lista = new ArrayList<>();
        conecta = con.conectar();
        if (conecta != null) {
            lista = consulta.buscarCiudad(conecta, ciudad);
            con.desconectar(conecta);
            return lista;
        } else {
            return null;
        }
    }
}