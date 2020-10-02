import java.util.Scanner;
//определитель 3*3
public class HomeWork1 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = 3;
        int k = 3;
        int [] [] a = new int[n][k];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < k; j++) {
                a [i][j] = in.nextInt();
            }
        }
        int s = a[0][0]*a[1][1]*a[2][2] + a[1][0]*a[2][1]*a[0][2] + a[0][1]*a[1][2]*a[2][0] - a[2][0]*a[1][1]*a[0][2]-a[1][0]*a[0][1]*a[2][2]-a[2][1]*a[1][2]*a[0][0];
        System.out.println(s);

    }
}
