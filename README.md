# 📚 Taller Teórico – Práctico I

## Integrantes:

Valentina Sanchez Marulanda. 

Shantal Coneo Garcia.

Mateo Valderrama Caliz.

Julian Adolfo Taborda Marin.


## Estructuras de Datos en Java

Repositorio que contiene la solución del **Taller Teórico – Práctico I** del curso de **Estructuras de Datos**, donde se implementan diferentes soluciones prácticas utilizando **estructuras fundamentales** sin recurrir a implementaciones avanzadas del lenguaje.

---

# 📑 Tabla de Contenidos

* [Descripción del Taller](#-descripción-del-taller)
* [Objetivos Académicos](#-objetivos-académicos)
* [Estructura del Repositorio](#-estructura-del-repositorio)
* [Punto 1 — Sistema de Control de Inventario](#-punto-1--sistema-de-control-de-inventario)

  * [Estructura utilizada](#estructura-utilizada)
  * [Operaciones implementadas](#operaciones-implementadas)
  * [Conceptos aplicados](#conceptos-aplicados)
* [Punto 2 — Cola de Atención con Prioridad Controlada](#-punto-2--cola-de-atención-con-prioridad-controlada)

  * [Estructura utilizada](#estructura-utilizada-1)
  * [Operaciones implementadas](#operaciones-implementadas-1)
  * [Reglas del sistema](#reglas-del-sistema)
* [Tecnologías Utilizadas](#-tecnologías-utilizadas)
* [Cómo Ejecutar el Proyecto](#-cómo-ejecutar-el-proyecto)
* [Autor](#-autor)

---

# 📖 Descripción del Taller

La presente actividad tiene como propósito **evaluar la comprensión conceptual y la aplicación práctica de las estructuras de datos fundamentales abordadas en el curso**.

A través del desarrollo de este taller se busca que el estudiante demuestre su capacidad para:

* Identificar la **estructura de datos adecuada** según un contexto planteado.
* Aplicar correctamente **operaciones fundamentales** como:

  * recorridos
  * inserciones
  * eliminaciones
  * validaciones
* Diseñar soluciones coherentes respetando **restricciones técnicas específicas**.
* Manejar adecuadamente **casos especiales asociados a cada estructura de datos**.

---

# 🎯 Objetivos Académicos

Este taller permite fortalecer conocimientos en:

* Manejo de **estructuras de datos básicas**
* Diseño de **algoritmos para manipulación de datos**
* Validación de información
* Control de casos especiales en estructuras dinámicas
* Organización lógica de la información

---

# 📂 Estructura del Repositorio

El repositorio contiene la implementación de **dos ejercicios principales**:

```
/taller-estructuras-datos
│
├── ControlInventario.java
│
├── SistemaColaAtencion.java
│
└── README.md
```

Cada ejercicio aborda un problema distinto aplicando **estructuras de datos específicas**.

---

# 📦 Punto 1 — Sistema de Control de Inventario

## Descripción

Este programa implementa un **sistema básico de gestión de inventario** que permite registrar productos y controlar su disponibilidad.

El sistema utiliza **un arreglo (array) de objetos `Producto`**, donde cada posición del arreglo almacena la información de un producto registrado.

Cada producto contiene:

* `codigo` → Identificador único del producto
* `nombre` → Nombre del producto
* `cantidadActual` → Cantidad disponible en inventario
* `cantidadMinima` → Cantidad mínima antes de generar alerta

---

## Estructura utilizada

Se utiliza un **arreglo de objetos**:

```
Producto[] inventario
```

El tamaño del inventario es definido por el usuario al iniciar el programa.

---

## Operaciones implementadas

El sistema presenta un **menú interactivo** con las siguientes funcionalidades:

### 1️⃣ Registrar producto

Permite agregar un nuevo producto al inventario.

Validaciones realizadas:

* El inventario no debe estar lleno
* El código del producto debe ser **único**

---

### 2️⃣ Registrar entrada

Permite **aumentar la cantidad disponible** de un producto existente.

Validaciones:

* El producto debe existir
* La cantidad ingresada debe ser **mayor que cero**

---

### 3️⃣ Registrar salida

Permite **reducir la cantidad disponible** de un producto.

Validaciones:

* El producto debe existir
* Debe haber **stock suficiente**

---

### 4️⃣ Consultar inventario

Recorre el arreglo y muestra la información de todos los productos registrados.

Si un producto tiene cantidad menor a la mínima, el sistema muestra una advertencia:

```
** Advertencia: Producto por debajo del mínimo **
```

---

## Conceptos aplicados

En este ejercicio se aplican:

* Uso de **arreglos (arrays)**
* Recorridos secuenciales
* Búsqueda de elementos
* Validación de datos
* Control de capacidad máxima

---

# 🎟 Punto 2 — Cola de Atención con Prioridad Controlada

## Descripción

Este programa simula un sistema de atención al cliente mediante **tickets de servicio**.

Existen dos tipos de tickets:

* **PRIORITARIO** → Atención preferente
* **NORMAL** → Atención estándar

El sistema garantiza:

* Prioridad de atención para tickets **PRIORITARIOS**
* Orden de llegada **FIFO** dentro de cada tipo
* Eliminación automática de **tickets vencidos**

---

## Estructura utilizada

Se implementa **una lista enlazada simple creada manualmente**, sin utilizar estructuras de datos predefinidas.

Cada nodo representa un ticket y contiene:

* `id`
* `tipo`
* `tiempoLlegada`
* `tiempoMaximoAtencion`
* referencia al **siguiente nodo**

Ejemplo conceptual de la estructura:

```
[Ticket 1] → [Ticket 2] → [Ticket 3] → null
```

---

## Operaciones implementadas

### Insertar ticket

* Valida que el **ID sea único**
* Inserta el ticket según su **prioridad**
* Mantiene el **orden de llegada**

---

### Atender siguiente ticket

* Selecciona el **primer ticket de la cola**
* Lo elimina correctamente de la lista

---

### Eliminar tickets vencidos

Un ticket se considera vencido cuando:

```
tiempoActual - tiempoLlegada > tiempoMaximoAtencion
```

El sistema:

* Recorre la lista
* Detecta tickets vencidos
* Los elimina sin romper la estructura

---

### Mostrar cola de atención

Imprime todos los tickets en la cola mostrando:

* ID
* Tipo
* Tiempo de llegada
* Tiempo máximo de atención

---

## Reglas del sistema

✔ Prioridad por tipo de ticket
✔ Orden FIFO dentro de cada tipo
✔ IDs únicos
✔ Eliminación correcta de nodos

---

# 💻 Tecnologías Utilizadas

* **Java**
* Programación orientada a objetos
* Implementación manual de **estructuras de datos**

---

# ▶️ Cómo Ejecutar el Proyecto

1️⃣ Clonar el repositorio

```bash
git clone https://github.com/tu-usuario/tu-repositorio.git
```

2️⃣ Abrir el proyecto en un IDE como:

* VS Code
* IntelliJ IDEA
* NetBeans

3️⃣ Compilar y ejecutar los archivos `.java`.

---

# 👨‍💻 Autor

Proyecto desarrollado como parte del curso de **Estructuras de Datos** con fines académicos.
