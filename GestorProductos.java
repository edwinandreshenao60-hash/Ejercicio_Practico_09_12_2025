package Ejercicios_POO.Ejercicios_ArrayList.Ejercicio_Practico_09_12_2025;

import java.util.ArrayList;

public class GestorProductos {

    private ArrayList<Producto> inventario;

    public GestorProductos() {
        inventario = new ArrayList<>();
    }

    public void agregarProducto(Producto p) {
        inventario.add(p);
        System.out.println("Producto guardado correctamente en el Gestor.");
    }

    public void mostrarInventario() {
        System.out.println("\n___ LISTA DE PRODUCTOS ___");
        
        if (inventario.size() == 0) {
            System.out.println("El inventario está vacío.");
        } else {
            for (int i = 0; i < inventario.size(); i++) {
                Producto p = inventario.get(i);
                p.mostrarDetalles();
            }
        }
    }

    public Producto buscarPorId(int idBuscado) {
        
        Producto encontrado = null;

        for (int i = 0; i < inventario.size(); i++) {
            Producto p = inventario.get(i);
            if (p.getId() == idBuscado) {
                encontrado = p;
            }
        }
        
        return encontrado;
    }

    public void eliminarProducto(int idEliminar) {
        
        Producto aBorrar = buscarPorId(idEliminar);

        if (aBorrar != null) {
            inventario.remove(aBorrar);
            System.out.println("El producto ha sido eliminado del sistema.");
        } else {
            System.out.println("Error: No se encontró ese ID para eliminar.");
        }
    }
}