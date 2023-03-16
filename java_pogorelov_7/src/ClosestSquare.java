import java.util.Scanner;
//Вводится число (пр. 123). Найти число квадрат которого будет ближе всего
//расположен к введенному числу (пр. 123 → 121 → 11).
public class ClosestSquare {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter a number: ");
        int number = scanner.nextInt();

        int closest = 0;
        int diff = Integer.MAX_VALUE;

        for (int i = 0; i <= number; i++) {
            int square = i * i;
            int d = Math.abs(number - square);
            if (d < diff) {
                closest = i;
                diff = d;
            }
        }

        System.out.println("The number whose square is closest to " + number + " is " + closest);
    }
}