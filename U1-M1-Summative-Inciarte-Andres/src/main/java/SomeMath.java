public class SomeMath {
    public static void main(String[] args) {
        total5(1, 2, 3, 4, 5);
        average5(1, 3, 5, 7, 9);
        largest5(42.0, 35.1, 2.3, 40.2, 15.6);
    }

    public static int total5(int num1,int num2,int num3,int num4,int num5) {
        int sum = num1 + num2 + num3 + num4 + num5;

        System.out.println(sum);
        return sum;
    }
    public static double average5(int num1,int num2,int num3,int num4,int num5) {
        double average = (num1 + num2 + num3 + num4 + num5) / 5;

        System.out.println(average);
        return average;
    }
    public static double largest5(double num1,double num2,double num3,double num4,double num5) {
        double largest = 0;

        if (num1 > num2) {
            largest = num1;
        }
        if(num3 > largest) {
            largest = num3;
        }
        if (num4 > largest) {
            largest = num4;
        }
        if (num5 > largest) {
            largest = num5;
        }

        System.out.println(largest);
        return largest;
    }
}
