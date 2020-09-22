package h10.chain_store_micro;

public class Start {
    public static void main(String[] args) throws ArgumentOutOfRangeException, IdNotPresentException {
        UserInterface ui = new UserInterface();
        GoldCard gc1 = new GoldCard(1, "Piet", 100d, 25);
        RegularCard rc1 = new RegularCard(2, "Jan", 1000d);
        GoldCard gc2 = new GoldCard(3 , "Truus", 750d,10);
        RegularCard rc2 = new RegularCard(9,"Evelien", 15);
        try {
            ui.addClient(gc1);
            ui.addClient(rc1);
            ui.addClient(gc2);
            ui.addClient(rc2);
        } catch (CardIdIsNotUniqueException e) {
            e.printStackTrace();
        }

        ui.showAllCustomers();

        ui.newPayment(2,33.33);
        ui.newPayment(3,100);
        ui.showAllCustomers();
    }

}
