package Week4.Task4and5;

// A subclass of Exam is done by extending it to Essay class (Hence, the
// supperclass of Essay is Exam)
public class Essay extends Exam {

    // Data fields
    private int grammar;
    private int spelling;
    private int contentsAndCoverage;
    private int length;

    private static final int MAX_POINTS1 = 15;
    private static final int MAX_POINTS2 = 55;

    // Constructor
    public Essay(int grammar, int spelling, int contentsAndCoverage, int length) {
        this.grammar = validatePoints(grammar, MAX_POINTS1);
        this.spelling = validatePoints(spelling, MAX_POINTS1);
        this.contentsAndCoverage = validatePoints(contentsAndCoverage, MAX_POINTS2);
        this.length = validatePoints(length, MAX_POINTS1);
    }

    /**
     * 
     * @param points     points obtained for each essay's category
     * @param maxAllowed max quantity of points allowed per category
     * @return if points are within allowed range, return points parameter value.
     *         Else, return 0 due to it invalidness
     */
    private int validatePoints(int points, int maxAllowed) {
        if (points < 0 || points > maxAllowed) {
            System.out.println("There is a category that its points are not valid. Setting as 0");
            return 0;
        } else {
            return points;
        }
    }

    /**
     * 
     * @return summatory of each essay categories
     */
    public int getEssayPoints() {
        return grammar + spelling + contentsAndCoverage + length;
    }

    @Override
    public int getGrade() {
        int essayPoints = Math.min(getEssayPoints(), 100);
        setPoints(essayPoints); // set points variable from essay points
        return super.getGrade(); // return grade value from setPoints method
    }
}
