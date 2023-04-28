// Требуется вычислить i-ый элемент ряда Фибоначчи при условии что 10 ≤ i ≤ 100000.
// После этого вычислить наибольшее вхождение цифры в числе. Пр. f(10) = 55  # вернет [(2, 5)],
// поскольку 5-ка присутствует наибольшее количество раз в числе и оно равно двум.
// Если две цифры имеют одинаковое количество вхождений то выводим нибольшее из них.
// Алгоритм должен быть эффективным и выполняться не миллион лет.

import java.util.Arrays;
import java.util.Scanner;

public class FibonacciDigitCount {
    public static int[][] fibonacciDigitCount(int i) {

        int[] fib = new int[i+1];
        fib[0] = 0;
        fib[1] = 1;
        for (int j = 2; j <= i; j++) {
            fib[j] = fib[j-1] + fib[j-2];
        }


        int[] digitCounts = new int[10];
        for (char digit : Integer.toString(fib[i]).toCharArray()) {
            digitCounts[Character.getNumericValue(digit)]++;
        }


        int maxDigits = -1;
        int maxCount = 0;
        for (int digit = 0; digit < 10; digit++) {
            if (digitCounts[digit] > maxCount) {
                maxDigits = digit;
                maxCount = digitCounts[digit];
            } else if (digitCounts[digit] == maxCount && maxDigits != -1) {
                maxDigits = Math.max(maxDigits, digit);
            }
        }

        return new int[][]{{maxCount, maxDigits}};
    }

    public static void main(String[] args) {

            Scanner scanner = new Scanner(System.in);
            System.out.print("Enter an integer between 10 and 100000: ");
            int i = scanner.nextInt();
            scanner.close();

            int[][] result = fibonacciDigitCount(i);

            System.out.println("f(" + i + ") = " + Arrays.toString(result[0]));
    }
}