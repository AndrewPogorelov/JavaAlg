//На ввод поступает две строки символов (пр. abc, bc).
// Верните true если вторая строка является окончанием
// первой и false в ином случае.
import java.util.Scanner;

public class EndsWith {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the first line: ");
        String firstLine = scanner.nextLine();

        System.out.print("Enter the second line: ");
        String secondLine = scanner.nextLine();

        boolean endsWith = firstLine.endsWith(secondLine);

        if (endsWith) {
            System.out.println("true");
        } else {
            System.out.println("false");
        }
    }
}