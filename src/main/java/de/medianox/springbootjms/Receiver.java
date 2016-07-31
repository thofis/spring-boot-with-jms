package de.medianox.springbootjms;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Profile;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.jms.support.converter.SimpleMessageConverter;
import org.springframework.stereotype.Component;

import javax.jms.JMSException;
import javax.jms.Message;
import java.io.Serializable;

@Component
@Profile(Application.RECEIVER_PROFILE)
public class Receiver {

    @Value("${processing.time}")
    int processingTime;

    @Autowired
    SimpleMessageConverter simpleMessageConverter;

    /**
     * When you receive a message, print it out, then shut down the application.
     * Finally, clean up any ActiveMQ server stuff.
     */
//    @JmsListener(destination = "mailbox-destination", containerFactory = "myJmsContainerFactory")
//    public void receiveMessage(String message) {
//        System.out.println("Received <" + message + ">");
//        try {
//            Thread.sleep(processingTime);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
//        //FileSystemUtils.deleteRecursively(new File("activemq-data"));
//    }

    @JmsListener(destination = "mailbox-destination", containerFactory = "myJmsContainerFactory")
    public void receiveMessage(Message message) throws JMSException {
        MyMessage myMessage = (MyMessage)simpleMessageConverter.fromMessage(message);
        System.out.println("Received <" + myMessage + ">");
        try {
            Thread.sleep(processingTime);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        //FileSystemUtils.deleteRecursively(new File("activemq-data"));
    }
}