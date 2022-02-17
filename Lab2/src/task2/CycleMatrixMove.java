package task2;

import java.util.Scanner;
import java.util.concurrent.ThreadLocalRandom;

public class CycleMatrixMove {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.print("Enter number n: ");
        int n = in.nextInt();
        int[][] matrix = new int[n][n];

        for(int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                matrix[i][j] = ThreadLocalRandom.current().nextInt(-n, n + 1);
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
        System.out.print("Enter number k: ");
        int k = in.nextInt();

        int[][] rightCycleMovedMatrix = new int[n][n];
        int[][] leftCycleMovedMatrix = new int[n][n];
        int[][] upCycleMovedMatrix = new int[n][n];
        int[][] downCycleMovedMatrix = new int[n][n];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                rightCycleMovedMatrix[i][j] = matrix[i][(j+n-k)%n];
                leftCycleMovedMatrix[i][j] = matrix[i][(j+k)%n];
                upCycleMovedMatrix[i][j] = matrix[(i+k)%n][j];
                downCycleMovedMatrix[i][j] = matrix[(i+n-k)%n][j];
            }
        }
        System.out.print("\nRight cycle move: \n");
        for(int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print(rightCycleMovedMatrix[i][j] + " ");
            }
            System.out.println();
        }
        System.out.print("\nLeft cycle move: \n");
        for(int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print(leftCycleMovedMatrix[i][j] + " ");
            }
            System.out.println();
        }
        System.out.print("\nUp cycle move: \n");
        for(int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print(upCycleMovedMatrix[i][j] + " ");
            }
            System.out.println();
        }
        System.out.print("\nDown cycle move: \n");
        for(int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print(downCycleMovedMatrix[i][j] + " ");
            }
            System.out.println();
        }
    }
}
