// Саша и Таня играют в игру: на столе лежит куча деревянных палочек в количестве: 1 <= n <= 10^18.
// Если количество палочек четное то игрок может взять либо одну палочку либо половину от всех палочек.
// Если количество палочек нечетное - то игрок может взять только 1 палочку.

import java.util.Scanner;

public class StickGame {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the number of sticks: ");
        long n = scanner.nextLong();
        String winner = findWinner(n, "Sasha");
        System.out.println("The winner is " + winner + ".");
    }

    public static String findWinner(long n, String player) {
        if (n == 1) {
            return player;
        } else if (n % 2 == 0) {
            return findWinner(n / 2, player.equals("Sasha") ? "Tanya" : "Sasha");
        } else {
            return player;
        }
    }
}