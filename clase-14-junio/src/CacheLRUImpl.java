import java.util.LinkedList;
import java.util.Queue;

public
class CacheLRUImpl
    implements CacheLRU
{
    private final int maxLargo;
    private Diccionario<String,NodoListaDoble<DatosUsuario>> cache=Diccionario.implPorDef();
    private ListaDobleCacheLRU<DatosUsuario> colaLRU=new ListaDobleCacheLRU<>();
   // private
    //Queue<DatosUsuario> colaLRU=new LinkedList<>();
    public
    CacheLRUImpl(final int maxLargo)
    {
        this.maxLargo = maxLargo;
    }
    @Override
    public DatosUsuario getCache(String email){
        NodoListaDoble<DatosUsuario> cacheado= cache.obtener(email);
        if(cacheado!=null){
            colaLRU.eliminarNodoCualquiera(cacheado);
            cache.agregar(email, colaLRU.agregarFin(cacheado.dato));

            return cacheado.dato;
        }
        return null;
    }

    @Override
    public boolean estaEnCache(String email){
        return cache.existe(email);
    }


    @Override
    public void cachear(String email,
                        String nombreUsuario){
        while (colaLRU.getLargo()>=maxLargo){
            DatosUsuario aBorrar =colaLRU.removerInicio();
            cache.remover(aBorrar.email);
        }
        var datos=new DatosUsuario(email,nombreUsuario);
        cache.agregar(email,colaLRU.agregarFin(datos));
        ;

    }
}
