package es.heliosspain.against.covid19.service.messaging;


public interface HelloSendMessageService {

    /**
     * Method that sends a message.
     */
    void sendHelloMessage();

    /**
     * Method that sends a message and waits for its reply
     * @return Reply
     */
    String sendAndReceiveHelloMessage();

    void sendMessages();
}
