import java.util.Scanner;

public class GestorDeInventarios {
    public static void main(String[] args) {
        ArbolBinarioBusqueda<Producto> inventario = new ArbolBinarioBusqueda<>();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            try {
                System.out.println("\n--- Gestión de Inventario ---");
                System.out.println("1. Agregar Producto");
                System.out.println("2. Eliminar Producto");
                System.out.println("3. Buscar Producto");
                System.out.println("4. Listar Inventario");
                System.out.println("5. Salir");
                System.out.print("Seleccione una opción: ");
                int opcion = Integer.parseInt(scanner.nextLine());

                switch (opcion) {
                    case 1:
                        agregarProducto(scanner, inventario);
                        break;
                    case 2:
                        eliminarProducto(scanner, inventario);
                        break;
                    case 3:
                        buscarProducto(scanner, inventario);
                        break;
                    case 4:
                        listarInventario(inventario);
                        break;
                    case 5:
                        System.out.println("Saliendo del sistema... BYE =)");
                        return;
                    default:
                        System.out.println("Opción inválida. Intente otra ves");
                }
            } catch (NumberFormatException e) {
                System.out.println("Entrada inválida. ingrese un número válido");
            } catch (Exception e) {
                System.out.println("Error: " + e.getMessage());
            }
        }
    }

    private static void agregarProducto(Scanner scanner, ArbolBinarioBusqueda<Producto> inventario) {
        try {
            System.out.print("Nombre del producto: ");
            String nombre = scanner.nextLine();

            System.out.print("ID del producto: ");
            int id = Integer.parseInt(scanner.nextLine());

            System.out.print("Precio del producto: ");
            double precio = Double.parseDouble(scanner.nextLine());

            System.out.print("Cantidad en inventario: ");
            int cantidad = Integer.parseInt(scanner.nextLine());

            if (precio < 0 || cantidad < 0) {
                System.out.println("El precio y la cantidad deben ser positivos.");
                return;
            }

            Producto producto = new Producto(nombre, id, precio, cantidad);
            inventario.insertar(producto);
            System.out.println("Producto agregado con éxito.");
        } catch (NumberFormatException e) {
            System.out.println("Error: Ingrese valores válidos para ID, precio y cantidad.");
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    private static void eliminarProducto(Scanner scanner, ArbolBinarioBusqueda<Producto> inventario) {
        try {
            System.out.print("ID del producto a eliminar: ");
            int idEliminar = Integer.parseInt(scanner.nextLine());

            Producto productoEliminar = new Producto("", idEliminar, 0, 0);
            inventario.eliminar(productoEliminar);
            System.out.println("Producto eliminado con éxito.");
        } catch (NumberFormatException e) {
            System.out.println("Error: Ingrese un ID válido.");
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    private static void buscarProducto(Scanner scanner, ArbolBinarioBusqueda<Producto> inventario) {
        try {
            System.out.print("ID del producto a buscar: ");
            int idBuscar = Integer.parseInt(scanner.nextLine());

            Producto productoBuscar = new Producto("", idBuscar, 0, 0);
            Producto encontrado = inventario.buscar(productoBuscar);
            if (encontrado != null) {
                System.out.println("Producto encontrado: " + encontrado);
            } else {
                System.out.println("Producto no encontrado.");
            }
        } catch (NumberFormatException e) {
            System.out.println("Error: Ingrese un ID válido.");
        }
    }

    private static void listarInventario(ArbolBinarioBusqueda<Producto> inventario) {
        System.out.println("Inventario en orden:");
        inventario.inOrden();
    }
}
