//На ввод поступает имя (пример аНнА).
// Выведите приветствие в формате: Привет, Анна!
import java.util.Scanner;

public class Greeting {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter your name: ");
        String name = scanner.nextLine();

        // Capitalize the first letter and lowercase the rest of the name
        String formattedName = name.substring(0, 1).toUpperCase() + name.substring(1).toLowerCase();

        System.out.println("Hello, " + formattedName + "!");
    }
}