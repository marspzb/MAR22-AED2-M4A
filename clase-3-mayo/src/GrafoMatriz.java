public class GrafoMatriz<V,A> {

    private class Vertice<T>{
        T informacion;
        int idx;

        public Vertice(T informacion, int idx) {
            this.informacion = informacion;
            this.idx = idx;
        }
    }
    private class Arista<T>{
        T informacion;
        boolean existe=false;

        public T getInformacion() {
            return informacion;
        }

        public void setInformacion(T informacion) {
            this.informacion = informacion;
        }

        public boolean isExiste() {
            return existe;
        }

        public void setExiste(boolean existe) {
            this.existe = existe;
        }
    }
    private final Vertice<V>[] vertices;
    private final Arista<A>[][] matrizAdyacencia;
    private final int maxVertices;
    private int largo;
    public GrafoMatriz(int maxVertices){
        vertices=new Vertice[maxVertices];
        matrizAdyacencia=new Arista[maxVertices][maxVertices];
        this.maxVertices=maxVertices;
        for (int i = 0; i < matrizAdyacencia.length; i++) {
            for (int j = 0; j < matrizAdyacencia.length; j++) {
                matrizAdyacencia[i][j]=new Arista<>();
            }

        }

    }

    public void agregarVertice(V infoVertice) throws EstructuraLlenaException {
        if(largo==maxVertices)
            throw new EstructuraLlenaException();

        this.vertices[largo]=new Vertice<V>(infoVertice,largo);
        largo++;
    }

    private Vertice<V> buscar(V info){

        for (int i = 0; i <largo; i++) {
            if(this.vertices[i]!=null && vertices[i].informacion.equals(info)){
                return this.vertices[i];
            }
        }
        return null;
    }
    public void agregarArista(V origen,V destino,A info){
        Vertice<V> vOrigen=this.buscar(origen);
        Vertice<V> vDestino=this.buscar(destino);

        this.agregarArista(vOrigen.idx,vDestino.idx,info);


    }
    private void agregarArista(int idxOrigen,int idxDestino,A informacionArista){
        this.matrizAdyacencia[idxOrigen][idxDestino].setExiste(true);
        this.matrizAdyacencia[idxOrigen][idxDestino].setInformacion(informacionArista);

    }






}
