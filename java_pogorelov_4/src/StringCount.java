public class StringCount {
    public static int strCount(String string, char ch) {
        int count = 0;
        for (char c : string.toCharArray()) {
            if (c == ch) {
                count++;
            }
        }
        return count;
    }

    public static void main(String[] args) {
        System.out.println(strCount("Hello", 'o')); // output: 1
        System.out.println(strCount("Hello", 'l')); // output: 2
        System.out.println(strCount("", 'z')); // output: 0
        System.out.println(strCount("Hello! Hello!", 'e'));
    }
}