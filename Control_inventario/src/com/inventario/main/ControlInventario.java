package com.inventario.main;

import com.inventario.modelo.Producto;
import com.inventario.servicio.Inventario;
import java.util.Scanner;

/**
 * Clase principal que ejecuta el sistema de inventario
 */
public class ControlInventario {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        // Solicitar tamaño del inventario (estructura fija)
        System.out.print("Ingrese la capacidad del inventario: ");
        int tamaño = scanner.nextInt();

        Inventario inventario = new Inventario(tamaño);

        int opcion;

        do {
            // Menú
            System.out.println("\n--- MENÚ ---");
            System.out.println("1. Registrar producto");
            System.out.println("2. Registrar entrada");
            System.out.println("3. Registrar salida");
            System.out.println("4. Consultar inventario");
            System.out.println("5. Salir");
            System.out.print("Seleccione una opción: ");

            opcion = scanner.nextInt();

            switch (opcion) {

                case 1:
                    // Registrar producto
                    System.out.print("Código: ");
                    String codigo = scanner.next();

                    System.out.print("Nombre: ");
                    String nombre = scanner.next();

                    System.out.print("Cantidad actual: ");
                    int cantidadActual = scanner.nextInt();

                    System.out.print("Cantidad mínima: ");
                    int cantidadMinima = scanner.nextInt();

                    Producto nuevo = new Producto(codigo, nombre, cantidadActual, cantidadMinima);

                    if (inventario.registrarProducto(nuevo)) {
                        System.out.println("Producto registrado correctamente.");
                    } else {
                        System.out.println("Error: Código repetido o inventario lleno.");
                    }
                    break;

                case 2:
                    // Entrada
                    System.out.print("Código: ");
                    codigo = scanner.next();

                    System.out.print("Cantidad: ");
                    int entrada = scanner.nextInt();

                    if (inventario.registrarEntrada(codigo, entrada)) {
                        System.out.println("Entrada registrada.");
                    } else {
                        System.out.println("Error en la operación.");
                    }
                    break;

                case 3:
                    // Salida
                    System.out.print("Código: ");
                    codigo = scanner.next();

                    System.out.print("Cantidad: ");
                    int salida = scanner.nextInt();

                    if (inventario.registrarSalida(codigo, salida)) {
                        System.out.println("Salida registrada.");
                    } else {
                        System.out.println("Error: stock insuficiente o datos inválidos.");
                    }
                    break;

                case 4:
                    // Mostrar inventario
                    inventario.mostrarInventario();
                    break;

                case 5:
                    System.out.println("Saliendo del sistema...");
                    break;

                default:
                    System.out.println("Opción inválida.");
            }

        } while (opcion != 5);

        scanner.close();
    }
}