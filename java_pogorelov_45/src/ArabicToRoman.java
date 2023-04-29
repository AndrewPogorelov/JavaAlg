// Напишите программу конвертации количества лет из Арабских чисел в Римские.
// Количество лет в диапазоне 1 < n < 10000.
import java.util.Scanner;

public class ArabicToRoman {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter a number of years between 1 and 9999: ");
        int num = scanner.nextInt();
        String romanYear = arabicToRoman(num);
        System.out.println("The Roman numeral equivalent of " + num + " is " + romanYear);
    }

    private static String arabicToRoman(int num) throws IllegalArgumentException {
        if (num <= 0 || num >= 10000) {
            throw new IllegalArgumentException("Number of years must be between 1 and 9999");
        }
        String[] thousands = {"", "M", "MM", "MMM"};
        String[] hundreds = {"", "C", "CC", "CCC", "CD", "D", "DC", "DCC", "DCCC", "CM"};
        String[] tens = {"", "X", "XX", "XXX", "XL", "L", "LX", "LXX", "LXXX", "XC"};
        String[] ones = {"", "I", "II", "III", "IV", "V", "VI", "VII", "VIII", "IX"};

        StringBuilder sb = new StringBuilder();
        sb.append(thousands[num / 1000]);
        sb.append(hundreds[(num % 1000) / 100]);
        sb.append(tens[(num % 100) / 10]);
        sb.append(ones[num % 10]);

        return sb.toString();
    }
}