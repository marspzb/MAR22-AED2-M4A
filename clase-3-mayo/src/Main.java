public class Main {

    public static void main(String [] args) throws EstructuraLlenaException {

        GrafoMontevideo g=new GrafoMontevideo(5);
        Esquina a=new Esquina("A");
        Esquina  b=new Esquina("B");
        Esquina c=new Esquina("C");
        Esquina d=new Esquina("D");
        Esquina e=new Esquina("E");


        g.agregarVertice(a);
        g.agregarVertice(b);
        g.agregarVertice(c);
        g.agregarVertice(d);
        g.agregarVertice(e);

        g.agregarArista(a,a,new Cuadra(2));
        g.agregarArista(a,b,new Cuadra(2));
        g.agregarArista(a,c,new Cuadra(2));
        g.agregarArista(b,e,new Cuadra(2));
        g.agregarArista(e,b,new Cuadra(2));
        g.agregarArista(e,d,new Cuadra(2));
        g.agregarArista(d,a,new Cuadra(2));
        g.agregarArista(c,d,new Cuadra(2));


       // g.esquinasAdyacentes(a).listar();
        //g.esquinasIncidentes(b).listar();

        g.bfs(a, new Visitor<Esquina>() {
            @Override
            public void visitar(Esquina vertice) {
                System.out.print(vertice+",");
            }
        });
        System.out.println();

    }
}
