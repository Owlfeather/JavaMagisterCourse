package task2;

import java.util.Scanner;

public class Fibonacci {

    static int fib0 = 0;
    static int fib1 = 1;
    static int current_fib = 1;

    public static void nextFib(){
        fib0 = fib1;
        fib1 = current_fib;
        current_fib = fib0 + fib1;
    }

    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);
        System.out.print("Enter number n: ");
        int n = in.nextInt();

        System.out.print("Enter array of numbers: \n");
        int[] numberArray = new int[n];
        for (int i = 0; i < n; i++) {
            numberArray[i] = in.nextInt();
        }

        int maxNumber = numberArray[0];
        for (int i = 0; i < n; i++) {
            if(maxNumber <= numberArray[i]){
                maxNumber = numberArray[i];
            }
        }

        boolean fibFound = false;
        System.out.print("\nFibonacci numbers: \n");
        while (current_fib <= maxNumber){
            for (int i = 0; i < n; i++) {
                if (current_fib == numberArray[i]){
                    fibFound = true;
                    System.out.print(numberArray[i] + " ");
                }
            }
            nextFib();
        }

        if (!fibFound) {
            System.out.print("   Not found :(");
        }

        in.close();

    }
}

