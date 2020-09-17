package h7;

public class PersonDiedException extends Throwable {
    String message = "Harstikke dood!";

    @Override
    public String getMessage() {
        return message;
    }
}
