public class MainSumaDiag
{
    static int sumaDiagDoble(int [][] mat){
        //pre: matriz cuadrada
        int suma=0;

        for(int f=0;f<mat.length;f++){
            for(int c=0;c<mat[f].length;c++){
                if(f==c || c==mat.length-1-f){
                    suma+=mat[f][c];
                }
            }
        }
        return suma;
    }
    static  int sumaSimple(int[][]mat){
        int suma=0;
        for(int i=0;i<mat.length;i++){
            suma+=mat[i][i];
            suma+=mat[i][mat.length-1-i];
        }
        if(mat.length%2==1){//es impar
            suma-=mat[mat.length/2][mat.length/2];
        }
        return suma;
    }
    public static void main(String [] args){
        int[][] mat=new int[][]{
                new int[]{1,2,3,4,5},
                new int[]{2,1,3,5,4},
                new int[]{2,3,1,5,4},
                new int[]{2,5,3,1,4},
                new int[]{5,2,3,5,1},
        };
        System.out.println(sumaDiagDoble(mat));
        System.out.println(sumaSimple(mat));
    }
}
