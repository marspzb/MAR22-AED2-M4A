public class Cuadra {
    private final int metros;
    private final boolean sePuedeCaminar;

    public Cuadra(int metros, boolean sePuedeCaminar) {
        this.metros = metros;
        this.sePuedeCaminar = sePuedeCaminar;
    }
    public Cuadra (int metros){
        this(metros,false);
    }

    public int getMetros() {
        return metros;
    }

    public boolean isSePuedeCaminar() {
        return sePuedeCaminar;
    }
}
