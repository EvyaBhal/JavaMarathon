/**Spring 2020
 * Java Marathon
 * Evyatar Bhalker
 */
package sixSeven;


public class Main {
    public static void main(String[] args) {
        BlockingArrayStack<Integer> blockingArrayStack = new BlockingArrayStack<>();

        for (int i=0; i<10; i++) {
            new Thread(new Runnable() {
                @Override
                public void run() {
                    System.out.println("popped: " + blockingArrayStack.pop());
                }
            }).start();
        }
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        for (int i=0; i<10; i++) {
            int finalI = i;
            new Thread(new Runnable() {
                @Override
                public void run() {
                    blockingArrayStack.push(finalI);
                    System.out.println("pushed: " + finalI);
                }
            }).start();
        }
    }
}
