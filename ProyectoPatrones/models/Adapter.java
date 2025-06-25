package models;

// Adapter: Convierte ExternalProduct en Product
public class Adapter extends Producto {
    public Adapter(ClaseExterna ext) {
        super(ext.title, ext.cost, ext.details);
    }
}