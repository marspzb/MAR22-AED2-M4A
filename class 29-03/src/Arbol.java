public class Arbol {

    private NodoAB raiz;

    public Arbol(NodoAB raiz) {
        this.raiz = raiz;
    }

    public int cantHojas(){
        return cantHojas(raiz);
    }

    private boolean esVacio(NodoAB n){
        return n==null;
    }
    private  boolean esHoja(NodoAB n){
        return esVacio(n.getIzq()) &&
                esVacio(n.getDer());

    }
    private int cantHojas(NodoAB nodo) {
        if(esVacio(nodo)){//ES Vacio
            return 0;
        }else if(esHoja(nodo)){
return 1;
        }else{
            return cantHojas(nodo.getDer())+
                    cantHojas(nodo.getIzq());
        }
    }
    public int altura(){
        return altura(raiz);
    }

    private int altura(NodoAB ab){
        if(esVacio(ab)){
            return -1;
        }else if(esHoja(ab)){
return 0;
        }else{
            return 1+Math.max(altura(ab.getIzq()),altura(ab.getDer()));
        }

    }

    public  boolean esIgualA(Arbol b){
        return iguales(this.raiz,b.raiz);
    }

    private boolean iguales(NodoAB nodoA, NodoAB nodoB) {
        if(esVacio(nodoA)||esVacio(nodoB))
            return esVacio(nodoA)&&esVacio(nodoB);
        else
            return
                    nodoA.getDato()==nodoB.getDato()
            && iguales(nodoA.getIzq(),nodoB.getIzq())
            &&iguales(nodoA.getDer(),nodoB.getDer());
    }
    public Arbol clon(){
        return new Arbol(clon(raiz));
    }

    private NodoAB clon(NodoAB nodo) {
        if(esVacio(nodo))return null;
        else{
            NodoAB clonIzquierdo=clon(nodo.getIzq());
            NodoAB clonDerecho=clon(nodo.getDer());
            return new NodoAB(nodo.getDato(),
                    clonIzquierdo,
                    clonDerecho);
        }

    }
}
