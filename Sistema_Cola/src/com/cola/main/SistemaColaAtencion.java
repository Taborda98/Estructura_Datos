package com.cola.main;

import java.util.Scanner;
import com.cola.servicio.ColaAtencion;

/**
 * Clase principal
 * Permite interactuar con el sistema mediante menú
 */
public class SistemaColaAtencion {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        ColaAtencion cola = new ColaAtencion();

        int opcion;

        do {
            System.out.println("\n--- MENU ---");
            System.out.println("1. Insertar Ticket");
            System.out.println("2. Atender Ticket");
            System.out.println("3. Eliminar Vencidos");
            System.out.println("4. Mostrar Cola");
            System.out.println("5. Salir");

            opcion = scanner.nextInt();

            switch (opcion) {

                case 1:
                    System.out.print("ID: ");
                    int id = scanner.nextInt();

                    System.out.print("Tipo (PRIORITARIO/NORMAL): ");
                    String tipo = scanner.next();

                    System.out.print("Tiempo llegada: ");
                    int llegada = scanner.nextInt();

                    System.out.print("Tiempo max: ");
                    int max = scanner.nextInt();

                    cola.insertarTicket(id, tipo, llegada, max);
                    break;

                case 2:
                    cola.atenderTicket();
                    break;

                case 3:
                    System.out.print("Tiempo actual: ");
                    int tiempo = scanner.nextInt();

                    cola.eliminarVencidos(tiempo);
                    break;

                case 4:
                    cola.mostrarCola();
                    break;

                case 5:
                    System.out.println("Fin del sistema.");
                    break;

                default:
                    System.out.println("Opción inválida.");
            }

        } while (opcion != 5);

        scanner.close();
    }
}