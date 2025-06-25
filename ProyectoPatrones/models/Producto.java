package models;

public class Producto implements Cloneable {
    private String nombre;
    private int precio;
    private String descripcion;

    public Producto(String nombre, int precio, String descripcion) {
        this.nombre = nombre;
        this.precio = precio;
        this.descripcion = descripcion;
    }

    public Producto(){

    }

    public String getNombre() {
        return nombre;
    }

    public int getPrecio() {
        return precio;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public String setNombre(String nombre) {
        this.nombre = nombre;
        return nombre;
    }
    public int setPrecio(int precio) {
        this.precio = precio;
        return precio;
    }
    public String setDescripcion(String descripcion) {
        this.descripcion = descripcion;
        return descripcion;
    }

    @Override
    public Producto clone() {
        try {
            return (Producto) super.clone();
        } catch (CloneNotSupportedException e) {
            return null;
        }
    }

    @Override
    public String toString() {
        return nombre + " - $" + precio + " - " + descripcion;
    }
}
