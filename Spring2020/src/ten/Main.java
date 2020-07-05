/**Spring 2020
 * Java Marathon
 * Evyatar Bhalker
 */
package ten;

import java.util.Queue;
import java.util.concurrent.ArrayBlockingQueue;

class ThreadPool {
    private boolean alive;
    private Queue<Runnable> queue;
    private final int MAX_ELEMENTS_IN_QUEUE = 10000;

    public ThreadPool(int numThreads) {
        alive = true;
        queue = new ArrayBlockingQueue<>(MAX_ELEMENTS_IN_QUEUE);

        for (int i=0; i<numThreads; i++) {
            new Thread(new Runnable() {
                @Override
                public void run() {
                    while (alive) {
                        Runnable task = getTask();
                        if (!alive) return;
                        task.run();
                    }
                }
            }).start();
        }
    }

    public Runnable getTask() {
        synchronized (this) {
            while (alive && queue.isEmpty()) {
                try {
                    wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            notifyAll();
        }
        return alive ? queue.remove() : null;
    }

    public void execute(Runnable task) {
        synchronized (this) {
            if (queue.size() == MAX_ELEMENTS_IN_QUEUE) {
                try {
                    wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            queue.add(task);
            notifyAll();
        }
    }

    public void shutdown() {
        alive = false;
        synchronized (this) {
            notifyAll();
        }
    }
    public static void main(String[] args) {
        ThreadPool ThreadPool = new ThreadPool(10);
        for (int i=0; i<1000; i++) {
            int finalI = i;
            ThreadPool.execute(new Runnable() {
                @Override
                public void run() {
                    System.out.println("task number " + finalI);
                }
            });
        }
        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        ThreadPool.shutdown();
    }
}

