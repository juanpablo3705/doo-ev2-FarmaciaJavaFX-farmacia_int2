package cl.materialjava.farmacia.modelo;

public abstract class Producto {
    private String nombre;
    private int stock;
    private double precio;

    protected Producto(String nombre, int stock, double precio) {
        setNombre(nombre);
        setStock(stock);
        setPrecio(precio);
    }

    protected Producto() { }

    public String getNombre() { return nombre; }
    public int getStock() { return stock; }
    public double getPrecio() { return precio; }

    public void setNombre(String nombre) {
        if (nombre == null || nombre.trim().isEmpty()) {
            throw new IllegalArgumentException("El nombre es obligatorio.");
        }
        this.nombre = nombre.trim();
    }

    public void setStock(int stock) {
        if (stock < 0) {
            throw new IllegalArgumentException("El stock no puede ser negativo.");
        }
        this.stock = stock;
    }

    public void setPrecio(double precio) {
        if (precio <= 0) {
            throw new IllegalArgumentException("El precio debe ser mayor que cero.");
        }
        this.precio = precio;
    }

    public abstract String getTipo();
    public abstract String getDetalle();
}