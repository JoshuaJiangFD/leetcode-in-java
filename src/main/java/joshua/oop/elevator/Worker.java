

package joshua.oop.elevator;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;

/**
 * @author Jiang Yong
 */
public class Worker implements Runnable {
    private Socket s;
    private Elevator elevator;

    public Worker(Socket s, Elevator elevator) {
        this.s = s;
        this.elevator = elevator;
    }

    @Override
    public void run() {
        try {
            BufferedReader reader = new BufferedReader(
                    new InputStreamReader(s.getInputStream()));
            String line;
            while (true) {
                if ((line = reader.readLine()) != null) {
                    String[] tokens = line.split(" ");
                    if(tokens.length == 3 && tokens[0].equals("call")){
                        elevator.call(Integer.parseInt(tokens[1]), tokens[2].equals("up") ? Direction.UP : Direction.DOWN);
                    }else if(tokens.length == 2 && tokens[0].equals("go")){
                        elevator.go(Integer.parseInt(tokens[1]));
                    }else{
                        s.getOutputStream().write("Wrong input".getBytes());
                    }
                }
            }
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
}