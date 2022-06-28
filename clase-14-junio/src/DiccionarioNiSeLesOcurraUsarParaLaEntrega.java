import java.util.HashMap;
import java.util.Map;

public
class DiccionarioNiSeLesOcurraUsarParaLaEntrega<K,V> implements Diccionario<K,V>
{

    private Map<K,V> mapa=new HashMap<>();

    @Override
    public
    void agregar(final K clave,
                 final V valor)
    {
        mapa.put(clave,valor);
    }

    @Override
    public
    V obtener(final K clave)
    {
        return mapa.get(clave);
    }

    @Override
    public
    boolean existe(final K clave)
    {
        return mapa.containsKey(clave);
    }

    @Override
    public
    void remover(final K clave)
    {
        mapa.remove(clave);
    }
}
