// Copyright 2016 Baidu Inc. All rights reserved.

package joshua.oop.elevator;

/**
 * @author Jiang Yong (jiangyong07@baidu.com)
 */
public class Request {

    private long time;

    private Direction direction;

    public Integer floor;

    public Request(long time, Integer floor, Direction direction) {
        this.time = time;
        this.direction = direction;
        this.floor = floor;
    }

    public long getTime() {
        return time;
    }

    public Direction getDirection() {
        return direction;
    }

    public Integer getFloor() {
        return floor;
    }

}
