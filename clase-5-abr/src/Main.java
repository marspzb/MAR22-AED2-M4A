public class Main {
    public static void main(String[] args) {
        ArbolBinarioBusqueda abb=new ArbolBinarioBusqueda();

        abb.insertar(5);
        abb.insertar(15);
        abb.insertar(25);
        abb.insertar(60);
        abb.insertar(81);
        abb.insertar(22);
        abb.insertar(1);
        abb.insertar(4);

System.out.println(
        String.format(
                "El amigo %s pertenece %s",
                81,
                abb.pertenece(81)));
        System.out.println(
                String.format(
                        "El amigo %s algo mas pertenece %s",
                        22,
                        abb.pertenece(22)));

        System.out.println(
                String.format(
                        "El amigo %s algo mas pertenece %s",
                        13,
                        abb.pertenece(13)));
        abb.insertar(13);
        System.out.println(
                String.format(
                        "El amigo %s algo mas pertenece %s",
                        13,
                        abb.pertenece(13)));

        System.out.printf("El minimo del abb es %s\n",abb.minimo());
        abb.listarOrdenado();
        System.out.println();
    }
}
