package h10.chain_store_micro;

public abstract class Card {

    final int cardId;
    String name;
    String address;
    String city;
    double credit;

    //-- Constructor

    public Card(int id, String name, double credit) {
        this.cardId = id;
        setCredit(credit);
        setName(name);
    }

    public String getName() {
        return name;
    }

    public double getCredit() {
        return credit;
    }

    public int getCardId() {
        return cardId;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setCredit(double credit) {
        this.credit = credit;
    }

    public abstract boolean pay(double amount);

}
