
import java.util.Scanner;
//определитель 2*2
public class HomeWork2 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = 2;
        int k = 2;
        int [] [] a = new int[n][k];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < k; j++) {
                a [i][j] = in.nextInt();
            }
        }
        int s = a[0][0]*a[1][1] - a [0][1]* a[1][0];
        System.out.println(s);

    }
}
