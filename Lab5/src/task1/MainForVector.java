package task1;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class MainForVector {
    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);
        Vector vec1;
        Vector vec2;

        try {
            System.out.print("Input vector 1 length: ");
            int n1 = in.nextInt();
            ArrayList<Integer> v1 = new ArrayList<>();
            System.out.println("Input elements for vector 1:");
            for (int i = 0; i < n1; i++) {
                int elem = in.nextInt();
                v1.add(elem);
            }
            vec1 = new Vector(v1);
        } catch (Exception e) {
            in.nextLine();
            System.out.println("Wrong input for vector 1!");
            vec1 = new Vector();
        }

        try {
            System.out.print("Input vector 2 length: ");
            int n2 = in.nextInt();
            ArrayList<Integer> v2 = new ArrayList<>();
            System.out.println("Input elements for vector 2:");
            for (int i = 0; i < n2; i++) {
                int elem = in.nextInt();
                v2.add(elem);
            }
            vec2 = new Vector(v2);
        } catch (Exception e) {
            in.nextLine();
            System.out.println("Wrong input for vector 2!");
            vec2 = new Vector();
        }

        System.out.println("Modulus of first vector: " + vec1.calculateModulus());
        System.out.println("Modulus of second vector: " + vec2.calculateModulus());

        vec1.scalarProduct(vec2);
        vec1.vectorSummation(vec2);
        vec1.vectorSubtraction(vec2);

        System.out.println("Multiplication of first vector by a constant 3: " + vec1.constantMultiplication(3));
        System.out.println("Multiplication of second vector by a constant -5: " + vec2.constantMultiplication(-5));

        System.out.println("Vectors are collinear or orthogonal? Solution: ");
        vec1.defineVectorsStatus(vec2);

    }
}
