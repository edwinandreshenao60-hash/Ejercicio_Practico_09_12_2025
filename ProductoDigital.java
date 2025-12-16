package Ejercicio_Practico_09_12_2025;

public class ProductoDigital extends Producto {
    
    private double tamanoMB;

    public ProductoDigital(int id, String nombre, double precio, int cantidadEnStock, double tamanoMB) {
        super(id, nombre, precio, cantidadEnStock);
        this.tamanoMB = tamanoMB;
    }

    @Override
    public void mostrarDetalles() {
        System.out.println("TIPO: Digital || ID: " + getId() + " || Nombre: " + getNombre() + " || Precio: " + getPrecio() + " || Peso Archivo: " + tamanoMB + "MB");
    }
}