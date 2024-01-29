package Week3.Exercises.Task1;

public class mainLockBox {
    public static void main(String[] args) {
        //Object creation from LockBock class
        Lockbox l1 = new Lockbox(1,2);
        Lockbox l2 = new Lockbox(2,1);
        
        //Printing from object
        System.out.println(l1); //Retrieve data directly    
        
        //Printing using getters
        System.out.println(l1.getCodeNumber());
        System.out.println(l2.getCodeNumber());

        //Updating a get method
        l1.setCodeNumber(33);
        System.out.println(l1.getCodeNumber());
        
    }
}
