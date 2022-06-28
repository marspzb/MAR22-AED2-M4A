public
class SistemaUsuarios
{

    private CacheLRU cache;

    public
    SistemaUsuarios(int largo)
    {
        this.cache =new CacheLRUImpl(largo);
    }

    public String getNombre(String email){

        if(cache.estaEnCache(email)){
            return cache.getCache(email).nombre;
        }
        try
        {
            Thread.sleep(2000);
        }
        catch (InterruptedException e)
        {
            e.printStackTrace();
        }
        String nom= email.split("@")[0];
        cache.cachear(email,nom);
        return nom;
    }
}
