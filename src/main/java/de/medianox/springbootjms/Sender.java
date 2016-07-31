package de.medianox.springbootjms;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Profile;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

/**
 * Created by tom on 31.07.16.
 */

@Component
@Profile(Application.SENDER_PROFILE)
public class Sender {

    @Autowired
    JmsTemplate jmsTemplate;

    @Scheduled(fixedRateString = "${send.rate}")
    public void send() {
        System.out.println("Sending a new message...");
        jmsTemplate.send("mailbox-destination", session -> session.createTextMessage("ping!"));
    }

}
