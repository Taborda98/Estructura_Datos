package com.inventario.modelo;

/**
 * Clase que representa un Producto dentro del inventario.
 * Contiene los atributos básicos y métodos de acceso.
 */
public class Producto {

    // Atributos privados (Encapsulación)
    private String codigo;
    private String nombre;
    private int cantidadActual;
    private int cantidadMinima;

    /**
     * Constructor para inicializar un producto
     */
    public Producto(String codigo, String nombre, int cantidadActual, int cantidadMinima) {
        this.codigo = codigo;
        this.nombre = nombre;
        this.cantidadActual = cantidadActual;
        this.cantidadMinima = cantidadMinima;
    }

    // Métodos GET (lectura de datos)

    public String getCodigo() {
        return codigo;
    }

    public String getNombre() {
        return nombre;
    }

    public int getCantidadActual() {
        return cantidadActual;
    }

    public int getCantidadMinima() {
        return cantidadMinima;
    }

    // Método SET (modificar cantidad)
    public void setCantidadActual(int cantidadActual) {
        this.cantidadActual = cantidadActual;
    }

    /**
     * Método para mostrar la información del producto
     */
    public void mostrarInformacion() {
        System.out.println("Código: " + codigo);
        System.out.println("Nombre: " + nombre);
        System.out.println("Cantidad actual: " + cantidadActual);
        System.out.println("Cantidad mínima: " + cantidadMinima);

        // Validación: alerta si está por debajo del mínimo
        if (cantidadActual < cantidadMinima) {
            System.out.println("⚠ Advertencia: Bajo nivel de stock");
        }

        System.out.println("----------------------------");
    }
}