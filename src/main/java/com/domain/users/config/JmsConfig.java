package com.domain.users.config;

import javax.jms.ConnectionFactory;

import com.domain.users.listeners.FirstMessageListener;

import org.apache.activemq.ActiveMQConnectionFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.jms.DefaultJmsListenerContainerFactoryConfigurer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jms.annotation.EnableJms;
import org.springframework.jms.config.DefaultJmsListenerContainerFactory;
import org.springframework.jms.config.JmsListenerContainerFactory;
import org.springframework.jms.config.SimpleJmsListenerContainerFactory;
import org.springframework.jms.config.SimpleJmsListenerEndpoint;
import org.springframework.jms.connection.CachingConnectionFactory;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.jms.listener.DefaultMessageListenerContainer;
import org.springframework.jms.listener.SimpleMessageListenerContainer;

@Configuration
public class JmsConfig {

    //@Value("${activemq.broker-url}")
    private String brokerUrl = "tcp://localhost:61616";

    //@Value("${activemq.broker-user}")
    private String brokerUser = "admin";

    //@Value("${activemq.broker-pssw}")
    private String brokerPssw = "admin";

    //@Value("${destination.first}")
    private String firstDestination = "prima-destinazione";

	
	//@Bean
	public ActiveMQConnectionFactory firstConnectionFactory(){
        ActiveMQConnectionFactory connectionFactory = new ActiveMQConnectionFactory();
        try{
            connectionFactory.setBrokerURL(brokerUrl);
            connectionFactory.setPassword(brokerUser);
            connectionFactory.setUserName(brokerPssw);
        }catch(Exception e)   {
            ;
        }
        
	    
	    return connectionFactory;
	}

    //@Bean
    public CachingConnectionFactory cachingConnectionFactory() {
        return new CachingConnectionFactory(firstConnectionFactory());
    }

	//@Bean
	//public JmsTemplate jmsTemplate(){
	//    JmsTemplate template = new JmsTemplate();
	//    template.setConnectionFactory(firstConnectionFactory());
	//    return template;
	//}

    //@Bean
    public JmsTemplate orderJmsTemplate() {
        JmsTemplate jmsTemplate = new JmsTemplate(cachingConnectionFactory());
        jmsTemplate.setDefaultDestinationName(firstDestination);

        return jmsTemplate;
    }

	//@Bean
	public DefaultJmsListenerContainerFactory firstDefaultJmsListenerContainerFactory() {
	    DefaultJmsListenerContainerFactory factory = new DefaultJmsListenerContainerFactory();
	    factory.setConnectionFactory(firstConnectionFactory());
        factory.setConcurrency("1-1");
        //factory.setConcurrency("3-10");
	    return factory;
    }
    

    //@Bean
    public SimpleJmsListenerContainerFactory firstSimpleJmsListenerContainerFactory() {
      SimpleJmsListenerContainerFactory factory = new SimpleJmsListenerContainerFactory();
      factory.setConnectionFactory(firstConnectionFactory());
  
      return factory;
    }
  
    //@Bean
    public DefaultMessageListenerContainer firstDefaultMessageListenerContainer() {
      SimpleJmsListenerEndpoint endpoint = new SimpleJmsListenerEndpoint();
      endpoint.setMessageListener(new FirstMessageListener("DMLC"));
      endpoint.setDestination(firstDestination);
  
      return firstDefaultJmsListenerContainerFactory().createListenerContainer(endpoint);
    }
  
    //@Bean
    public SimpleMessageListenerContainer firstSimpleMessageListenerContainer() {
      SimpleJmsListenerEndpoint endpoint = new SimpleJmsListenerEndpoint();
      endpoint.setMessageListener(new FirstMessageListener("SLC"));
      endpoint.setDestination(firstDestination);
  
      return firstSimpleJmsListenerContainerFactory().createListenerContainer(endpoint);
    }

    @Bean
    public JmsListenerContainerFactory<?> firstJmsListenerContainerFactory(
        ConnectionFactory connectionFactory,
        DefaultJmsListenerContainerFactoryConfigurer configurer
    ) {
        DefaultJmsListenerContainerFactory factory = new DefaultJmsListenerContainerFactory();
        configurer.configure(factory, connectionFactory);
	    
	    return factory;
    }


    



}