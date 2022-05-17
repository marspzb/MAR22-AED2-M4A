import java.util.ArrayDeque;
import java.util.Queue;

public class GrafoMontevideo
{

    private class Arista{
        private boolean existe;
        private final   int idxOrigen;
        private  final int idxDestino;
        private Cuadra cuadra;
        public Arista(int idxOrigen, int idxDestino) {
            this.idxOrigen = idxOrigen;
            this.idxDestino = idxDestino;
        }


    }
    private final Esquina[] vertices;
    private final Arista[][] aristas;
    private final  int maxVertices;
    private int largo;

    public GrafoMontevideo(int maxVertices) {
        this.maxVertices = maxVertices;
        this.vertices=new Esquina[maxVertices];
        this.aristas=new Arista[maxVertices][maxVertices];
        for (int i = 0; i < maxVertices; i++) {
            for (int j = 0; j < maxVertices; j++) {
                this.aristas[i][j]=new Arista(i,j);
            }

        }
    }

    public void agregarVertice(Esquina esq) throws EstructuraLlenaException{
        if(maxVertices==largo){
            throw new EstructuraLlenaException();
        }
        this.vertices[largo]=esq;
        this.largo++;
    }
    private int buscarIndice(Esquina esq){
        for (int i = 0; i < vertices.length; i++) {
            if(vertices[i].equals(esq)){
                return i;
            }
        }
        return -1;
    }

    public void agregarArista(Esquina origen,
                              Esquina destino,
                              Cuadra c) {
        int idxOrigen=this.buscarIndice(origen);
        int idxDestino=this.buscarIndice(destino);

        this.aristas[idxOrigen][idxDestino].existe=true;
        this.aristas[idxOrigen][idxDestino].cuadra=c;
    }

    public ListaEnlazada<Esquina> esquinasAdyacentes(Esquina origen){
        ListaEnlazada<Esquina> adyacentes=new ListaEnlazada<>();
        int idxOrigen=buscarIndice(origen);//fila;
        for (int destino = 0; destino < maxVertices; destino++) {
            if(aristas[idxOrigen][destino].existe){
                Arista a=aristas[idxOrigen][destino];

                adyacentes.agregarInicio(vertices[destino]);
            }
        }
        return adyacentes;

    }
    public ListaEnlazada<Esquina> esquinasIncidentes(Esquina destino){
        ListaEnlazada<Esquina> incidentes=new ListaEnlazada<>();
        int idxDestino=buscarIndice(destino);//columna;
        for (int origen = 0; origen < maxVertices; origen++) {
            if(aristas[origen][idxDestino].existe){
                incidentes.agregarInicio(vertices[origen]);
            }
        }
        return incidentes;
    }
    public void dfs(Esquina origen,Visitor<Esquina> visitador){
        Pila<Integer> frontera=new Pila<Integer>();
        int idxOrigen=buscarIndice(origen);
        boolean [] visitados=new boolean[maxVertices];
        frontera.push(idxOrigen);
        while(!frontera.esVacia()){
            int verticeAExplorar=frontera.pop();

            if(!visitados[verticeAExplorar]){
                visitador.visitar(vertices[verticeAExplorar]);

                visitados[verticeAExplorar]=true;
                //foreach de los adyacentes !
                for (int destino = 0; destino < maxVertices; destino++) {
                    if(aristas[verticeAExplorar][destino].existe){
                        frontera.push(destino);
                    }
                }
            }


        }

    }
    public void bfs(Esquina origen,Visitor<Esquina> visitador){
        Queue<Integer> frontera=new ArrayDeque<>();//IMPERDONABLE EN EL OBLIGATORIO
        int idxOrigen=buscarIndice(origen);
        boolean [] visitados=new boolean[maxVertices];
        frontera.add(idxOrigen);//push
        while(!frontera.isEmpty()){//es vacia
            int verticeAExplorar=frontera.poll();//pop

            if(!visitados[verticeAExplorar]){
                visitador.visitar(vertices[verticeAExplorar]);

                visitados[verticeAExplorar]=true;
                //foreach de los adyacentes !
                for (int destino = 0; destino < maxVertices; destino++) {
                    if(aristas[verticeAExplorar][destino].existe){
                        frontera.add(destino);
                    }
                }
            }


        }

    }


    private boolean existe(int idxOrigen, int idxDestino) {
        return aristas[idxOrigen][idxDestino].existe;
    }
}
