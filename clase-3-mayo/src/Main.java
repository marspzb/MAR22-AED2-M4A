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
        //System.out.println(getGrafoGrande());
        getGrafoGrande().dijkstra(new Esquina("vS"),new Esquina("vG"),v->System.out.println(v.getNombre()));

    }
    static GrafoMontevideo getGrafoGrande() throws EstructuraLlenaException {
        GrafoMontevideo gf=new GrafoMontevideo(100);
        for (int i = 0; i < 9; i++) {
            gf.agregarVertice(new Esquina("v"+(i+1)));
        }
        for (int i = 0; i < 19; i++) {

            char nom=(char)('A'+i);
            if(nom!='I')
            gf.agregarVertice(new Esquina("v"+nom));
        }

        agCuadra(gf,"v1","v2",56);
        agCuadra(gf,"v2","v1",56);
        agCuadra(gf,"v2","v4",130);
        agCuadra(gf,"v4","v6",150);
        agCuadra(gf,"v6","v7",200);
        agCuadra(gf,"v7","v8",250);
        agCuadra(gf,"v8","vB",280);
        agCuadra(gf,"v8","v9",170);
        agCuadra(gf,"vB","vA",110);
        agCuadra(gf,"vB","vC",240);
        agCuadra(gf,"vC","vD",230);
        agCuadra(gf,"vA","v9",93);
        agCuadra(gf,"v9","vS",210);
        agCuadra(gf,"v9","vE",250);
        agCuadra(gf,"vS","v5",205);
        agCuadra(gf,"v5","v6",72);
        agCuadra(gf,"v5","v3",160);
        agCuadra(gf,"v4","v3",43);
        agCuadra(gf,"v3","v4",43);
        agCuadra(gf,"v3","v1",134);
        agCuadra(gf,"v1","vM",64);
        agCuadra(gf,"vM","vN",93);
        agCuadra(gf,"vM","vL",145);
        agCuadra(gf,"vL","vN",170);
        agCuadra(gf,"vL","vK",110);
        agCuadra(gf,"vK","vJ",120);
        agCuadra(gf,"vJ","vH",130);
        agCuadra(gf,"vH","vF",140);
        agCuadra(gf,"vH","vR",230);
        agCuadra(gf,"vR","vQ",200);
        agCuadra(gf,"vQ","vJ",160);
        agCuadra(gf,"vQ","vP",83);
        agCuadra(gf,"vP","vO",130);
        agCuadra(gf,"vO","vL",170);
        agCuadra(gf,"vF","vE",170);
        agCuadra(gf,"vE","vD",79);
        agCuadra(gf,"vD","vG",130);
        agCuadra(gf,"vF","vG",150);
        agCuadra(gf,"vG","vF",150);



        return gf;
    }
    private static void agCuadra(GrafoMontevideo gf,String orig,String dest,int metros){
        gf.agregarArista(new Esquina(orig),new Esquina(dest),new Cuadra(metros,true));
    }
}
