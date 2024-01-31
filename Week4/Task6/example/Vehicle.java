package Week4.Task6.example;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class Vehicle implements java.io.Serializable {
    public static void serialization_write() {
        try {
            Vehicle[] vArray = new Vehicle[10];
            for (int i = 0; i < vArray.length; i++)
                vArray[i] = new Vehicle();

            ObjectOutputStream output = new ObjectOutputStream(new FileOutputStream("array.datax", true));

            output.writeObject(vArray);
            output.close();

        } catch (IOException ioe) {
            System.out.println(ioe);
        }
    }

    public static void serialization_read() {

        try {
            ObjectInputStream input = new ObjectInputStream(new FileInputStream("array.datax"));

            Vehicle[] vArray = (Vehicle[]) (input.readObject());

            for (int i = 0; i < vArray.length; i++)
                System.out.println(vArray[i].toString());

            input.close();
        } catch (Exception ioe) {
            System.out.println(ioe);
        }
    }
    public static void main(String[] args) {
        serialization_write();
        serialization_read();
    }
}
