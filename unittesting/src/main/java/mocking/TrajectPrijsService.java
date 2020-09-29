package mocking;

public class TrajectPrijsService {
    TrajectNaarTrajectEenhedenService trajectNaarTrajectEenhedenService;
    TrajectEenhedenNaarPrijsService trajectEenhedenNaarPrijsService;
    Reader reader;

    int getTrajectPrijsFromTerminal() throws InvalidLocationException {
        return getTrajectPrijs(getScannerWrapper().scanLocatie(true), getScannerWrapper().scanLocatie(false));
    }

    int getTrajectPrijs(String from, String to) throws InvalidLocationException {
        int a = getTrajectNaarTrajectEenhedenService().getTrajectEenheden(from, to);
        int b = getTrajectEenhedenNaarPrijsService().getPriceTrajectEenheden(a);
        return a * b;
    }

    public TrajectNaarTrajectEenhedenService getTrajectNaarTrajectEenhedenService() {
        return trajectNaarTrajectEenhedenService;
    }

    public void setTrajectNaarTrajectEenhedenService(TrajectNaarTrajectEenhedenService trajectNaarTrajectEenhedenService) {
        this.trajectNaarTrajectEenhedenService = trajectNaarTrajectEenhedenService;
    }

    public TrajectEenhedenNaarPrijsService getTrajectEenhedenNaarPrijsService() {
        return trajectEenhedenNaarPrijsService;
    }

    public void setTrajectEenhedenNaarPrijsService(TrajectEenhedenNaarPrijsService trajectEenhedenNaarPrijsService) {
        this.trajectEenhedenNaarPrijsService = trajectEenhedenNaarPrijsService;
    }

    public Reader getScannerWrapper() {
        return reader;
    }

    public void setScannerWrapper(Reader reader) {
        this.reader = reader;
    }
}
