package es.heliosspain.against.covid19.service;


public interface EmailService {

    /**
     * Method that gets the mail example configuration and sends an email
     */
    void sendExampleEmail();

    /**
     * Method that sends an HTML formatted email
     *
     * @param subject Subject of the email
     * @param from Address of the sender
     * @param to String[] containing the receivers of the email
     * @param body Body, in HTML format, of the email.
     */
    void sendHTMLEmail(String subject, String from, String[] to, String body);
}
