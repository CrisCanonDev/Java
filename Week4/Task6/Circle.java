package Week4.Task6;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

//Implementing Serialization- deserialization 
public class Circle extends GeometricObject implements java.io.Serializable {
	private double radius;

	public Circle() {
	}

	public Circle(double radius) {
		this.radius = radius;
	}

	/** Return radius */
	public double getRadius() {
		return radius;
	}

	/** Set a new radius */
	public void setRadius(double radius) {
		this.radius = radius;
	}

	@Override /** Return area */
	public double getArea() {
		return radius * radius * Math.PI;
	}

	/** Return diameter */
	public double getDiameter() {
		return 2 * radius;
	}

	@Override /** Return perimeter */
	public double getPerimeter() {
		return 2 * radius * Math.PI;
	}

	/* Print the circle info */
	public void printCircle() {
		System.out.println("The circle is created " + getDateCreated() +
				" and the radius is " + radius);
	}

	@Override /** Return a string representation of a Circle object */
	public String toString() {
		return super.toString() + " radius: " + radius;
	}

	// ------TASK 6---------------
	/**
	 * Method that performs serialization
	 * 
	 * This method takes no parameter and serialize an array of 10 Circle's instance
	 * providing a random radius from 0 - 10 through its class argumented
	 * constructor.
	 * 
	 * @throws IOException an I/O error occurs while writing to the
	 *                     ObjectOutputStream file.
	 */
	public static void serialization_write() {
		try {
			Circle[] vArray = new Circle[10];
			for (int i = 0; i < vArray.length; i++) {
				double rndRadius = (double) (Math.random() * 100) + 1;
				rndRadius = Math.round(rndRadius * 100) / 100.0;
				vArray[i] = new Circle(rndRadius);
			}

			ObjectOutputStream output = new ObjectOutputStream(new FileOutputStream("Circles.data", true));

			output.writeObject(vArray);
			output.close();

		} catch (IOException ioe) {
			System.out.println("Error ocurred during serialization: " + ioe.getMessage());
			ioe.printStackTrace();
		}
	}

	/**
	 * Method that performs de-serialization
	 * 
	 * This method takes no parameter and deserialize object stream containing
	 * Circle class information of 10 instances.Then, saving it to an Array to find
	 * the higest and lowest area instances.
	 * 
	 * @throws FileNotFoundException an I/O error occurs while file is not found.
	 * @throws IOException           an I/O error occurs while writing to the
	 *                               ObjectOutputStream file.
	 */
	public static void serialization_read() {
		// (2)
		try {
			ObjectInputStream input = new ObjectInputStream(new FileInputStream("Circles.data"));

			Circle[] vArray = (Circle[]) (input.readObject());

			SmallestAndHighestArea(vArray);

			input.close();
		} catch (FileNotFoundException fnf) {
			System.out.println("The file cannot be found. Please check file's name");
		} catch (Exception ioe) {
			System.out.println(ioe);
		}
	}

	
	/**
	 * Method that prints smallest and highest circle's area of the array
	 * 
	 * @param CircleList Array of type Circle containing insntance
	 */
	public static void SmallestAndHighestArea(Circle[] CircleList) {

		if (CircleList == null || CircleList.length == 0) {
			System.out.println("There is no circle instances created");
		} else {
			//set as small/highest value the area from 1st index value of Circles' array
			double smallArea = CircleList[0].getArea();
			double highestArea = CircleList[0].getArea();
			//Set its index
			int smallAreaIndex = 0;
			int highestAreaIndex = 0;

			System.out.println("--CIRCLES' ARRAY--");
			for (int i = 0; i < CircleList.length; i++) {
				System.out.println("CIRCLE "+(i+1));
				System.out.println(CircleList[i].toString()+"\n");

				double currentArea = CircleList[i].getArea();
				if (currentArea < smallArea) {
					smallArea = currentArea;
					smallAreaIndex = i;
				}
				if (currentArea > highestArea) {
					highestArea = currentArea;
					highestAreaIndex = i;
				}

			}
			System.out.println("////CIRCLE WITH SMALLEST AREA ///\n" + CircleList[smallAreaIndex].toString());
			System.out.println("\n////CIRCLE WITH HIGHEST AREA ///\n" + CircleList[highestAreaIndex].toString());

		}
	}

	public static void main(String[] args) {
		serialization_write();

		serialization_read();
	}
}