import javax.enterprise.inject.Alternative;

@Alternative
public class GreetingNL implements Greetable {

    public String greet() {
        return "Hallo wereld!";
    }

}
