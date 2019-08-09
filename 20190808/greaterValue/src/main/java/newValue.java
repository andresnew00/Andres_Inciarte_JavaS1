import java.util.Scanner;

public class newValue {

    public static int promptDimension(String msg) {
        Scanner scan = new Scanner(System.in);
        System.out.format("What is the %s of the driveway in feet? %n", msg);
        return Integer.parseInt(scan.nextLine());
    }

    public static void outputDimensions(String name, int value) {
        System.out.format("The %s of the driveway is %d square feet? %n", name, value);
    }

    public static void outputCosts(String name, float value) {
        System.out.format("The cost of the %s is %f . %n", name, value);
    }
1
    public static void main(String[] args) {
        int length = promptDimension("length");
        int width = promptDimension("Width");
        float cementCost = 12.5f;
        float framingCost = 8.25f;
        int area = length * width;
        int perimeter = 2 * length + 2 * width;
        outputDimensions("area", area);
        outputDimensions("perimeter", perimeter);
        outputCosts("Cement", area * cementCost);
        outputCosts("framing/footers", perimeter * framingCost);
    }
}
