package cl.materialjava.farmacia.modelo;

public class CuidadoPersonal extends Producto {
    private String marca;

    public CuidadoPersonal(String nombre, int stock, double precio, String marca) {
        super(nombre, stock, precio);

        if (marca == null || marca.trim().isEmpty()) {
            throw new IllegalArgumentException("La marca es obligatoria.");
        }

        this.marca = marca.trim();
    }

    private CuidadoPersonal() { }

    public String getMarca() {
        return marca;
    }

    @Override
    public String getTipo() {
        return "Cuidado personal";
    }

    @Override
    public String getDetalle() {
        return marca;
    }
}