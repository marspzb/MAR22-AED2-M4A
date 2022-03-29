public class Main {

    static int suma(int[] vec,int desde,int hasta){
        if(desde==hasta)return vec[desde];
        else if (desde>hasta)return 0;
        else{
            int mid=(desde+hasta)/2;
            return suma(vec,desde,mid)+
                    suma(vec,mid+1,hasta);
        }

    }
    static int min(int[] vec,int indice){
        if(indice>=vec.length||indice<0)
            return Integer.MAX_VALUE;
        else
            return Math.min(vec[indice],
                    min(vec,indice+1));
    }
    static void imprimirMat(int[][] mat){
        for(int f=0;f<mat.length;f++){
            for(int c=0;c<mat[f].length;c++){
                if(c>=1)System.out.print(",");
                System.out.print(mat[f][c]);
            }
            System.out.println();
        }
    }
    static void imprimirFila(int[][] mat,int fila){

            for(int c=0;c<mat[fila].length;c++){
                if(c>=1)System.out.print(",");
                System.out.print(mat[fila][c]);
            }
            System.out.println();

    }
    static void imprimirColumna(int[][] mat,int col){

        for(int f=0;f<mat.length;f++){
            System.out.println(mat[f][col]);
        }

    }
    public static void main(String[] args){

        int[] vec=new int[]{2,3,5,8,5,1,12};
        System.out.println("La suma es "+
                suma(vec,0, vec.length-1));
        System.out.println("El minimo es "+
                min(vec,0));

        int[][] miMatriz=new int[][]{
                new int[]{1,2,3},
                new int[]{4,5,6},
                new int[]{7,8,9},
                new int[]{10,11,12}

        };
        //imprimirMat(miMatriz);
        //imprimirFila(miMatriz,2);
        imprimirColumna(miMatriz,1);
    }
}
