package seventeen;

public class Account {
    double balance;
    public void withdraw(double amount) {
        balance -= amount;
    }
    public void deposit(double amount) {
        balance += amount;
    }
}