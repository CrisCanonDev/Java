import java.util.Scanner;

/*
 * Write a Java program, that asks the user to enter a series of natural numbers (posi0ve integers),
calculate their sum, and print the sum out for the user. When the user enters a nega0ve integer
number or zero, the program stops and prints the sum.
 */

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
