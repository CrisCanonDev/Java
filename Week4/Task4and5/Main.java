package Week4.Task4and5;

public class Main {
    public static void main(String[] args) {
        // Instanciating exam class
        Exam examResult= new Exam();
        examResult.setPoints(70);
        System.out.println("Exam Result: "+examResult.getGrade());
        System.out.println("Is a top Exam grade: "+examResult.isTopGrade());

        // Instanciating essay class
        Essay essayResult = new Essay(15,15,50, 14);
        System.out.println("\nEssay points: "+essayResult.getEssayPoints()+" Essay grade: "+essayResult.getGrade());

        //TASK5
        System.out.println("Is a top essay grade: "+essayResult.isTopGrade());
    } 
}
