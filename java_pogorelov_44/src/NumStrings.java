// Программа принимает на вход два числа в формате строки.
// Требуется сложить эти числа и вернуть результат в формате строки.
// Все числа положительные.
import java.math.BigInteger;
import java.util.Scanner;

public class NumStrings {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String num1;
        String num2;
        do {
            System.out.print("Enter the first positive number: ");
            num1 = scanner.next();
            System.out.print("Enter the second positive number: ");
            num2 = scanner.next();
        } while (!isPositive(num1) || !isPositive(num2));

        BigInteger a = new BigInteger(num1);
        BigInteger b = new BigInteger(num2);
        BigInteger sum = a.add(b);

        System.out.println("The sum of the two numbers is: " + sum);
    }

    private static boolean isPositive(String num) {
        try {
            int n = Integer.parseInt(num);
            if (n < 0) {
                System.out.println("Error! The number must be positive!!!");
            }
            return n > 0;
        } catch (NumberFormatException e) {
            System.out.println("Error! Invalid input format.");
            return false;
        }
    }
}