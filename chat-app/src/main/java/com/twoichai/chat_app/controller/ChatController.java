package com.twoichai.chat_app.controller;

import com.twoichai.chat_app.model.ChatMessage;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.messaging.simp.SimpMessageHeaderAccessor;
import org.springframework.stereotype.Controller;

@Controller
public class ChatController {

    @MessageMapping("/chat.sendMessage")
    @SendTo("/topic/public")
    public ChatMessage sendMessage(
            @Payload ChatMessage chatMessage
    ){
        return chatMessage;
    }

    // Allows to establish connection between a joined user and webSocket
    @MessageMapping("/chat.addUser")
    @SendTo("/topic/public")
    public ChatMessage addUser (
            @Payload ChatMessage chatMessage,
            // used to manipulate the websocket message headers, specifically to add attributes to the
            // webSocket session
            SimpMessageHeaderAccessor headerAccessor
    ) {
        // Add username in webSocket session
        headerAccessor.getSessionAttributes().put("username", chatMessage.getSender());
        return chatMessage;
    }
}
