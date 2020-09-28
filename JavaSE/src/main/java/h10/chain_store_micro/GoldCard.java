package h10.chain_store_micro;

public class GoldCard extends Card {

    int discount;

    public GoldCard(int id, String name, double credit, int discount) throws ArgumentOutOfRangeException {
        super(id, name, credit);
        setDiscount(discount);

    }

    public int getDiscount() {
        return discount;
    }

    public void setDiscount(int discount) throws ArgumentOutOfRangeException {
        if ((discount < 1) || (discount > 30))
            throw new ArgumentOutOfRangeException("Discount moet tussen 1 en 30 zijn!");
        this.discount = discount;
    }

    @Override
    public boolean pay(double amount) {
        double discountfactor = (double) (100 - getDiscount()) / 100;
        super.credit -= amount * discountfactor;
        return false;
    }

    @Override
    public String toString() {
        return String.format("%10d %20s %20s %10d", getCardId(), getName(), getCredit(), getDiscount());
    }
}
