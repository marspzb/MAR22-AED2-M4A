import java.io.PrintStream;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

public
class Main
{
    public static void main(String[] arrgs){

        SistemaUsuarios s=new SistemaUsuarios(5);


        buscarNombre(s,"marcos@gmail.com");
        buscarNombre(s,"marcos@gmail.com");
        buscarNombre(s,"pedro@gmail.com");
        buscarNombre(s,"roberto@gmail.com");
        buscarNombre(s,"carlos@gmail.com");
        buscarNombre(s,"gabriela@gmail.com");
        buscarNombre(s,"marcos@gmail.com");
        buscarNombre(s,"romina@gmail.com");
        buscarNombre(s,"marcos@gmail.com");
        buscarNombre(s,"pedro@gmail.com");
        buscarNombre(s,"marcos@gmail.com");
    }

    private static
    PrintStream buscarNombre(SistemaUsuarios s,
                             String email)
    {
        long start=System.currentTimeMillis();
        String nom=s.getNombre(email);

        return System.out.printf("[%s]Nombre: '%s', llevo: %.2f secs\n", LocalTime.now()
                                                                .format(DateTimeFormatter.ISO_LOCAL_TIME), nom,
                                 (System.currentTimeMillis()-start)/1000f);
    }
}
