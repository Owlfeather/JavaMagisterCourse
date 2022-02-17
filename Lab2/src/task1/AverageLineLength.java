package task1;

import java.util.Scanner;

public class AverageLineLength {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.print("Enter number n: ");
        int n = in.nextInt();
        in.skip("\n");

        System.out.print("Enter array of strings: \n");
        String[] stringArray = new String[n];
        for (int i = 0; i < n; i++) {
            stringArray[i] = in.nextLine();
        }

        int averageLength = 0;
        for (int i = 0; i < n; i++) {
            averageLength += stringArray[i].length();
        }
        averageLength = averageLength/n;
        System.out.println("Average string length: " + averageLength);

        System.out.print("\nStrings with less length: \n");
        for (int i = 0; i < n; i++) {
            if(stringArray[i].length() < averageLength){
                System.out.println(stringArray[i]);
            }
        }
        System.out.print("\nStrings with greater length: \n");
        for (int i = 0; i < n; i++) {
            if(stringArray[i].length() > averageLength){
                System.out.println(stringArray[i]);
            }
        }

        TaskCompletionMark taskCompletionMark = new TaskCompletionMark();
        taskCompletionMark.printMark();
    }
}
