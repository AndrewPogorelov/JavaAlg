// Сыграем в игру каждый третий. На вход программе поступает количество игроков и номер игрока
// с которого начинается игра. Каждый третий выбывает и так по кругу пока не останется только 1.
// Выведите весь список выбывших игроков в том числе и победителя. Пример:
//        [1,2,4,5,6,7] => 3 is counted out and goes into the result [3]
//        [1,2,4,5,7] => 6 is counted out and goes into the result [3,6]
//        [1,4,5,7] => 2 is counted out and goes into the result [3,6,2]
//        [1,4,5] => 7 is counted out and goes into the result [3,6,2,7]
//        [1,4] => 5 is counted out and goes into the result [3,6,2,7,5]
//        [4] => 1 is counted out and goes into the result [3,6,2,7,5,1]
//        [] => 4 is counted out and goes into the result [3,6,2,7,5,1,4]
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class EliminationGame {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter number of players: ");
        int numPlayers = Integer.parseInt(scanner.nextLine());
        System.out.print("Enter starting player number: ");
        int startPlayer = Integer.parseInt(scanner.nextLine());

        List<Integer> players = new ArrayList<>();
        for (int i = 1; i <= numPlayers; i++) {
            players.add(i);
        }

        List<Integer> eliminated = new ArrayList<>();
        int current = startPlayer - 1, count = 1;
        while (players.size() > 1) {
            if (count % 3 == 0) {
                eliminated.add(players.remove(current));
                System.out.printf("%s %d is counted out and result %s\n",
                        players.toString(), eliminated.get(eliminated.size() - 1), eliminated.toString());
                current--;
            }
            count++;
            current = (current + 1) % players.size();
        }

        System.out.printf("Eliminated players: %s\n", eliminated.toString());
        System.out.printf("Winner: %d\n", players.get(0));
    }
}