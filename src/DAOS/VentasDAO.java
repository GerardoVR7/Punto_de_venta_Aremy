package DAOS;

import Adapters.MariaDBadapter;
import Model.Producto;
import Model.Venta;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.sql.*;
import java.time.LocalDate;
import java.util.List;

public class VentasDAO {
    private Connection connectionMySQL = null;
    private final int ACCEPT = 1;
    public VentasDAO() {

        MariaDBadapter conector = MariaDBadapter.getInstancia();
        connectionMySQL = conector.getConnection();
    }

    public ObservableList<Venta> getVenta() {

        List<Venta> ventas = FXCollections.observableArrayList();

        if (connectionMySQL != null) {
            String sql = "select * from ventas";

            try {
                PreparedStatement statement = connectionMySQL.prepareStatement(sql);
                ResultSet rs = statement.executeQuery();
                while (rs.next()) {

                    int idProducto = rs.getInt(1);
                    String productoVendido = rs.getString(2);
                    float precioProducto = rs.getFloat(3);
                    int productosVendidos = rs.getInt(4);
                    String fechaVenta = rs.getString(5);
                    int id = rs.getInt(6);



                    Venta venta = new Venta(idProducto,productoVendido,precioProducto,productosVendidos,fechaVenta,id);

                    ventas.add(venta);

                }

            } catch (SQLException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }

        ObservableList<Venta> tablasVentas = FXCollections.observableArrayList(ventas);

        return  tablasVentas;
    }


    public void setVenta(Venta venta) {

        if (connectionMySQL != null) {
            String sql = "insert into ventas values (?,?,?,?,?,?)";

            try {
                PreparedStatement statement = connectionMySQL.prepareStatement(sql);

                statement.setInt(1,venta.getIdProducto());
                statement.setString(2,venta.getProductoVendido());
                statement.setFloat(3,venta.getPrecioProducto());
                statement.setInt(4,venta.getProductosVendidos());
                statement.setString(5,venta.getFechaVenta());
                statement.setInt(6, venta.getIdVentas());

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
