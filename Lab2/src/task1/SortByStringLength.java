package task1;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

class StringLengthSortComparator implements Comparator<String> {
    public int compare(String o1, String o2) {
        if(o1.length() > o2.length()){
            return 1;
        }else{
            if(o1.length() < o2.length()){
                return -1;
            }else{
                return 0;
            }
        }
    }
}

public class SortByStringLength {

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

        Arrays.sort(stringArray, new StringLengthSortComparator());

        System.out.print("Sorted array of strings: \n");
        for (int i = 0; i < n; i++) {
            System.out.println(stringArray[i]);
        }

        System.out.print("\nReverse order of sorted array of strings: \n");
        for (int i = n-1; i >= 0; i--) {
            System.out.println(stringArray[i]);
        }

        TaskCompletionMark taskCompletionMark = new TaskCompletionMark();
        taskCompletionMark.printMark();
    }
}
