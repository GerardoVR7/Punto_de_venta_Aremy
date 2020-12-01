package Model;

import java.time.LocalDate;

public class Venta {

    private int idProducto;
    private String productoVendido;
    private float precioProducto;
    private int productosVendidos;
    private String fechaVenta;
    private int idVentas;

    public Venta(){

    }

    public Venta(int idProducto, String productoVendido, float precioProducto, int productosVendidos, String fechaVenta, int idVentas) {
        this.idProducto = idProducto;
        this.productoVendido = productoVendido;
        this.precioProducto = precioProducto;
        this.productosVendidos = productosVendidos;
        this.fechaVenta = fechaVenta;
        this.idVentas = idVentas;
    }

    public int getProductosVendidos() {
        return productosVendidos;
    }

    public void setProductosVendidos(int productosVendidos) {
        this.productosVendidos = productosVendidos;
    }

    public String getFechaVenta() {
        return fechaVenta;
    }

    public void setFechaVenta(String fechaVenta) {
        this.fechaVenta = fechaVenta;
    }

    public int getIdProducto() {
        return idProducto;
    }

    public void setIdProducto(int idProducto) {
        this.idProducto = idProducto;
    }

    public String getProductoVendido() {
        return productoVendido;
    }

    public void setProductoVendido(String productoVendido) {
        this.productoVendido = productoVendido;
    }

    public float getPrecioProducto() {
        return precioProducto;
    }

    public void setPrecioProducto(float precioProducto) {
        this.precioProducto = precioProducto;
    }

    public int getIdVentas() {
        return idVentas;
    }

    public void setIdVentas(int idVentas) {
        this.idVentas = idVentas;
    }
}
