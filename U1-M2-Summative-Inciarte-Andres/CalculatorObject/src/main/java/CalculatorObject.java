public class CalculatorObject {

    //add
    public static int add(int a, int b) {
        return a + b;
    }

    public static double add(double a, double b) {
        return a + b;
    }

    //subtraction
    public static int subs(int a, int b) {
        return a - b;
    }

    public static double subs(double a, double b) {
        return a - b;
    }

    //multiplication
    public static int multiplication(int a, int b) {
        return a * b;
    }

    public static double multiplication(double a, double b) {
        return a * b;
    }

    //division
    public static int division(int a, int b) {
        return a / b;
    }

    public static double division(double a, double b) {
        return a / b;
    }

    public static void main(String[] args) {

        System.out.print("1 + 1 = ");
        System.out.println(CalculatorObject.add(1, 1));

        System.out.print("23 - 52 = ");
        System.out.println(CalculatorObject.subs(23, 52));

        System.out.print("34 + 2 = ");
        System.out.println(CalculatorObject.multiplication(34, 2));

        System.out.print("12 + 3 = ");
        System.out.println(CalculatorObject.division(12, 3));

        System.out.print("12 + 7 = ");
        System.out.println(CalculatorObject.division(12, 7));

        System.out.print("12 + 3 = ");
        System.out.println(CalculatorObject.add(3.4, 2.3));

        System.out.print("6.7 + 4.4 = ");
        System.out.println(CalculatorObject.multiplication(6.7, 4.4));

        System.out.print("5.5 + 0.5 = ");
        System.out.println(CalculatorObject.subs(5.5, 0.5));

        System.out.print("10.8 + 2.2 = ");
        System.out.println(CalculatorObject.division(10.8, 2.2));
    }

}
