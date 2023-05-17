//Саша и Таня хотят поехать в несколько городов. У Тани случайно обнаружился
// список этих городов и расстояний между ними. l= [50, 55, 57, 58, 60].
// Саша тонко намекает Тане, что бензина на их поездку можно потратить ровно
// на 175 километров и он хочет посетить только 3 города. Нужно найти какие
// города могут посетить Саша и Таня, потратив максимально много бензина.
// Пр. l=[50,55,57],[50,55,58],[50,55,60],[50,57,58],[50,57,60],[50,58,60],[55,57,58],[55,57,60],[55,58,60],[57,58,60].
// Работа программы ts = [50, 55, 56, 57, 58], choose_best_sum(163, 3, ts) -> 163.

import java.util.ArrayList;
import java.util.Arrays;

public class CityTrip {
    public static ArrayList<Integer> chooseBestSum(int maxDistance, int citiesToVisit, int[] cityDistances) {
        ArrayList<Integer> bestCombination = null;
        int bestDistance = 0;

        int[] indices = new int[citiesToVisit];
        for (int i = 0; i < citiesToVisit; i++) {
            indices[i] = i;
        }
        while (indices[0] <= cityDistances.length - citiesToVisit) {
            ArrayList<Integer> combination = new ArrayList<>();
            for (int index : indices) {
                combination.add(cityDistances[index]);
            }

            int combinationDistance = combination.stream().mapToInt(Integer::intValue).sum();
            if (combinationDistance <= maxDistance) {
                if (combinationDistance > bestDistance) {
                    bestDistance = combinationDistance;
                    bestCombination = combination;
                }
            }

            int i = citiesToVisit - 1;
            while (i >= 0 && indices[i] == cityDistances.length - citiesToVisit + i) {
                i--;
            }
            if (i < 0) {
                break;
            }
            indices[i]++;
            for (int j = i + 1; j < citiesToVisit; j++) {
                indices[j] = indices[j - 1] + 1;
            }
        }

        return bestCombination;
    }

    public static void main(String args[]) {
        int[] cityDistances = {50, 55, 57, 58, 60};
        int maxDistance = 163;
        int citiesToVisit = 3;
        ArrayList<Integer> bestCombination = chooseBestSum(maxDistance, citiesToVisit, cityDistances);
        if (bestCombination != null) {
            System.out.println("maxDistance: " + maxDistance);
            System.out.println("Best combination: " + Arrays.toString(bestCombination.toArray()));
        } else {
            System.out.println("No valid combinations found.");
        }
    }
}