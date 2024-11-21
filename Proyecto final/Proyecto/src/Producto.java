public class Producto implements Comparable<Producto> {
    private String nombre;
    private int id;
    private double precio;
    private int cantidad;
    public Producto(String nombre, int id, double precio, int cantidad) {
        this.nombre = nombre;
        this.id = id;
        this.precio = precio;
        this.cantidad = cantidad;
    }
    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }
    public void setPrecio(double precio) {
        this.precio = precio;
    }
    public void setId(int id) {
        this.id = id;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getNombre() {
        return nombre;
    }
    public int getId() {
        return id;
    }
    public double getPrecio() {
        return precio;
    }
    public int getCantidad() {
        return cantidad;
    }
    @Override
    public int compareTo(Producto otro) {
        return Integer.compare(this.id, otro.id);
    }
    @Override
    public String toString() {
        return "Producto{" +
                "ID= " + id +
                ", Nombre = '" + nombre + '\'' +
                ", Precio = $" + precio +
                ", Cantidad= " + cantidad +
                '}';
    }
}
