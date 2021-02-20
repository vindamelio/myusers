package com.domain.users.listeners;

import java.util.Map;

import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageListener;
import javax.jms.TextMessage;

import com.google.gson.Gson;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.messaging.handler.annotation.SendTo;

import org.springframework.stereotype.Component;

//@Component
public class FirstMessageListener implements MessageListener{
	
    private String id;
    private Integer count = 0;

	public FirstMessageListener(String id) {
        super();
        this.id = id;
      }
    
      @Override
      public void onMessage(Message message) {
        if (message instanceof TextMessage) {
          try {
            String text = ((TextMessage) message).getText();
            System.out.println("FirstMessageListener Received message " + text);
            count++;
          } catch (JMSException e) {
            System.out.println("FirstMessageListener error " + e.getMessage());
          }
        } else {
            System.out.println("FirstMessageListener not TextMessage " );
        }
      }
    
      
      public String getId() {
        return this.id;
      }


      public Integer getCount() {
        return this.count;
      }

}