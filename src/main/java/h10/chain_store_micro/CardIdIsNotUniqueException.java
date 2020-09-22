package h10.chain_store_micro;

public class CardIdIsNotUniqueException extends Exception {
    public CardIdIsNotUniqueException(String msg) {
        super(msg);
    }
}
