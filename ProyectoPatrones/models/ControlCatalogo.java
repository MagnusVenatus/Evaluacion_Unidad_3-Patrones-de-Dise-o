package models;
import java.util.ArrayList;
import java.util.List;

// Singleton: Solo una instancia de ControlCatalogo
public class ControlCatalogo {
    private static ControlCatalogo instancia;
    private List<Producto> productos;

    private ControlCatalogo() {
        productos = new ArrayList<>();
    }

    public static ControlCatalogo getInstancia() {
        if (instancia == null) {
            instancia = new ControlCatalogo();
        }
        return instancia;
    }

    public void agregarProducto(Producto producto) {
        productos.add(producto);
    }

    public List<Producto> getProductos() {
        return productos;
    }

   // Método para obtener el iterador
    public Iterador getIterator() {
       return new Iterador(productos);
    }
}