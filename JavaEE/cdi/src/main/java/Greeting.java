import javax.enterprise.inject.Default;

@Default
public class Greeting implements Greetable {

    public String greet() {
        return "Hello world!";
    }

}

