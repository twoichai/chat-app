package com.twoichai.chat_app.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.twoichai.chat_app.model.enums.MessageType;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ChatMessage {

    private String content;
    private String sender;
    private MessageType type;
}
