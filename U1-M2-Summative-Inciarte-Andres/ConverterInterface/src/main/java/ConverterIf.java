public class ConverterIf implements ConverterInterface {

    public String convertMonth(int monthNumber) {
//        * This method converts the given number into its corresponding month.
//     * @param dayNumber the number you wish to convert to a month
//     * @return the name of the corresponding month if the parameter value is between 1 and 12;
//     error message otherwise
//                */
        if (monthNumber == 1) {
            return "January";
        } else if (monthNumber == 2) {
            return "February";
        } else if (monthNumber == 3) {
            return "March";
        } else if (monthNumber == 4) {
            return "April";
        } else if (monthNumber == 5) {
            return "May";
        } else if (monthNumber == 6) {
            return "June";
        } else if (monthNumber == 7) {
            return "July";
        } else if (monthNumber == 8) {
            return "August";
        } else if (monthNumber == 9) {
            return "September";
        } else if (monthNumber == 10) {
            return "October";
        } else if (monthNumber == 11) {
            return "November";
        } else if (monthNumber == 12) {
            return "December";
        } else {
            return "Please enter a valid number";
        }
    }


    public String convertDay(int dayNumber) {
        /**
         * This method converts the given number into its corresponding day of the week.
         * @param dayNumber number you wish to convert to a day of the week
         * @return the name of the corresponding day if the parameter value is between 1 and 7, error message otherwise
         * The first day of the week is Sunday
         */
        if (dayNumber == 1) {
            return "Monday";
        } else if (dayNumber == 2) {
            return "Tuesday";
        } else if (dayNumber == 3) {
            return "Wednesday";
        } else if (dayNumber == 4) {
            return "Thursday";
        } else if (dayNumber == 5) {
            return "Friday";
        } else if (dayNumber == 6) {
            return "Saturday";
        } else if (dayNumber == 7) {
            return "Sunday";
        } else {
            return "Please enter a valid number";
        }
    }
}
