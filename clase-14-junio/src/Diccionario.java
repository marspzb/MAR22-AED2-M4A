public
interface Diccionario<K,V>
{
    void agregar(K clave,V valor);
    V obtener(K clave);
    boolean existe(K clave);
    void remover(K clave);

    static <K,V> Diccionario<K,V> implPorDef(){
        return new DiccionarioNiSeLesOcurraUsarParaLaEntrega<>();
    }
}
