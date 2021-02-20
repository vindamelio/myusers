package com.domain.users.listeners;

import java.util.Map;

import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.TextMessage;

import com.domain.users.components.SettaStringa;
import com.google.gson.Gson;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Component;

@Component
public class FirstListener {

	@Autowired
	private SettaStringa settaStringa;

	//@Value("${destination.first}")
	private String firstDestination = "prima-destinazione";

	private Integer count = 0;
	

	@JmsListener(destination = "prima-destinazione", containerFactory = "firstJmsListenerContainerFactory")
	public void receiveMessage(final Message jsonMessage) throws JMSException {
		String messageData = null;
		//System.out.println("FirstListener Received message " + jsonMessage);
		
		if(jsonMessage instanceof TextMessage) {
			TextMessage textMessage = (TextMessage)jsonMessage;
			messageData = textMessage.getText();
			//Map map = new Gson().fromJson(messageData, Map.class);
			//response  = "Hello " + map.get("name");
			
			count++;
			//settaStringa.setCount(count);
			settaStringa.addCount();

			System.out.println("FirstListener Received message messageData" + messageData);
			System.out.println("FirstListener this count " + count + ", that stringa " + settaStringa.getStringa());
		}else{
			System.out.println("FirstListener Received message not TextMessage");
		}	
		
	}

}