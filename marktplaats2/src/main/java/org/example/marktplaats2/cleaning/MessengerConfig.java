package org.example.marktplaats2.cleaning;

import javax.annotation.Resource;
import javax.enterprise.inject.Produces;
import javax.jms.JMSDestinationDefinition;
import javax.jms.Queue;

@JMSDestinationDefinition( // lookup the queue, defined in server.xml
        name = "java:app/cleaningQueue", // JNDI name of the destination resource being defined.
        interfaceName = "javax.jms.Queue",
        destinationName = "cleaningQueue")
public class MessengerConfig {

    @Resource(lookup = "java:app/cleaningQueue") // the JNDI name from JMSDestinationDefinition
    private Queue cleaningQueue;

    @Produces
    public Queue cleaningQueue() {
        return cleaningQueue;
    }

}

