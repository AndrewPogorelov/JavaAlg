// Лупа и Пупа пошли заниматься в фитнес зал "Бухгалтерия". Каждый месяц
// фитнес-зал вывешивает список всех посетителей с их весом отсортированный
// по возрастанию. Пупа каждый раз очень расстраивается из-за того что он
// всегда внизу списка с наибольшим весом. У Лупы как всегда все хорошо и
// поскольку он лучший друг Пупы решил, что немного подправит функцию сортировки
// и таблица будет сортироваться не по весу, а по сумме чисел данного веса (189 -> 18).
// Помогите Лупе решить эту задачу. Пример "56 65 74 100 99 68 86 180 90"
// отсортированный спико должен начать выглядеть вот так: "100 180 90 56 65 74 68 86 99"

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class FitnessRoom {

    public static int sumOfDigits(int n) {
        if (n < 10) {
            return n;
        } else {
            return n % 10 + sumOfDigits(n / 10);
        }
    }

    public static List<Integer> sortByDigitSum(List<Integer> weights) {
        Comparator<Integer> comparator = new Comparator<Integer>() {
            @Override
            public int compare(Integer i1, Integer i2) {
                return sumOfDigits(i1) - sumOfDigits(i2);
            }
        };
        Collections.sort(weights, comparator);
        return weights;
    }

    public static void main(String[] args) {
        List<Integer> weights = new ArrayList<Integer>();
        weights.add(56);
        weights.add(65);
        weights.add(74);
        weights.add(100);
        weights.add(99);
        weights.add(68);
        weights.add(86);
        weights.add(180);
        weights.add(90);
        List<Integer> sortedWeights = sortByDigitSum(weights);
        System.out.println(sortedWeights);  // [100, 180, 90, 56, 65, 74, 68, 86, 99]
    }
}