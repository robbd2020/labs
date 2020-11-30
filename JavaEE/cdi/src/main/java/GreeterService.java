import org.slf4j.Logger;

import javax.inject.Inject;

public class GreeterService {

    @Inject
    private Logger log;

    @Inject
    private Greetable greeting = null; // talk to an interface, not an implementation

    public GreeterService(Greetable greeting) {
        this.greeting = greeting;
    }

    public GreeterService() { }

    public String saySomething() {
        log.debug("saySomething");
        return greeting.greet();
    }

    public void setGreeting(Greetable greeting) {
        this.greeting = greeting;
    }
}

