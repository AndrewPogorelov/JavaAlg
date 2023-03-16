//Пользователь с клавиатуры вводит три отрезка определенной длины (6, 12, 7).
// Требуется понять возможно ли из них составить треугольник и рассчитать
// наибольший внешний угол полученного треугольника.
import java.util.Scanner;

public class TriangleAngle {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the length of the first segment: ");
        int a = scanner.nextInt();

        System.out.print("Enter the length of the second segment: ");
        int b = scanner.nextInt();

        System.out.print("Enter the length of the third segment: ");
        int c = scanner.nextInt();

        boolean isTriangle = false;
        int maxAngle = 0;

        if (a + b > c && b + c > a && c + a > b) {
            isTriangle = true;
            int cosA = (b * b + c * c - a * a) / (2 * b * c);
            int cosB = (c * c + a * a - b * b) / (2 * c * a);
            int cosC = (a * a + b * b - c * c) / (2 * a * b);
            maxAngle = (int) Math.toDegrees(Math.acos(Math.max(Math.max(cosA, cosB), cosC)));
        }

        if (isTriangle) {
            System.out.println("It is possible to make a triangle from the given segments.");
            System.out.println("The largest outer angle of the resulting triangle is " + maxAngle + " degrees.");
        } else {
            System.out.println("It is not possible to make a triangle from the given segments.");
        }
    }
}
