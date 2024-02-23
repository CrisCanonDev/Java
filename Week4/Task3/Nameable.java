package Week4.Task3;

// INTERFACE
// Abstract type used to specify behavior of a class
// Interface in java -> Blueprint of a behavior
//     -Static constants
//     -Abstract methods


// Interface is the mechanism to achieve abstraction (show essential details/functionality to users)
        //   provides multiple inheritance | Classes in java does not allow it. 1 class extend to 1 class.
 // FEATURES
    // 1. All methods have no body and are public.
    // 2. All fields public, static, and final by default.
    // 3. Class that implements interface must implement all methods declare in interface.

 // RELATIONSHIPS
    // -Class EXTENDS Class
    // -Class IMPLEMENTS Interface
    // -INTERFACE EXTENDS Interface


/**
 * Nameable
 */
public interface Nameable {
    public void setName(String n);
    public String getName();
} 
/**
 * Person
 */
/**
 * InnerNameable
 */
class two implements Nameable{
    private String name;
    public void setName(Stringname){
        this.name = name;
    };
}
class Person implements Nameable{
    private String name;

    public void setName(String name){
        this.name = name;
    }

    public String getName(){
        return name;
    }

    public static void main(String[] args) {
        Person p = new Person();
        p.setName("Juan");
        System.out.println(p.getName());
    }
}
