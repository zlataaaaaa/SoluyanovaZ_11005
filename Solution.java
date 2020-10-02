
import java.util.Scanner;
//транспонирование
public class Solution {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int k = in.nextInt();
        int matrix [][] = new int [n][k];
        int mat [] []= new int [k][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < k; j++) {
                matrix [i] [j] = in.nextInt();
            }
        }
        for (int i = 0; i < k; i++) {
            for (int j = 0; j < n; j++) {
                mat [i][j] = matrix [j][i];
            }
        }
        for (int i = 0; i < k; i++) {
            System.out.println();
            for (int j = 0; j < n; j++) {
                System.out.print(mat [i] [j] + " ");
            }
        }

    }
}