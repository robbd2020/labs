package org.example.marktplaats2.cleaning;

import javax.ejb.Schedule;
import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.jms.DeliveryMode;
import javax.jms.JMSContext;
import javax.jms.JMSProducer;
import javax.jms.Queue;

import static org.example.marktplaats2.util.DateUtils.TWENTY_THREE_HOURS_IN_MS;

@Stateless
public class Producer {

    @Inject // produced by MessengerConfig
    private Queue queue;

    @Inject
    private JMSContext context;

    @Schedule(hour = "*", minute = "*", second = "10", persistent = false)
    public void stuurOudeAdvertentiesOpschonenStartenBericht() {
        String message = "productlijstopruimen+";
        verstuurBericht(message);
    }

    public void stuurProductVerwijderBericht(long id) {
        String message = "productverwijderen+" + id;
        verstuurBericht(message);
    }

    public void verstuurBericht(String bericht) {
        System.out.println("Ga nu dit bericht sturen: " + bericht);
        JMSProducer producer = context.createProducer();
        producer.setDeliveryMode(DeliveryMode.NON_PERSISTENT);
        producer.setTimeToLive(TWENTY_THREE_HOURS_IN_MS);  //Bericht leeft 23 uur
        producer.send(queue, bericht);
    }
}
