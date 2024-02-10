import java.util.Scanner;

/*
 * Write a method called NestedLoop, which takes one String variable s and an integer variable
upper_limit as its parameters. In the method, construct a nested loop structure, where the outer
loop iterates the leJers of the given String s. The inner loop iterates from 0 un0l the upper limit
(including the upper limit)
 */
public class NestedLoops {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the word: ");
        String word = scanner.nextLine();
        System.out.print("Enter the number: ");
        int num = scanner.nextInt();
        scanner.close();
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
