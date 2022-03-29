public class Main {
    public static void main(String[] args){
        NodoAB raiz=new NodoAB(15,
                new NodoAB(2,
                        new NodoAB(4),
                        new NodoAB(5)),
                new NodoAB(2));
         Arbol ab=new Arbol(raiz);
         System.out.println(ab.cantidadNodos());
    }
}
