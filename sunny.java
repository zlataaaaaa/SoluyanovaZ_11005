import java.util.Scanner;
public class sunny {
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        System.out.print("ввести число,факториал которого нужно унать: ");
        int count = in.nextInt();
        System.out.print(factorial(count));
    }
    private static int factorial(int count){
        if (count == 1){
            return 1;
        }
        return count*factorial(count-1);
    }
}
