package DAOS;

import Adapters.MariaDBadapter;
import Model.Producto;
import Model.Proveedor;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ProveedoresDAO {

    private Connection connectionMySQL = null;
    private final int ACCEPT = 1;
    public ProveedoresDAO() {

        MariaDBadapter conector = MariaDBadapter.getInstancia();
        connectionMySQL = conector.getConnection();
    }
    List<Proveedor> proveedores = new ArrayList<>();

    public ObservableList<Proveedor> getProveedor() {

        if (connectionMySQL != null) {
            String sql = "select * from proveedores";

            try {
                PreparedStatement statement = connectionMySQL.prepareStatement(sql);
                ResultSet rs = statement.executeQuery();
                while (rs.next()) {

                    int id = rs.getInt(1);
                    String nombre = rs.getString(2);


                    Proveedor proveedor = new Proveedor(id,nombre);

                    proveedores.add(proveedor);

                }

            } catch (SQLException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }

        ObservableList<Proveedor> tablaProveedores = FXCollections.observableArrayList(proveedores);

        return tablaProveedores;
    }


    public void setProveedor(Proveedor proveedor) {

        if (connectionMySQL != null) {
            String sql = "insert into proveedores values (?,?)";

            try {
                PreparedStatement statement = connectionMySQL.prepareStatement(sql);

                statement.setInt(1,proveedor.getIdProveedor());
                statement.setString(2,proveedor.getNombreProveedor());

                if (statement.executeUpdate() == ACCEPT){
                    System.out.println("Dato subido correctamente");
                }


            } catch (SQLException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }

    }

    public List getNombresProveedores(){

        getProveedor();
        List<String> listaProveedores = new ArrayList<>();

        for (int i=0; i<proveedores.size(); i++){

            String Aux;
            Aux = proveedores.get(i).getNombreProveedor();
            listaProveedores.add(Aux);

        }

        return  listaProveedores;
    }

    public List getDatosProveedores(){

        getProveedor();
        List<Integer> listaProveedores = new ArrayList<>();

        for (int i=0; i<proveedores.size(); i++){

            int Aux;
                    Aux = proveedores.get(i).getIdProveedor();
            listaProveedores.add(Aux);

        }

        return  listaProveedores;
    }

    public void deletedProveedor(int nombreProveedor) {

        if (connectionMySQL != null) {

            String sql = "delete from proveedores where idProveedor = " + nombreProveedor;

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
