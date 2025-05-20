import java.util.Scanner;
public class MainArbolTaller {
    public static void main(String[] args) throws Exception {
        Scanner scanner = new Scanner (System.in); //para entrada de datos por consola
        ArbolBinario arbol = new ArbolBinario(); //instanciación de la clase ArbolBinario
        int opcion;
        System.out.println("Árbol binario de contactos funciones:");

        do{
            // Muestra el menú de opciones al usuario
        System.out.println("1). Agregar nodos");
        System.out.println("2). Realizar recorrido PreOrden");
        System.out.println("3). Realizar recorrido InOrden");
        System.out.println("4). Realizar recorrido PostOrden");
        System.out.println("5). Búsqueda de nodos");
        System.out.println("6). Saber la altura del árbol");
        System.out.println("7). Contar los nodos que son hojas");
        System.out.println("8). Borrar un nodo");
        System.out.println("9). Vaciar el árbol");
        System.out.println("10). Salir");
        // Pide una opción al usuario
        System.out.println("Seleccione una opción: ");
        opcion = scanner.nextInt();

        // Valida la opción seleccionada
        if (opcion > 9 || opcion < 1){
            System.out.println("Seleccione una opción válida");
        }

        // Estructura de control para ejecutar la opción elegida
        switch (opcion) {
            case 1:
            scanner.nextLine();

            String continuar;
            do {
            System.out.print("Ingrese el índice del nodo (número entero): ");
            int indice = scanner.nextInt();
            scanner.nextLine(); 

            System.out.print("Ingrese el contenido del nodo (por ejemplo, nombre del contacto): ");
            String contenido = scanner.nextLine(); //se guarda como object en el nodo

            // se inserta el nodo en el árbol
            arbol.insertar(indice, contenido);

            System.out.print("¿Desea agregar otro nodo? (si/no): ");
            continuar = scanner.nextLine();

            } while (continuar.equalsIgnoreCase("si"));
            break;
        
            default:
                break;

            case 2:
            scanner.nextLine();

            System.out.println("Recorrido preOrden del árbol: ");
            arbol.mostrarPreOrden();
            break;

            case 3:
            scanner.nextLine();
            System.out.println("Recorrido inOrden del árbol: ");
            arbol.mostrarInOrden();
            break;

            case 4:
            scanner.nextLine();
            System.out.println("Recorrido postOrden del árbol: ");
            arbol.mostrarPostOrden();
            break;

            case 5:
            scanner.nextLine();

            String buscar_otro_nodo;
            do{
            System.out.println("Ingrese el índice del nodo que desea buscar (número entero): ");
            int indice = scanner.nextInt();
            scanner.nextLine();

            Nodo resultado = arbol.buscarNodo(indice);
            if (resultado != null) {
            System.out.println("Nodo encontrado: " + resultado.getContenido());
            } else {
            System.out.println("Nodo no encontrado.");
            }

            System.out.println("¿Desea buscar otro nodo? (si/no): ");
            buscar_otro_nodo = scanner.nextLine();
            }while (buscar_otro_nodo.equalsIgnoreCase("si"));
            break;

            case 6:
            scanner.nextLine();
            System.out.println("La altura del árbol es: " + arbol.determinarAlturaArbol());
            break;

            case 7:
            scanner.nextLine();
            System.out.println("Los nodos que son hojas son: " + arbol.contarHojas());
            break;

            case 8:
            System.out.println("Inserte el indice del nodo que desea borrar: ");
            int valorEliminar = scanner.nextInt();
            arbol.eliminarNodo(valorEliminar);
            System.out.println("Nodo eliminado si existía.");
            break;

            case 9:
            arbol.limpiar();
            System.out.println("Árbol vaciado.");
            break;
        }

        scanner.close();
    }while (opcion != 10); // El bucle se repetirá hasta que el usuario elija la opción 10 (Salir)
}}
