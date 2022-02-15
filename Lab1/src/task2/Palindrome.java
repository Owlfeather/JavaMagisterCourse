package task2;

import java.util.Scanner;

public class Palindrome {

    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);
        System.out.print("Enter number n: ");
        int n = in.nextInt();

        System.out.print("Enter array of numbers: \n");
        int[] numberArray = new int[n];
        for (int i = 0; i < n; i++) {
            numberArray[i] = in.nextInt();
        }

        boolean palFound = false;
        System.out.print("\nPalindrom numbers: \n");

        boolean isPalindrome;
        for (int i = 0; i < n; i++) {
            String numAsString = numberArray[i] + "";
            isPalindrome = true;
            for (int j = 0; j < numAsString.length()/2; j++) {
                if (numAsString.charAt(j) !=  numAsString.charAt(numAsString.length() - j - 1)){
                    isPalindrome = false;
                    break;
                }
            }
            if (isPalindrome){
                palFound = true;
                System.out.print(numberArray[i] + " ");
            }
        }
        if (!palFound) {
            System.out.print("   Not found :(");
        }

        in.close();

    }
}
