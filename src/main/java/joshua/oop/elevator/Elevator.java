

package joshua.oop.elevator;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 * @author Jiang Yong
 */
public class Elevator implements  Runnable{

    private static final int FLOOR_NUM = 10;

    public static Comparator<Request> upComparator = new Comparator<Request>() {
        @Override
        public int compare(Request o1, Request o2) {
            return o1.floor.compareTo(o2.floor);
        }
    };

    public static Comparator<Request> downComparator = new Comparator<Request>() {
        @Override
        public int compare(Request o1, Request o2) {
            return o2.floor.compareTo(o1.floor);
        }
    };

    private float location = 0;

    private Direction direction = Direction.UP;

    private State state = State.STOPPED;

    private Queue<Request> upQueue = new PriorityQueue<Request>(FLOOR_NUM, upComparator);

    private Queue<Request> currentQueue = upQueue;

    private Queue<Request> downQueue = new PriorityQueue<Request>(FLOOR_NUM, downComparator);

    /**
     * call the elevator to go UP/Down at specific floor
     * 相当于相应电梯外面某一层按钮的请求。
     *
     * @param floor
     * @param direction
     */
    public void call(int floor, Direction direction) {
        if (direction == Direction.UP) {
            if (floor >= location) {
                currentQueue.add(new Request(System.currentTimeMillis(), floor,
                        direction));
            } else {
                upQueue.add(new Request(System.currentTimeMillis(), floor,
                        direction));
            }
        } else {
            if (floor <= location) {
                currentQueue.add(new Request(System.currentTimeMillis(), floor,
                        direction));
            } else {
                downQueue.add(new Request(System.currentTimeMillis(), floor,
                        direction));
            }
        }
    }

    /**
     * 相当于已经在电梯里面的乘客请求到达某一楼层
     *
     * @param floor
     */
    public void go(int floor) {
        call(floor, direction);
    }

    public void goToFloor(int floor) {
        state = State.MOVING;
        for (float i = location; i <= floor; i = (float) (i + 0.1)) {
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
        location = floor;
        state = State.STOPPED;
        state = State.DOOR_OPEN;
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        state = State.DOOR_CLOSED;
    }

    @Override
    public void run() {
        process();
    }

    public void process() {
        while (true) {
            if (!upQueue.isEmpty() && !downQueue.isEmpty()) {
                Request r = currentQueue.poll();
                if (r != null) {
                    goToFloor(r.floor);
                } else {
                    // 决定是向上，还是向下
                    preProcessNextQueue();
                }
            }
        }
    }

    private void preProcessNextQueue() {
        if (getLowestTimeUpQueue() > getLowestTimeDownQueue()) {
            this.direction = Direction.UP;
            currentQueue = upQueue;
            upQueue = new PriorityQueue<Request>(FLOOR_NUM,upComparator);
        } else {
            this.direction = Direction.DOWN;
            currentQueue = downQueue;
            downQueue = new PriorityQueue<Request>(FLOOR_NUM, downComparator);
        }
    }

    private long getLowestTimeUpQueue() {
        long lowest = Long.MAX_VALUE;
        for (Request r : upQueue) {
            if (r.getTime() < lowest)
                lowest = r.getTime();
        }
        return lowest;
    }

    private long getLowestTimeDownQueue() {
        long lowest = Long.MAX_VALUE;
        for (Request r : downQueue) {
            if (r.getTime() < lowest)
                lowest = r.getTime();
        }
        return lowest;
    }
}
