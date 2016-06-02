package joshua.oop.parkinglot;

/**
 * @author Joshua.Jiang on 2016/6/2.
 */
public class Car extends Vehicle {

    public Car() {
        spotsNeeded = 1;
        size = VehicleSize.Compact;
    }

    public boolean canFitInSpot(ParkingSpot spot) {
        return spot.getSize() == VehicleSize.Large || spot.getSize() == VehicleSize.Compact;
    }

    public void print() {
        System.out.print("C");
    }
}
