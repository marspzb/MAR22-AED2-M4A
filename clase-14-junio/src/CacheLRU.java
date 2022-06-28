public
interface CacheLRU
{
    DatosUsuario getCache(String email);

    boolean estaEnCache(String email);

    void cachear(String email,
                 String nombreUsuario);
}
