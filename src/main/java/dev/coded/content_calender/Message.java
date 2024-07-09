package dev.coded.content_calender;

import org.springframework.stereotype.Component;

@Component
public class Message {
    String k ="kettle";

   public String getMessage() {
       return " Hello World!";
   }


    public String myMessage() {
        getMessage();
        sendMessage("Tom");
        return " Money!";
    }
    public String sendMessage(String towncrier) {
        return " Tomorrow!";
    }
}
