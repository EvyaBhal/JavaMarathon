package seventeen;

public class Main2 {
    public static void main(String[] args) {
        Account ac1 = new Account();
        Account ac2 = new Account();
        Thread t1 = new TransferThread(ac1, ac2, 100);
        Thread t2 = new TransferThread(ac2, ac1, 100);
        t1.start();
        t2.start();
    }
}
