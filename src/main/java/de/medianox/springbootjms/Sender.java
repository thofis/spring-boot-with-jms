package de.medianox.springbootjms;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.jms.core.MessageCreator;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.Session;

/**
 * Created by tom on 31.07.16.
 */

@Component
public class Sender {

    @Autowired
    JmsTemplate jmsTemplate;

    @Scheduled(fixedRate = 1000)
    public void send() {
        System.out.println("Sending a new message...");
        jmsTemplate.send("mailbox-destination", session -> session.createTextMessage("ping!"));
    }

}
