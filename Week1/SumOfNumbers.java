import java.util.Scanner;



public class SumOfNumbers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int num;
        int totalSum = 0;
        do { 
            System.out.print("Enter a number -> ");
            num = scanner.nextInt();
            totalSum += num;
        } while (num == 0);
        System.out.println("Sum is: " + totalSum);
        scanner.close();
    }
}
