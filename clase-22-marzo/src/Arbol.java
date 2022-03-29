public class Arbol {
    private NodoAB raiz;

    public Arbol(NodoAB raiz) {
        this.raiz = raiz;
    }

    public  int cantidadNodos(){
        return cantidadNodos(raiz);
    }

    private int cantidadNodos(NodoAB nodoActual) {
        if(esVacio(nodoActual)){
            return 0;
        }else{
            return 1+cantidadNodos(nodoActual.getIzq())
                    +cantidadNodos(nodoActual.getDer());
        }
    }

    private boolean esVacio(NodoAB nodoActual) {
        return nodoActual==null;
    }
}
