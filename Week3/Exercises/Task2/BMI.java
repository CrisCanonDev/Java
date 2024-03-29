package Week3.Exercises.Task2;

public class BMI {
    private String name;
    private int age;
    private double weight; // in pounds
    private double height; // in inches
    public static final double KILOGRAMS_PER_POUND = 0.45359237; 
    public static final double METERS_PER_INCH = 0.0254;  

    
    private boolean metric; //implementation of new variable

    
    public BMI(String name, int age, double weight, double height, boolean metric) {//including  metric constructor's parameters 
      this.name = name;
      this.age = age;
      this.weight = weight;
      this.height = height;
      this.metric = metric; //including metric variable
    }
    
    public BMI(String name, double weight, double height, boolean metric) { //including  metric constructor's parameters 
      this(name, 20, weight, height, true); //including metric variable
    }
    
    public double getBMI() {
      double bmi = weight * KILOGRAMS_PER_POUND / 
        ((height * METERS_PER_INCH) * (height * METERS_PER_INCH));
        if(metric == true){ //Checking if measures are in metric system
            return Math.round(bmi * 100) / 100.0;
        }else{ //Conversion to imperial system when metric is False
            double bmiImperial = weight/(Math.pow(height, 2))*703;
            return Math.round(bmiImperial * 100) / 100.0;
        }
      
    }
    
    public String getStatus() {
      double bmi = getBMI();
      if (bmi < 18.5)
        return "Underweight";
      else if (bmi < 25)
        return "Normal";
      else if (bmi < 30)
        return "Overweight";
      else
        return "Obese";
    }
    
    public String getName() {
      return name;
    }
    
    public int getAge() {
      return age;
    }
    
    public double getWeight() {
      return weight;
    }
    
    public double getHeight() {
      return height;
    }

    //Setter and getters for metric
    public boolean getmetric() {
        return metric;
      }
    public void setMetric(boolean metric){
        this.metric = metric;
    }

  }