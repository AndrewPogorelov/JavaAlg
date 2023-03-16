import java.util.Random;
import java.util.Scanner;

// На ввод поступает матрица любой размерности.
// Выполните транспонирование матрицы → строки
// становятся столбцами и выведите ее на экран.
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the number of rows: ");
        int numRows = scanner.nextInt();
        System.out.print("Enter the number of columns: ");
        int numCols = scanner.nextInt();

        int[][] matrix = new int[numRows][numCols];
        Random random = new Random();
        for (int i = 0; i < numRows; i++) {
            for (int j = 0; j < numCols; j++) {
                matrix[i][j] = random.nextInt(99) + 1;
            }
        }

        System.out.println("Original matrix:");
        displayMatrix(matrix);


        int[][] transposedMatrix = new int[numCols][numRows];
        for (int i = 0; i < numCols; i++) {
            for (int j = 0; j < numRows; j++) {
                transposedMatrix[i][j] = matrix[j][i];
            }
        }

        System.out.println("Transposed matrix:");
        displayMatrix(transposedMatrix);
    }
    private static void displayMatrix(int[][] matrix) {
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
    }
}