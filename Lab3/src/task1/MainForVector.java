package task1;
import java.util.ArrayList;
import java.util.Arrays;

public class MainForVector {
    public static void main(String[] args) {

        Vector vec1 = new Vector(new Integer[]{1, 0, 0});
        Vector vec2 = new Vector(new Integer[]{2, 0, 0});

        System.out.println("First vector: " + vec1);
        System.out.println("Second vector: " + vec2);

        System.out.println("Modulus of first vector: " + vec1.calculateModulus());
        System.out.println("Modulus of second vector: " + vec2.calculateModulus());

        System.out.println("Scalar product of vectors: " + vec1.scalarProduct(vec2));
        System.out.println("Summation of vectors: " + vec1.vectorSummation(vec2));
        System.out.println("Subtraction of vectors: " + vec1.vectorSubtraction(vec2));

        System.out.println("Multiplication of first vector by a constant 3: " + vec1.constantMultiplication(3));
        System.out.println("Multiplication of second vector by a constant -5: " + vec2.constantMultiplication(-5));

        Vector[] vectorsArray = {new Vector(new Integer[]{1, 2, 3}),
                                 new Vector(),
                                 new Vector(new ArrayList<>(Arrays.asList(4, 5, 6)))};

        //System.out.println(vec1.isCollinear(vec2));
        //System.out.println(vec1.isOrthogonal(vec2));

        vec1.defineVectorsStatus(vec2);

    }
}
