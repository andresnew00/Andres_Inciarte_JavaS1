public class GettingDigits {
    public static void main(String[] args) {
        for (int i = 1; i <= 9; i++){
            for (int j = 0; j <= 9 ;j++) {
                System.out.print(i);
                System.out.print(j + ",");
                System.out.println( " " + i + " + " + j + " = " + (i + j));
            }
        }
    }
}
