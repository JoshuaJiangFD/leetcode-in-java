// Copyright 2016 Baidu Inc. All rights reserved.

package joshua.oop.elevator;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * @author Jiang Yong (jiangyong07@baidu.com)
 */
public class Listener implements Runnable {

    private Elevator elevator;

    public Listener(Elevator elevator) {
        this.elevator = elevator;
    }

    @Override
    public void run() {
        try {
            ServerSocket serverSocket = new ServerSocket(90000);
            while (true) {
                Socket socket = serverSocket.accept();
                Thread thread = new Thread(new Worker(socket, elevator));
                thread.start();
            }
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

    }
}