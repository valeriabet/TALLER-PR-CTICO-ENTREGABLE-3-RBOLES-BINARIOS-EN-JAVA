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
            Nodo actual = raiz;
            Nodo padre = null;
            // Recorre el árbol para encontrar la posición correcta
        while (actual != null) {
        padre = actual;
        if (i < actual.indice) {
            actual = actual.izquierda;
        } else {
            actual = actual.derecha;
    }
}

        n.padre = padre;
        if (i < padre.indice) {
        padre.izquierda = n;
        } else {
        padre.derecha = n;
}
        }
    }

    // Métodos de los recorridos del Arbol
    public void mostrarInOrden() {
        inOrden(raiz);
        System.out.println();
    }
    
    public void inOrden(Nodo nodo) {
        if (nodo != null) {
        inOrden(nodo.getIzquierdo());
        System.out.print(nodo.getContenido() + " ");
        inOrden(nodo.getDerecho());
        }
    }

    public void mostrarPreOrden() {
        preOrden(raiz);
        System.out.println();
    }

    public void preOrden(Nodo nodo) {
        if (nodo != null) {
        System.out.print(nodo.getContenido() + " ");
        preOrden(nodo.getIzquierdo());
        preOrden(nodo.getDerecho());
        }
    }

    public void mostrarPostOrden() {
        postOrden(raiz);
        System.out.println();
    }

    private void postOrden(Nodo nodo) {
        if (nodo != null) {
        postOrden(nodo.getIzquierdo());
        postOrden(nodo.getDerecho());
        System.out.print(nodo.getContenido() + " ");
        }
    }

    // Método para buscar un nodo en el árbol
    public boolean contiene(int valor) {
        return buscarNodo(valor) != null;
    }

    public Nodo buscarNodo(int valor) {
        return buscarNodoRec(raiz, valor);
    }
    
    private Nodo buscarNodoRec(Nodo nodo, int valor) {
        if (nodo == null) return null;
        if (nodo.getIndice() == valor) return nodo;
    
        if (valor < nodo.getIndice())
            return buscarNodoRec(nodo.getIzquierdo(), valor);
        else
            return buscarNodoRec(nodo.getDerecho(), valor);
    }

    // Metodo para Mostrar la Altura del Arbol
    public int determinarAlturaArbol(){
        return alturaRec(raiz);
    }

    private int alturaRec(Nodo nodo) {
        if (nodo == null) return 0;
        return 1 + Math.max(alturaRec(nodo.getIzquierdo()), alturaRec(nodo.getDerecho()));
    }

    //Metodo para Contar Nodos de las Hojas
    public int contarHojas() {
        return contarHojasRec(raiz);
    }
            
    private int contarHojasRec(Nodo nodo) {
        if (nodo == null) return 0;
        if (nodo.getIzquierdo() == null && nodo.getDerecho() == null) return 1;
        return contarHojasRec(nodo.getIzquierdo()) + contarHojasRec(nodo.getDerecho());
    }

    //Metodo para Borrar un Nodo
    public void eliminarNodo(int valor) {
        raiz = eliminarRec(raiz, valor);
    }
    
    private Nodo eliminarRec(Nodo nodo, int valor) {
        if (nodo == null) return null;
    
        if (valor < nodo.getIndice()) {
            nodo.izquierda = eliminarRec(nodo.izquierda, valor);
        } else if (valor > nodo.getIndice()) {
            nodo.derecha = eliminarRec(nodo.derecha, valor);
        } else {
            // Caso 1: sin hijos
            if (nodo.izquierda == null && nodo.derecha == null) {
                return null;
            }
            // Caso 2: un hijo
            if (nodo.izquierda == null) return nodo.derecha;
            if (nodo.derecha == null) return nodo.izquierda;
    
            // Caso 3: dos hijos
            Nodo sucesor = encontrarMinimo(nodo.derecha);
            nodo.indice = sucesor.indice;
            nodo.contenido = sucesor.contenido;
            nodo.derecha = eliminarRec(nodo.derecha, sucesor.indice);
        }
    
        return nodo;
    }
    
    private Nodo encontrarMinimo(Nodo nodo) {
        while (nodo.izquierda != null) {
            nodo = nodo.izquierda;
        }
        return nodo;
    }

        // Vacíar el Arbol
        public void limpiar() {
        raiz = null;
        }

    public Nodo getRaiz(){
        return raiz;
    }
}
