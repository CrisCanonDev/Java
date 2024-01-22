import java.util.Scanner;

public class Task4 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter value for X coordenate: ");
        int xVal = sc.nextInt();
        System.out.print("Enter value for Y coordenate: ");
        int yVal = sc.nextInt();

        int quadrant = vwar(xVal, yVal);
        System.out.println("The coordenates (" + xVal + "," + yVal + ") represents quandrant: " + quadrant);
    }

    public static Integer vwar(int x, int y) {

        if (x > 0) {
            if (y > 0) {
                return 1;
            } else if (y < 0) {
                return 4;
            } else {
                return 0;
            }
        } else if (x < 0) {
            if (y > 0) {
                return 2;
            } else if (y < 0) {
                return 3;
            } else {
                return 0;
            }
        } else {
            return 0;
        }
    }

}