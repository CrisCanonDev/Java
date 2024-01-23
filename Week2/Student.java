package Week2;

public class Student {
    private int yearsStudied;
    private int credits;
    private String name;

    public String getName(){
        return name;
    }

    //A.Constructor
    Student(){
        yearsStudied = 0;
        credits = 0;
        name = "Unknown";
    }

    //B.
    Student(int yrs, int cre, String nam){
        yearsStudied = yrs;
        credits = cre;
        name = nam;
    }

    //C.
    public double getCreditsPerYear(){
        if(yearsStudied == 0){
            System.out.println("Not able to divide by zero");
            return Double.NaN;
        }else{
            return credits/yearsStudied;
        }
    }

    //D.
    public static void main(String[] args) {
        Student st = new Student(4, 100, "Cristhian");
        System.out.println(st.getName());
        Double creditsYear = st.getCreditsPerYear();

        if(!Double.isNaN(creditsYear)){
            System.out.println("There are "+creditsYear+" per year");
        }

    }
}
