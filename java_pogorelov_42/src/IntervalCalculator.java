// Напишите программу которая производит расчет количества чисел между заданными интервалами и возвращает
// количество всех этих чисел.
// Пример: [1, 2], [6, 10], [11, 15] => 9
import java.util.Scanner;

public class IntervalCalculator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter intervals in the form start-end: ");
        String input = scanner.nextLine().trim();

        int count;
        try {
            count = calculateCount(input);
            System.out.println("The total count is: " + count);
        } catch (IllegalArgumentException e) {
            System.out.println("Invalid input: " + e.getMessage());
        }
    }

    private static int calculateCount(String input) {
        int count = 0;

        String[] intervals = input.split(",");
        for (String interval : intervals) {
            int[] arr = parseInterval(interval);
            count += (arr[1] - arr[0]);
        }

        return count;
    }

    private static int[] parseInterval(String interval) throws IllegalArgumentException {
        interval = interval.trim();
        if (!interval.matches("\\d+\\s*\\-\\s*\\d+")) {
            throw new IllegalArgumentException("Invalid interval: " + interval);
        }

        String[] parts = interval.split("-");
        int start = Integer.parseInt(parts[0].trim());
        int end = Integer.parseInt(parts[1].trim());

        if (start > end) {
            throw new IllegalArgumentException("Invalid interval: " + interval);
        }

        return new int[] {start, end};
    }
}