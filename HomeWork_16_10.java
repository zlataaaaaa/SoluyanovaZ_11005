import java.sql.SQLOutput;
import java.util.Arrays;

public class HomeWork_16_10 {

    // Написать метод, который считает количество разрядов числа.
    public static int CounterOfCategory(int n) {
        int k = 0;
        while (n>0) {
            n /= 10;
            k++;
        }
        return k;
    }

    // Написать метод, который выводит строку в обратном порядке
    public static String ReverseString(String s) {
        String[] arr;
        arr = s.split("");
        String[] arg;
        arg = new String [arr.length];
        int a = 0;

        for (int i = arg.length - 1; i >= 0; i--) {
            arg[a] = arr[i];
            a++;
        }
        return Arrays.toString(arg);
    }

    // Написать метод, который находит максимальное значение массива
    public static int MaxValue(int[] arg) {
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < arg.length; i++) {
            if (arg[i] > max) {
                max = arg[i];
            }
        }
        return max;
    }

    // Написать метод, который принимает два массива и “склеивает” их (для массивов {1,3,5} и {2,4,6} будет результат {1,3,5,2,4,6})
    public static String MergerOfArrays(int []c, int[]a) {
        int[] newArray;
        newArray = new int[c.length + a.length];

        for (int i = 0; i < newArray.length; i++) {

            if (i < c.length) {
                newArray[i] = c[i];
            }

            if (c.length <= i) {
               newArray[i] = a[i - c.length] ;
            }
        }
        return Arrays.toString(newArray);
    }

    // Написать метод, который принимает на вход матрицу и транспонирует её
    public static int[][] TransponingMatrix(int [][]m) {
        int[][] matrix2 = new int[m[0].length][m.length];

        for (int i = 0; i < matrix2.length; i++) {
            for (int j = 0; j < matrix2[i].length; j++) {
                matrix2[i][j] = m[j][i];
            }
        }

        /*for (int f = 0; f < m[0].length; f++){
            for (int q = 0; q < m.length; q++){
                System.out.print(matrix2[f][q] + " ");
            }
            System.out.print("\n");
        }
        System.out.println("");*/
        return matrix2;
    }

    // Написать метод, который принимает на вход две матрицы и возвращает их сумму
    public static int[][] SumOfMatrix(int[][] m1, int[][] m2) {
        int[][] matrix3 = new int[m1.length][m1[0].length];

        for (int i = 0; i < m1.length; i++) {
            for (int j = 0; j < m1[i].length; j++) {
                matrix3[i][j] = m1[i][j] + m2[i][j];
            }
        }

        return matrix3;
    }



    public static void main(String[] args) {
        // Fisrt
        int f = 1;
        System.out.print("Разрядность числа: ");
        System.out.println(CounterOfCategory(f));

        // Second
        String d = "HEllo, Bob! How are you?";
        System.out.print("Строка в обратном порядке: ");
        System.out.println(ReverseString(d));

        // Third
        int []kl = {2,56,37,12,79,063,326,284,23,848};
        System.out.print("Максимальное значение: ");
        System.out.println(MaxValue(kl));

        // Fourth
        int []aq1 = {1,3,5};
        int []aq2 = {2,4,6};
        System.out.print("Массив полученный после слияния: ");
        System.out.println(MergerOfArrays(aq1,aq2));

        // Fifth
        int[][] matrix = {
                {1, 5, 7},
                {5, 7, 2},
                {9, 0, 3},
                {4, 5, 8},

        };
        int[][] newMatrix;
        newMatrix = TransponingMatrix(matrix);
        for (int s = 0; s < newMatrix.length; s++){
            for (int q = 0; q < newMatrix[s].length; q++){
                System.out.print(newMatrix[s][q] + " ");
            }
            System.out.print("\n");
        }
        System.out.println("");

        // Sixth
        int[][] matrix2 = {
                {5, 7, 1},
                {0, 4, 7},
                {8, 6, 3},
                {2, 8, 1},

        };
        int[][] sumMatrix;

        sumMatrix = SumOfMatrix(matrix, matrix2);

        for (int r = 0; r < sumMatrix.length; r++){
            for (int q = 0; q < sumMatrix[r].length; q++){
                System.out.print(sumMatrix[r][q] + " ");
            }
            System.out.print("\n");
        }
        System.out.println("");

    }
}
