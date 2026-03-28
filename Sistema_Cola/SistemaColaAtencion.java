/*
 * Nombre de la clase: SistemaColaAtencion
 * Propósito: Simular un sistema de atención con tickets PRIORITARIOS y NORMALES
 * utilizando una lista enlazada simple implementada manualmente.
 */

import java.util.Scanner; // Permite leer datos desde el teclado

public class SistemaColaAtencion {

    /*
     * Clase Nodo
     * Representa cada ticket dentro de la cola.
     * Cada nodo contiene la información del ticket y una referencia al siguiente nodo.
     */
    static class Nodo {

        int id; // Identificador único del ticket
        String tipo; // Tipo de ticket: "PRIORITARIO" o "NORMAL"
        int tiempoLlegada; // Momento en el que el ticket fue creado
        int tiempoMaximoAtencion; // Tiempo máximo permitido antes de que el ticket venza

        Nodo siguiente; // Referencia al siguiente nodo de la lista

        /*
         * Constructor de la clase Nodo
         * Inicializa los valores del ticket
         */
        public Nodo(int id, String tipo, int tiempoLlegada, int tiempoMaximoAtencion) {
            this.id = id;
            this.tipo = tipo;
            this.tiempoLlegada = tiempoLlegada;
            this.tiempoMaximoAtencion = tiempoMaximoAtencion;
            this.siguiente = null; // Inicialmente no apunta a ningún nodo
        }
    }

    // Referencia al primer nodo de la lista (inicio de la cola)
    Nodo cabeza;

    /*
     * Constructor de la cola
     * Inicializa la lista vacía
     */
    public SistemaColaAtencion() {
        cabeza = null;
    }

    /*
     * Método: existeId
     * Verifica si ya existe un ticket con el mismo ID
     */
    public boolean existeId(int id) {

        Nodo actual = cabeza; // Comenzamos desde el inicio de la lista

        // Recorremos toda la lista
        while (actual != null) {

            if (actual.id == id) { // Si encontramos el mismo id
                return true; // El id ya existe
            }

            actual = actual.siguiente; // Avanzamos al siguiente nodo
        }

        return false; // No se encontró el id
    }

    /*
     * Método: insertarTicket
     * Inserta un nuevo ticket respetando:
     * - Prioridad
     * - Orden de llegada
     * - ID único
     */
    public void insertarTicket(int id, String tipo, int tiempoLlegada, int tiempoMaximo) {

        // Validar que el ID no exista
        if (existeId(id)) {
            System.out.println("Error: El ID ya existe.");
            return;
        }

        // Crear el nuevo nodo
        Nodo nuevo = new Nodo(id, tipo, tiempoLlegada, tiempoMaximo);

        // Caso 1: Lista vacía
        if (cabeza == null) {
            cabeza = nuevo;
            return;
        }

        // Caso 2: Ticket PRIORITARIO
        if (tipo.equals("PRIORITARIO")) {

            // Si el primero es NORMAL, insertar al inicio
            if (cabeza.tipo.equals("NORMAL")) {
                nuevo.siguiente = cabeza;
                cabeza = nuevo;
                return;
            }

            // Buscar el último PRIORITARIO
            Nodo actual = cabeza;

            while (actual.siguiente != null && actual.siguiente.tipo.equals("PRIORITARIO")) {
                actual = actual.siguiente;
            }

            // Insertar después del último prioritario
            nuevo.siguiente = actual.siguiente;
            actual.siguiente = nuevo;

        } else { // Caso 3: Ticket NORMAL

            Nodo actual = cabeza;

            // Avanzar hasta el final
            while (actual.siguiente != null) {
                actual = actual.siguiente;
            }

            // Insertar al final
            actual.siguiente = nuevo;
        }

    }

    /*
     * Método: atenderTicket
     * Atiende el primer ticket de la cola
     */
    public void atenderTicket() {

        // Verificar si la cola está vacía
        if (cabeza == null) {
            System.out.println("No hay tickets para atender.");
            return;
        }

        // Mostrar el ticket que será atendido
        System.out.println("Atendiendo ticket ID: " + cabeza.id);

        // Eliminar el primer nodo moviendo la cabeza al siguiente
        cabeza = cabeza.siguiente;
    }

    /*
     * Método: eliminarTicketsVencidos
     * Elimina todos los tickets que superaron su tiempo máximo de atención
     */
    public void eliminarTicketsVencidos(int tiempoActual) {

        // Eliminar vencidos al inicio de la lista
        while (cabeza != null &&
                (tiempoActual - cabeza.tiempoLlegada > cabeza.tiempoMaximoAtencion)) {

            System.out.println("Eliminando ticket vencido ID: " + cabeza.id);
            cabeza = cabeza.siguiente;
        }

        Nodo actual = cabeza;

        // Recorrer el resto de la lista
        while (actual != null && actual.siguiente != null) {

            if (tiempoActual - actual.siguiente.tiempoLlegada >
                    actual.siguiente.tiempoMaximoAtencion) {

                System.out.println("Eliminando ticket vencido ID: " + actual.siguiente.id);

                // Eliminamos el nodo saltándolo
                actual.siguiente = actual.siguiente.siguiente;

            } else {

                actual = actual.siguiente;
            }
        }

    }

    /*
     * Método: imprimirCola
     * Muestra todos los tickets en la cola
     */
    public void imprimirCola() {

        // Verificar si la lista está vacía
        if (cabeza == null) {
            System.out.println("La cola está vacía.");
            return;
        }

        Nodo actual = cabeza;

        System.out.println("Estado actual de la cola:");

        // Recorrer la lista e imprimir cada ticket
        while (actual != null) {

            System.out.println(
                    "ID: " + actual.id +
                            " | Tipo: " + actual.tipo +
                            " | Llegada: " + actual.tiempoLlegada +
                            " | Tiempo Max: " + actual.tiempoMaximoAtencion
            );

            actual = actual.siguiente;
        }

    }

    /*
     * Método principal
     * Permite interactuar con el sistema mediante un menú
     */
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        SistemaColaAtencion cola = new SistemaColaAtencion();

        int opcion;

        do {

            System.out.println("\n--- MENU ---");
            System.out.println("1. Insertar Ticket");
            System.out.println("2. Atender Ticket");
            System.out.println("3. Eliminar Tickets Vencidos");
            System.out.println("4. Mostrar Cola");
            System.out.println("5. Salir");

            opcion = scanner.nextInt();

            switch (opcion) {

                case 1:

                    System.out.print("ID: ");
                    int id = scanner.nextInt();

                    System.out.print("Tipo (PRIORITARIO/NORMAL): ");
                    String tipo = scanner.next();

                    System.out.print("Tiempo de llegada: ");
                    int llegada = scanner.nextInt();

                    System.out.print("Tiempo maximo de atencion: ");
                    int tiempoMax = scanner.nextInt();

                    cola.insertarTicket(id, tipo, llegada, tiempoMax);

                    break;

                case 2:

                    cola.atenderTicket();

                    break;

                case 3:

                    System.out.print("Tiempo actual: ");
                    int tiempoActual = scanner.nextInt();

                    cola.eliminarTicketsVencidos(tiempoActual);

                    break;

                case 4:

                    cola.imprimirCola();

                    break;

                case 5:

                    System.out.println("Saliendo...");

                    break;

                default:

                    System.out.println("Opcion invalida.");

            }

        } while (opcion != 5);

        scanner.close();
    }
}
