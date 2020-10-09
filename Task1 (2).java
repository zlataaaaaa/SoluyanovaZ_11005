import java.util.*;

public class Task1 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        int [] array = new int[n];

        for (int i = 0; i < n; i++) {
            array[i] = sc.nextInt();
        }

        Arrays.sort(array);

        System.out.println(find(sc.nextInt(), array, 0, array.length - 1));
    }

    public static boolean find(int value, int [] array, int begin, int n) {
        int middle = begin + (n / 2);

        if (array[middle] > value) {
            return find(value, array, begin, n / 2);
        }
        if (array[n] < value) {
            return find(value, array, middle, n / 2);
        }
        if (array[n] == value) {
            return true;
        }
        return false;
    }
}
