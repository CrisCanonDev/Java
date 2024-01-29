package Week3.Exercises.Task1;

public class Lockbox implements java.io.Serializable {

    //Data fields
    private int codeNumber; // Accessed only within a class
    int lockType; // Accessed any class in case package

    //Constructor
    public Lockbox(int codeNumber, int lockType) {
        this.codeNumber = codeNumber;
        this.lockType = lockType;
    }

    //Getters and setters
    public int getCodeNumber() {
        return codeNumber;
    }

    public void setCodeNumber(int codeNumber) {
        this.codeNumber = codeNumber;
    }

    public int getLockType() {
        return codeNumber;
    }

    public void setLockType(int lockType) {
        this.lockType = lockType;
    }

}
