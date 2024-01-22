import java.util.Scanner;

public class Task6 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the word: ");
        String word = sc.nextLine();
        System.out.print("Enter the number: ");
        int num = sc.nextInt();
        NestedLoop(word, num);
    }

    public static void NestedLoop(String s, int upper_limit) {
        for (int x = 0; x < s.length(); x++) {
            for (int y = 0; y <= upper_limit; y++) {
                char letter = s.charAt(x);
                System.out.println(letter + " - " + y);
            }
        }
    }
}
