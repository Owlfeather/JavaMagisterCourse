package task2;

import java.util.Scanner;
import java.util.concurrent.ThreadLocalRandom;

public class FindSequence {

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

        int maxRowAscCount = 0;
        int maxRowAscCountRowIndex = 0;
        int maxRowDescCount = 0;
        int maxRowDescCountRowIndex = 0;
        for(int i = 0; i < n; i++) {
            int ascCount = 1;
            int descCount = 1;
            for (int j = 0; j < n-1; j++) {
                if (matrix[i][j] < matrix[i][j+1]){
                    ascCount++;
                }
                else {
                    ascCount = 1;
                }
                if (ascCount > maxRowAscCount){
                    maxRowAscCount = ascCount;
                    maxRowAscCountRowIndex = i;
                }
                if (matrix[i][j] > matrix[i][j+1]){
                    descCount++;
                }
                else {
                    descCount = 1;
                }
                if (descCount > maxRowDescCount){
                    maxRowDescCount = descCount;
                    maxRowDescCountRowIndex = i;
                }
            }
        }
        System.out.print("Max row ascending: ");
        System.out.print(maxRowAscCount + " in row №" + maxRowAscCountRowIndex);
        System.out.print("\nMax row descending: ");
        System.out.print(maxRowDescCount + " in row №" + maxRowDescCountRowIndex);

        int maxColAscCount = 0;
        int maxColAscCountRowIndex = 0;
        int maxColDescCount = 0;
        int maxColDescCountRowIndex = 0;
        for(int j = 0; j < n; j++) {
            int ascCount = 1;
            int descCount = 1;
            for (int i = 0; i < n-1; i++) {
                if (matrix[i][j] < matrix[i+1][j]){
                    ascCount++;
                }
                else {
                    ascCount = 1;
                }
                if (ascCount > maxColAscCount){
                    maxColAscCount = ascCount;
                    maxColAscCountRowIndex = i;
                }
                if (matrix[i][j] > matrix[i+1][j]){
                    descCount++;
                }
                else {
                    descCount = 1;
                }
                if (descCount > maxColDescCount){
                    maxColDescCount = descCount;
                    maxColDescCountRowIndex = i;
                }
            }
        }
        System.out.print("\nMax col ascending: ");
        System.out.print(maxColAscCount + " in col №" + maxColAscCountRowIndex);
        System.out.print("\nMax col descending: ");
        System.out.print(maxColDescCount + " in col №" + maxColDescCountRowIndex);
    }
}
