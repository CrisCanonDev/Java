package Week2;

public class Rectangle {
    private double height;
    private double width;

    Rectangle(){
        height = 1;
        width = 1;
    }

    Rectangle(double newHeight, double newWidth){
        this.height = newHeight;
        this.width = newWidth;
    }
    
    public double getArea(){
        return height*width;
    }

    public double getDiagonal(){
        return Math.sqrt(Math.pow(height,2)+Math.pow(width,2));
    }

    public static void main(String[] args) {
        Rectangle r1 = new Rectangle();
        Rectangle r2 = new Rectangle(4, 3);

        System.out.println("Rectangle 1\nArea: "+r1.getArea()+"\nDiagonal: "+r1.getDiagonal());
        System.out.println("Rectangle 2\nArea: "+r2.getArea()+"\nDiagonal: "+r2.getDiagonal());
        

    }

}
