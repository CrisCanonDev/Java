import java.util.Scanner;

public class Task2 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int num = 1;
        int totalSum = 0;
        while (num != 0) {
            System.out.print("Enter a number -> ");
            num = sc.nextInt();
            totalSum += num;
        }
        System.out.println("Sum is: " + totalSum);
    }
}
