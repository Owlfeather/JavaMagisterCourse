package task1;

import java.util.HashMap;
import java.util.Random;
import java.util.Scanner;

public class SumPolinomialElements {

    public static void main(String[] args) {

        HashMap<Integer, Integer> polinom1 = new HashMap<>();
        HashMap<Integer, Integer> polinom2 = new HashMap<>();
        HashMap<Integer, Integer> polinom_result = new HashMap<>();

        Random random = new Random();
        Scanner in = new Scanner(System.in);
        System.out.print("Enter number n: ");
        int length = in.nextInt();

        for (int i = 0; i < length; i++) {
            polinom1.put(i, random.nextInt(15));
            polinom2.put(i, random.nextInt(15));
        }

        System.out.println(polinom1);
        System.out.println(polinom2);

        for (int key : polinom1.keySet()) {
            polinom_result.put(key, polinom1.get(key) + polinom2.get(key));
        }

        System.out.println("Result: ");
        System.out.println(polinom_result);

    }
}
