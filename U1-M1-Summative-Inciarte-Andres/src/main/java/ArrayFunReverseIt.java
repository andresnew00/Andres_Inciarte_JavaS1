public class ArrayFunReverseIt {
    public static void main(String[] args) {

        int[] array = new int[]{1, 2, 3, 4, 5};

        int[] ReverseArray = new int[array.length];
        // variable that is going to contain the current position
        int reverseValue = 0;

        // loop backwards
        for (int i = array.length - 1; i >= 0; i--) {
            ReverseArray[reverseValue++] = array[i];
        }

        //display both arrays
        System.out.println("original array: ");
        for (int i = 0; i < array.length; i++) {
            System.out.println(array[i]);
        }
        System.out.println("reversed array: ");
        for (int i = 0; i < array.length; i++) {
            System.out.println(ReverseArray[i]);
        }
    }

}
