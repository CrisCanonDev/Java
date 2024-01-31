package Week4.Task4and5;

public class Exam implements TopGrade {
    private double points;

    public void setPoints(double p) {
        this.points = p;
    }

    public double getPoints() {
        return this.points;
    }

    public int getGrade() {
        int grade = 0;
        if (this.points >= 90) {
            grade = 5;
        } else if (this.points >= 80) {
            grade = 4;
        } else if (this.points >= 70) {
            grade = 3;
        } else if (this.points >= 60) {
            grade = 2;
        } else if (this.points >= 50) {
            grade = 1;
        }
        return grade;
    }
    public boolean isTopGrade(){
        if (getGrade() ==5) {
            return true;
        }else{
            return false;
        }
    }
}