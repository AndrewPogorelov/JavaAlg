/*На вход подается число N - количество чисел для случайной генерации.
 Полученный массив чисел необходимо отсортировать в формате Змейки. Пр.
 Исходный массив array = [[1,2,3], [4,5,6], [7,8,9]] snail(array) #=> [1,2,3,6,9,8,7,4,5] array = [[1,2,3], [8,9,4], [7,6,5]] snail(array) #=> [1,2,3,4,5,6,7,8,9]
 */
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SnailSort {
    public static int[] snail(int[][] array) {
        List<Integer> result = new ArrayList<>();
        String direction = "right";
        int top = 0, bottom = array.length - 1, left = 0, right = array[0].length - 1;
        while (top <= bottom && left <= right) {
            if (direction.equals("right")) {
                for (int i = left; i <= right; i++) {
                    result.add(array[top][i]);
                }
                top++;
            } else if (direction.equals("down")) {
                for (int i = top; i <= bottom; i++) {
                    result.add(array[i][right]);
                }
                right--;
            } else if (direction.equals("left")) {
                for (int i = right; i >= left; i--) {
                    result.add(array[bottom][i]);
                }
                bottom--;
            } else if (direction.equals("up")) {
                for (int i = bottom; i >= top; i--) {
                    result.add(array[i][left]);
                }
                left++;
            }
            direction = getNextDirection(direction);
        }
        return result.stream().mapToInt(Integer::intValue).toArray();
    }

    private static String getNextDirection(String direction) {
        String[] directions = {"right", "down", "left", "up"};
        int currentIndex = Arrays.asList(directions).indexOf(direction);
        return directions[(currentIndex + 1) % directions.length];
    }

    public static void main(String[] args) {
        int[][] array = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
        System.out.println("Original array:");
        printArray(array);
        int[] result = snail(array);
        System.out.println("Sorted array in snake format:");
        System.out.println(Arrays.toString(result));

        array = new int[][]{{1, 2, 3}, {8, 9, 4}, {7, 6, 5}};
        System.out.println("Original array:");
        printArray(array);
        result = snail(array);
        System.out.println("Sorted array in snake format:");
        System.out.println(Arrays.toString(result));
    }

    private static void printArray(int[][] array) {
        for (int i = 0; i < array.length; i++) {
            System.out.println(Arrays.toString(array[i]));
        }
    }
}
