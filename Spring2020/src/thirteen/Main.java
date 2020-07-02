package thirteen;

public class Main {
    public static void main(String[] args) {
        String s1 = "bing ";
        s1 = s1.concat( "boom " );
        String s2 = "bang ";
        String s3 = "bong ";
        s3.concat( "bamm " );

        System.out.println( s1 + s2 + s3 );
    }

}

class Abcde extends Thread {
    public synchronized void run() {
        try {
            System.out.println( "A" );
            wait();
            System.out.println( "B" );
            notify();
            System.out.println( "C" );
        } catch( Exception e ) {
            System.out.println( "D" );
        } finally {
            System.out.println( "E" );
        }
    }

    public static void main(String[] args) {
        new Abcde().start();
    }
}
