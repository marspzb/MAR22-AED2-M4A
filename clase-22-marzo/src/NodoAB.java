public class NodoAB {
    private  int dato;
    private NodoAB izq;
    private NodoAB der;

    public int getDato() {
        return dato;
    }

    public NodoAB getIzq() {
        return izq;
    }

    public NodoAB getDer() {
        return der;
    }

    public NodoAB(int dato) {
        this.dato = dato;
    }

    public NodoAB(int dato, NodoAB izq, NodoAB der) {
        this.dato = dato;
        this.izq = izq;
        this.der = der;
    }
}
