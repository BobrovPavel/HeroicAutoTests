import com.sun.mail.pop3.POP3SSLStore;

import javax.mail.*;
import javax.mail.internet.ContentType;
import javax.mail.internet.MimeMultipart;
import javax.mail.internet.ParseException;
import javax.naming.spi.DirStateFactory;
import java.io.IOException;
import java.lang.reflect.Array;
import java.util.*;

public class GetPOPMails {

    private static final String MAIL_POP_HOST = "pop.gmail.com";
    private static final String MAIL_STORE_TYPE = "pop3";
    private static final String POP_USER = "raindropslolz@gmail.com";
    private static final String POP_PASSWORD = "TARGETstart113";
    private static final String POP_PORT = "995";
    private static Message body;

    private static String getTextFromMessage(Message message) throws MessagingException, IOException {
        String result = "";
        if (message.isMimeType("text/plain")) {
            result = message.getContent().toString();
        } else if (message.isMimeType("multipart/*")) {
            MimeMultipart mimeMultipart = (MimeMultipart) message.getContent();
            result = getTextFromMimeMultipart(mimeMultipart);
        }
        return result;
    }

    private static String getTextFromMimeMultipart(MimeMultipart mimeMultipart)  throws MessagingException, IOException {
        String result = "";
        int count = mimeMultipart.getCount();
        for (int i = 0; i < count; i++) {
            BodyPart bodyPart = mimeMultipart.getBodyPart(i);
            if (bodyPart.isMimeType("text/plain")) {
                result = result + "\n" + bodyPart.getContent();
                break; // without break same text appears twice in my tests
            } else if (bodyPart.isMimeType("text/html")) {
                String html = (String) bodyPart.getContent();
                result = result + "\n" + org.jsoup.Jsoup.parse(html).text();
            } else if (bodyPart.getContent() instanceof MimeMultipart){
                result = result + getTextFromMimeMultipart((MimeMultipart)bodyPart.getContent());
            }
        }
        return result;
    }

    public static void getMails(String user,String password) {
        try {

            // create properties field
            Properties properties = new Properties();
            properties.put("mail.pop3.host", MAIL_POP_HOST);
            properties.put("mail.pop3.port", POP_PORT);
            properties.put("mail.pop3.starttls.enable", "true");
            properties.put("mail.pop3.socketFactory.class" , "javax.net.ssl.SSLSocketFactory" );
            //Session emailSession = Session.getDefaultInstance(properties);
            Session emailSession = Session.getDefaultInstance(properties , new Authenticator() {
                @Override
                protected PasswordAuthentication getPasswordAuthentication() {
                    return new PasswordAuthentication( POP_USER , POP_PASSWORD);
                }
            });
            // create the POP3 store object and connect with the pop server
            Store store = emailSession.getStore(MAIL_STORE_TYPE);

            store.connect(MAIL_POP_HOST, user, password);

            // create the folder object and open it
            Folder emailFolder = store.getFolder("INBOX");
            emailFolder.open(Folder.READ_ONLY);

            // retrieve the messages from the folder in an array and print it
            List<Message> messageList = new ArrayList<>();
            messageList = Arrays.asList(emailFolder.getMessages());
//            Message[] messages = emailFolder.getMessages();
            System.out.println("messages.length---" + messageList.size());

            for (int i = 0, n = messageList.size(); i < n; i++) {
                Message message = messageList.get(i);
                System.out.println("---------------------------------");
                System.out.println("Email Number " + (i + 1));
                System.out.println("Subject: " + message.getSubject());
                System.out.println("From: " + message.getFrom()[0]);
                System.out.println("Body: " + message.getContent());
                body = messageList.get(0);
                System.out.println(getTextFromMessage(body));
            }

            // close the store and folder objects
            emailFolder.close(false);
            store.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    public static void main(String[] args) throws IOException, MessagingException {
        getMails(POP_USER, POP_PASSWORD);
    }
}
