package cl.materialjava.farmacia.modelo;

public class Medicamento extends Producto {
    private String principioActivo;
    private boolean requiereReceta;

    public Medicamento(String nombre, int stock, double precio,
                       String principioActivo, boolean requiereReceta) {
        super(nombre, stock, precio);
        setPrincipioActivo(principioActivo);
        this.requiereReceta = requiereReceta;
    }

    private Medicamento() { }

    public String getPrincipioActivo() {
        return principioActivo;
    }

    public boolean isRequiereReceta() {
        return requiereReceta;
    }

    public void setPrincipioActivo(String principioActivo) {
        if (principioActivo == null || principioActivo.trim().isEmpty()) {
            throw new IllegalArgumentException("El principio activo es obligatorio.");
        }
        this.principioActivo = principioActivo.trim();
    }

    @Override
    public String getTipo() {
        return "Medicamento";
    }

    @Override
    public String getDetalle() {
        return principioActivo
                + (requiereReceta ? " (con receta)" : " (sin receta)");
    }
}