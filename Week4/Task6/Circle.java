package Week4.Task6;
// SERIALIZATION. Mechanism of converting state of object into byte stream 
// byte stream independent platform
    // Advantages:
    //     1.Save state of work
    //     2.Travel object across a newtork

    

public class Circle implements java.io.Serializable {
    Circle[] vArray = new Circle[10];
    for (int i=0;i< vArray.length;i++){
        vArray[i] = new Circle();
    }
}
