import java.util.Scanner;
//умножение матриц
public class HomeWork {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int k = in.nextInt();
        int[][] a = new int[n][k];
        int[][] b = new int[n][k];
        int[][] c = new int[n][k];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < k; j++) {
                a[i][j] = in.nextInt();
            }
        }
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < k; j++) {
                b[i][j] = in.nextInt();
            }
        }
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < k; j++) {
                c[i][j] = 0;
                for (int p = 0; p < k; p++) {
                    c[i][j] += a[i][p] * b[p][j];
                }
            }
        }
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < k; j++) {
                System.out.print(c[i][j] + " ");
            }
            System.out.println();
        }

    }
}
