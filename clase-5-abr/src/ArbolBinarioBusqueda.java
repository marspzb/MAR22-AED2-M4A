public class ArbolBinarioBusqueda {
    private class NodoABB{
        private int dato;
        private NodoABB izq;
        private NodoABB der;

        public NodoABB(int dato) {
            this.dato = dato;
        }

        public NodoABB(int dato, NodoABB izq, NodoABB der) {
            this.dato = dato;
            this.izq = izq;
            this.der = der;
        }
    }
    private NodoABB raiz;

    public int minimo(){
        return minimo(raiz);
    }
    private int minimo( NodoABB noodo){
        if(noodo==null){return Integer.MAX_VALUE;}
        else if(noodo.izq==null)return noodo.dato;
        else return minimo(noodo.izq);

    }
    public boolean pertenece(int dato){
        return pertenece(raiz,dato);
    }

    private boolean pertenece(NodoABB raizSubArbol, int dato) {
        if(raizSubArbol==null){
            return false;

        }else if(raizSubArbol.dato==dato){
            return true;
        }else if(dato<raizSubArbol.dato){
            return pertenece(raizSubArbol.izq,dato);
        }else{
            return pertenece(raizSubArbol.der,dato);
        }
    }


    public  void insertar(int dato){

        raiz=insertarMagico(raiz,dato);
        /*if(raiz==null){
            this.raiz=new NodoABB(dato);
        }else{
            this.insertar(raiz,dato);
        }*/

    }
    private NodoABB insertarMagico(
            NodoABB nodo,
            int dato) {
        if(nodo==null){
            return new NodoABB(dato);
        }else if(dato<nodo.dato){
            nodo.izq=insertarMagico(nodo.izq,dato);
        }else if(dato>nodo.dato){
            nodo.der=insertarMagico(nodo.der,dato);
        }
        return nodo;
    }

    private void insertar(NodoABB nodo, int dato) {
        if(nodo==null)throw new RuntimeException("Error no funciona el metodo");
        else if(nodo.dato==dato){
            return;
        }else if(dato<nodo.dato){
            if(nodo.izq==null)//es vacio
                nodo.izq=new NodoABB(dato);
            else
                insertar(nodo.izq,dato);
        }else {//es mayor
            if(nodo.der==null){
                nodo.der=new NodoABB(dato);
            }else{
                insertar(nodo.der,dato);
            }

        }

    }
    public void listarOrdenado(){
        listarOrdenado(raiz);
    }

    private void listarOrdenado(NodoABB raizSubArbol) {
        if(raizSubArbol==null){
            return;
        }
        listarOrdenado(raizSubArbol.izq);//listo los que son menores
        System.out.print(raizSubArbol.dato+",");
        listarOrdenado(raizSubArbol.der);//listo los que son mayores
    }
}
