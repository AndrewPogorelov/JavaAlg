// На ввод поступает ряд чисел. Первые два числа задают ряд M..N,
// все последующие являются делителями. Посчитайте сумму всех чисел
// в ряде, которые делятся на один из делителей без остатка.
import java.util.Scanner;

public class DivisibleSum {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the starting number M: ");
        int M = scanner.nextInt();

        System.out.print("Enter the ending number N: ");
        int N = scanner.nextInt();

        System.out.print("Enter the number of divisors: ");
        int numDivisors = scanner.nextInt();

        System.out.print("Enter the divisors: ");
        int[] divisors = new int[numDivisors];
        for (int i = 0; i < numDivisors; i++) {
            divisors[i] = scanner.nextInt();
        }

        for (int divisor : divisors) {
            int sum = 0;
            for (int num = M; num <= N; num++) {
                if (num % divisor == 0) {
                    sum += num;
                }
            }
            System.out.println("Sum for divisor " + divisor + ": " + sum);
        }
    }
}



