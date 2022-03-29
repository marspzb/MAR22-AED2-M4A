public class Main {


    public static void main(String[]args){
        hanoi(3,'I','A','F');
    }
    private  static  void hanoi(int cantidadDiscos, char colInicial, char colAuxiliar, char colFinal){
        if(cantidadDiscos==0){
            return;
        }

        hanoi(cantidadDiscos-1,colInicial,colFinal,colAuxiliar);
        System.out.println("Mover disco "+cantidadDiscos+ " de "+colInicial +" a "+colFinal);
        hanoi(cantidadDiscos-1,colAuxiliar,colInicial,colFinal);
    }
}
