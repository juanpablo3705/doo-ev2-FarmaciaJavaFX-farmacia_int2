package cl.materialjava.farmacia.controlador;

import cl.materialjava.farmacia.modelo.CuidadoPersonal;
import cl.materialjava.farmacia.modelo.Medicamento;
import cl.materialjava.farmacia.modelo.Producto;
import cl.materialjava.farmacia.repositorio.ProductoRepository;
import javafx.collections.ObservableList;

public class FarmaciaController {

    // primero se llaman los métodos de ProductoRepository
    private final ProductoRepository repositorio = new ProductoRepository();

    // método para leer la lista como observable list
    public ObservableList<Producto> getProductos() {
        return repositorio.obtenerTodos();
    }

    // constructor de productos de la clase Medicamento
    public void agregarMedicamento(String nombre, int stock, double precio,
                                   String principioActivo, boolean requiereReceta) {
        Medicamento medicamento = new Medicamento(
                nombre, stock, precio, principioActivo, requiereReceta);
        repositorio.agregar(medicamento);
    }

    // constructor de productos de la clase CuidadoPersonal
    public void agregarCuidado(String nombre, int stock, double precio, String marca) {
        CuidadoPersonal cuidado = new CuidadoPersonal(
                nombre, stock, precio, marca);
        repositorio.agregar(cuidado);
    }

    // se llama al método eliminar de ProductoRepository
    public void eliminar(Producto producto) {
        repositorio.eliminar(producto);
    }
}