package task3;

import java.util.ArrayList;
import java.util.Arrays;

public class MainForArrays {
    public static void main(String[] args) {

        Array1Dim ar1 = new Array1Dim(new ArrayList<Float>(Arrays.asList(1.f, 2.f, 3.f)));
        Array1Dim ar2 = new Array1Dim(new ArrayList<Float>(Arrays.asList(4.f, 5.f, 6.f)));

        System.out.println("Array 1 : ");
        System.out.println(ar1);
        System.out.println("Array 2 : ");
        System.out.println(ar2);

        Array1Dim ar_sum = ar1.getClone();
        Array1Dim ar_sub = ar1.getClone();
        Array1Dim ar_mul = ar1.getClone();

        System.out.println();
        System.out.println("Array summation : ");
        ar_sum.summation(ar2);
        System.out.println(ar_sum);

        System.out.println();
        System.out.println("Array subtraction : ");
        ar_sub.subtraction(ar2);
        System.out.println(ar_sub);

        System.out.println();
        System.out.println("Array multiplication : ");
        ar_mul.multiplication(ar2);
        System.out.println(ar_mul);

    }
}
