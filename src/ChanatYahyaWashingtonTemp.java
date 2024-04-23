/***********************************************************************
 @Title:	ChanatYahyaWashingtonTemp.java
 @Purpose:	To get familiar with arrays and their usage
 @Author:    (Chanat Yahya)
 @Date:   	(08/01/2024)
 @Version:	1.0
 ************************************************************************/

import java.util.Arrays;

public class ChanatYahyaWashingtonTemp {
    public static void main(String[] args) {

        //My Arrays
        int[] days = new int[366];

        int [][] months = {
                {31,25,38},
                {29,26,40},
                {31,34,48},
                {30,43,58},
                {31,52,68},
                {30,62,77},
                {31,68,83},
                {31,60,75},
                {30,49,65},
                {31,41,54},
                {30,31,43},
                {31,47,61}
        };

        //My Variables
        int counter = 0;
        int average = 0;
        int hottest = 0;
        int hottestMonth = 0;
        int hottestDay = 0;
        int day = 0;
        int hotDayInMonth = 0;
        int coldest = 83;
        int coldestMonth = 0;
        int coldestDay = 0;
        int colDayInMonth = 0;
        int below = 0;
        int more = 0;

        //Main For loop
        for(int row = 0; row < 12; row++){

            for(int i = counter; i < (months[row][0] + (counter) ); i++){
                day++;
                days[i] = (int)Math.floor(months[row][1] + Math.random() * (months[row][2]-months[row][1]+1));
                below = days[i] < 33 ? below + 1 : below;
                more = days[i] > 75 ? more + 1 : more;

                if(hottest < days[i]){
                    hottest = days[i];
                    hottestMonth = row + 1;
                    hottestDay = i + 1;
                    hotDayInMonth = day;
                }
                if(coldest > days[i]){
                    coldest = days[i];
                    coldestMonth = row + 1;
                    coldestDay = i + 1;
                    colDayInMonth = day;
                }
                average += days[i];

            }
            day = 0;
            System.out.println("The average in " + (row + 1) + " month is: " + (average / months[row][0]));
            average = 0;
            counter += months[row][0];
        }

        System.out.println(Arrays.toString(days));

        //Using my methods
        String hottestMonthWord = convertToMonthName(hottestMonth);
        String coldestMonthWord = convertToMonthName(coldestMonth);
        String hottestDayName = convertToDayName(hottestDay);
        String coldestDayName = convertToDayName(coldestDay);

        //Print answers
        System.out.println("The hottest day in the entire year was on " + hottestDayName + ", " + hottestMonthWord + " " + hotDayInMonth + " \n" +
                "It was " + hottest + " degree F on this day.");

        System.out.println("The coldest day in the entire year was on " + coldestDayName + ", " + coldestMonthWord + " " + colDayInMonth + " \n" +
                "It was " + coldest + " degree F on this day.");
        System.out.println("There were " + more + " days where the temperature was above 75 degrees");
        System.out.println("There were " + below + " days where the temperature was below 33 degrees");

    }
    //My Methods
    public static String convertToMonthName(int month) {
        switch (month) {
            case 1: return "January";
            case 2: return "February";
            case 3: return "March";
            case 4: return "April";
            case 5: return "May";
            case 6: return "June";
            case 7: return "July";
            case 8: return "August";
            case 9: return "September";
            case 10: return "October";
            case 11: return "November";
            case 12: return "December";
            default: return "Invalid month";
        }
    }
    public static String convertToDayName(int day) {
        switch ((day % 7 + 1)) {
            case 1: return "Sunday";
            case 2: return "Monday";
            case 3: return "Tuesday";
            case 4: return "Wednesday";
            case 5: return "Thursday";
            case 6: return "Friday";
            case 7: return "Saturday";
            default: return "Invalid day";
        }
    }
}