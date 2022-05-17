public class Pila<T> {
    private ListaEnlazada<T> lista=new ListaEnlazada<>();

    public T pop(){

        return lista.eliminarInicio();
    }
    public void push(T dato){
        lista.agregarInicio(dato);
    }

    public boolean esVacia(){
        return lista.esVacia();
    }
}
