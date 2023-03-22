// Дана строка символов. Определите длинейший палиндром в строке.
// Пр. aa - 2, aabbac - 2, aabosobca - 5.
import java.util.Scanner;

public class LongestPalindrome {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter a string: ");
        String str = scanner.nextLine();
        String longestPalindrome = findLongestPalindrome(str);
        System.out.println("Longest palindrome in the string is: " + longestPalindrome);
    }

    public static String findLongestPalindrome(String str) {
        if (str == null || str.length() == 0) {
            return "";
        }
        int len = str.length();
        boolean[][] dp = new boolean[len][len];
        int maxLen = 0;
        int startIndex = 0;

        // All substrings of length 1 are palindromes
        for (int i = 0; i < len; i++) {
            dp[i][i] = true;
            maxLen = 1;
        }

        // Check for substrings of length 2
        for (int i = 0; i < len - 1; i++) {
            if (str.charAt(i) == str.charAt(i+1)) {
                dp[i][i+1] = true;
                maxLen = 2;
                startIndex = i;
            }
        }

        // Check for substrings of length > 2
        for (int k = 3; k <= len; k++) {
            for (int i = 0; i < len - k + 1; i++) {
                int j = i + k - 1;
                if (str.charAt(i) == str.charAt(j) && dp[i+1][j-1]) {
                    dp[i][j] = true;
                    if (k > maxLen) {
                        maxLen = k;
                        startIndex = i;
                    }
                }
            }
        }

        return str.substring(startIndex, startIndex + maxLen) + " (" + maxLen + ")";
    }
}






