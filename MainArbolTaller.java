import java.util.Scanner;
public class MainArbolTaller {
    public static void main(String[] args) throws Exception {
        Scanner scanner = new Scanner (System.in); //para entrada de datos por consola
        ArbolBinario arbol = new ArbolBinario(); //instanciación de la clase ArbolBinario

        System.out.println("Árbol binario de contactos funciones:");

        // Muestra el menú de opciones al usuario
        System.out.println("1). Agregar nodos");
        System.out.println("2). Realizar recorrido PreOrden");
        System.out.println("3). Realizar recorrido InOrden");
        System.out.println("4). Realizar recorrido PostOrden");
        System.out.println("5). Búsqueda de nodos");
        System.out.println("6). Saber la altura del árbol");
        // Pide una opción al usuario
        System.out.println("Seleccione una opción: ");
        int opcion = scanner.nextInt();

        // Valida la opción seleccionada
        if (opcion > 6 || opcion < 1){
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

            } while (continuar == "si");
            break;
        
            default:
                break;
        }
    }
}
