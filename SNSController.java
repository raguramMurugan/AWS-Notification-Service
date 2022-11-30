package com.hubino.sns.configuration.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.amazonaws.services.sns.AmazonSNSClient;
import com.amazonaws.services.sns.model.MessageAttributeValue;
import com.amazonaws.services.sns.model.PublishRequest;
import com.amazonaws.services.sns.model.SubscribeRequest;

@RestController
public class SNSController {
	
	@Autowired
	private AmazonSNSClient snsclient;
	
	private String TOPICArn="arn:aws:sns:ap-northeast-1:021734146617:Notification-To-Sumi";
	
	@GetMapping("/Subscription/{email}")
	public String addSubscription(@PathVariable(value = "email") String email)
	{
		SubscribeRequest request=new SubscribeRequest(TOPICArn, "email",email);
		snsclient.subscribe(request);
		return "Subcription Request Sent.";
	}
	@GetMapping("/addNotifcation/{message}")
	public String addNotification(@PathVariable(value = "message") String message)
	{
		
		PublishRequest publish=new PublishRequest(TOPICArn,message);
		publish.setMessage(message);
		publish.setTopicArn(TOPICArn);
		snsclient.publish(publish);
		return "Message Sent Successfully";
	}
	

}
