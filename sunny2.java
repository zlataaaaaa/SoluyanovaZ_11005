import java.util.Scanner;
public class sunny2 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.print("ввести номер числа Фибоначи: ");
        int n =in.nextInt();
        n=n-2;
        long a=0;
        long b=1;
        long c=0;
        fib(a,b,n,c);
    }
    private static void fib(long a,long b,int n,long c){
        if (n!=0){
            n--;
            c=a+b;
            a=b;
            b=c;
        }
        else{
            System.out.print(c);
            return;
        }
        fib(a,b,n,c);
    }
}
