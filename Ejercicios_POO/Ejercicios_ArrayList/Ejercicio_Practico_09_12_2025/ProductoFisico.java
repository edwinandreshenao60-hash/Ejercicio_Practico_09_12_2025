package Ejercicio_Practico_09_12_2025;

public class ProductoFisico extends Producto {
    
    private double pesoKg; 

    public ProductoFisico(int id, String nombre, double precio, int cantidadEnStock, double pesoKg) {
        super(id, nombre, precio, cantidadEnStock);
        this.pesoKg = pesoKg;
    }

    @Override
    public void mostrarDetalles() {
        System.out.println("TIPO: Físico || ID: " + getId() + " || Nombre: " + getNombre() + " || Precio: " + getPrecio() + " || Peso: " + pesoKg + "kg");
    }
}