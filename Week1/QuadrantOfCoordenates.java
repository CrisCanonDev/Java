import java.util.Scanner;
/*
 * Implement a method to determine the quadrant of a point (x,y) in a coordinate plane. The rules for
figuring out the quadrant are as follows:
    • If both x and y are positive, the point belongs to quadrant 1.
    • If y is positive and x is negative, the point belongs to quadrant 2.
    • If both x and y are negative, the point belongs to quadrant 3.
    • If x is positive and y is negative, the point belongs to quadrant 4.
    • The origin (0,0) does not belong to any quadrant (quadrant 0).
•    If either x is 0 or y is 0, it means that the point is in between of quadrants (quadrant 0)
 */

public class QuadrantOfCoordenates {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter value for X coordenate: ");
        int xValue = scanner.nextInt();
        System.out.print("Enter value for Y coordenate: ");
        int yValue = scanner.nextInt();
        scanner.close();
        int quadrant = Coordenates(xValue, yValue);
        System.out.println("The coordenates (" + xValue + "," + yValue + ") represents quandrant: " + quadrant);
    }

    public static Integer Coordenates(int xCoordenate, int yCoordenate) {
        if (xCoordenate == 0 && yCoordenate == 0)
            return 0;
        if (xCoordenate > 0) {
            if (yCoordenate > 0)
                return 1;
            else if (yCoordenate < 0)
                return 4;
            else
                return 0;
        } else if (xCoordenate < 0) {
            if (yCoordenate > 0)
                return 2;
            else if (yCoordenate < 0)
                return 3;
            else
                return 0;
        }
        return 0;
    }

}