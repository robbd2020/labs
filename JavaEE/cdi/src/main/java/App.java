import org.jboss.weld.environment.se.Weld;
import org.jboss.weld.environment.se.WeldContainer;

public class App {

    public static void main(String[] args) {

        Weld weld = new Weld();
        WeldContainer container = weld.initialize();

        // GreeterService greeterService = new GreeterService(new Greeting());// DIY DI
        // GreeterService greeterService = new GreeterService(); // object managed by myself instead of CDI (i.e. DI container)
        GreeterService greeterService = container.select(GreeterService.class).get(); // object managed by CDI (i.e. DI container)
        String s = greeterService.saySomething();
        System.out.println(s);

        GreeterService greeterService2 = new GreeterService(new GreetingNL());
        String s2 = greeterService2.saySomething();
        System.out.println(s2);

        container.close();
    }

}