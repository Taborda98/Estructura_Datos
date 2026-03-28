package com.inventario.servicio;

import com.inventario.modelo.Producto;

/**
 * Clase que gestiona el inventario de productos.
 * Usa un arreglo (estructura fija) como lo exige el ejercicio.
 */
public class Inventario {

    private Producto[] productos; // Arreglo fijo
    private int contador;         // Número de productos registrados

    /**
     * Constructor que define el tamaño del inventario
     */
    public Inventario(int tamaño) {
        productos = new Producto[tamaño];
        contador = 0;
    }

    /**
     * Registra un nuevo producto en el inventario
     */
    public boolean registrarProducto(Producto nuevoProducto) {

        // Validar espacio disponible
        if (contador >= productos.length) {
            return false;
        }

        // Validar código repetido
        for (int i = 0; i < contador; i++) {
            if (productos[i].getCodigo().equals(nuevoProducto.getCodigo())) {
                return false;
            }
        }

        // Agregar producto
        productos[contador] = nuevoProducto;
        contador++;

        return true;
    }

    /**
     * Busca un producto por su código
     */
    public Producto buscarProducto(String codigo) {

        for (int i = 0; i < contador; i++) {
            if (productos[i].getCodigo().equals(codigo)) {
                return productos[i];
            }
        }

        return null; // No encontrado
    }

    /**
     * Registra una entrada (incrementa cantidad)
     */
    public boolean registrarEntrada(String codigo, int cantidad) {

        Producto producto = buscarProducto(codigo);

        // Validaciones
        if (producto == null || cantidad <= 0) {
            return false;
        }

        producto.setCantidadActual(producto.getCantidadActual() + cantidad);
        return true;
    }

    /**
     * Registra una salida (disminuye cantidad)
     */
    public boolean registrarSalida(String codigo, int cantidad) {

        Producto producto = buscarProducto(codigo);

        // Validaciones
        if (producto == null || cantidad <= 0) {
            return false;
        }

        // Validar stock suficiente
        if (cantidad > producto.getCantidadActual()) {
            return false;
        }

        producto.setCantidadActual(producto.getCantidadActual() - cantidad);
        return true;
    }

    /**
     * Muestra todos los productos del inventario
     */
    public void mostrarInventario() {

        if (contador == 0) {
            System.out.println("Inventario vacío.");
            return;
        }

        for (int i = 0; i < contador; i++) {
            productos[i].mostrarInformacion();
        }
    }
}