
import java.util.Scanner;
import models.Adapter;
import models.ClaseExterna;
import models.ControlCatalogo;
import models.Iterador;
import models.Producto;

public class App {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ControlCatalogo catalogo = ControlCatalogo.getInstancia();
        boolean salir = false;

       while (!salir) {
            System.out.println("\n--- MENÚ PRINCIPAL ---");
            System.out.println("1. Agregar producto");
            System.out.println("2. Listar productos");
            System.out.println("3. Clonar producto");
            System.out.println("4. Adaptar producto externo");
            System.out.println("5. Actualizar producto");
            System.out.println("6. Eliminar producto");
            System.out.println("7. Salir");
            System.out.print("Seleccione una opción: ");
            String opcion = sc.nextLine();

            switch (opcion) {
                case "1":
                    System.out.print("Nombre: ");
                    String nombre = sc.nextLine();
                    System.out.print("Precio: ");
                    int precio = Integer.parseInt(sc.nextLine());
                    System.out.print("Descripción: ");
                    String descripcion = sc.nextLine();
                    catalogo.agregarProducto(new Producto(nombre, precio, descripcion));
                    System.out.println("Producto agregado.");
                    break;
                case "2":
                    listarProductos(catalogo);
                    break;
                case "3":
                    listarProductos(catalogo);
                    System.out.print("Ingrese el número de producto a clonar: ");
                    int idxClonar = Integer.parseInt(sc.nextLine()) - 1;
                    if (idxClonar >= 0 && idxClonar < catalogo.getProductos().size()) {
                        Producto original = catalogo.getProductos().get(idxClonar);
                        Producto clon = original.clone();
                        if (clon != null) {
                            System.out.print("Nuevo nombre: ");
                            clon.setNombre(sc.nextLine());
                            System.out.print("Nueva descripción: ");
                            clon.setDescripcion(sc.nextLine());
                            catalogo.agregarProducto(clon);
                            System.out.println("Producto clonado y agregado.");
                        }
                    } else {
                        System.out.println("Índice inválido.");
                    }
                    break;
                case "4":
                    System.out.print("Título externo: ");
                    String titulo = sc.nextLine();
                    System.out.print("Detalles externos: ");
                    String detalles = sc.nextLine();
                    System.out.print("Costo externo: ");
                    int costo = Integer.parseInt(sc.nextLine());
                    ClaseExterna ext = new ClaseExterna(titulo, detalles, costo);
                    Producto adaptado = new Adapter(ext);
                    catalogo.agregarProducto(adaptado);
                    System.out.println("Producto externo adaptado y agregado.");
                    break;
                case "5":
                    listarProductos(catalogo);
                    System.out.print("Ingrese el número de producto a actualizar: ");
                    int idxActualizar = Integer.parseInt(sc.nextLine()) - 1;
                    if (idxActualizar >= 0 && idxActualizar < catalogo.getProductos().size()) {
                        Producto prod = catalogo.getProductos().get(idxActualizar);
                        System.out.print("Nuevo nombre (" + prod.getNombre() + "): ");
                        String nuevoNombre = sc.nextLine();
                        if (!nuevoNombre.isEmpty()) prod.setNombre(nuevoNombre);
                        System.out.print("Nuevo precio (" + prod.getPrecio() + "): ");
                        String nuevoPrecio = sc.nextLine();
                        if (!nuevoPrecio.isEmpty()) prod.setPrecio(Integer.parseInt(nuevoPrecio));
                        System.out.print("Nueva descripción (" + prod.getDescripcion() + "): ");
                        String nuevaDesc = sc.nextLine();
                        if (!nuevaDesc.isEmpty()) prod.setDescripcion(nuevaDesc);
                        System.out.println("Producto actualizado.");
                    } else {
                        System.out.println("Índice inválido.");
                    }
                    break;
                case "6":
                    listarProductos(catalogo);
                    System.out.print("Ingrese el número de producto a eliminar: ");
                    int idxEliminar = Integer.parseInt(sc.nextLine()) - 1;
                    if (idxEliminar >= 0 && idxEliminar < catalogo.getProductos().size()) {
                        catalogo.getProductos().remove(idxEliminar);
                        System.out.println("Producto eliminado.");
                    } else {
                        System.out.println("Índice inválido.");
                    }
                    break;
                case "7":
                    salir = true;
                    System.out.println("¡Hasta luego!");
                    break;
                default:
                    System.out.println("Opción inválida.");
            }
        }
        sc.close();
    }

    private static void listarProductos(ControlCatalogo catalogo) {
        System.out.println("\nCatálogo de productos:");
        Iterador it = catalogo.getIterator();
        int i = 1;
        while (it.hasNext()) {
            System.out.println(i + ". " + it.next());
            i++;
        }
        if (i == 1) {
            System.out.println("No hay productos registrados.");
        }
    }
}