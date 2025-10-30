package modelo;

import java.sql.*;
import java.util.ArrayList;

public class CConsultas {

    Connection con;
    String query;

    public CConsultas() {

    }

    public boolean ingresar(Connection con, String nombres, String apellidos, String telefono, String direccion, String email) {
        this.con = con;
        query = "INSERT INTO datos(id,nombres,apellidos,telefono,direccion,email) VALUES (null,'" + nombres + "','" + apellidos + "','" + telefono + "','" + direccion + "','" + email + "');";
        try {
            PreparedStatement preparar = con.prepareStatement(query);
            preparar.executeUpdate();
            System.out.println("Contacto agregado.");
            return true;
        } catch (SQLException ex) {
            System.out.println("Error en el sql.");
            return false;
        }
    }

    public ArrayList<CContacto> consultar(Connection con) {
        this.con = con;
        query = "SELECT * FROM datos";
        ArrayList<CContacto> lista = new ArrayList<>();
        try {
            PreparedStatement preparar = con.prepareStatement(query);
            ResultSet resultado = preparar.executeQuery();

            while (resultado.next()) {
                CContacto c = new CContacto(
                        resultado.getInt("id"),
                        resultado.getString("nombres"),
                        resultado.getString("apellidos"),
                        resultado.getString("telefono"),
                        resultado.getString("direccion"),
                        resultado.getString("email"));
                lista.add(c);
            }
            System.out.println("Consulta correcta.");
            return lista;

        } catch (SQLException ex) {
            System.out.println("Error en el sql.");
            return null;
        }
    }

    public boolean borrar(Connection con, String email) {
        this.con = con;
        String query = "DELETE FROM datos WHERE email = '" + email + "';";
        try {
            PreparedStatement preparar = con.prepareStatement(query);
            int x = preparar.executeUpdate();
            if (x > 0) {
                System.out.println("Contacto eliminado.");
                return true;
            } else {
                System.out.println("Email no encontrado.");
                return false;
            }
        } catch (SQLException ex) {
            System.out.println("Error en el sql.");
            return false;
        }
    }

    public boolean editar(Connection con, String nombres, String apellidos, String telefono, String direccion, String email) {
        this.con = con;
        String query = "UPDATE datos SET nombres='" + nombres + "', apellidos='" + apellidos + "', telefono='" + telefono + "', direccion='" + direccion + "' WHERE email='" + email + "';";
        try {
            PreparedStatement preparar = con.prepareStatement(query);
            int x = preparar.executeUpdate();
            if (x > 0) {
                System.out.println("Contacto editado.");
                return true;
            } else {
                System.out.println("Email no encontrado.");
                return false;
            }
        } catch (SQLException ex) {
            System.out.println("Error en el sql.");
            return false;
        }
    }

    public ArrayList<CContacto> buscarCiudad(Connection con, String ciudad) {
        this.con = con;
        query = "SELECT * FROM datos WHERE direccion LIKE '%" + ciudad + "%';";
        ArrayList<CContacto> lista = new ArrayList<>();
        try {
            PreparedStatement preparar = con.prepareStatement(query);
            ResultSet resultado = preparar.executeQuery();

            while (resultado.next()) {
                CContacto c = new CContacto(
                        resultado.getInt("id"),
                        resultado.getString("nombres"),
                        resultado.getString("apellidos"),
                        resultado.getString("telefono"),
                        resultado.getString("direccion"),
                        resultado.getString("email"));
                lista.add(c);
            }
            System.out.println("Contactos por ciudad consultados.");
            return lista;

        } catch (SQLException ex) {
            System.out.println("Error en el sql.");
            return null;
        }
    }

    public ArrayList<CContacto> listarRangoId(Connection con, String idInicio, String idFin) {
        this.con = con;
        query = "SELECT * FROM datos WHERE id BETWEEN " + idInicio + " AND " + idFin + ";";
        ArrayList<CContacto> lista = new ArrayList<>();
        try {
            PreparedStatement preparar = con.prepareStatement(query);
            ResultSet resultado = preparar.executeQuery();

            while (resultado.next()) {
                CContacto c = new CContacto(
                        resultado.getInt("id"),
                        resultado.getString("nombres"),
                        resultado.getString("apellidos"),
                        resultado.getString("telefono"),
                        resultado.getString("direccion"),
                        resultado.getString("email"));
                lista.add(c);
            }
            System.out.println("Contactos por rango de ID.");
            return lista;
        } catch (SQLException ex) {
            System.out.println("Error en el sql.");
            return null;
        }
    }

    public ArrayList<CContacto> buscarNombre(Connection con, String nombre) {
        this.con = con;
        query = "SELECT * FROM datos WHERE nombres LIKE '" + nombre + "%';";
        ArrayList<CContacto> lista = new ArrayList<>();
        try {
            PreparedStatement preparar = con.prepareStatement(query);
            ResultSet resultado = preparar.executeQuery();

            while (resultado.next()) {
                CContacto c = new CContacto(
                        resultado.getInt("id"),
                        resultado.getString("nombres"),
                        resultado.getString("apellidos"),
                        resultado.getString("telefono"),
                        resultado.getString("direccion"),
                        resultado.getString("email"));
                lista.add(c);
            }
            System.out.println("Contactos por el nombre requerido consultados.");
            return lista;
        } catch (SQLException ex) {
            System.out.println("Error en el sql.");
            return null;
        }
    }

    public ArrayList<CContacto> buscarApellido(Connection con, String apellido) {
        this.con = con;
        query = "SELECT * FROM datos WHERE apellidos LIKE '" + apellido + "%';";
        ArrayList<CContacto> lista = new ArrayList<>();
        try {
            PreparedStatement preparar = con.prepareStatement(query);
            ResultSet resultado = preparar.executeQuery();

            while (resultado.next()) {
                CContacto c = new CContacto(
                        resultado.getInt("id"),
                        resultado.getString("nombres"),
                        resultado.getString("apellidos"),
                        resultado.getString("telefono"),
                        resultado.getString("direccion"),
                        resultado.getString("email"));
                lista.add(c);
            }
            System.out.println("Contactos por el apellido requerido consultados.");
            return lista;
        } catch (SQLException ex) {
            System.out.println("Error en el sql.");
            return null;
        }
    }

    public ArrayList<CContacto> buscarId(Connection con, String idBuscar) {
        this.con = con;
        query = "SELECT * FROM datos WHERE id = " + idBuscar + ";";
        ArrayList<CContacto> lista = new ArrayList<>();
        try {
            PreparedStatement preparar = con.prepareStatement(query);
            ResultSet resultado = preparar.executeQuery();

            while (resultado.next()) {
                CContacto c = new CContacto(
                        resultado.getInt("id"),
                        resultado.getString("nombres"),
                        resultado.getString("apellidos"),
                        resultado.getString("telefono"),
                        resultado.getString("direccion"),
                        resultado.getString("email"));
                lista.add(c);
            }
            System.out.println("Contacto por el id requerido consultado.");
            return lista;
        } catch (SQLException ex) {
            System.out.println("Error en el sql.");
            return null;
        }
    }

    public ArrayList<CContacto> listarCalles(Connection con) {
        this.con = con;
        query = "SELECT * FROM datos WHERE direccion LIKE '%Cl%';";
        ArrayList<CContacto> lista = new ArrayList<>();
        try {
            PreparedStatement preparar = con.prepareStatement(query);
            ResultSet resultado = preparar.executeQuery();

            while (resultado.next()) {
                CContacto c = new CContacto(
                        resultado.getInt("id"),
                        resultado.getString("nombres"),
                        resultado.getString("apellidos"),
                        resultado.getString("telefono"),
                        resultado.getString("direccion"),
                        resultado.getString("email"));
                lista.add(c);
            }
            System.out.println("Contactos que viven en calles consultados.");
            return lista;
        } catch (SQLException ex) {
            System.out.println("Error en el sql.");
            return null;
        }
    }

    public ArrayList<CContacto> listarCarreras(Connection con) {
        this.con = con;
        query = "SELECT * FROM datos WHERE direccion LIKE '%Cra%';";
        ArrayList<CContacto> lista = new ArrayList<>();
        try {
            PreparedStatement preparar = con.prepareStatement(query);
            ResultSet resultado = preparar.executeQuery();

            while (resultado.next()) {
                CContacto c = new CContacto(
                        resultado.getInt("id"),
                        resultado.getString("nombres"),
                        resultado.getString("apellidos"),
                        resultado.getString("telefono"),
                        resultado.getString("direccion"),
                        resultado.getString("email"));
                lista.add(c);
            }
            System.out.println("Contactos que viven en carreras consultados.");
            return lista;
        } catch (SQLException ex) {
            System.out.println("Error en el sql.");
            return null;
        }
    }

    public ArrayList<CContacto> listarPrefijos(Connection con, String prefijo) {
        this.con = con;
        query = "SELECT * FROM datos WHERE telefono LIKE '" + prefijo + "%';";
        ArrayList<CContacto> lista = new ArrayList<>();
        try {
            PreparedStatement preparar = con.prepareStatement(query);
            ResultSet resultado = preparar.executeQuery();

            while (resultado.next()) {
                CContacto c = new CContacto(
                        resultado.getInt("id"),
                        resultado.getString("nombres"),
                        resultado.getString("apellidos"),
                        resultado.getString("telefono"),
                        resultado.getString("direccion"),
                        resultado.getString("email"));
                lista.add(c);
            }
            System.out.println("Contactos por el prefijo requerido consultados.");
            return lista;
        } catch (SQLException ex) {
            System.out.println("Error en el sql.");
            return null;
        }
    }

    public ArrayList<CContacto> listarAlfabeticamente(Connection con) {
        this.con = con;
        query = "SELECT * FROM datos ORDER BY nombres ASC;";
        ArrayList<CContacto> lista = new ArrayList<>();
        try {
            PreparedStatement preparar = con.prepareStatement(query);
            ResultSet resultado = preparar.executeQuery();

            while (resultado.next()) {
                CContacto c = new CContacto(
                        resultado.getInt("id"),
                        resultado.getString("nombres"),
                        resultado.getString("apellidos"),
                        resultado.getString("telefono"),
                        resultado.getString("direccion"),
                        resultado.getString("email"));
                lista.add(c);
            }
            System.out.println("Contactos organizados alfabeticamente consultados.");
            return lista;
        } catch (SQLException ex) {
            System.out.println("Error en el sql.");
            return null;
        }
    }

    public ArrayList<CContacto> listarIdPar(Connection con) {
        this.con = con;
        query = "SELECT * FROM datos WHERE id % 2 = 0";
        ArrayList<CContacto> lista = new ArrayList<>();
        try {
            PreparedStatement preparar = con.prepareStatement(query);
            ResultSet resultado = preparar.executeQuery();

            while (resultado.next()) {
                CContacto c = new CContacto(
                        resultado.getInt("id"),
                        resultado.getString("nombres"),
                        resultado.getString("apellidos"),
                        resultado.getString("telefono"),
                        resultado.getString("direccion"),
                        resultado.getString("email"));
                lista.add(c);
            }
            System.out.println("Contactos con id par consultados.");
            return lista;
        } catch (SQLException ex) {
            System.out.println("Error en el sql.");
            return null;
        }
    }

    public ArrayList<CContacto> listarIdImpar(Connection con) {
        this.con = con;
        query = "SELECT * FROM datos WHERE id % 2 != 0";
        ArrayList<CContacto> lista = new ArrayList<>();
        try {
            PreparedStatement preparar = con.prepareStatement(query);
            ResultSet resultado = preparar.executeQuery();

            while (resultado.next()) {
                CContacto c = new CContacto(
                        resultado.getInt("id"),
                        resultado.getString("nombres"),
                        resultado.getString("apellidos"),
                        resultado.getString("telefono"),
                        resultado.getString("direccion"),
                        resultado.getString("email"));
                lista.add(c);
            }
            System.out.println("Contactos con id impar consultados.");
            return lista;
        } catch (SQLException ex) {
            System.out.println("Error en el sql.");
            return null;
        }
    }

    public ArrayList<CContacto> listarCampo(Connection con, String campo) {
        this.con = con;
        query = "SELECT id, " + campo + " FROM datos;";
        ArrayList<CContacto> lista = new ArrayList<>();
        try {
            PreparedStatement preparar = con.prepareStatement(query);
            ResultSet resultado = preparar.executeQuery();
            if (campo.equals("id")) {
                while (resultado.next()) {
                    CContacto c = new CContacto(resultado.getInt(campo), "", "", "", "", "");
                    lista.add(c);
                }
                System.out.println("Datos del campo id consultados.");
            } else if (campo.equals("nombres")) {
                while (resultado.next()) {
                    CContacto c = new CContacto(0, resultado.getString(campo), "", "", "", "");
                    lista.add(c);
                }
                System.out.println("Datos del campo nombres consultados.");
            } else if (campo.equals("apellidos")) {
                while (resultado.next()) {
                    CContacto c = new CContacto(0, "", resultado.getString(campo), "", "", "");
                    lista.add(c);
                }
                System.out.println("Datos del campo apellidos consultados");
            } else if (campo.equals("telefono")) {
                while (resultado.next()) {
                    CContacto c = new CContacto(0, "", "", resultado.getString(campo), "", "");
                    lista.add(c);
                }
                System.out.println("Datos del campo telefono consultado");
            } else if (campo.equals("direccion")) {
                while (resultado.next()) {
                    CContacto c = new CContacto(0, "", "", "", resultado.getString(campo), "");
                    lista.add(c);
                }
                System.out.println("Datos del campo direccion consultados");
            } else if (campo.equals("email")) {
                while (resultado.next()) {
                    CContacto c = new CContacto(0, "", "", "", "", resultado.getString(campo));
                    lista.add(c);
                }
                System.out.println("Datos del campo email consultados");
            }
            return lista;
        } catch (SQLException ex) {
            System.out.println("Error en el sql.");
            return null;
        }
    }

    public int mostrarCantidad(Connection con) {
        this.con = con;
        query = "SELECT * FROM datos WHERE direccion LIKE '%manizales%';";
        int cont = 0;
        try {
            PreparedStatement preparar = con.prepareStatement(query);
            ResultSet resultado = preparar.executeQuery();
            while (resultado.next()) {
                CContacto c = new CContacto(
                        resultado.getInt("id"),
                        resultado.getString("nombres"),
                        resultado.getString("apellidos"),
                        resultado.getString("telefono"),
                        resultado.getString("direccion"),
                        resultado.getString("email"));
                cont++;
            }
            System.out.println("Cantidad de contactos que viven en manizales.");
            return cont;
        } catch (SQLException ex) {
            System.out.println("Error en el sql");
            return 0;
        }
    }
}
