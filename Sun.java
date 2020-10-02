import java.util.Scanner;
//самое длинное слово
public class Sun {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String s = in.nextLine();
        String[] list = s.trim().split("/s+");
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < list.length; i++) {
            if (list[i].length() > max) {
                max = list.length;
                s = list[i];
            }
        }
        System.out.println(s);
    }
}
