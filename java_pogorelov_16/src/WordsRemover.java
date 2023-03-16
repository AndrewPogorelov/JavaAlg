// На ввод поступает строка символов.
// Преобразовать всю строку к верхнему
// регистру если заглавных символов больше
// чем строчных и наоборот. В случае если
// символов равное количество - преобразовать
// к строчному виду. Пр. ABccAAr → ABCCAAR | abCCaaR → abccaar
import java.util.Scanner;

public class WordsRemover {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();

        int upperCount = 0, lowerCount = 0;
        for (int i = 0; i < input.length(); i++) {
            char c = input.charAt(i);
            if (Character.isUpperCase(c)) {
                upperCount++;
            } else if (Character.isLowerCase(c)) {
                lowerCount++;
            }
        }

        if (upperCount > lowerCount) {
            input = input.toUpperCase();
        } else if (lowerCount > upperCount) {
            input = input.toLowerCase();
        } else {
            input = input.toLowerCase();
        }

        System.out.println(input);
    }
}