package Week4.Task1;

public class areas {
    // Static: Used to construct methods regardless or not any instace of class is generated
        // FEATURES:
        // 1. Static method in java -> Methos that is part of class rather than an instance of that class.
        // 2. Every instance of class can access to the static method
        // 3. Static methods have access to static variables without using an instance
        // 4. Static data only acessed using static method

        // WHY USE?
        // 1. access and hange static variables
        // 2. 

    //OVERLOADING
        // -Related to compile-time polymorphism
        // -Allows diff methods have same name and diff input parameters and its type
 
    /**
    * Calculating area of a cilinder.
    * 
    *@param r  - radius of cylinder
    *@param h  - height of cylinder      
    */
    public static void calculateArea(double r, double h){  
        double area = ((2*Math.PI)*r)*(r+h);
        System.out.println("Cylinder area: "+ Math.round(area * 100)/100.0); 
    }
    /**
    * Calculating area of a circle.
    * 
    *@param r  - radius of circle      
    */
    public static void calculateArea(double r){  
        double area = Math.PI*(Math.pow(r, 2));
        System.out.println("Circle area: "+ Math.round(area * 100)/100.0); 
    }


    public static void main(String[] args) {
        calculateArea(10);
        calculateArea(20, 5);
    }
}
