package Week3.Exercises.Task3;

public class Fan {
    //Datafields    
    private int speed;
    private boolean on = false;
    private double radius = 5;
    private String color = "blue";

    //static values used in speed
    public static final int SLOW=1;
    public static final int MEDUIM=2;
    public static final int FAST=3;

    //Setter and getter 
    private void setSpeed(int speed){
        if (speed >= SLOW && speed <= FAST){ //Checking if speed values are within range allowed.
            this.speed = speed;
        }else{
            System.out.println("Invalid speed value. Allowed values goes from 1 to 3");
        }
    }
    public int getSpeed(){
        return speed;
    }

    private void setRadius(int radius){
        this.radius = radius;
    }
    private double getRadius(){
        return radius;
    }

    private void setColor(String color){
        this.color = color;
    }
    private String getColor(){
        return color;
    }

    //No arguments constructor 
    public Fan(){}

    //methods to turn on/off fan
    public void turnOn(){
        on = true;
    }
    public void turnOff(){
        on = false;
    }

    public void  increaseSpeed(){
        if( speed == FAST){ //if speed is the maximum notify.
            System.out.println("Fan is already running at highest speed.");
        }else{ //increase if not
            speed+= 1;
        }
    }
    public void decreaseSpeed(){
        if( speed == SLOW){ //if speed is the lowest notify.
            System.out.println("Fan is already running at lowest speed.");
        }else{ //decrease if not    
            speed-= 1;
        }
    }

    //Retrieve string containing fan object information.    
    public String toString(){
        if(on == true){
            return "Speed:"+speed+"\nColor:"+color+"\nRadius:"+radius;
        }else{
            return "Color:"+color+"\nRadius:"+radius+"\nFan is off.";       
        }
    }

    public static void main(String[] args) {
        Fan f1 = new Fan();
        Fan f2 = new Fan();
        
        f1.setColor("Red");
        f1.setRadius(10);
        f1.setSpeed(2);
        f1.turnOn();
        f1.increaseSpeed();
        System.out.println(f1.toString()+"\n");

        System.out.println("Fan2 using  get methods: "+ f2.getColor() +" "+f2.getRadius()+" "+f2.getSpeed());
        System.out.println("Fan 2 using to string method: \n"+f2.toString());

    }
}
