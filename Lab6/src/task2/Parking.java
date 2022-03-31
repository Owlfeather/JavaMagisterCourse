package task2;

import java.util.ArrayList;
import java.util.Random;

public class Parking {

    private int N;
    private ArrayList<Boolean> parking_row;

    public Parking(int n) {
        N = n;
        parking_row = new ArrayList<>(this.N);
        Random random = new Random();
        for (int i = 0; i < n; i++) {
            parking_row.add(random.nextBoolean());
        }
        System.out.println("Parking created: ");
        System.out.println(this);
    }

    public boolean CarArrival(int start_point){
        System.out.println("---Car arrived to parking---");
        System.out.println("Car starts searching from place number " + start_point);
        for (int i = start_point-1; i < N; i++) {
            if(!parking_row.get(i)){
                System.out.println("Car took place number " + (i+1));
                parking_row.set(i, true);
                return true;
            }
        }
        System.out.println("No free places");
        return false;
    }

    public void CarDeparture(int parking_place){
        System.out.println("Car is leaving place number " + parking_place);
        parking_row.set(parking_place-1, false);
        System.out.println("---Car left parking---");
    }

    @Override
    public String toString() {
        return "Parking{" +
                "parking_row=" + parking_row +
                '}';
    }
}
