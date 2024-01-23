package Week2;

public class task1B {
    public static void main(String[] args) {
        int[][] twoDimensionArray = {
                { 1, 2, 3, 4, 5, 6, 7 },
                { 5, 2, 7, 4, 7, 4, 7 }
        };
        Double[][] doubleTwoDimensionArray = new Double[twoDimensionArray.length][twoDimensionArray[0].length];
        for (int i = 0; i < twoDimensionArray.length; i++) {
            for (int j = 0; j < twoDimensionArray[0].length; j++) {
                doubleTwoDimensionArray[i][j] = (double) twoDimensionArray[i][j];
            }
        }
        String salesPerWeek = weeklySales(doubleTwoDimensionArray);
        System.out.println("The total sales per week is: "+salesPerWeek);
    }

    public static String weeklySales(Double[][] arr) {
        String sales = "";
        for (int x = 0; x < arr.length; x++) {
            Double totalWeekly = 0.0;
            for (int y = 0; y < arr[0].length; y++) {
                totalWeekly += arr[x][y];
            }
            if(arr.length-1 == x){
                sales += totalWeekly;
            }else{
                sales += totalWeekly+", ";
            }
        }
        return sales;

    }
}
