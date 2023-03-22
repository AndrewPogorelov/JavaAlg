// На вход подается число (0 < n > 100000). Число n является разницей
// между двумя последовательными квадратами числа. Пр. 9 = 25-16, 5 = 9-4, 7 = 16-9.
import java.util.Scanner;

public class SquareDifference {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter number: ");
        int N = sc.nextInt();

        for (int i = 1; i <= Math.sqrt(N); i++) {
            if (N % i == 0) {
                int j = N / i;

                if ((i + j) % 2 == 0 && (j - i) % 2 == 0) {
                    int x = (i + j) / 2;
                    int y = (j - i) / 2;

                    if ((x >= 1) && (x < 100000) && (y >= 1) && (y < 100000)) {
                        System.out.println("Square difference: " + x*x + "-" + y*y);
                        System.out.println("The necessary numbers: " + x + " " + y);
                    }
                }
            }
        }
    }
}
