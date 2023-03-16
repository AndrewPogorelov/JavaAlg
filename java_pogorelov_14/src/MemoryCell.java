// Дана ячейка памяти хранящая максимум три числа.
// При вводе числа если есть пустые ячейки, она
// заполняется введенным числом. Если пустых ячеек нет
// введенное число заменяет наименьшее из уже записанных.
import java.util.Scanner;

public class MemoryCell {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] numbers = new int[3];

        for (int i = 0; i < numbers.length; i++) {
            System.out.print("Enter a number: ");
            int inputNumber = scanner.nextInt();

            if (i == 0 || inputNumber > numbers[0]) {
                numbers[2] = numbers[1];
                numbers[1] = numbers[0];
                numbers[0] = inputNumber;
            } else if (i == 1 || inputNumber > numbers[1]) {
                numbers[2] = numbers[1];
                numbers[1] = inputNumber;
            } else {
                numbers[2] = inputNumber;
            }
        }

        System.out.println("The numbers in memory are: " + numbers[0] + ", " + numbers[1] + ", " + numbers[2]);
    }
}