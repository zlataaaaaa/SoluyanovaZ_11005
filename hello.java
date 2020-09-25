import java.util.Scanner;

public class hello {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[][] matrix = new int[n][n];
        int[][] b = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                matrix[i][j] = in.nextInt();
            }
        }
        for (int i = 0; i <n; i++) {
            for (int j = 0; j < n; j++) {
                b[i][j] = in.nextInt();
            }

        }
        for (int i = 0; i < n; i++) {
            System.out.println();
            for (int j = 0; j < n; j++) {
                b[i][j] += matrix [i][j];
                System.out.println(b[i][j] + " ");

            }


        }
    }
}
