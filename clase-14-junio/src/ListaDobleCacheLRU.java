public
class ListaDobleCacheLRU<T>
{
    private NodoListaDoble<T> inicio;
    private NodoListaDoble<T> fin;
    private int largo;

    public
    int getLargo()
    {
        return largo;
    }

    public NodoListaDoble<T> agregarInicio(T dato){
        var nuevo=new NodoListaDoble<>(dato,null,inicio);
        if(this.inicio!=null){
            this.inicio.prev=nuevo;

        }else{
            this.fin=nuevo;
        }
        this.inicio=nuevo;
        largo++;
        return nuevo;
    }
    public NodoListaDoble<T> agregarFin(T dato){
        var nuevo=new NodoListaDoble<>(dato,fin,null);
        if(fin!=null){
            fin.next=nuevo;
            nuevo.prev=fin;

        }else{
            this.inicio=nuevo;

        }
        fin=nuevo;
        largo++;
        return nuevo;
    }

    public T removerInicio(){
        if(inicio!=null){
            T dat=inicio.dato;
            this.inicio=eliminarNodo(inicio);
            if(inicio==null){
                fin=null;
            }
            largo--;
            return dat;
        }

        return null;
    }
    public T removerFin(){
        if(fin!=null)
        {
            var nuevoFin = fin.prev;
            eliminarNodo(fin);
            T dato=fin.dato;
            fin=nuevoFin;
            if(fin==null){
                inicio=null;
            }
            largo--;
            return dato;

        }
        return null;

    }
    public T eliminarNodoCualquiera(NodoListaDoble<T> nodo){
        if(nodo==inicio)return removerInicio();
        else if(nodo==fin) return removerFin();
        else
        {
            eliminarNodo(nodo);
            largo--;
           return nodo.dato;
        }
    }

    private NodoListaDoble<T> eliminarNodo(final NodoListaDoble<T> elemento)
    {
        if(elemento.prev!=null){
            elemento.prev.next=elemento.next;

        }
        if(elemento.next!=null){
            elemento.next.prev=elemento.prev;
        }
        return elemento.next;
    }
}
