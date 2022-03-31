package task2;

import java.util.Random;
import java.util.Scanner;

public class MainForParking {

    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);
        System.out.print("Enter number n: ");
        int n = in.nextInt();
        Parking parking = new Parking(n);
        System.out.println();

        System.out.print("Enter start point for search: ");
        int search_start = in.nextInt();
        parking.CarArrival(search_start);
        System.out.println(parking);
        System.out.println();

        System.out.println("Enter place for leaving car: ");
        int leaving_car_place = in.nextInt();
        parking.CarDeparture(leaving_car_place);
        System.out.println(parking);
    }
}
