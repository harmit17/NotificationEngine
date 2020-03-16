package com.finablr.platform.notification.jmsconfiguration;

import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.ObjectMessage;
import javax.jms.Session;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.jms.core.MessageCreator;
import org.springframework.stereotype.Component;

import com.finablr.platform.notification.domain.NotificationRequest;

@Component
public class MessageSender {

	@Autowired
	JmsTemplate jmsTemplate;
	
	public void sendMessage(final NotificationRequest notificationRequest)
	{
		jmsTemplate.send(new MessageCreator() {
			
			@Override
			public Message createMessage(Session session) throws JMSException {
				
				ObjectMessage objectmessage = session.createObjectMessage(notificationRequest);
				return objectmessage;
			}
		});
	}
}
