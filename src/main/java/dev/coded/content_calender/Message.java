package dev.coded.content_calender;

import org.springframework.stereotype.Component;

@Component
public class Message {
    String k ="keyword";

   public String getMessage() {
       return " Spirit of the deep!";
   }


    public String myMessage() {
        getMessage();
        sendMessage("Ann");
        return " The Best Software Engineer!";
    }
    public String sendMessage(String towncrier) {
        return " The Future is Now!";
    }
}
