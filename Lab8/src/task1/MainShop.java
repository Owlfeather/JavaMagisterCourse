package task1;

import java.util.Random;

public class MainShop {

    public volatile static boolean supply_done;
    public volatile static int stock;
    public volatile static Random random;

    public static void main(String[] args) {
        random = new Random();
        stock = 0;
        supply_done = false;

        new Thread(supplier).start();
        new Thread(customer).start();

    }

    static Runnable supplier = new Runnable() {
        @Override
        public void run() {
            while (true) {
                try {
                    Thread.sleep(5000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                int goods = random.nextInt(1, 25);
                stock += goods;
                System.out.print("New supply: ");
                System.out.println(goods);
                System.out.print("Stock: ");
                System.out.println(stock);
                System.out.println("-----------");
                supply_done = true;
            }
        }
    };

    static Runnable customer = new Runnable() {
        @Override
        public void run() {
            int order = random.nextInt(25, 50);
            while (true) {
                while (!supply_done) {
                    // беск цикл
                }
                if (order <= stock) {
                    stock -= order;
                    System.out.print("Bought: ");
                    System.out.println(order);
                    System.out.print("Stock: ");
                    System.out.println(stock);
                    System.out.println("-----------");
                    order = random.nextInt(25, 50);
                } else {
                    System.out.print("Order: ");
                    System.out.println(order);
                    System.out.print("Stock: ");
                    System.out.println(stock);
                    System.out.println("Not enough goods!");
                    System.out.println("-----------");
                }
                supply_done = false;
            }
        }
    };

}
