import java.util.Scanner;
public class sunny1 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.print("вывести число,с которого нужно начать вывод: ");
        int m = in.nextInt();
        System.out.println("ввести последнее число: ");
        int n = in.nextInt();
        otADoB(m,n);

    }
    private static void otADoB(int m, int n){
        if (m<=n) {
            System.out.println(m);
            m++;
        }
        else{
            return;
        }
        otADoB(m,n);
    }
}
