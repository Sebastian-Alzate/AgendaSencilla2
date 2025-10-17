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
            //preparo la consulta
            PreparedStatement preparar = con.prepareStatement(query);
            //ejecuto la consulta luego de prepararla
            preparar.executeUpdate();
            return true;
        } catch (SQLException ex) {
            System.out.println("Error en el sql");
            return false;
        }
    }

    public ArrayList<CContacto> consultar(Connection con) {
        this.con = con;
        query = "SELECT * FROM datos";
        ArrayList<CContacto> lista = new ArrayList<>();
        try {
            //preparo la consulta
            PreparedStatement preparar = con.prepareStatement(query);
            //ejecuto la consulta luego de prepararla
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
            System.out.println("Consulta correcta");
            return lista;

        } catch (SQLException ex) {
            System.out.println("Error en el sql");
            return null;
        }
    }
}
