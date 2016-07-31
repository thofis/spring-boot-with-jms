package de.medianox.springbootjms;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.jms.annotation.EnableJms;
import org.springframework.jms.config.JmsListenerContainerFactory;
import org.springframework.jms.config.SimpleJmsListenerContainerFactory;
import org.springframework.jms.support.converter.MessageConverter;
import org.springframework.jms.support.converter.SimpleMessageConverter;
import org.springframework.scheduling.annotation.EnableScheduling;

import javax.jms.ConnectionFactory;

@SpringBootApplication
@EnableJms
@EnableScheduling
public class Application  {

    final static String SENDER_PROFILE = "sender";
    final static String RECEIVER_PROFILE = "receiver";

    @Bean // Strictly speaking this bean is not necessary as boot creates a default
    JmsListenerContainerFactory<?> myJmsContainerFactory(ConnectionFactory connectionFactory) {
        SimpleJmsListenerContainerFactory factory = new SimpleJmsListenerContainerFactory();
        factory.setConnectionFactory(connectionFactory);
        return factory;
    }
    public static void main(String[] args) {
        // Clean out any ActiveMQ data from a previous run
        //FileSystemUtils.deleteRecursively(new File("activemq-data"));

        // Launch the application
        SpringApplication.run(Application.class, args);
    }

    @Bean
    SimpleMessageConverter simpleMessageConverter() {
        return new SimpleMessageConverter();
    }

}