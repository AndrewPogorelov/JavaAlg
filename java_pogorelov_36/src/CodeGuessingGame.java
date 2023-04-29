// Программой загадан код из четырех символов. Требуется сыграть
// в игру и разгадать код быстрее чем за 20 попыток. Каждый раз
// вводить требуется 4 числа. Количество изменений за раз - любое.
// Если программа обнаруживает совпадения нескольких чисел - она
// выводит количество совпадений, но не указывает какие конкретно числа совпали.
import java.util.HashSet;
import java.util.Random;
import java.util.Scanner;
import java.util.Set;

public class CodeGuessingGame {
    public static void main(String[] args) {

        Random rand = new Random();
        int[] code = new int[4];
        Set<Integer> used = new HashSet<>();
        for (int i = 0; i < 4; i++) {
            int x;
            do {
                x = rand.nextInt(10);
            } while (used.contains(x));
            code[i] = x;
            used.add(x);
        }


        Scanner scanner = new Scanner(System.in);
        for (int attempt = 1; attempt <= 20; attempt++) {
            System.out.printf("Attempt #%d: Enter a 4-number code: ", attempt);
            int[] guess = new int[4];
            String input = scanner.nextLine();
            boolean valid = true;
            if (input.length() != 4) {
                valid = false;
            } else {
                for (int i = 0; i < 4; i++) {
                    try {
                        guess[i] = Integer.parseInt(input.substring(i, i + 1));
                    } catch (NumberFormatException e) {
                        valid = false;
                        break;
                    }
                }
            }
            if (!valid) {
                System.out.println("Invalid input. Please enter 4 digits.");
                continue;
            }
            int matchCount = 0;
            for (int i = 0; i < 4; i++) {
                if (guess[i] == code[i]) {
                    matchCount++;
                }
            }
            if (matchCount == 4) {
                System.out.println("Congratulations! You guessed the code.");
                break;
            } else if (attempt == 20) {
                System.out.println("Sorry, you ran out of attempts.");
                System.out.printf("The code was: %d%d%d%d\n", code[0], code[1], code[2], code[3]);
                break;
            } else {
                int partialMatchCount = 0;
                for (int i = 0; i < 4; i++) {
                    for (int j = 0; j < 4; j++) {
                        if (i != j && guess[i] == code[j]) {
                            partialMatchCount++;
                            break;
                        }
                    }
                }
                System.out.printf("Match: %d. Partial match: %d.\n", matchCount, partialMatchCount);
            }
        }
    }
}