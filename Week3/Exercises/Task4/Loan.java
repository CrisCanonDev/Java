package Week3.Exercises.Task4;

import java.util.Scanner;

// Implements Seriablizable to support object IO  
public class Loan implements java.io.Serializable {
  private double annualInterestRate;
  private int numberOfYears;
  private double loanAmount;
  private java.util.Date loanDate;

  /** Default constructor */
  public Loan() {
    this(2.5, 1, 1000);
  }

  /**
   * Construct a loan with specified annual interest rate,
   * number of years and loan amount
   */
  public Loan(double annualInterestRate, int numberOfYears,
      double loanAmount) {
    this.annualInterestRate = annualInterestRate;
    this.numberOfYears = numberOfYears;
    this.loanAmount = loanAmount;
    loanDate = new java.util.Date();
  }

  /** Return annualInterestRate */
  public double getAnnualInterestRate() {
    return annualInterestRate;
  }

  /** Set a new annualInterestRate */
  public void setAnnualInterestRate(double annualInterestRate) {
    this.annualInterestRate = annualInterestRate;
  }

  /** Return numberOfYears */
  public int getNumberOfYears() {
    return numberOfYears;
  }

  /** Set a new numberOfYears */
  public void setNumberOfYears(int numberOfYears) {
    this.numberOfYears = numberOfYears;
  }

  /** Return loanAmount */
  public double getLoanAmount() {
    return loanAmount;
  }

  /** Set a newloanAmount */
  public void setLoanAmount(double loanAmount) {
    this.loanAmount = loanAmount;
  }

  /** Find monthly payment */
  public double getMonthlyPayment() {
    double monthlyInterestRate = annualInterestRate / 1200;
    double monthlyPayment = loanAmount * monthlyInterestRate / (1 -
        (Math.pow(1 / (1 + monthlyInterestRate), numberOfYears * 12)));
    return monthlyPayment;
  }

  /** Find total payment */
  public double getTotalPayment() {
    double totalPayment = getMonthlyPayment() * numberOfYears * 12;
    return totalPayment;
  }

  /** Return loan date */
  public java.util.Date getLoanDate() {
    return loanDate;
  }

  //void method that print menu every time is called.
  public static void printMenu() {
    System.out.println("----------LOAN----------\n1) Apply for a new loan.\n2) Get montly payment.\n3) Quit.");
    System.out.print("Enter an option (3 to exit): ");
  }


  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int userInput;
    boolean loanCreated = false;

    Loan newLoan = new Loan();

    //do-while to repeate loop until exit option is typed=.
    do {
      printMenu();
      userInput = sc.nextInt();
      if (userInput == 1) {
        System.out.println("Please enter the following information.");
        System.out.print("Annual rate interest: ");
        double newAnnualRateInterest = sc.nextDouble();
        System.out.print("Loan's number of years: ");
        int newNumberOfYears = sc.nextInt();
        System.out.print("Loan's amount: ");
        double newAmount = sc.nextDouble();

        newLoan.setAnnualInterestRate(newAnnualRateInterest);
        newLoan.setNumberOfYears(newNumberOfYears);
        newLoan.setLoanAmount(newAmount);
        loanCreated = true;

        System.out.println("New loan has been created succesfully!\n");
      } else if (userInput == 2) {
        if (loanCreated) { //Flag to check loan's creation  
          String formattedNumber = String.format("%.2f", newLoan.getMonthlyPayment());
          System.out.println("Loan's montly payment. £" + formattedNumber);

        } else {
          System.out.println("No loan applications. Apply for a loan first.");
        }
      } else {
        System.out.println("-Enter a valid option.\n"); //if option is not allowed.
      }
    } while (userInput != 3);
    sc.close();
  }
}
