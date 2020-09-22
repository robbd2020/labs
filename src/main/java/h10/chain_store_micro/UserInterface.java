package h10.chain_store_micro;


import java.util.HashMap;
import java.util.Map;
import java.util.NoSuchElementException;

public class UserInterface {

    private Map<Integer, Card> cardMap = new HashMap<>();

    public Map<Integer, Card> getCardMap() {
        return cardMap;
    }

    public void addClient(Card CardToAdd) throws CardIdIsNotUniqueException {
        if (getCardMap().containsKey(CardToAdd.getCardId())) throw new CardIdIsNotUniqueException(
                "The card ID is not unique. This card can't be added");
        cardMap.put(CardToAdd.getCardId(), CardToAdd);
    }

    public void showAllCustomers() {
        System.out.printf("%10s %20s %20s %10s\n" +
                "----------------------------------------------------------------\n",
                "Card Id", "Name", "Credit balance", "Discount");
        getCardMap().forEach((key, value) -> System.out.println(value.toString()));
        System.out.println();
    }

    public Card findCustomerById(int id) throws IdNotPresentException {
        if (cardMap.containsKey(id)) return cardMap.get(id);
        else throw new IdNotPresentException("ID is not known");
    }

    public void newPayment(int customerNumber, double amount) throws IdNotPresentException {
        Card card;
            card = findCustomerById(customerNumber);
            card.pay(amount);

    }
}
