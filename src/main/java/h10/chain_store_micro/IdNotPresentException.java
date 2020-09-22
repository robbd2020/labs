package h10.chain_store_micro;

public class IdNotPresentException extends Exception {
    public IdNotPresentException(String msg) {
        super(msg);
    }
}
