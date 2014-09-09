package controllers;

import models.MessageStore;

public class HelloWorldAction {

    private static final long serialVersionUID = 1L;

    private MessageStore messageStore;

    public String execute() throws Exception {

        messageStore = new MessageStore();
        return "ejecutar mensaje";
    }

    public MessageStore getMessageStore() {
        return messageStore;
    }

    public void setMessageStore(MessageStore messageStore) {
        this.messageStore = messageStore;
    }

}
