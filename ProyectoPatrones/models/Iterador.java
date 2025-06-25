package models;
import java.util.Iterator;
import java.util.List;

// Iterator: Permite recorrer la lista de productos
public class Iterador implements Iterator<Producto> {
    private List<Producto> productos;
    private int posicion = 0;

    public Iterador(List<Producto> productos) {
        this.productos = productos;
    }

    @Override
    public boolean hasNext() {
        return posicion < productos.size();
    }

    @Override
    public Producto next() {
        return productos.get(posicion++);
    }
}