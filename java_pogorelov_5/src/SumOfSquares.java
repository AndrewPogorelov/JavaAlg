import java.util.Scanner;

public class SumOfSquares {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter numbers separated by spaces: ");
        String input = scanner.nextLine();

        String[] numbers = input.split("\\s+");

        int sum = 0;
        for (String number : numbers) {
            int n = Integer.parseInt(number);
            sum += n * n;
        }

        System.out.println("Sum of squares: " + sum);
    }
}