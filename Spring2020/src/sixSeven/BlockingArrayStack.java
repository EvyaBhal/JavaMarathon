/**Spring 2020
 * Java Marathon
 * Evyatar Bhalker
 */
package sixSeven;



public class BlockingArrayStack<E> extends ArrayStack<E> {

    @Override
    public void push(E elem) {
        synchronized (this) {
            super.push(elem);
            notifyAll();
        }
    }

    @Override
    public E peek() {
        synchronized (this) {
            while (isEmpty()) {
                try {
                    wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            return super.peek();
        }
    }

    @Override
    public E pop() {
        synchronized (this) {
            while (isEmpty()) {
                try {
                    wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            return super.pop();
        }
    }
}