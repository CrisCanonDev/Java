import java.util.Scanner;

public class Task5 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the length of the fibbonaci sequence: ");
        int length = sc.nextInt();
        String fiboSeq = Fibonnaci(length);
        System.out.println(fiboSeq);    
    }

    public static String Fibonnaci(int lengthFibo) {
        int firstVal = 0;
        int secondVal = 1;
        String fiboSequence = "";
        if (lengthFibo == 1) {
            return "0";
        } else if (lengthFibo == 2) {
            return "0, 1";
        } else {
            fiboSequence += firstVal + ", " + secondVal;
            for (int x = 0; x < lengthFibo - 2; x++) {
                int newVal = firstVal + secondVal;
                fiboSequence += ", " + newVal;
                firstVal = secondVal;
                secondVal = newVal;
            }
            return fiboSequence;
        }
    }
}
