package h10.chain_store_micro;

public class RegularCard extends Card {

    public RegularCard(int id, String name, double credit) {
        super(id, name, credit);
    }

    @Override
    public boolean pay(double amount) {
        if (amount <= super.credit) {
            super.credit -= amount;
            return true;
        }
        return false;
    }

    @Override
    public String toString(){
        return String.format("%10d %20s %20s", getCardId(), getName(), getCredit());
    }
}
