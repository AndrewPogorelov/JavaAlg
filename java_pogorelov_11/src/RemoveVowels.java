//Программа, которая удаляет все гласные из введенной строки.
import java.util.Scanner;

public class RemoveVowels {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter a string: ");
        String input = scanner.nextLine();

        String output = removeVowels(input);

        System.out.println("Result: " + output);
    }

    public static String removeVowels(String input) {
        return input.replaceAll("[ ауоыиэяюёеАУОЫИЭЯЮЁЕ]", "");
    }
}