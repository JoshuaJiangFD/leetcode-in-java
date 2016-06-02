// Copyright 2016 Baidu Inc. All rights reserved.

package joshua.oop.elevator;

/**
 * @author Jiang Yong (jiangyong07@baidu.com)
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
