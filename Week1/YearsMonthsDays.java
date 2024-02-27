import java.util.Scanner;

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
        return (days +" days equals " + years + " years, " + weeks + " weeks and " + remainingDays + " days.");
    }
}
