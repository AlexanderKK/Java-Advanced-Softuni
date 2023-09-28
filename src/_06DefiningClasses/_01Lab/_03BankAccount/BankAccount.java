package _06DefiningClasses._01Lab._03BankAccount;

public class BankAccount {
    private static double interestRate = 0.02;
    private static int nextID = 1;
    private double balance;
    private int id;

    public BankAccount() {
        this.id = nextID++;
    }

    public static void setInterestRate(double interest) {
        BankAccount.interestRate = interest;
    }

    public double getInterest(int years) {
        return BankAccount.interestRate * years * balance;
    }

    public void deposit(double amount) {
        balance += amount;
    }

    public int ID() {
        return id;
    }
}
