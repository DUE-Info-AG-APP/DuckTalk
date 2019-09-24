package com.infoag.ducktalk.models;

public class Message {
    private String sender;
    private String recipient;
    private String timestamp;
    private String data;

    public Message(String sender, String recipient, String timestamp, String data) {
        this.sender = sender;
        this.recipient = recipient;
        this.timestamp = timestamp;
        this.data = data;
    }

    public String getSender() {
        return sender;
    }

    public String getRecipient() {
        return recipient;
    }

    public String getTimestamp() {
        return timestamp;
    }

    public String getData() {
        return data;
    }
}
