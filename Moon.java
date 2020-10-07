import java.util.HashSet;
import java.util.Scanner;

//количество уникальных символов

public class Moon {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String s = in.nextLine();
        HashSet<Integer> a = new HashSet<>();
        for (int i = 0; i < s.length(); i++) {
            a.add(Character.hashCode(s.charAt(i)));
        }
        System.out.println(a.size());
    }
}