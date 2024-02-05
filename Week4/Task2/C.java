package Week4.Task2;

// Abstract: Java modifier applicable for classes and methods/ Not variables
// Abstract class : 
//     Class that can not be initiated by itself
//     Needs to be SUBCLASSED by another class to use its properties

// FEATURES:
// 1. Instance of abstract class can not be created
// 2. constructor allowed
// 3. Can have abstract class without any abstract method
// 4. Final method -> Can be in abstract class / an abstract method cannot be declared as final
// 5. Static methods in abstract class are allowed
abstract public class C {
    private int a;
    int b;

    public int getA() {
        return a;
    }

    public void setA(int a) {
        this.a = a;
    }

    public int getB() {
        return b;
    }

    public void setB(int b) {
        this.b = b;
    }
    public String toString() {
        return "A:" + this.a + " B:" + this.b;
    }

    abstract public double calculate(int x, int y);
}

class D extends C {
    private double q; // Private limit access to its own class
    protected double r;// Private limit access to its package

    // Setters and getters for class D data fields
    public void setQ(double q) {
        this.q = q;
    }

    public double getQ() {
        return q;
    }

    public void setR(double r) {
        this.r = r;
    }

    public double getR() {
        return r;
    }

    // Method that implements abstact superclass method
    @Override
    public double calculate(int a, int b) {
        return this.getA() * this.b;
    }

    public String toString() {
        return super.toString() + " Q:" + this.q + " R:" + this.r;
    }

    public static void main(String[] args) {
        D obj = new D(); // Instanciating D object
        // Passing values through setters
        obj.setA(30);
        obj.setB(2);
        obj.setQ(1.2);
        obj.setR(3.5);

        System.out.println(obj.getQ()); // Obtaining value from Q getter
        System.out.println(obj.calculate(obj.getA(), obj.b)); // Obtaining product from getters A and B

        System.out.println(obj.toString()); // Returning string made of supperclass method (via super) to its subclass
                                            // by adding its attributes
    }
}
