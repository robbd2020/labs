package mocking;

public interface TrajectNaarTrajectEenhedenService {
    int getTrajectEenheden(String from, String to) throws InvalidLocationException;
}
