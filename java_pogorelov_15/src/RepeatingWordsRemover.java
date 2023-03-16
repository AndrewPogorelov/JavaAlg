import java.util.ArrayList;
import java.util.List;

// Введена строка из повторяющихся слов.
// Требуется удалить все слова оставив
// только 1 в строке: abc abc ab abc ab acs acs → abc ab acs
public class RepeatingWordsRemover {
    public static String removeRepeatingWords(String string) {
        String[] words = string.split("\\s+");
        List<String> nonRepeatingWords = new ArrayList<>();
        for (String word : words) {
            if (!nonRepeatingWords.contains(word)) {
                nonRepeatingWords.add(word);
            }
        }
        return String.join(" ", nonRepeatingWords);
    }

    public static void main(String[] args) {
        String string = "abc abc ab abc ab acs acs";
        String result = removeRepeatingWords(string);
        System.out.println(result); // "abc ab acs"
    }
}
