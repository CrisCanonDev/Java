import java.util.Scanner;

public class howManyYWD {
    public static void main(String[] args) {   
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter number of days -> ");
        int days = sc.nextInt();
        String result = howManyYWD(days);
        System.out.println(result);
    }
    
    public static String howManyYWD(int days){
        int years = (days/365);
        int weeks = (days - (years *365)) / 7;
        int remainingDays = days - ((years*365) + (weeks*7));    
        String text = (days +" days equals " + years + " years, " + weeks + " weeks and " + remainingDays + " days.");
        return text;
    }
}
