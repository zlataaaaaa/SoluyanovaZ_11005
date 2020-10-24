import java.util.Scanner;
public class sunny3 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.print("функция аккермана: ");
        System.out.print("ввести число a: ");
        int a = in.nextInt();
        System.out.print("ввести число b: ");
        int b = in.nextInt();
        int c = acerman(a,b);
        System.out.print(c);
    }
    private static int acerman(int a,int b){
        if (a==0){
            return b+1;

        }
        if((a>0)&&(b==0)){
            return acerman(a-1,1);
        }
        return acerman(a-1,acerman(a,b-1));
    }
}
