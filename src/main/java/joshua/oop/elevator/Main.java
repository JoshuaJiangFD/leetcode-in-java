

package joshua.oop.elevator;

/**
 * @author Jiang Yong
 */
public class Main {

    public static void main(String[] args) {
        Elevator elevator = new Elevator();
        Thread processingThread = new Thread(elevator);
        processingThread.start();
        Thread listeningThread = new Thread(new Listener(elevator));
        listeningThread.start();
        try {
            Thread.currentThread().join();
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
}
