import java.util.*;

public class Task3 {

    private static final int n = 5;

    public static void main(String[] args) {
        Random random = new Random();

        int [][] array = new int [n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                array[i][j] = random.nextInt(10);
            }
        }

        System.out.println(check(array));
        System.out.println();

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print(array[i][j] + " ");
            }
            System.out.println();
        }
    }

    public static boolean check(int [][] array) {
        for (int i = (n / 4); i < n - (n / 4); i++) {

            int k = 0;

            for (int j = 0; j < i; j++) {
                if (array[j][i - j] % 2 == 0) {
                    k++;
                }
            }

            if (k >= n / 2) {
                return true;
            }
        }

        for (int i = n - (n / 4) - 1; i >= 0; i--) {

            int k = 0;

            for (int j = 0; j + i < n; j++) {
                if (array[j][i + j] % 2 == 0) {
                    k++;
                }
            }
            if (k >= n / 2) {
                return true;
            }
        }

        for (int i = 1; i < n - (n / 4); i++) {

            int k = 0;

            for (int j = 0; i + j < n; j++) {
                if (array[i + j][j] % 2 == 0) {
                    k++;
                }
            }
            if (k >= n / 2) {
                return true;
            }
        }

        return false;
    }
}
