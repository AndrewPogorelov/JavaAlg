// Напишите программу, которая принимает целое положительное число и возвращает следующее большее число,
// которое можно составить, переставляя его цифры. В случае если перестановка чисел не принесет результата вернуть  -1 .
//        Пример:
//        23 ==> 32
//        523 ==> 532
//        2018 ==> 2081
//        1 ==> -1
//        532 ==> -1
import java.util.Scanner;

public class NextLargerNumber {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter a positive integer: ");
        int n = scanner.nextInt();

        int result = nextLargerNumber(n);
        if (result == -1) {
            System.out.println(result);
        } else {
            System.out.printf("The next larger number is %d.\n", result);
        }
    }

    public static int nextLargerNumber(int n) {
        char[] digits = Integer.toString(n).toCharArray();
        int i = digits.length - 2;
        while (i >= 0 && digits[i] >= digits[i + 1]) {
            i--;
        }
        if (i < 0) {
            return -1;
        }
        int j = digits.length - 1;
        while (j > i && digits[j] <= digits[i]) {
            j--;
        }
        swap(digits, i, j);
        reverse(digits, i + 1, digits.length - 1);
        int result = Integer.parseInt(new String(digits));
        return result;
    }

    public static void swap(char[] arr, int i, int j) {
        char temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public static void reverse(char[] arr, int i, int j) {
        while (i < j) {
            swap(arr, i, j);
            i++;
            j--;
        }
    }
}