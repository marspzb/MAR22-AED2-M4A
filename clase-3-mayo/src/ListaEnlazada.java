public class ListaEnlazada<T> {

    private  class Nodo {
        private T dato;
        private  Nodo sig;

        public Nodo(T dato, Nodo sig) {
            this.dato = dato;
            this.sig = sig;
        }
    }
    private  Nodo inicio;


    public void agregarInicio(T dato){
        this.inicio=new Nodo(dato,inicio);
    }

    public  void listar(){
        Nodo n =inicio;
        while (n!=null){
            System.out.printf("%s,",n.dato);
            n=n.sig;


        }
        System.out.println();
    }
}
