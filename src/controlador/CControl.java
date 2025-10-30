package controlador;

import java.sql.Connection;
import java.util.ArrayList;
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
    
    public boolean editar(String nombres, String apellidos, String telefono, String direccion, String email) {
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
    
    public ArrayList<CContacto> listarRangoId(String idInicio, String idFin) {
        ArrayList<CContacto> lista = new ArrayList<>();
        conecta = con.conectar();
        if (conecta != null) {
            lista = consulta.listarRangoId(conecta, idInicio, idFin);
            con.desconectar(conecta);
            return lista;
        } else {
            return null;
        }
    }
    
    public ArrayList<CContacto> buscarNombre(String nombre) {
        ArrayList<CContacto> lista = new ArrayList<>();
        conecta = con.conectar();
        if (conecta != null) {
            lista = consulta.buscarNombre(conecta, nombre);
            con.desconectar(conecta);
            return lista;
        } else {
            return null;
        }
    }
    
    public ArrayList<CContacto> buscarApellido(String apellido) {
        ArrayList<CContacto> lista = new ArrayList<>();
        conecta = con.conectar();
        if (conecta != null) {
            lista = consulta.buscarApellido(conecta, apellido);
            con.desconectar(conecta);
            return lista;
        } else {
            return null;
        }
    }
    
    public ArrayList<CContacto> buscarId(String idBuscar) {
        ArrayList<CContacto> lista = new ArrayList<>();
        conecta = con.conectar();
        if (conecta != null) {
            lista = consulta.buscarId(conecta, idBuscar);
            con.desconectar(conecta);
            return lista;
        } else {
            return null;
        }
    }
    
    public ArrayList<CContacto> listarCalles() {
        ArrayList<CContacto> lista = new ArrayList<>();
        conecta = con.conectar();
        if (conecta != null) {
            lista = consulta.listarCalles(conecta);
            con.desconectar(conecta);
            return lista;
        } else {
            return null;
        }
    }
    
    public ArrayList<CContacto> listarCarreras() {
        ArrayList<CContacto> lista = new ArrayList<>();
        conecta = con.conectar();
        if (conecta != null) {
            lista = consulta.listarCarreras(conecta);
            con.desconectar(conecta);
            return lista;
        } else {
            return null;
        }
    }
    
    public ArrayList<CContacto> listarPrefijos(String prefijo) {
        ArrayList<CContacto> lista = new ArrayList<>();
        conecta = con.conectar();
        if (conecta != null) {
            lista = consulta.listarPrefijos(conecta, prefijo);
            con.desconectar(conecta);
            return lista;
        } else {
            return null;
        }
    }
    
    public ArrayList<CContacto> listarAlfabeticamente() {
        ArrayList<CContacto> lista = new ArrayList<>();
        conecta = con.conectar();
        if (conecta != null) {
            lista = consulta.listarAlfabeticamente(conecta);
            con.desconectar(conecta);
            return lista;
        } else {
            return null;
        }
    }
    
    public ArrayList<CContacto> listarIdPar() {
        ArrayList<CContacto> lista = new ArrayList<>();
        conecta = con.conectar();
        if (conecta != null) {
            lista = consulta.listarIdPar(conecta);
            con.desconectar(conecta);
            return lista;
        } else {
            return null;
        }
    }
    
    public ArrayList<CContacto> listarIdImpar() {
        ArrayList<CContacto> lista = new ArrayList<>();
        conecta = con.conectar();
        if (conecta != null) {
            lista = consulta.listarIdImpar(conecta);
            con.desconectar(conecta);
            return lista;
        } else {
            return null;
        }
    }
    
    public ArrayList<CContacto> listarCampo(String campo) {
        ArrayList<CContacto> lista = new ArrayList<>();
        conecta = con.conectar();
        if (conecta != null) {
            lista = consulta.listarCampo(conecta, campo);
            con.desconectar(conecta);
            return lista;
        } else {
            return null;
        }
    }
    
    public int mostrarCantidad() {
        conecta = con.conectar();
        if (conecta != null) {
            int cant = consulta.mostrarCantidad(conecta);
            con.desconectar(conecta);
            return cant;
        } else {
            return 0;
        }
    }
}