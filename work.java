import java.util.Scanner;
//сложение матриц
public class work {
    public static void main (String[] args){
        Scanner in = new Scanner (System.in);
        int n = in.nextInt();
        int [] [] matrix = new int [n][n];
        int [] [] mat = new int [n] [n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                matrix[i][j]= in.nextInt();
            }
        }
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                mat[i][j]= in.nextInt();
            }
        }


        for (int i = 0; i < n; i++) {
            System.out.println();
            for (int j = 0; j < n; j++){
                mat [i][j] += matrix [i][j] ;
                System.out.print(mat [i][j] + " ");
            }

        }


    }
}
