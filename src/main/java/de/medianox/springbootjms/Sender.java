package de.medianox.springbootjms;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Profile;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.jms.core.MessageCreator;
import org.springframework.jms.support.converter.SimpleMessageConverter;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.Session;

/**
 * Created by tom on 31.07.16.
 */

@Component
@Profile(Application.SENDER_PROFILE)
public class Sender {

    @Autowired
    JmsTemplate jmsTemplate;

    @Autowired
    SimpleMessageConverter simpleMessageConverter;

    @Scheduled(fixedRateString = "${send.rate}")
    public void send() {
        System.out.println("Sending a new message...");
        //jmsTemplate.send("mailbox-destination", session -> session.createTextMessage("ping!"));
        jmsTemplate.send("mailbox-destination", (Session session) -> simpleMessageConverter.toMessage(new MyMessage("Thofis", "Here it comes."), session));

//        jmsTemplate.send("mailbox-destination", new MessageCreator() {
//            @Override
//            public Message createMessage(Session session) throws JMSException {
//                return simpleMessageConverter.toMessage(new MyMessage("Thofis", "Here it comes."), session);
//            }
//        });
    }

}
