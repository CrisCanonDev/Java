import java.util.Scanner;
/*
 * Write a Java method that calculates how many years, weeks and days can be formed from a given
integer variable days. The method should take one integer variable as its parameter, and it should
return a String variable
 */

public class YearsMonthsDays {
    public static void main(String[] args) {   
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter number of days -> ");
        int days = scanner.nextInt();
        String result = howManyYWD(days);
        System.out.println(result);
        scanner.close();
    }
    
    public static String howManyYWD(int days){
        int years = (days/365);
        int weeks = (days - (years *365)) / 7;
        int remainingDays = days - ((years*365) + (weeks*7));    
        String text = (days +" days equals " + years + " years, " + weeks + " weeks and " + remainingDays + " days.");
        return text;
    }
}
