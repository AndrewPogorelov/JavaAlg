// На ввод поступает два числа. Наименьшее число является началом ряда,
// а также отвечает за шаг для получения следующего числа.
// Выведите все квадраты полученных чисел. Пр. 5, 1 → 1, 4, 9, 16, 25
import java.util.Scanner;

public class NumberSeries {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter a number: ");
        int num1 = scanner.nextInt();

        System.out.print("Enter another number: ");
        int num2 = scanner.nextInt();

        int smallest = num1 < num2 ? num1 : num2;
        int largest = num1 > num2 ? num1 : num2;

        int currentNumber = smallest;
        while (currentNumber <= largest) {
            System.out.print(currentNumber * currentNumber + " ");
            currentNumber += smallest;
        }
    }
}