package seventeen;

import java.util.concurrent.locks.Lock;

public class TransferThreadGood extends Thread {
    Account from;
    Account to;
    double amount;
    Lock lock;

    public TransferThreadGood(Account from, Account to, double amount, Lock lock) {
        this.from = from;
        this.to = to;
        this.amount = amount;
        this.lock = lock;
    }

    public void transfer() {
        lock.lock();
        synchronized (from) {
            synchronized (to) {
                lock.unlock();
                from.withdraw(amount);
                to.deposit(amount);
            }
        }
    }

    public void run() {
        transfer();
    }

}