package com.cola.modelo;

/**
 * Clase Nodo
 * Representa un ticket dentro de la lista enlazada.
 * Cada nodo contiene la información del ticket y la referencia al siguiente nodo.
 */
public class Nodo {

    // Atributos del ticket
    public int id;
    public String tipo; // "PRIORITARIO" o "NORMAL"
    public int tiempoLlegada;
    public int tiempoMaximoAtencion;

    // Referencia al siguiente nodo
    public Nodo siguiente;

    /**
     * Constructor del nodo
     */
    public Nodo(int id, String tipo, int tiempoLlegada, int tiempoMaximoAtencion) {
        this.id = id;
        this.tipo = tipo;
        this.tiempoLlegada = tiempoLlegada;
        this.tiempoMaximoAtencion = tiempoMaximoAtencion;
        this.siguiente = null;
    }
}