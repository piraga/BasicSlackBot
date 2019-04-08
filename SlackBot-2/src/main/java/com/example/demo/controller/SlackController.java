package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Profile;
import org.springframework.web.socket.WebSocketSession;

import me.ramswaroop.jbot.core.common.Controller;
import me.ramswaroop.jbot.core.common.EventType;
import me.ramswaroop.jbot.core.common.JBot;
import me.ramswaroop.jbot.core.slack.Bot;
import me.ramswaroop.jbot.core.slack.models.Event;



@JBot
@Profile("slack")
public class SlackController extends Bot {
	
	
	@Value("${slackBotToken}")
	public String token;

	@Override
	public Bot getSlackBot() {
		// TODO Auto-generated method stub
		System.out.println("Called slackBot method");
		return this;
	}

	@Override
	public String getSlackToken() {
		// TODO Auto-generated method stub
		
		System.out.println("Called token method");
		return token;
	}
	
    @Controller(events = {EventType.DIRECT_MENTION, EventType.DIRECT_MESSAGE}, pattern = "helo" , next= "confirmTiming")
    public void onReceiveDM(WebSocketSession session, Event event) {
//    	startConversation(event, "confirmTiming"); 
    	System.out.println(event.getText()+"  "+event.getUserId());
    	System.out.println(event.getUser());
        reply(session, event, "Hi, I am " + slackService.getCurrentUser().getName());
        reply(session, event, "Hi, I am " + slackService.getCurrentUser().getName());
        reply(session, event, "Hi, I am " + slackService.getCurrentUser().getName());
        
//        System.out.println(slackService.);

    }
    
//    @Controller(pattern = "(setup meeting)", next = "confirmTiming")
//    public void setupMeeting(WebSocketSession session, Event event) {
//        startConversation(event, "confirmTiming");   // start conversation
//        reply(session, event, "Cool! At what time (ex. 15:30) do you want me to set up the meeting?");
//    }

}
