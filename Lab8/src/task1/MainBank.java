package task1;

import java.util.Random;

public class MainBank {

    public volatile static int account;
    public volatile static Random random;

    public static void main(String[] args) throws InterruptedException {
        random = new Random();
        account = 0;

        new Thread(income).start();
        Thread.sleep(2000);
        new Thread(outcome).start();

    }

    static Runnable income = new Runnable() {
        @Override
        public void run() {
            while (true) {
                try {
                    Thread.sleep(5000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                int receipt = random.nextInt(100, 500);
                account += receipt;
                System.out.print("New income: ");
                System.out.println(receipt);
                System.out.print("Account: ");
                System.out.println(account);
                System.out.println("-----------");
            }
        }
    };

    static Runnable outcome = new Runnable() {
        @Override
        public void run() {
            while (true) {
                try {
                    Thread.sleep(5000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                int withdraw = random.nextInt(200, 400);
                if (withdraw <= account) {
                    account -= withdraw;
                    System.out.print("New outcome: ");
                    System.out.println(withdraw);
                    System.out.print("Account: ");
                    System.out.println(account);
                    System.out.println("-----------");
                } else {
                    System.out.print("Tried to write-off: ");
                    System.out.println(withdraw);
                    System.out.print("Account: ");
                    System.out.println(account);
                    System.out.println("Not enough money!");
                    System.out.println("-----------");
                }
            }
        }
    };
}
