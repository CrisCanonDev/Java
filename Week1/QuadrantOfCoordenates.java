import java.util.Scanner;

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