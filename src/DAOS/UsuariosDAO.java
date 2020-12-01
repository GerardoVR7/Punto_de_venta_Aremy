package DAOS;

import Adapters.MariaDBadapter;
import Model.Producto;
import Model.Usuario;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class UsuariosDAO {
    private Connection connectionMySQL = null;
    private final int ACCEPT = 1;
    public UsuariosDAO() {

        MariaDBadapter conector = MariaDBadapter.getInstancia();
        connectionMySQL = conector.getConnection();
    }

    List<Usuario> usuarios = new ArrayList<>();

    public ObservableList<Usuario> getUsuario() {



        if (connectionMySQL != null) {
            String sql = "select * from usuarios";

            try {
                PreparedStatement statement = connectionMySQL.prepareStatement(sql);
                ResultSet rs = statement.executeQuery();
                while (rs.next()) {

                    int id = rs.getInt(1);
                    String nombre = rs.getString(2);
                    String contrasena = rs.getString(3);
                    String rol = rs.getString(4);

                    Usuario usuario = new Usuario(id,nombre,contrasena,rol);

                    usuarios.add(usuario);

                }

            } catch (SQLException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }

        ObservableList<Usuario> tablaUsuarios = FXCollections.observableArrayList(usuarios);

        return  tablaUsuarios;
    }


    public void setUsuario(Usuario usuario) {

        if (connectionMySQL != null) {
            String sql = "insert into usuarios values (?,?,?,?)";

            try {
                PreparedStatement statement = connectionMySQL.prepareStatement(sql);

                statement.setInt(1,usuario.getIdUsuario());
                statement.setString(2,usuario.getNombre());
                statement.setString(3,usuario.getContrasena());
                statement.setString(4,usuario.getRol());

                if (statement.executeUpdate() == ACCEPT){
                    System.out.println("Dato subido correctamente");
                }


            } catch (SQLException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }

    }

    public List getDatosUsuarios(){

        getUsuario();
        List<Integer> listaUsuarios = new ArrayList<>();

        for (int i=0; i<usuarios.size(); i++){

            int Aux;
            Aux = usuarios.get(i).getIdUsuario();
            listaUsuarios.add(Aux);

        }

        return  listaUsuarios;
    }

    public void deletedUsuario(int  Usuario) {

        if (connectionMySQL != null) {

            String sql = "delete from usuarios where idUsuarios = " + Usuario;

            try {
                PreparedStatement statement = connectionMySQL.prepareStatement(sql);

                if (statement.executeUpdate() == ACCEPT){
                    System.out.println("Dato subido correctamente");
                }

            } catch (SQLException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }

    }
}
