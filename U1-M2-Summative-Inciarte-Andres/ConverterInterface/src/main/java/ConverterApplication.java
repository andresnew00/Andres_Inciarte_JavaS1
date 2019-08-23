public class ConverterApplication {

    public static void main(String[] args) {

        //ConverterIf Instantiation
        ConverterIf convertIf = new ConverterIf();
        System.out.println(convertIf.convertDay(4));
        System.out.println(convertIf.convertMonth(5));

        //ConverterSwitch Instantiation
        ConverterSwitch convertSwitch = new ConverterSwitch();
        System.out.println(convertSwitch.convertDay(2));
        System.out.println(convertSwitch.convertMonth(1));
    }

}
