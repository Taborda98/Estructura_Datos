// Importamos la clase Scanner para poder leer datos desde el teclado
import java.util.Scanner;

// Definimos la clase principal del programa
public class ControlInventario {

    // Clase Producto para almacenar la información de cada producto
    static class Producto {
        
        // Código único del producto
        String codigo;
        
        // Nombre del producto
        String nombre;
        
        // Cantidad actual disponible en inventario
        int cantidadActual;
        
        // Cantidad mínima permitida
        int cantidadMinima;
    }

    // Método principal donde inicia el programa
    public static void main(String[] args) {
        
        // Creamos el objeto Scanner para leer datos del usuario
        Scanner sc = new Scanner(System.in);
        
        // Variable para almacenar el tamaño del inventario
        int tamaño;
        
        // Solicitamos al usuario el tamaño máximo del inventario
        System.out.print("Ingrese la cantidad máxima de productos: ");
        tamaño = sc.nextInt();
        
        // Creamos el arreglo fijo de productos con el tamaño indicado
        Producto[] inventario = new Producto[tamaño];
        
        // Variable para llevar el control de cuántos productos se han registrado
        int contadorProductos = 0;
        
        // Variable para controlar el menú
        int opcion;
        
        // Ciclo do-while para mostrar el menú hasta que el usuario elija salir
        do {
            
            // Mostramos las opciones del menú
            System.out.println("\n--- MENU ---");
            System.out.println("1. Registrar producto");
            System.out.println("2. Registrar entrada");
            System.out.println("3. Registrar salida");
            System.out.println("4. Consultar inventario");
            System.out.println("5. Salir");
            System.out.print("Seleccione una opción: ");
            
            // Leemos la opción seleccionada
            opcion = sc.nextInt();
            
            // Estructura switch para ejecutar la opción elegida
            switch(opcion) {
                
                case 1:
                    // Registrar producto
                    
                    // Verificamos si aún hay espacio en el arreglo
                    if(contadorProductos < tamaño) {
                        
                        // Creamos un nuevo objeto Producto
                        Producto nuevo = new Producto();
                        
                        // Pedimos el código del producto
                        System.out.print("Ingrese código: ");
                        nuevo.codigo = sc.next();
                        
                        // Variable para verificar si el código ya existe
                        boolean existe = false;
                        
                        // Recorremos el inventario para verificar código repetido
                        for(int i = 0; i < contadorProductos; i++) {
                            if(inventario[i].codigo.equals(nuevo.codigo)) {
                                existe = true;
                                break;
                            }
                        }
                        
                        // Si el código ya existe mostramos error
                        if(existe) {
                            System.out.println("Error: El código ya existe.");
                        } else {
                            
                            // Pedimos el nombre del producto
                            System.out.print("Ingrese nombre: ");
                            nuevo.nombre = sc.next();
                            
                            // Pedimos la cantidad actual
                            System.out.print("Ingrese cantidad actual: ");
                            nuevo.cantidadActual = sc.nextInt();
                            
                            // Pedimos la cantidad mínima
                            System.out.print("Ingrese cantidad mínima: ");
                            nuevo.cantidadMinima = sc.nextInt();
                            
                            // Guardamos el producto en el arreglo
                            inventario[contadorProductos] = nuevo;
                            
                            // Incrementamos el contador de productos
                            contadorProductos++;
                            
                            // Mensaje de éxito
                            System.out.println("Producto registrado correctamente.");
                        }
                        
                    } else {
                        // Mensaje si el inventario está lleno
                        System.out.println("Inventario lleno. No se pueden agregar más productos.");
                    }
                    break;
                    
                case 2:
                    // Registrar entrada
                    
                    System.out.print("Ingrese código del producto: ");
                    String codigoEntrada = sc.next();
                    
                    // Variable para encontrar el producto
                    int indiceEntrada = -1;
                    
                    // Buscamos el producto por código
                    for(int i = 0; i < contadorProductos; i++) {
                        if(inventario[i].codigo.equals(codigoEntrada)) {
                            indiceEntrada = i;
                            break;
                        }
                    }
                    
                    // Verificamos si el producto existe
                    if(indiceEntrada == -1) {
                        System.out.println("Error: Código no encontrado.");
                    } else {
                        
                        // Pedimos la cantidad a ingresar
                        System.out.print("Ingrese cantidad a añadir: ");
                        int cantidad = sc.nextInt();
                        
                        // Validamos que sea mayor que cero
                        if(cantidad > 0) {
                            inventario[indiceEntrada].cantidadActual += cantidad;
                            System.out.println("Entrada registrada correctamente.");
                        } else {
                            System.out.println("Error: La cantidad debe ser mayor que cero.");
                        }
                    }
                    break;
                    
                case 3:
                    // Registrar salida
                    
                    System.out.print("Ingrese código del producto: ");
                    String codigoSalida = sc.next();
                    
                    // Variable para encontrar el producto
                    int indiceSalida = -1;
                    
                    // Buscamos el producto por código
                    for(int i = 0; i < contadorProductos; i++) {
                        if(inventario[i].codigo.equals(codigoSalida)) {
                            indiceSalida = i;
                            break;
                        }
                    }
                    
                    // Verificamos si existe
                    if(indiceSalida == -1) {
                        System.out.println("Error: Código no encontrado.");
                    } else {
                        
                        // Pedimos cantidad a retirar
                        System.out.print("Ingrese cantidad a retirar: ");
                        int cantidad = sc.nextInt();
                        
                        // Validamos que sea mayor que cero
                        if(cantidad > 0) {
                            
                            // Verificamos que haya stock suficiente
                            if(cantidad <= inventario[indiceSalida].cantidadActual) {
                                inventario[indiceSalida].cantidadActual -= cantidad;
                                System.out.println("Salida registrada correctamente.");
                            } else {
                                System.out.println("Error: Stock insuficiente.");
                            }
                            
                        } else {
                            System.out.println("Error: La cantidad debe ser mayor que cero.");
                        }
                    }
                    break;
                    
                case 4:
                    // Consultar inventario
                    
                    System.out.println("\n--- INVENTARIO ---");
                    
                    // Recorremos los productos registrados
                    for(int i = 0; i < contadorProductos; i++) {
                        
                        System.out.println("Código: " + inventario[i].codigo);
                        System.out.println("Nombre: " + inventario[i].nombre);
                        System.out.println("Cantidad actual: " + inventario[i].cantidadActual);
                        System.out.println("Cantidad mínima: " + inventario[i].cantidadMinima);
                        
                        // Advertencia si está por debajo del mínimo
                        if(inventario[i].cantidadActual < inventario[i].cantidadMinima) {
                            System.out.println("** Advertencia: Producto por debajo del mínimo **");
                        }
                        
                        System.out.println("------------------------");
                    }
                    break;
                    
                case 5:
                    // Mensaje de salida
                    System.out.println("Saliendo del sistema...");
                    break;
                    
                default:
                    // Mensaje si la opción no es válida
                    System.out.println("Opción inválida.");
            }
            
        } while(opcion != 5); // El ciclo continúa hasta que el usuario elija 5
        
        // Cerramos el Scanner
        sc.close();
    }
}
