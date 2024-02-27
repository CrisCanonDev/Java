import java.util.Scanner;

public class FibonacciSerie {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the length of the fibbonaci sequence: ");
        int lengthofFibonacciSerie = scanner.nextInt();
        scanner.close();
        String fibonacciSequence = Fibonnaci(lengthofFibonacciSerie);
        System.out.println(fibonacciSequence);    
    }

    public static String Fibonnaci(int lengthFibo) {
        int firstValue = 0;
        int secondValue = 1;
        if (lengthFibo == 1) {
            return "0";
        } else if (lengthFibo == 2) {
            return "0, 1";
        } else {
            
            String fibonacciSequence = "";
            fibonacciSequence += firstValue + ", " + secondValue;
            for (int x = 0; x < lengthFibo - 2; x++) {
                int newVal = firstValue + secondValue;
                fibonacciSequence += ", " + newVal;
                firstValue = secondValue;
                secondValue = newVal;
            }
            return fibonacciSequence;
        }
    }
}
