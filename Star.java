import java.util.Arrays;
import java.util.Scanner;
//палиндром
public class Star {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String s = in.next();
        char[] v = new char[s.length()];
        int cnt = 0;
        for (int i = s.length() - 1; i >= 0; i--) {
            v[i] = s.charAt(cnt);
            cnt++;
        }
        System.out.println(Arrays.equals(v, s.toCharArray()));
    }
}