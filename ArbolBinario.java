public class ArbolBinario {
    Nodo raiz;

    // Constructor: al crear el árbol, su raíz está vacía (null)
    public ArbolBinario (){
        raiz = null;
    }

    // método para insertar un nodo con un indice y contenido 
    public void insertar(int i, Object contactos){
        Nodo n = new Nodo (i); // Crea un nuevo nodo con el índice dado
        n.contenido = contactos; //asigna el contenido al nodo

        // Si el árbol está vacío, el nuevo nodo se convierte en la raíz
        if(raiz == null){
            raiz = n;
        }

        else{
            Nodo aux = raiz;
            // Recorre el árbol para encontrar la posición correcta
            while (aux != null){
                n.padre = aux; // Guarda referencia al nodo padre actual
                // Si el índice del nuevo nodo es mayor o igual, ve a la derecha
                if(n.indice >= aux.indice){
                    aux = aux.derecha;
                }
                // Si es menor, ve a la izquierda
                else {
                    aux = aux.izquierda;
                }
            }
            // Una vez encontrada la posición (aux es vacio), se conecta el nuevo nodo al árbol
            if (n.indice < n.padre.indice){
                n.padre.izquierda = n;
            }
            else{
                n.padre.derecha = n;
            }
        }
    }

    public void buscarNodos(){

    }

    public void determinarAlturaArbol(){
        
    }

    public void InOrden(){

    }

    public void PreOrden(){

    }

    public void PostOrden(){

    }

    public Nodo getRaiz(){
        return raiz;
    }
}
