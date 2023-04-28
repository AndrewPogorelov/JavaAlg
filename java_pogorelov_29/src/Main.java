// На вход поступает положительное число и число для начала ряда.
// Вычислить возможна ли такая ситуация - сумма последовательных
// степеней ряда (n=1,2,3...) каждой из цифр - является произведением
// этого числа на любой из множителей 2^6 -> (q^w + e^(w+1) + r^(w+1) +...= sum = a * s).
// Пр. sC(89, 1) => 8^1+9^2=89*1,sC(695, 2) => 6^2+9^3+5^4=1390=695*2.

import java.util.Scanner;


public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n;
        do {
            System.out.print("Enter a positive integer for n: ");
            n = scanner.nextInt();
            if (n <= 0) {
                System.out.println("The number n must be positive! Enter again.");
            }
        } while (n <= 0);

        System.out.print("Enter p: ");
        int p = scanner.nextInt();

        double result = digPow(n, p);

    }

    public static int digPow(int n, int p) {

        if (n < 10) {
            return -1;
        }

        int sum = 0;
        int[] myArray = new int[String.valueOf(n).length()];
        int holder = n;

        for (int i = String.valueOf(n).length() - 1; i >= 0; i--) {
            myArray[i] = holder % 10;
            holder = holder / 10;
            myArray[i] = (int) Math.pow(myArray[i], p + i);
            sum += myArray[i];
        }

        if (sum % n == 0) {
            int result = sum / n;
            StringBuilder sb = new StringBuilder();
            sb.append("(").append(n).append(", ").append(p).append(") => ");
            for (char c : String.valueOf(n).toCharArray()) {
                sb.append(c).append("^").append(p).append("+");
                p++;
            }
            sb.deleteCharAt(sb.length() - 1);
            sb.append("=").append(sum).append("=").append(n).append("*").append(result);
            System.out.println(sb.toString());
            return result;
        } else {
            System.out.println("Сумма последовательных степеней ряда каждой из цифр - не является произведением этого числа на любой из множителей");

        }
        return -1;
    }
}
