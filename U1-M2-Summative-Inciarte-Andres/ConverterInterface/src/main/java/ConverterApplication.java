public class ConverterApplication {

    public static void main(String[] args) {

        //ConverterIf Instantiation
        ConverterIf convertIf = new ConverterIf();
        convertIf.convertDay(4);
        convertIf.convertMonth(5);

        //ConverterSwitch Instantiation
        ConverterSwitch convertSwitch = new ConverterSwitch();
        convertSwitch.convertDay(2);
        convertSwitch.convertMonth(1);
    }

}
