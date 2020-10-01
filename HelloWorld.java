import java.util.Scanner;

public class Day {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int r = in.nextInt();
        int n = in.nextInt();
        int[][] a = new int[r][n];
        for (int i = 0; i < r; i++) {
            for (int j = 0; j < n; j++) {
                a[i][j] = in.nextInt();
            }
        }
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n - i; j++) {
                if (j != n - i - 1) {
                    if (a[0][j] > a[0][j + 1]) {
                        for (int k = 0; k < r; k++) {
                            int temp = a[k][j];
                            a[k][j] = a[k][j + 1];
                            a[k][j + 1] = temp;
                        }
                    }
                }
            }
        }
        for (int i = 0; i < r; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print(a[i][j] + " ");
            }
            System.out.println();
        }

    }
}
дз:сортировка столбцов