import java.util.Scanner;
import java.io.File;
import java.io.FileWriter;
import java.util.Stack;

public class Calculator {

        private static final String HISTORY_FILE = "history.txt";

        public static void main(String[] args) {
            Scanner input = new Scanner(System.in);
            String equation;
            double result;
            File file = new File(HISTORY_FILE);
            try {
                if (!file.exists()) {
                    file.createNewFile();
                }
                FileWriter writer = new FileWriter(file, true);
                while (true) {
                    System.out.print("Enter an equation (q to quit): ");
                    equation = input.nextLine();
                    if (equation.equals("q")) {
                        break;
                    }
                    writer.write(equation + "\n");
                    writer.flush();
                    result = calculate(equation);
                    System.out.println("Result: " + result + "\n");
                }
                writer.close(); 
            } catch (Exception e) {
                System.out.println("An error occurred while writing to the file: " + e.getMessage());
            }
            input.close();
            displayHistory();
        }

        private static void displayHistory() {
            File file = new File(HISTORY_FILE);
            try {
                Scanner scanner = new Scanner(file);
                System.out.println("History of Equations:");
                while (scanner.hasNextLine()) {
                    String equation = scanner.nextLine();
                    System.out.println(equation);
                }
                scanner.close();
            } catch (Exception e) {
                System.out.println("An error occurred while reading the file: " + e.getMessage());
            }
        }


        public static double calculate(String equation) {
            Stack<Double> operands = new Stack<>();
            Stack<Character> operators = new Stack<>();
            for (int i = 0; i < equation.length(); i++) {
                char c = equation.charAt(i);
                if (Character.isDigit(c)) {
                    String numStr = Character.toString(c);
                    while (i+1 < equation.length() && (Character.isDigit(equation.charAt(i+1)) || equation.charAt(i+1) == '.')) {
                        numStr += equation.charAt(i+1);
                        i++;
                    }
                    double num = Double.parseDouble(numStr);
                    operands.push(num);
                } else if (c == '(') {
                    int openCount = 1;
                    int j = i + 1;
                    while (openCount > 0 && j < equation.length()) {
                        char nestedChar = equation.charAt(j);
                        if (nestedChar == '(') {
                            openCount++;
                        } else if (nestedChar == ')') {
                            openCount--;
                        }
                        j++;
                    }
                    double nestedResult = calculate(equation.substring(i+1, j-1));
                    operands.push(nestedResult);
                    i = j-1;
                } else if (c == '+' || c == '-' || c == '*' || c == '/' || c == '^' || c == '%' || c == '|') {
                    operators.push(c);
                } else if (c == ')') {
                    evaluate(operands, operators);
                }
            }
            while (!operators.empty()) {
                evaluate(operands, operators);
            }
            return operands.pop();
    }

        private static void evaluate(Stack<Double> operands, Stack<Character> operators) {
            double operand2 = operands.pop();
            double operand1 = operands.pop();
            char operator = operators.pop();
            double result = 0;
            switch (operator) {
                case '+':
                    result = operand1 + operand2;
                    break;
                case '-':
                    result = operand1 - operand2;
                    break;
                case '*':
                    result = operand1 * operand2;
                    break;
                case '/':
                    result = operand1 / operand2;
                    break;
                case '^':
                    result = Math.pow(operand1, operand2);
                    break;
                case '%':
                    result = operand1 % operand2;
                    break;
                case '|':
                    result = Math.abs(operand2);
                    break;
            }
            operands.push(result);
        }
}
