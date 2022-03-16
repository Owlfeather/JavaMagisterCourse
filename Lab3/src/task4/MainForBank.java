package task4;

public class MainForBank {
    public static void main(String[] args) {

        Client cl1 = new Client("Ivanov Ivan Ivanovich", 1);
        Client cl2 = new Client("Petrov Petr Petrovich", 2);
        Client cl3 = new Client("Smirnov Igor Igorevich", 3);

        Bank bank = new Bank();

        bank.addClient( 4, cl1);
        bank.addCard(4, 531);
        bank.addMoney(4, 15000);

        bank.addClient( 5, cl2);
        bank.addCard(5, 129);
        bank.addMoney(5, 3000);

        bank.addClient( 6, cl3);
        bank.addCard(6, 773);
        bank.addMoney(6, 100);

        System.out.println("Added clients:");
        System.out.println(bank);

        bank.payOrder(4, 5000);
        bank.switchToAccount(4, 5, 1000);

        System.out.println("Payments are done:");
        System.out.println(bank);

        bank.blockCard(129);
        bank.cancelAccount(6);

        System.out.println("Card blocked and account canceled:");
        System.out.println(bank);

        bank.payOrder(4, 10000000);
        bank.checkCredit(4);

        System.out.println(bank);
    }
}
