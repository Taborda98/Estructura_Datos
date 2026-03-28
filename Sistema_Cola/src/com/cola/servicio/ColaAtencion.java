package com.cola.servicio;

import com.cola.modelo.Nodo;

/**
 * Clase ColaAtencion
 * Implementa una lista enlazada simple para gestionar tickets.
 * Cumple:
 * - Prioridad (PRIORITARIO antes que NORMAL)
 * - FIFO dentro de cada tipo
 * - Eliminación de vencidos
 */
public class ColaAtencion {

    // Inicio de la lista
    private Nodo cabeza;

    /**
     * Constructor: inicializa la cola vacía
     */
    public ColaAtencion() {
        cabeza = null;
    }

    /**
     * Verifica si un ID ya existe
     */
    public boolean existeId(int id) {

        Nodo actual = cabeza;

        while (actual != null) {
            if (actual.id == id) {
                return true;
            }
            actual = actual.siguiente;
        }

        return false;
    }

    /**
     * Inserta un ticket respetando prioridad y orden FIFO
     */
    public void insertarTicket(int id, String tipo, int llegada, int tiempoMax) {

        // Validación ID único
        if (existeId(id)) {
            System.out.println("Error: ID duplicado.");
            return;
        }

        Nodo nuevo = new Nodo(id, tipo, llegada, tiempoMax);

        // Caso 1: lista vacía
        if (cabeza == null) {
            cabeza = nuevo;
            return;
        }

        // Caso 2: PRIORITARIO
        if (tipo.equals("PRIORITARIO")) {

            // Insertar al inicio si el primero es NORMAL
            if (cabeza.tipo.equals("NORMAL")) {
                nuevo.siguiente = cabeza;
                cabeza = nuevo;
                return;
            }

            Nodo actual = cabeza;

            // Buscar último PRIORITARIO
            while (actual.siguiente != null &&
                   actual.siguiente.tipo.equals("PRIORITARIO")) {

                actual = actual.siguiente;
            }

            // Insertar manteniendo orden
            nuevo.siguiente = actual.siguiente;
            actual.siguiente = nuevo;

        } else { // Caso NORMAL

            Nodo actual = cabeza;

            // Ir al final
            while (actual.siguiente != null) {
                actual = actual.siguiente;
            }

            actual.siguiente = nuevo;
        }
    }

    /**
     * Atiende el primer ticket (FIFO general con prioridad)
     */
    public void atenderTicket() {

        if (cabeza == null) {
            System.out.println("Cola vacía.");
            return;
        }

        System.out.println("Atendiendo ID: " + cabeza.id);

        // Eliminar primer nodo
        cabeza = cabeza.siguiente;
    }

    /**
     * Elimina tickets vencidos
     */
    public void eliminarVencidos(int tiempoActual) {

        // Eliminar desde el inicio
        while (cabeza != null &&
               (tiempoActual - cabeza.tiempoLlegada > cabeza.tiempoMaximoAtencion)) {

            System.out.println("Eliminado (inicio) ID: " + cabeza.id);
            cabeza = cabeza.siguiente;
        }

        Nodo actual = cabeza;

        while (actual != null && actual.siguiente != null) {

            if (tiempoActual - actual.siguiente.tiempoLlegada >
                actual.siguiente.tiempoMaximoAtencion) {

                System.out.println("Eliminado ID: " + actual.siguiente.id);

                // Eliminar nodo intermedio o final
                actual.siguiente = actual.siguiente.siguiente;

            } else {
                actual = actual.siguiente;
            }
        }
    }

    /**
     * Imprime la cola completa
     */
    public void mostrarCola() {

        if (cabeza == null) {
            System.out.println("Cola vacía.");
            return;
        }

        Nodo actual = cabeza;

        while (actual != null) {

            System.out.println(
                "ID: " + actual.id +
                " | Tipo: " + actual.tipo +
                " | Llegada: " + actual.tiempoLlegada +
                " | Max: " + actual.tiempoMaximoAtencion
            );

            actual = actual.siguiente;
        }
    }
}