package org.example.marktplaats2.cleaning;

import javax.ejb.ActivationConfigProperty;
import javax.ejb.MessageDriven;
import javax.inject.Inject;
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageListener;

@MessageDriven(
        name = "ConsumerMDB",
        activationConfig = {
                @ActivationConfigProperty(propertyName = "destinationType", propertyValue = "javax.jms.Queue"),
                @ActivationConfigProperty(propertyName = "destination", propertyValue = "java:app/cleaningQueue")
        }
)
public class BerichtConsument implements MessageListener {

    @Inject
    private BerichtAfhandelaarI handler;

    @Override
    public void onMessage(Message message) {
        try {
            String m = message.getBody(String.class);
            System.out.println("Message received: " + m);
            handler.verwerkBericht(m);
        } catch (JMSException ex) {
            throw new RuntimeException(ex);
        }
    }
}

