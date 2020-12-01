package DAOS;

import Adapters.MariaDBadapter;
import Model.Producto;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ProductosDAO {

    private Connection connectionMySQL = null;
    private final int ACCEPT = 1;
    public ProductosDAO() {

        MariaDBadapter conector = MariaDBadapter.getInstancia();
        connectionMySQL = conector.getConnection();
    }

    List<Producto> productos = new ArrayList<>();
    List<Producto> productosAux = new ArrayList<>();

    public ObservableList<Producto> getProducto() {

        if (connectionMySQL != null) {
            String sql = "select * from almacen";

            try {
                PreparedStatement statement = connectionMySQL.prepareStatement(sql);
                ResultSet rs = statement.executeQuery();
                while (rs.next()) {

                    int id = rs.getInt(1);
                    String nombre = rs.getString(2);
                    float precio = rs.getInt(3);
                    int stock = rs.getInt(4);
                    String proveedor = rs.getString(5);

                    Producto producto = new Producto(id,nombre,precio,stock,proveedor);

                    productos.add(producto);
                    productosAux.add(producto);

                }

            } catch (SQLException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }

        ObservableList<Producto> tablaProductos = FXCollections.observableArrayList(productos);

        return  tablaProductos;
    }

    public List<Producto> getlistaProductos(){
        getProducto();
        ArrayList<Producto> aux = new ArrayList<>();
        aux  = (ArrayList<Producto>) productosAux;

        return  productosAux;
    }


    public void setProducto(Producto producto) {

        if (connectionMySQL != null) {
            String sql = "insert into almacen values (?,?,?,?,?)";

            try {
                PreparedStatement statement = connectionMySQL.prepareStatement(sql);

                    statement.setInt(1,producto.getIdProducto());
                    statement.setString(2,producto.getNombre());
                    statement.setFloat(3,producto.getPrecio());
                    statement.setInt(4,producto.getStock());
                    statement.setString(5,producto.getProveedor());

                    if (statement.executeUpdate() == ACCEPT){
                        System.out.println("Dato subido correctamente");
                }


            } catch (SQLException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }

    }

    public List getNombresProductos(){

        getProducto();
        List<Integer> listaProductos = new ArrayList<>();

        for (int i=0; i<productos.size(); i++){

            int Aux;
            Aux = productos.get(i).getIdProducto();
            listaProductos.add(Aux);

        }

        return  listaProductos;
    }

    public void deletedProveedor(int producto) {

        if (connectionMySQL != null) {

            String sql = "delete from almacen where idProducto = " + producto ;

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
