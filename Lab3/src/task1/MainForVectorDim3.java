package task1;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class MainForVectorDim3 {
    public static void main(String[] args) {

        VectorDim3 vec1 = new VectorDim3(0, 1, 0, 0, 0, 0);
        VectorDim3 vec2 = new VectorDim3(0, 0, 0, 1, 0, 1);
        VectorDim3 vec3 = new VectorDim3(0, 1, 0, 1, 0, 1);
        VectorDim3 vec4 = new VectorDim3(0, 1, 0, -1, 0, 1);

        System.out.println("First vector: "+vec1);
        System.out.println("Second vector: "+vec2);

        System.out.println( vec1.isOrthogonal(vec2) ? "Vectors are orthogonal" : "Vectors aren't orthogonal");
        System.out.println(vec1.compareVectors(vec2));

        System.out.println("Third vector: "+vec3);
        System.out.println("Fourth vector: "+vec4);

        System.out.println( vec3.isOrthogonal(vec4) ? "Vectors are orthogonal" : "Vectors aren't orthogonal");
        System.out.println( vec3.isCrossed(vec4, 0.5f) ? "Vectors are crossed" : "Vectors aren't crossed");
        System.out.println(vec3.compareVectors(vec4));

        VectorDim3 vec5 = new VectorDim3(0, 0, 0, 1, 0, 0);
        VectorDim3 vec6 = new VectorDim3(0, 0, 0, 2, 0, 0);
        VectorDim3 vec7 = new VectorDim3(0, 0, 0, 7, 0, 0);
        System.out.println(vec1.areComplanar(vec2, vec3) ? "Vectors are complanar" : "Vectors aren't complanar");
        System.out.println(vec5.areComplanar(vec6, vec7) ? "Vectors are complanar" : "Vectors aren't complanar");

        ArrayList<VectorDim3> vectorArrayList = new ArrayList<>();

        Scanner in = new Scanner(System.in);
        System.out.print("Enter number m: ");
        int m = in.nextInt();
        Random random = new Random();
        float x_start, x_end, y_start, y_end, z_start, z_end;
        float bound_1 = -3.f;
        float bound_2 = 3.f;
        for (int i = 0; i < m; i++) {
            x_start = random.nextFloat(bound_1, bound_2);
            x_end = random.nextFloat(bound_1, bound_2);
            y_start = random.nextFloat(bound_1, bound_2);
            y_end = random.nextFloat(bound_1, bound_2);
            z_start = random.nextFloat(bound_1, bound_2);
            z_end = random.nextFloat(bound_1, bound_2);
            vectorArrayList.add(new VectorDim3(x_start, x_end, y_start, y_end, z_start, z_end));
        }
        for (int i = 0; i < m-2; i++) {
            for (int j = i+1; j < m-1; j++) {
                for (int k = j+1; k < m; k++) {
                    System.out.println(vectorArrayList.get(i).areComplanar(vectorArrayList.get(j), vectorArrayList.get(k)) ? "Vectors are complanar" : "Vectors aren't complanar");
                }
            }
        }
    }
}
