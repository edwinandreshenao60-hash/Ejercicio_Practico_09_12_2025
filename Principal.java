package Ejercicio_Practico_09_12_2025;

import java.util.Scanner;

public class Principal {
    public static void main(String[] args) {
        
        Scanner scanner = new Scanner(System.in);
        
        GestorProductos gestor = new GestorProductos();

        boolean continuar = true;

        while (continuar) {
            System.out.println("\n___ GESTIÓN DE INVENTARIO (CON GESTOR) ___ \n");            
            System.out.println("1. Registrar un producto");
            System.out.println("2. Mostrar todos los productos");
            System.out.println("3. Buscar un producto por su ID");
            System.out.println("4. Actualizar un producto");
            System.out.println("5. Eliminar un producto");
            System.out.println("6. Salir del sistema\n");
            System.out.print("Ingrese una opción: ");

            int opcion = scanner.nextInt();
            scanner.nextLine();

            if (opcion == 6) {
                continuar = false;
                System.out.println("Saliendo del sistema...");
                break;
            }

            if (opcion == 1) {
                System.out.println("¿Qué tipo de producto es?");
                System.out.println("1. Físico");
                System.out.println("2. Digital");
                int tipo = scanner.nextInt();
                scanner.nextLine();

                System.out.print("Ingrese ID: ");
                int id = scanner.nextInt();
                scanner.nextLine();

                System.out.print("Ingrese Nombre: ");
                String nombre = scanner.nextLine();

                System.out.print("Ingrese Precio: ");
                double precio = scanner.nextDouble();

                System.out.print("Ingrese Stock: ");
                int stock = scanner.nextInt();

                if (tipo == 1) {
                    System.out.print("Peso (Kg): ");
                    double peso = scanner.nextDouble();
                    ProductoFisico p = new ProductoFisico(id, nombre, precio, stock, peso);
                    gestor.agregarProducto(p);
                } 
                else if (tipo == 2) {
                    System.out.print("Tamaño (MB): ");
                    double mb = scanner.nextDouble();
                    ProductoDigital p = new ProductoDigital(id, nombre, precio, stock, mb);
                    gestor.agregarProducto(p);
                }
            }

            if (opcion == 2) {
                gestor.mostrarInventario();
            }

            if (opcion == 3) {
                System.out.print("Ingrese ID a buscar: ");
                int id = scanner.nextInt();
                
                Producto encontrado = gestor.buscarPorId(id);

                if (encontrado != null) {
                    System.out.println("¡Producto Localizado!");
                    encontrado.mostrarDetalles();
                } else {
                    System.out.println("No se encontró ningún producto con ese ID.");
                }
            }

            if (opcion == 4) {
                System.out.print("Ingrese ID a modificar: ");
                int id = scanner.nextInt();
                scanner.nextLine();

                Producto encontrado = gestor.buscarPorId(id);

                if (encontrado != null) {
                    System.out.println("Editando: " + encontrado.getNombre());
                    System.out.println("1. Cambiar Nombre");
                    System.out.println("2. Cambiar Precio");
                    int opMod = scanner.nextInt();
                    scanner.nextLine();

                    if (opMod == 1) {
                        System.out.print("Nuevo Nombre: ");
                        String nn = scanner.nextLine();
                        encontrado.setNombre(nn);
                    }
                    if (opMod == 2) {
                        System.out.print("Nuevo Precio: ");
                        double np = scanner.nextDouble();
                        encontrado.setPrecio(np);
                    }
                    System.out.println("Actualización exitosa.");
                } else {
                    System.out.println("Error: No se puede editar porque el ID no existe.");
                }
            }

            if (opcion == 5) {
                System.out.print("Ingrese ID a eliminar: ");
                int id = scanner.nextInt();
                
                gestor.eliminarProducto(id);
            }
        }
    }
}