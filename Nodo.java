public class Nodo {
    int indice;
    Nodo padre;
    Nodo izquierda;
    Nodo derecha;
    Object contenido;

    //constructor que inicializa al nodo con un indice
    public Nodo (int valor){
        this.indice = valor; //asigna un indice al nodo
        this.padre = null; //el nodo padre está vacío
        this.izquierda = null; //hijo de la izquierda vacio
        this.derecha = null; //hijo de la derecha vacio
        this.contenido = null; //contenido vacio al inicio
    }

    public int getIndice() {
        return indice;
    }
    
    public Object getContenido() {
        return contenido;
    }
    
    public Nodo getIzquierdo() {
        return izquierda;
    }
    
    public Nodo getDerecho() {
        return derecha;
    }
}
