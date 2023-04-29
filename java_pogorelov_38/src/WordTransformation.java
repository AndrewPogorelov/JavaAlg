// В программу поступает текст в виде одного или нескольких предложений.
// Нужно изменить текст следующим образом: переместить первую букву каждого
// слова в конец и добавить текст "ауч". Знаки препинания не трогаем.
import java.util.Scanner;

public class WordTransformation {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter text: ");
        String input = scanner.nextLine();

        input = input.replaceAll("[^\\p{L}\\s]+", "");

        String[] words = input.split("\\s+");
        StringBuilder sb = new StringBuilder();
        for (String word : words) {
            sb.append(word.substring(1)).append(word.charAt(0)).append("Ауч ");
        }

        System.out.println(sb.toString().trim());
    }
}