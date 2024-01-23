package Week2;

public class task1A {
    public static void main(String[] args) {
        Double[] listNumbers = { 2.4, 3.5, 2.5, 77.2, 7.7, 2.11 };
        Double averageValue = average(listNumbers);
        System.out.print("The list of double numbers: ");
        for (int value = 0; value < listNumbers.length; value++) {
            if (listNumbers.length - 1 == value) {
                System.out.print(listNumbers[value] + ".\n");
                break;
            } else {
                System.out.print(listNumbers[value] + ",");
            }
        }

        System.out.println("\nThe list average is: " + averageValue);
    }

    public static double average(Double[] lst) {
        Double avg = 0.0;
        for (int x = 0; x < lst.length; x++) {
            avg += lst[x];
        }
        return avg / (lst.length + 1);
    }
}
