package seventeen;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Main1 {
    public static void main(String[] args) {
        Account ac1 = new Account();
        Account ac2 = new Account();
        Lock lock = new ReentrantLock();
        Thread t1 = new TransferThreadGood(ac1, ac2, 100,lock );
        Thread t2 = new TransferThreadGood(ac2, ac1, 100,lock);
        t1.start();
        t2.start();
    }
}