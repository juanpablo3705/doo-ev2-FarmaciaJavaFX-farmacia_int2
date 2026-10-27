package cl.materialjava.farmacia.repositorio;

// esta es lo que antes le decía "clase gestora", acá se crea y se almacena la lista de productos

import cl.materialjava.farmacia.modelo.Producto;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class ProductoRepository {

    // crear la lista bajo el nombre "productos"
    private final ObservableList<Producto> productos =
            FXCollections.observableArrayList();

    // método para retornar la lista de todos los productos
    public ObservableList<Producto> obtenerTodos() {
        return productos;
    }

    // método para agregar productos a la lista
    public void agregar(Producto producto) {
        if (producto != null) {
            productos.add(producto);
        }
    }

    // método para eliminar productos de la lista
    public void eliminar(Producto producto) {
        if (producto != null) {
            productos.remove(producto);
        }
    }
}