public class NodoAB {
    private int dato;
    private NodoAB izq;
    private NodoAB der;

    public NodoAB(int dato) {
        this.dato = dato;
    }

    public NodoAB(int dato, NodoAB izq, NodoAB der) {
        this.dato = dato;
        this.izq = izq;
        this.der = der;
    }

    public int getDato() {
        return dato;
    }

    public void setDato(int dato) {
        this.dato = dato;
    }

    public NodoAB getIzq() {
        return izq;
    }

    public void setIzq(NodoAB izq) {
        this.izq = izq;
    }

    public NodoAB getDer() {
        return der;
    }

    public void setDer(NodoAB der) {
        this.der = der;
    }
}
