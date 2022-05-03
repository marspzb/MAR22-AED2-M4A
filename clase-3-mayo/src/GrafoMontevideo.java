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

    private boolean existe(int idxOrigen, int idxDestino) {
        return aristas[idxOrigen][idxDestino].existe;
    }
}
