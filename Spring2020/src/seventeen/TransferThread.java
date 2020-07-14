package seventeen;

public class TransferThread extends Thread {
    Account from;
    Account to;
    double amount;

    public TransferThread(Account from, Account to, double amount) {
        this.from = from;
        this.to = to;
        this.amount = amount;
    }

    public void transfer() {
        synchronized (from) {
            synchronized (to) {
                from.withdraw(amount);
                to.deposit(amount);
            }
        }
    }

    public void run() {
        transfer();
    }

}
