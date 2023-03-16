//На ввод поступает три числа: начало ряда, шаг, количество шагов.
// Выведите на экран все числа полученного ряда. Пр. 1 2 5 → 1, 3, 5, 7, 9
import java.util.Scanner;

public class NumberSeries {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the first number: ");
        int firstNumber = scanner.nextInt();

        System.out.print("Enter the step: ");
        int step = scanner.nextInt();

        System.out.print("Enter the number of steps: ");
        int numSteps = scanner.nextInt();

        // Print the series of numbers
        for (int i = 0; i < numSteps; i++) {
            int number = firstNumber + i * step;
            System.out.print(number + " ");
        }
    }
}
