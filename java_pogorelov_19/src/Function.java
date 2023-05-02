// Задана система уравнений:
//        func(0) = 0
//        func(1) = 1
//        func(2*n) = func(n)
//        func (2*n+1) = func (n) + func(n+1)
//        Расчитать систему уравнений. Пр. func(10) -> func(10) = func(5) [правило 3] ->
//        func(5) = func(2) + func(3) [правило 4] -> func(2) = func(1) [правило 3] ->
//        func(1) = 1 [правило 2] -> funtc(3) = func(1) + func(2) [правило 4] ->
//        func(1) и func (2) посчитаны и равны 1. Результат func(10) = func(5) = func(2) + func(3) = 1+2 = 3.
public class Function {

    static int calculateFunction(int n) {
        if (n == 0) {
            return 0;
        } else if (n == 1) {
            return 1;
        } else if (n % 2 == 0) {
            return calculateFunction(n / 2);
        } else {
            return calculateFunction(n / 2) + calculateFunction(n / 2 + 1);
        }
    }

    public static void main(String[] args) {
        int n = 10;
        int result = calculateFunction(n);
        System.out.println("Function(" + n + ") = " + result);
    }
}