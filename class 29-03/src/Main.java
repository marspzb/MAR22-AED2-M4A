public class Main {

    public static void main(String[] args) {

        NodoAB r = crearArbol();
        //r.getIzq().getDer().setDato(200);
        Arbol a=new Arbol(r);
        Arbol b=new Arbol(crearArbol());

        //System.out.println(a.esIgualA(b));
System.out.println(a.esIgualA(a.clon()));
    }

    private static NodoAB crearArbol() {
        NodoAB rIzqIzq=new NodoAB(10);
        NodoAB rIzqDerIzq=new NodoAB(20,
                new NodoAB(25),
                new NodoAB(23,
                        null,
                        new NodoAB(20)));

        NodoAB rIzqDer=new NodoAB(2,rIzqDerIzq,
                new NodoAB(3));
        NodoAB rIzq=new NodoAB(15,rIzqIzq,rIzqDer);
        NodoAB rDer=new NodoAB(52);
        NodoAB r=new NodoAB(1,rIzq,rDer);
        return r;
    }
}
