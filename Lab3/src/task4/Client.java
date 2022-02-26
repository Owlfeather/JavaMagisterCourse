package task4;

/*
Система Платежи. Клиент имеет Счет в банке и Кредитную Карту (КК).
Клиент может оплатить Заказ, сделать платеж на другой Счет, заблокировать КК и аннулировать Счет.
Администратор может заблокировать КК за превышение кредита.
 */

import java.util.Objects;

public class Client {

    private String name;
    private int id;

    public Client() {
    }

    public Client(String name, int id) {
        this.name = name;
        this.id = id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Client client = (Client) o;
        return id == client.id && Objects.equals(name, client.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, id);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Client{" +
                "name='" + name + '\'' +
                ", id=" + id +
                '}';
    }
}
