public
class NodoListaDoble<T>
{
    public T dato;
    public NodoListaDoble<T> prev;
    public NodoListaDoble<T> next;

    public
    NodoListaDoble(final T dato)
    {
        this.dato = dato;
    }

    public
    NodoListaDoble(final T dato,
                   final NodoListaDoble<T> prev,
                   final NodoListaDoble<T> next)
    {
        this.dato = dato;
        this.prev = prev;
        this.next = next;
    }
}
