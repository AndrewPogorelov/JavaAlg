import java.util.Scanner;

public class AccountingOfEmployees  {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter values in the format '1,0,1,1,1': ");
        String inputStr = scanner.nextLine();
        String[] inputArr = inputStr.split(",");
        boolean[] values = new boolean[inputArr.length];
        for (int i = 0; i < inputArr.length; i++) {
            values[i] = inputArr[i].equals("1");
        }
        int employeeCount = 0;
        for (boolean value : values) {
            if (value) {
                employeeCount++;
            }
        }
        System.out.println("Number of employees: " + employeeCount);
    }
}