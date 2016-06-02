package joshua.oop.parkinglot;

/**
 * @author Joshua.Jiang on 2016/6/2.
 */
public class Main {
    public static void main(String[] args) {
        ParkingLot lot = new ParkingLot();

        Vehicle v = null;
        while (v == null || lot.parkVehicle(v)) {
            lot.print();
            int r = (int) (Math.random() * (10));
            if (r < 2) {
                v = new Bus();
            } else if (r < 4) {
                v = new Motorcycle();
            } else {
                v = new Car();
            }
            System.out.print("\nParking a ");
            v.print();
            System.out.println("");
        }
        System.out.println("Parking Failed. Final state: ");
        lot.print();
    }
}
