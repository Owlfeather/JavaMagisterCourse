package task1;

import java.util.Scanner;

public class Hello {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.print("What is your name? ");
        String name = in.nextLine();

        System.out.printf("Hello, %s! \n", name);
        in.close();
    }
}