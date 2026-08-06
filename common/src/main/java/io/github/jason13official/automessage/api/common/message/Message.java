package io.github.jason13official.automessage.api.common.message;

public class Message {

    public String identifier;

    public MessageSchedule schedule;
    public MessageType type;

    public boolean repeats;
    public boolean pack_intro;

    public String link;
    public String text;

    public static Message defaultFallback() {

        Message message = new Message();

        message.identifier = "default_message";

        message.schedule = MessageSchedule.ON_FIRST_JOIN;
        message.type = MessageType.CHAT;
        
        message.repeats = true;
        message.pack_intro = false;

        message.link = "https://www.google.com";
        message.text = "Default (with link): Welcome to AutoMessage, %player%!";

        return message;
    }
}
