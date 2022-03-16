package task4;

import java.util.HashMap;

public class Bank {
    private HashMap<Integer, Client> account_client;
    private HashMap<Integer, Integer> account_sum;
    private HashMap<Integer, Integer> account_card;
    private HashMap<Integer, Boolean> card_active;

    public Bank() {
        account_client = new HashMap<>();
        account_sum = new HashMap<>();
        account_card = new HashMap<>();
        card_active = new HashMap<>();
    }

    public void addClient(Integer acc_id, Client client){
        account_client.put(acc_id, client);
        account_sum.put(acc_id, 0);
    }

    public void addCard(Integer acc_id, Integer cardNum){
        account_card.put(acc_id, cardNum);
        card_active.put(cardNum, true);
    }

    public void addMoney(Integer acc_id, Integer amount){
        account_sum.put(acc_id, account_sum.get(acc_id) + amount);
    }

    public void blockCard(Integer cardNum){
        card_active.put(cardNum, false);
    }

    public void payOrder(Integer acc_id, Integer amount){
        account_sum.put(acc_id, account_sum.get(acc_id) - amount);
    }

    public void switchToAccount(Integer acc1_id, Integer acc2_id, Integer amount){
        account_sum.put(acc1_id, account_sum.get(acc1_id) - amount);
        account_sum.put(acc2_id, account_sum.get(acc2_id) + amount);
    }

    public void cancelAccount(Integer acc_id){
        blockCard(account_card.get(acc_id));
        account_client.remove(acc_id);
        account_sum.remove(acc_id);
        account_card.remove(acc_id);
    }

    public void checkCredit(Integer acc_id){
        if(account_sum.get(acc_id) < -1000000){
            blockCard(account_card.get(acc_id));
        }
    }

    @Override
    public String toString() {
        return "Bank{" +
                "account_client=" + account_client +
                "\n   account_sum=" + account_sum +
                "\n   account_card=" + account_card +
                "\n   card_active=" + card_active +
                '}';
    }
}
